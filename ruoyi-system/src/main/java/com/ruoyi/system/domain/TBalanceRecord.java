package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资金记录对象 t_balance_record
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
public class TBalanceRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String memberId;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 资金类型 */
    @Excel(name = "资金类型")
    private Integer balanceType;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private Integer fundsType;

    /** 资产变更前 */
    @Excel(name = "资产变更前")
    private BigDecimal balanceBefore;

    /** 资产变更后 */
    @Excel(name = "资产变更后")
    private BigDecimal balanceBack;

    /** 资产差额 */
    @Excel(name = "资产差额")
    private BigDecimal balanceDifference;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMemberId(String memberId) 
    {
        this.memberId = memberId;
    }

    public String getMemberId() 
    {
        return memberId;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setBalanceType(Integer balanceType) 
    {
        this.balanceType = balanceType;
    }

    public Integer getBalanceType() 
    {
        return balanceType;
    }
    public void setFundsType(Integer fundsType) 
    {
        this.fundsType = fundsType;
    }

    public Integer getFundsType() 
    {
        return fundsType;
    }
    public void setBalanceBefore(BigDecimal balanceBefore) 
    {
        this.balanceBefore = balanceBefore;
    }

    public BigDecimal getBalanceBefore() 
    {
        return balanceBefore;
    }
    public void setBalanceBack(BigDecimal balanceBack) 
    {
        this.balanceBack = balanceBack;
    }

    public BigDecimal getBalanceBack() 
    {
        return balanceBack;
    }
    public void setBalanceDifference(BigDecimal balanceDifference) 
    {
        this.balanceDifference = balanceDifference;
    }

    public BigDecimal getBalanceDifference() 
    {
        return balanceDifference;
    }

    private String phone;
    private String uuid;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private Integer dataClassification;

    public Integer getDataClassification() {
        return dataClassification;
    }

    public void setDataClassification(Integer dataClassification) {
        this.dataClassification = dataClassification;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("currency", getCurrency())
            .append("balanceType", getBalanceType())
            .append("fundsType", getFundsType())
            .append("balanceBefore", getBalanceBefore())
            .append("balanceBack", getBalanceBack())
            .append("balanceDifference", getBalanceDifference())
            .append("createTime", getCreateTime())
            .toString();
    }
}
