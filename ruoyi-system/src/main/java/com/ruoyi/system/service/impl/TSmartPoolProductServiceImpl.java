package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TSmartPoolOrder;
import com.ruoyi.system.domain.params.TSmartPoolOrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSmartPoolProductMapper;
import com.ruoyi.system.domain.TSmartPoolProduct;
import com.ruoyi.system.service.ITSmartPoolProductService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TSmartPoolProductServiceImpl implements ITSmartPoolProductService 
{
    @Autowired
    private TSmartPoolProductMapper tSmartPoolProductMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TSmartPoolProduct selectTSmartPoolProductById(Long id)
    {
        return tSmartPoolProductMapper.selectTSmartPoolProductById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TSmartPoolProduct> selectTSmartPoolProductList(TSmartPoolProduct tSmartPoolProduct)
    {
        return tSmartPoolProductMapper.selectTSmartPoolProductList(tSmartPoolProduct);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTSmartPoolProduct(TSmartPoolProduct tSmartPoolProduct)
    {
        tSmartPoolProduct.setCreateTime(DateUtils.getNowDate());
        return tSmartPoolProductMapper.insertTSmartPoolProduct(tSmartPoolProduct);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tSmartPoolProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTSmartPoolProduct(TSmartPoolProduct tSmartPoolProduct)
    {
        tSmartPoolProduct.setUpdateTime(DateUtils.getNowDate());
        return tSmartPoolProductMapper.updateTSmartPoolProduct(tSmartPoolProduct);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolProductByIds(Long[] ids)
    {
        return tSmartPoolProductMapper.deleteTSmartPoolProductByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolProductById(Long id)
    {
        return tSmartPoolProductMapper.deleteTSmartPoolProductById(id);
    }

}
