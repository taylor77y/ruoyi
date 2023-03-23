package com.ruoyi.web.controller.bus;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.domain.TPairs;
import com.ruoyi.system.domain.dto.MemberDto;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.TBalanceMapper;
import com.ruoyi.system.mapper.TPairsMapper;
import com.ruoyi.system.service.*;
import com.ruoyi.system.utils.MemberUtils;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.ruoyi.system.domain.TMember;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/member")
public class TMemberController extends BaseController
{
    @Autowired
    private ITMemberService tMemberService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMember tMember)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tMember.setSysIds(getSysIds(list));
        }
        startPage();
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:export')")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMember tMember)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tMember.setSysIds(getSysIds(list));
        }
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        ExcelUtil<TMember> util = new ExcelUtil<TMember>(TMember.class);
        util.exportExcel(response, list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMemberService.selectTMemberById(id));
    }

    /**
     * 新增会员
     */
    @PreAuthorize("@ss.hasPermi('system:member:add')")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMember tMember)
    {
        return toAjax(tMemberService.insertTMember(tMember));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('system:member:edit')")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMember tMember)
    {
        if (tMemberService.updateTMember(tMember) == -3) return AjaxResult.error("手机号已存在");
        return toAjax(tMemberService.updateTMember(tMember));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('system:member:remove')")
    @Log(title = "会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMemberService.deleteTMemberByIds(ids));
    }

    /**
     * 上分
     */
    @PreAuthorize("@ss.hasPermi('system:member:above')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/above")
    public AjaxResult above(@RequestBody MemberDto memberDto){
        return tMemberService.changeAmount(memberDto,1);
    }

    /**
     * 下分
     */
    @PreAuthorize("@ss.hasPermi('system:member:lower')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/lower")
    public AjaxResult lower(@RequestBody MemberDto memberDto){
        return tMemberService.changeAmount(memberDto,2);
    }
    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:member:restPwd')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/restPwd")
    @Transactional
    public AjaxResult restPwd(@RequestBody MemberDto memberDto){

        TMember tMember = tMemberService.selectTMemberById(memberDto.getId());
        tMember.setPassword(MemberUtils.encryString(memberDto.getPassword(),tMember.getSalt()));
        return toAjax(tMemberService.updateTMember(tMember));
    }
    /**
     * 重置支付密码
     */
    @PreAuthorize("@ss.hasPermi('system:member:restPayPwd')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/restPayPwd")
    @Transactional
    public AjaxResult restPayPwd(@RequestBody MemberDto memberDto){

        TMember tMember = tMemberService.selectTMemberById(memberDto.getId());
        tMember.setPayPassword(MemberUtils.encryString(memberDto.getPassword(),tMember.getSalt()));
        return toAjax(tMemberService.updateTMember(tMember));
    }
    @Autowired
    private ITBalanceService tBalanceService;
    @Autowired
    private TBalanceMapper tBalanceMapper;
    @Autowired
    private TPairsMapper tPairsMapper;
    /**
     * 查看资产
     */
    @PreAuthorize("@ss.hasPermi('system:member:zcm')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @GetMapping("/zcm")
    public AjaxResult zcm(TMember tMember){
        TBalance balance = new TBalance();
        balance.setUserId(tMember.getId());
        JSONObject jsonObject = new JSONObject();
        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal freeze = BigDecimal.ZERO;
        List<TBalance> list = tBalanceMapper.selectTBalanceUid(tMember.getId());
        for (TBalance res : list) {
            if (StringUtils.isNotEmpty(res.getCurrency())){
                TPairs tPairs = tPairsMapper.selectTPairsByName(res.getCurrency());
                res.settPairs(tPairs);
                amount = amount.add(res.getAssetsBalance().multiply(tPairs.getPrice()));
                freeze = freeze.add(res.getAssetsBlockedBalance().multiply(tPairs.getPrice()));

            }
        }
        jsonObject.put("amount",amount);
        jsonObject.put("freeze",freeze);
        jsonObject.put("list",list);
        return AjaxResult.success(jsonObject);
    }

    /**
     * 修改邀请人
     */
    @PreAuthorize("@ss.hasPermi('system:member:wel')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/wel")
    public AjaxResult wel(@RequestBody TMember tMember){
        return tMemberService.wel(tMember);
    }

    /**
     * 查询下级
     */
    @PreAuthorize("@ss.hasPermi('system:member:lookDown')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @GetMapping("/lookDown/{id}")
    public AjaxResult lookDown(@PathVariable String id){
        TMember tMember = new TMember();
        tMember.setWelMember(id);
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        return AjaxResult.success(list);
    }
    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 修改归属员工
     */
    @PreAuthorize("@ss.hasPermi('system:member:vested')")
    @Log(title = "会员", businessType = BusinessType.OTHER)
    @PostMapping("/vested")
    public AjaxResult vested(@RequestBody TMember tMember){
        SysUser sysUser = sysUserMapper.selectUserById(tMember.getSysId());
        if (sysUser  == null) return AjaxResult.error("查无此人，请重新查询");
        return toAjax(tMemberService.updateTMember(tMember));
    }
}
