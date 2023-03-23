package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币币兑换记录对象 t_exchange_record
 * 
 * @author ruoyi
 * @date 2022-09-25
 */
public class TExchangeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String memberId;

    /** 原始币 */
    @Excel(name = "原始币")
    private String currency;

    /** 目标币 */
    @Excel(name = "目标币")
    private String currencyTarget;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 兑换后数量 */
    @Excel(name = "兑换后数量")
    private BigDecimal afterExchangeQuantity;

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
    public void setCurrencyTarget(String currencyTarget) 
    {
        this.currencyTarget = currencyTarget;
    }

    public String getCurrencyTarget() 
    {
        return currencyTarget;
    }
    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }
    public void setAfterExchangeQuantity(BigDecimal afterExchangeQuantity) 
    {
        this.afterExchangeQuantity = afterExchangeQuantity;
    }

    public BigDecimal getAfterExchangeQuantity() 
    {
        return afterExchangeQuantity;
    }

    private String uuid;
    private String phone;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("currency", getCurrency())
            .append("currencyTarget", getCurrencyTarget())
            .append("quantity", getQuantity())
            .append("afterExchangeQuantity", getAfterExchangeQuantity())
            .append("createTime", getCreateTime())
            .toString();
    }
}
