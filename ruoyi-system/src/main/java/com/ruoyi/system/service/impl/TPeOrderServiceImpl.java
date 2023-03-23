package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPeOrderMapper;
import com.ruoyi.system.domain.TPeOrder;
import com.ruoyi.system.service.ITPeOrderService;

/**
 * 私募订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TPeOrderServiceImpl implements ITPeOrderService 
{
    @Autowired
    private TPeOrderMapper tPeOrderMapper;

    /**
     * 查询私募订单
     * 
     * @param id 私募订单主键
     * @return 私募订单
     */
    @Override
    public TPeOrder selectTPeOrderById(String id)
    {
        return tPeOrderMapper.selectTPeOrderById(id);
    }

    /**
     * 查询私募订单列表
     * 
     * @param tPeOrder 私募订单
     * @return 私募订单
     */
    @Override
    public List<TPeOrder> selectTPeOrderList(TPeOrder tPeOrder)
    {
        return tPeOrderMapper.selectTPeOrderList(tPeOrder);
    }

    /**
     * 新增私募订单
     * 
     * @param tPeOrder 私募订单
     * @return 结果
     */
    @Override
    public int insertTPeOrder(TPeOrder tPeOrder)
    {
        tPeOrder.setCreateTime(DateUtils.getNowDate());
        return tPeOrderMapper.insertTPeOrder(tPeOrder);
    }

    /**
     * 修改私募订单
     * 
     * @param tPeOrder 私募订单
     * @return 结果
     */
    @Override
    public int updateTPeOrder(TPeOrder tPeOrder)
    {
        tPeOrder.setUpdateTime(DateUtils.getNowDate());
        return tPeOrderMapper.updateTPeOrder(tPeOrder);
    }

    /**
     * 批量删除私募订单
     * 
     * @param ids 需要删除的私募订单主键
     * @return 结果
     */
    @Override
    public int deleteTPeOrderByIds(String[] ids)
    {
        return tPeOrderMapper.deleteTPeOrderByIds(ids);
    }

    /**
     * 删除私募订单信息
     * 
     * @param id 私募订单主键
     * @return 结果
     */
    @Override
    public int deleteTPeOrderById(String id)
    {
        return tPeOrderMapper.deleteTPeOrderById(id);
    }
}
