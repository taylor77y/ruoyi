package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TOtcOrder;

/**
 * 法币订单Service接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface ITOtcOrderService 
{
    /**
     * 查询法币订单
     * 
     * @param id 法币订单主键
     * @return 法币订单
     */
    public TOtcOrder selectTOtcOrderById(String id);

    /**
     * 查询法币订单列表
     * 
     * @param tOtcOrder 法币订单
     * @return 法币订单集合
     */
    public List<TOtcOrder> selectTOtcOrderList(TOtcOrder tOtcOrder);

    /**
     * 新增法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    public AjaxResult insertTOtcOrder(TOtcOrder tOtcOrder);

    /**
     * 修改法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    public AjaxResult updateTOtcOrder(TOtcOrder tOtcOrder);

    /**
     * 批量删除法币订单
     * 
     * @param ids 需要删除的法币订单主键集合
     * @return 结果
     */
    public int deleteTOtcOrderByIds(String[] ids);

    /**
     * 删除法币订单信息
     * 
     * @param id 法币订单主键
     * @return 结果
     */
    public int deleteTOtcOrderById(String id);

    /**
     * 撤销
     */
    public AjaxResult revoke(String id);
}
