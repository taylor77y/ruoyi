package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TExtractCoin;

/**
 * 提币审核Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITExtractCoinService 
{
    /**
     * 查询提币审核
     * 
     * @param id 提币审核主键
     * @return 提币审核
     */
    public TExtractCoin selectTExtractCoinById(String id);

    /**
     * 查询提币审核列表
     * 
     * @param tExtractCoin 提币审核
     * @return 提币审核集合
     */
    public List<TExtractCoin> selectTExtractCoinList(TExtractCoin tExtractCoin);

    /**
     * 新增提币审核
     * 
     * @param tExtractCoin 提币审核
     * @return 结果
     */
    public int insertTExtractCoin(TExtractCoin tExtractCoin);

    /**
     * 修改提币审核
     * 
     * @param tExtractCoin 提币审核
     * @return 结果
     */
    public int updateTExtractCoin(TExtractCoin tExtractCoin);

    /**
     * 批量删除提币审核
     * 
     * @param ids 需要删除的提币审核主键集合
     * @return 结果
     */
    public int deleteTExtractCoinByIds(String[] ids);

    /**
     * 删除提币审核信息
     * 
     * @param id 提币审核主键
     * @return 结果
     */
    public int deleteTExtractCoinById(String id);

    AjaxResult withdrawAudit(Integer type, String id);
}
