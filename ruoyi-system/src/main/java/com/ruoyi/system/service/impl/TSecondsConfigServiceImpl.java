package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSecondsConfigMapper;
import com.ruoyi.system.domain.TSecondsConfig;
import com.ruoyi.system.service.ITSecondsConfigService;

/**
 * 秒合约配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class TSecondsConfigServiceImpl implements ITSecondsConfigService 
{
    @Autowired
    private TSecondsConfigMapper tSecondsConfigMapper;

    /**
     * 查询秒合约配置
     * 
     * @param id 秒合约配置主键
     * @return 秒合约配置
     */
    @Override
    public TSecondsConfig selectTSecondsConfigById(Long id)
    {
        return tSecondsConfigMapper.selectTSecondsConfigById(id);
    }

    /**
     * 查询秒合约配置列表
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 秒合约配置
     */
    @Override
    public List<TSecondsConfig> selectTSecondsConfigList(TSecondsConfig tSecondsConfig)
    {
        return tSecondsConfigMapper.selectTSecondsConfigList(tSecondsConfig);
    }

    /**
     * 新增秒合约配置
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 结果
     */
    @Override
    public int insertTSecondsConfig(TSecondsConfig tSecondsConfig)
    {
        tSecondsConfig.setCreateTime(DateUtils.getNowDate());
        return tSecondsConfigMapper.insertTSecondsConfig(tSecondsConfig);
    }

    /**
     * 修改秒合约配置
     * 
     * @param tSecondsConfig 秒合约配置
     * @return 结果
     */
    @Override
    public int updateTSecondsConfig(TSecondsConfig tSecondsConfig)
    {
        return tSecondsConfigMapper.updateTSecondsConfig(tSecondsConfig);
    }

    /**
     * 批量删除秒合约配置
     * 
     * @param ids 需要删除的秒合约配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondsConfigByIds(Long[] ids)
    {
        return tSecondsConfigMapper.deleteTSecondsConfigByIds(ids);
    }

    /**
     * 删除秒合约配置信息
     * 
     * @param id 秒合约配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondsConfigById(Long id)
    {
        return tSecondsConfigMapper.deleteTSecondsConfigById(id);
    }
}
