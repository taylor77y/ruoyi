package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOtcCurrenctConfigMapper;
import com.ruoyi.system.domain.TOtcCurrenctConfig;
import com.ruoyi.system.service.ITOtcCurrenctConfigService;

/**
 * 法币币种配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TOtcCurrenctConfigServiceImpl implements ITOtcCurrenctConfigService 
{
    @Autowired
    private TOtcCurrenctConfigMapper tOtcCurrenctConfigMapper;

    /**
     * 查询法币币种配置
     * 
     * @param id 法币币种配置主键
     * @return 法币币种配置
     */
    @Override
    public TOtcCurrenctConfig selectTOtcCurrenctConfigById(Long id)
    {
        return tOtcCurrenctConfigMapper.selectTOtcCurrenctConfigById(id);
    }

    /**
     * 查询法币币种配置列表
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 法币币种配置
     */
    @Override
    public List<TOtcCurrenctConfig> selectTOtcCurrenctConfigList(TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        return tOtcCurrenctConfigMapper.selectTOtcCurrenctConfigList(tOtcCurrenctConfig);
    }

    /**
     * 新增法币币种配置
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 结果
     */
    @Override
    public int insertTOtcCurrenctConfig(TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        tOtcCurrenctConfig.setCreateTime(DateUtils.getNowDate());
        return tOtcCurrenctConfigMapper.insertTOtcCurrenctConfig(tOtcCurrenctConfig);
    }

    /**
     * 修改法币币种配置
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 结果
     */
    @Override
    public int updateTOtcCurrenctConfig(TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        tOtcCurrenctConfig.setUpdateTime(DateUtils.getNowDate());
        return tOtcCurrenctConfigMapper.updateTOtcCurrenctConfig(tOtcCurrenctConfig);
    }

    /**
     * 批量删除法币币种配置
     * 
     * @param ids 需要删除的法币币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTOtcCurrenctConfigByIds(Long[] ids)
    {
        return tOtcCurrenctConfigMapper.deleteTOtcCurrenctConfigByIds(ids);
    }

    /**
     * 删除法币币种配置信息
     * 
     * @param id 法币币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTOtcCurrenctConfigById(Long id)
    {
        return tOtcCurrenctConfigMapper.deleteTOtcCurrenctConfigById(id);
    }
}
