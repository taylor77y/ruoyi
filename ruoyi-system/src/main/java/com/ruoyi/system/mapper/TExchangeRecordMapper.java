package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TExchangeRecord;

/**
 * 币币兑换记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-25
 */
public interface TExchangeRecordMapper 
{
    /**
     * 查询币币兑换记录
     * 
     * @param id 币币兑换记录主键
     * @return 币币兑换记录
     */
    public TExchangeRecord selectTExchangeRecordById(Long id);

    /**
     * 查询币币兑换记录列表
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 币币兑换记录集合
     */
    public List<TExchangeRecord> selectTExchangeRecordList(TExchangeRecord tExchangeRecord);

    /**
     * 新增币币兑换记录
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 结果
     */
    public int insertTExchangeRecord(TExchangeRecord tExchangeRecord);

    /**
     * 修改币币兑换记录
     * 
     * @param tExchangeRecord 币币兑换记录
     * @return 结果
     */
    public int updateTExchangeRecord(TExchangeRecord tExchangeRecord);

    /**
     * 删除币币兑换记录
     * 
     * @param id 币币兑换记录主键
     * @return 结果
     */
    public int deleteTExchangeRecordById(Long id);

    /**
     * 批量删除币币兑换记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTExchangeRecordByIds(Long[] ids);
}
