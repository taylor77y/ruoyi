package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 会员对象 t_member
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public class Store extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** UUID */
    @Excel(name = "UUID")
    private String uuid;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String password;

    /** 邀请人id */
    @Excel(name = "邀请人id")
    private String welMember;

    /** 佣金 */
    @Excel(name = "佣金")
    private BigDecimal brokerage;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String welCode;

    /** 支付密码 */
    @Excel(name = "支付密码")
    private String payPassword;

    /** 账号类型:INTERNAL内部的,EXTERNAL外部的 */
    @Excel(name = "账号类型:INTERNAL内部的,EXTERNAL外部的")
    private String type;

    /** 姓名 */
    @Excel(name = "姓名")
    private String uname;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birth;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String cardNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String address;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String quickMark;

    /** 是(1)否(0) */
    @Excel(name = "是(1)否(0)")
    private Integer broker;

    /** 经纪人等级一 */
    @Excel(name = "经纪人等级一")
    private String brokerGradeOne;

    /** 经纪人等级二 */
    @Excel(name = "经纪人等级二")
    private String brokerGradeTwo;

    /** 经纪人等级三 */
    @Excel(name = "经纪人等级三")
    private String brokerGradeThree;

    /** 邀请节点路径 */
    @Excel(name = "邀请节点路径")
    private String nodePath;

    /** 银行卡所属行 */
    @Excel(name = "银行卡所属行")
    private String nickName;

    /** 微信图片 */
    @Excel(name = "微信图片")
    private String payWechat;

    /** 支付宝图片 */
    @Excel(name = "支付宝图片")
    private String payAliay;

    /** 微信姓名 */
    @Excel(name = "微信姓名")
    private String wechatName;

    /** 支付宝姓名 */
    @Excel(name = "支付宝姓名")
    private String aliayName;

    /** 身份证反面 */
    @Excel(name = "身份证反面")
    private String sideLink;

    /** 身份证正面 */
    @Excel(name = "身份证正面")
    private String positiveLink;

    /** 高级认证状态 */
    @Excel(name = "高级认证状态")
    private String cardState;

    /** 商家昵称 */
    @Excel(name = "商家昵称")
    private String storeName;

    /** 银行卡姓名 */
    @Excel(name = "银行卡姓名")
    private String bankUserName;

    /** 银行卡所属行 */
    @Excel(name = "银行卡所属行")
    private String bankName;

    /** 银行卡支行 */
    @Excel(name = "银行卡支行")
    private String bankAddress;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String bankCard;

    /** 法币是否可用'NORMAL'可用，UNNORMAL 不可用 */
    @Excel(name = "法币是否可用'NORMAL'可用，UNNORMAL 不可用")
    private String fbStatus;

    /** 是否是商家 */
    @Excel(name = "是否是商家")
    private String storeState;

    /** 密码盐 */
    @Excel(name = "密码盐")
    private String salt;

    /** 区号 */
    @Excel(name = "区号")
    private String areaCode;

    /** 手持身份证照片 */
    @Excel(name = "手持身份证照片")
    private String handLink;

    /** 封号状态 */
    @Excel(name = "封号状态")
    private String userStatus;

    /** 法币配置ID */
    @Excel(name = "法币配置ID")
    private Long oucId;

    /** 是否控盘 */
    @Excel(name = "是否控盘")
    private Integer isControl;

    /** xxx */
    @Excel(name = "xxx")
    private Integer isBok;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getMail() 
    {
        return mail;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setWelMember(String welMember) 
    {
        this.welMember = welMember;
    }

    public String getWelMember() 
    {
        return welMember;
    }
    public void setBrokerage(BigDecimal brokerage) 
    {
        this.brokerage = brokerage;
    }

    public BigDecimal getBrokerage() 
    {
        return brokerage;
    }
    public void setWelCode(String welCode) 
    {
        this.welCode = welCode;
    }

    public String getWelCode() 
    {
        return welCode;
    }
    public void setPayPassword(String payPassword) 
    {
        this.payPassword = payPassword;
    }

    public String getPayPassword() 
    {
        return payPassword;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setUname(String uname) 
    {
        this.uname = uname;
    }

    public String getUname() 
    {
        return uname;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirth(String birth) 
    {
        this.birth = birth;
    }

    public String getBirth() 
    {
        return birth;
    }
    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }

    public String getCardNo() 
    {
        return cardNo;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setQuickMark(String quickMark) 
    {
        this.quickMark = quickMark;
    }

    public String getQuickMark() 
    {
        return quickMark;
    }
    public void setBroker(Integer broker) 
    {
        this.broker = broker;
    }

    public Integer getBroker() 
    {
        return broker;
    }
    public void setBrokerGradeOne(String brokerGradeOne) 
    {
        this.brokerGradeOne = brokerGradeOne;
    }

    public String getBrokerGradeOne() 
    {
        return brokerGradeOne;
    }
    public void setBrokerGradeTwo(String brokerGradeTwo) 
    {
        this.brokerGradeTwo = brokerGradeTwo;
    }

    public String getBrokerGradeTwo() 
    {
        return brokerGradeTwo;
    }
    public void setBrokerGradeThree(String brokerGradeThree) 
    {
        this.brokerGradeThree = brokerGradeThree;
    }

    public String getBrokerGradeThree() 
    {
        return brokerGradeThree;
    }
    public void setNodePath(String nodePath) 
    {
        this.nodePath = nodePath;
    }

    public String getNodePath() 
    {
        return nodePath;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setPayWechat(String payWechat) 
    {
        this.payWechat = payWechat;
    }

    public String getPayWechat() 
    {
        return payWechat;
    }
    public void setPayAliay(String payAliay) 
    {
        this.payAliay = payAliay;
    }

    public String getPayAliay() 
    {
        return payAliay;
    }
    public void setWechatName(String wechatName) 
    {
        this.wechatName = wechatName;
    }

    public String getWechatName() 
    {
        return wechatName;
    }
    public void setAliayName(String aliayName) 
    {
        this.aliayName = aliayName;
    }

    public String getAliayName() 
    {
        return aliayName;
    }
    public void setSideLink(String sideLink) 
    {
        this.sideLink = sideLink;
    }

    public String getSideLink() 
    {
        return sideLink;
    }
    public void setPositiveLink(String positiveLink) 
    {
        this.positiveLink = positiveLink;
    }

    public String getPositiveLink() 
    {
        return positiveLink;
    }
    public void setCardState(String cardState) 
    {
        this.cardState = cardState;
    }

    public String getCardState() 
    {
        return cardState;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setBankUserName(String bankUserName) 
    {
        this.bankUserName = bankUserName;
    }

    public String getBankUserName() 
    {
        return bankUserName;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankAddress(String bankAddress) 
    {
        this.bankAddress = bankAddress;
    }

    public String getBankAddress() 
    {
        return bankAddress;
    }
    public void setBankCard(String bankCard) 
    {
        this.bankCard = bankCard;
    }

    public String getBankCard() 
    {
        return bankCard;
    }
    public void setFbStatus(String fbStatus) 
    {
        this.fbStatus = fbStatus;
    }

    public String getFbStatus() 
    {
        return fbStatus;
    }
    public void setStoreState(String storeState) 
    {
        this.storeState = storeState;
    }

    public String getStoreState() 
    {
        return storeState;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setHandLink(String handLink) 
    {
        this.handLink = handLink;
    }

    public String getHandLink() 
    {
        return handLink;
    }
    public void setUserStatus(String userStatus) 
    {
        this.userStatus = userStatus;
    }

    public String getUserStatus() 
    {
        return userStatus;
    }
    public void setOucId(Long oucId) 
    {
        this.oucId = oucId;
    }

    public Long getOucId() 
    {
        return oucId;
    }
    public void setIsControl(Integer isControl) 
    {
        this.isControl = isControl;
    }

    public Integer getIsControl() 
    {
        return isControl;
    }
    public void setIsBok(Integer isBok) 
    {
        this.isBok = isBok;
    }

    public Integer getIsBok() 
    {
        return isBok;
    }

    /**
     * 法币名称
     */
    private String oucName;

    public String getOucName() {
        return oucName;
    }

    public void setOucName(String oucName) {
        this.oucName = oucName;
    }

    /**
     * 商户客服链接
     */
    private String connectLink;

    public String getConnectLink() {
        return connectLink;
    }

    public void setConnectLink(String connectLink) {
        this.connectLink = connectLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("uuid", getUuid())
            .append("mail", getMail())
            .append("password", getPassword())
            .append("welMember", getWelMember())
            .append("brokerage", getBrokerage())
            .append("welCode", getWelCode())
            .append("payPassword", getPayPassword())
            .append("type", getType())
            .append("uname", getUname())
            .append("sex", getSex())
            .append("birth", getBirth())
            .append("cardNo", getCardNo())
            .append("address", getAddress())
            .append("quickMark", getQuickMark())
            .append("broker", getBroker())
            .append("brokerGradeOne", getBrokerGradeOne())
            .append("brokerGradeTwo", getBrokerGradeTwo())
            .append("brokerGradeThree", getBrokerGradeThree())
            .append("nodePath", getNodePath())
            .append("nickName", getNickName())
            .append("payWechat", getPayWechat())
            .append("payAliay", getPayAliay())
            .append("wechatName", getWechatName())
            .append("aliayName", getAliayName())
            .append("sideLink", getSideLink())
            .append("positiveLink", getPositiveLink())
            .append("cardState", getCardState())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("storeName", getStoreName())
            .append("bankUserName", getBankUserName())
            .append("bankName", getBankName())
            .append("bankAddress", getBankAddress())
            .append("bankCard", getBankCard())
            .append("fbStatus", getFbStatus())
            .append("storeState", getStoreState())
            .append("salt", getSalt())
            .append("areaCode", getAreaCode())
            .append("handLink", getHandLink())
            .append("userStatus", getUserStatus())
            .append("oucId", getOucId())
            .append("isControl", getIsControl())
            .append("isBok", getIsBok())
            .append("remark", getRemark())
            .toString();
    }
}
