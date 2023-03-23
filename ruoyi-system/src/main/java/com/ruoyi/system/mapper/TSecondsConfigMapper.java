package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TSecondsConfig;

/**
 * 秒合约配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface TSecondsConfigMapper 
{
    /**
     * 查询秒合约配置
     * 
     * @param id 秒合约配置主键
     * @return 秒合约配置
     */
    public TSecondsConfig selectTSecondsConfigById(Long id);

    /**
     * 查询秒合约配置列表
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 秒合约配置集合
     */
    public List<TSecondsConfig> selectTSecondsConfigList(TSecondsConfig tSecondsConfig);

    /**
     * 新增秒合约配置
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 结果
     */
    public int insertTSecondsConfig(TSecondsConfig tSecondsConfig);

    /**
     * 修改秒合约配置
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 结果
     */
    public int updateTSecondsConfig(TSecondsConfig tSecondsConfig);

    /**
     * 删除秒合约配置
     * 
     * @param id 秒合约配置主键
     * @return 结果
     */
    public int deleteTSecondsConfigById(Long id);

    /**
     * 批量删除秒合约配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSecondsConfigByIds(Long[] ids);
}
