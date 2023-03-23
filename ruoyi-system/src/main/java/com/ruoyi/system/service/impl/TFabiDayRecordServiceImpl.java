package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TFabiDayRecordMapper;
import com.ruoyi.system.domain.TFabiDayRecord;
import com.ruoyi.system.service.ITFabiDayRecordService;

/**
 * 法币交易统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@Service
public class TFabiDayRecordServiceImpl implements ITFabiDayRecordService 
{
    @Autowired
    private TFabiDayRecordMapper tFabiDayRecordMapper;

    /**
     * 查询法币交易统计
     * 
     * @param id 法币交易统计主键
     * @return 法币交易统计
     */
    @Override
    public TFabiDayRecord selectTFabiDayRecordById(Long id)
    {
        return tFabiDayRecordMapper.selectTFabiDayRecordById(id);
    }

    /**
     * 查询法币交易统计列表
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 法币交易统计
     */
    @Override
    public List<TFabiDayRecord> selectTFabiDayRecordList(TFabiDayRecord tFabiDayRecord)
    {
        return tFabiDayRecordMapper.selectTFabiDayRecordList(tFabiDayRecord);
    }

    /**
     * 新增法币交易统计
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 结果
     */
    @Override
    public int insertTFabiDayRecord(TFabiDayRecord tFabiDayRecord)
    {
        tFabiDayRecord.setCreateTime(DateUtils.getNowDate());
        return tFabiDayRecordMapper.insertTFabiDayRecord(tFabiDayRecord);
    }

    /**
     * 修改法币交易统计
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 结果
     */
    @Override
    public int updateTFabiDayRecord(TFabiDayRecord tFabiDayRecord)
    {
        return tFabiDayRecordMapper.updateTFabiDayRecord(tFabiDayRecord);
    }

    /**
     * 批量删除法币交易统计
     * 
     * @param ids 需要删除的法币交易统计主键
     * @return 结果
     */
    @Override
    public int deleteTFabiDayRecordByIds(Long[] ids)
    {
        return tFabiDayRecordMapper.deleteTFabiDayRecordByIds(ids);
    }

    /**
     * 删除法币交易统计信息
     * 
     * @param id 法币交易统计主键
     * @return 结果
     */
    @Override
    public int deleteTFabiDayRecordById(Long id)
    {
        return tFabiDayRecordMapper.deleteTFabiDayRecordById(id);
    }
}
