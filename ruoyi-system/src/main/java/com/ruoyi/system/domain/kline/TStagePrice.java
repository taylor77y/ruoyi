package com.ruoyi.system.domain.kline;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自发币时间阶段价格对象 t_stage_price
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public class TStagePrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币名称 */
    @Excel(name = "币名称")
    private String tokenCur;

    /** 时间类型：1m,5m,15m,30m,1h,1d,1w */
    @Excel(name = "时间类型：1m,5m,15m,30m,1h,1d,1w")
    private String timeType;

    /** 最高价 */
    @Excel(name = "最高价")
    private BigDecimal high;

    /** 最低价 */
    @Excel(name = "最低价")
    private BigDecimal low;

    /** 成交量 */
    @Excel(name = "成交量")
    private BigDecimal volume;

    /** 成交额 */
    @Excel(name = "成交额")
    private BigDecimal vol;

    /** 成交笔数 */
    @Excel(name = "成交笔数")
    private Integer count;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private BigDecimal open;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private BigDecimal close;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

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
    public void setTimeType(String timeType)
    {
        this.timeType = timeType;
    }

    public String getTimeType()
    {
        return timeType;
    }
    public void setHigh(BigDecimal high)
    {
        this.high = high;
    }

    public BigDecimal getHigh()
    {
        return high;
    }
    public void setLow(BigDecimal low)
    {
        this.low = low;
    }

    public BigDecimal getLow()
    {
        return low;
    }
    public void setVolume(BigDecimal volume)
    {
        this.volume = volume;
    }

    public BigDecimal getVolume()
    {
        return volume;
    }
    public void setVol(BigDecimal vol)
    {
        this.vol = vol;
    }

    public BigDecimal getVol()
    {
        return vol;
    }
    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Integer getCount()
    {
        return count;
    }
    public void setOpen(BigDecimal open)
    {
        this.open = open;
    }

    public BigDecimal getOpen()
    {
        return open;
    }
    public void setClose(BigDecimal close)
    {
        this.close = close;
    }

    public BigDecimal getClose()
    {
        return close;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tokenCur", getTokenCur())
                .append("timeType", getTimeType())
                .append("high", getHigh())
                .append("low", getLow())
                .append("volume", getVolume())
                .append("vol", getVol())
                .append("count", getCount())
                .append("open", getOpen())
                .append("close", getClose())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}