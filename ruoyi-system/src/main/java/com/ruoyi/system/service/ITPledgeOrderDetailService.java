package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TPledgeOrderDetail;

/**
 * 质押借币订单详情Service接口
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
public interface ITPledgeOrderDetailService 
{
    /**
     * 查询质押借币订单详情
     * 
     * @param id 质押借币订单详情主键
     * @return 质押借币订单详情
     */
    public TPledgeOrderDetail selectTPledgeOrderDetailById(String id);

    /**
     * 查询质押借币订单详情列表
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 质押借币订单详情集合
     */
    public List<TPledgeOrderDetail> selectTPledgeOrderDetailList(TPledgeOrderDetail tPledgeOrderDetail);

    /**
     * 新增质押借币订单详情
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 结果
     */
    public int insertTPledgeOrderDetail(TPledgeOrderDetail tPledgeOrderDetail);

    /**
     * 修改质押借币订单详情
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 结果
     */
    public int updateTPledgeOrderDetail(TPledgeOrderDetail tPledgeOrderDetail);

    /**
     * 批量删除质押借币订单详情
     * 
     * @param ids 需要删除的质押借币订单详情主键集合
     * @return 结果
     */
    public int deleteTPledgeOrderDetailByIds(String[] ids);

    /**
     * 删除质押借币订单详情信息
     * 
     * @param id 质押借币订单详情主键
     * @return 结果
     */
    public int deleteTPledgeOrderDetailById(String id);
}
