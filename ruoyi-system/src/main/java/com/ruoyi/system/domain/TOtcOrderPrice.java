package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 下单对象 t_otc_order_price
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TOtcOrderPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 商家id */
    @Excel(name = "商家id")
    private String storeId;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderId;

    /** 用户方向 */
    @Excel(name = "用户方向")
    private String userDirection;

    /** 商家方向 */
    @Excel(name = "商家方向")
    private String storeDirection;

    /** 下单数量 */
    @Excel(name = "下单数量")
    private BigDecimal num;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 付款类型 */
    @Excel(name = "付款类型")
    private String payType;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String status;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 申诉状态 */
    @Excel(name = "申诉状态")
    private String appealStatus;

    /** 申诉id */
    @Excel(name = "申诉id")
    private String appealUserId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setStoreId(String storeId) 
    {
        this.storeId = storeId;
    }

    public String getStoreId() 
    {
        return storeId;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setUserDirection(String userDirection) 
    {
        this.userDirection = userDirection;
    }

    public String getUserDirection() 
    {
        return userDirection;
    }
    public void setStoreDirection(String storeDirection) 
    {
        this.storeDirection = storeDirection;
    }

    public String getStoreDirection() 
    {
        return storeDirection;
    }
    public void setNum(BigDecimal num) 
    {
        this.num = num;
    }

    public BigDecimal getNum() 
    {
        return num;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
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
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setAppealStatus(String appealStatus) 
    {
        this.appealStatus = appealStatus;
    }

    public String getAppealStatus() 
    {
        return appealStatus;
    }
    public void setAppealUserId(String appealUserId) 
    {
        this.appealUserId = appealUserId;
    }

    public String getAppealUserId() 
    {
        return appealUserId;
    }

    private String userPhone;
    private String userMail;
    private String storePhone;
    private String storeMail;
    private String appealUserPhone;
    private String appealUserMail;

    private String lastUserPhone;

    public String getLastUserPhone() {
        return lastUserPhone;
    }

    public void setLastUserPhone(String lastUserPhone) {
        this.lastUserPhone = lastUserPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreMail() {
        return storeMail;
    }

    public void setStoreMail(String storeMail) {
        this.storeMail = storeMail;
    }

    public String getAppealUserPhone() {
        return appealUserPhone;
    }

    public void setAppealUserPhone(String appealUserPhone) {
        this.appealUserPhone = appealUserPhone;
    }

    public String getAppealUserMail() {
        return appealUserMail;
    }

    public void setAppealUserMail(String appealUserMail) {
        this.appealUserMail = appealUserMail;
    }

    private String userUuid;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    private Long payMccId;

    public Long getPayMccId() {
        return payMccId;
    }

    public void setPayMccId(Long payMccId) {
        this.payMccId = payMccId;
    }

    private TMemberCurrencyConfig memberCurrencyConfig;

    public TMemberCurrencyConfig getMemberCurrencyConfig() {
        return memberCurrencyConfig;
    }

    public void setMemberCurrencyConfig(TMemberCurrencyConfig memberCurrencyConfig) {
        this.memberCurrencyConfig = memberCurrencyConfig;
    }

    private Integer useType;

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("storeId", getStoreId())
            .append("orderId", getOrderId())
            .append("userDirection", getUserDirection())
            .append("storeDirection", getStoreDirection())
            .append("num", getNum())
            .append("price", getPrice())
            .append("totalPrice", getTotalPrice())
            .append("payType", getPayType())
            .append("status", getStatus())
            .append("currency", getCurrency())
            .append("appealStatus", getAppealStatus())
            .append("appealUserId", getAppealUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
