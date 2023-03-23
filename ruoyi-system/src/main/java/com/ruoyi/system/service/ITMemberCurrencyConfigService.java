package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMemberCurrencyConfig;

/**
 * 法币配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface ITMemberCurrencyConfigService 
{
    /**
     * 查询法币配置
     * 
     * @param id 法币配置主键
     * @return 法币配置
     */
    public TMemberCurrencyConfig selectTMemberCurrencyConfigById(Long id);

    /**
     * 查询法币配置列表
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 法币配置集合
     */
    public List<TMemberCurrencyConfig> selectTMemberCurrencyConfigList(TMemberCurrencyConfig tMemberCurrencyConfig);

    /**
     * 新增法币配置
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 结果
     */
    public int insertTMemberCurrencyConfig(TMemberCurrencyConfig tMemberCurrencyConfig);

    /**
     * 修改法币配置
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 结果
     */
    public int updateTMemberCurrencyConfig(TMemberCurrencyConfig tMemberCurrencyConfig);

    /**
     * 批量删除法币配置
     * 
     * @param ids 需要删除的法币配置主键集合
     * @return 结果
     */
    public int deleteTMemberCurrencyConfigByIds(Long[] ids);

    /**
     * 删除法币配置信息
     * 
     * @param id 法币配置主键
     * @return 结果
     */
    public int deleteTMemberCurrencyConfigById(Long id);
}
