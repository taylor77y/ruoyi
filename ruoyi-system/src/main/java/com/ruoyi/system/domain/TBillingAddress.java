package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户提款账单地址对象 t_billing_address
 * 
 * @author ruoyi
 * @date 2022-10-11
 */
public class TBillingAddress extends BaseEntity
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

    /** 币种子类型 */
    @Excel(name = "币种子类型")
    private String currencyType;

    /** 收款地址 */
    @Excel(name = "收款地址")
    private String address;

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
    public void setCurrencyType(String currencyType) 
    {
        this.currencyType = currencyType;
    }

    public String getCurrencyType() 
    {
        return currencyType;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("currency", getCurrency())
            .append("currencyType", getCurrencyType())
            .append("address", getAddress())
            .append("createTime", getCreateTime())
            .toString();
    }
}
