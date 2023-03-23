package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TWalletPool;

/**
 * 充币地址Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITWalletPoolService 
{
    /**
     * 查询充币地址
     * 
     * @param id 充币地址主键
     * @return 充币地址
     */
    public TWalletPool selectTWalletPoolById(String id);

    /**
     * 查询充币地址列表
     * 
     * @param tWalletPool 充币地址
     * @return 充币地址集合
     */
    public List<TWalletPool> selectTWalletPoolList(TWalletPool tWalletPool);

    /**
     * 新增充币地址
     * 
     * @param tWalletPool 充币地址
     * @return 结果
     */
    public int insertTWalletPool(TWalletPool tWalletPool);

    /**
     * 修改充币地址
     * 
     * @param tWalletPool 充币地址
     * @return 结果
     */
    public int updateTWalletPool(TWalletPool tWalletPool);

    /**
     * 批量删除充币地址
     * 
     * @param ids 需要删除的充币地址主键集合
     * @return 结果
     */
    public int deleteTWalletPoolByIds(String[] ids);

    /**
     * 删除充币地址信息
     * 
     * @param id 充币地址主键
     * @return 结果
     */
    public int deleteTWalletPoolById(String id);
}
