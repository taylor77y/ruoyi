package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * @author Krson
 * @date 2022/10/20 17:49
 */
public class MinDto extends BaseEntity {

    private List<String> info;

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }
}
