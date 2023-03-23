package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 秒合约记录对象 t_seconds_bet_log
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class TSecondsBetLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 会员ID */
    @Excel(name = "会员ID")
    private String memberId;

    /** 秒配置ID */
    @Excel(name = "秒配置ID")
    private Long sid;

    /** 虚拟币ID */
    @Excel(name = "虚拟币ID")
    private Long ckid;

    /** 虚拟币币种s */
    @Excel(name = "虚拟币币种s")
    private String ckType;

    /** 虚拟币名称 */
    @Excel(name = "虚拟币名称")
    private String ckName;

    /** 开始价格 */
    @Excel(name = "开始价格")
    private BigDecimal startAmount;

    /** 结束价格 */
    @Excel(name = "结束价格")
    private BigDecimal finishsAmount;

    /** 下注金额 */
    @Excel(name = "下注金额")
    private BigDecimal amount;

    /** 利润 */
    @Excel(name = "利润")
    private BigDecimal profit;

    /** 买入状态 1涨2跌 */
    @Excel(name = "买入状态 1涨2跌")
    private Integer buyStatus;

    /** 结算状态 */
    @Excel(name = "结算状态")
    private Integer settleStatus;

    /** 是否输赢 */
    @Excel(name = "是否输赢")
    private Integer isWin;

    /** 是否控盘 */
    @Excel(name = "是否控盘")
    private Integer isControl;

    /** 控盘配置 */
    @Excel(name = "控盘配置")
    private BigDecimal controlPecent;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMemberId(String memberId) 
    {
        this.memberId = memberId;
    }

    public String getMemberId() 
    {
        return memberId;
    }
    public void setSid(Long sid) 
    {
        this.sid = sid;
    }

    public Long getSid() 
    {
        return sid;
    }
    public void setCkid(Long ckid) 
    {
        this.ckid = ckid;
    }

    public Long getCkid() 
    {
        return ckid;
    }
    public void setCkType(String ckType) 
    {
        this.ckType = ckType;
    }

    public String getCkType() 
    {
        return ckType;
    }
    public void setCkName(String ckName) 
    {
        this.ckName = ckName;
    }

    public String getCkName() 
    {
        return ckName;
    }
    public void setStartAmount(BigDecimal startAmount) 
    {
        this.startAmount = startAmount;
    }

    public BigDecimal getStartAmount() 
    {
        return startAmount;
    }
    public void setFinishsAmount(BigDecimal finishsAmount) 
    {
        this.finishsAmount = finishsAmount;
    }

    public BigDecimal getFinishsAmount() 
    {
        return finishsAmount;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setProfit(BigDecimal profit) 
    {
        this.profit = profit;
    }

    public BigDecimal getProfit() 
    {
        return profit;
    }
    public void setBuyStatus(Integer buyStatus) 
    {
        this.buyStatus = buyStatus;
    }

    public Integer getBuyStatus() 
    {
        return buyStatus;
    }
    public void setSettleStatus(Integer settleStatus) 
    {
        this.settleStatus = settleStatus;
    }

    public Integer getSettleStatus() 
    {
        return settleStatus;
    }
    public void setIsWin(Integer isWin) 
    {
        this.isWin = isWin;
    }

    public Integer getIsWin() 
    {
        return isWin;
    }
    public void setIsControl(Integer isControl) 
    {
        this.isControl = isControl;
    }

    public Integer getIsControl() 
    {
        return isControl;
    }
    public void setControlPecent(BigDecimal controlPecent) 
    {
        this.controlPecent = controlPecent;
    }

    public BigDecimal getControlPecent() 
    {
        return controlPecent;
    }
    public void setSettleTime(Date settleTime) 
    {
        this.settleTime = settleTime;
    }

    public Date getSettleTime() 
    {
        return settleTime;
    }

    private String phone;
    private String mail;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberId", getMemberId())
            .append("sid", getSid())
            .append("ckid", getCkid())
            .append("ckType", getCkType())
            .append("ckName", getCkName())
            .append("startAmount", getStartAmount())
            .append("finishsAmount", getFinishsAmount())
            .append("amount", getAmount())
            .append("profit", getProfit())
            .append("buyStatus", getBuyStatus())
            .append("settleStatus", getSettleStatus())
            .append("isWin", getIsWin())
            .append("isControl", getIsControl())
            .append("controlPecent", getControlPecent())
            .append("createTime", getCreateTime())
            .append("settleTime", getSettleTime())
            .toString();
    }
}
