package com.ruoyi.web.controller.bbq;

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
import com.ruoyi.system.domain.TEntrustHistory;
import com.ruoyi.system.service.ITEntrustHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史委托记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/entrustHistory")
public class TEntrustHistoryController extends BaseController
{
    @Autowired
    private ITEntrustHistoryService tEntrustHistoryService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询历史委托记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:entrustHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEntrustHistory tEntrustHistory)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tEntrustHistory.setSysIds(getSysIds(list));
        }
        startPage();
        List<TEntrustHistory> list = tEntrustHistoryService.selectTEntrustHistoryList(tEntrustHistory);
        return getDataTable(list);
    }

    /**
     * 导出历史委托记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:entrustHistory:export')")
    @Log(title = "历史委托记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEntrustHistory tEntrustHistory)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tEntrustHistory.setSysIds(getSysIds(list));
        }
        List<TEntrustHistory> list = tEntrustHistoryService.selectTEntrustHistoryList(tEntrustHistory);
        ExcelUtil<TEntrustHistory> util = new ExcelUtil<TEntrustHistory>(TEntrustHistory.class);
        util.exportExcel(response, list, "历史委托记录数据");
    }

    /**
     * 获取历史委托记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:entrustHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tEntrustHistoryService.selectTEntrustHistoryById(id));
    }

    /**
     * 新增历史委托记录
     */
    @PreAuthorize("@ss.hasPermi('system:entrustHistory:add')")
    @Log(title = "历史委托记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEntrustHistory tEntrustHistory)
    {
        return toAjax(tEntrustHistoryService.insertTEntrustHistory(tEntrustHistory));
    }

    /**
     * 修改历史委托记录
     */
    @PreAuthorize("@ss.hasPermi('system:entrustHistory:edit')")
    @Log(title = "历史委托记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEntrustHistory tEntrustHistory)
    {
        return toAjax(tEntrustHistoryService.updateTEntrustHistory(tEntrustHistory));
    }

    /**
     * 删除历史委托记录
     */
    @PreAuthorize("@ss.hasPermi('system:entrustHistory:remove')")
    @Log(title = "历史委托记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tEntrustHistoryService.deleteTEntrustHistoryByIds(ids));
    }
}
