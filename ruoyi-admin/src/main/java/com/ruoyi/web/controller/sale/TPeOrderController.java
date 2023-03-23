package com.ruoyi.web.controller.sale;

import java.util.List;
import java.util.UUID;
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
import com.ruoyi.system.domain.TPeOrder;
import com.ruoyi.system.service.ITPeOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 私募订单Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/peOrder")
public class TPeOrderController extends BaseController
{
    @Autowired
    private ITPeOrderService tPeOrderService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询私募订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:peOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPeOrder tPeOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tPeOrder.setSysIds(getSysIds(list));
        }
        startPage();
        List<TPeOrder> list = tPeOrderService.selectTPeOrderList(tPeOrder);
        return getDataTable(list);
    }

    /**
     * 导出私募订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:peOrder:export')")
    @Log(title = "私募订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPeOrder tPeOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tPeOrder.setSysIds(getSysIds(list));
        }
        List<TPeOrder> list = tPeOrderService.selectTPeOrderList(tPeOrder);
        ExcelUtil<TPeOrder> util = new ExcelUtil<TPeOrder>(TPeOrder.class);
        util.exportExcel(response, list, "私募订单数据");
    }

    /**
     * 获取私募订单详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:peOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tPeOrderService.selectTPeOrderById(id));
    }

    /**
     * 新增私募订单
     */
    @PreAuthorize("@ss.hasPermi('system:peOrder:add')")
    @Log(title = "私募订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPeOrder tPeOrder)
    {
        tPeOrder.setId(UUID.randomUUID().toString());
        return toAjax(tPeOrderService.insertTPeOrder(tPeOrder));
    }

    /**
     * 修改私募订单
     */
    @PreAuthorize("@ss.hasPermi('system:peOrder:edit')")
    @Log(title = "私募订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPeOrder tPeOrder)
    {
        return toAjax(tPeOrderService.updateTPeOrder(tPeOrder));
    }

    /**
     * 删除私募订单
     */
    @PreAuthorize("@ss.hasPermi('system:peOrder:remove')")
    @Log(title = "私募订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tPeOrderService.deleteTPeOrderByIds(ids));
    }
}
