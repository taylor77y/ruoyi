package com.ruoyi.system.domain.kline;

import java.util.Arrays;
import java.util.List;

/**
 * @author Krson
 * @date 2023/1/11 11:21
 */
public class BatchData {

    private Object name;
    private Object type;
    private Object val;
    private Object time;
    private Integer mode;

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    private List<Long> list;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BatchData{" +
                "name=" + name +
                ", type=" + type +
                ", val=" + val +
                ", time=" + time +
                ", list=" + list +
                '}';
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
