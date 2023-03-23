package com.ruoyi.system.domain.kline;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自发币K线数据对象 t_kline_data
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public class TKlineData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币名称 */
    @Excel(name = "币名称")
    private String tokenCur;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private BigDecimal open;

    /** 收盘价（当K线为最晚的一根时，是最新成交价） */
    @Excel(name = "收盘价", readConverterExp = "当=K线为最晚的一根时，是最新成交价")
    private BigDecimal close;

    /** 最低价 */
    @Excel(name = "最低价")
    private BigDecimal low;

    /** 最高价 */
    @Excel(name = "最高价")
    private BigDecimal high;

    /** 成交量 */
    @Excel(name = "成交量")
    private BigDecimal volume;

    /** 成交额, 即 sum(每一笔成交价 * 该笔的成交量) */
    @Excel(name = "成交额, 即 sum(每一笔成交价 * 该笔的成交量)")
    private BigDecimal vol;

    /** 成交笔数 */
    @Excel(name = "成交笔数")
    private Long count;

    /** 当前价格 */
    @Excel(name = "当前价格")
    private BigDecimal price;

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
    public void setLow(BigDecimal low) 
    {
        this.low = low;
    }

    public BigDecimal getLow() 
    {
        return low;
    }
    public void setHigh(BigDecimal high) 
    {
        this.high = high;
    }

    public BigDecimal getHigh() 
    {
        return high;
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
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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
            .append("open", getOpen())
            .append("close", getClose())
            .append("low", getLow())
            .append("high", getHigh())
            .append("volume", getVolume())
            .append("vol", getVol())
            .append("count", getCount())
            .append("price", getPrice())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
