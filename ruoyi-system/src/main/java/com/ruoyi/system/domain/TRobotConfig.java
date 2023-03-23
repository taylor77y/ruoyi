package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机器人配置对象 t_robot_config
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class TRobotConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 交易对名称 */
    @Excel(name = "交易对名称")
    private String pairName;

    /** 是否开启k线 */
    @Excel(name = "是否开启k线")
    private String openKine;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private String isOpen;

    /** 是否开启盘口 */
    @Excel(name = "是否开启盘口")
    private String openTape;

    /** 目标价格 */
    @Excel(name = "目标价格")
    private BigDecimal willPrice;

    /** 目标时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "目标时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date willTime;

    /** 绑定用户 */
    @Excel(name = "绑定用户")
    private String bindUser;

    /** 下单数量上限 */
    @Excel(name = "下单数量上限")
    private BigDecimal startNum;

    /** 下单数量波动下限 */
    @Excel(name = "下单数量波动下限")
    private BigDecimal endNum;

    /** 下单价格波动上限 */
    @Excel(name = "下单价格波动上限")
    private BigDecimal startPrice;

    /** 下单价格波动上限 */
    @Excel(name = "下单价格波动上限")
    private BigDecimal endPrice;

    /** 撮合数量波动上限 */
    @Excel(name = "撮合数量波动上限")
    private BigDecimal mendNum;

    /** 撮合数量波动下限 */
    @Excel(name = "撮合数量波动下限")
    private BigDecimal mstartNum;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPairName(String pairName) 
    {
        this.pairName = pairName;
    }

    public String getPairName() 
    {
        return pairName;
    }
    public void setOpenKine(String openKine) 
    {
        this.openKine = openKine;
    }

    public String getOpenKine() 
    {
        return openKine;
    }
    public void setIsOpen(String isOpen) 
    {
        this.isOpen = isOpen;
    }

    public String getIsOpen() 
    {
        return isOpen;
    }
    public void setOpenTape(String openTape) 
    {
        this.openTape = openTape;
    }

    public String getOpenTape() 
    {
        return openTape;
    }
    public void setWillPrice(BigDecimal willPrice) 
    {
        this.willPrice = willPrice;
    }

    public BigDecimal getWillPrice() 
    {
        return willPrice;
    }
    public void setWillTime(Date willTime) 
    {
        this.willTime = willTime;
    }

    public Date getWillTime() 
    {
        return willTime;
    }
    public void setBindUser(String bindUser) 
    {
        this.bindUser = bindUser;
    }

    public String getBindUser() 
    {
        return bindUser;
    }
    public void setStartNum(BigDecimal startNum) 
    {
        this.startNum = startNum;
    }

    public BigDecimal getStartNum() 
    {
        return startNum;
    }
    public void setEndNum(BigDecimal endNum) 
    {
        this.endNum = endNum;
    }

    public BigDecimal getEndNum() 
    {
        return endNum;
    }
    public void setStartPrice(BigDecimal startPrice) 
    {
        this.startPrice = startPrice;
    }

    public BigDecimal getStartPrice() 
    {
        return startPrice;
    }
    public void setEndPrice(BigDecimal endPrice) 
    {
        this.endPrice = endPrice;
    }

    public BigDecimal getEndPrice() 
    {
        return endPrice;
    }
    public void setMendNum(BigDecimal mendNum) 
    {
        this.mendNum = mendNum;
    }

    public BigDecimal getMendNum() 
    {
        return mendNum;
    }
    public void setMstartNum(BigDecimal mstartNum) 
    {
        this.mstartNum = mstartNum;
    }

    public BigDecimal getMstartNum() 
    {
        return mstartNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pairName", getPairName())
            .append("openKine", getOpenKine())
            .append("isOpen", getIsOpen())
            .append("openTape", getOpenTape())
            .append("willPrice", getWillPrice())
            .append("willTime", getWillTime())
            .append("bindUser", getBindUser())
            .append("startNum", getStartNum())
            .append("endNum", getEndNum())
            .append("startPrice", getStartPrice())
            .append("endPrice", getEndPrice())
            .append("mendNum", getMendNum())
            .append("mstartNum", getMstartNum())
            .append("createTime", getCreateTime())
            .toString();
    }
}
