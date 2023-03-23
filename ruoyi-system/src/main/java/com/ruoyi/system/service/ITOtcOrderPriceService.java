package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TOtcOrderPrice;

/**
 * 下单Service接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface ITOtcOrderPriceService 
{
    /**
     * 查询下单
     * 
     * @param id 下单主键
     * @return 下单
     */
    public TOtcOrderPrice selectTOtcOrderPriceById(String id);

    /**
     * 查询下单列表
     * 
     * @param tOtcOrderPrice 下单
     * @return 下单集合
     */
    public List<TOtcOrderPrice> selectTOtcOrderPriceList(TOtcOrderPrice tOtcOrderPrice);

    /**
     * 新增下单
     * 
     * @param tOtcOrderPrice 下单
     * @return 结果
     */
    public int insertTOtcOrderPrice(TOtcOrderPrice tOtcOrderPrice);

    /**
     * 修改下单
     * 
     * @param tOtcOrderPrice 下单
     * @return 结果
     */
    public int updateTOtcOrderPrice(TOtcOrderPrice tOtcOrderPrice);

    /**
     * 批量删除下单
     * 
     * @param ids 需要删除的下单主键集合
     * @return 结果
     */
    public int deleteTOtcOrderPriceByIds(String[] ids);

    /**
     * 删除下单信息
     * 
     * @param id 下单主键
     * @return 结果
     */
    public int deleteTOtcOrderPriceById(String id);

    AjaxResult release(String id,Integer type);
    AjaxResult sureOrder(String id);
    AjaxResult cancelOrder(String id);
}
