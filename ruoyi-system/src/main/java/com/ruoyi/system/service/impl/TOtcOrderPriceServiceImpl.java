package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.TOtcOrder;
import com.ruoyi.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.TOtcOrderPrice;
import com.ruoyi.system.service.ITOtcOrderPriceService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 下单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TOtcOrderPriceServiceImpl implements ITOtcOrderPriceService 
{
    @Autowired
    private TOtcOrderPriceMapper tOtcOrderPriceMapper;
    @Autowired
    private TMemberMapper memberMapper;
    /**
     * 查询下单
     * 
     * @param id 下单主键
     * @return 下单
     */
    @Override
    public TOtcOrderPrice selectTOtcOrderPriceById(String id)
    {
        TOtcOrderPrice x = tOtcOrderPriceMapper.selectTOtcOrderPriceById(id);
        String memberPhone = memberMapper.getMemberPhone(x.getStoreId());
        String memberMail = memberMapper.getMemberMail(x.getStoreId());
        x.setStorePhone(memberPhone);
        x.setStoreMail(memberMail);
        if (!x.getAppealStatus().equals("NORMAL")){
            if (x.getUserId().equals(x.getAppealUserId())){
                x.setAppealUserPhone(x.getUserPhone());
                x.setAppealUserMail(x.getUserMail());
            }else {
                x.setAppealUserPhone(x.getStorePhone());
                x.setAppealUserMail(x.getStoreMail());
            }
        }
        x.setMemberCurrencyConfig(tMemberCurrencyConfigMapper.selectTMemberCurrencyConfigById(x.getPayMccId()));
        return x;
    }
    @Autowired
    private TMemberCurrencyConfigMapper tMemberCurrencyConfigMapper;
    /**
     * 查询下单列表
     * 
     * @param tOtcOrderPrice 下单
     * @return 下单
     */
    @Override
    public List<TOtcOrderPrice> selectTOtcOrderPriceList(TOtcOrderPrice tOtcOrderPrice)
    {
        List<TOtcOrderPrice> list = tOtcOrderPriceMapper.selectTOtcOrderPriceList(tOtcOrderPrice);
        if (list.size()>0){
            list.stream().forEach(x->{
                String memberPhone = memberMapper.getMemberPhone(x.getStoreId());
                String memberMail = memberMapper.getMemberMail(x.getStoreId());
                x.setStorePhone(memberPhone);
                x.setStoreMail(memberMail);
                if (!x.getAppealStatus().equals("NORMAL")){
                    if (x.getUserId().equals(x.getAppealUserId())){
                        x.setAppealUserPhone(x.getUserPhone());
                        x.setAppealUserMail(x.getUserMail());
                    }else {
                        x.setAppealUserPhone(x.getStorePhone());
                        x.setAppealUserMail(x.getStoreMail());
                    }
                }
                x.setMemberCurrencyConfig(tMemberCurrencyConfigMapper.selectTMemberCurrencyConfigById(x.getPayMccId()));
            });
        }
        return list;
    }

    /**
     * 新增下单
     * 
     * @param tOtcOrderPrice 下单
     * @return 结果
     */
    @Override
    public int insertTOtcOrderPrice(TOtcOrderPrice tOtcOrderPrice)
    {
        tOtcOrderPrice.setCreateTime(DateUtils.getNowDate());
        return tOtcOrderPriceMapper.insertTOtcOrderPrice(tOtcOrderPrice);
    }

    /**
     * 修改下单
     * 
     * @param tOtcOrderPrice 下单
     * @return 结果
     */
    @Override
    public int updateTOtcOrderPrice(TOtcOrderPrice tOtcOrderPrice)
    {
        tOtcOrderPrice.setUpdateTime(DateUtils.getNowDate());
        return tOtcOrderPriceMapper.updateTOtcOrderPrice(tOtcOrderPrice);
    }

    /**
     * 批量删除下单
     * 
     * @param ids 需要删除的下单主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderPriceByIds(String[] ids)
    {
        return tOtcOrderPriceMapper.deleteTOtcOrderPriceByIds(ids);
    }

    /**
     * 删除下单信息
     * 
     * @param id 下单主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderPriceById(String id)
    {
        return tOtcOrderPriceMapper.deleteTOtcOrderPriceById(id);
    }
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private TOtcOrderMapper tOtcOrderMapper;
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Override
    @Transactional
    public AjaxResult release(String id,Integer type) {
        TOtcOrderPrice tOtcOrderPrice = tOtcOrderPriceMapper.selectTOtcOrderPriceById(id);
        String memberId = tOtcOrderPrice.getUserId();
        TMember tMember = tMemberMapper.selectTMemberById(memberId);
        //检验法币状态
        if (!tMember.getFbStatus().equals("NORMAL")){
            return AjaxResult.error("法币不可用");
        }
//        //判断是否实名认证
//        if (tMember.getCardNo() == null || tMember.getCardNo().length() == 0){
//            return AjaxResult.error("请先通过实名认证");
//        }
//        if (tMember.getCardState() == null || !tMember.getCardState().equals("PASS")){
//            return AjaxResult.error("请先通过实名认证");
//        }
//        if (type == 1){
//            //订单状态
//            if (!tOtcOrderPrice.getStatus().equals("PAYMENT")){
//                return AjaxResult.error("订单状态异常");
//            }
//        }
        TBalanceRecord tBalanceRecord = new TBalanceRecord();
        tBalanceRecord.setMemberId(tOtcOrderPrice.getUserId());
        tBalanceRecord.setCurrency(tOtcOrderPrice.getCurrency());
        tBalanceRecord.setBalanceDifference(tOtcOrderPrice.getNum());
        tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(tOtcOrderPrice.getUserId(),"USDT"));
        //用户方向
        if (tOtcOrderPrice.getUserDirection().equals("BUY")){//用户是买
            //减去商家法币冻结
            int row = memberMapper.subFbBlockedBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getStoreId(),tOtcOrderPrice.getCurrency());
            if (row == 0){
                return AjaxResult.error("更新资产失败");
            }
            //加用户余额
            int row2 = memberMapper.addFbBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getUserId(),tOtcOrderPrice.getCurrency());
            if (row2 == 0){
                return AjaxResult.error("更新资产失败");
            }
            tBalanceRecord.setFundsType(2);
            tBalanceRecord.setBalanceType(21);
            tBalanceRecord.setDataClassification(2);
            tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(tOtcOrderPrice.getUserId(),"USDT"));
            tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
        }else {//用户是卖
            //扣用户的法币冻结
            int row = memberMapper.subFbBlockedBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getUserId(),tOtcOrderPrice.getCurrency());
            if (row == 0){
                return AjaxResult.error("更新资产失败");
            }
            //加商家余额
            int row2 = memberMapper.addFbBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getStoreId(),tOtcOrderPrice.getCurrency());
            if (row2 == 0){
                return AjaxResult.error("更新资产失败");
            }
        }
        tOtcOrderPrice.setStatus("FINISH");
        //广告数据
        TOtcOrder tOtcOrder = tOtcOrderMapper.selectTOtcOrderById(tOtcOrderPrice.getOrderId());
//        tOtcOrder.setDealNum(tOtcOrder.getDealNum().add(tOtcOrderPrice.getNum()));
        tOtcOrder.setFreeze(tOtcOrder.getFreeze().subtract(tOtcOrderPrice.getNum()));
        tOtcOrderPrice.setUpdateTime(DateUtils.getNowDate());
        tOtcOrderPriceMapper.updateTOtcOrderPrice(tOtcOrderPrice);
        tOtcOrderMapper.updateTOtcOrder(tOtcOrder);
        tOtcOrderMapper.addDealNumById(tOtcOrderPrice.getNum(),tOtcOrder.getId());
        return AjaxResult.success();
    }

    @Override
    public AjaxResult sureOrder(String id) {
        return null;
    }

    @Override
    @Transactional
    public AjaxResult cancelOrder(String id) {
        TOtcOrderPrice tOtcOrderPrice = tOtcOrderPriceMapper.selectTOtcOrderPriceById(id);
        String memberId = tOtcOrderPrice.getUserId();
        TMember tMember = tMemberMapper.selectTMemberById(memberId);
        //检验法币状态
        if (!tMember.getFbStatus().equals("NORMAL")){
            return AjaxResult.error("法币不可用");
        }
//        //判断是否实名认证
//        if (tMember.getCardNo() == null || tMember.getCardNo().length() == 0){
//            return AjaxResult.error("请先通过实名认证");
//        }
//        if (tMember.getCardState() == null || !tMember.getCardState().equals("PASS")){
//            return AjaxResult.error("请先通过实名认证");
//        }
        //订单状态
//        if (!tOtcOrderPrice.getStatus().equals("NONPAYMENT")){
//            return AjaxResult.error("只能取消未付款状态订单");
//        }
        //用户买卖
        if (tOtcOrderPrice.getUserDirection().equals("BUY")) {//用户是买

        }else {
            int row = memberMapper.subFbBlockedBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getUserId(),tOtcOrderPrice.getCurrency());
            if (row == 0) {
                return AjaxResult.error("更新资产失败");
            }
            TBalanceRecord tBalanceRecord = new TBalanceRecord();
            tBalanceRecord.setMemberId(tOtcOrderPrice.getUserId());
            tBalanceRecord.setCurrency(tOtcOrderPrice.getCurrency());
            tBalanceRecord.setBalanceDifference(tOtcOrderPrice.getNum());
            tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(tOtcOrderPrice.getUserId(),"USDT"));
            memberMapper.addFbBalanceByUserIdAndBz(tOtcOrderPrice.getNum(),tOtcOrderPrice.getUserId(),tOtcOrderPrice.getCurrency());

            tBalanceRecord.setFundsType(2);
            tBalanceRecord.setBalanceType(23);
            tBalanceRecord.setDataClassification(2);
            tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(tOtcOrderPrice.getUserId(),"USDT"));
            tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
        }
        tOtcOrderPrice.setStatus("CALLOFF");
        //广告数据
        TOtcOrder tOtcOrder = tOtcOrderMapper.selectTOtcOrderById(tOtcOrderPrice.getOrderId());
        tOtcOrder.setNum(tOtcOrder.getNum().add(tOtcOrderPrice.getNum()));
        tOtcOrder.setFreeze(tOtcOrder.getFreeze().subtract(tOtcOrderPrice.getNum()));
        tOtcOrderPrice.setUpdateTime(DateUtils.getNowDate());
        tOtcOrderPriceMapper.updateTOtcOrderPrice(tOtcOrderPrice);
        tOtcOrderMapper.updateTOtcOrder(tOtcOrder);
        return AjaxResult.success();
    }
}
