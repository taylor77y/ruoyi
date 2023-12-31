package com.ruoyi.web.controller.mhy;

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
import com.ruoyi.system.domain.TSecondsBetLog;
import com.ruoyi.system.service.ITSecondsBetLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 秒合约记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/secondsBetLog")
public class TSecondsBetLogController extends BaseController
{
    @Autowired
    private ITSecondsBetLogService tSecondsBetLogService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询秒合约记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSecondsBetLog tSecondsBetLog)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tSecondsBetLog.setSysIds(getSysIds(list));
        }
        startPage();
        List<TSecondsBetLog> list = tSecondsBetLogService.selectTSecondsBetLogList(tSecondsBetLog);
        return getDataTable(list);
    }

    /**
     * 导出秒合约记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:export')")
    @Log(title = "秒合约记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSecondsBetLog tSecondsBetLog)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tSecondsBetLog.setSysIds(getSysIds(list));
        }
        List<TSecondsBetLog> list = tSecondsBetLogService.selectTSecondsBetLogList(tSecondsBetLog);
        ExcelUtil<TSecondsBetLog> util = new ExcelUtil<TSecondsBetLog>(TSecondsBetLog.class);
        util.exportExcel(response, list, "秒合约记录数据");
    }

    /**
     * 获取秒合约记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSecondsBetLogService.selectTSecondsBetLogById(id));
    }

    /**
     * 新增秒合约记录
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:add')")
    @Log(title = "秒合约记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSecondsBetLog tSecondsBetLog)
    {
        return toAjax(tSecondsBetLogService.insertTSecondsBetLog(tSecondsBetLog));
    }

    /**
     * 修改秒合约记录
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:edit')")
    @Log(title = "秒合约记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSecondsBetLog tSecondsBetLog)
    {
        return toAjax(tSecondsBetLogService.updateTSecondsBetLog(tSecondsBetLog));
    }

    /**
     * 删除秒合约记录
     */
    @PreAuthorize("@ss.hasPermi('system:secondsBetLog:remove')")
    @Log(title = "秒合约记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSecondsBetLogService.deleteTSecondsBetLogByIds(ids));
    }
}
