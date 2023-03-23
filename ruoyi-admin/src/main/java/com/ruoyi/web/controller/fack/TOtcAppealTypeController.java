package com.ruoyi.web.controller.fack;

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
import com.ruoyi.system.domain.TOtcAppealType;
import com.ruoyi.system.service.ITOtcAppealTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * OTC申诉类型Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/otcAppealType")
public class TOtcAppealTypeController extends BaseController
{
    @Autowired
    private ITOtcAppealTypeService tOtcAppealTypeService;

    /**
     * 查询OTC申诉类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcAppealType:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOtcAppealType tOtcAppealType)
    {
        startPage();
        List<TOtcAppealType> list = tOtcAppealTypeService.selectTOtcAppealTypeList(tOtcAppealType);
        return getDataTable(list);
    }

    /**
     * 导出OTC申诉类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:otcAppealType:export')")
    @Log(title = "OTC申诉类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOtcAppealType tOtcAppealType)
    {
        List<TOtcAppealType> list = tOtcAppealTypeService.selectTOtcAppealTypeList(tOtcAppealType);
        ExcelUtil<TOtcAppealType> util = new ExcelUtil<TOtcAppealType>(TOtcAppealType.class);
        util.exportExcel(response, list, "OTC申诉类型数据");
    }

    /**
     * 获取OTC申诉类型详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:otcAppealType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tOtcAppealTypeService.selectTOtcAppealTypeById(id));
    }

    /**
     * 新增OTC申诉类型
     */
    @PreAuthorize("@ss.hasPermi('system:otcAppealType:add')")
    @Log(title = "OTC申诉类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOtcAppealType tOtcAppealType)
    {
        return toAjax(tOtcAppealTypeService.insertTOtcAppealType(tOtcAppealType));
    }

    /**
     * 修改OTC申诉类型
     */
    @PreAuthorize("@ss.hasPermi('system:otcAppealType:edit')")
    @Log(title = "OTC申诉类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOtcAppealType tOtcAppealType)
    {
        return toAjax(tOtcAppealTypeService.updateTOtcAppealType(tOtcAppealType));
    }

    /**
     * 删除OTC申诉类型
     */
    @PreAuthorize("@ss.hasPermi('system:otcAppealType:remove')")
    @Log(title = "OTC申诉类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tOtcAppealTypeService.deleteTOtcAppealTypeByIds(ids));
    }
}
