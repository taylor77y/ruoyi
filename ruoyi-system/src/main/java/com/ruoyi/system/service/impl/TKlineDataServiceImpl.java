package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TKlineData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TKlineDataMapper;
import com.ruoyi.system.service.ITKlineDataService;

import javax.security.auth.kerberos.KerberosKey;

/**
 * 自发币K线数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@Service
public class TKlineDataServiceImpl implements ITKlineDataService 
{
    @Autowired
    private TKlineDataMapper tKlineDataMapper;

    /**
     * 查询自发币K线数据
     * 
     * @param id 自发币K线数据主键
     * @return 自发币K线数据
     */
    @Override
    public TKlineData selectTKlineDataById(Long id)
    {
        return tKlineDataMapper.selectTKlineDataById(id);
    }

    /**
     * 查询自发币K线数据列表
     * 
     * @param tKlineData 自发币K线数据
     * @return 自发币K线数据
     */
    @Override
    public List<TKlineData> selectTKlineDataList(TKlineData tKlineData)
    {
        return tKlineDataMapper.selectTKlineDataList(tKlineData);
    }

    /**
     * 新增自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    @Override
    public int insertTKlineData(TKlineData tKlineData)
    {
        tKlineData.setCreateTime(DateUtils.getNowDate());
        return tKlineDataMapper.insertTKlineData(tKlineData);
    }

    /**
     * 修改自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    @Override
    public int updateTKlineData(TKlineData tKlineData)
    {
        return tKlineDataMapper.updateTKlineData(tKlineData);
    }

    /**
     * 批量删除自发币K线数据
     * 
     * @param ids 需要删除的自发币K线数据主键
     * @return 结果
     */
    @Override
    public int deleteTKlineDataByIds(Long[] ids)
    {
        return tKlineDataMapper.deleteTKlineDataByIds(ids);
    }

    /**
     * 删除自发币K线数据信息
     * 
     * @param id 自发币K线数据主键
     * @return 结果
     */
    @Override
    public int deleteTKlineDataById(Long id)
    {
        return tKlineDataMapper.deleteTKlineDataById(id);
    }

    @Override
    public AjaxResult batch(BatchData batchData) {

        TKlineData tKlineData = tKlineDataMapper.findByTokenCur(batchData.getName());
        if (tKlineData == null) return AjaxResult.error("币名称不存在");
        int rows = tKlineDataMapper.updateObj(batchData.getName(),batchData.getType(),batchData.getVal());
        return rows > 0 ? AjaxResult.success() : AjaxResult.error("暂无可修改内容");
    }
}
