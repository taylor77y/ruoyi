package com.ruoyi.web.controller.contract;

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
import com.ruoyi.system.domain.TContractMul;
import com.ruoyi.system.service.ITContractMulService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合约交易对Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/contractMul")
public class TContractMulController extends BaseController
{
    @Autowired
    private ITContractMulService tContractMulService;

    /**
     * 查询合约交易对列表
     */
    @PreAuthorize("@ss.hasPermi('system:contractMul:list')")
    @GetMapping("/list")
    public TableDataInfo list(TContractMul tContractMul)
    {
        startPage();
        List<TContractMul> list = tContractMulService.selectTContractMulList(tContractMul);
        return getDataTable(list);
    }

    /**
     * 导出合约交易对列表
     */
    @PreAuthorize("@ss.hasPermi('system:contractMul:export')")
    @Log(title = "合约交易对", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TContractMul tContractMul)
    {
        List<TContractMul> list = tContractMulService.selectTContractMulList(tContractMul);
        ExcelUtil<TContractMul> util = new ExcelUtil<TContractMul>(TContractMul.class);
        util.exportExcel(response, list, "合约交易对数据");
    }

    /**
     * 获取合约交易对详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:contractMul:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tContractMulService.selectTContractMulById(id));
    }

    /**
     * 新增合约交易对
     */
    @PreAuthorize("@ss.hasPermi('system:contractMul:add')")
    @Log(title = "合约交易对", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TContractMul tContractMul)
    {
        tContractMul.setId(UUID.randomUUID().toString());
        return toAjax(tContractMulService.insertTContractMul(tContractMul));
    }

    /**
     * 修改合约交易对
     */
    @PreAuthorize("@ss.hasPermi('system:contractMul:edit')")
    @Log(title = "合约交易对", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TContractMul tContractMul)
    {
        return toAjax(tContractMulService.updateTContractMul(tContractMul));
    }

    /**
     * 删除合约交易对
     */
    @PreAuthorize("@ss.hasPermi('system:contractMul:remove')")
    @Log(title = "合约交易对", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tContractMulService.deleteTContractMulByIds(ids));
    }
}
