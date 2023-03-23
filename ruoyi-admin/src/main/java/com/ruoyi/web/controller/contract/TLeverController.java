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
import com.ruoyi.system.domain.TLever;
import com.ruoyi.system.service.ITLeverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合约杠杆Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/lever")
public class TLeverController extends BaseController
{
    @Autowired
    private ITLeverService tLeverService;

    /**
     * 查询合约杠杆列表
     */
    @PreAuthorize("@ss.hasPermi('system:lever:list')")
    @GetMapping("/list")
    public TableDataInfo list(TLever tLever)
    {
        startPage();
        List<TLever> list = tLeverService.selectTLeverList(tLever);
        return getDataTable(list);
    }

    /**
     * 导出合约杠杆列表
     */
    @PreAuthorize("@ss.hasPermi('system:lever:export')")
    @Log(title = "合约杠杆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TLever tLever)
    {
        List<TLever> list = tLeverService.selectTLeverList(tLever);
        ExcelUtil<TLever> util = new ExcelUtil<TLever>(TLever.class);
        util.exportExcel(response, list, "合约杠杆数据");
    }

    /**
     * 获取合约杠杆详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:lever:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tLeverService.selectTLeverById(id));
    }

    /**
     * 新增合约杠杆
     */
    @PreAuthorize("@ss.hasPermi('system:lever:add')")
    @Log(title = "合约杠杆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TLever tLever)
    {
        tLever.setId(UUID.randomUUID().toString());
        return toAjax(tLeverService.insertTLever(tLever));
    }

    /**
     * 修改合约杠杆
     */
    @PreAuthorize("@ss.hasPermi('system:lever:edit')")
    @Log(title = "合约杠杆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TLever tLever)
    {
        return toAjax(tLeverService.updateTLever(tLever));
    }

    /**
     * 删除合约杠杆
     */
    @PreAuthorize("@ss.hasPermi('system:lever:remove')")
    @Log(title = "合约杠杆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tLeverService.deleteTLeverByIds(ids));
    }
}
