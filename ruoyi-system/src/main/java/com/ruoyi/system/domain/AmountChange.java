package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资金变更记录对象 amount_change
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class AmountChange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 会员ID */
    @Excel(name = "会员ID")
    private String memberId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 变更类型 */
    @Excel(name = "变更类型")
    private Integer type;

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
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }

    private String phone;
    private String mail;

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
            .append("amount", getAmount())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .toString();
    }
}
