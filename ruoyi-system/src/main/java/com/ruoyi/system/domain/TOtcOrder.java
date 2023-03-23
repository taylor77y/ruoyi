package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 法币订单对象 t_otc_order
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TOtcOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户 */
    @Excel(name = "用户")
    private String member;

    /** 商家昵称 */
    @Excel(name = "商家昵称")
    private String memberFbName;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private BigDecimal num;

    /** 溢价 */
    @Excel(name = "溢价")
    private BigDecimal upDownNumber;

    /** 最小成交价格 */
    @Excel(name = "最小成交价格")
    private BigDecimal minPrice;

    /** 极端价格 */
    @Excel(name = "极端价格")
    private BigDecimal extremum;

    /** 交易说明 */
    @Excel(name = "交易说明")
    private String remarks;

    /** 方向 */
    @Excel(name = "方向")
    private String direction;

    /** 收款方式 */
    @Excel(name = "收款方式")
    private String payType;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String autoStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String autoMsg;

    /** 冻结数量 */
    @Excel(name = "冻结数量")
    private BigDecimal freeze;

    /** 已成交数量 */
    @Excel(name = "已成交数量")
    private BigDecimal dealNum;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setMemberFbName(String memberFbName) 
    {
        this.memberFbName = memberFbName;
    }

    public String getMemberFbName() 
    {
        return memberFbName;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setNum(BigDecimal num) 
    {
        this.num = num;
    }

    public BigDecimal getNum() 
    {
        return num;
    }
    public void setUpDownNumber(BigDecimal upDownNumber) 
    {
        this.upDownNumber = upDownNumber;
    }

    public BigDecimal getUpDownNumber() 
    {
        return upDownNumber;
    }
    public void setMinPrice(BigDecimal minPrice) 
    {
        this.minPrice = minPrice;
    }

    public BigDecimal getMinPrice() 
    {
        return minPrice;
    }
    public void setExtremum(BigDecimal extremum) 
    {
        this.extremum = extremum;
    }

    public BigDecimal getExtremum() 
    {
        return extremum;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setDirection(String direction) 
    {
        this.direction = direction;
    }

    public String getDirection() 
    {
        return direction;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAutoStatus(String autoStatus) 
    {
        this.autoStatus = autoStatus;
    }

    public String getAutoStatus() 
    {
        return autoStatus;
    }
    public void setAutoMsg(String autoMsg) 
    {
        this.autoMsg = autoMsg;
    }

    public String getAutoMsg() 
    {
        return autoMsg;
    }
    public void setFreeze(BigDecimal freeze) 
    {
        this.freeze = freeze;
    }

    public BigDecimal getFreeze() 
    {
        return freeze;
    }
    public void setDealNum(BigDecimal dealNum) 
    {
        this.dealNum = dealNum;
    }

    public BigDecimal getDealNum() 
    {
        return dealNum;
    }

    private String phone;
    private String mail;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    private Integer mccId;
    private String mccName;

    public Integer getMccId() {
        return mccId;
    }

    public void setMccId(Integer mccId) {
        this.mccId = mccId;
    }

    public String getMccName() {
        return mccName;
    }

    public void setMccName(String mccName) {
        this.mccName = mccName;
    }

    private Integer isUp;

    public Integer getIsUp() {
        return isUp;
    }

    public void setIsUp(Integer isUp) {
        this.isUp = isUp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("member", getMember())
            .append("memberFbName", getMemberFbName())
            .append("currency", getCurrency())
            .append("num", getNum())
            .append("upDownNumber", getUpDownNumber())
            .append("minPrice", getMinPrice())
            .append("extremum", getExtremum())
            .append("remarks", getRemarks())
            .append("direction", getDirection())
            .append("payType", getPayType())
            .append("status", getStatus())
            .append("autoStatus", getAutoStatus())
            .append("autoMsg", getAutoMsg())
            .append("freeze", getFreeze())
            .append("dealNum", getDealNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
