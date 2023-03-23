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
import com.ruoyi.system.domain.TMemberRecharge;
import com.ruoyi.system.service.ITMemberRechargeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员充值Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/memberRecharge")
public class TMemberRechargeController extends BaseController
{
    @Autowired
    private ITMemberRechargeService tMemberRechargeService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询会员充值列表
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMemberRecharge tMemberRecharge)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tMemberRecharge.setSysIds(getSysIds(list));
        }
        startPage();
        List<TMemberRecharge> list = tMemberRechargeService.selectTMemberRechargeList(tMemberRecharge);
        return getDataTable(list);
    }

    /**
     * 导出会员充值列表
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:export')")
    @Log(title = "会员充值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMemberRecharge tMemberRecharge)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tMemberRecharge.setSysIds(getSysIds(list));
        }
        List<TMemberRecharge> list = tMemberRechargeService.selectTMemberRechargeList(tMemberRecharge);
        ExcelUtil<TMemberRecharge> util = new ExcelUtil<TMemberRecharge>(TMemberRecharge.class);
        util.exportExcel(response, list, "会员充值数据");
    }

    /**
     * 获取会员充值详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:memberRecharge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tMemberRechargeService.selectTMemberRechargeById(id));
    }

    /**
     * 新增会员充值
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:add')")
    @Log(title = "会员充值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMemberRecharge tMemberRecharge)
    {
        return toAjax(tMemberRechargeService.insertTMemberRecharge(tMemberRecharge));
    }

    /**
     * 修改会员充值
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:edit')")
    @Log(title = "会员充值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMemberRecharge tMemberRecharge)
    {
        return toAjax(tMemberRechargeService.updateTMemberRecharge(tMemberRecharge));
    }

    /**
     * 删除会员充值
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:remove')")
    @Log(title = "会员充值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMemberRechargeService.deleteTMemberRechargeByIds(ids));
    }

    /**
     * 通过
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:agree')")
    @Log(title = "会员充值", businessType = BusinessType.OTHER)
    @PostMapping("/agree/{id}")
    public AjaxResult agree(@PathVariable Long id){
        return tMemberRechargeService.rechargeAudit(1,id);
    }

    /**
     * 驳回
     */
    @PreAuthorize("@ss.hasPermi('system:memberRecharge:reject')")
    @Log(title = "会员充值", businessType = BusinessType.OTHER)
    @PostMapping("/reject/{id}")
    public AjaxResult reject(@PathVariable Long id){
        return tMemberRechargeService.rechargeAudit(2,id);
    }
}
