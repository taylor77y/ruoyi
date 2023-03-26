package com.ruoyi.web.controller.fund;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TFundProduct;
import com.ruoyi.system.service.ITFundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/system/fund/product")
public class TFundProductController extends BaseController {

    @Autowired
    private ITFundProductService tFundProductService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFundProduct tFundProduct,String name)
    {
        startPage();
        if(StringUtils.isNoneBlank(name)){
            tFundProduct.setZhName(name);
            tFundProduct.setZhTwName(name);
            tFundProduct.setEnName(name);
            tFundProduct.setJaName(name);
            tFundProduct.setKoName(name);
        }
        List<TFundProduct> list = tFundProductService.selectTFundProductList(tFundProduct);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TFundProduct tFundProduct)
    {
        List<TFundProduct> list = tFundProductService.selectTFundProductList(tFundProduct);
        ExcelUtil<TFundProduct> util = new ExcelUtil<TFundProduct>(TFundProduct.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tFundProductService.selectTFundProductById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFundProduct tFundProduct)
    {
        return toAjax(tFundProductService.insertTFundProduct(tFundProduct));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFundProduct tFundProduct)
    {
        return toAjax(tFundProductService.updateTFundProduct(tFundProduct));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:fundProduct:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tFundProductService.deleteTFundProductByIds(ids));
    }
}
