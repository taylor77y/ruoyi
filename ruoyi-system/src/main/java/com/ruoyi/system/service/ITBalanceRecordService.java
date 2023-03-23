package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TBalanceRecord;

/**
 * 资金记录Service接口
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
public interface ITBalanceRecordService 
{
    /**
     * 查询资金记录
     * 
     * @param id 资金记录主键
     * @return 资金记录
     */
    public TBalanceRecord selectTBalanceRecordById(Long id);

    /**
     * 查询资金记录列表
     * 
     * @param tBalanceRecord 资金记录
     * @return 资金记录集合
     */
    public List<TBalanceRecord> selectTBalanceRecordList(TBalanceRecord tBalanceRecord);

    /**
     * 新增资金记录
     * 
     * @param tBalanceRecord 资金记录
     * @return 结果
     */
    public int insertTBalanceRecord(TBalanceRecord tBalanceRecord);

    /**
     * 修改资金记录
     * 
     * @param tBalanceRecord 资金记录
     * @return 结果
     */
    public int updateTBalanceRecord(TBalanceRecord tBalanceRecord);

    /**
     * 批量删除资金记录
     * 
     * @param ids 需要删除的资金记录主键集合
     * @return 结果
     */
    public int deleteTBalanceRecordByIds(Long[] ids);

    /**
     * 删除资金记录信息
     * 
     * @param id 资金记录主键
     * @return 结果
     */
    public int deleteTBalanceRecordById(Long id);
}
