package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TEntrustHistoryMapper;
import com.ruoyi.system.domain.TEntrustHistory;
import com.ruoyi.system.service.ITEntrustHistoryService;

/**
 * 历史委托记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TEntrustHistoryServiceImpl implements ITEntrustHistoryService 
{
    @Autowired
    private TEntrustHistoryMapper tEntrustHistoryMapper;

    /**
     * 查询历史委托记录
     * 
     * @param id 历史委托记录主键
     * @return 历史委托记录
     */
    @Override
    public TEntrustHistory selectTEntrustHistoryById(String id)
    {
        return tEntrustHistoryMapper.selectTEntrustHistoryById(id);
    }

    /**
     * 查询历史委托记录列表
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 历史委托记录
     */
    @Override
    public List<TEntrustHistory> selectTEntrustHistoryList(TEntrustHistory tEntrustHistory)
    {
        return tEntrustHistoryMapper.selectTEntrustHistoryList(tEntrustHistory);
    }

    /**
     * 新增历史委托记录
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 结果
     */
    @Override
    public int insertTEntrustHistory(TEntrustHistory tEntrustHistory)
    {
        tEntrustHistory.setCreateTime(DateUtils.getNowDate());
        return tEntrustHistoryMapper.insertTEntrustHistory(tEntrustHistory);
    }

    /**
     * 修改历史委托记录
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 结果
     */
    @Override
    public int updateTEntrustHistory(TEntrustHistory tEntrustHistory)
    {
        tEntrustHistory.setUpdateTime(DateUtils.getNowDate());
        return tEntrustHistoryMapper.updateTEntrustHistory(tEntrustHistory);
    }

    /**
     * 批量删除历史委托记录
     * 
     * @param ids 需要删除的历史委托记录主键
     * @return 结果
     */
    @Override
    public int deleteTEntrustHistoryByIds(String[] ids)
    {
        return tEntrustHistoryMapper.deleteTEntrustHistoryByIds(ids);
    }

    /**
     * 删除历史委托记录信息
     * 
     * @param id 历史委托记录主键
     * @return 结果
     */
    @Override
    public int deleteTEntrustHistoryById(String id)
    {
        return tEntrustHistoryMapper.deleteTEntrustHistoryById(id);
    }
}
