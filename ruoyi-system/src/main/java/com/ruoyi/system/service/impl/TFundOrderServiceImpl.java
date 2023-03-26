package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.params.TFundOrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TFundOrderMapper;
import com.ruoyi.system.domain.TFundOrder;
import com.ruoyi.system.service.ITFundOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TFundOrderServiceImpl implements ITFundOrderService {
    @Autowired
    private TFundOrderMapper tFundOrderMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TFundOrder selectTFundOrderById(Long id) {
        return tFundOrderMapper.selectTFundOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tFundOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TFundOrder> selectTFundOrderList(TFundOrder tFundOrder) {
        return tFundOrderMapper.selectTFundOrderList(tFundOrder);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tFundOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTFundOrder(TFundOrder tFundOrder) {
        tFundOrder.setCreateTime(DateUtils.getNowDate());
        return tFundOrderMapper.insertTFundOrder(tFundOrder);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tFundOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTFundOrder(TFundOrder tFundOrder) {
        tFundOrder.setUpdateTime(DateUtils.getNowDate());
        return tFundOrderMapper.updateTFundOrder(tFundOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTFundOrderByIds(Long[] ids) {
        return tFundOrderMapper.deleteTFundOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTFundOrderById(Long id) {
        return tFundOrderMapper.deleteTFundOrderById(id);
    }

    @Override
    public List<TFundOrder> selectTFundOrderListByParam(TFundOrderParam tFundOrderParam) {
        return tFundOrderMapper.selectTFundOrderListByParam(tFundOrderParam);
    }
}
