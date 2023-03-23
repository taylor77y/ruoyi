package com.ruoyi.web.controller.userAmount;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.domain.TSysBalance;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.ITBalanceService;
import com.ruoyi.system.service.ITSysBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户余额Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/sysbalance")
public class TSysBalanceController extends BaseController
{
    @Autowired
    private ITSysBalanceService itSysBalanceService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSysBalance tBalance)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalance.setSysIds(getSysIds(list));
        }
        startPage();
        List<TSysBalance> list = itSysBalanceService.selectTBalanceList(tBalance);
        return getDataTable(list);
    }

    /**
     * 导出用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:export')")
    @Log(title = "用户余额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSysBalance tBalance)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalance.setSysIds(getSysIds(list));
        }
        List<TSysBalance> list = itSysBalanceService.selectTBalanceList(tBalance);
        ExcelUtil<TSysBalance> util = new ExcelUtil<TSysBalance>(TSysBalance.class);
        util.exportExcel(response, list, "用户余额数据");
    }

    /**
     * 获取用户余额详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(itSysBalanceService.selectTBalanceById(id));
    }

    /**
     * 新增用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:add')")
    @Log(title = "用户余额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSysBalance tSysBalance)
    {
        return toAjax(itSysBalanceService.insertTBalance(tSysBalance));
    }

    /**
     * 修改用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:edit')")
    @Log(title = "用户余额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSysBalance tSysBalance)
    {
        return toAjax(itSysBalanceService.updateTBalance(tSysBalance));
    }

    /**
     * 删除用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:sysbalance:remove')")
    @Log(title = "用户余额", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(itSysBalanceService.deleteTBalanceByIds(ids));
    }
}
