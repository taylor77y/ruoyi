package com.ruoyi.web.controller.kline;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.kline.BatchData;
import com.ruoyi.system.domain.kline.TStagePrice;
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
import com.ruoyi.system.service.ITStagePriceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自发币时间阶段价格Controller
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@RestController
@RequestMapping("/system/stagePrice")
public class TStagePriceController extends BaseController
{
    @Autowired
    private ITStagePriceService tStagePriceService;

    /**
     * 查询自发币时间阶段价格列表
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:list')")
    @GetMapping("/list")
    public TableDataInfo list(TStagePrice tStagePrice)
    {
        startPage();
        List<TStagePrice> list = tStagePriceService.selectTStagePriceList(tStagePrice);
        return getDataTable(list);
    }

    /**
     * 导出自发币时间阶段价格列表
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:export')")
    @Log(title = "自发币时间阶段价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TStagePrice tStagePrice)
    {
        List<TStagePrice> list = tStagePriceService.selectTStagePriceList(tStagePrice);
        ExcelUtil<TStagePrice> util = new ExcelUtil<TStagePrice>(TStagePrice.class);
        util.exportExcel(response, list, "自发币时间阶段价格数据");
    }

    /**
     * 获取自发币时间阶段价格详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tStagePriceService.selectTStagePriceById(id));
    }

    /**
     * 新增自发币时间阶段价格
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:add')")
    @Log(title = "自发币时间阶段价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TStagePrice tStagePrice)
    {
        return toAjax(tStagePriceService.insertTStagePrice(tStagePrice));
    }

    /**
     * 修改自发币时间阶段价格
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:edit')")
    @Log(title = "自发币时间阶段价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TStagePrice tStagePrice)
    {
        return toAjax(tStagePriceService.updateTStagePrice(tStagePrice));
    }

    /**
     * 删除自发币时间阶段价格
     */
    @PreAuthorize("@ss.hasPermi('system:stagePrice:remove')")
    @Log(title = "自发币时间阶段价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tStagePriceService.deleteTStagePriceByIds(ids));
    }

    /**
     * 批量修改
     */
    @PreAuthorize("@ss.hasPermi('system:klineData:batch')")
    @Log(title = "自发币时间阶段价格", businessType = BusinessType.UPDATE)
    @PostMapping("/batch")
    public AjaxResult batch(@RequestBody BatchData batchData){
        if (batchData.getMode() == 1){
            return tStagePriceService.batch(batchData);
        }
        return tStagePriceService.batch2(batchData);
    }
}
