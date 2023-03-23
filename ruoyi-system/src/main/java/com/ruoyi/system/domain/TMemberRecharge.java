package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员充值对象 t_member_recharge
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class TMemberRecharge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 会员ID */
    @Excel(name = "会员ID")
    private String memberId;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private BigDecimal amount;

    /** 充值状态 */
    @Excel(name = "充值状态")
    private Integer status;

    @Excel(name = "链名")
    private String chainName;
    @Excel(name = "图片")
    private String paymentVoucher;

    public String getPaymentVoucher() {
        return paymentVoucher;
    }

    public void setPaymentVoucher(String paymentVoucher) {
        this.paymentVoucher = paymentVoucher;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

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
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
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

    private String lastPhone;

    public String getLastPhone() {
        return lastPhone;
    }

    public void setLastPhone(String lastPhone) {
        this.lastPhone = lastPhone;
    }

    private String useType;

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("currency", getCurrency())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
