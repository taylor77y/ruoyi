package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TWithdrawHistoryMapper;
import com.ruoyi.system.domain.TWithdrawHistory;
import com.ruoyi.system.service.ITWithdrawHistoryService;

/**
 * 提币记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TWithdrawHistoryServiceImpl implements ITWithdrawHistoryService 
{
    @Autowired
    private TWithdrawHistoryMapper tWithdrawHistoryMapper;

    /**
     * 查询提币记录
     * 
     * @param id 提币记录主键
     * @return 提币记录
     */
    @Override
    public TWithdrawHistory selectTWithdrawHistoryById(String id)
    {
        return tWithdrawHistoryMapper.selectTWithdrawHistoryById(id);
    }

    /**
     * 查询提币记录列表
     * 
     * @param tWithdrawHistory 提币记录
     * @return 提币记录
     */
    @Override
    public List<TWithdrawHistory> selectTWithdrawHistoryList(TWithdrawHistory tWithdrawHistory)
    {
        return tWithdrawHistoryMapper.selectTWithdrawHistoryList(tWithdrawHistory);
    }

    /**
     * 新增提币记录
     * 
     * @param tWithdrawHistory 提币记录
     * @return 结果
     */
    @Override
    public int insertTWithdrawHistory(TWithdrawHistory tWithdrawHistory)
    {
        tWithdrawHistory.setCreateTime(DateUtils.getNowDate());
        return tWithdrawHistoryMapper.insertTWithdrawHistory(tWithdrawHistory);
    }

    /**
     * 修改提币记录
     * 
     * @param tWithdrawHistory 提币记录
     * @return 结果
     */
    @Override
    public int updateTWithdrawHistory(TWithdrawHistory tWithdrawHistory)
    {
        return tWithdrawHistoryMapper.updateTWithdrawHistory(tWithdrawHistory);
    }

    /**
     * 批量删除提币记录
     * 
     * @param ids 需要删除的提币记录主键
     * @return 结果
     */
    @Override
    public int deleteTWithdrawHistoryByIds(String[] ids)
    {
        return tWithdrawHistoryMapper.deleteTWithdrawHistoryByIds(ids);
    }

    /**
     * 删除提币记录信息
     * 
     * @param id 提币记录主键
     * @return 结果
     */
    @Override
    public int deleteTWithdrawHistoryById(String id)
    {
        return tWithdrawHistoryMapper.deleteTWithdrawHistoryById(id);
    }
}
