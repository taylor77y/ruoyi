package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.TWareHouse;
import com.ruoyi.system.domain.params.TWareHouseParam;
import com.ruoyi.system.mapper.TWareHouseMapper;
import com.ruoyi.system.service.TWareHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TWareHouseServiceImpl implements TWareHouseService {

    @Resource
    TWareHouseMapper tWareHouseMapper;

    @Override
    public List<TWareHouse> selectPage(TWareHouseParam param) {
        return tWareHouseMapper.selectPage(param);
    }

    @Override
    public int setWin(String id, String win) {
        return tWareHouseMapper.setWin(id,win);
    }
}
