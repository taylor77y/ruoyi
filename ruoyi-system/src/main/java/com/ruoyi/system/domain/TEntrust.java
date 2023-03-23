package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币币撮合对象 t_entrust
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class TEntrust extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pairs;

    /** 主币 */
    @Excel(name = "主币")
    private String mainCur;

    /** 代币 */
    @Excel(name = "代币")
    private String tokenCur;

    /** 交易对 */
    @Excel(name = "交易对")
    private String pairsName;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 成交价格 */
    @Excel(name = "成交价格")
    private BigDecimal matchPrice;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal count;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal percentageCount;

    /** 成交数量 */
    @Excel(name = "成交数量")
    private BigDecimal matchCount;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private BigDecimal surplusCount;

    /** 会员id */
    @Excel(name = "会员id")
    private String member;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String memberType;

    /** 手续费费率 */
    @Excel(name = "手续费费率")
    private BigDecimal tradeRate;

    /** 委托类型 */
    @Excel(name = "委托类型")
    private String entrustType;

    /** 成交方式 */
    @Excel(name = "成交方式")
    private String methodType;

    /**  */
    @Excel(name = "")
    private String priceType;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal tradeFee;

    /** 撮合方 */
    @Excel(name = "撮合方")
    private String matchMember;

    /** 撮合总额 */
    @Excel(name = "撮合总额")
    private BigDecimal matchFee;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPairs(String pairs) 
    {
        this.pairs = pairs;
    }

    public String getPairs() 
    {
        return pairs;
    }
    public void setMainCur(String mainCur) 
    {
        this.mainCur = mainCur;
    }

    public String getMainCur() 
    {
        return mainCur;
    }
    public void setTokenCur(String tokenCur) 
    {
        this.tokenCur = tokenCur;
    }

    public String getTokenCur() 
    {
        return tokenCur;
    }
    public void setPairsName(String pairsName) 
    {
        this.pairsName = pairsName;
    }

    public String getPairsName() 
    {
        return pairsName;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setMatchPrice(BigDecimal matchPrice) 
    {
        this.matchPrice = matchPrice;
    }

    public BigDecimal getMatchPrice() 
    {
        return matchPrice;
    }
    public void setCount(BigDecimal count) 
    {
        this.count = count;
    }

    public BigDecimal getCount() 
    {
        return count;
    }
    public void setPercentageCount(BigDecimal percentageCount) 
    {
        this.percentageCount = percentageCount;
    }

    public BigDecimal getPercentageCount() 
    {
        return percentageCount;
    }
    public void setMatchCount(BigDecimal matchCount) 
    {
        this.matchCount = matchCount;
    }

    public BigDecimal getMatchCount() 
    {
        return matchCount;
    }
    public void setSurplusCount(BigDecimal surplusCount) 
    {
        this.surplusCount = surplusCount;
    }

    public BigDecimal getSurplusCount() 
    {
        return surplusCount;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setMemberType(String memberType) 
    {
        this.memberType = memberType;
    }

    public String getMemberType() 
    {
        return memberType;
    }
    public void setTradeRate(BigDecimal tradeRate) 
    {
        this.tradeRate = tradeRate;
    }

    public BigDecimal getTradeRate() 
    {
        return tradeRate;
    }
    public void setEntrustType(String entrustType) 
    {
        this.entrustType = entrustType;
    }

    public String getEntrustType() 
    {
        return entrustType;
    }
    public void setMethodType(String methodType) 
    {
        this.methodType = methodType;
    }

    public String getMethodType() 
    {
        return methodType;
    }
    public void setPriceType(String priceType) 
    {
        this.priceType = priceType;
    }

    public String getPriceType() 
    {
        return priceType;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setTradeFee(BigDecimal tradeFee) 
    {
        this.tradeFee = tradeFee;
    }

    public BigDecimal getTradeFee() 
    {
        return tradeFee;
    }
    public void setMatchMember(String matchMember) 
    {
        this.matchMember = matchMember;
    }

    public String getMatchMember() 
    {
        return matchMember;
    }
    public void setMatchFee(BigDecimal matchFee) 
    {
        this.matchFee = matchFee;
    }

    public BigDecimal getMatchFee() 
    {
        return matchFee;
    }

    private String phone;
    private String mail;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pairs", getPairs())
            .append("mainCur", getMainCur())
            .append("tokenCur", getTokenCur())
            .append("pairsName", getPairsName())
            .append("price", getPrice())
            .append("matchPrice", getMatchPrice())
            .append("count", getCount())
            .append("percentageCount", getPercentageCount())
            .append("matchCount", getMatchCount())
            .append("surplusCount", getSurplusCount())
            .append("member", getMember())
            .append("memberType", getMemberType())
            .append("tradeRate", getTradeRate())
            .append("entrustType", getEntrustType())
            .append("methodType", getMethodType())
            .append("priceType", getPriceType())
            .append("state", getState())
            .append("tradeFee", getTradeFee())
            .append("matchMember", getMatchMember())
            .append("matchFee", getMatchFee())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
