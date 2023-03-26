package com.ruoyi.system.service;

import com.ruoyi.system.domain.PerpetualContractOrder;
import com.ruoyi.system.domain.params.PerpetualContractOrderParam;

import java.util.List;

public interface PerpetualContractOrderService {
    List<PerpetualContractOrder> getList(PerpetualContractOrderParam param);

    int setControlAndWin(String id, Integer control, Integer win);
}
