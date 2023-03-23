package com.ruoyi.web.controller.contract;

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
import com.ruoyi.system.domain.TContractOrder;
import com.ruoyi.system.service.ITContractOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合约订单Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/contractOrder")
public class TContractOrderController extends BaseController
{
    @Autowired
    private ITContractOrderService tContractOrderService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询合约订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:contractOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TContractOrder tContractOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tContractOrder.setSysIds(getSysIds(list));
        }
        startPage();
        List<TContractOrder> list = tContractOrderService.selectTContractOrderList(tContractOrder);
        return getDataTable(list);
    }

    /**
     * 导出合约订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:contractOrder:export')")
    @Log(title = "合约订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TContractOrder tContractOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tContractOrder.setSysIds(getSysIds(list));
        }
        List<TContractOrder> list = tContractOrderService.selectTContractOrderList(tContractOrder);
        ExcelUtil<TContractOrder> util = new ExcelUtil<TContractOrder>(TContractOrder.class);
        util.exportExcel(response, list, "合约订单数据");
    }

    /**
     * 获取合约订单详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:contractOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tContractOrderService.selectTContractOrderById(id));
    }

    /**
     * 新增合约订单
     */
    @PreAuthorize("@ss.hasPermi('system:contractOrder:add')")
    @Log(title = "合约订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TContractOrder tContractOrder)
    {
        return toAjax(tContractOrderService.insertTContractOrder(tContractOrder));
    }

    /**
     * 修改合约订单
     */
    @PreAuthorize("@ss.hasPermi('system:contractOrder:edit')")
    @Log(title = "合约订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TContractOrder tContractOrder)
    {
        return toAjax(tContractOrderService.updateTContractOrder(tContractOrder));
    }

    /**
     * 删除合约订单
     */
    @PreAuthorize("@ss.hasPermi('system:contractOrder:remove')")
    @Log(title = "合约订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tContractOrderService.deleteTContractOrderByIds(ids));
    }
}
