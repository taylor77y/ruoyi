package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MoneyAccountMapper;
import com.ruoyi.system.domain.MoneyAccount;
import com.ruoyi.system.service.IMoneyAccountService;

/**
 * 收款账户Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class MoneyAccountServiceImpl implements IMoneyAccountService 
{
    @Autowired
    private MoneyAccountMapper moneyAccountMapper;

    /**
     * 查询收款账户
     * 
     * @param id 收款账户主键
     * @return 收款账户
     */
    @Override
    public MoneyAccount selectMoneyAccountById(Long id)
    {
        return moneyAccountMapper.selectMoneyAccountById(id);
    }

    /**
     * 查询收款账户列表
     * 
     * @param moneyAccount 收款账户
     * @return 收款账户
     */
    @Override
    public List<MoneyAccount> selectMoneyAccountList(MoneyAccount moneyAccount)
    {
        return moneyAccountMapper.selectMoneyAccountList(moneyAccount);
    }

    /**
     * 新增收款账户
     * 
     * @param moneyAccount 收款账户
     * @return 结果
     */
    @Override
    public int insertMoneyAccount(MoneyAccount moneyAccount)
    {
        moneyAccount.setCreateTime(DateUtils.getNowDate());
        return moneyAccountMapper.insertMoneyAccount(moneyAccount);
    }

    /**
     * 修改收款账户
     * 
     * @param moneyAccount 收款账户
     * @return 结果
     */
    @Override
    public int updateMoneyAccount(MoneyAccount moneyAccount)
    {
        return moneyAccountMapper.updateMoneyAccount(moneyAccount);
    }

    /**
     * 批量删除收款账户
     * 
     * @param ids 需要删除的收款账户主键
     * @return 结果
     */
    @Override
    public int deleteMoneyAccountByIds(Long[] ids)
    {
        return moneyAccountMapper.deleteMoneyAccountByIds(ids);
    }

    /**
     * 删除收款账户信息
     * 
     * @param id 收款账户主键
     * @return 结果
     */
    @Override
    public int deleteMoneyAccountById(Long id)
    {
        return moneyAccountMapper.deleteMoneyAccountById(id);
    }
}
