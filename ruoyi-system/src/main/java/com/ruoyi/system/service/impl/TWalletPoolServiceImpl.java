package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TWalletPoolMapper;
import com.ruoyi.system.domain.TWalletPool;
import com.ruoyi.system.service.ITWalletPoolService;

/**
 * 充币地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TWalletPoolServiceImpl implements ITWalletPoolService 
{
    @Autowired
    private TWalletPoolMapper tWalletPoolMapper;

    /**
     * 查询充币地址
     * 
     * @param id 充币地址主键
     * @return 充币地址
     */
    @Override
    public TWalletPool selectTWalletPoolById(String id)
    {
        return tWalletPoolMapper.selectTWalletPoolById(id);
    }

    /**
     * 查询充币地址列表
     * 
     * @param tWalletPool 充币地址
     * @return 充币地址
     */
    @Override
    public List<TWalletPool> selectTWalletPoolList(TWalletPool tWalletPool)
    {
        return tWalletPoolMapper.selectTWalletPoolList(tWalletPool);
    }

    /**
     * 新增充币地址
     * 
     * @param tWalletPool 充币地址
     * @return 结果
     */
    @Override
    public int insertTWalletPool(TWalletPool tWalletPool)
    {
        tWalletPool.setCreateTime(DateUtils.getNowDate());
        return tWalletPoolMapper.insertTWalletPool(tWalletPool);
    }

    /**
     * 修改充币地址
     * 
     * @param tWalletPool 充币地址
     * @return 结果
     */
    @Override
    public int updateTWalletPool(TWalletPool tWalletPool)
    {
        return tWalletPoolMapper.updateTWalletPool(tWalletPool);
    }

    /**
     * 批量删除充币地址
     * 
     * @param ids 需要删除的充币地址主键
     * @return 结果
     */
    @Override
    public int deleteTWalletPoolByIds(String[] ids)
    {
        return tWalletPoolMapper.deleteTWalletPoolByIds(ids);
    }

    /**
     * 删除充币地址信息
     * 
     * @param id 充币地址主键
     * @return 结果
     */
    @Override
    public int deleteTWalletPoolById(String id)
    {
        return tWalletPoolMapper.deleteTWalletPoolById(id);
    }
}
