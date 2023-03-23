package com.ruoyi.web.controller.ctb;

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
import com.ruoyi.system.domain.TWalletPool;
import com.ruoyi.system.service.ITWalletPoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充币地址Controller
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@RestController
@RequestMapping("/system/walletPool")
public class TWalletPoolController extends BaseController
{
    @Autowired
    private ITWalletPoolService tWalletPoolService;

    /**
     * 查询充币地址列表
     */
    @PreAuthorize("@ss.hasPermi('system:walletPool:list')")
    @GetMapping("/list")
    public TableDataInfo list(TWalletPool tWalletPool)
    {
        startPage();
        List<TWalletPool> list = tWalletPoolService.selectTWalletPoolList(tWalletPool);
        return getDataTable(list);
    }

    /**
     * 导出充币地址列表
     */
    @PreAuthorize("@ss.hasPermi('system:walletPool:export')")
    @Log(title = "充币地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWalletPool tWalletPool)
    {
        List<TWalletPool> list = tWalletPoolService.selectTWalletPoolList(tWalletPool);
        ExcelUtil<TWalletPool> util = new ExcelUtil<TWalletPool>(TWalletPool.class);
        util.exportExcel(response, list, "充币地址数据");
    }

    /**
     * 获取充币地址详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:walletPool:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tWalletPoolService.selectTWalletPoolById(id));
    }

    /**
     * 新增充币地址
     */
    @PreAuthorize("@ss.hasPermi('system:walletPool:add')")
    @Log(title = "充币地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWalletPool tWalletPool)
    {
        return toAjax(tWalletPoolService.insertTWalletPool(tWalletPool));
    }

    /**
     * 修改充币地址
     */
    @PreAuthorize("@ss.hasPermi('system:walletPool:edit')")
    @Log(title = "充币地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWalletPool tWalletPool)
    {
        return toAjax(tWalletPoolService.updateTWalletPool(tWalletPool));
    }

    /**
     * 删除充币地址
     */
    @PreAuthorize("@ss.hasPermi('system:walletPool:remove')")
    @Log(title = "充币地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tWalletPoolService.deleteTWalletPoolByIds(ids));
    }
}
