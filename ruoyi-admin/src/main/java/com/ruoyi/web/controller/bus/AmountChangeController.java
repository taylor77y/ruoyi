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
import com.ruoyi.system.domain.AmountChange;
import com.ruoyi.system.service.IAmountChangeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资金变更记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/amountChange")
public class AmountChangeController extends BaseController
{
    @Autowired
    private IAmountChangeService amountChangeService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询资金变更记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:amountChange:list')")
    @GetMapping("/list")
    public TableDataInfo list(AmountChange amountChange)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            amountChange.setSysIds(getSysIds(list));
        }
        startPage();
        List<AmountChange> list = amountChangeService.selectAmountChangeList(amountChange);
        return getDataTable(list);
    }

    /**
     * 导出资金变更记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:amountChange:export')")
    @Log(title = "资金变更记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AmountChange amountChange)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            amountChange.setSysIds(getSysIds(list));
        }
        List<AmountChange> list = amountChangeService.selectAmountChangeList(amountChange);
        ExcelUtil<AmountChange> util = new ExcelUtil<AmountChange>(AmountChange.class);
        util.exportExcel(response, list, "资金变更记录数据");
    }

    /**
     * 获取资金变更记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:amountChange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(amountChangeService.selectAmountChangeById(id));
    }

    /**
     * 新增资金变更记录
     */
    @PreAuthorize("@ss.hasPermi('system:amountChange:add')")
    @Log(title = "资金变更记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AmountChange amountChange)
    {
        return toAjax(amountChangeService.insertAmountChange(amountChange));
    }

    /**
     * 修改资金变更记录
     */
    @PreAuthorize("@ss.hasPermi('system:amountChange:edit')")
    @Log(title = "资金变更记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AmountChange amountChange)
    {
        return toAjax(amountChangeService.updateAmountChange(amountChange));
    }

    /**
     * 删除资金变更记录
     */
    @PreAuthorize("@ss.hasPermi('system:amountChange:remove')")
    @Log(title = "资金变更记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(amountChangeService.deleteAmountChangeByIds(ids));
    }
}
