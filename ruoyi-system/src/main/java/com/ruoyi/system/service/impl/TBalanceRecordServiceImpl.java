package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBalanceRecordMapper;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.service.ITBalanceRecordService;

/**
 * 资金记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
@Service
public class TBalanceRecordServiceImpl implements ITBalanceRecordService 
{
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;

    /**
     * 查询资金记录
     * 
     * @param id 资金记录主键
     * @return 资金记录
     */
    @Override
    public TBalanceRecord selectTBalanceRecordById(Long id)
    {
        return tBalanceRecordMapper.selectTBalanceRecordById(id);
    }

    /**
     * 查询资金记录列表
     * 
     * @param tBalanceRecord 资金记录
     * @return 资金记录
     */
    @Override
    public List<TBalanceRecord> selectTBalanceRecordList(TBalanceRecord tBalanceRecord)
    {
        return tBalanceRecordMapper.selectTBalanceRecordList(tBalanceRecord);
    }

    /**
     * 新增资金记录
     * 
     * @param tBalanceRecord 资金记录
     * @return 结果
     */
    @Override
    public int insertTBalanceRecord(TBalanceRecord tBalanceRecord)
    {
        tBalanceRecord.setCreateTime(DateUtils.getNowDate());
        return tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
    }

    /**
     * 修改资金记录
     * 
     * @param tBalanceRecord 资金记录
     * @return 结果
     */
    @Override
    public int updateTBalanceRecord(TBalanceRecord tBalanceRecord)
    {
        return tBalanceRecordMapper.updateTBalanceRecord(tBalanceRecord);
    }

    /**
     * 批量删除资金记录
     * 
     * @param ids 需要删除的资金记录主键
     * @return 结果
     */
    @Override
    public int deleteTBalanceRecordByIds(Long[] ids)
    {
        return tBalanceRecordMapper.deleteTBalanceRecordByIds(ids);
    }

    /**
     * 删除资金记录信息
     * 
     * @param id 资金记录主键
     * @return 结果
     */
    @Override
    public int deleteTBalanceRecordById(Long id)
    {
        return tBalanceRecordMapper.deleteTBalanceRecordById(id);
    }
}
