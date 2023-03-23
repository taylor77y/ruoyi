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
import com.ruoyi.system.domain.TBibiDayRecord;
import com.ruoyi.system.service.ITBibiDayRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币种交易量Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/bibiDayRecord")
public class TBibiDayRecordController extends BaseController
{
    @Autowired
    private ITBibiDayRecordService tBibiDayRecordService;

    /**
     * 查询币种交易量列表
     */
    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBibiDayRecord tBibiDayRecord)
    {
        startPage();
        List<TBibiDayRecord> list = tBibiDayRecordService.selectTBibiDayRecordList(tBibiDayRecord);
        return getDataTable(list);
    }

    /**
     * 导出币种交易量列表
     */
    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:export')")
    @Log(title = "币种交易量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBibiDayRecord tBibiDayRecord)
    {
        List<TBibiDayRecord> list = tBibiDayRecordService.selectTBibiDayRecordList(tBibiDayRecord);
        ExcelUtil<TBibiDayRecord> util = new ExcelUtil<TBibiDayRecord>(TBibiDayRecord.class);
        util.exportExcel(response, list, "币种交易量数据");
    }

    /**
     * 获取币种交易量详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tBibiDayRecordService.selectTBibiDayRecordById(id));
    }

    /**
     * 新增币种交易量
     */
    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:add')")
    @Log(title = "币种交易量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBibiDayRecord tBibiDayRecord)
    {
        return toAjax(tBibiDayRecordService.insertTBibiDayRecord(tBibiDayRecord));
    }

    /**
     * 修改币种交易量
     */
    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:edit')")
    @Log(title = "币种交易量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBibiDayRecord tBibiDayRecord)
    {
        return toAjax(tBibiDayRecordService.updateTBibiDayRecord(tBibiDayRecord));
    }

    /**
     * 删除币种交易量
     */
    @PreAuthorize("@ss.hasPermi('system:bibiDayRecord:remove')")
    @Log(title = "币种交易量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBibiDayRecordService.deleteTBibiDayRecordByIds(ids));
    }
}
