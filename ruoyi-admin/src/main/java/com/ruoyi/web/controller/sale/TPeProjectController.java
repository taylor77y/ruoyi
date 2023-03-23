package com.ruoyi.web.controller.sale;

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
import com.ruoyi.system.domain.TPeProject;
import com.ruoyi.system.service.ITPeProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 私募项目Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/peProject")
public class TPeProjectController extends BaseController
{
    @Autowired
    private ITPeProjectService tPeProjectService;

    /**
     * 查询私募项目列表
     */
    @PreAuthorize("@ss.hasPermi('system:peProject:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPeProject tPeProject)
    {
        startPage();
        List<TPeProject> list = tPeProjectService.selectTPeProjectList(tPeProject);
        return getDataTable(list);
    }

    /**
     * 导出私募项目列表
     */
    @PreAuthorize("@ss.hasPermi('system:peProject:export')")
    @Log(title = "私募项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPeProject tPeProject)
    {
        List<TPeProject> list = tPeProjectService.selectTPeProjectList(tPeProject);
        ExcelUtil<TPeProject> util = new ExcelUtil<TPeProject>(TPeProject.class);
        util.exportExcel(response, list, "私募项目数据");
    }

    /**
     * 获取私募项目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:peProject:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tPeProjectService.selectTPeProjectById(id));
    }

    /**
     * 新增私募项目
     */
    @PreAuthorize("@ss.hasPermi('system:peProject:add')")
    @Log(title = "私募项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPeProject tPeProject)
    {
        tPeProject.setId(UUID.randomUUID().toString());
        return toAjax(tPeProjectService.insertTPeProject(tPeProject));
    }

    /**
     * 修改私募项目
     */
    @PreAuthorize("@ss.hasPermi('system:peProject:edit')")
    @Log(title = "私募项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPeProject tPeProject)
    {
        return toAjax(tPeProjectService.updateTPeProject(tPeProject));
    }

    /**
     * 删除私募项目
     */
    @PreAuthorize("@ss.hasPermi('system:peProject:remove')")
    @Log(title = "私募项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tPeProjectService.deleteTPeProjectByIds(ids));
    }
}
