package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TFundOrder;
import com.ruoyi.system.domain.params.TFundOrderParam;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface TFundOrderMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TFundOrder selectTFundOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tFundOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TFundOrder> selectTFundOrderList(TFundOrder tFundOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tFundOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertTFundOrder(TFundOrder tFundOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tFundOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateTFundOrder(TFundOrder tFundOrder);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTFundOrderById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTFundOrderByIds(Long[] ids);

    List<TFundOrder> selectTFundOrderListByParam(TFundOrderParam tFundOrderParam);
}
