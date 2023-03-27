package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.params.TSmartPoolOrderParam;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.utils.OrderNoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.ITSmartPoolOrderService;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TSmartPoolOrderServiceImpl implements ITSmartPoolOrderService {
    @Autowired
    private TSmartPoolOrderMapper tSmartPoolOrderMapper;
    @Resource
    private TMemberMapper tMemberMapper;
    @Resource
    private TBalanceMapper tBalanceMapper;
    @Resource
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Resource
    private TSmartPoolProductMapper tSmartPoolProductMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TSmartPoolOrder selectTSmartPoolOrderById(Long id) {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TSmartPoolOrder> selectTSmartPoolOrderList(TSmartPoolOrder tSmartPoolOrder) {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderList(tSmartPoolOrder);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder) {
        tSmartPoolOrder.setCreateTime(DateUtils.getNowDate());
        return tSmartPoolOrderMapper.insertTSmartPoolOrder(tSmartPoolOrder);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder) {
        tSmartPoolOrder.setUpdateTime(DateUtils.getNowDate());
        return tSmartPoolOrderMapper.updateTSmartPoolOrder(tSmartPoolOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolOrderByIds(Long[] ids) {
        return tSmartPoolOrderMapper.deleteTSmartPoolOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolOrderById(Long id) {
        return tSmartPoolOrderMapper.deleteTSmartPoolOrderById(id);
    }

    @Override
    public List<TSmartPoolOrder> selectTSmartPoolOrderListByParam(TSmartPoolOrderParam tSmartPoolOrderParam) {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderListByParam(tSmartPoolOrderParam);
    }

    @Override
    public boolean addOrder(TSmartPoolOrder tSmartPoolOrder) {
        TMember tMember = tMemberMapper.selectTMemberByUuid(tSmartPoolOrder.getMemberId());
        if (tMember == null) {
            throw new ServiceException("该用户不存在！");
        }
        TSmartPoolProduct tSmartPoolProduct = tSmartPoolProductMapper.selectTSmartPoolProductById(tSmartPoolOrder.getProductId());
        if (tSmartPoolProduct == null) {
            throw new ServiceException("该矿机不存在！");
        }
        if (tSmartPoolOrder.getPrice().compareTo(tSmartPoolProduct.getInvestmentAmountBehind()) < 1
                ||
                tSmartPoolOrder.getPrice().compareTo(tSmartPoolProduct.getInvestmentAmountFront()) == 1
        ) {
            throw new ServiceException("金额不在投资区间！");
        }
        Date nowTime = new Date();
        tSmartPoolOrder.setOrderNumber(OrderNoUtils.getCode());
        tSmartPoolOrder.setValueDate(nowTime);
        tSmartPoolOrder.setStartTime(nowTime);
        Integer periodDay = tSmartPoolProduct.getPeriodDay();
        if (periodDay == null) {
            tSmartPoolOrder.setEndTime(nowTime);
        } else {
            Calendar dd = Calendar.getInstance();
            dd.setTime(nowTime);
            dd.add(Calendar.DATE, periodDay);
            tSmartPoolOrder.setEndTime(dd.getTime());
        }
        String buyPairsName = tSmartPoolProduct.getBuyPairsName();
        TBalance tBalance = tBalanceMapper.getBalanceByUserIdWithPairsName(tMember.getId(), buyPairsName);
        if (tBalance == null || tBalance.getBalance().compareTo(tSmartPoolOrder.getPrice()) == -1) {
            throw new ServiceException(String.format("用户%s币不足", buyPairsName));
        }
        BigDecimal subtract = tBalance.getBalance().subtract(tSmartPoolOrder.getPrice());
        tBalance.setBalance(subtract);
        TBalanceRecord tBalanceRecord = new TBalanceRecord();
        tBalanceRecord.setMemberId(tMember.getId());
        tBalanceRecord.setCurrency(buyPairsName);
        tBalanceRecord.setBalanceType(11);
        tBalanceRecord.setFundsType(1);
        tBalanceRecord.setBalanceBefore(tBalance.getBalance());
        tBalanceRecord.setBalanceBack(subtract);
        tBalanceRecord.setBalanceDifference(tSmartPoolOrder.getPrice());
        tBalanceRecord.setDataClassification(6);

        tSmartPoolOrder.setMemberId(tMember.getId());
        tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
        tBalanceMapper.updateTBalance(tBalance);
        tSmartPoolOrderMapper.insertTSmartPoolOrder(tSmartPoolOrder);
        return true;
    }
}
