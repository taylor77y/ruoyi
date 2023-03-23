package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提币记录对象 t_withdraw_history
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public class TWithdrawHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 提币用户ID */
    @Excel(name = "提币用户ID")
    private String member;

    /** 交易区块高度 */
    @Excel(name = "交易区块高度")
    private String blockNumber;

    /** 交易hash */
    @Excel(name = "交易hash")
    private String txHash;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String contract;

    /** 转出地址 */
    @Excel(name = "转出地址")
    private String fromAddress;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 收币地址 */
    @Excel(name = "收币地址")
    private String toAddress;

    /** 币名 */
    @Excel(name = "币名")
    private String coin;

    /** 数量 */
    @Excel(name = "数量")
    private String amount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setBlockNumber(String blockNumber) 
    {
        this.blockNumber = blockNumber;
    }

    public String getBlockNumber() 
    {
        return blockNumber;
    }
    public void setTxHash(String txHash) 
    {
        this.txHash = txHash;
    }

    public String getTxHash() 
    {
        return txHash;
    }
    public void setContract(String contract) 
    {
        this.contract = contract;
    }

    public String getContract() 
    {
        return contract;
    }
    public void setFromAddress(String fromAddress) 
    {
        this.fromAddress = fromAddress;
    }

    public String getFromAddress() 
    {
        return fromAddress;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setToAddress(String toAddress) 
    {
        this.toAddress = toAddress;
    }

    public String getToAddress() 
    {
        return toAddress;
    }
    public void setCoin(String coin) 
    {
        this.coin = coin;
    }

    public String getCoin() 
    {
        return coin;
    }
    public void setAmount(String amount) 
    {
        this.amount = amount;
    }

    public String getAmount() 
    {
        return amount;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("member", getMember())
            .append("blockNumber", getBlockNumber())
            .append("txHash", getTxHash())
            .append("contract", getContract())
            .append("fromAddress", getFromAddress())
            .append("status", getStatus())
            .append("toAddress", getToAddress())
            .append("coin", getCoin())
            .append("amount", getAmount())
            .append("createTime", getCreateTime())
            .toString();
    }
}
