package com.ruoyi.web.controller.contract;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.PerpetualContractOrder;
import com.ruoyi.system.domain.params.PerpetualContractOrderParam;
import com.ruoyi.system.service.PerpetualContractOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/perpetual/contract/control")
public class PerpetualContractOrderController extends BaseController {
    @Resource
    PerpetualContractOrderService perpetualContractOrderService;

    @GetMapping("/page")
    public TableDataInfo list(PerpetualContractOrderParam param) {
        startPage();
        List<PerpetualContractOrder> list = perpetualContractOrderService.getList(param);
        TableDataInfo dataTable = getDataTable(list);
        return dataTable;
    }

    @PutMapping("/setControlAndWin")
    public AjaxResult setControlAndWin(String id, Integer control, Integer win) {
        return AjaxResult.success(perpetualContractOrderService.setControlAndWin(id, control, win));
    }
}
