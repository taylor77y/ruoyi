package com.ruoyi.web.controller.contract;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.TContractOrder;
import com.ruoyi.system.domain.TWareHouse;
import com.ruoyi.system.domain.params.TWareHouseParam;
import com.ruoyi.system.service.TWareHouseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/contractControl")
public class TContractControlController extends BaseController {

    @Resource
    TWareHouseService tWareHouseService;

//    @PreAuthorize("@ss.hasPermi('system:contractOrder:list')")
    @GetMapping("/page")
    public TableDataInfo list(TWareHouseParam param)
    {
        startPage();
        List<TWareHouse> list = tWareHouseService.selectPage(param);
        TableDataInfo dataTable = getDataTable(list);
        return dataTable;
    }

    @PutMapping("/setWin")
    public AjaxResult setWin(String id,Integer win)
    {
        return AjaxResult.success(tWareHouseService.setWin(id,win));
    }
}
