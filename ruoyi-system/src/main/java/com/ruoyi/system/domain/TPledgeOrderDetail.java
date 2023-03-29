package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 质押借币订单详情对象 t_pledge_order_detail
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
public class TPledgeOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 质押订单id */
    @Excel(name = "质押订单id")
    private String orderId;

    /** （BORROW）借款，(REFUND)还款 （RENEWAL）续借（NEWPLEDGE)新增质押 */
    @Excel(name = "借款", readConverterExp = "BORROW")
    private String type;

    /** 借款金额，还款金额 */
    @Excel(name = "借款金额，还款金额")
    private BigDecimal money;

    /** 质押类型 */
    @Excel(name = "质押类型")
    private String pledgeType;

    /** 质押金额 */
    @Excel(name = "质押金额")
    private BigDecimal pledgePrice;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    /** 质押币名称 */
    @Excel(name = "质押币名称")
    private String pledgeName;

    public TPledgeOrderDetail() {
    }

    public TPledgeOrderDetail(String orderId) {
        this.orderId = orderId;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMoney(BigDecimal money) 
    {
        this.money = money;
    }

    public BigDecimal getMoney() 
    {
        return money;
    }
    public void setPledgeType(String pledgeType) 
    {
        this.pledgeType = pledgeType;
    }

    public String getPledgeType() 
    {
        return pledgeType;
    }
    public void setPledgePrice(BigDecimal pledgePrice) 
    {
        this.pledgePrice = pledgePrice;
    }

    public BigDecimal getPledgePrice() 
    {
        return pledgePrice;
    }
    public void setCreationTime(Date creationTime) 
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime() 
    {
        return creationTime;
    }
    public void setPledgeName(String pledgeName) 
    {
        this.pledgeName = pledgeName;
    }

    public String getPledgeName() 
    {
        return pledgeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("type", getType())
            .append("money", getMoney())
            .append("pledgeType", getPledgeType())
            .append("pledgePrice", getPledgePrice())
            .append("creationTime", getCreationTime())
            .append("updateTime", getUpdateTime())
            .append("pledgeName", getPledgeName())
            .toString();
    }
}
