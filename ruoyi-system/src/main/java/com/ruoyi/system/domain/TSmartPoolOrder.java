package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_smart_pool_order
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class TSmartPoolOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 订单号（时间+6位随机数） */
    @Excel(name = "订单号", readConverterExp = "时=间+6位随机数")
    private String orderNumber;

    /** 基金产品Id */
    @Excel(name = "矿机产品Id")
    private String productId;

    /** 会员id */
    @Excel(name = "会员id")
    private String memberId;

    /** 起息日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "起息日", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date valueDate;

    /** 结束起息日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束起息日", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date finishValueDate;

    /** 周期（天） */
    @Excel(name = "周期", readConverterExp = "天=")
    private Integer periodDay;

    /** 剩余（天） */
    @Excel(name = "剩余", readConverterExp = "天=")
    private Integer residueDay;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal price;

    /** 累计收益额 */
    @Excel(name = "累计收益额")
    private BigDecimal accumulatedIncome;

    /** 违约金（发生强赎产生） */
    @Excel(name = "违约金", readConverterExp = "发=生强赎产生")
    private BigDecimal penalPrice;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
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
            .append("productId", getProductId())
            .append("memberId", getMemberId())
            .append("valueDate", getValueDate())
            .append("finishValueDate", getFinishValueDate())
            .append("periodDay", getPeriodDay())
            .append("residueDay", getResidueDay())
            .append("price", getPrice())
            .append("accumulatedIncome", getAccumulatedIncome())
            .append("penalPrice", getPenalPrice())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("enabled", getEnabled())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
