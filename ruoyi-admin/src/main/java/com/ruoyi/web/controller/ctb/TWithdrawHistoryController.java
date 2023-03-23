package com.ruoyi.web.controller.ctb;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TWithdrawHistory;
import com.ruoyi.system.service.ITWithdrawHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提币记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/withdrawHistory")
public class TWithdrawHistoryController extends BaseController
{
    @Autowired
    private ITWithdrawHistoryService tWithdrawHistoryService;

    /**
     * 查询提币记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(TWithdrawHistory tWithdrawHistory)
    {
        startPage();
        List<TWithdrawHistory> list = tWithdrawHistoryService.selectTWithdrawHistoryList(tWithdrawHistory);
        return getDataTable(list);
    }

    /**
     * 导出提币记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:export')")
    @Log(title = "提币记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWithdrawHistory tWithdrawHistory)
    {
        List<TWithdrawHistory> list = tWithdrawHistoryService.selectTWithdrawHistoryList(tWithdrawHistory);
        ExcelUtil<TWithdrawHistory> util = new ExcelUtil<TWithdrawHistory>(TWithdrawHistory.class);
        util.exportExcel(response, list, "提币记录数据");
    }

    /**
     * 获取提币记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tWithdrawHistoryService.selectTWithdrawHistoryById(id));
    }

    /**
     * 新增提币记录
     */
    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:add')")
    @Log(title = "提币记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWithdrawHistory tWithdrawHistory)
    {
        tWithdrawHistory.setId(UUID.randomUUID().toString());
        return toAjax(tWithdrawHistoryService.insertTWithdrawHistory(tWithdrawHistory));
    }

    /**
     * 修改提币记录
     */
    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:edit')")
    @Log(title = "提币记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWithdrawHistory tWithdrawHistory)
    {
        return toAjax(tWithdrawHistoryService.updateTWithdrawHistory(tWithdrawHistory));
    }

    /**
     * 删除提币记录
     */
    @PreAuthorize("@ss.hasPermi('system:withdrawHistory:remove')")
    @Log(title = "提币记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tWithdrawHistoryService.deleteTWithdrawHistoryByIds(ids));
    }
}
