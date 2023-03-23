package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易对配置对象 t_pairs
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TPairs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 交易对名称 */
    @Excel(name = "交易对名称")
    private String pairsName;

    /** 主币 */
    @Excel(name = "主币")
    private String mainCur;

    /** 代币 */
    @Excel(name = "代币")
    private String tokenCur;

    /** 冻结状态 */
    @Excel(name = "冻结状态")
    private String state;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String contract;

    /** 合约小数位 */
    @Excel(name = "合约小数位")
    private Long point;

    /** LOGO */
    @Excel(name = "LOGO")
    private String image;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private BigDecimal openPrice;

    /** 现价 */
    @Excel(name = "现价")
    private BigDecimal price;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal chPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal volume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal open;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal lowPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal higPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal updown;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Integer isTop;

    /** 最大交易数量 */
    @Excel(name = "最大交易数量")
    private Long tradeMax;

    /** 最小交易数量 */
    @Excel(name = "最小交易数量")
    private Long tradeMin;

    /** 币币 */
    @Excel(name = "币币")
    private String tradeType;

    /** 交易手续费 */
    @Excel(name = "交易手续费")
    private BigDecimal tradeRate;

    /** 主链 */
    @Excel(name = "主链")
    private String mainFrom;

    /** 充提开关 */
    @Excel(name = "充提开关")
    private String isDw;

    /** 最提币数量 */
    @Excel(name = "最提币数量")
    private BigDecimal withdrawMin;

    /** 提币手续费 */
    @Excel(name = "提币手续费")
    private BigDecimal withdrawFee;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPairsName(String pairsName) 
    {
        this.pairsName = pairsName;
    }

    public String getPairsName() 
    {
        return pairsName;
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
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setContract(String contract) 
    {
        this.contract = contract;
    }

    public String getContract() 
    {
        return contract;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setOpenPrice(BigDecimal openPrice) 
    {
        this.openPrice = openPrice;
    }

    public BigDecimal getOpenPrice() 
    {
        return openPrice;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setChPrice(BigDecimal chPrice) 
    {
        this.chPrice = chPrice;
    }

    public BigDecimal getChPrice() 
    {
        return chPrice;
    }
    public void setVolume(BigDecimal volume) 
    {
        this.volume = volume;
    }

    public BigDecimal getVolume() 
    {
        return volume;
    }
    public void setOpen(BigDecimal open) 
    {
        this.open = open;
    }

    public BigDecimal getOpen() 
    {
        return open;
    }
    public void setLowPrice(BigDecimal lowPrice) 
    {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getLowPrice() 
    {
        return lowPrice;
    }
    public void setHigPrice(BigDecimal higPrice) 
    {
        this.higPrice = higPrice;
    }

    public BigDecimal getHigPrice() 
    {
        return higPrice;
    }
    public void setUpdown(BigDecimal updown) 
    {
        this.updown = updown;
    }

    public BigDecimal getUpdown() 
    {
        return updown;
    }
    public void setIsTop(Integer isTop) 
    {
        this.isTop = isTop;
    }

    public Integer getIsTop() 
    {
        return isTop;
    }
    public void setTradeMax(Long tradeMax) 
    {
        this.tradeMax = tradeMax;
    }

    public Long getTradeMax() 
    {
        return tradeMax;
    }
    public void setTradeMin(Long tradeMin) 
    {
        this.tradeMin = tradeMin;
    }

    public Long getTradeMin() 
    {
        return tradeMin;
    }
    public void setTradeType(String tradeType) 
    {
        this.tradeType = tradeType;
    }

    public String getTradeType() 
    {
        return tradeType;
    }
    public void setTradeRate(BigDecimal tradeRate) 
    {
        this.tradeRate = tradeRate;
    }

    public BigDecimal getTradeRate() 
    {
        return tradeRate;
    }
    public void setMainFrom(String mainFrom) 
    {
        this.mainFrom = mainFrom;
    }

    public String getMainFrom() 
    {
        return mainFrom;
    }
    public void setIsDw(String isDw) 
    {
        this.isDw = isDw;
    }

    public String getIsDw() 
    {
        return isDw;
    }
    public void setWithdrawMin(BigDecimal withdrawMin) 
    {
        this.withdrawMin = withdrawMin;
    }

    public BigDecimal getWithdrawMin() 
    {
        return withdrawMin;
    }
    public void setWithdrawFee(BigDecimal withdrawFee) 
    {
        this.withdrawFee = withdrawFee;
    }

    public BigDecimal getWithdrawFee() 
    {
        return withdrawFee;
    }

    private Integer pairsType;

    public Integer getPairsType() {
        return pairsType;
    }

    public void setPairsType(Integer pairsType) {
        this.pairsType = pairsType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pairsName", getPairsName())
            .append("mainCur", getMainCur())
            .append("tokenCur", getTokenCur())
            .append("state", getState())
            .append("type", getType())
            .append("contract", getContract())
            .append("point", getPoint())
            .append("image", getImage())
            .append("sort", getSort())
            .append("openPrice", getOpenPrice())
            .append("price", getPrice())
            .append("chPrice", getChPrice())
            .append("volume", getVolume())
            .append("open", getOpen())
            .append("lowPrice", getLowPrice())
            .append("higPrice", getHigPrice())
            .append("updown", getUpdown())
            .append("isTop", getIsTop())
            .append("tradeMax", getTradeMax())
            .append("tradeMin", getTradeMin())
            .append("tradeType", getTradeType())
            .append("tradeRate", getTradeRate())
            .append("mainFrom", getMainFrom())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("isDw", getIsDw())
            .append("withdrawMin", getWithdrawMin())
            .append("withdrawFee", getWithdrawFee())
            .toString();
    }
}
