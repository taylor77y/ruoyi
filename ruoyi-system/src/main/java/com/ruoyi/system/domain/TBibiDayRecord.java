package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币种交易量对象 t_bibi_day_record
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public class TBibiDayRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 币币总购买 */
    @Excel(name = "币币总购买")
    private BigDecimal sumBibiBuy;

    /** 币币总出售 */
    @Excel(name = "币币总出售")
    private BigDecimal sumBibiSell;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setSumBibiBuy(BigDecimal sumBibiBuy) 
    {
        this.sumBibiBuy = sumBibiBuy;
    }

    public BigDecimal getSumBibiBuy() 
    {
        return sumBibiBuy;
    }
    public void setSumBibiSell(BigDecimal sumBibiSell) 
    {
        this.sumBibiSell = sumBibiSell;
    }

    public BigDecimal getSumBibiSell() 
    {
        return sumBibiSell;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("currency", getCurrency())
            .append("sumBibiBuy", getSumBibiBuy())
            .append("sumBibiSell", getSumBibiSell())
            .append("createTime", getCreateTime())
            .toString();
    }
}
