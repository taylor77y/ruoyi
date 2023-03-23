package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充币地址对象 t_wallet_pool
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class TWalletPool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** ETH地址 */
    @Excel(name = "ETH地址")
    private String address;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 会员ID */
    @Excel(name = "会员ID")
    private String member;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String coin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long usdtBalance;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ethBalance;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setCoin(String coin) 
    {
        this.coin = coin;
    }

    public String getCoin() 
    {
        return coin;
    }
    public void setUsdtBalance(Long usdtBalance) 
    {
        this.usdtBalance = usdtBalance;
    }

    public Long getUsdtBalance() 
    {
        return usdtBalance;
    }
    public void setEthBalance(Long ethBalance) 
    {
        this.ethBalance = ethBalance;
    }

    public Long getEthBalance() 
    {
        return ethBalance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("address", getAddress())
            .append("password", getPassword())
            .append("member", getMember())
            .append("coin", getCoin())
            .append("usdtBalance", getUsdtBalance())
            .append("ethBalance", getEthBalance())
            .append("createTime", getCreateTime())
            .toString();
    }
}
