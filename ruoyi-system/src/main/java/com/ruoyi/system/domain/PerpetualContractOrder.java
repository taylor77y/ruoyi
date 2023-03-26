package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PerpetualContractOrder{
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户名称
     */
    private String memberId;

    /**
     * 交易对名称
     */
    private String pairsName;

    /**
     * 开始价
     */
    private BigDecimal kPrice;

    /**
     * 结束价
     */
    private BigDecimal bPrice;

    /**
     * 合约金额
     */
    private BigDecimal amount;

    /**
     * 保证金
     */
    private BigDecimal margin;


    /**
     * 手续费
     */
    private BigDecimal matchFee;

    /**
     * 收益
     */
    private BigDecimal profit;

    /**
     * 是否输赢
     */
    private int isWin;

    /**
     * 是否控盘
     */
    private int isControl;

    /**
     * 控盘价
     */
    private BigDecimal controlPrice;

    /**
     * 杠杆ID
     */
    private String leverId;

    /**
     * 杠杆数
     */
    private int leverNum;

    /**
     * 杠杆说明
     */
    private String leverDesc;

    /**
     * 结算状态（持仓，已平仓）
     */
    private String orderState;

    /**
     * 交易类型（开多，开空，平多，平空）
     */
    private String tradeType;

    /**
     * 手数
     */
    private BigDecimal contractHands;

    /**
     * 开始时间
     */
    private Date createTime;

    /**
     * 结束时间
     */
    private Date settleTime;

    private String uuid;
    private String phone;
    private String mail;

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

    public String getPairsName() {
        return pairsName;
    }

    public void setPairsName(String pairsName) {
        this.pairsName = pairsName;
    }

    public BigDecimal getkPrice() {
        return kPrice;
    }

    public void setkPrice(BigDecimal kPrice) {
        this.kPrice = kPrice;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public BigDecimal getMatchFee() {
        return matchFee;
    }

    public void setMatchFee(BigDecimal matchFee) {
        this.matchFee = matchFee;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public int getIsControl() {
        return isControl;
    }

    public void setIsControl(int isControl) {
        this.isControl = isControl;
    }

    public BigDecimal getControlPrice() {
        return controlPrice;
    }

    public void setControlPrice(BigDecimal controlPrice) {
        this.controlPrice = controlPrice;
    }

    public String getLeverId() {
        return leverId;
    }

    public void setLeverId(String leverId) {
        this.leverId = leverId;
    }

    public int getLeverNum() {
        return leverNum;
    }

    public void setLeverNum(int leverNum) {
        this.leverNum = leverNum;
    }

    public String getLeverDesc() {
        return leverDesc;
    }

    public void setLeverDesc(String leverDesc) {
        this.leverDesc = leverDesc;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getContractHands() {
        return contractHands;
    }

    public void setContractHands(BigDecimal contractHands) {
        this.contractHands = contractHands;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }
}
