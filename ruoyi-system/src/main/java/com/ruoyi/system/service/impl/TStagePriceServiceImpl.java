package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TKlineData;
import com.ruoyi.system.domain.kline.TStagePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TStagePriceMapper;
import com.ruoyi.system.service.ITStagePriceService;

/**
 * 自发币时间阶段价格Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@Service
public class TStagePriceServiceImpl implements ITStagePriceService 
{
    @Autowired
    private TStagePriceMapper tStagePriceMapper;

    /**
     * 查询自发币时间阶段价格
     * 
     * @param id 自发币时间阶段价格主键
     * @return 自发币时间阶段价格
     */
    @Override
    public TStagePrice selectTStagePriceById(Long id)
    {
        return tStagePriceMapper.selectTStagePriceById(id);
    }

    /**
     * 查询自发币时间阶段价格列表
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 自发币时间阶段价格
     */
    @Override
    public List<TStagePrice> selectTStagePriceList(TStagePrice tStagePrice)
    {
        return tStagePriceMapper.selectTStagePriceList(tStagePrice);
    }

    /**
     * 新增自发币时间阶段价格
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 结果
     */
    @Override
    public int insertTStagePrice(TStagePrice tStagePrice)
    {
        tStagePrice.setCreateTime(DateUtils.getNowDate());
        return tStagePriceMapper.insertTStagePrice(tStagePrice);
    }

    /**
     * 修改自发币时间阶段价格
     * 
     * @param tStagePrice 自发币时间阶段价格
     * @return 结果
     */
    @Override
    public int updateTStagePrice(TStagePrice tStagePrice)
    {
        return tStagePriceMapper.updateTStagePrice(tStagePrice);
    }

    /**
     * 批量删除自发币时间阶段价格
     * 
     * @param ids 需要删除的自发币时间阶段价格主键
     * @return 结果
     */
    @Override
    public int deleteTStagePriceByIds(Long[] ids)
    {
        return tStagePriceMapper.deleteTStagePriceByIds(ids);
    }

    /**
     * 删除自发币时间阶段价格信息
     * 
     * @param id 自发币时间阶段价格主键
     * @return 结果
     */
    @Override
    public int deleteTStagePriceById(Long id)
    {
        return tStagePriceMapper.deleteTStagePriceById(id);
    }

    @Override
    public AjaxResult batch(BatchData batchData) {
        System.err.println(batchData);
        TStagePrice tStagePrice = tStagePriceMapper.findByTokenCur(batchData.getName());
        if (tStagePrice == null) return AjaxResult.error("币名称不存在");
        int rows = tStagePriceMapper.updateObj(batchData.getName(),batchData.getType(),batchData.getVal(),batchData.getList());
        return rows > 0 ? AjaxResult.success() : AjaxResult.error("暂无可修改内容");
    }

    @Override
    public AjaxResult batch2(BatchData batchData) {
        TStagePrice tStagePrice = tStagePriceMapper.findByTokenCur(batchData.getName());
        if (tStagePrice == null) return AjaxResult.error("币名称不存在");
        int rows = tStagePriceMapper.updateObj2(batchData.getName(),batchData.getType(),batchData.getVal(),batchData.getTime());
        return rows > 0 ? AjaxResult.success() : AjaxResult.error("暂无可修改内容");
    }
}
