package com.ruoyi.web.controller.userAmount;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Bizhongzongshu;
import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.mapper.BizhongzongshuMapper;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.ITBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户余额Controller
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/system/Bizhongzongshu")
public class BizhongzongshuController extends BaseController
{

    @Autowired
    private BizhongzongshuMapper bizhongzongshuMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:Bizhongzongshu:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBalance tBalance)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalance.setSysIds(getSysIds(list));
        }
//        startPage();
        List<Bizhongzongshu> list = new ArrayList<>();
        List<Map<String, Object>> maps = bizhongzongshuMapper.selectBalance(tBalance);
        maps.stream().forEach(map -> {
            String currency = map.get("currency").toString();
            BigDecimal balance = new BigDecimal(map.get("balance").toString());
            BigDecimal blocked_balance = new BigDecimal(map.get("blocked_balance").toString());
            BigDecimal assets_balance = new BigDecimal(map.get("assets_balance").toString());
            BigDecimal assets_blocked_balance = new BigDecimal(map.get("assets_blocked_balance").toString());
            BigDecimal token_balance = new BigDecimal(map.get("token_balance").toString());
            BigDecimal token_blocked_balance = new BigDecimal(map.get("token_blocked_balance").toString());
            BigDecimal fb_balance = new BigDecimal(map.get("fb_balance").toString());
            BigDecimal fb_blocked_balance = new BigDecimal(map.get("fb_blocked_balance").toString());
            BigDecimal chain_balance = new BigDecimal(map.get("chain_balance").toString());
            Bizhongzongshu bizhongzongshu1 = new Bizhongzongshu();
            bizhongzongshu1.setCurrency(currency);
            bizhongzongshu1.setBibidongjie(blocked_balance);
            bizhongzongshu1.setBibikeyong(balance);
            bizhongzongshu1.setHeyuedongjie(token_blocked_balance);
            bizhongzongshu1.setHeyuekeyong(token_balance);
            bizhongzongshu1.setChongtidongjie(assets_blocked_balance);
            bizhongzongshu1.setChongtikeyong(assets_balance);
            bizhongzongshu1.setFabikeyong(fb_balance);
            bizhongzongshu1.setFabidongjie(fb_blocked_balance);
            bizhongzongshu1.setChainbalance(chain_balance);
            bizhongzongshu1.setSum(balance.add(blocked_balance).add(assets_balance).add(assets_blocked_balance).add(token_balance).add(token_blocked_balance).add(fb_balance).add(fb_blocked_balance));
            bizhongzongshu1.setCreateTime(new Date());
            list.add(bizhongzongshu1);
        });
        return getDataTable(list);
    }

    /**
     * 导出用户余额列表
     */
    @PreAuthorize("@ss.hasPermi('system:Bizhongzongshu:export')")
    @Log(title = "用户余额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBalance tBalance)
    {
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            tBalance.setSysIds(getSysIds(list));
        }
        List<Bizhongzongshu> list = new ArrayList<>();
        List<Map<String, Object>> maps = bizhongzongshuMapper.selectBalance(tBalance);
        maps.stream().forEach(map -> {
            String currency = map.get("currency").toString();
            BigDecimal balance = new BigDecimal(map.get("balance").toString());
            BigDecimal blocked_balance = new BigDecimal(map.get("blocked_balance").toString());
            BigDecimal assets_balance = new BigDecimal(map.get("assets_balance").toString());
            BigDecimal assets_blocked_balance = new BigDecimal(map.get("assets_blocked_balance").toString());
            BigDecimal token_balance = new BigDecimal(map.get("token_balance").toString());
            BigDecimal token_blocked_balance = new BigDecimal(map.get("token_blocked_balance").toString());
            BigDecimal fb_balance = new BigDecimal(map.get("fb_balance").toString());
            BigDecimal fb_blocked_balance = new BigDecimal(map.get("fb_blocked_balance").toString());
            BigDecimal chain_balance = new BigDecimal(map.get("chain_balance").toString());
            Bizhongzongshu bizhongzongshu1 = new Bizhongzongshu();
            bizhongzongshu1.setCurrency(currency);
            bizhongzongshu1.setBibidongjie(blocked_balance);
            bizhongzongshu1.setBibikeyong(balance);
            bizhongzongshu1.setHeyuedongjie(token_blocked_balance);
            bizhongzongshu1.setHeyuekeyong(token_balance);
            bizhongzongshu1.setChongtidongjie(assets_blocked_balance);
            bizhongzongshu1.setChongtikeyong(assets_balance);
            bizhongzongshu1.setFabikeyong(fb_balance);
            bizhongzongshu1.setFabidongjie(fb_blocked_balance);
            bizhongzongshu1.setChainbalance(chain_balance);
            bizhongzongshu1.setSum(balance.add(blocked_balance).add(assets_balance).add(assets_blocked_balance).add(token_balance).add(token_blocked_balance).add(fb_balance).add(fb_blocked_balance));
            bizhongzongshu1.setCreateTime(new Date());
            list.add(bizhongzongshu1);
        });
        ExcelUtil<Bizhongzongshu> util = new ExcelUtil<Bizhongzongshu>(Bizhongzongshu.class);
        util.exportExcel(response, list, "用户余额数据");
    }
}
