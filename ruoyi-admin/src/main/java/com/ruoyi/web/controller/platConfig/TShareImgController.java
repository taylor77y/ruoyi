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
import com.ruoyi.system.domain.TShareImg;
import com.ruoyi.system.service.ITShareImgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分享图片Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/shareImg")
public class TShareImgController extends BaseController
{
    @Autowired
    private ITShareImgService tShareImgService;

    /**
     * 查询分享图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:shareImg:list')")
    @GetMapping("/list")
    public TableDataInfo list(TShareImg tShareImg)
    {
        startPage();
        List<TShareImg> list = tShareImgService.selectTShareImgList(tShareImg);
        return getDataTable(list);
    }

    /**
     * 导出分享图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:shareImg:export')")
    @Log(title = "分享图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TShareImg tShareImg)
    {
        List<TShareImg> list = tShareImgService.selectTShareImgList(tShareImg);
        ExcelUtil<TShareImg> util = new ExcelUtil<TShareImg>(TShareImg.class);
        util.exportExcel(response, list, "分享图片数据");
    }

    /**
     * 获取分享图片详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:shareImg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tShareImgService.selectTShareImgById(id));
    }

    /**
     * 新增分享图片
     */
    @PreAuthorize("@ss.hasPermi('system:shareImg:add')")
    @Log(title = "分享图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TShareImg tShareImg)
    {
        tShareImg.setId(UUID.randomUUID().toString());
        return toAjax(tShareImgService.insertTShareImg(tShareImg));
    }

    /**
     * 修改分享图片
     */
    @PreAuthorize("@ss.hasPermi('system:shareImg:edit')")
    @Log(title = "分享图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TShareImg tShareImg)
    {
        return toAjax(tShareImgService.updateTShareImg(tShareImg));
    }

    /**
     * 删除分享图片
     */
    @PreAuthorize("@ss.hasPermi('system:shareImg:remove')")
    @Log(title = "分享图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tShareImgService.deleteTShareImgByIds(ids));
    }
}
