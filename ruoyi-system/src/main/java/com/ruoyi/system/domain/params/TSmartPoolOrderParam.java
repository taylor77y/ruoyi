package com.ruoyi.system.domain.params;

import lombok.Data;

@Data
public class TSmartPoolOrderParam {
    private String orderNo;
    private Long productId;
    private String user;
    private String status;
}
