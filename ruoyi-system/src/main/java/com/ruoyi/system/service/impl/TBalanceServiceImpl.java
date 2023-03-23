package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TPairs;
import com.ruoyi.system.mapper.TPairsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBalanceMapper;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.service.ITBalanceService;

/**
 * 用户余额Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@Service
public class TBalanceServiceImpl implements ITBalanceService 
{
    @Autowired
    private TBalanceMapper tBalanceMapper;
    /**
     * 查询用户余额
     * 
     * @param id 用户余额主键
     * @return 用户余额
     */
    @Override
    public TBalance selectTBalanceById(String id)
    {
        return tBalanceMapper.selectTBalanceById(id);
    }

    /**
     * 查询用户余额列表
     * 
     * @param tBalance 用户余额
     * @return 用户余额
     */
    @Override
    public List<TBalance> selectTBalanceList(TBalance tBalance)
    {
        return tBalanceMapper.selectTBalanceList(tBalance);
    }

    /**
     * 新增用户余额
     * 
     * @param tBalance 用户余额
     * @return 结果
     */
    @Override
    public int insertTBalance(TBalance tBalance)
    {
        tBalance.setCreateTime(DateUtils.getNowDate());
        return tBalanceMapper.insertTBalance(tBalance);
    }

    /**
     * 修改用户余额
     * 
     * @param tBalance 用户余额
     * @return 结果
     */
    @Override
    public int updateTBalance(TBalance tBalance)
    {
        tBalance.setUpdateTime(DateUtils.getNowDate());
        return tBalanceMapper.updateTBalance(tBalance);
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
        return tBalanceMapper.deleteTBalanceByIds(ids);
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
        return tBalanceMapper.deleteTBalanceById(id);
    }
}
