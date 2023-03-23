package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户财务分析对象 t_user_blance_collect
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public class TUserBlanceCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String member;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 总充值 */
    @Excel(name = "总充值")
    private BigDecimal sumChong;

    /** 总提币 */
    @Excel(name = "总提币")
    private BigDecimal sumTi;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setSumChong(BigDecimal sumChong) 
    {
        this.sumChong = sumChong;
    }

    public BigDecimal getSumChong() 
    {
        return sumChong;
    }
    public void setSumTi(BigDecimal sumTi) 
    {
        this.sumTi = sumTi;
    }

    public BigDecimal getSumTi() 
    {
        return sumTi;
    }

    private String phone;

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
            .append("member", getMember())
            .append("currency", getCurrency())
            .append("sumChong", getSumChong())
            .append("sumTi", getSumTi())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
