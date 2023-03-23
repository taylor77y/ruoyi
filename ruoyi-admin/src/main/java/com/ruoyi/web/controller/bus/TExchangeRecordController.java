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
import com.ruoyi.system.domain.TExchangeRecord;
import com.ruoyi.system.service.ITExchangeRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币币兑换记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-25
 */
@RestController
@RequestMapping("/system/exchangeRecord")
public class TExchangeRecordController extends BaseController
{
    @Autowired
    private ITExchangeRecordService tExchangeRecordService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询币币兑换记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TExchangeRecord tExchangeRecord)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tExchangeRecord.setSysIds(getSysIds(list));
        }
        startPage();
        List<TExchangeRecord> list = tExchangeRecordService.selectTExchangeRecordList(tExchangeRecord);
        return getDataTable(list);
    }

    /**
     * 导出币币兑换记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:export')")
    @Log(title = "币币兑换记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TExchangeRecord tExchangeRecord)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tExchangeRecord.setSysIds(getSysIds(list));
        }
        List<TExchangeRecord> list = tExchangeRecordService.selectTExchangeRecordList(tExchangeRecord);
        ExcelUtil<TExchangeRecord> util = new ExcelUtil<TExchangeRecord>(TExchangeRecord.class);
        util.exportExcel(response, list, "币币兑换记录数据");
    }

    /**
     * 获取币币兑换记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tExchangeRecordService.selectTExchangeRecordById(id));
    }

    /**
     * 新增币币兑换记录
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:add')")
    @Log(title = "币币兑换记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TExchangeRecord tExchangeRecord)
    {
        return toAjax(tExchangeRecordService.insertTExchangeRecord(tExchangeRecord));
    }

    /**
     * 修改币币兑换记录
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:edit')")
    @Log(title = "币币兑换记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TExchangeRecord tExchangeRecord)
    {
        return toAjax(tExchangeRecordService.updateTExchangeRecord(tExchangeRecord));
    }

    /**
     * 删除币币兑换记录
     */
    @PreAuthorize("@ss.hasPermi('system:exchangeRecord:remove')")
    @Log(title = "币币兑换记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tExchangeRecordService.deleteTExchangeRecordByIds(ids));
    }
}
