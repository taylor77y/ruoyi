package com.ruoyi.web.controller.kline;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TKlineData;
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
import com.ruoyi.system.service.ITKlineDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自发币K线数据Controller
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@RestController
@RequestMapping("/system/klineData")
public class TKlineDataController extends BaseController
{
    @Autowired
    private ITKlineDataService tKlineDataService;

    /**
     * 查询自发币K线数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:list')")
    @GetMapping("/list")
    public TableDataInfo list(TKlineData tKlineData)
    {
        startPage();
        List<TKlineData> list = tKlineDataService.selectTKlineDataList(tKlineData);
        return getDataTable(list);
    }

    /**
     * 导出自发币K线数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:export')")
    @Log(title = "自发币K线数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TKlineData tKlineData)
    {
        List<TKlineData> list = tKlineDataService.selectTKlineDataList(tKlineData);
        ExcelUtil<TKlineData> util = new ExcelUtil<TKlineData>(TKlineData.class);
        util.exportExcel(response, list, "自发币K线数据数据");
    }

    /**
     * 获取自发币K线数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tKlineDataService.selectTKlineDataById(id));
    }

    /**
     * 新增自发币K线数据
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:add')")
    @Log(title = "自发币K线数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TKlineData tKlineData)
    {
        return toAjax(tKlineDataService.insertTKlineData(tKlineData));
    }

    /**
     * 修改自发币K线数据
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:edit')")
    @Log(title = "自发币K线数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TKlineData tKlineData)
    {
        return toAjax(tKlineDataService.updateTKlineData(tKlineData));
    }

    /**
     * 删除自发币K线数据
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:remove')")
    @Log(title = "自发币K线数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tKlineDataService.deleteTKlineDataByIds(ids));
    }

    /**
     * 批量修改
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:batch')")
    @Log(title = "自发币K线数据", businessType = BusinessType.UPDATE)
    @PostMapping("/batch")
    public AjaxResult batch(@RequestBody BatchData batchData){
        return tKlineDataService.batch(batchData);
    }
}
