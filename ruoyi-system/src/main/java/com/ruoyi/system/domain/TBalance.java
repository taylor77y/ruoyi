package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户余额对象 t_balance
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public class TBalance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 冻结余额 */
    @Excel(name = "冻结余额")
    private BigDecimal blockedBalance;

    /** 币币余额 */
    @Excel(name = "币币余额")
    private BigDecimal balance;

    /** 资产冻结 */
    @Excel(name = "资产冻结")
    private BigDecimal assetsBlockedBalance;

    /** 充提可用 */
    @Excel(name = "充提可用")
    private BigDecimal assetsBalance;

    /** 合约可用 */
    @Excel(name = "合约可用")
    private BigDecimal tokenBalance;

    /** 合约冻结 */
    @Excel(name = "合约冻结")
    private BigDecimal tokenBlockedBalance;

    /** 法币可用 */
    @Excel(name = "法币可用")
    private BigDecimal fbBalance;

    /** 法币冻结 */
    @Excel(name = "法币冻结")
    private BigDecimal fbBlockedBalance;

    /** 私募冻结 */
    @Excel(name = "私募冻结")
    private BigDecimal raiseBalance;

    /** 恋上资产 */
    @Excel(name = "恋上资产")
    private BigDecimal chainBalance;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;
    private TPairs tPairs;

    public TPairs gettPairs() {
        return tPairs;
    }

    public void settPairs(TPairs tPairs) {
        this.tPairs = tPairs;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setBlockedBalance(BigDecimal blockedBalance) 
    {
        this.blockedBalance = blockedBalance;
    }

    public BigDecimal getBlockedBalance() 
    {
        return blockedBalance;
    }
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setAssetsBlockedBalance(BigDecimal assetsBlockedBalance) 
    {
        this.assetsBlockedBalance = assetsBlockedBalance;
    }

    public BigDecimal getAssetsBlockedBalance() 
    {
        return assetsBlockedBalance;
    }
    public void setAssetsBalance(BigDecimal assetsBalance) 
    {
        this.assetsBalance = assetsBalance;
    }

    public BigDecimal getAssetsBalance() 
    {
        return assetsBalance;
    }
    public void setTokenBalance(BigDecimal tokenBalance) 
    {
        this.tokenBalance = tokenBalance;
    }

    public BigDecimal getTokenBalance() 
    {
        return tokenBalance;
    }
    public void setTokenBlockedBalance(BigDecimal tokenBlockedBalance) 
    {
        this.tokenBlockedBalance = tokenBlockedBalance;
    }

    public BigDecimal getTokenBlockedBalance() 
    {
        return tokenBlockedBalance;
    }
    public void setFbBalance(BigDecimal fbBalance) 
    {
        this.fbBalance = fbBalance;
    }

    public BigDecimal getFbBalance() 
    {
        return fbBalance;
    }
    public void setFbBlockedBalance(BigDecimal fbBlockedBalance) 
    {
        this.fbBlockedBalance = fbBlockedBalance;
    }

    public BigDecimal getFbBlockedBalance() 
    {
        return fbBlockedBalance;
    }
    public void setRaiseBalance(BigDecimal raiseBalance) 
    {
        this.raiseBalance = raiseBalance;
    }

    public BigDecimal getRaiseBalance() 
    {
        return raiseBalance;
    }
    public void setChainBalance(BigDecimal chainBalance) 
    {
        this.chainBalance = chainBalance;
    }

    public BigDecimal getChainBalance() 
    {
        return chainBalance;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    private String phone;
    private String mail;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    private String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("currency", getCurrency())
            .append("blockedBalance", getBlockedBalance())
            .append("balance", getBalance())
            .append("assetsBlockedBalance", getAssetsBlockedBalance())
            .append("assetsBalance", getAssetsBalance())
            .append("tokenBalance", getTokenBalance())
            .append("tokenBlockedBalance", getTokenBlockedBalance())
            .append("fbBalance", getFbBalance())
            .append("fbBlockedBalance", getFbBlockedBalance())
            .append("raiseBalance", getRaiseBalance())
            .append("chainBalance", getChainBalance())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
