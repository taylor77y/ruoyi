package com.ruoyi.web.controller.finance;

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
import com.ruoyi.system.domain.TUserBlanceCollect;
import com.ruoyi.system.service.ITUserBlanceCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户财务分析Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/userBlanceCollect")
public class TUserBlanceCollectController extends BaseController
{
    @Autowired
    private ITUserBlanceCollectService tUserBlanceCollectService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询用户财务分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUserBlanceCollect tUserBlanceCollect)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tUserBlanceCollect.setSysIds(getSysIds(list));
        }
        startPage();
        List<TUserBlanceCollect> list = tUserBlanceCollectService.selectTUserBlanceCollectList(tUserBlanceCollect);
        return getDataTable(list);
    }

    /**
     * 导出用户财务分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:export')")
    @Log(title = "用户财务分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUserBlanceCollect tUserBlanceCollect)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tUserBlanceCollect.setSysIds(getSysIds(list));
        }
        List<TUserBlanceCollect> list = tUserBlanceCollectService.selectTUserBlanceCollectList(tUserBlanceCollect);
        ExcelUtil<TUserBlanceCollect> util = new ExcelUtil<TUserBlanceCollect>(TUserBlanceCollect.class);
        util.exportExcel(response, list, "用户财务分析数据");
    }

    /**
     * 获取用户财务分析详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tUserBlanceCollectService.selectTUserBlanceCollectById(id));
    }

    /**
     * 新增用户财务分析
     */
    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:add')")
    @Log(title = "用户财务分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUserBlanceCollect tUserBlanceCollect)
    {
        return toAjax(tUserBlanceCollectService.insertTUserBlanceCollect(tUserBlanceCollect));
    }

    /**
     * 修改用户财务分析
     */
    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:edit')")
    @Log(title = "用户财务分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUserBlanceCollect tUserBlanceCollect)
    {
        return toAjax(tUserBlanceCollectService.updateTUserBlanceCollect(tUserBlanceCollect));
    }

    /**
     * 删除用户财务分析
     */
    @PreAuthorize("@ss.hasPermi('system:userBlanceCollect:remove')")
    @Log(title = "用户财务分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUserBlanceCollectService.deleteTUserBlanceCollectByIds(ids));
    }
}
