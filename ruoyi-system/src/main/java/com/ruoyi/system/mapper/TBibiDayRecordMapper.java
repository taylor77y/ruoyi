package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBibiDayRecord;

/**
 * 币种交易量Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public interface TBibiDayRecordMapper 
{
    /**
     * 查询币种交易量
     * 
     * @param id 币种交易量主键
     * @return 币种交易量
     */
    public TBibiDayRecord selectTBibiDayRecordById(Long id);

    /**
     * 查询币种交易量列表
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 币种交易量集合
     */
    public List<TBibiDayRecord> selectTBibiDayRecordList(TBibiDayRecord tBibiDayRecord);

    /**
     * 新增币种交易量
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 结果
     */
    public int insertTBibiDayRecord(TBibiDayRecord tBibiDayRecord);

    /**
     * 修改币种交易量
     * 
     * @param tBibiDayRecord 币种交易量
     * @return 结果
     */
    public int updateTBibiDayRecord(TBibiDayRecord tBibiDayRecord);

    /**
     * 删除币种交易量
     * 
     * @param id 币种交易量主键
     * @return 结果
     */
    public int deleteTBibiDayRecordById(Long id);

    /**
     * 批量删除币种交易量
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBibiDayRecordByIds(Long[] ids);
}
