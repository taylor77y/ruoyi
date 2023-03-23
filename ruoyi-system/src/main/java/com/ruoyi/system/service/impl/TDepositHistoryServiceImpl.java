package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TDepositHistoryMapper;
import com.ruoyi.system.domain.TDepositHistory;
import com.ruoyi.system.service.ITDepositHistoryService;

/**
 * 充币记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TDepositHistoryServiceImpl implements ITDepositHistoryService 
{
    @Autowired
    private TDepositHistoryMapper tDepositHistoryMapper;

    /**
     * 查询充币记录
     * 
     * @param id 充币记录主键
     * @return 充币记录
     */
    @Override
    public TDepositHistory selectTDepositHistoryById(String id)
    {
        return tDepositHistoryMapper.selectTDepositHistoryById(id);
    }

    /**
     * 查询充币记录列表
     * 
     * @param tDepositHistory 充币记录
     * @return 充币记录
     */
    @Override
    public List<TDepositHistory> selectTDepositHistoryList(TDepositHistory tDepositHistory)
    {
        return tDepositHistoryMapper.selectTDepositHistoryList(tDepositHistory);
    }

    /**
     * 新增充币记录
     * 
     * @param tDepositHistory 充币记录
     * @return 结果
     */
    @Override
    public int insertTDepositHistory(TDepositHistory tDepositHistory)
    {
        tDepositHistory.setCreateTime(DateUtils.getNowDate());
        return tDepositHistoryMapper.insertTDepositHistory(tDepositHistory);
    }

    /**
     * 修改充币记录
     * 
     * @param tDepositHistory 充币记录
     * @return 结果
     */
    @Override
    public int updateTDepositHistory(TDepositHistory tDepositHistory)
    {
        return tDepositHistoryMapper.updateTDepositHistory(tDepositHistory);
    }

    /**
     * 批量删除充币记录
     * 
     * @param ids 需要删除的充币记录主键
     * @return 结果
     */
    @Override
    public int deleteTDepositHistoryByIds(String[] ids)
    {
        return tDepositHistoryMapper.deleteTDepositHistoryByIds(ids);
    }

    /**
     * 删除充币记录信息
     * 
     * @param id 充币记录主键
     * @return 结果
     */
    @Override
    public int deleteTDepositHistoryById(String id)
    {
        return tDepositHistoryMapper.deleteTDepositHistoryById(id);
    }
}
