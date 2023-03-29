package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_fund_product
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class TFundProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 简体名称 */
    @Excel(name = "简体名称")
    private String zhName;

    /** 繁体名称 */
    @Excel(name = "繁体名称")
    private String zhTwName;

    /** 英文名称 */
    @Excel(name = "英文名称")
    private String enName;

    /** 韩文名称 */
    @Excel(name = "韩文名称")
    private String koName;

    /** 日文名称 */
    @Excel(name = "日文名称")
    private String jaName;

    /** 产品图片 */
    @Excel(name = "产品图片")
    private String fundImage;

    /** 周期（天） */
    @Excel(name = "周期", readConverterExp = "天=")
    private Integer periodDay;

    /** 日利率%（前） */
    @Excel(name = "日利率%", readConverterExp = "前=")
    private BigDecimal dayRateFront;

    /** 日利率%(后) */
    @Excel(name = "日利率%(后)")
    private BigDecimal dayRateBehind;

    /** 今日利率% */
    @Excel(name = "今日利率%")
    private BigDecimal todayRate;

    /** 违约结算比列% */
    @Excel(name = "违约结算比列%")
    private BigDecimal defaultRatio;

    /** 投资金额USDT（小） */
    @Excel(name = "投资金额USDT", readConverterExp = "小=")
    private BigDecimal investmentAmountFront;

    /** 投资金额USDT（大） */
    @Excel(name = "投资金额USDT", readConverterExp = "大=")
    private BigDecimal investmentAmountBehind;

    /** 数量限制 */
    @Excel(name = "数量限制")
    private Integer numAstrict;

    /** 状态(0停用，1启用) */
    @Excel(name = "状态(0停用，1启用)")
    private Integer enabled;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setZhName(String zhName) 
    {
        this.zhName = zhName;
    }

    public String getZhName() 
    {
        return zhName;
    }
    public void setZhTwName(String zhTwName) 
    {
        this.zhTwName = zhTwName;
    }

    public String getZhTwName() 
    {
        return zhTwName;
    }
    public void setEnName(String enName) 
    {
        this.enName = enName;
    }

    public String getEnName() 
    {
        return enName;
    }
    public void setKoName(String koName) 
    {
        this.koName = koName;
    }

    public String getKoName() 
    {
        return koName;
    }
    public void setJaName(String jaName) 
    {
        this.jaName = jaName;
    }

    public String getJaName() 
    {
        return jaName;
    }
    public void setFundImage(String fundImage) 
    {
        this.fundImage = fundImage;
    }

    public String getFundImage() 
    {
        return fundImage;
    }
    public void setPeriodDay(Integer periodDay) 
    {
        this.periodDay = periodDay;
    }

    public Integer getPeriodDay() 
    {
        return periodDay;
    }
    public void setDayRateFront(BigDecimal dayRateFront) 
    {
        this.dayRateFront = dayRateFront;
    }

    public BigDecimal getDayRateFront() 
    {
        return dayRateFront;
    }
    public void setDayRateBehind(BigDecimal dayRateBehind) 
    {
        this.dayRateBehind = dayRateBehind;
    }

    public BigDecimal getDayRateBehind() 
    {
        return dayRateBehind;
    }
    public void setTodayRate(BigDecimal todayRate) 
    {
        this.todayRate = todayRate;
    }

    public BigDecimal getTodayRate() 
    {
        return todayRate;
    }
    public void setDefaultRatio(BigDecimal defaultRatio) 
    {
        this.defaultRatio = defaultRatio;
    }

    public BigDecimal getDefaultRatio() 
    {
        return defaultRatio;
    }
    public void setInvestmentAmountFront(BigDecimal investmentAmountFront) 
    {
        this.investmentAmountFront = investmentAmountFront;
    }

    public BigDecimal getInvestmentAmountFront() 
    {
        return investmentAmountFront;
    }
    public void setInvestmentAmountBehind(BigDecimal investmentAmountBehind) 
    {
        this.investmentAmountBehind = investmentAmountBehind;
    }

    public BigDecimal getInvestmentAmountBehind() 
    {
        return investmentAmountBehind;
    }
    public void setNumAstrict(Integer numAstrict) 
    {
        this.numAstrict = numAstrict;
    }

    public Integer getNumAstrict() 
    {
        return numAstrict;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("zhName", getZhName())
            .append("zhTwName", getZhTwName())
            .append("enName", getEnName())
            .append("koName", getKoName())
            .append("jaName", getJaName())
            .append("fundImage", getFundImage())
            .append("periodDay", getPeriodDay())
            .append("dayRateFront", getDayRateFront())
            .append("dayRateBehind", getDayRateBehind())
            .append("todayRate", getTodayRate())
            .append("defaultRatio", getDefaultRatio())
            .append("investmentAmountFront", getInvestmentAmountFront())
            .append("investmentAmountBehind", getInvestmentAmountBehind())
            .append("numAstrict", getNumAstrict())
            .append("enabled", getEnabled())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
