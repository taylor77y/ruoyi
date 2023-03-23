package com.ruoyi.web.controller.bus;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Approve;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/approve")
public class ApproveController extends BaseController
{
    @Autowired
    private IApproveService approveService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:approve:list')")
    @GetMapping("/list")
    public TableDataInfo list(Approve approve)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            approve.setSysIds(getSysIds(list));
        }
        startPage();
        List<Approve> list = approveService.selectTMemberList(approve);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:approve:export')")
    @Log(title = "商家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Approve approve)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            approve.setSysIds(getSysIds(list));
        }
        List<Approve> list = approveService.selectTMemberList(approve);
        ExcelUtil<Approve> util = new ExcelUtil<Approve>(Approve.class);
        util.exportExcel(response, list, "认证数据");
    }

    /**
     * 获取会员详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:approve:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(approveService.selectTMemberById(id));
    }

    /**
     * 新增会员
     */
    @PreAuthorize("@ss.hasPermi('system:approve:add')")
    @Log(title = "商家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Approve approve)
    {
        return toAjax(approveService.insertTMember(approve));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('system:approve:edit')")
    @Log(title = "商家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Approve approve)
    {
        return toAjax(approveService.updateTMember(approve));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('system:approve:remove')")
    @Log(title = "商家", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(approveService.deleteTMemberByIds(ids));
    }

}
