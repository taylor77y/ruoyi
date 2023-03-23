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
import com.ruoyi.system.domain.TOtcTypeConfig;
import com.ruoyi.system.service.ITOtcTypeConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单持续总时长Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/otcTypeConfig")
public class TOtcTypeConfigController extends BaseController
{
    @Autowired
    private ITOtcTypeConfigService tOtcTypeConfigService;

    /**
     * 查询订单持续总时长列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcTypeConfig tOtcTypeConfig)
    {
        startPage();
        List<TOtcTypeConfig> list = tOtcTypeConfigService.selectTOtcTypeConfigList(tOtcTypeConfig);
        return getDataTable(list);
    }

    /**
     * 导出订单持续总时长列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:export')")
    @Log(title = "订单持续总时长", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcTypeConfig tOtcTypeConfig)
    {
        List<TOtcTypeConfig> list = tOtcTypeConfigService.selectTOtcTypeConfigList(tOtcTypeConfig);
        ExcelUtil<TOtcTypeConfig> util = new ExcelUtil<TOtcTypeConfig>(TOtcTypeConfig.class);
        util.exportExcel(response, list, "订单持续总时长数据");
    }

    /**
     * 获取订单持续总时长详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tOtcTypeConfigService.selectTOtcTypeConfigById(id));
    }

    /**
     * 新增订单持续总时长
     */
    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:add')")
    @Log(title = "订单持续总时长", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcTypeConfig tOtcTypeConfig)
    {
        return toAjax(tOtcTypeConfigService.insertTOtcTypeConfig(tOtcTypeConfig));
    }

    /**
     * 修改订单持续总时长
     */
    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:edit')")
    @Log(title = "订单持续总时长", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcTypeConfig tOtcTypeConfig)
    {
        return toAjax(tOtcTypeConfigService.updateTOtcTypeConfig(tOtcTypeConfig));
    }

    /**
     * 删除订单持续总时长
     */
    @PreAuthorize("@ss.hasPermi('system:otcTypeConfig:remove')")
    @Log(title = "订单持续总时长", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tOtcTypeConfigService.deleteTOtcTypeConfigByIds(ids));
    }
}
