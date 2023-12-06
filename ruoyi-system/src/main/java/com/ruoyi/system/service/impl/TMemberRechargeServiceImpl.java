package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.mapper.TBalanceMapper;
import com.ruoyi.system.mapper.TBalanceRecordMapper;
import com.ruoyi.system.mapper.TMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberRechargeMapper;
import com.ruoyi.system.domain.TMemberRecharge;
import com.ruoyi.system.service.ITMemberRechargeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员充值Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TMemberRechargeServiceImpl implements ITMemberRechargeService 
{
    @Autowired
    private TMemberRechargeMapper tMemberRechargeMapper;

    /**
     * 查询会员充值
     * 
     * @param id 会员充值主键
     * @return 会员充值
     */
    @Override
    public TMemberRecharge selectTMemberRechargeById(Long id)
    {
        return tMemberRechargeMapper.selectTMemberRechargeById(id);
    }
    @Value("${img.path-suffix}")
    private String IMG_PATH;
    /**
     * 查询会员充值列表
     * 
     * @param tMemberRecharge 会员充值
     * @return 会员充值
     */
    @Override
    public List<TMemberRecharge> selectTMemberRechargeList(TMemberRecharge tMemberRecharge)
    {
        List<TMemberRecharge> list = tMemberRechargeMapper.selectTMemberRechargeList(tMemberRecharge);
        for (TMemberRecharge recharge : list) {
            recharge.setPaymentVoucher(IMG_PATH+recharge.getPaymentVoucher());
        }
        return list;
    }

    /**
     * 新增会员充值
     * 
     * @param tMemberRecharge 会员充值
     * @return 结果
     */
    @Override
    public int insertTMemberRecharge(TMemberRecharge tMemberRecharge)
    {
        tMemberRecharge.setCreateTime(DateUtils.getNowDate());
        return tMemberRechargeMapper.insertTMemberRecharge(tMemberRecharge);
    }

    /**
     * 修改会员充值
     * 
     * @param tMemberRecharge 会员充值
     * @return 结果
     */
    @Override
    public int updateTMemberRecharge(TMemberRecharge tMemberRecharge)
    {
        return tMemberRechargeMapper.updateTMemberRecharge(tMemberRecharge);
    }

    /**
     * 批量删除会员充值
     * 
     * @param ids 需要删除的会员充值主键
     * @return 结果
     */
    @Override
    public int deleteTMemberRechargeByIds(Long[] ids)
    {
        return tMemberRechargeMapper.deleteTMemberRechargeByIds(ids);
    }

    /**
     * 删除会员充值信息
     * 
     * @param id 会员充值主键
     * @return 结果
     */
    @Override
    public int deleteTMemberRechargeById(Long id)
    {
        return tMemberRechargeMapper.deleteTMemberRechargeById(id);
    }

    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Autowired
    private TBalanceMapper tBalanceMapper;
    @Override
    @Transactional
    public AjaxResult rechargeAudit(Integer type, Long id) {
        TMemberRecharge recharge = tMemberRechargeMapper.selectTMemberRechargeById(id);
        if (recharge.getStatus() != 1){
            return AjaxResult.error("订单已处理，请勿重复操作");
        }
        if (type == 1){
            TBalance balance=tBalanceMapper.findBalanceByUserId(recharge.getMemberId(),recharge.getCurrency());
            if (balance!=null){
                balance.setAssetsBalance(balance.getAssetsBalance().add(recharge.getAmount()));
                balance.setUpdateTime(new Date());
                tBalanceMapper.updateTBalance(balance);
            }
            TBalanceRecord tBalanceRecord = new TBalanceRecord();
            tBalanceRecord.setMemberId(recharge.getMemberId());
            tBalanceRecord.setCurrency(recharge.getCurrency());
            tBalanceRecord.setBalanceDifference(recharge.getAmount());
            tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(recharge.getMemberId(),"USDT"));
            recharge.setStatus(2);
            recharge.setRemark("充值已通过");
            recharge.setUpdateTime(DateUtils.getNowDate());
            tMemberRechargeMapper.updateTMemberRecharge(recharge);
            tMemberMapper.addBalanceByUserIdAndBz(recharge.getAmount(),recharge.getMemberId(),recharge.getCurrency());

            tBalanceRecord.setFundsType(2);
            tBalanceRecord.setBalanceType(51);
            tBalanceRecord.setDataClassification(5);
            tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(recharge.getMemberId(),"USDT"));
            tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
            return AjaxResult.success();
        }else if (type == 2){
            recharge.setStatus(3);
            recharge.setRemark("充值已驳回");
            recharge.setUpdateTime(DateUtils.getNowDate());
            tMemberRechargeMapper.updateTMemberRecharge(recharge);
            return AjaxResult.success();
        }
        return AjaxResult.error("系统异常，请重新尝试");
    }
}
