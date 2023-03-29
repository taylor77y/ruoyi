package com.ruoyi.web.controller.pledge;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TPledgeOrderDetail;
import com.ruoyi.system.service.ITPledgeOrderDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 质押借币订单详情Controller
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@RestController
@RequestMapping("/system/pledge/detail")
public class TPledgeOrderDetailController extends BaseController
{
    @Autowired
    private ITPledgeOrderDetailService tPledgeOrderDetailService;

    /**
     * 查询质押借币订单详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPledgeOrderDetail tPledgeOrderDetail)
    {
        startPage();
        List<TPledgeOrderDetail> list = tPledgeOrderDetailService.selectTPledgeOrderDetailList(tPledgeOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出质押借币订单详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "质押借币订单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPledgeOrderDetail tPledgeOrderDetail)
    {
        List<TPledgeOrderDetail> list = tPledgeOrderDetailService.selectTPledgeOrderDetailList(tPledgeOrderDetail);
        ExcelUtil<TPledgeOrderDetail> util = new ExcelUtil<TPledgeOrderDetail>(TPledgeOrderDetail.class);
        util.exportExcel(response, list, "质押借币订单详情数据");
    }

    /**
     * 获取质押借币订单详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tPledgeOrderDetailService.selectTPledgeOrderDetailById(id));
    }

    /**
     * 新增质押借币订单详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "质押借币订单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPledgeOrderDetail tPledgeOrderDetail)
    {
        return toAjax(tPledgeOrderDetailService.insertTPledgeOrderDetail(tPledgeOrderDetail));
    }

    /**
     * 修改质押借币订单详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "质押借币订单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPledgeOrderDetail tPledgeOrderDetail)
    {
        return toAjax(tPledgeOrderDetailService.updateTPledgeOrderDetail(tPledgeOrderDetail));
    }

    /**
     * 删除质押借币订单详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "质押借币订单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tPledgeOrderDetailService.deleteTPledgeOrderDetailByIds(ids));
    }
}
