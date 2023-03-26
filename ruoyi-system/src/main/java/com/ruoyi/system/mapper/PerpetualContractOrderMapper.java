package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.PerpetualContractOrder;
import com.ruoyi.system.domain.params.PerpetualContractOrderParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PerpetualContractOrderMapper {
    List<PerpetualContractOrder> getList(PerpetualContractOrderParam param);

    int setControlAndWin(@Param("id") String id,@Param("control") Integer control, @Param("win") Integer win);
}
