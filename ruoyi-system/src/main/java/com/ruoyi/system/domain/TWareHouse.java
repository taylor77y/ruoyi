package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class TWareHouse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 交易对名称 */
    @Excel(name = "交易对名称")
    private String pairsName;

    /** 币种名称 */
    @Excel(name = "币种名称")
    private String coinName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mainCur;

    /** 保证金 */
    @Excel(name = "保证金")
    private BigDecimal margin;

    /** unProfitLoss */
    @Excel(name = "unProfitLoss")
    private BigDecimal unProfitLoss;

    /** profit */
    @Excel(name = "profit")
    private BigDecimal profit;

    /** profitUp */
    @Excel(name = "profitUp")
    private BigDecimal profitUp;

    /** tokenNum */
    @Excel(name = "tokenNum")
    private BigDecimal tokenNum;

    /** isTokenNum */
    @Excel(name = "isTokenNum")
    private BigDecimal isTokenNum;

    /** avePrice */
    @Excel(name = "avePrice")
    private BigDecimal avePrice;

    /** closePrice */
    @Excel(name = "closePrice")
    private BigDecimal closePrice;

    /** triggerPrice */
    @Excel(name = "triggerPrice")
    private BigDecimal triggerPrice;

    /** ordPrice */
    @Excel(name = "ordPrice")
    private BigDecimal ordPrice;

    /** 用户 */
    @Excel(name = "用户")
    private String member;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String tradeType;

    /** avgLevel */
    @Excel(name = "avgLevel")
    private BigDecimal avgLevel;

    /** hands */
    @Excel(name = "hands")
    private BigDecimal hands;

    /** orders */
    @Excel(name = "orders")
    private BigDecimal orders;

    /** forcePrice */
    @Excel(name = "state")
    private BigDecimal forcePrice;

    /** state */
    @Excel(name = "state")
    private String state;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 控制输赢 */
    @Excel(name = "输赢")
    private Integer win;


    /** 控盘价 */
    @Excel(name = "控盘价")
    private Integer controlPrice;

    public Integer getControlPrice() {
        return controlPrice;
    }

    public void setControlPrice(Integer controlPrice) {
        this.controlPrice = controlPrice;
    }

    private String uuid;
    private String phone;
    private String mail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPairsName() {
        return pairsName;
    }

    public void setPairsName(String pairsName) {
        this.pairsName = pairsName;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getMainCur() {
        return mainCur;
    }

    public void setMainCur(String mainCur) {
        this.mainCur = mainCur;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public BigDecimal getUnProfitLoss() {
        return unProfitLoss;
    }

    public void setUnProfitLoss(BigDecimal unProfitLoss) {
        this.unProfitLoss = unProfitLoss;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getProfitUp() {
        return profitUp;
    }

    public void setProfitUp(BigDecimal profitUp) {
        this.profitUp = profitUp;
    }

    public BigDecimal getTokenNum() {
        return tokenNum;
    }

    public void setTokenNum(BigDecimal tokenNum) {
        this.tokenNum = tokenNum;
    }

    public BigDecimal getIsTokenNum() {
        return isTokenNum;
    }

    public void setIsTokenNum(BigDecimal isTokenNum) {
        this.isTokenNum = isTokenNum;
    }

    public BigDecimal getAvePrice() {
        return avePrice;
    }

    public void setAvePrice(BigDecimal avePrice) {
        this.avePrice = avePrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public BigDecimal getOrdPrice() {
        return ordPrice;
    }

    public void setOrdPrice(BigDecimal ordPrice) {
        this.ordPrice = ordPrice;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getAvgLevel() {
        return avgLevel;
    }

    public void setAvgLevel(BigDecimal avgLevel) {
        this.avgLevel = avgLevel;
    }

    public BigDecimal getHands() {
        return hands;
    }

    public void setHands(BigDecimal hands) {
        this.hands = hands;
    }

    public BigDecimal getOrders() {
        return orders;
    }

    public void setOrders(BigDecimal orders) {
        this.orders = orders;
    }

    public BigDecimal getForcePrice() {
        return forcePrice;
    }

    public void setForcePrice(BigDecimal forcePrice) {
        this.forcePrice = forcePrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
