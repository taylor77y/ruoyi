package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TSmartPoolOrder;
import com.ruoyi.system.domain.params.TSmartPoolOrderParam;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface ITSmartPoolOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TSmartPoolOrder selectTSmartPoolOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TSmartPoolOrder> selectTSmartPoolOrderList(TSmartPoolOrder tSmartPoolOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTSmartPoolOrderByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTSmartPoolOrderById(Long id);

    List<TSmartPoolOrder> selectTSmartPoolOrderListByParam(TSmartPoolOrderParam tSmartPoolOrderParam);
}
