package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TBillingAddress;

/**
 * 用户提款账单地址Service接口
 * 
 * @author ruoyi
 * @date 2022-10-11
 */
public interface ITBillingAddressService 
{
    /**
     * 查询用户提款账单地址
     * 
     * @param id 用户提款账单地址主键
     * @return 用户提款账单地址
     */
    public TBillingAddress selectTBillingAddressById(Long id);

    /**
     * 查询用户提款账单地址列表
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 用户提款账单地址集合
     */
    public List<TBillingAddress> selectTBillingAddressList(TBillingAddress tBillingAddress);

    /**
     * 新增用户提款账单地址
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 结果
     */
    public int insertTBillingAddress(TBillingAddress tBillingAddress);

    /**
     * 修改用户提款账单地址
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 结果
     */
    public int updateTBillingAddress(TBillingAddress tBillingAddress);

    /**
     * 批量删除用户提款账单地址
     * 
     * @param ids 需要删除的用户提款账单地址主键集合
     * @return 结果
     */
    public int deleteTBillingAddressByIds(Long[] ids);

    /**
     * 删除用户提款账单地址信息
     * 
     * @param id 用户提款账单地址主键
     * @return 结果
     */
    public int deleteTBillingAddressById(Long id);
}
