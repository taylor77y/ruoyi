package com.ruoyi.common.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity基类
 * 
 * @author ruoyi
 */
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 搜索值 */
    private String searchValue;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    private String remark;

    /** 请求参数 */
    private Map<String, Object> params;

    private List<String> sysIds;//后台id组

    private String hash;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<String> getSysIds() {
        return sysIds;
    }

    public void setSysIds(List<String> sysIds) {
        this.sysIds = sysIds;
    }

    public String getSearchValue()
    {
        return searchValue;
    }

    public void setSearchValue(String searchValue)
    {
        this.searchValue = searchValue;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

    //开始时间
    private Date openTime;
    //关闭时间
    private Date closeTime;
    //充值 BTC、ETH、USDT
    private BigDecimal btcAmount;
    private BigDecimal ethAmount;
    private BigDecimal usdtAmount;
    //提现
    private BigDecimal txAmount;
    //法币买卖
    private BigDecimal fbBuyAmount;
    private BigDecimal fbSellAmount;
    //秒合约输赢
    private BigDecimal mhyWinAmount;
    private BigDecimal mhyDonateAmount;

    //虚拟上下分(USDT)
    private BigDecimal xnUpAmount;
    private BigDecimal xnDownAmount;
    //虚拟上下分(BTC)
    private BigDecimal xnUpAmountBTC;
    private BigDecimal xnDownAmountBTC;
    //虚拟上下分(ETH)
    private BigDecimal xnUpAmountETH;
    private BigDecimal xnDownAmountETH;

    public BigDecimal getXnUpAmountBTC() {
        return xnUpAmountBTC;
    }

    public void setXnUpAmountBTC(BigDecimal xnUpAmountBTC) {
        this.xnUpAmountBTC = xnUpAmountBTC;
    }

    public BigDecimal getXnDownAmountBTC() {
        return xnDownAmountBTC;
    }

    public void setXnDownAmountBTC(BigDecimal xnDownAmountBTC) {
        this.xnDownAmountBTC = xnDownAmountBTC;
    }

    public BigDecimal getXnUpAmountETH() {
        return xnUpAmountETH;
    }

    public void setXnUpAmountETH(BigDecimal xnUpAmountETH) {
        this.xnUpAmountETH = xnUpAmountETH;
    }

    public BigDecimal getXnDownAmountETH() {
        return xnDownAmountETH;
    }

    public void setXnDownAmountETH(BigDecimal xnDownAmountETH) {
        this.xnDownAmountETH = xnDownAmountETH;
    }

    public BigDecimal getXnUpAmount() {
        return xnUpAmount;
    }

    public void setXnUpAmount(BigDecimal xnUpAmount) {
        this.xnUpAmount = xnUpAmount;
    }

    public BigDecimal getXnDownAmount() {
        return xnDownAmount;
    }

    public void setXnDownAmount(BigDecimal xnDownAmount) {
        this.xnDownAmount = xnDownAmount;
    }

    public BigDecimal getMhyWinAmount() {
        return mhyWinAmount;
    }

    public void setMhyWinAmount(BigDecimal mhyWinAmount) {
        this.mhyWinAmount = mhyWinAmount;
    }

    public BigDecimal getMhyDonateAmount() {
        return mhyDonateAmount;
    }

    public void setMhyDonateAmount(BigDecimal mhyDonateAmount) {
        this.mhyDonateAmount = mhyDonateAmount;
    }

    public BigDecimal getFbBuyAmount() {
        return fbBuyAmount;
    }

    public void setFbBuyAmount(BigDecimal fbBuyAmount) {
        this.fbBuyAmount = fbBuyAmount;
    }

    public BigDecimal getFbSellAmount() {
        return fbSellAmount;
    }

    public void setFbSellAmount(BigDecimal fbSellAmount) {
        this.fbSellAmount = fbSellAmount;
    }

    public BigDecimal getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(BigDecimal txAmount) {
        this.txAmount = txAmount;
    }

    public BigDecimal getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(BigDecimal btcAmount) {
        this.btcAmount = btcAmount;
    }

    public BigDecimal getEthAmount() {
        return ethAmount;
    }

    public void setEthAmount(BigDecimal ethAmount) {
        this.ethAmount = ethAmount;
    }

    public BigDecimal getUsdtAmount() {
        return usdtAmount;
    }

    public void setUsdtAmount(BigDecimal usdtAmount) {
        this.usdtAmount = usdtAmount;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
