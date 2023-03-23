package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TSysConfig;

/**
 * 三方接口Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TSysConfigMapper 
{
    /**
     * 查询三方接口
     * 
     * @param id 三方接口主键
     * @return 三方接口
     */
    public TSysConfig selectTSysConfigById(String id);

    /**
     * 查询三方接口列表
     * 
     * @param tSysConfig 三方接口
     * @return 三方接口集合
     */
    public List<TSysConfig> selectTSysConfigList(TSysConfig tSysConfig);

    /**
     * 新增三方接口
     * 
     * @param tSysConfig 三方接口
     * @return 结果
     */
    public int insertTSysConfig(TSysConfig tSysConfig);

    /**
     * 修改三方接口
     * 
     * @param tSysConfig 三方接口
     * @return 结果
     */
    public int updateTSysConfig(TSysConfig tSysConfig);

    /**
     * 删除三方接口
     * 
     * @param id 三方接口主键
     * @return 结果
     */
    public int deleteTSysConfigById(String id);

    /**
     * 批量删除三方接口
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSysConfigByIds(String[] ids);
}
