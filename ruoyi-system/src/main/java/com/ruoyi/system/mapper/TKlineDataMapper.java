package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.kline.TKlineData;
import org.apache.ibatis.annotations.Param;

/**
 * 自发币K线数据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface TKlineDataMapper 
{
    /**
     * 查询自发币K线数据
     * 
     * @param id 自发币K线数据主键
     * @return 自发币K线数据
     */
    public TKlineData selectTKlineDataById(Long id);

    /**
     * 查询自发币K线数据列表
     * 
     * @param tKlineData 自发币K线数据
     * @return 自发币K线数据集合
     */
    public List<TKlineData> selectTKlineDataList(TKlineData tKlineData);

    /**
     * 新增自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    public int insertTKlineData(TKlineData tKlineData);

    /**
     * 修改自发币K线数据
     * 
     * @param tKlineData 自发币K线数据
     * @return 结果
     */
    public int updateTKlineData(TKlineData tKlineData);

    /**
     * 删除自发币K线数据
     * 
     * @param id 自发币K线数据主键
     * @return 结果
     */
    public int deleteTKlineDataById(Long id);

    /**
     * 批量删除自发币K线数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTKlineDataByIds(Long[] ids);
    public int delete(String tokenCur);

    TKlineData findByTokenCur(Object tokenCur);

    int updateObj(@Param("tokenCur") Object tokenCur,
                  @Param("key") Object key,
                  @Param("val") Object val);
}
