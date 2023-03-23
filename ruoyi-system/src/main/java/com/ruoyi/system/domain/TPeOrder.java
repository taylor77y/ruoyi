package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 私募订单对象 t_pe_order
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TPeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** pe项目id */
    @Excel(name = "pe项目id")
    private String peId;

    /** 购买份额用户id */
    @Excel(name = "购买份额用户id")
    private String member;

    /** 形目名称 */
    @Excel(name = "形目名称")
    private String peName;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal pePrice;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal peNum;

    /** 总额 */
    @Excel(name = "总额")
    private BigDecimal peAmount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPeId(String peId) 
    {
        this.peId = peId;
    }

    public String getPeId() 
    {
        return peId;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setPeName(String peName) 
    {
        this.peName = peName;
    }

    public String getPeName() 
    {
        return peName;
    }
    public void setPePrice(BigDecimal pePrice) 
    {
        this.pePrice = pePrice;
    }

    public BigDecimal getPePrice() 
    {
        return pePrice;
    }
    public void setPeNum(BigDecimal peNum) 
    {
        this.peNum = peNum;
    }

    public BigDecimal getPeNum() 
    {
        return peNum;
    }
    public void setPeAmount(BigDecimal peAmount) 
    {
        this.peAmount = peAmount;
    }

    public BigDecimal getPeAmount() 
    {
        return peAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("peId", getPeId())
            .append("member", getMember())
            .append("peName", getPeName())
            .append("pePrice", getPePrice())
            .append("peNum", getPeNum())
            .append("peAmount", getPeAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
