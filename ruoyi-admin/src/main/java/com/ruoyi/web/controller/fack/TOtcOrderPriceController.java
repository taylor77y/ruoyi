package com.ruoyi.web.controller.fack;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.util.MessageUtils;
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
import com.ruoyi.system.domain.TOtcOrderPrice;
import com.ruoyi.system.service.ITOtcOrderPriceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 下单Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/otcOrderPrice")
public class TOtcOrderPriceController extends BaseController
{
    @Autowired
    private ITOtcOrderPriceService tOtcOrderPriceService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询下单列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcOrderPrice tOtcOrderPrice)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrderPrice.setSysIds(getSysIds(list));
        }
        startPage();
        List<TOtcOrderPrice> list = tOtcOrderPriceService.selectTOtcOrderPriceList(tOtcOrderPrice);
        return getDataTable(list);
    }

    /**
     * 导出下单列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:export')")
    @Log(title = "下单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcOrderPrice tOtcOrderPrice)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tOtcOrderPrice.setSysIds(getSysIds(list));
        }
        List<TOtcOrderPrice> list = tOtcOrderPriceService.selectTOtcOrderPriceList(tOtcOrderPrice);
        ExcelUtil<TOtcOrderPrice> util = new ExcelUtil<TOtcOrderPrice>(TOtcOrderPrice.class);
        util.exportExcel(response, list, "下单数据");
    }

    /**
     * 获取下单详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id,String sender)
    {
        TOtcOrderPrice data = tOtcOrderPriceService.selectTOtcOrderPriceById(id);
        return AjaxResult.success(data).put("hash", MessageUtils.hash(data.getStoreId(),data.getUserId()));
    }

    /**
     * 新增下单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:add')")
    @Log(title = "下单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcOrderPrice tOtcOrderPrice)
    {
        return toAjax(tOtcOrderPriceService.insertTOtcOrderPrice(tOtcOrderPrice));
    }

    /**
     * 修改下单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:edit')")
    @Log(title = "下单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcOrderPrice tOtcOrderPrice)
    {
        return toAjax(tOtcOrderPriceService.updateTOtcOrderPrice(tOtcOrderPrice));
    }

    /**
     * 删除下单
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:remove')")
    @Log(title = "下单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tOtcOrderPriceService.deleteTOtcOrderPriceByIds(ids));
    }
    /**
     * 放行
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:release')")
    @Log(title = "下单", businessType = BusinessType.OTHER)
    @PostMapping("/release/{id}")
    public AjaxResult release(@PathVariable String id){
        return tOtcOrderPriceService.release(id,1);
    }
    /**
     * 确定
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:sure')")
    @Log(title = "下单", businessType = BusinessType.OTHER)
    @PostMapping("/sure/{id}")
    public AjaxResult sureOrder(@PathVariable String id){
        return tOtcOrderPriceService.release(id,2);
    }
    /**
     * 取消
     */
    @PreAuthorize("@ss.hasPermi('system:otcOrderPrice:cancel')")
    @Log(title = "下单", businessType = BusinessType.OTHER)
    @PostMapping("/cancel/{id}")
    public AjaxResult cancelOrder(@PathVariable String id){
        return tOtcOrderPriceService.cancelOrder(id);
    }
}
