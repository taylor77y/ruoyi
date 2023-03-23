package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AmountChangeMapper;
import com.ruoyi.system.domain.AmountChange;
import com.ruoyi.system.service.IAmountChangeService;

/**
 * 资金变更记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class AmountChangeServiceImpl implements IAmountChangeService 
{
    @Autowired
    private AmountChangeMapper amountChangeMapper;

    /**
     * 查询资金变更记录
     * 
     * @param id 资金变更记录主键
     * @return 资金变更记录
     */
    @Override
    public AmountChange selectAmountChangeById(Long id)
    {
        return amountChangeMapper.selectAmountChangeById(id);
    }

    /**
     * 查询资金变更记录列表
     * 
     * @param amountChange 资金变更记录
     * @return 资金变更记录
     */
    @Override
    public List<AmountChange> selectAmountChangeList(AmountChange amountChange)
    {
        return amountChangeMapper.selectAmountChangeList(amountChange);
    }

    /**
     * 新增资金变更记录
     * 
     * @param amountChange 资金变更记录
     * @return 结果
     */
    @Override
    public int insertAmountChange(AmountChange amountChange)
    {
        amountChange.setCreateTime(DateUtils.getNowDate());
        return amountChangeMapper.insertAmountChange(amountChange);
    }

    /**
     * 修改资金变更记录
     * 
     * @param amountChange 资金变更记录
     * @return 结果
     */
    @Override
    public int updateAmountChange(AmountChange amountChange)
    {
        return amountChangeMapper.updateAmountChange(amountChange);
    }

    /**
     * 批量删除资金变更记录
     * 
     * @param ids 需要删除的资金变更记录主键
     * @return 结果
     */
    @Override
    public int deleteAmountChangeByIds(Long[] ids)
    {
        return amountChangeMapper.deleteAmountChangeByIds(ids);
    }

    /**
     * 删除资金变更记录信息
     * 
     * @param id 资金变更记录主键
     * @return 结果
     */
    @Override
    public int deleteAmountChangeById(Long id)
    {
        return amountChangeMapper.deleteAmountChangeById(id);
    }
}
