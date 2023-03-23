package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBillingAddressMapper;
import com.ruoyi.system.domain.TBillingAddress;
import com.ruoyi.system.service.ITBillingAddressService;

/**
 * 用户提款账单地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-11
 */
@Service
public class TBillingAddressServiceImpl implements ITBillingAddressService 
{
    @Autowired
    private TBillingAddressMapper tBillingAddressMapper;

    /**
     * 查询用户提款账单地址
     * 
     * @param id 用户提款账单地址主键
     * @return 用户提款账单地址
     */
    @Override
    public TBillingAddress selectTBillingAddressById(Long id)
    {
        return tBillingAddressMapper.selectTBillingAddressById(id);
    }

    /**
     * 查询用户提款账单地址列表
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 用户提款账单地址
     */
    @Override
    public List<TBillingAddress> selectTBillingAddressList(TBillingAddress tBillingAddress)
    {
        return tBillingAddressMapper.selectTBillingAddressList(tBillingAddress);
    }

    /**
     * 新增用户提款账单地址
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 结果
     */
    @Override
    public int insertTBillingAddress(TBillingAddress tBillingAddress)
    {
        tBillingAddress.setCreateTime(DateUtils.getNowDate());
        return tBillingAddressMapper.insertTBillingAddress(tBillingAddress);
    }

    /**
     * 修改用户提款账单地址
     * 
     * @param tBillingAddress 用户提款账单地址
     * @return 结果
     */
    @Override
    public int updateTBillingAddress(TBillingAddress tBillingAddress)
    {
        return tBillingAddressMapper.updateTBillingAddress(tBillingAddress);
    }

    /**
     * 批量删除用户提款账单地址
     * 
     * @param ids 需要删除的用户提款账单地址主键
     * @return 结果
     */
    @Override
    public int deleteTBillingAddressByIds(Long[] ids)
    {
        return tBillingAddressMapper.deleteTBillingAddressByIds(ids);
    }

    /**
     * 删除用户提款账单地址信息
     * 
     * @param id 用户提款账单地址主键
     * @return 结果
     */
    @Override
    public int deleteTBillingAddressById(Long id)
    {
        return tBillingAddressMapper.deleteTBillingAddressById(id);
    }
}
