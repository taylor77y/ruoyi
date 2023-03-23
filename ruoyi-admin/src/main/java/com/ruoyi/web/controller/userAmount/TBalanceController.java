package com.ruoyi.web.controller.userAmount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.service.ITBalanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户余额Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/balance")
public class TBalanceController extends BaseController
{
    @Autowired
    private ITBalanceService tBalanceService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:balance:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBalance tBalance)
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
        List<TBalance> list = tBalanceService.selectTBalanceList(tBalance);
        return getDataTable(list);
    }

    /**
     * 导出用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:balance:export')")
    @Log(title = "用户余额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBalance tBalance)
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
        List<TBalance> list = tBalanceService.selectTBalanceList(tBalance);
        ExcelUtil<TBalance> util = new ExcelUtil<TBalance>(TBalance.class);
        util.exportExcel(response, list, "用户余额数据");
    }

    /**
     * 获取用户余额详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:balance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tBalanceService.selectTBalanceById(id));
    }

    /**
     * 新增用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:balance:add')")
    @Log(title = "用户余额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBalance tBalance)
    {
        return toAjax(tBalanceService.insertTBalance(tBalance));
    }

    /**
     * 修改用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:balance:edit')")
    @Log(title = "用户余额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBalance tBalance)
    {
        return toAjax(tBalanceService.updateTBalance(tBalance));
    }

    /**
     * 删除用户余额
     */
    @PreAuthorize("@ss.hasPermi('system:balance:remove')")
    @Log(title = "用户余额", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tBalanceService.deleteTBalanceByIds(ids));
    }
}
