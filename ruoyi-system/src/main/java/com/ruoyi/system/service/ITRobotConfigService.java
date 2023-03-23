package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TRobotConfig;

/**
 * 机器人配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ITRobotConfigService 
{
    /**
     * 查询机器人配置
     * 
     * @param id 机器人配置主键
     * @return 机器人配置
     */
    public TRobotConfig selectTRobotConfigById(String id);

    /**
     * 查询机器人配置列表
     * 
     * @param tRobotConfig 机器人配置
     * @return 机器人配置集合
     */
    public List<TRobotConfig> selectTRobotConfigList(TRobotConfig tRobotConfig);

    /**
     * 新增机器人配置
     * 
     * @param tRobotConfig 机器人配置
     * @return 结果
     */
    public int insertTRobotConfig(TRobotConfig tRobotConfig);

    /**
     * 修改机器人配置
     * 
     * @param tRobotConfig 机器人配置
     * @return 结果
     */
    public int updateTRobotConfig(TRobotConfig tRobotConfig);

    /**
     * 批量删除机器人配置
     * 
     * @param ids 需要删除的机器人配置主键集合
     * @return 结果
     */
    public int deleteTRobotConfigByIds(String[] ids);

    /**
     * 删除机器人配置信息
     * 
     * @param id 机器人配置主键
     * @return 结果
     */
    public int deleteTRobotConfigById(String id);
}
