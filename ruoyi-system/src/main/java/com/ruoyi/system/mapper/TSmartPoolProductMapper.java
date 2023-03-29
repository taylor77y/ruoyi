package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TSmartPoolProduct;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface TSmartPoolProductMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TSmartPoolProduct selectTSmartPoolProductById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TSmartPoolProduct> selectTSmartPoolProductList(TSmartPoolProduct tSmartPoolProduct);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 结果
     */
    public int insertTSmartPoolProduct(TSmartPoolProduct tSmartPoolProduct);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 结果
     */
    public int updateTSmartPoolProduct(TSmartPoolProduct tSmartPoolProduct);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTSmartPoolProductById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSmartPoolProductByIds(Long[] ids);
}
