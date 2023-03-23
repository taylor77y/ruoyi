package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBibiDayRecordMapper;
import com.ruoyi.system.domain.TBibiDayRecord;
import com.ruoyi.system.service.ITBibiDayRecordService;

/**
 * 币种交易量Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@Service
public class TBibiDayRecordServiceImpl implements ITBibiDayRecordService 
{
    @Autowired
    private TBibiDayRecordMapper tBibiDayRecordMapper;

    /**
     * 查询币种交易量
     * 
     * @param id 币种交易量主键
     * @return 币种交易量
     */
    @Override
    public TBibiDayRecord selectTBibiDayRecordById(Long id)
    {
        return tBibiDayRecordMapper.selectTBibiDayRecordById(id);
    }

    /**
     * 查询币种交易量列表
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 币种交易量
     */
    @Override
    public List<TBibiDayRecord> selectTBibiDayRecordList(TBibiDayRecord tBibiDayRecord)
    {
        return tBibiDayRecordMapper.selectTBibiDayRecordList(tBibiDayRecord);
    }

    /**
     * 新增币种交易量
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 结果
     */
    @Override
    public int insertTBibiDayRecord(TBibiDayRecord tBibiDayRecord)
    {
        tBibiDayRecord.setCreateTime(DateUtils.getNowDate());
        return tBibiDayRecordMapper.insertTBibiDayRecord(tBibiDayRecord);
    }

    /**
     * 修改币种交易量
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 结果
     */
    @Override
    public int updateTBibiDayRecord(TBibiDayRecord tBibiDayRecord)
    {
        return tBibiDayRecordMapper.updateTBibiDayRecord(tBibiDayRecord);
    }

    /**
     * 批量删除币种交易量
     * 
     * @param ids 需要删除的币种交易量主键
     * @return 结果
     */
    @Override
    public int deleteTBibiDayRecordByIds(Long[] ids)
    {
        return tBibiDayRecordMapper.deleteTBibiDayRecordByIds(ids);
    }

    /**
     * 删除币种交易量信息
     * 
     * @param id 币种交易量主键
     * @return 结果
     */
    @Override
    public int deleteTBibiDayRecordById(Long id)
    {
        return tBibiDayRecordMapper.deleteTBibiDayRecordById(id);
    }
}
