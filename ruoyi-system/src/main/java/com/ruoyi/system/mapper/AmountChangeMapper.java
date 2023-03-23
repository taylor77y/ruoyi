package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AmountChange;

/**
 * 资金变更记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface AmountChangeMapper 
{
    /**
     * 查询资金变更记录
     * 
     * @param id 资金变更记录主键
     * @return 资金变更记录
     */
    public AmountChange selectAmountChangeById(Long id);

    /**
     * 查询资金变更记录列表
     * 
     * @param amountChange 资金变更记录
     * @return 资金变更记录集合
     */
    public List<AmountChange> selectAmountChangeList(AmountChange amountChange);

    /**
     * 新增资金变更记录
     * 
     * @param amountChange 资金变更记录
     * @return 结果
     */
    public int insertAmountChange(AmountChange amountChange);

    /**
     * 修改资金变更记录
     * 
     * @param amountChange 资金变更记录
     * @return 结果
     */
    public int updateAmountChange(AmountChange amountChange);

    /**
     * 删除资金变更记录
     * 
     * @param id 资金变更记录主键
     * @return 结果
     */
    public int deleteAmountChangeById(Long id);

    /**
     * 批量删除资金变更记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAmountChangeByIds(Long[] ids);
}
