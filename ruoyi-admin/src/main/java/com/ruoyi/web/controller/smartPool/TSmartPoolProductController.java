package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.system.domain.TSmartPoolProduct;
import com.ruoyi.system.service.ITSmartPoolProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/system/smartPool/product")
public class TSmartPoolProductController extends BaseController
{
    @Autowired
    private ITSmartPoolProductService tSmartPoolProductService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSmartPoolProduct tSmartPoolProduct,String name)
    {
        startPage();
        if(StringUtils.isNoneBlank(name)){
            tSmartPoolProduct.setZhName(name);
            tSmartPoolProduct.setZhTwName(name);
            tSmartPoolProduct.setEnName(name);
            tSmartPoolProduct.setJaName(name);
            tSmartPoolProduct.setKoName(name);
        }
        List<TSmartPoolProduct> list = tSmartPoolProductService.selectTSmartPoolProductList(tSmartPoolProduct);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSmartPoolProduct tSmartPoolProduct)
    {
        List<TSmartPoolProduct> list = tSmartPoolProductService.selectTSmartPoolProductList(tSmartPoolProduct);
        ExcelUtil<TSmartPoolProduct> util = new ExcelUtil<TSmartPoolProduct>(TSmartPoolProduct.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tSmartPoolProductService.selectTSmartPoolProductById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSmartPoolProduct tSmartPoolProduct)
    {
        return toAjax(tSmartPoolProductService.insertTSmartPoolProduct(tSmartPoolProduct));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSmartPoolProduct tSmartPoolProduct)
    {
        return toAjax(tSmartPoolProductService.updateTSmartPoolProduct(tSmartPoolProduct));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:smartPoolProduct:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSmartPoolProductService.deleteTSmartPoolProductByIds(ids));
    }
}
