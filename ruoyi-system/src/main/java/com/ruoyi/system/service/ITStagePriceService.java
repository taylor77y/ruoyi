package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TStagePrice;

/**
 * 自发币时间阶段价格Service接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface ITStagePriceService 
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
     * 批量删除自发币时间阶段价格
     * 
     * @param ids 需要删除的自发币时间阶段价格主键集合
     * @return 结果
     */
    public int deleteTStagePriceByIds(Long[] ids);

    /**
     * 删除自发币时间阶段价格信息
     * 
     * @param id 自发币时间阶段价格主键
     * @return 结果
     */
    public int deleteTStagePriceById(Long id);

    AjaxResult batch(BatchData batchData);

    AjaxResult batch2(BatchData batchData);
}
