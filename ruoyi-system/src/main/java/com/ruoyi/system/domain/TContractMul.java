package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合约交易对对象 t_contract_mul
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TContractMul extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 交易对名称 */
    @Excel(name = "交易对名称")
    private String pairsName;

    /** 合约乘数 */
    @Excel(name = "合约乘数")
    private BigDecimal contractMul;

    /** 强平价格 */
    @Excel(name = "强平价格")
    private BigDecimal forcePrice;

    /** 开仓手续费 */
    @Excel(name = "开仓手续费")
    private BigDecimal makerFee;

    /** 平仓手续费 */
    @Excel(name = "平仓手续费")
    private BigDecimal takerFee;

    /** 强平手续费 */
    @Excel(name = "强平手续费")
    private BigDecimal forceFee;

    /** 交易手续费 */
    @Excel(name = "交易手续费")
    private BigDecimal tradeFee;

    /** 提币手续费 */
    @Excel(name = "提币手续费")
    private BigDecimal withdrawFee;

    /** 维持保证金比率 */
    @Excel(name = "维持保证金比率")
    private BigDecimal ensure;

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
    public void setContractMul(BigDecimal contractMul) 
    {
        this.contractMul = contractMul;
    }

    public BigDecimal getContractMul() 
    {
        return contractMul;
    }
    public void setForcePrice(BigDecimal forcePrice) 
    {
        this.forcePrice = forcePrice;
    }

    public BigDecimal getForcePrice() 
    {
        return forcePrice;
    }
    public void setMakerFee(BigDecimal makerFee) 
    {
        this.makerFee = makerFee;
    }

    public BigDecimal getMakerFee() 
    {
        return makerFee;
    }
    public void setTakerFee(BigDecimal takerFee) 
    {
        this.takerFee = takerFee;
    }

    public BigDecimal getTakerFee() 
    {
        return takerFee;
    }
    public void setForceFee(BigDecimal forceFee) 
    {
        this.forceFee = forceFee;
    }

    public BigDecimal getForceFee() 
    {
        return forceFee;
    }
    public void setTradeFee(BigDecimal tradeFee) 
    {
        this.tradeFee = tradeFee;
    }

    public BigDecimal getTradeFee() 
    {
        return tradeFee;
    }
    public void setWithdrawFee(BigDecimal withdrawFee) 
    {
        this.withdrawFee = withdrawFee;
    }

    public BigDecimal getWithdrawFee() 
    {
        return withdrawFee;
    }
    public void setEnsure(BigDecimal ensure) 
    {
        this.ensure = ensure;
    }

    public BigDecimal getEnsure() 
    {
        return ensure;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pairsName", getPairsName())
            .append("contractMul", getContractMul())
            .append("forcePrice", getForcePrice())
            .append("makerFee", getMakerFee())
            .append("takerFee", getTakerFee())
            .append("forceFee", getForceFee())
            .append("tradeFee", getTradeFee())
            .append("withdrawFee", getWithdrawFee())
            .append("ensure", getEnsure())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
