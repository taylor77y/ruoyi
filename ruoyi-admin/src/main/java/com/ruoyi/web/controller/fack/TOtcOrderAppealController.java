package com.ruoyi.web.controller.fack;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.TOtcOrderAppeal;
import com.ruoyi.system.service.ITOtcOrderAppealService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Otc申诉Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/otcOrderAppeal")
public class TOtcOrderAppealController extends BaseController
{
    @Autowired
    private ITOtcOrderAppealService tOtcOrderAppealService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询Otc申诉列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcOrderAppeal tOtcOrderAppeal)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrderAppeal.setSysIds(getSysIds(list));
        }
        startPage();
        List<TOtcOrderAppeal> list = tOtcOrderAppealService.selectTOtcOrderAppealList(tOtcOrderAppeal);
        return getDataTable(list);
    }

    /**
     * 导出Otc申诉列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:export')")
    @Log(title = "Otc申诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcOrderAppeal tOtcOrderAppeal)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrderAppeal.setSysIds(getSysIds(list));
        }
        List<TOtcOrderAppeal> list = tOtcOrderAppealService.selectTOtcOrderAppealList(tOtcOrderAppeal);
        ExcelUtil<TOtcOrderAppeal> util = new ExcelUtil<TOtcOrderAppeal>(TOtcOrderAppeal.class);
        util.exportExcel(response, list, "Otc申诉数据");
    }

    /**
     * 获取Otc申诉详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tOtcOrderAppealService.selectTOtcOrderAppealById(id));
    }

    /**
     * 新增Otc申诉
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:add')")
    @Log(title = "Otc申诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcOrderAppeal tOtcOrderAppeal)
    {
        return toAjax(tOtcOrderAppealService.insertTOtcOrderAppeal(tOtcOrderAppeal));
    }

    /**
     * 修改Otc申诉
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:edit')")
    @Log(title = "Otc申诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcOrderAppeal tOtcOrderAppeal)
    {
        return toAjax(tOtcOrderAppealService.updateTOtcOrderAppeal(tOtcOrderAppeal));
    }

    /**
     * 删除Otc申诉
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderAppeal:remove')")
    @Log(title = "Otc申诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tOtcOrderAppealService.deleteTOtcOrderAppealByIds(ids));
    }
}
