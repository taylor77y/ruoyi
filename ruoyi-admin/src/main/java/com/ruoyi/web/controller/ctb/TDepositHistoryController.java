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
import com.ruoyi.system.domain.TDepositHistory;
import com.ruoyi.system.service.ITDepositHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充币记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/depositHistory")
public class TDepositHistoryController extends BaseController
{
    @Autowired
    private ITDepositHistoryService tDepositHistoryService;

    /**
     * 查询充币记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:depositHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDepositHistory tDepositHistory)
    {
        startPage();
        List<TDepositHistory> list = tDepositHistoryService.selectTDepositHistoryList(tDepositHistory);
        return getDataTable(list);
    }

    /**
     * 导出充币记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:depositHistory:export')")
    @Log(title = "充币记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDepositHistory tDepositHistory)
    {
        List<TDepositHistory> list = tDepositHistoryService.selectTDepositHistoryList(tDepositHistory);
        ExcelUtil<TDepositHistory> util = new ExcelUtil<TDepositHistory>(TDepositHistory.class);
        util.exportExcel(response, list, "充币记录数据");
    }

    /**
     * 获取充币记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:depositHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tDepositHistoryService.selectTDepositHistoryById(id));
    }

    /**
     * 新增充币记录
     */
    @PreAuthorize("@ss.hasPermi('system:depositHistory:add')")
    @Log(title = "充币记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDepositHistory tDepositHistory)
    {
        tDepositHistory.setId(UUID.randomUUID().toString());
        return toAjax(tDepositHistoryService.insertTDepositHistory(tDepositHistory));
    }

    /**
     * 修改充币记录
     */
    @PreAuthorize("@ss.hasPermi('system:depositHistory:edit')")
    @Log(title = "充币记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDepositHistory tDepositHistory)
    {
        return toAjax(tDepositHistoryService.updateTDepositHistory(tDepositHistory));
    }

    /**
     * 删除充币记录
     */
    @PreAuthorize("@ss.hasPermi('system:depositHistory:remove')")
    @Log(title = "充币记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tDepositHistoryService.deleteTDepositHistoryByIds(ids));
    }
}
