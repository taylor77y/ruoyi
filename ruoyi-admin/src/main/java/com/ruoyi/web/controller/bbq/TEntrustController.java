package com.ruoyi.web.controller.bbq;

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
import com.ruoyi.system.domain.TEntrust;
import com.ruoyi.system.service.ITEntrustService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币币撮合Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/entrust")
public class TEntrustController extends BaseController
{
    @Autowired
    private ITEntrustService tEntrustService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询币币撮合列表
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEntrust tEntrust)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tEntrust.setSysIds(getSysIds(list));
        }
        startPage();
        List<TEntrust> list = tEntrustService.selectTEntrustList(tEntrust);
        return getDataTable(list);
    }

    /**
     * 导出币币撮合列表
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:export')")
    @Log(title = "币币撮合", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEntrust tEntrust)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tEntrust.setSysIds(getSysIds(list));
        }
        List<TEntrust> list = tEntrustService.selectTEntrustList(tEntrust);
        ExcelUtil<TEntrust> util = new ExcelUtil<TEntrust>(TEntrust.class);
        util.exportExcel(response, list, "币币撮合数据");
    }

    /**
     * 获取币币撮合详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:entrust:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tEntrustService.selectTEntrustById(id));
    }

    /**
     * 新增币币撮合
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:add')")
    @Log(title = "币币撮合", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEntrust tEntrust)
    {
        return toAjax(tEntrustService.insertTEntrust(tEntrust));
    }

    /**
     * 修改币币撮合
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:edit')")
    @Log(title = "币币撮合", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEntrust tEntrust)
    {
        return toAjax(tEntrustService.updateTEntrust(tEntrust));
    }

    /**
     * 删除币币撮合
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:remove')")
    @Log(title = "币币撮合", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tEntrustService.deleteTEntrustByIds(ids));
    }

    /**
     * 撤销
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:cancel')")
    @Log(title = "币币撮合", businessType = BusinessType.OTHER)
    @PostMapping("/cancel/{id}")
    public AjaxResult cancel(@PathVariable String id){
        return tEntrustService.cancel(id);
    }

    /**
     * 同意
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:agree')")
    @Log(title = "币币撮合", businessType = BusinessType.OTHER)
    @PostMapping("/agree/{id}")
    public AjaxResult agree(@PathVariable String id){
        return tEntrustService.agree(id);
    }
}
