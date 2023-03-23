package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 谷歌密钥对象 t_google_code
 * 
 * @author ruoyi
 * @date 2022-09-08
 */
public class TGoogleCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 密钥 */
    @Excel(name = "密钥")
    private String sercet;

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
    public void setSercet(String sercet) 
    {
        this.sercet = sercet;
    }

    public String getSercet() 
    {
        return sercet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("account", getAccount())
            .append("sercet", getSercet())
            .append("createTime", getCreateTime())
            .toString();
    }
}
