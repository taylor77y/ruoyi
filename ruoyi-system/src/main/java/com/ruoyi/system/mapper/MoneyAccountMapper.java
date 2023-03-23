package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.MoneyAccount;

/**
 * 收款账户Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface MoneyAccountMapper 
{
    /**
     * 查询收款账户
     * 
     * @param id 收款账户主键
     * @return 收款账户
     */
    public MoneyAccount selectMoneyAccountById(Long id);

    /**
     * 查询收款账户列表
     * 
     * @param moneyAccount 收款账户
     * @return 收款账户集合
     */
    public List<MoneyAccount> selectMoneyAccountList(MoneyAccount moneyAccount);

    /**
     * 新增收款账户
     * 
     * @param moneyAccount 收款账户
     * @return 结果
     */
    public int insertMoneyAccount(MoneyAccount moneyAccount);

    /**
     * 修改收款账户
     * 
     * @param moneyAccount 收款账户
     * @return 结果
     */
    public int updateMoneyAccount(MoneyAccount moneyAccount);

    /**
     * 删除收款账户
     * 
     * @param id 收款账户主键
     * @return 结果
     */
    public int deleteMoneyAccountById(Long id);

    /**
     * 批量删除收款账户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMoneyAccountByIds(Long[] ids);

    public MoneyAccount findByUsername(String username);
}
