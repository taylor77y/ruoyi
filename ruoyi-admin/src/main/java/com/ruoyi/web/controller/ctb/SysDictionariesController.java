package com.ruoyi.web.controller.ctb;

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
import com.ruoyi.system.domain.SysDictionaries;
import com.ruoyi.system.service.ISysDictionariesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 *  充提配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/dictionaries")
public class SysDictionariesController extends BaseController
{
    @Autowired
    private ISysDictionariesService sysDictionariesService;

    /**
     * 查询 充提配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:dictionaries:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDictionaries sysDictionaries)
    {
        startPage();
        List<SysDictionaries> list = sysDictionariesService.selectSysDictionariesList(sysDictionaries);
        return getDataTable(list);
    }

    /**
     * 导出 充提配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:dictionaries:export')")
    @Log(title = " 充提配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictionaries sysDictionaries)
    {
        List<SysDictionaries> list = sysDictionariesService.selectSysDictionariesList(sysDictionaries);
        ExcelUtil<SysDictionaries> util = new ExcelUtil<SysDictionaries>(SysDictionaries.class);
        util.exportExcel(response, list, " 充提配置数据");
    }

    /**
     * 获取 充提配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:dictionaries:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysDictionariesService.selectSysDictionariesById(id));
    }

    /**
     * 新增 充提配置
     */
    @PreAuthorize("@ss.hasPermi('system:dictionaries:add')")
    @Log(title = " 充提配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDictionaries sysDictionaries)
    {
        return toAjax(sysDictionariesService.insertSysDictionaries(sysDictionaries));
    }

    /**
     * 修改 充提配置
     */
    @PreAuthorize("@ss.hasPermi('system:dictionaries:edit')")
    @Log(title = " 充提配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDictionaries sysDictionaries)
    {
        return toAjax(sysDictionariesService.updateSysDictionaries(sysDictionaries));
    }

    /**
     * 删除 充提配置
     */
    @PreAuthorize("@ss.hasPermi('system:dictionaries:remove')")
    @Log(title = " 充提配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysDictionariesService.deleteSysDictionariesByIds(ids));
    }
}
