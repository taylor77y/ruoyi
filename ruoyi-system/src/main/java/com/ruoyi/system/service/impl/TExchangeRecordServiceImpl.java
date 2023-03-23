package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TExchangeRecordMapper;
import com.ruoyi.system.domain.TExchangeRecord;
import com.ruoyi.system.service.ITExchangeRecordService;

/**
 * 币币兑换记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-25
 */
@Service
public class TExchangeRecordServiceImpl implements ITExchangeRecordService 
{
    @Autowired
    private TExchangeRecordMapper tExchangeRecordMapper;

    /**
     * 查询币币兑换记录
     * 
     * @param id 币币兑换记录主键
     * @return 币币兑换记录
     */
    @Override
    public TExchangeRecord selectTExchangeRecordById(Long id)
    {
        return tExchangeRecordMapper.selectTExchangeRecordById(id);
    }

    /**
     * 查询币币兑换记录列表
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 币币兑换记录
     */
    @Override
    public List<TExchangeRecord> selectTExchangeRecordList(TExchangeRecord tExchangeRecord)
    {
        return tExchangeRecordMapper.selectTExchangeRecordList(tExchangeRecord);
    }

    /**
     * 新增币币兑换记录
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 结果
     */
    @Override
    public int insertTExchangeRecord(TExchangeRecord tExchangeRecord)
    {
        tExchangeRecord.setCreateTime(DateUtils.getNowDate());
        return tExchangeRecordMapper.insertTExchangeRecord(tExchangeRecord);
    }

    /**
     * 修改币币兑换记录
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 结果
     */
    @Override
    public int updateTExchangeRecord(TExchangeRecord tExchangeRecord)
    {
        return tExchangeRecordMapper.updateTExchangeRecord(tExchangeRecord);
    }

    /**
     * 批量删除币币兑换记录
     * 
     * @param ids 需要删除的币币兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteTExchangeRecordByIds(Long[] ids)
    {
        return tExchangeRecordMapper.deleteTExchangeRecordByIds(ids);
    }

    /**
     * 删除币币兑换记录信息
     * 
     * @param id 币币兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteTExchangeRecordById(Long id)
    {
        return tExchangeRecordMapper.deleteTExchangeRecordById(id);
    }
}
