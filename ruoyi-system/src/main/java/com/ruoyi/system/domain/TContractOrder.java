package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合约订单对象 t_contract_order
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TContractOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 交易对名称 */
    @Excel(name = "交易对名称")
    private String pairsName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mainCur;

    /** 币种名称 */
    @Excel(name = "币种名称")
    private String coinName;

    /** 杠杆倍数 */
    @Excel(name = "杠杆倍数")
    private Long leverNum;

    /** 杠杆描述 */
    @Excel(name = "杠杆描述")
    private String leverDesc;

    /** 保证金 */
    @Excel(name = "保证金")
    private BigDecimal margin;

    /** 手数 */
    @Excel(name = "手数")
    private Long contractHands;

    /** 持仓价格 */
    @Excel(name = "持仓价格")
    private BigDecimal price;

    /** 撮合价格 */
    @Excel(name = "撮合价格")
    private BigDecimal matchPrice;

    /** 平仓金额 */
    @Excel(name = "平仓金额")
    private BigDecimal matchFee;

    /** 平仓类型 */
    @Excel(name = "平仓类型")
    private String closeType;

    /** 价格类型 */
    @Excel(name = "价格类型")
    private String priceType;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal coinNum;

    /** 可用合约乘数 */
    @Excel(name = "可用合约乘数")
    private BigDecimal isContractHands;

    /** 状态 */
    @Excel(name = "状态")
    private String orderState;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal takeFee;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private String orderType;

    /** 用户 */
    @Excel(name = "用户")
    private String member;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String tradeType;

    /** 合约配置 ID */
    @Excel(name = "合约配置 ID")
    private String contractMulId;

    /** 杠杆 ID */
    @Excel(name = "杠杆 ID")
    private String leverId;

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
    public void setCoinName(String coinName) 
    {
        this.coinName = coinName;
    }

    public String getCoinName() 
    {
        return coinName;
    }
    public void setLeverNum(Long leverNum) 
    {
        this.leverNum = leverNum;
    }

    public Long getLeverNum() 
    {
        return leverNum;
    }
    public void setLeverDesc(String leverDesc) 
    {
        this.leverDesc = leverDesc;
    }

    public String getLeverDesc() 
    {
        return leverDesc;
    }
    public void setMargin(BigDecimal margin) 
    {
        this.margin = margin;
    }

    public BigDecimal getMargin() 
    {
        return margin;
    }
    public void setContractHands(Long contractHands) 
    {
        this.contractHands = contractHands;
    }

    public Long getContractHands() 
    {
        return contractHands;
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
    public void setMatchFee(BigDecimal matchFee) 
    {
        this.matchFee = matchFee;
    }

    public BigDecimal getMatchFee() 
    {
        return matchFee;
    }
    public void setCloseType(String closeType) 
    {
        this.closeType = closeType;
    }

    public String getCloseType() 
    {
        return closeType;
    }
    public void setPriceType(String priceType) 
    {
        this.priceType = priceType;
    }

    public String getPriceType() 
    {
        return priceType;
    }
    public void setCoinNum(BigDecimal coinNum) 
    {
        this.coinNum = coinNum;
    }

    public BigDecimal getCoinNum() 
    {
        return coinNum;
    }
    public void setIsContractHands(BigDecimal isContractHands) 
    {
        this.isContractHands = isContractHands;
    }

    public BigDecimal getIsContractHands() 
    {
        return isContractHands;
    }
    public void setOrderState(String orderState) 
    {
        this.orderState = orderState;
    }

    public String getOrderState() 
    {
        return orderState;
    }
    public void setTakeFee(BigDecimal takeFee) 
    {
        this.takeFee = takeFee;
    }

    public BigDecimal getTakeFee() 
    {
        return takeFee;
    }
    public void setOrderType(String orderType) 
    {
        this.orderType = orderType;
    }

    public String getOrderType() 
    {
        return orderType;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setTradeType(String tradeType) 
    {
        this.tradeType = tradeType;
    }

    public String getTradeType() 
    {
        return tradeType;
    }
    public void setContractMulId(String contractMulId) 
    {
        this.contractMulId = contractMulId;
    }

    public String getContractMulId() 
    {
        return contractMulId;
    }
    public void setLeverId(String leverId) 
    {
        this.leverId = leverId;
    }

    public String getLeverId() 
    {
        return leverId;
    }

    private String phone;
    private String mail;

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
            .append("pairsName", getPairsName())
            .append("mainCur", getMainCur())
            .append("coinName", getCoinName())
            .append("leverNum", getLeverNum())
            .append("leverDesc", getLeverDesc())
            .append("margin", getMargin())
            .append("contractHands", getContractHands())
            .append("price", getPrice())
            .append("matchPrice", getMatchPrice())
            .append("matchFee", getMatchFee())
            .append("closeType", getCloseType())
            .append("priceType", getPriceType())
            .append("coinNum", getCoinNum())
            .append("isContractHands", getIsContractHands())
            .append("orderState", getOrderState())
            .append("takeFee", getTakeFee())
            .append("orderType", getOrderType())
            .append("member", getMember())
            .append("tradeType", getTradeType())
            .append("contractMulId", getContractMulId())
            .append("leverId", getLeverId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
