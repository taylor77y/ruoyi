package com.ruoyi.web.controller.bus;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.domain.dto.MemberDto;
import com.ruoyi.system.service.IStoreService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.ITMemberCurrencyConfigService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/store")
public class StoreController extends BaseController
{
    @Autowired
    private IStoreService storeService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:store:list')")
    @GetMapping("/list")
    public TableDataInfo list(Store store)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            store.setSysIds(getSysIds(list));
        }
        startPage();
        List<Store> list = storeService.selectTMemberList(store);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:store:export')")
    @Log(title = "商家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Store store)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            store.setSysIds(getSysIds(list));
        }
        List<Store> list = storeService.selectTMemberList(store);
        ExcelUtil<Store> util = new ExcelUtil<Store>(Store.class);
        util.exportExcel(response, list, "商家数据");
    }

    /**
     * 获取会员详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:store:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(storeService.selectTMemberById(id));
    }

    /**
     * 新增会员
     */
    @PreAuthorize("@ss.hasPermi('system:store:add')")
    @Log(title = "商家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Store store)
    {
        return toAjax(storeService.insertTMember(store));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('system:store:edit')")
    @Log(title = "商家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Store store)
    {
        return toAjax(storeService.updateTMember(store));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('system:store:remove')")
    @Log(title = "商家", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(storeService.deleteTMemberByIds(ids));
    }

    @Autowired
    private ITMemberCurrencyConfigService currencyConfigService;

    /**
     * 法币List
     */
    @GetMapping("/oucList")
    public AjaxResult oucList(){
        return AjaxResult.success(currencyConfigService.selectTMemberCurrencyConfigList(null));
    }

    /**
     * 充值法币余额
     */
    @PreAuthorize("@ss.hasPermi('system:store:fbAmount')")
    @Log(title = "商家", businessType = BusinessType.OTHER)
    @PostMapping("/fbAmount")
    public AjaxResult fbAmount(@RequestBody MemberDto memberDto){
        return storeService.fbAmount(memberDto);
    }
}
