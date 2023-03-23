package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 三方接口对象 t_sys_config
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TSysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 参数名 */
    @Excel(name = "参数名")
    private String paramName;

    /** 键 */
    @Excel(name = "键")
    private String paramKey;

    /** 值 */
    @Excel(name = "值")
    private String paramValue;

    /** 备注 */
    @Excel(name = "备注")
    private String commit;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setParamName(String paramName) 
    {
        this.paramName = paramName;
    }

    public String getParamName() 
    {
        return paramName;
    }
    public void setParamKey(String paramKey) 
    {
        this.paramKey = paramKey;
    }

    public String getParamKey() 
    {
        return paramKey;
    }
    public void setParamValue(String paramValue) 
    {
        this.paramValue = paramValue;
    }

    public String getParamValue() 
    {
        return paramValue;
    }
    public void setCommit(String commit) 
    {
        this.commit = commit;
    }

    public String getCommit() 
    {
        return commit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("paramName", getParamName())
            .append("paramKey", getParamKey())
            .append("paramValue", getParamValue())
            .append("commit", getCommit())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
