package com.ruoyi.system.domain.vo;

/**
 * @author Krson
 * @date 2022/8/22 18:25
 */
public class TkDto {

    private boolean isOpen;
    private Long count;
    private String path;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
