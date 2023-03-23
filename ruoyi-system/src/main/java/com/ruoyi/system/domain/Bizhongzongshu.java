package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 用户余额对象 t_balance
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public class Bizhongzongshu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 总数 */
    @Excel(name = "总数")
    private BigDecimal sum;

    /** 币币可用 */
    @Excel(name = "币币可用")
    private BigDecimal bibikeyong;

    /** 币币冻结 */
    @Excel(name = "币币冻结")
    private BigDecimal bibidongjie;

    /** 充提可用 */
    @Excel(name = "充提可用")
    private BigDecimal chongtikeyong;

    /** 充提冻结 */
    @Excel(name = "充提冻结")
    private BigDecimal chongtidongjie;

    /** 合约可用 */
    @Excel(name = "合约可用")
    private BigDecimal heyuekeyong;

    /** 合约冻结 */
    @Excel(name = "合约冻结")
    private BigDecimal heyuedongjie;

    /** 法币可用 */
    @Excel(name = "法币可用")
    private BigDecimal fabikeyong;

    /** 法币冻结 */
    @Excel(name = "法币冻结")
    private BigDecimal fabidongjie;

    @Excel(name = "链上实际")
    private BigDecimal chainbalance;

    /** 法币冻结 */
    @Excel(name = "链上资产")
    private BigDecimal chainBalance;

    public void setId(Long id)
    {
        this.id = id;
    }

    public BigDecimal getChainBalance() {
        return chainBalance;
    }

    public void setChainBalance(BigDecimal chainBalance) {
        this.chainBalance = chainBalance;
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getBibikeyong() {
        return bibikeyong;
    }

    public void setBibikeyong(BigDecimal bibikeyong) {
        this.bibikeyong = bibikeyong;
    }

    public BigDecimal getBibidongjie() {
        return bibidongjie;
    }

    public void setBibidongjie(BigDecimal bibidongjie) {
        this.bibidongjie = bibidongjie;
    }

    public BigDecimal getChongtikeyong() {
        return chongtikeyong;
    }

    public void setChongtikeyong(BigDecimal chongtikeyong) {
        this.chongtikeyong = chongtikeyong;
    }

    public BigDecimal getChongtidongjie() {
        return chongtidongjie;
    }

    public void setChongtidongjie(BigDecimal chongtidongjie) {
        this.chongtidongjie = chongtidongjie;
    }

    public BigDecimal getHeyuekeyong() {
        return heyuekeyong;
    }

    public void setHeyuekeyong(BigDecimal heyuekeyong) {
        this.heyuekeyong = heyuekeyong;
    }

    public BigDecimal getHeyuedongjie() {
        return heyuedongjie;
    }

    public void setHeyuedongjie(BigDecimal heyuedongjie) {
        this.heyuedongjie = heyuedongjie;
    }

    public BigDecimal getFabikeyong() {
        return fabikeyong;
    }

    public void setFabikeyong(BigDecimal fabikeyong) {
        this.fabikeyong = fabikeyong;
    }

    public BigDecimal getFabidongjie() {
        return fabidongjie;
    }

    public void setFabidongjie(BigDecimal fabidongjie) {
        this.fabidongjie = fabidongjie;
    }

    public BigDecimal getChainbalance() {
        return chainbalance;
    }

    public void setChainbalance(BigDecimal chainbalance) {
        this.chainbalance = chainbalance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("currency", getCurrency())
                .append("sum", getSum())
                .append("bibikeyong", getBibikeyong())
                .append("bibidongjie", getBibidongjie())
                .append("chongtikeyong", getChongtikeyong())
                .append("chongtidongjie", getChongtidongjie())
                .append("heyuekeyong", getHeyuekeyong())
                .append("heyuedongjie", getHeyuedongjie())
                .append("fabikeyong", getFabikeyong())
                .append("fabidongjie", getFabidongjie())
                .append("createTime", getCreateTime())
                .toString();
    }
}
