package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.kline.TStagePrice;
import org.apache.ibatis.annotations.Param;

/**
 * 自发币时间阶段价格Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface TStagePriceMapper 
{
    /**
     * 查询自发币时间阶段价格
     * 
     * @param id 自发币时间阶段价格主键
     * @return 自发币时间阶段价格
     */
    public TStagePrice selectTStagePriceById(Long id);

    /**
     * 查询自发币时间阶段价格列表
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 自发币时间阶段价格集合
     */
    public List<TStagePrice> selectTStagePriceList(TStagePrice tStagePrice);

    /**
     * 新增自发币时间阶段价格
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 结果
     */
    public int insertTStagePrice(TStagePrice tStagePrice);

    /**
     * 修改自发币时间阶段价格
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 结果
     */
    public int updateTStagePrice(TStagePrice tStagePrice);

    /**
     * 删除自发币时间阶段价格
     * 
     * @param id 自发币时间阶段价格主键
     * @return 结果
     */
    public int deleteTStagePriceById(Long id);

    /**
     * 批量删除自发币时间阶段价格
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTStagePriceByIds(Long[] ids);
    public int delete(String tokenCur);

    TStagePrice findByTokenCur(Object tokenCur);

    int updateObj(@Param("tokenCur") Object tokenCur,
                  @Param("key") Object key,
                  @Param("val") Object val,
                  @Param("list") List<Long> list);
    int updateObj2(@Param("tokenCur") Object tokenCur,
                  @Param("key") Object key,
                  @Param("val") Object val,
                  @Param("time") Object time);
}
