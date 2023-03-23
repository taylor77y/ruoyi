package com.ruoyi.system.domain.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Krson
 * @date 2022/8/13 20:41
 */
public class CtDataVo {

    private String name;
    private BigDecimal amount;
    private Long count;
    private String path;
    private List<Map> items;

    public List<Map> getItems() {
        return items;
    }

    public void setItems(List<Map> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CtDataVo{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", count=" + count +
                ", path='" + path + '\'' +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
