package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 *  充提配置对象 sys_dictionaries
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class SysDictionaries extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列号 */
    private Long id;

    /** 键 */
    @Excel(name = "键")
    private String ukey;

    /** 值 */
    @Excel(name = "值")
    private String uvalue;

    /** 描述信息 */
    @Excel(name = "描述信息")
    private String info;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUkey(String ukey) 
    {
        this.ukey = ukey;
    }

    public String getUkey() 
    {
        return ukey;
    }
    public void setUvalue(String uvalue) 
    {
        this.uvalue = uvalue;
    }

    public String getUvalue() 
    {
        return uvalue;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ukey", getUkey())
            .append("uvalue", getUvalue())
            .append("info", getInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
