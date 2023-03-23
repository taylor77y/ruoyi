package com.ruoyi.web.controller.platConfig;

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
import com.ruoyi.system.domain.TNotice;
import com.ruoyi.system.service.ITNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币币-公告Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/mNotice")
public class TNoticeController extends BaseController
{
    @Autowired
    private ITNoticeService tNoticeService;

    /**
     * 查询币币-公告列表
     */
    @PreAuthorize("@ss.hasPermi('system:mNotice:list')")
    @GetMapping("/list")
    public TableDataInfo list(TNotice tNotice)
    {
        startPage();
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        return getDataTable(list);
    }

    /**
     * 导出币币-公告列表
     */
    @PreAuthorize("@ss.hasPermi('system:mNotice:export')")
    @Log(title = "币币-公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TNotice tNotice)
    {
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        ExcelUtil<TNotice> util = new ExcelUtil<TNotice>(TNotice.class);
        util.exportExcel(response, list, "币币-公告数据");
    }

    /**
     * 获取币币-公告详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:mNotice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tNoticeService.selectTNoticeById(id));
    }

    /**
     * 新增币币-公告
     */
    @PreAuthorize("@ss.hasPermi('system:mNotice:add')")
    @Log(title = "币币-公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TNotice tNotice)
    {
        tNotice.setId(UUID.randomUUID().toString());
        return toAjax(tNoticeService.insertTNotice(tNotice));
    }

    /**
     * 修改币币-公告
     */
    @PreAuthorize("@ss.hasPermi('system:mNotice:edit')")
    @Log(title = "币币-公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TNotice tNotice)
    {
        return toAjax(tNoticeService.updateTNotice(tNotice));
    }

    /**
     * 删除币币-公告
     */
    @PreAuthorize("@ss.hasPermi('system:mNotice:remove')")
    @Log(title = "币币-公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tNoticeService.deleteTNoticeByIds(ids));
    }
}
