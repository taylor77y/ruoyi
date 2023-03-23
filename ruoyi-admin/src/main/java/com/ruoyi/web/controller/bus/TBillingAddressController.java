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
import com.ruoyi.system.domain.TBillingAddress;
import com.ruoyi.system.service.ITBillingAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户提款账单地址Controller
 * 
 * @author ruoyi
 * @date 2022-10-11
 */
@RestController
@RequestMapping("/system/billingAddress")
public class TBillingAddressController extends BaseController
{
    @Autowired
    private ITBillingAddressService tBillingAddressService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询用户提款账单地址列表
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBillingAddress tBillingAddress)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBillingAddress.setSysIds(getSysIds(list));
        }
        startPage();
        List<TBillingAddress> list = tBillingAddressService.selectTBillingAddressList(tBillingAddress);
        return getDataTable(list);
    }

    /**
     * 导出用户提款账单地址列表
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:export')")
    @Log(title = "用户提款账单地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBillingAddress tBillingAddress)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBillingAddress.setSysIds(getSysIds(list));
        }
        List<TBillingAddress> list = tBillingAddressService.selectTBillingAddressList(tBillingAddress);
        ExcelUtil<TBillingAddress> util = new ExcelUtil<TBillingAddress>(TBillingAddress.class);
        util.exportExcel(response, list, "用户提款账单地址数据");
    }

    /**
     * 获取用户提款账单地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tBillingAddressService.selectTBillingAddressById(id));
    }

    /**
     * 新增用户提款账单地址
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:add')")
    @Log(title = "用户提款账单地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBillingAddress tBillingAddress)
    {
        return toAjax(tBillingAddressService.insertTBillingAddress(tBillingAddress));
    }

    /**
     * 修改用户提款账单地址
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:edit')")
    @Log(title = "用户提款账单地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBillingAddress tBillingAddress)
    {
        return toAjax(tBillingAddressService.updateTBillingAddress(tBillingAddress));
    }

    /**
     * 删除用户提款账单地址
     */
    @PreAuthorize("@ss.hasPermi('system:billingAddress:remove')")
    @Log(title = "用户提款账单地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBillingAddressService.deleteTBillingAddressByIds(ids));
    }
}
