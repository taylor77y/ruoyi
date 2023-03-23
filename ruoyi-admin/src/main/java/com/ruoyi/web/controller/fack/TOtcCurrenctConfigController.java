package com.ruoyi.web.controller.fack;

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
import com.ruoyi.system.domain.TOtcCurrenctConfig;
import com.ruoyi.system.service.ITOtcCurrenctConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法币币种配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/otcCurrenctConfig")
public class TOtcCurrenctConfigController extends BaseController
{
    @Autowired
    private ITOtcCurrenctConfigService tOtcCurrenctConfigService;

    /**
     * 查询法币币种配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        startPage();
        List<TOtcCurrenctConfig> list = tOtcCurrenctConfigService.selectTOtcCurrenctConfigList(tOtcCurrenctConfig);
        return getDataTable(list);
    }

    /**
     * 导出法币币种配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:export')")
    @Log(title = "法币币种配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        List<TOtcCurrenctConfig> list = tOtcCurrenctConfigService.selectTOtcCurrenctConfigList(tOtcCurrenctConfig);
        ExcelUtil<TOtcCurrenctConfig> util = new ExcelUtil<TOtcCurrenctConfig>(TOtcCurrenctConfig.class);
        util.exportExcel(response, list, "法币币种配置数据");
    }

    /**
     * 获取法币币种配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tOtcCurrenctConfigService.selectTOtcCurrenctConfigById(id));
    }

    /**
     * 新增法币币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:add')")
    @Log(title = "法币币种配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        return toAjax(tOtcCurrenctConfigService.insertTOtcCurrenctConfig(tOtcCurrenctConfig));
    }

    /**
     * 修改法币币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:edit')")
    @Log(title = "法币币种配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcCurrenctConfig tOtcCurrenctConfig)
    {
        return toAjax(tOtcCurrenctConfigService.updateTOtcCurrenctConfig(tOtcCurrenctConfig));
    }

    /**
     * 删除法币币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:otcCurrenctConfig:remove')")
    @Log(title = "法币币种配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tOtcCurrenctConfigService.deleteTOtcCurrenctConfigByIds(ids));
    }
}
