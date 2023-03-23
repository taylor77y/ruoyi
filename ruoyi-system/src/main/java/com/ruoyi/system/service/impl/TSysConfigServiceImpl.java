package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSysConfigMapper;
import com.ruoyi.system.domain.TSysConfig;
import com.ruoyi.system.service.ITSysConfigService;

/**
 * 三方接口Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TSysConfigServiceImpl implements ITSysConfigService 
{
    @Autowired
    private TSysConfigMapper tSysConfigMapper;

    /**
     * 查询三方接口
     * 
     * @param id 三方接口主键
     * @return 三方接口
     */
    @Override
    public TSysConfig selectTSysConfigById(String id)
    {
        return tSysConfigMapper.selectTSysConfigById(id);
    }

    /**
     * 查询三方接口列表
     * 
     * @param tSysConfig 三方接口
     * @return 三方接口
     */
    @Override
    public List<TSysConfig> selectTSysConfigList(TSysConfig tSysConfig)
    {
        return tSysConfigMapper.selectTSysConfigList(tSysConfig);
    }

    /**
     * 新增三方接口
     * 
     * @param tSysConfig 三方接口
     * @return 结果
     */
    @Override
    public int insertTSysConfig(TSysConfig tSysConfig)
    {
        tSysConfig.setCreateTime(DateUtils.getNowDate());
        return tSysConfigMapper.insertTSysConfig(tSysConfig);
    }

    /**
     * 修改三方接口
     * 
     * @param tSysConfig 三方接口
     * @return 结果
     */
    @Override
    public int updateTSysConfig(TSysConfig tSysConfig)
    {
        tSysConfig.setUpdateTime(DateUtils.getNowDate());
        return tSysConfigMapper.updateTSysConfig(tSysConfig);
    }

    /**
     * 批量删除三方接口
     * 
     * @param ids 需要删除的三方接口主键
     * @return 结果
     */
    @Override
    public int deleteTSysConfigByIds(String[] ids)
    {
        return tSysConfigMapper.deleteTSysConfigByIds(ids);
    }

    /**
     * 删除三方接口信息
     * 
     * @param id 三方接口主键
     * @return 结果
     */
    @Override
    public int deleteTSysConfigById(String id)
    {
        return tSysConfigMapper.deleteTSysConfigById(id);
    }
}
