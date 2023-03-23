package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.mapper.TBalanceMapper;
import com.ruoyi.system.mapper.TMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOtcOrderMapper;
import com.ruoyi.system.domain.TOtcOrder;
import com.ruoyi.system.service.ITOtcOrderService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 法币订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TOtcOrderServiceImpl implements ITOtcOrderService 
{
    @Autowired
    private TOtcOrderMapper tOtcOrderMapper;

    /**
     * 查询法币订单
     * 
     * @param id 法币订单主键
     * @return 法币订单
     */
    @Override
    public TOtcOrder selectTOtcOrderById(String id)
    {
        return tOtcOrderMapper.selectTOtcOrderById(id);
    }

    /**
     * 查询法币订单列表
     * 
     * @param tOtcOrder 法币订单
     * @return 法币订单
     */
    @Override
    public List<TOtcOrder> selectTOtcOrderList(TOtcOrder tOtcOrder)
    {
        return tOtcOrderMapper.selectTOtcOrderList(tOtcOrder);
    }
    @Autowired
    private TMemberMapper tMemberMapper;
    /**
     * 新增法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTOtcOrder(TOtcOrder tOtcOrder)
    {
        String memberId = tOtcOrder.getMember();
        TMember tMember = tMemberMapper.selectTMemberById(memberId);
        //检验法币状态
        if (!tMember.getFbStatus().equals("NORMAL")){
            return AjaxResult.error("法币不可用");
        }
        //判断是否实名认证
        if (tMember.getCardNo() == null || tMember.getCardNo().length() == 0){
            return AjaxResult.error("请先通过实名认证");
        }
        if (tMember.getCardState() == null || !tMember.getCardState().equals("PASS")){
            return AjaxResult.error("请先通过实名认证");
        }
        if (tMember.getBankCard() == null || tMember.getBankCard().length() == 0) {
            return AjaxResult.error("请先添加收款方式，再进行选择");
        }
        //用户买卖
//        if (tOtcOrder.getDirection().equals("SELL")){
            //扣法币可用
            int row = tMemberMapper.subFbBalanceByUserIdAndBz(tOtcOrder.getNum(),memberId,tOtcOrder.getCurrency());
            if (row == 0) return AjaxResult.error("资金不足，请先充值");
            if (row == 1){
                //加法币冻结
                tMemberMapper.addFbBlockedBalanceByUserIdAndBz(tOtcOrder.getNum(),memberId,tOtcOrder.getCurrency());
            }
//        }
        tOtcOrder.setMemberFbName(tMember.getStoreName());
        tOtcOrder.setCreateTime(DateUtils.getNowDate());
        tOtcOrder.setUpdateTime(DateUtils.getNowDate());
        tOtcOrder.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tOtcOrderMapper.insertTOtcOrder(tOtcOrder);
        return AjaxResult.success();
    }

    /**
     * 修改法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    @Override
    public AjaxResult updateTOtcOrder(TOtcOrder tOtcOrder)
    {
        /**
         * 更改之前的数据
         */
        TOtcOrder lastInfo = tOtcOrderMapper.selectTOtcOrderById(tOtcOrder.getId());
        String memberId = tOtcOrder.getMember();
        TMember tMember = tMemberMapper.selectTMemberById(memberId);
        //检验法币状态
        if (!tMember.getFbStatus().equals("NORMAL")){
            return AjaxResult.error("法币不可用");
        }
        //判断是否实名认证
        if (tMember.getCardNo() == null || tMember.getCardNo().length() == 0){
            return AjaxResult.error("请先通过实名认证");
        }
        if (tMember.getCardState() == null || !tMember.getCardState().equals("PASS")){
            return AjaxResult.error("请先通过实名认证");
        }
        if (tMember.getBankCard() == null || tMember.getBankCard().length() == 0) {
            return AjaxResult.error("请先添加收款方式，再进行选择");
        }
        //用户买卖
        if (tOtcOrder.getDirection().equals("SELL")){
            if (tOtcOrder.getNum().doubleValue() < lastInfo.getNum().doubleValue()){
                return AjaxResult.error("卖出数量不能小于原卖出数据");
            }
            double sx = tOtcOrder.getNum().doubleValue() - lastInfo.getNum().doubleValue();
            //扣法币可用
            int row = tMemberMapper.subFbBalanceByUserIdAndBz(BigDecimal.valueOf(sx),memberId,tOtcOrder.getCurrency());
            if (row == 1){
                //加法币冻结
                tMemberMapper.addFbBlockedBalanceByUserIdAndBz(BigDecimal.valueOf(sx),memberId,tOtcOrder.getCurrency());
            }
        }
        tOtcOrder.setUpdateTime(DateUtils.getNowDate());
        tOtcOrderMapper.updateTOtcOrder(tOtcOrder);
        return AjaxResult.success();
    }

    /**
     * 批量删除法币订单
     * 
     * @param ids 需要删除的法币订单主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderByIds(String[] ids)
    {
        return tOtcOrderMapper.deleteTOtcOrderByIds(ids);
    }

    /**
     * 删除法币订单信息
     * 
     * @param id 法币订单主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderById(String id)
    {
        return tOtcOrderMapper.deleteTOtcOrderById(id);
    }

    @Override
    public AjaxResult revoke(String id) {

        TOtcOrder tOtcOrder = tOtcOrderMapper.selectTOtcOrderById(id);
        //用户买卖
        if (tOtcOrder.getDirection().equals("SELL")){
            //扣法币冻结
            int row = tMemberMapper.subFbBlockedBalanceByUserIdAndBz(tOtcOrder.getNum(),tOtcOrder.getMember(),tOtcOrder.getCurrency());
            if (row == 1){
                //加法币可用
                tMemberMapper.addFbBalanceByUserIdAndBz(tOtcOrder.getNum(),tOtcOrder.getMember(),tOtcOrder.getCurrency());
            }else {
                return AjaxResult.error("交易异常，请刷新重试");
            }
        }
        tOtcOrder.setStatus("BACKOUT");
        tOtcOrderMapper.updateTOtcOrder(tOtcOrder);
        return AjaxResult.success();
    }
}
