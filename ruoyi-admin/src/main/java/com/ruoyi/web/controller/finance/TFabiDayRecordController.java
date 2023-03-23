package com.ruoyi.web.controller.finance;

import java.util.List;
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
import com.ruoyi.system.domain.TFabiDayRecord;
import com.ruoyi.system.service.ITFabiDayRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法币交易统计Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/fabiDayRecord")
public class TFabiDayRecordController extends BaseController
{
    @Autowired
    private ITFabiDayRecordService tFabiDayRecordService;

    /**
     * 查询法币交易统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFabiDayRecord tFabiDayRecord)
    {
        startPage();
        List<TFabiDayRecord> list = tFabiDayRecordService.selectTFabiDayRecordList(tFabiDayRecord);
        return getDataTable(list);
    }

    /**
     * 导出法币交易统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:export')")
    @Log(title = "法币交易统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TFabiDayRecord tFabiDayRecord)
    {
        List<TFabiDayRecord> list = tFabiDayRecordService.selectTFabiDayRecordList(tFabiDayRecord);
        ExcelUtil<TFabiDayRecord> util = new ExcelUtil<TFabiDayRecord>(TFabiDayRecord.class);
        util.exportExcel(response, list, "法币交易统计数据");
    }

    /**
     * 获取法币交易统计详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tFabiDayRecordService.selectTFabiDayRecordById(id));
    }

    /**
     * 新增法币交易统计
     */
    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:add')")
    @Log(title = "法币交易统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFabiDayRecord tFabiDayRecord)
    {
        return toAjax(tFabiDayRecordService.insertTFabiDayRecord(tFabiDayRecord));
    }

    /**
     * 修改法币交易统计
     */
    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:edit')")
    @Log(title = "法币交易统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFabiDayRecord tFabiDayRecord)
    {
        return toAjax(tFabiDayRecordService.updateTFabiDayRecord(tFabiDayRecord));
    }

    /**
     * 删除法币交易统计
     */
    @PreAuthorize("@ss.hasPermi('system:fabiDayRecord:remove')")
    @Log(title = "法币交易统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tFabiDayRecordService.deleteTFabiDayRecordByIds(ids));
    }
}
