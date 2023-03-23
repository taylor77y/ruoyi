package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 私募项目对象 t_pe_project
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TPeProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long orderIndex;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目地址 */
    @Excel(name = "项目地址")
    private String projectUrl;

    /** 大图 */
    @Excel(name = "大图")
    private String projectImg;

    /** 私募开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "私募开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 私募结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "私募结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 已经募数量 */
    @Excel(name = "已经募数量")
    private BigDecimal nowNum;

    /** 私募数 */
    @Excel(name = "私募数")
    private BigDecimal sumNum;

    /** 最小数量 */
    @Excel(name = "最小数量")
    private BigDecimal minNum;

    /** 最大数量 */
    @Excel(name = "最大数量")
    private BigDecimal maxNum;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal coinPice;

    /** 币种名称 */
    @Excel(name = "币种名称")
    private String coinName;

    /** 私募状态 WAIT排队，ING正在进行，PASS结束 */
    @Excel(name = "私募状态 WAIT排队，ING正在进行，PASS结束")
    private String status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOrderIndex(Long orderIndex) 
    {
        this.orderIndex = orderIndex;
    }

    public Long getOrderIndex() 
    {
        return orderIndex;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectUrl(String projectUrl) 
    {
        this.projectUrl = projectUrl;
    }

    public String getProjectUrl() 
    {
        return projectUrl;
    }
    public void setProjectImg(String projectImg) 
    {
        this.projectImg = projectImg;
    }

    public String getProjectImg() 
    {
        return projectImg;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setNowNum(BigDecimal nowNum) 
    {
        this.nowNum = nowNum;
    }

    public BigDecimal getNowNum() 
    {
        return nowNum;
    }
    public void setSumNum(BigDecimal sumNum) 
    {
        this.sumNum = sumNum;
    }

    public BigDecimal getSumNum() 
    {
        return sumNum;
    }
    public void setMinNum(BigDecimal minNum) 
    {
        this.minNum = minNum;
    }

    public BigDecimal getMinNum() 
    {
        return minNum;
    }
    public void setMaxNum(BigDecimal maxNum) 
    {
        this.maxNum = maxNum;
    }

    public BigDecimal getMaxNum() 
    {
        return maxNum;
    }
    public void setCoinPice(BigDecimal coinPice) 
    {
        this.coinPice = coinPice;
    }

    public BigDecimal getCoinPice() 
    {
        return coinPice;
    }
    public void setCoinName(String coinName) 
    {
        this.coinName = coinName;
    }

    public String getCoinName() 
    {
        return coinName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderIndex", getOrderIndex())
            .append("projectName", getProjectName())
            .append("projectUrl", getProjectUrl())
            .append("projectImg", getProjectImg())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("nowNum", getNowNum())
            .append("sumNum", getSumNum())
            .append("minNum", getMinNum())
            .append("maxNum", getMaxNum())
            .append("coinPice", getCoinPice())
            .append("coinName", getCoinName())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
