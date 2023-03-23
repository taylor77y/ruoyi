package com.ruoyi.web.controller.kline;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.kline.TCurrencyControls;
import org.aspectj.weaver.loadtime.Aj;
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
import com.ruoyi.system.service.ITCurrencyControlsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自发币控制Controller
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@RestController
@RequestMapping("/system/currencyControls")
public class TCurrencyControlsController extends BaseController
{
    @Autowired
    private ITCurrencyControlsService tCurrencyControlsService;

    /**
     * 查询自发币控制列表
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:list')")
    @GetMapping("/list")
    public TableDataInfo list(TCurrencyControls tCurrencyControls)
    {
        startPage();
        List<TCurrencyControls> list = tCurrencyControlsService.selectTCurrencyControlsList(tCurrencyControls);
        return getDataTable(list);
    }

    /**
     * 导出自发币控制列表
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:export')")
    @Log(title = "自发币控制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TCurrencyControls tCurrencyControls)
    {
        List<TCurrencyControls> list = tCurrencyControlsService.selectTCurrencyControlsList(tCurrencyControls);
        ExcelUtil<TCurrencyControls> util = new ExcelUtil<TCurrencyControls>(TCurrencyControls.class);
        util.exportExcel(response, list, "自发币控制数据");
    }

    /**
     * 获取自发币控制详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tCurrencyControlsService.selectTCurrencyControlsById(id));
    }

    /**
     * 新增自发币控制
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:add')")
    @Log(title = "自发币控制", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCurrencyControls tCurrencyControls)
    {
        return toAjax(tCurrencyControlsService.insertTCurrencyControls(tCurrencyControls));
    }

    /**
     * 修改自发币控制
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:edit')")
    @Log(title = "自发币控制", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCurrencyControls tCurrencyControls)
    {
        return toAjax(tCurrencyControlsService.updateTCurrencyControls(tCurrencyControls));
    }

    /**
     * 删除自发币控制
     */
    @PreAuthorize("@ss.hasPermi('system:currencyControls:remove')")
    @Log(title = "自发币控制", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tCurrencyControlsService.deleteTCurrencyControlsByIds(ids));
    }

    @GetMapping("/getCurs")
    public AjaxResult getCurs(){
        return AjaxResult.success(tCurrencyControlsService.selectTCurrencyControlsList(new TCurrencyControls()));
    }
}
