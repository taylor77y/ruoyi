package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TDepositHistory;

/**
 * 充币记录Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITDepositHistoryService 
{
    /**
     * 查询充币记录
     * 
     * @param id 充币记录主键
     * @return 充币记录
     */
    public TDepositHistory selectTDepositHistoryById(String id);

    /**
     * 查询充币记录列表
     * 
     * @param tDepositHistory 充币记录
     * @return 充币记录集合
     */
    public List<TDepositHistory> selectTDepositHistoryList(TDepositHistory tDepositHistory);

    /**
     * 新增充币记录
     * 
     * @param tDepositHistory 充币记录
     * @return 结果
     */
    public int insertTDepositHistory(TDepositHistory tDepositHistory);

    /**
     * 修改充币记录
     * 
     * @param tDepositHistory 充币记录
     * @return 结果
     */
    public int updateTDepositHistory(TDepositHistory tDepositHistory);

    /**
     * 批量删除充币记录
     * 
     * @param ids 需要删除的充币记录主键集合
     * @return 结果
     */
    public int deleteTDepositHistoryByIds(String[] ids);

    /**
     * 删除充币记录信息
     * 
     * @param id 充币记录主键
     * @return 结果
     */
    public int deleteTDepositHistoryById(String id);
}
