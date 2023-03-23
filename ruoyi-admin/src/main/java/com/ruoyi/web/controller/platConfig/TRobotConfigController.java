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
import com.ruoyi.system.domain.TRobotConfig;
import com.ruoyi.system.service.ITRobotConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机器人配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/robotConfig")
public class TRobotConfigController extends BaseController
{
    @Autowired
    private ITRobotConfigService tRobotConfigService;

    /**
     * 查询机器人配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:robotConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(TRobotConfig tRobotConfig)
    {
        startPage();
        List<TRobotConfig> list = tRobotConfigService.selectTRobotConfigList(tRobotConfig);
        return getDataTable(list);
    }

    /**
     * 导出机器人配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:robotConfig:export')")
    @Log(title = "机器人配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TRobotConfig tRobotConfig)
    {
        List<TRobotConfig> list = tRobotConfigService.selectTRobotConfigList(tRobotConfig);
        ExcelUtil<TRobotConfig> util = new ExcelUtil<TRobotConfig>(TRobotConfig.class);
        util.exportExcel(response, list, "机器人配置数据");
    }

    /**
     * 获取机器人配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:robotConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tRobotConfigService.selectTRobotConfigById(id));
    }

    /**
     * 新增机器人配置
     */
    @PreAuthorize("@ss.hasPermi('system:robotConfig:add')")
    @Log(title = "机器人配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TRobotConfig tRobotConfig)
    {
        tRobotConfig.setId(UUID.randomUUID().toString());
        return toAjax(tRobotConfigService.insertTRobotConfig(tRobotConfig));
    }

    /**
     * 修改机器人配置
     */
    @PreAuthorize("@ss.hasPermi('system:robotConfig:edit')")
    @Log(title = "机器人配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TRobotConfig tRobotConfig)
    {
        return toAjax(tRobotConfigService.updateTRobotConfig(tRobotConfig));
    }

    /**
     * 删除机器人配置
     */
    @PreAuthorize("@ss.hasPermi('system:robotConfig:remove')")
    @Log(title = "机器人配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tRobotConfigService.deleteTRobotConfigByIds(ids));
    }
}
