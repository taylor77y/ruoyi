package com.ruoyi.web.controller.platConfig;

import java.util.List;
import java.util.UUID;
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
import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.service.ITBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币币-banner图Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/banner")
public class TBannerController extends BaseController
{
    @Autowired
    private ITBannerService tBannerService;

    /**
     * 查询币币-banner图列表
     */
    @PreAuthorize("@ss.hasPermi('system:banner:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBanner tBanner)
    {
        startPage();
        List<TBanner> list = tBannerService.selectTBannerList(tBanner);
        return getDataTable(list);
    }

    /**
     * 导出币币-banner图列表
     */
    @PreAuthorize("@ss.hasPermi('system:banner:export')")
    @Log(title = "币币-banner图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBanner tBanner)
    {
        List<TBanner> list = tBannerService.selectTBannerList(tBanner);
        ExcelUtil<TBanner> util = new ExcelUtil<TBanner>(TBanner.class);
        util.exportExcel(response, list, "币币-banner图数据");
    }

    /**
     * 获取币币-banner图详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:banner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tBannerService.selectTBannerById(id));
    }

    /**
     * 新增币币-banner图
     */
    @PreAuthorize("@ss.hasPermi('system:banner:add')")
    @Log(title = "币币-banner图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBanner tBanner)
    {
        tBanner.setId(UUID.randomUUID().toString());
        return toAjax(tBannerService.insertTBanner(tBanner));
    }

    /**
     * 修改币币-banner图
     */
    @PreAuthorize("@ss.hasPermi('system:banner:edit')")
    @Log(title = "币币-banner图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBanner tBanner)
    {
        return toAjax(tBannerService.updateTBanner(tBanner));
    }

    /**
     * 删除币币-banner图
     */
    @PreAuthorize("@ss.hasPermi('system:banner:remove')")
    @Log(title = "币币-banner图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tBannerService.deleteTBannerByIds(ids));
    }
}
