package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TFundProductMapper;
import com.ruoyi.system.domain.TFundProduct;
import com.ruoyi.system.service.ITFundProductService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TFundProductServiceImpl implements ITFundProductService 
{
    @Autowired
    private TFundProductMapper tFundProductMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TFundProduct selectTFundProductById(Long id)
    {
        return tFundProductMapper.selectTFundProductById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TFundProduct> selectTFundProductList(TFundProduct tFundProduct)
    {
        return tFundProductMapper.selectTFundProductList(tFundProduct);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTFundProduct(TFundProduct tFundProduct)
    {
        tFundProduct.setCreateTime(DateUtils.getNowDate());
        return tFundProductMapper.insertTFundProduct(tFundProduct);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tFundProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTFundProduct(TFundProduct tFundProduct)
    {
        tFundProduct.setUpdateTime(DateUtils.getNowDate());
        return tFundProductMapper.updateTFundProduct(tFundProduct);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTFundProductByIds(Long[] ids)
    {
        return tFundProductMapper.deleteTFundProductByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTFundProductById(Long id)
    {
        return tFundProductMapper.deleteTFundProductById(id);
    }
}
