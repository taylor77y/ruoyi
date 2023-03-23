package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TOtcCurrenctConfig;

/**
 * 法币币种配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TOtcCurrenctConfigMapper 
{
    /**
     * 查询法币币种配置
     * 
     * @param id 法币币种配置主键
     * @return 法币币种配置
     */
    public TOtcCurrenctConfig selectTOtcCurrenctConfigById(Long id);

    /**
     * 查询法币币种配置列表
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 法币币种配置集合
     */
    public List<TOtcCurrenctConfig> selectTOtcCurrenctConfigList(TOtcCurrenctConfig tOtcCurrenctConfig);

    /**
     * 新增法币币种配置
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 结果
     */
    public int insertTOtcCurrenctConfig(TOtcCurrenctConfig tOtcCurrenctConfig);

    /**
     * 修改法币币种配置
     * 
     * @param tOtcCurrenctConfig 法币币种配置
     * @return 结果
     */
    public int updateTOtcCurrenctConfig(TOtcCurrenctConfig tOtcCurrenctConfig);

    /**
     * 删除法币币种配置
     * 
     * @param id 法币币种配置主键
     * @return 结果
     */
    public int deleteTOtcCurrenctConfigById(Long id);

    /**
     * 批量删除法币币种配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTOtcCurrenctConfigByIds(Long[] ids);
}
