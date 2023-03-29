package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPledgeOrderMapper;
import com.ruoyi.system.domain.TPledgeOrder;
import com.ruoyi.system.service.ITPledgeOrderService;

/**
 * 质押借币订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@Service
public class TPledgeOrderServiceImpl implements ITPledgeOrderService 
{
    @Autowired
    private TPledgeOrderMapper tPledgeOrderMapper;

    /**
     * 查询质押借币订单
     * 
     * @param id 质押借币订单主键
     * @return 质押借币订单
     */
    @Override
    public TPledgeOrder selectTPledgeOrderById(String id)
    {
        return tPledgeOrderMapper.selectTPledgeOrderById(id);
    }

    /**
     * 查询质押借币订单列表
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 质押借币订单
     */
    @Override
    public List<TPledgeOrder> selectTPledgeOrderList(TPledgeOrder tPledgeOrder)
    {
        return tPledgeOrderMapper.selectTPledgeOrderList(tPledgeOrder);
    }

    /**
     * 新增质押借币订单
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 结果
     */
    @Override
    public int insertTPledgeOrder(TPledgeOrder tPledgeOrder)
    {
        return tPledgeOrderMapper.insertTPledgeOrder(tPledgeOrder);
    }

    /**
     * 修改质押借币订单
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 结果
     */
    @Override
    public int updateTPledgeOrder(TPledgeOrder tPledgeOrder)
    {
        tPledgeOrder.setUpdateTime(DateUtils.getNowDate());
        return tPledgeOrderMapper.updateTPledgeOrder(tPledgeOrder);
    }

    /**
     * 批量删除质押借币订单
     * 
     * @param ids 需要删除的质押借币订单主键
     * @return 结果
     */
    @Override
    public int deleteTPledgeOrderByIds(String[] ids)
    {
        return tPledgeOrderMapper.deleteTPledgeOrderByIds(ids);
    }

    /**
     * 删除质押借币订单信息
     * 
     * @param id 质押借币订单主键
     * @return 结果
     */
    @Override
    public int deleteTPledgeOrderById(String id)
    {
        return tPledgeOrderMapper.deleteTPledgeOrderById(id);
    }
}
