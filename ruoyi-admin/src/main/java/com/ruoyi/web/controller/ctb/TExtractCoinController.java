package com.ruoyi.web.controller.ctb;

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
import com.ruoyi.system.domain.TExtractCoin;
import com.ruoyi.system.service.ITExtractCoinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提币审核Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/extractCoin")
public class TExtractCoinController extends BaseController
{
    @Autowired
    private ITExtractCoinService tExtractCoinService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询提币审核列表
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:list')")
    @GetMapping("/list")
    public TableDataInfo list(TExtractCoin tExtractCoin)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tExtractCoin.setSysIds(getSysIds(list));
        }
        startPage();
        List<TExtractCoin> list = tExtractCoinService.selectTExtractCoinList(tExtractCoin);
        return getDataTable(list);
    }

    /**
     * 导出提币审核列表
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:export')")
    @Log(title = "提币审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TExtractCoin tExtractCoin)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tExtractCoin.setSysIds(getSysIds(list));
        }
        List<TExtractCoin> list = tExtractCoinService.selectTExtractCoinList(tExtractCoin);
        ExcelUtil<TExtractCoin> util = new ExcelUtil<TExtractCoin>(TExtractCoin.class);
        util.exportExcel(response, list, "提币审核数据");
    }

    /**
     * 获取提币审核详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:extractCoin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tExtractCoinService.selectTExtractCoinById(id));
    }

    /**
     * 新增提币审核
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:add')")
    @Log(title = "提币审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TExtractCoin tExtractCoin)
    {
        return toAjax(tExtractCoinService.insertTExtractCoin(tExtractCoin));
    }

    /**
     * 修改提币审核
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:edit')")
    @Log(title = "提币审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TExtractCoin tExtractCoin)
    {
        return toAjax(tExtractCoinService.updateTExtractCoin(tExtractCoin));
    }

    /**
     * 删除提币审核
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:remove')")
    @Log(title = "提币审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tExtractCoinService.deleteTExtractCoinByIds(ids));
    }

    /**
     * 通过
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:agree')")
    @Log(title = "提币审核", businessType = BusinessType.OTHER)
    @PostMapping("/agree/{id}")
    public AjaxResult agree(@PathVariable String id){
        return tExtractCoinService.withdrawAudit(1,id);
    }

    /**
     * 驳回
     */
    @PreAuthorize("@ss.hasPermi('system:extractCoin:reject')")
    @Log(title = "提币审核", businessType = BusinessType.OTHER)
    @PostMapping("/reject/{id}")
    public AjaxResult reject(@PathVariable String id){
        return tExtractCoinService.withdrawAudit(2,id);
    }
}
