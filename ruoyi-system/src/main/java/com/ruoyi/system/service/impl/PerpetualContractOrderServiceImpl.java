package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.PerpetualContractOrder;
import com.ruoyi.system.domain.params.PerpetualContractOrderParam;
import com.ruoyi.system.mapper.PerpetualContractOrderMapper;
import com.ruoyi.system.service.PerpetualContractOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PerpetualContractOrderServiceImpl implements PerpetualContractOrderService {
    @Resource
    PerpetualContractOrderMapper perpetualContractOrderMapper;

    @Override
    public List<PerpetualContractOrder> getList(PerpetualContractOrderParam param) {
        return perpetualContractOrderMapper.getList(param);
    }

    @Override
    public int setControlAndWin(String id, Integer control, Integer win) {
        return perpetualContractOrderMapper.setControlAndWin(id, control, win);
    }
}
