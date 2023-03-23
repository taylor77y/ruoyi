package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合约杠杆对象 t_lever
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TLever extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 倍数 */
    @Excel(name = "倍数")
    private Integer lever;

    /** 倍数描述 */
    @Excel(name = "倍数描述")
    private String leverDesc;

    /** 交易对 */
    @Excel(name = "交易对")
    private String pairsName;

    /** 手 */
    @Excel(name = "手")
    private Integer handsMax;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLever(Integer lever) 
    {
        this.lever = lever;
    }

    public Integer getLever() 
    {
        return lever;
    }
    public void setLeverDesc(String leverDesc) 
    {
        this.leverDesc = leverDesc;
    }

    public String getLeverDesc() 
    {
        return leverDesc;
    }
    public void setPairsName(String pairsName) 
    {
        this.pairsName = pairsName;
    }

    public String getPairsName() 
    {
        return pairsName;
    }
    public void setHandsMax(Integer handsMax) 
    {
        this.handsMax = handsMax;
    }

    public Integer getHandsMax() 
    {
        return handsMax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lever", getLever())
            .append("leverDesc", getLeverDesc())
            .append("pairsName", getPairsName())
            .append("handsMax", getHandsMax())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
