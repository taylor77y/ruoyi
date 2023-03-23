package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TRobotConfigMapper;
import com.ruoyi.system.domain.TRobotConfig;
import com.ruoyi.system.service.ITRobotConfigService;

/**
 * 机器人配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TRobotConfigServiceImpl implements ITRobotConfigService 
{
    @Autowired
    private TRobotConfigMapper tRobotConfigMapper;

    /**
     * 查询机器人配置
     * 
     * @param id 机器人配置主键
     * @return 机器人配置
     */
    @Override
    public TRobotConfig selectTRobotConfigById(String id)
    {
        return tRobotConfigMapper.selectTRobotConfigById(id);
    }

    /**
     * 查询机器人配置列表
     * 
     * @param tRobotConfig 机器人配置
     * @return 机器人配置
     */
    @Override
    public List<TRobotConfig> selectTRobotConfigList(TRobotConfig tRobotConfig)
    {
        return tRobotConfigMapper.selectTRobotConfigList(tRobotConfig);
    }

    /**
     * 新增机器人配置
     * 
     * @param tRobotConfig 机器人配置
     * @return 结果
     */
    @Override
    public int insertTRobotConfig(TRobotConfig tRobotConfig)
    {
        tRobotConfig.setCreateTime(DateUtils.getNowDate());
        return tRobotConfigMapper.insertTRobotConfig(tRobotConfig);
    }

    /**
     * 修改机器人配置
     * 
     * @param tRobotConfig 机器人配置
     * @return 结果
     */
    @Override
    public int updateTRobotConfig(TRobotConfig tRobotConfig)
    {
        return tRobotConfigMapper.updateTRobotConfig(tRobotConfig);
    }

    /**
     * 批量删除机器人配置
     * 
     * @param ids 需要删除的机器人配置主键
     * @return 结果
     */
    @Override
    public int deleteTRobotConfigByIds(String[] ids)
    {
        return tRobotConfigMapper.deleteTRobotConfigByIds(ids);
    }

    /**
     * 删除机器人配置信息
     * 
     * @param id 机器人配置主键
     * @return 结果
     */
    @Override
    public int deleteTRobotConfigById(String id)
    {
        return tRobotConfigMapper.deleteTRobotConfigById(id);
    }
}
