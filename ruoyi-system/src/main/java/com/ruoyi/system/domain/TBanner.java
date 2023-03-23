package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币币-banner图对象 t_banner
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** banner图 */
    @Excel(name = "banner图")
    private String bannerUrl;

    /** 跳转URL */
    @Excel(name = "跳转URL")
    private String linkUrl;

    /** 状态 */
    @Excel(name = "状态")
    private String bannerType;

    /** 国际化 */
    @Excel(name = "国际化")
    private String global;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updateUser;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setBannerUrl(String bannerUrl) 
    {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() 
    {
        return bannerUrl;
    }
    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
    }
    public void setBannerType(String bannerType) 
    {
        this.bannerType = bannerType;
    }

    public String getBannerType() 
    {
        return bannerType;
    }
    public void setGlobal(String global) 
    {
        this.global = global;
    }

    public String getGlobal() 
    {
        return global;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bannerUrl", getBannerUrl())
            .append("linkUrl", getLinkUrl())
            .append("bannerType", getBannerType())
            .append("global", getGlobal())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
