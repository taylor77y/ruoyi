package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOtcTypeConfigMapper;
import com.ruoyi.system.domain.TOtcTypeConfig;
import com.ruoyi.system.service.ITOtcTypeConfigService;

/**
 * 订单持续总时长Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TOtcTypeConfigServiceImpl implements ITOtcTypeConfigService 
{
    @Autowired
    private TOtcTypeConfigMapper tOtcTypeConfigMapper;

    /**
     * 查询订单持续总时长
     * 
     * @param id 订单持续总时长主键
     * @return 订单持续总时长
     */
    @Override
    public TOtcTypeConfig selectTOtcTypeConfigById(Long id)
    {
        return tOtcTypeConfigMapper.selectTOtcTypeConfigById(id);
    }

    /**
     * 查询订单持续总时长列表
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 订单持续总时长
     */
    @Override
    public List<TOtcTypeConfig> selectTOtcTypeConfigList(TOtcTypeConfig tOtcTypeConfig)
    {
        return tOtcTypeConfigMapper.selectTOtcTypeConfigList(tOtcTypeConfig);
    }

    /**
     * 新增订单持续总时长
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 结果
     */
    @Override
    public int insertTOtcTypeConfig(TOtcTypeConfig tOtcTypeConfig)
    {
        tOtcTypeConfig.setCreateTime(DateUtils.getNowDate());
        return tOtcTypeConfigMapper.insertTOtcTypeConfig(tOtcTypeConfig);
    }

    /**
     * 修改订单持续总时长
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 结果
     */
    @Override
    public int updateTOtcTypeConfig(TOtcTypeConfig tOtcTypeConfig)
    {
        tOtcTypeConfig.setUpdateTime(DateUtils.getNowDate());
        return tOtcTypeConfigMapper.updateTOtcTypeConfig(tOtcTypeConfig);
    }

    /**
     * 批量删除订单持续总时长
     * 
     * @param ids 需要删除的订单持续总时长主键
     * @return 结果
     */
    @Override
    public int deleteTOtcTypeConfigByIds(Long[] ids)
    {
        return tOtcTypeConfigMapper.deleteTOtcTypeConfigByIds(ids);
    }

    /**
     * 删除订单持续总时长信息
     * 
     * @param id 订单持续总时长主键
     * @return 结果
     */
    @Override
    public int deleteTOtcTypeConfigById(Long id)
    {
        return tOtcTypeConfigMapper.deleteTOtcTypeConfigById(id);
    }
}
