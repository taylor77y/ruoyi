package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币种信息对象 t_coin_token
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public class TCoinToken extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 币名 */
    @Excel(name = "币名")
    private String coin;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String token;

    /** 小数位 */
    @Excel(name = "小数位")
    private Long point;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCoin(String coin) 
    {
        this.coin = coin;
    }

    public String getCoin() 
    {
        return coin;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coin", getCoin())
            .append("token", getToken())
            .append("point", getPoint())
            .toString();
    }
}
