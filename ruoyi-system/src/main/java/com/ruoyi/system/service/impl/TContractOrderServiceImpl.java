package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TContractOrderMapper;
import com.ruoyi.system.domain.TContractOrder;
import com.ruoyi.system.service.ITContractOrderService;

/**
 * 合约订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TContractOrderServiceImpl implements ITContractOrderService 
{
    @Autowired
    private TContractOrderMapper tContractOrderMapper;

    /**
     * 查询合约订单
     * 
     * @param id 合约订单主键
     * @return 合约订单
     */
    @Override
    public TContractOrder selectTContractOrderById(String id)
    {
        return tContractOrderMapper.selectTContractOrderById(id);
    }

    /**
     * 查询合约订单列表
     * 
     * @param tContractOrder 合约订单
     * @return 合约订单
     */
    @Override
    public List<TContractOrder> selectTContractOrderList(TContractOrder tContractOrder)
    {
        return tContractOrderMapper.selectTContractOrderList(tContractOrder);
    }

    /**
     * 新增合约订单
     * 
     * @param tContractOrder 合约订单
     * @return 结果
     */
    @Override
    public int insertTContractOrder(TContractOrder tContractOrder)
    {
        tContractOrder.setCreateTime(DateUtils.getNowDate());
        return tContractOrderMapper.insertTContractOrder(tContractOrder);
    }

    /**
     * 修改合约订单
     * 
     * @param tContractOrder 合约订单
     * @return 结果
     */
    @Override
    public int updateTContractOrder(TContractOrder tContractOrder)
    {
        tContractOrder.setUpdateTime(DateUtils.getNowDate());
        return tContractOrderMapper.updateTContractOrder(tContractOrder);
    }

    /**
     * 批量删除合约订单
     * 
     * @param ids 需要删除的合约订单主键
     * @return 结果
     */
    @Override
    public int deleteTContractOrderByIds(String[] ids)
    {
        return tContractOrderMapper.deleteTContractOrderByIds(ids);
    }

    /**
     * 删除合约订单信息
     * 
     * @param id 合约订单主键
     * @return 结果
     */
    @Override
    public int deleteTContractOrderById(String id)
    {
        return tContractOrderMapper.deleteTContractOrderById(id);
    }
}
