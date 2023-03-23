package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TFabiDayRecord;

/**
 * 法币交易统计Service接口
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public interface ITFabiDayRecordService 
{
    /**
     * 查询法币交易统计
     * 
     * @param id 法币交易统计主键
     * @return 法币交易统计
     */
    public TFabiDayRecord selectTFabiDayRecordById(Long id);

    /**
     * 查询法币交易统计列表
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 法币交易统计集合
     */
    public List<TFabiDayRecord> selectTFabiDayRecordList(TFabiDayRecord tFabiDayRecord);

    /**
     * 新增法币交易统计
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 结果
     */
    public int insertTFabiDayRecord(TFabiDayRecord tFabiDayRecord);

    /**
     * 修改法币交易统计
     * 
     * @param tFabiDayRecord 法币交易统计
     * @return 结果
     */
    public int updateTFabiDayRecord(TFabiDayRecord tFabiDayRecord);

    /**
     * 批量删除法币交易统计
     * 
     * @param ids 需要删除的法币交易统计主键集合
     * @return 结果
     */
    public int deleteTFabiDayRecordByIds(Long[] ids);

    /**
     * 删除法币交易统计信息
     * 
     * @param id 法币交易统计主键
     * @return 结果
     */
    public int deleteTFabiDayRecordById(Long id);
}
