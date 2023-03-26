package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TFundProduct;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface TFundProductMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TFundProduct selectTFundProductById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TFundProduct> selectTFundProductList(TFundProduct tFundProduct);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 结果
     */
    public int insertTFundProduct(TFundProduct tFundProduct);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 结果
     */
    public int updateTFundProduct(TFundProduct tFundProduct);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTFundProductById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTFundProductByIds(Long[] ids);
}
