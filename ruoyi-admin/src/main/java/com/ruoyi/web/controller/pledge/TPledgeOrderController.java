package com.ruoyi.web.controller.pledge;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.TPledgeOrderDetail;
import com.ruoyi.system.service.ITPledgeOrderDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TPledgeOrder;
import com.ruoyi.system.service.ITPledgeOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 质押借币订单Controller
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@RestController
@RequestMapping("/system/pledge/order")
public class TPledgeOrderController extends BaseController
{
    @Autowired
    private ITPledgeOrderService tPledgeOrderService;
    @Autowired
    private ITPledgeOrderDetailService itPledgeOrderDetailService;

    /**
     * 查询质押借币订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPledgeOrder tPledgeOrder)
    {
        startPage();
        if(tPledgeOrder.getStatus()<0){
            tPledgeOrder.setStatus(null);
        }
        List<TPledgeOrder> list = tPledgeOrderService.selectTPledgeOrderList(tPledgeOrder);
        list.forEach(item->{
            List<TPledgeOrderDetail> details=itPledgeOrderDetailService.selectTPledgeOrderDetailList(new TPledgeOrderDetail(item.getId()));
            item.setDetails(details);
        });
        return getDataTable(list);
    }

    /**
     * 导出质押借币订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "质押借币订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPledgeOrder tPledgeOrder)
    {
        List<TPledgeOrder> list = tPledgeOrderService.selectTPledgeOrderList(tPledgeOrder);
        ExcelUtil<TPledgeOrder> util = new ExcelUtil<TPledgeOrder>(TPledgeOrder.class);
        util.exportExcel(response, list, "质押借币订单数据");
    }

    /**
     * 获取质押借币订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tPledgeOrderService.selectTPledgeOrderById(id));
    }

    /**
     * 新增质押借币订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "质押借币订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPledgeOrder tPledgeOrder)
    {
        return toAjax(tPledgeOrderService.insertTPledgeOrder(tPledgeOrder));
    }

    /**
     * 修改质押借币订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "质押借币订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPledgeOrder tPledgeOrder)
    {
        return toAjax(tPledgeOrderService.updateTPledgeOrder(tPledgeOrder));
    }

    /**
     * 删除质押借币订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "质押借币订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tPledgeOrderService.deleteTPledgeOrderByIds(ids));
    }
}
