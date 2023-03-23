package com.ruoyi.web.controller.bbq;

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
import com.ruoyi.system.domain.TCoinToken;
import com.ruoyi.system.service.ITCoinTokenService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币种信息Controller
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/system/coinToken")
public class TCoinTokenController extends BaseController
{
    @Autowired
    private ITCoinTokenService tCoinTokenService;

    /**
     * 查询币种信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:coinToken:list')")
    @GetMapping("/list")
    public TableDataInfo list(TCoinToken tCoinToken)
    {
        startPage();
        List<TCoinToken> list = tCoinTokenService.selectTCoinTokenList(tCoinToken);
        return getDataTable(list);
    }

    /**
     * 导出币种信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:coinToken:export')")
    @Log(title = "币种信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TCoinToken tCoinToken)
    {
        List<TCoinToken> list = tCoinTokenService.selectTCoinTokenList(tCoinToken);
        ExcelUtil<TCoinToken> util = new ExcelUtil<TCoinToken>(TCoinToken.class);
        util.exportExcel(response, list, "币种信息数据");
    }

    /**
     * 获取币种信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:coinToken:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tCoinTokenService.selectTCoinTokenById(id));
    }

    /**
     * 新增币种信息
     */
    @PreAuthorize("@ss.hasPermi('system:coinToken:add')")
    @Log(title = "币种信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCoinToken tCoinToken)
    {
        tCoinToken.setId(UUID.randomUUID().toString());
        return toAjax(tCoinTokenService.insertTCoinToken(tCoinToken));
    }

    /**
     * 修改币种信息
     */
    @PreAuthorize("@ss.hasPermi('system:coinToken:edit')")
    @Log(title = "币种信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCoinToken tCoinToken)
    {
        return toAjax(tCoinTokenService.updateTCoinToken(tCoinToken));
    }

    /**
     * 删除币种信息
     */
    @PreAuthorize("@ss.hasPermi('system:coinToken:remove')")
    @Log(title = "币种信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tCoinTokenService.deleteTCoinTokenByIds(ids));
    }
}
