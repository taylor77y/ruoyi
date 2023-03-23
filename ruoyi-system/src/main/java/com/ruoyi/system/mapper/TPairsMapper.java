package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TPairs;

/**
 * 交易对配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TPairsMapper 
{
    /**
     * 查询交易对配置
     * 
     * @param id 交易对配置主键
     * @return 交易对配置
     */
    public TPairs selectTPairsById(String id);
    public TPairs selectTPairsByName(String name);

    /**
     * 查询交易对配置列表
     * 
     * @param tPairs 交易对配置
     * @return 交易对配置集合
     */
    public List<TPairs> selectTPairsList(TPairs tPairs);

    /**
     * 新增交易对配置
     * 
     * @param tPairs 交易对配置
     * @return 结果
     */
    public int insertTPairs(TPairs tPairs);

    /**
     * 修改交易对配置
     * 
     * @param tPairs 交易对配置
     * @return 结果
     */
    public int updateTPairs(TPairs tPairs);

    /**
     * 删除交易对配置
     * 
     * @param id 交易对配置主键
     * @return 结果
     */
    public int deleteTPairsById(String id);

    /**
     * 批量删除交易对配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPairsByIds(String[] ids);

    public List<TPairs> findByAll();
}
