package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.kline.TCurrencyControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TCurrencyControlsMapper;
import com.ruoyi.system.service.ITCurrencyControlsService;

/**
 * 自发币控制Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@Service
public class TCurrencyControlsServiceImpl implements ITCurrencyControlsService 
{
    @Autowired
    private TCurrencyControlsMapper tCurrencyControlsMapper;

    /**
     * 查询自发币控制
     * 
     * @param id 自发币控制主键
     * @return 自发币控制
     */
    @Override
    public TCurrencyControls selectTCurrencyControlsById(Long id)
    {
        return tCurrencyControlsMapper.selectTCurrencyControlsById(id);
    }

    /**
     * 查询自发币控制列表
     * 
     * @param tCurrencyControls 自发币控制
     * @return 自发币控制
     */
    @Override
    public List<TCurrencyControls> selectTCurrencyControlsList(TCurrencyControls tCurrencyControls)
    {
        return tCurrencyControlsMapper.selectTCurrencyControlsList(tCurrencyControls);
    }

    /**
     * 新增自发币控制
     * 
     * @param tCurrencyControls 自发币控制
     * @return 结果
     */
    @Override
    public int insertTCurrencyControls(TCurrencyControls tCurrencyControls)
    {
        tCurrencyControls.setCreateTime(DateUtils.getNowDate());
        return tCurrencyControlsMapper.insertTCurrencyControls(tCurrencyControls);
    }

    /**
     * 修改自发币控制
     * 
     * @param tCurrencyControls 自发币控制
     * @return 结果
     */
    @Override
    public int updateTCurrencyControls(TCurrencyControls tCurrencyControls)
    {
        tCurrencyControls.setUpdateTime(DateUtils.getNowDate());
        return tCurrencyControlsMapper.updateTCurrencyControls(tCurrencyControls);
    }

    /**
     * 批量删除自发币控制
     * 
     * @param ids 需要删除的自发币控制主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencyControlsByIds(Long[] ids)
    {
        return tCurrencyControlsMapper.deleteTCurrencyControlsByIds(ids);
    }

    /**
     * 删除自发币控制信息
     * 
     * @param id 自发币控制主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencyControlsById(Long id)
    {
        return tCurrencyControlsMapper.deleteTCurrencyControlsById(id);
    }
}
