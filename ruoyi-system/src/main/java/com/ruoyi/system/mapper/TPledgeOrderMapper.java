package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TPledgeOrder;

/**
 * 质押借币订单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
public interface TPledgeOrderMapper 
{
    /**
     * 查询质押借币订单
     * 
     * @param id 质押借币订单主键
     * @return 质押借币订单
     */
    public TPledgeOrder selectTPledgeOrderById(String id);

    /**
     * 查询质押借币订单列表
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 质押借币订单集合
     */
    public List<TPledgeOrder> selectTPledgeOrderList(TPledgeOrder tPledgeOrder);

    /**
     * 新增质押借币订单
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 结果
     */
    public int insertTPledgeOrder(TPledgeOrder tPledgeOrder);

    /**
     * 修改质押借币订单
     * 
     * @param tPledgeOrder 质押借币订单
     * @return 结果
     */
    public int updateTPledgeOrder(TPledgeOrder tPledgeOrder);

    /**
     * 删除质押借币订单
     * 
     * @param id 质押借币订单主键
     * @return 结果
     */
    public int deleteTPledgeOrderById(String id);

    /**
     * 批量删除质押借币订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPledgeOrderByIds(String[] ids);
}
