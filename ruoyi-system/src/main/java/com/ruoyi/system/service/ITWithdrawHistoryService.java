package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TWithdrawHistory;

/**
 * 提币记录Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITWithdrawHistoryService 
{
    /**
     * 查询提币记录
     * 
     * @param id 提币记录主键
     * @return 提币记录
     */
    public TWithdrawHistory selectTWithdrawHistoryById(String id);

    /**
     * 查询提币记录列表
     * 
     * @param tWithdrawHistory 提币记录
     * @return 提币记录集合
     */
    public List<TWithdrawHistory> selectTWithdrawHistoryList(TWithdrawHistory tWithdrawHistory);

    /**
     * 新增提币记录
     * 
     * @param tWithdrawHistory 提币记录
     * @return 结果
     */
    public int insertTWithdrawHistory(TWithdrawHistory tWithdrawHistory);

    /**
     * 修改提币记录
     * 
     * @param tWithdrawHistory 提币记录
     * @return 结果
     */
    public int updateTWithdrawHistory(TWithdrawHistory tWithdrawHistory);

    /**
     * 批量删除提币记录
     * 
     * @param ids 需要删除的提币记录主键集合
     * @return 结果
     */
    public int deleteTWithdrawHistoryByIds(String[] ids);

    /**
     * 删除提币记录信息
     * 
     * @param id 提币记录主键
     * @return 结果
     */
    public int deleteTWithdrawHistoryById(String id);
}
