package com.ruoyi.system.domain.dto;

import java.math.BigDecimal;

/**
 * @author Krson
 * @date 2022/8/10 11:18
 */
public class MemberDto {

    private String id;
    private BigDecimal amount;
    private String password;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", password='" + password + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
