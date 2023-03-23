package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.domain.TMemberRecharge;
import com.ruoyi.system.mapper.TBalanceRecordMapper;
import com.ruoyi.system.mapper.TMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TExtractCoinMapper;
import com.ruoyi.system.domain.TExtractCoin;
import com.ruoyi.system.service.ITExtractCoinService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 提币审核Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TExtractCoinServiceImpl implements ITExtractCoinService 
{
    @Autowired
    private TExtractCoinMapper tExtractCoinMapper;

    /**
     * 查询提币审核
     * 
     * @param id 提币审核主键
     * @return 提币审核
     */
    @Override
    public TExtractCoin selectTExtractCoinById(String id)
    {
        return tExtractCoinMapper.selectTExtractCoinById(id);
    }

    /**
     * 查询提币审核列表
     * 
     * @param tExtractCoin 提币审核
     * @return 提币审核
     */
    @Override
    public List<TExtractCoin> selectTExtractCoinList(TExtractCoin tExtractCoin)
    {
        return tExtractCoinMapper.selectTExtractCoinList(tExtractCoin);
    }

    /**
     * 新增提币审核
     * 
     * @param tExtractCoin 提币审核
     * @return 结果
     */
    @Override
    public int insertTExtractCoin(TExtractCoin tExtractCoin)
    {
        tExtractCoin.setCreateTime(DateUtils.getNowDate());
        return tExtractCoinMapper.insertTExtractCoin(tExtractCoin);
    }

    /**
     * 修改提币审核
     * 
     * @param tExtractCoin 提币审核
     * @return 结果
     */
    @Override
    public int updateTExtractCoin(TExtractCoin tExtractCoin)
    {
        tExtractCoin.setUpdateTime(DateUtils.getNowDate());
        return tExtractCoinMapper.updateTExtractCoin(tExtractCoin);
    }

    /**
     * 批量删除提币审核
     * 
     * @param ids 需要删除的提币审核主键
     * @return 结果
     */
    @Override
    public int deleteTExtractCoinByIds(String[] ids)
    {
        return tExtractCoinMapper.deleteTExtractCoinByIds(ids);
    }

    /**
     * 删除提币审核信息
     * 
     * @param id 提币审核主键
     * @return 结果
     */
    @Override
    public int deleteTExtractCoinById(String id)
    {
        return tExtractCoinMapper.deleteTExtractCoinById(id);
    }
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Override
    @Transactional
    public AjaxResult withdrawAudit(Integer type, String id) {

        TExtractCoin extractCoin = tExtractCoinMapper.selectTExtractCoinById(id);
        if (!extractCoin.getState().equals("CREATE")){
            return AjaxResult.error("订单已处理，请勿重复操作");
        }
        if (type == 1){
            extractCoin.setState("PASS");
            extractCoin.setUpdateTime(DateUtils.getNowDate());
            tExtractCoinMapper.updateTExtractCoin(extractCoin);
            return AjaxResult.success();
        }else if (type == 2){
            TBalanceRecord tBalanceRecord = new TBalanceRecord();
            tBalanceRecord.setMemberId(extractCoin.getMember());
            tBalanceRecord.setCurrency(extractCoin.getCurrency());
            tBalanceRecord.setBalanceDifference(extractCoin.getBalance().add(extractCoin.getHandlingFee()));
            tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(extractCoin.getMember(),"USDT"));
            extractCoin.setState("REJECT");
            extractCoin.setUpdateTime(DateUtils.getNowDate());
            tExtractCoinMapper.updateTExtractCoin(extractCoin);
            tMemberMapper.addBalanceByUserIdAndBz(extractCoin.getBalance().add(extractCoin.getHandlingFee()),extractCoin.getMember(),extractCoin.getCurrency());

            tBalanceRecord.setFundsType(2);
            tBalanceRecord.setBalanceType(55);
            tBalanceRecord.setDataClassification(5);
            tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(extractCoin.getMember(),"USDT"));
            tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
            return AjaxResult.success();
        }
        return AjaxResult.error("系统异常，请重新尝试");
    }
}
