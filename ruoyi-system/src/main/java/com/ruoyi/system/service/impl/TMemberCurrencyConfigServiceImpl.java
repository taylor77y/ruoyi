package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberCurrencyConfigMapper;
import com.ruoyi.system.domain.TMemberCurrencyConfig;
import com.ruoyi.system.service.ITMemberCurrencyConfigService;

/**
 * 法币配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class TMemberCurrencyConfigServiceImpl implements ITMemberCurrencyConfigService 
{
    @Autowired
    private TMemberCurrencyConfigMapper tMemberCurrencyConfigMapper;

    /**
     * 查询法币配置
     * 
     * @param id 法币配置主键
     * @return 法币配置
     */
    @Override
    public TMemberCurrencyConfig selectTMemberCurrencyConfigById(Long id)
    {
        return tMemberCurrencyConfigMapper.selectTMemberCurrencyConfigById(id);
    }

    /**
     * 查询法币配置列表
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 法币配置
     */
    @Override
    public List<TMemberCurrencyConfig> selectTMemberCurrencyConfigList(TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        return tMemberCurrencyConfigMapper.selectTMemberCurrencyConfigList(tMemberCurrencyConfig);
    }

    /**
     * 新增法币配置
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 结果
     */
    @Override
    public int insertTMemberCurrencyConfig(TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        tMemberCurrencyConfig.setCreateTime(DateUtils.getNowDate());
        return tMemberCurrencyConfigMapper.insertTMemberCurrencyConfig(tMemberCurrencyConfig);
    }

    /**
     * 修改法币配置
     * 
     * @param tMemberCurrencyConfig 法币配置
     * @return 结果
     */
    @Override
    public int updateTMemberCurrencyConfig(TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        return tMemberCurrencyConfigMapper.updateTMemberCurrencyConfig(tMemberCurrencyConfig);
    }

    /**
     * 批量删除法币配置
     * 
     * @param ids 需要删除的法币配置主键
     * @return 结果
     */
    @Override
    public int deleteTMemberCurrencyConfigByIds(Long[] ids)
    {
        return tMemberCurrencyConfigMapper.deleteTMemberCurrencyConfigByIds(ids);
    }

    /**
     * 删除法币配置信息
     * 
     * @param id 法币配置主键
     * @return 结果
     */
    @Override
    public int deleteTMemberCurrencyConfigById(Long id)
    {
        return tMemberCurrencyConfigMapper.deleteTMemberCurrencyConfigById(id);
    }
}
