package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TExtractCoin;

/**
 * 提币审核Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface TExtractCoinMapper 
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
     * 删除提币审核
     * 
     * @param id 提币审核主键
     * @return 结果
     */
    public int deleteTExtractCoinById(String id);

    /**
     * 批量删除提币审核
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTExtractCoinByIds(String[] ids);
}
