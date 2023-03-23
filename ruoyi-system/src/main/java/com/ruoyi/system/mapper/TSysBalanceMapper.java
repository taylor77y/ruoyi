package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TSysBalance;

import java.util.List;

/**
 * 用户余额Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public interface TSysBalanceMapper
{
    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    public TSysBalance selectTBalanceById(String id);

    /**
     * 查询用户余额列表
     * 
     * @return 用户余额集合
     */
    public List<TSysBalance> selectTBalanceList(TSysBalance tSysBalance);

    /**
     * 新增用户余额
     * 
     * @return 结果
     */
    public int insertTBalance(TSysBalance tSysBalance);

    /**
     * 修改用户余额
     *
     * @return 结果
     */
    public int updateTBalance(TSysBalance tSysBalance);

    /**
     * 删除用户余额
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    public int deleteTBalanceById(String id);

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBalanceByIds(String[] ids);
}
