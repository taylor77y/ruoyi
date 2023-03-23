package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收款账户对象 money_account
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class MoneyAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 收款账号(链接) */
    @Excel(name = "收款账号(链接)")
    private String account;

    /** 收款名称(链名) */
    @Excel(name = "收款名称(链名)")
    private String username;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrcode;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 账户状态 */
    @Excel(name = "账户状态")
    private Integer status;

    /** 银行卡名称 */
    @Excel(name = "银行卡名称")
    private String bankname;

    /** 账户类型 */
    @Excel(name = "账户类型")
    private Integer type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setBankname(String bankname) 
    {
        this.bankname = bankname;
    }

    public String getBankname() 
    {
        return bankname;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("account", getAccount())
            .append("username", getUsername())
            .append("qrcode", getQrcode())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("bankname", getBankname())
            .append("type", getType())
            .toString();
    }
}
