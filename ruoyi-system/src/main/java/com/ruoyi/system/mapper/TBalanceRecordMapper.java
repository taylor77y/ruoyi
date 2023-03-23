package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBalanceRecord;

/**
 * 资金记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
public interface TBalanceRecordMapper 
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
     * 删除资金记录
     * 
     * @param id 资金记录主键
     * @return 结果
     */
    public int deleteTBalanceRecordById(Long id);

    /**
     * 批量删除资金记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBalanceRecordByIds(Long[] ids);
}
