package com.ruoyi.web.controller.mhy;

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
import com.ruoyi.system.domain.TSecondsConfig;
import com.ruoyi.system.service.ITSecondsConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 秒合约配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/secondsConfig")
public class TSecondsConfigController extends BaseController
{
    @Autowired
    private ITSecondsConfigService tSecondsConfigService;

    /**
     * 查询秒合约配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:secondsConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSecondsConfig tSecondsConfig)
    {
        startPage();
        List<TSecondsConfig> list = tSecondsConfigService.selectTSecondsConfigList(tSecondsConfig);
        return getDataTable(list);
    }

    /**
     * 导出秒合约配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:secondsConfig:export')")
    @Log(title = "秒合约配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSecondsConfig tSecondsConfig)
    {
        List<TSecondsConfig> list = tSecondsConfigService.selectTSecondsConfigList(tSecondsConfig);
        ExcelUtil<TSecondsConfig> util = new ExcelUtil<TSecondsConfig>(TSecondsConfig.class);
        util.exportExcel(response, list, "秒合约配置数据");
    }

    /**
     * 获取秒合约配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:secondsConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSecondsConfigService.selectTSecondsConfigById(id));
    }

    /**
     * 新增秒合约配置
     */
    @PreAuthorize("@ss.hasPermi('system:secondsConfig:add')")
    @Log(title = "秒合约配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSecondsConfig tSecondsConfig)
    {
        return toAjax(tSecondsConfigService.insertTSecondsConfig(tSecondsConfig));
    }

    /**
     * 修改秒合约配置
     */
    @PreAuthorize("@ss.hasPermi('system:secondsConfig:edit')")
    @Log(title = "秒合约配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSecondsConfig tSecondsConfig)
    {
        return toAjax(tSecondsConfigService.updateTSecondsConfig(tSecondsConfig));
    }

    /**
     * 删除秒合约配置
     */
    @PreAuthorize("@ss.hasPermi('system:secondsConfig:remove')")
    @Log(title = "秒合约配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSecondsConfigService.deleteTSecondsConfigByIds(ids));
    }
}
