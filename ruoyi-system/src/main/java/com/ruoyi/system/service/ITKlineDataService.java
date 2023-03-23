package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TKlineData;

/**
 * 自发币K线数据Service接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface ITKlineDataService 
{
    /**
     * 查询自发币K线数据
     * 
     * @param id 自发币K线数据主键
     * @return 自发币K线数据
     */
    public TKlineData selectTKlineDataById(Long id);

    /**
     * 查询自发币K线数据列表
     * 
     * @param tKlineData 自发币K线数据
     * @return 自发币K线数据集合
     */
    public List<TKlineData> selectTKlineDataList(TKlineData tKlineData);

    /**
     * 新增自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    public int insertTKlineData(TKlineData tKlineData);

    /**
     * 修改自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    public int updateTKlineData(TKlineData tKlineData);

    /**
     * 批量删除自发币K线数据
     * 
     * @param ids 需要删除的自发币K线数据主键集合
     * @return 结果
     */
    public int deleteTKlineDataByIds(Long[] ids);

    /**
     * 删除自发币K线数据信息
     * 
     * @param id 自发币K线数据主键
     * @return 结果
     */
    public int deleteTKlineDataById(Long id);

    AjaxResult batch(BatchData batchData);
}
