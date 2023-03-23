package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 法币配置对象 t_member_currency_config
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class TMemberCurrencyConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 币种名称 */
    @Excel(name = "币种名称")
    private String currencyName;

    /** 汇率 */
    @Excel(name = "汇率")
    private BigDecimal rate;

    /** 符号 */
    @Excel(name = "符号")
    private String mark;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCurrencyName(String currencyName) 
    {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() 
    {
        return currencyName;
    }
    public void setRate(BigDecimal rate) 
    {
        this.rate = rate;
    }

    public BigDecimal getRate() 
    {
        return rate;
    }
    public void setMark(String mark) 
    {
        this.mark = mark;
    }

    public String getMark() 
    {
        return mark;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("currencyName", getCurrencyName())
            .append("rate", getRate())
            .append("mark", getMark())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .toString();
    }
}
