package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 秒合约配置对象 t_seconds_config
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class TSecondsConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 秒数 */
    @Excel(name = "秒数")
    private Long seconds;

    /** 时分（s秒，m分钟，h小时） */
    @Excel(name = "时分", readConverterExp = "s=秒，m分钟，h小时")
    private String secondsTime;

    /** 最低下注 */
    @Excel(name = "最低下注")
    private BigDecimal minimum;

    /** 赔率 */
    @Excel(name = "赔率")
    private BigDecimal odds;

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
    public void setSeconds(Long seconds) 
    {
        this.seconds = seconds;
    }

    public Long getSeconds() 
    {
        return seconds;
    }
    public void setSecondsTime(String secondsTime) 
    {
        this.secondsTime = secondsTime;
    }

    public String getSecondsTime() 
    {
        return secondsTime;
    }
    public void setMinimum(BigDecimal minimum) 
    {
        this.minimum = minimum;
    }

    public BigDecimal getMinimum() 
    {
        return minimum;
    }
    public void setOdds(BigDecimal odds) 
    {
        this.odds = odds;
    }

    public BigDecimal getOdds() 
    {
        return odds;
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
            .append("seconds", getSeconds())
            .append("secondsTime", getSecondsTime())
            .append("minimum", getMinimum())
            .append("odds", getOdds())
            .append("createTime", getCreateTime())
            .append("sort", getSort())
            .toString();
    }
}
