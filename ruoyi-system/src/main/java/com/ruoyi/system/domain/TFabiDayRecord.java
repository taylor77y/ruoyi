package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 法币交易统计对象 t_fabi_day_record
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public class TFabiDayRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 当日购买 */
    @Excel(name = "当日购买")
    private BigDecimal sumBuy;

    /** 当日出售 */
    @Excel(name = "当日出售")
    private BigDecimal sumSell;

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
    public void setSumBuy(BigDecimal sumBuy) 
    {
        this.sumBuy = sumBuy;
    }

    public BigDecimal getSumBuy() 
    {
        return sumBuy;
    }
    public void setSumSell(BigDecimal sumSell) 
    {
        this.sumSell = sumSell;
    }

    public BigDecimal getSumSell() 
    {
        return sumSell;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("currency", getCurrency())
            .append("sumBuy", getSumBuy())
            .append("sumSell", getSumSell())
            .append("createTime", getCreateTime())
            .toString();
    }
}
