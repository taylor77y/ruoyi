package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.params.TSmartPoolOrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSmartPoolOrderMapper;
import com.ruoyi.system.domain.TSmartPoolOrder;
import com.ruoyi.system.service.ITSmartPoolOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TSmartPoolOrderServiceImpl implements ITSmartPoolOrderService 
{
    @Autowired
    private TSmartPoolOrderMapper tSmartPoolOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TSmartPoolOrder selectTSmartPoolOrderById(Long id)
    {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TSmartPoolOrder> selectTSmartPoolOrderList(TSmartPoolOrder tSmartPoolOrder)
    {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderList(tSmartPoolOrder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder)
    {
        tSmartPoolOrder.setCreateTime(DateUtils.getNowDate());
        return tSmartPoolOrderMapper.insertTSmartPoolOrder(tSmartPoolOrder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tSmartPoolOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTSmartPoolOrder(TSmartPoolOrder tSmartPoolOrder)
    {
        tSmartPoolOrder.setUpdateTime(DateUtils.getNowDate());
        return tSmartPoolOrderMapper.updateTSmartPoolOrder(tSmartPoolOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolOrderByIds(Long[] ids)
    {
        return tSmartPoolOrderMapper.deleteTSmartPoolOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTSmartPoolOrderById(Long id)
    {
        return tSmartPoolOrderMapper.deleteTSmartPoolOrderById(id);
    }

    @Override
    public List<TSmartPoolOrder> selectTSmartPoolOrderListByParam(TSmartPoolOrderParam tSmartPoolOrderParam) {
        return tSmartPoolOrderMapper.selectTSmartPoolOrderListByParam(tSmartPoolOrderParam);
    }
}
