package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客服链接配置对象 t_customer_service
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class TCustomerService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 客服链接 */
    @Excel(name = "客服链接")
    private String contactLink;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContactLink(String contactLink) 
    {
        this.contactLink = contactLink;
    }

    public String getContactLink() 
    {
        return contactLink;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contactLink", getContactLink())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("type", getType())
            .toString();
    }
}
