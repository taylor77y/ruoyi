package com.ruoyi.system.domain.kline;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自发币控制对象 t_currency_controls
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public class TCurrencyControls extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币名称 */
    @Excel(name = "币名称")
    private String tokenCur;

    /** 起始价格（浮动价格） */
    @Excel(name = "起始价格", readConverterExp = "浮=动价格")
    private BigDecimal startingPrice;

    /** 结束价格（浮动价格） */
    @Excel(name = "结束价格", readConverterExp = "浮=动价格")
    private BigDecimal finalPrice;

    /** 最大交易量 */
    @Excel(name = "最大交易量")
    private BigDecimal tradingVolumeMax;

    /** 最小交易量 */
    @Excel(name = "最小交易量")
    private BigDecimal tradingVolumeMin;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private BigDecimal openingPrice;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private BigDecimal closingPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTokenCur(String tokenCur) 
    {
        this.tokenCur = tokenCur;
    }

    public String getTokenCur() 
    {
        return tokenCur;
    }
    public void setStartingPrice(BigDecimal startingPrice) 
    {
        this.startingPrice = startingPrice;
    }

    public BigDecimal getStartingPrice() 
    {
        return startingPrice;
    }
    public void setFinalPrice(BigDecimal finalPrice) 
    {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalPrice() 
    {
        return finalPrice;
    }
    public void setTradingVolumeMax(BigDecimal tradingVolumeMax) 
    {
        this.tradingVolumeMax = tradingVolumeMax;
    }

    public BigDecimal getTradingVolumeMax() 
    {
        return tradingVolumeMax;
    }
    public void setTradingVolumeMin(BigDecimal tradingVolumeMin) 
    {
        this.tradingVolumeMin = tradingVolumeMin;
    }

    public BigDecimal getTradingVolumeMin() 
    {
        return tradingVolumeMin;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setOpeningPrice(BigDecimal openingPrice) 
    {
        this.openingPrice = openingPrice;
    }

    public BigDecimal getOpeningPrice() 
    {
        return openingPrice;
    }
    public void setClosingPrice(BigDecimal closingPrice) 
    {
        this.closingPrice = closingPrice;
    }

    public BigDecimal getClosingPrice() 
    {
        return closingPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tokenCur", getTokenCur())
            .append("startingPrice", getStartingPrice())
            .append("finalPrice", getFinalPrice())
            .append("tradingVolumeMax", getTradingVolumeMax())
            .append("tradingVolumeMin", getTradingVolumeMin())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("openingPrice", getOpeningPrice())
            .append("closingPrice", getClosingPrice())
            .toString();
    }
}
