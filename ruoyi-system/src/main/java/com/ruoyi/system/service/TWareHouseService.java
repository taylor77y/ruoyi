package com.ruoyi.system.service;

import com.ruoyi.system.domain.TWareHouse;
import com.ruoyi.system.domain.params.TWareHouseParam;

import java.util.List;

public interface TWareHouseService {
    List<TWareHouse> selectPage(TWareHouseParam param);
    int setWin(String id,Integer win);
}
