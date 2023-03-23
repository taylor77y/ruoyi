package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Otc申诉对象 t_otc_order_appeal
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TOtcOrderAppeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 会员ID */
    @Excel(name = "会员ID")
    private String memberId;

    /** 下单ID */
    @Excel(name = "下单ID")
    private String priceOrderId;

    /** 信息 */
    @Excel(name = "信息")
    private String msg;

    /** 图片 */
    @Excel(name = "图片")
    private String pic;

    /** 图片1 */
    @Excel(name = "图片1")
    private String pic1;

    /** 申诉状态 */
    @Excel(name = "申诉状态")
    private String status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setPriceOrderId(String priceOrderId) 
    {
        this.priceOrderId = priceOrderId;
    }

    public String getPriceOrderId() 
    {
        return priceOrderId;
    }
    public void setMsg(String msg) 
    {
        this.msg = msg;
    }

    public String getMsg() 
    {
        return msg;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setPic1(String pic1) 
    {
        this.pic1 = pic1;
    }

    public String getPic1() 
    {
        return pic1;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    private String phone;
    private String mail;

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
            .append("priceOrderId", getPriceOrderId())
            .append("msg", getMsg())
            .append("pic", getPic())
            .append("pic1", getPic1())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
