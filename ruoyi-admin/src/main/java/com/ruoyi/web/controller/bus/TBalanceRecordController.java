package com.ruoyi.web.controller.bus;

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
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.service.ITBalanceRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资金记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
@RestController
@RequestMapping("/system/balanceRecord")
public class TBalanceRecordController extends BaseController
{
    @Autowired
    private ITBalanceRecordService tBalanceRecordService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询资金记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBalanceRecord tBalanceRecord)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalanceRecord.setSysIds(getSysIds(list));
        }
        startPage();
        List<TBalanceRecord> list = tBalanceRecordService.selectTBalanceRecordList(tBalanceRecord);
        return getDataTable(list);
    }

    /**
     * 导出资金记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:export')")
    @Log(title = "资金记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBalanceRecord tBalanceRecord)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalanceRecord.setSysIds(getSysIds(list));
        }
        List<TBalanceRecord> list = tBalanceRecordService.selectTBalanceRecordList(tBalanceRecord);
        ExcelUtil<TBalanceRecord> util = new ExcelUtil<TBalanceRecord>(TBalanceRecord.class);
        util.exportExcel(response, list, "资金记录数据");
    }

    /**
     * 获取资金记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tBalanceRecordService.selectTBalanceRecordById(id));
    }

    /**
     * 新增资金记录
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:add')")
    @Log(title = "资金记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBalanceRecord tBalanceRecord)
    {
        return toAjax(tBalanceRecordService.insertTBalanceRecord(tBalanceRecord));
    }

    /**
     * 修改资金记录
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:edit')")
    @Log(title = "资金记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBalanceRecord tBalanceRecord)
    {
        return toAjax(tBalanceRecordService.updateTBalanceRecord(tBalanceRecord));
    }

    /**
     * 删除资金记录
     */
    @PreAuthorize("@ss.hasPermi('system:balanceRecord:remove')")
    @Log(title = "资金记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBalanceRecordService.deleteTBalanceRecordByIds(ids));
    }
}
