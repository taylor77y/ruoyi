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
import com.ruoyi.system.domain.TSysConfig;
import com.ruoyi.system.service.ITSysConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 三方接口Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/thirdPart")
public class TSysConfigController extends BaseController
{
    @Autowired
    private ITSysConfigService tSysConfigService;

    /**
     * 查询三方接口列表
     */
    @PreAuthorize("@ss.hasPermi('system:thirdPart:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSysConfig tSysConfig)
    {
        startPage();
        List<TSysConfig> list = tSysConfigService.selectTSysConfigList(tSysConfig);
        return getDataTable(list);
    }

    /**
     * 导出三方接口列表
     */
    @PreAuthorize("@ss.hasPermi('system:thirdPart:export')")
    @Log(title = "三方接口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSysConfig tSysConfig)
    {
        List<TSysConfig> list = tSysConfigService.selectTSysConfigList(tSysConfig);
        ExcelUtil<TSysConfig> util = new ExcelUtil<TSysConfig>(TSysConfig.class);
        util.exportExcel(response, list, "三方接口数据");
    }

    /**
     * 获取三方接口详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:thirdPart:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tSysConfigService.selectTSysConfigById(id));
    }

    /**
     * 新增三方接口
     */
    @PreAuthorize("@ss.hasPermi('system:thirdPart:add')")
    @Log(title = "三方接口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSysConfig tSysConfig)
    {
        tSysConfig.setId(UUID.randomUUID().toString());
        return toAjax(tSysConfigService.insertTSysConfig(tSysConfig));
    }

    /**
     * 修改三方接口
     */
    @PreAuthorize("@ss.hasPermi('system:thirdPart:edit')")
    @Log(title = "三方接口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSysConfig tSysConfig)
    {
        return toAjax(tSysConfigService.updateTSysConfig(tSysConfig));
    }

    /**
     * 删除三方接口
     */
    @PreAuthorize("@ss.hasPermi('system:thirdPart:remove')")
    @Log(title = "三方接口", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tSysConfigService.deleteTSysConfigByIds(ids));
    }
}
