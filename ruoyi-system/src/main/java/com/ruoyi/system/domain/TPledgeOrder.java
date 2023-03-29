package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 质押借币订单对象 t_pledge_order
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
public class TPledgeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String memberId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNumber;

    /** 借款金额 */
    @Excel(name = "借款金额")
    private BigDecimal borrowMoney;

    /** 借款币种 */
    @Excel(name = "借款币种")
    private String borrowName;

    /** 质押金额 */
    @Excel(name = "质押金额")
    private BigDecimal pledgeMoney;

    /** 质押币名称 */
    @Excel(name = "质押币名称")
    private String pledgeName;

    /** 借款天数（天） */
    @Excel(name = "借款天数", readConverterExp = "天=")
    private Integer deadline;

    /** 强平价格 */
    @Excel(name = "强平价格")
    private BigDecimal forcePrice;

    /** 质押率（%） */
    @Excel(name = "质押率", readConverterExp = "%=")
    private BigDecimal pledgeRate;

    /** 小时利率 */
    @Excel(name = "小时利率")
    private BigDecimal hrRate;

    /** 日利率 */
    @Excel(name = "日利率")
    private BigDecimal dayRate;

    /** 提前还款手续费 */
    @Excel(name = "提前还款手续费")
    private BigDecimal feeMoney;

    /** 总利息 */
    @Excel(name = "总利息")
    private BigDecimal totalMoney;

    /** 总负债 */
    @Excel(name = "总负债")
    private BigDecimal totalIncurDebts;

    /** 预计还款金额 */
    @Excel(name = "预计还款金额")
    private BigDecimal predictRefundMoney;

    /** 还款金额 */
    @Excel(name = "还款金额")
    private BigDecimal refundPrice;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    /** 到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireTime;

    /** 0(计息中) 1（已结清）2（强平结算） */
    @Excel(name = "0", readConverterExp = "计息中")
    private Integer status;
    private List<TPledgeOrderDetail> details;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public BigDecimal getPledgeMoney() {
        return pledgeMoney;
    }

    public void setPledgeMoney(BigDecimal pledgeMoney) {
        this.pledgeMoney = pledgeMoney;
    }

    public String getPledgeName() {
        return pledgeName;
    }

    public void setPledgeName(String pledgeName) {
        this.pledgeName = pledgeName;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public BigDecimal getForcePrice() {
        return forcePrice;
    }

    public void setForcePrice(BigDecimal forcePrice) {
        this.forcePrice = forcePrice;
    }

    public BigDecimal getPledgeRate() {
        return pledgeRate;
    }

    public void setPledgeRate(BigDecimal pledgeRate) {
        this.pledgeRate = pledgeRate;
    }

    public BigDecimal getHrRate() {
        return hrRate;
    }

    public void setHrRate(BigDecimal hrRate) {
        this.hrRate = hrRate;
    }

    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    public BigDecimal getFeeMoney() {
        return feeMoney;
    }

    public void setFeeMoney(BigDecimal feeMoney) {
        this.feeMoney = feeMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalIncurDebts() {
        return totalIncurDebts;
    }

    public void setTotalIncurDebts(BigDecimal totalIncurDebts) {
        this.totalIncurDebts = totalIncurDebts;
    }

    public BigDecimal getPredictRefundMoney() {
        return predictRefundMoney;
    }

    public void setPredictRefundMoney(BigDecimal predictRefundMoney) {
        this.predictRefundMoney = predictRefundMoney;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TPledgeOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TPledgeOrderDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "TPledgeOrder{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", borrowMoney=" + borrowMoney +
                ", borrowName='" + borrowName + '\'' +
                ", pledgeMoney=" + pledgeMoney +
                ", pledgeName='" + pledgeName + '\'' +
                ", deadline=" + deadline +
                ", forcePrice=" + forcePrice +
                ", pledgeRate=" + pledgeRate +
                ", hrRate=" + hrRate +
                ", dayRate=" + dayRate +
                ", feeMoney=" + feeMoney +
                ", totalMoney=" + totalMoney +
                ", totalIncurDebts=" + totalIncurDebts +
                ", predictRefundMoney=" + predictRefundMoney +
                ", refundPrice=" + refundPrice +
                ", creationTime=" + creationTime +
                ", expireTime=" + expireTime +
                ", status=" + status +
                ", details=" + details +
                '}';
    }
}
