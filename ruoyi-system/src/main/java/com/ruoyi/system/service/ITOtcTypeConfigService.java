package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TOtcTypeConfig;

/**
 * 订单持续总时长Service接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface ITOtcTypeConfigService 
{
    /**
     * 查询订单持续总时长
     * 
     * @param id 订单持续总时长主键
     * @return 订单持续总时长
     */
    public TOtcTypeConfig selectTOtcTypeConfigById(Long id);

    /**
     * 查询订单持续总时长列表
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 订单持续总时长集合
     */
    public List<TOtcTypeConfig> selectTOtcTypeConfigList(TOtcTypeConfig tOtcTypeConfig);

    /**
     * 新增订单持续总时长
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 结果
     */
    public int insertTOtcTypeConfig(TOtcTypeConfig tOtcTypeConfig);

    /**
     * 修改订单持续总时长
     * 
     * @param tOtcTypeConfig 订单持续总时长
     * @return 结果
     */
    public int updateTOtcTypeConfig(TOtcTypeConfig tOtcTypeConfig);

    /**
     * 批量删除订单持续总时长
     * 
     * @param ids 需要删除的订单持续总时长主键集合
     * @return 结果
     */
    public int deleteTOtcTypeConfigByIds(Long[] ids);

    /**
     * 删除订单持续总时长信息
     * 
     * @param id 订单持续总时长主键
     * @return 结果
     */
    public int deleteTOtcTypeConfigById(Long id);
}
