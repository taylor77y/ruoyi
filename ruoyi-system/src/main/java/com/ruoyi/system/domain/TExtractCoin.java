package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提币审核对象 t_extract_coin
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class TExtractCoin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户id */
    @Excel(name = "用户id")
    private String member;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal balance;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal handlingFee;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 提币地址 */
    @Excel(name = "提币地址")
    private String wallet;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String state;

    /** php:交易hex/交易ID */
    @Excel(name = "php:交易hex/交易ID")
    private String hex;

    /** php:交易区块页面 */
    @Excel(name = "php:交易区块页面")
    private String viewInExplorer;

    /** php:出方地址 */
    @Excel(name = "php:出方地址")
    private String fromAddress;

    /** php:收方地址 */
    @Excel(name = "php:收方地址")
    private String toAddress;

    /** php:转账数量 */
    @Excel(name = "php:转账数量")
    private String tokenNumber;

    /** php:时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "php:时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date extractTime;

    private Integer type;
    private String chainName;
    private String bankUserName;
    private String bankName;
    private String bankAddress;
    private String bankCard;
    private BigDecimal exchangeRate;
    private BigDecimal amount;
    private String currencySymbol;

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

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
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setHandlingFee(BigDecimal handlingFee) 
    {
        this.handlingFee = handlingFee;
    }

    public BigDecimal getHandlingFee() 
    {
        return handlingFee;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setWallet(String wallet) 
    {
        this.wallet = wallet;
    }

    public String getWallet() 
    {
        return wallet;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setHex(String hex) 
    {
        this.hex = hex;
    }

    public String getHex() 
    {
        return hex;
    }
    public void setViewInExplorer(String viewInExplorer) 
    {
        this.viewInExplorer = viewInExplorer;
    }

    public String getViewInExplorer() 
    {
        return viewInExplorer;
    }
    public void setFromAddress(String fromAddress) 
    {
        this.fromAddress = fromAddress;
    }

    public String getFromAddress() 
    {
        return fromAddress;
    }
    public void setToAddress(String toAddress) 
    {
        this.toAddress = toAddress;
    }

    public String getToAddress() 
    {
        return toAddress;
    }
    public void setTokenNumber(String tokenNumber) 
    {
        this.tokenNumber = tokenNumber;
    }

    public String getTokenNumber() 
    {
        return tokenNumber;
    }
    public void setExtractTime(Date extractTime) 
    {
        this.extractTime = extractTime;
    }

    public Date getExtractTime() 
    {
        return extractTime;
    }

    private String phone;
    private String mail;
    private String uuid;
    private String lastPhone;
    private String smName;
    private String lastSmName;
    private String useType;

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }

    public String getLastSmName() {
        return lastSmName;
    }

    public void setLastSmName(String lastSmName) {
        this.lastSmName = lastSmName;
    }

    public String getLastPhone() {
        return lastPhone;
    }

    public void setLastPhone(String lastPhone) {
        this.lastPhone = lastPhone;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("member", getMember())
            .append("balance", getBalance())
            .append("handlingFee", getHandlingFee())
            .append("currency", getCurrency())
            .append("wallet", getWallet())
            .append("state", getState())
            .append("hex", getHex())
            .append("viewInExplorer", getViewInExplorer())
            .append("fromAddress", getFromAddress())
            .append("toAddress", getToAddress())
            .append("tokenNumber", getTokenNumber())
            .append("extractTime", getExtractTime())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
