package com.ruoyi.web.controller.bus;

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
import com.ruoyi.system.domain.TCustomerService;
import com.ruoyi.system.service.ITCustomerServiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客服链接配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/customerService")
public class TCustomerServiceController extends BaseController
{
    @Autowired
    private ITCustomerServiceService tCustomerServiceService;

    /**
     * 查询客服链接配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:customerService:list')")
    @GetMapping("/list")
    public TableDataInfo list(TCustomerService tCustomerService)
    {
        startPage();
        List<TCustomerService> list = tCustomerServiceService.selectTCustomerServiceList(tCustomerService);
        return getDataTable(list);
    }

    /**
     * 导出客服链接配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:customerService:export')")
    @Log(title = "客服链接配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TCustomerService tCustomerService)
    {
        List<TCustomerService> list = tCustomerServiceService.selectTCustomerServiceList(tCustomerService);
        ExcelUtil<TCustomerService> util = new ExcelUtil<TCustomerService>(TCustomerService.class);
        util.exportExcel(response, list, "客服链接配置数据");
    }

    /**
     * 获取客服链接配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:customerService:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tCustomerServiceService.selectTCustomerServiceById(id));
    }

    /**
     * 新增客服链接配置
     */
    @PreAuthorize("@ss.hasPermi('system:customerService:add')")
    @Log(title = "客服链接配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCustomerService tCustomerService)
    {
        return toAjax(tCustomerServiceService.insertTCustomerService(tCustomerService));
    }

    /**
     * 修改客服链接配置
     */
    @PreAuthorize("@ss.hasPermi('system:customerService:edit')")
    @Log(title = "客服链接配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCustomerService tCustomerService)
    {
        return toAjax(tCustomerServiceService.updateTCustomerService(tCustomerService));
    }

    /**
     * 删除客服链接配置
     */
    @PreAuthorize("@ss.hasPermi('system:customerService:remove')")
    @Log(title = "客服链接配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tCustomerServiceService.deleteTCustomerServiceByIds(ids));
    }
}
