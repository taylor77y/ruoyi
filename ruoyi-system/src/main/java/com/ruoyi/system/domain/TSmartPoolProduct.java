package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_smart_pool_product
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class TSmartPoolProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

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

    /** 矿机购买币种 */
    @Excel(name = "矿机购买币种")
    private String buyPairsName;

    /** 矿机产出币种 */
    @Excel(name = "矿机产出币种")
    private String outPairsName;

    /** 周期（天） */
    @Excel(name = "周期", readConverterExp = "天=")
    private Integer periodDay;

    /** 可解锁周期(天) */
    @Excel(name = "可解锁周期(天)")
    private Integer periodDayUnlock;

    /** 日利率% */
    @Excel(name = "日利率%")
    private BigDecimal dayRate;

    /** 今日利率% */
    @Excel(name = "今日利率%")
    private BigDecimal todayRate;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
    public void setBuyPairsName(String buyPairsName) 
    {
        this.buyPairsName = buyPairsName;
    }

    public String getBuyPairsName() 
    {
        return buyPairsName;
    }
    public void setOutPairsName(String outPairsName) 
    {
        this.outPairsName = outPairsName;
    }

    public String getOutPairsName() 
    {
        return outPairsName;
    }
    public void setPeriodDay(Integer periodDay) 
    {
        this.periodDay = periodDay;
    }

    public Integer getPeriodDay() 
    {
        return periodDay;
    }
    public void setPeriodDayUnlock(Integer periodDayUnlock) 
    {
        this.periodDayUnlock = periodDayUnlock;
    }

    public Integer getPeriodDayUnlock() 
    {
        return periodDayUnlock;
    }
    public void setDayRate(BigDecimal dayRate) 
    {
        this.dayRate = dayRate;
    }

    public BigDecimal getDayRate() 
    {
        return dayRate;
    }
    public void setTodayRate(BigDecimal todayRate) 
    {
        this.todayRate = todayRate;
    }

    public BigDecimal getTodayRate() 
    {
        return todayRate;
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
            .append("buyPairsName", getBuyPairsName())
            .append("outPairsName", getOutPairsName())
            .append("periodDay", getPeriodDay())
            .append("periodDayUnlock", getPeriodDayUnlock())
            .append("dayRate", getDayRate())
            .append("todayRate", getTodayRate())
            .append("investmentAmountFront", getInvestmentAmountFront())
            .append("investmentAmountBehind", getInvestmentAmountBehind())
            .append("numAstrict", getNumAstrict())
            .append("enabled", getEnabled())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
