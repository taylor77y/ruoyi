package com.ruoyi.web.controller.fack;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.domain.TMemberCurrencyConfig;
import com.ruoyi.system.service.*;
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
import com.ruoyi.system.domain.TOtcOrder;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法币订单Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/otcOrder")
public class TOtcOrderController extends BaseController
{
    @Autowired
    private ITOtcOrderService tOtcOrderService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询法币订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcOrder tOtcOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrder.setSysIds(getSysIds(list));
        }
        startPage();
        List<TOtcOrder> list = tOtcOrderService.selectTOtcOrderList(tOtcOrder);
        return getDataTable(list);
    }

    /**
     * 导出法币订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrder:export')")
    @Log(title = "法币订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcOrder tOtcOrder)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrder.setSysIds(getSysIds(list));
        }
        List<TOtcOrder> list = tOtcOrderService.selectTOtcOrderList(tOtcOrder);
        ExcelUtil<TOtcOrder> util = new ExcelUtil<TOtcOrder>(TOtcOrder.class);
        util.exportExcel(response, list, "法币订单数据");
    }

    /**
     * 获取法币订单详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tOtcOrderService.selectTOtcOrderById(id));
    }

    /**
     * 新增法币订单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrder:add')")
    @Log(title = "法币订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcOrder tOtcOrder)
    {
        tOtcOrder.setPayType("BANKCARD");
        tOtcOrder.setStatus("NORMAL");
        return tOtcOrderService.insertTOtcOrder(tOtcOrder);
    }

    /**
     * 修改法币订单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrder:edit')")
    @Log(title = "法币订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcOrder tOtcOrder)
    {
        return tOtcOrderService.updateTOtcOrder(tOtcOrder);
    }

    /**
     * 删除法币订单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrder:remove')")
    @Log(title = "法币订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tOtcOrderService.deleteTOtcOrderByIds(ids));
    }

    /**
     * 撤销
     */
    @PreAuthorize("@ss.hasPermi('system:revoke:remove')")
    @Log(title = "法币订单", businessType = BusinessType.OTHER)
    @PostMapping("/revoke/{id}")
    public AjaxResult revoke(@PathVariable String id)
    {
        return tOtcOrderService.revoke(id);
    }
    @Autowired
    private IStoreService iStoreService;
    @Autowired
    private ITMemberCurrencyConfigService itMemberCurrencyConfigService;

    @GetMapping("/getStoreList")
    public AjaxResult getStoreList(){
        List<Store> list = iStoreService.selectTMemberList(new Store());
        return AjaxResult.success(list);
    }
    @GetMapping("/getFbList")
    public AjaxResult getFbList(){
        List<TMemberCurrencyConfig> list = itMemberCurrencyConfigService.selectTMemberCurrencyConfigList(new TMemberCurrencyConfig());
        return AjaxResult.success(list);
    }
}
