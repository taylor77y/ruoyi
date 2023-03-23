package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TBalance;

/**
 * 用户余额Service接口
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public interface ITBalanceService 
{
    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    public TBalance selectTBalanceById(String id);

    /**
     * 查询用户余额列表
     * 
     * @param tBalance 用户余额
     * @return 用户余额集合
     */
    public List<TBalance> selectTBalanceList(TBalance tBalance);

    /**
     * 新增用户余额
     * 
     * @param tBalance 用户余额
     * @return 结果
     */
    public int insertTBalance(TBalance tBalance);

    /**
     * 修改用户余额
     * 
     * @param tBalance 用户余额
     * @return 结果
     */
    public int updateTBalance(TBalance tBalance);

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的用户余额主键集合
     * @return 结果
     */
    public int deleteTBalanceByIds(String[] ids);

    /**
     * 删除用户余额信息
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    public int deleteTBalanceById(String id);
}
