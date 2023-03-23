package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TSysBalance;
import com.ruoyi.system.mapper.TSysBalanceMapper;
import com.ruoyi.system.service.ITSysBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户余额Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@Service
public class TSysBalanceServiceImpl implements ITSysBalanceService
{
    @Autowired
    private TSysBalanceMapper tSysBalanceMapper;

    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    @Override
    public TSysBalance selectTBalanceById(String id)
    {
        return tSysBalanceMapper.selectTBalanceById(id);
    }

    /**
     * 查询用户余额列表
     * 
     * @return 用户余额
     */
    @Override
    public List<TSysBalance> selectTBalanceList(TSysBalance tSysBalance)
    {
        return tSysBalanceMapper.selectTBalanceList(tSysBalance);
    }

    /**
     * 新增用户余额
     * 
     * @return 结果
     */
    @Override
    public int insertTBalance(TSysBalance tSysBalance)
    {
        tSysBalance.setCreateTime(DateUtils.getNowDate());
        return tSysBalanceMapper.insertTBalance(tSysBalance);
    }

    /**
     * 修改用户余额
     * 
     * @return 结果
     */
    @Override
    public int updateTBalance(TSysBalance tSysBalance)
    {
        tSysBalance.setUpdateTime(DateUtils.getNowDate());
        return tSysBalanceMapper.updateTBalance(tSysBalance);
    }

    /**
     * 批量删除用户余额
     * 
     * @param ids 需要删除的用户余额主键
     * @return 结果
     */
    @Override
    public int deleteTBalanceByIds(String[] ids)
    {
        return tSysBalanceMapper.deleteTBalanceByIds(ids);
    }

    /**
     * 删除用户余额信息
     * 
     * @param id 用户余额主键
     * @return 结果
     */
    @Override
    public int deleteTBalanceById(String id)
    {
        return tSysBalanceMapper.deleteTBalanceById(id);
    }
}
