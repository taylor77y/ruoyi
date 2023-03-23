package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TWareHouse;
import com.ruoyi.system.domain.params.TWareHouseParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TWareHouseMapper {
    List<TWareHouse> selectPage(TWareHouseParam param);

    int setWin(@Param("id") String id,@Param("win") String win);
}
