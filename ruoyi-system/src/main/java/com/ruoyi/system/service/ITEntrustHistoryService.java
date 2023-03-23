package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TEntrustHistory;

/**
 * 历史委托记录Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITEntrustHistoryService 
{
    /**
     * 查询历史委托记录
     * 
     * @param id 历史委托记录主键
     * @return 历史委托记录
     */
    public TEntrustHistory selectTEntrustHistoryById(String id);

    /**
     * 查询历史委托记录列表
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 历史委托记录集合
     */
    public List<TEntrustHistory> selectTEntrustHistoryList(TEntrustHistory tEntrustHistory);

    /**
     * 新增历史委托记录
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 结果
     */
    public int insertTEntrustHistory(TEntrustHistory tEntrustHistory);

    /**
     * 修改历史委托记录
     * 
     * @param tEntrustHistory 历史委托记录
     * @return 结果
     */
    public int updateTEntrustHistory(TEntrustHistory tEntrustHistory);

    /**
     * 批量删除历史委托记录
     * 
     * @param ids 需要删除的历史委托记录主键集合
     * @return 结果
     */
    public int deleteTEntrustHistoryByIds(String[] ids);

    /**
     * 删除历史委托记录信息
     * 
     * @param id 历史委托记录主键
     * @return 结果
     */
    public int deleteTEntrustHistoryById(String id);
}
