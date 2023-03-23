package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币币-公告对象 t_notice
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 公告图 */
    @Excel(name = "公告图")
    private String imgUrl;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String linkUrl;

    /** 公告类型 */
    @Excel(name = "公告类型")
    private String noticeType;

    /** 收藏状态 */
    @Excel(name = "收藏状态")
    private String isFavorite;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long readCount;

    /** 语言种类 */
    @Excel(name = "语言种类")
    private String global;

    /** 备用文本 */
    @Excel(name = "备用文本")
    private String bakText;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
    }
    public void setNoticeType(String noticeType) 
    {
        this.noticeType = noticeType;
    }

    public String getNoticeType() 
    {
        return noticeType;
    }
    public void setIsFavorite(String isFavorite) 
    {
        this.isFavorite = isFavorite;
    }

    public String getIsFavorite() 
    {
        return isFavorite;
    }
    public void setReadCount(Long readCount) 
    {
        this.readCount = readCount;
    }

    public Long getReadCount() 
    {
        return readCount;
    }
    public void setGlobal(String global) 
    {
        this.global = global;
    }

    public String getGlobal() 
    {
        return global;
    }
    public void setBakText(String bakText) 
    {
        this.bakText = bakText;
    }

    public String getBakText() 
    {
        return bakText;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("imgUrl", getImgUrl())
            .append("linkUrl", getLinkUrl())
            .append("noticeType", getNoticeType())
            .append("isFavorite", getIsFavorite())
            .append("readCount", getReadCount())
            .append("global", getGlobal())
            .append("bakText", getBakText())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
