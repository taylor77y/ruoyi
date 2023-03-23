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
import com.ruoyi.system.domain.TMemberCurrencyConfig;
import com.ruoyi.system.service.ITMemberCurrencyConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法币配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/memberCurrencyConfig")
public class TMemberCurrencyConfigController extends BaseController
{
    @Autowired
    private ITMemberCurrencyConfigService tMemberCurrencyConfigService;

    /**
     * 查询法币配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        startPage();
        List<TMemberCurrencyConfig> list = tMemberCurrencyConfigService.selectTMemberCurrencyConfigList(tMemberCurrencyConfig);
        return getDataTable(list);
    }

    /**
     * 导出法币配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:export')")
    @Log(title = "法币配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        List<TMemberCurrencyConfig> list = tMemberCurrencyConfigService.selectTMemberCurrencyConfigList(tMemberCurrencyConfig);
        ExcelUtil<TMemberCurrencyConfig> util = new ExcelUtil<TMemberCurrencyConfig>(TMemberCurrencyConfig.class);
        util.exportExcel(response, list, "法币配置数据");
    }

    /**
     * 获取法币配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tMemberCurrencyConfigService.selectTMemberCurrencyConfigById(id));
    }

    /**
     * 新增法币配置
     */
    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:add')")
    @Log(title = "法币配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        return toAjax(tMemberCurrencyConfigService.insertTMemberCurrencyConfig(tMemberCurrencyConfig));
    }

    /**
     * 修改法币配置
     */
    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:edit')")
    @Log(title = "法币配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMemberCurrencyConfig tMemberCurrencyConfig)
    {
        return toAjax(tMemberCurrencyConfigService.updateTMemberCurrencyConfig(tMemberCurrencyConfig));
    }

    /**
     * 删除法币配置
     */
    @PreAuthorize("@ss.hasPermi('system:memberCurrencyConfig:remove')")
    @Log(title = "法币配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMemberCurrencyConfigService.deleteTMemberCurrencyConfigByIds(ids));
    }
}
