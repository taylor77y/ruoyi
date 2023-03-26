package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_fund_order
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class TFundOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 订单号（时间+6位随机数） */
    @Excel(name = "订单号", readConverterExp = "时=间+6位随机数")
    private String orderNumber;

    /** 基金产品Id */
    @Excel(name = "基金产品Id")
    private Long fundProductId;

    /** 会员id */
    @Excel(name = "会员id")
    private String memberId;

    /** 起息日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起息日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date valueDate;

    /** 结束起息日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束起息日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishValueDate;

    /** 周期（天） */
    @Excel(name = "周期", readConverterExp = "天=")
    private Integer periodDay;

    /** 剩余（天） */
    @Excel(name = "剩余", readConverterExp = "天=")
    private Integer residueDay;

    /** 违约金（发生强赎产生） */
    @Excel(name = "违约金", readConverterExp = "发=生强赎产生")
    private BigDecimal price;

    /** 累计收益额 */
    @Excel(name = "累计收益额")
    private BigDecimal accumulatedIncome;

    /** 违约金（发生强赎产生） */
    @Excel(name = "违约金", readConverterExp = "发=生强赎产生")
    private BigDecimal penalPrice;

    /** 状态(0托管中，1已赎回，2强赎) */
    @Excel(name = "状态(0托管中，1已赎回，2强赎)")
    private Integer enabled;

    @Excel(name = "产品名称")
    private String productName;

    private String productNameEn;

    @Excel(name = "UID")
    private String UID;

    @Excel(name = "用户名")
    private String UName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameEn() {
        return productNameEn;
    }

    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setFundProductId(Long fundProductId) 
    {
        this.fundProductId = fundProductId;
    }

    public Long getFundProductId() 
    {
        return fundProductId;
    }
    public void setMemberId(String memberId) 
    {
        this.memberId = memberId;
    }

    public String getMemberId() 
    {
        return memberId;
    }
    public void setValueDate(Date valueDate) 
    {
        this.valueDate = valueDate;
    }

    public Date getValueDate() 
    {
        return valueDate;
    }
    public void setFinishValueDate(Date finishValueDate) 
    {
        this.finishValueDate = finishValueDate;
    }

    public Date getFinishValueDate() 
    {
        return finishValueDate;
    }
    public void setPeriodDay(Integer periodDay) 
    {
        this.periodDay = periodDay;
    }

    public Integer getPeriodDay() 
    {
        return periodDay;
    }
    public void setResidueDay(Integer residueDay) 
    {
        this.residueDay = residueDay;
    }

    public Integer getResidueDay() 
    {
        return residueDay;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setAccumulatedIncome(BigDecimal accumulatedIncome) 
    {
        this.accumulatedIncome = accumulatedIncome;
    }

    public BigDecimal getAccumulatedIncome() 
    {
        return accumulatedIncome;
    }
    public void setPenalPrice(BigDecimal penalPrice) 
    {
        this.penalPrice = penalPrice;
    }

    public BigDecimal getPenalPrice() 
    {
        return penalPrice;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNumber", getOrderNumber())
            .append("fundProductId", getFundProductId())
            .append("memberId", getMemberId())
            .append("valueDate", getValueDate())
            .append("finishValueDate", getFinishValueDate())
            .append("periodDay", getPeriodDay())
            .append("residueDay", getResidueDay())
            .append("price", getPrice())
            .append("accumulatedIncome", getAccumulatedIncome())
            .append("penalPrice", getPenalPrice())
            .append("enabled", getEnabled())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
