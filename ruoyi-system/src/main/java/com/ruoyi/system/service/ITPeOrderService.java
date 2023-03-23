package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TPeOrder;

/**
 * 私募订单Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ITPeOrderService 
{
    /**
     * 查询私募订单
     * 
     * @param id 私募订单主键
     * @return 私募订单
     */
    public TPeOrder selectTPeOrderById(String id);

    /**
     * 查询私募订单列表
     * 
     * @param tPeOrder 私募订单
     * @return 私募订单集合
     */
    public List<TPeOrder> selectTPeOrderList(TPeOrder tPeOrder);

    /**
     * 新增私募订单
     * 
     * @param tPeOrder 私募订单
     * @return 结果
     */
    public int insertTPeOrder(TPeOrder tPeOrder);

    /**
     * 修改私募订单
     * 
     * @param tPeOrder 私募订单
     * @return 结果
     */
    public int updateTPeOrder(TPeOrder tPeOrder);

    /**
     * 批量删除私募订单
     * 
     * @param ids 需要删除的私募订单主键集合
     * @return 结果
     */
    public int deleteTPeOrderByIds(String[] ids);

    /**
     * 删除私募订单信息
     * 
     * @param id 私募订单主键
     * @return 结果
     */
    public int deleteTPeOrderById(String id);
}
