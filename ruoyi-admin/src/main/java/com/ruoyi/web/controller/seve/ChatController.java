package com.ruoyi.web.controller.seve;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.IChatService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Krson
 * @date 2022/9/21 10:25
 */
@RestController
@RequestMapping("/system/seve")
public class ChatController extends BaseController {

    @Autowired
    private IChatService iChatService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;

    @GetMapping("/chat")
    public AjaxResult chat(){
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        SysUser user = new SysUser();
        if (depts.size() == 1){
            user.setUserId(getUserId());
        }
        List<SysUser> list = userService.selectUserList(user);
        return AjaxResult.success("查询结果",list);
    }

    @GetMapping("/getChatList/{id}")
    public AjaxResult getChatList(@PathVariable String id, Map<String,Object> map){
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        SysUser user = new SysUser();
        if (depts.size() == 1){
            user.setUserId(getUserId());
        }
        List<SysUser> list = userService.selectUserList(user);
        return AjaxResult.success("查询结果",iChatService.getChatList(getSysIds(list),id));
    }
    @GetMapping("/search/{code}")
    public AjaxResult source(@PathVariable String code){
        return iChatService.sourceRecord(code,getSysIdList(),getUserId().toString());
    }
    @GetMapping("/chatRecords/{hash}")
    public AjaxResult chatRecords(@PathVariable String hash){
        return AjaxResult.success("查询结果",iChatService.chatRecords(hash));
    }
    private List<String> getSysIdList(){
        List<String> sysIds = new ArrayList<>();
        if (getCheckUid() != null) {
            List<SysDept> depts = deptService.selectDeptList(new SysDept());
            SysUser user = new SysUser();
            if (depts.size() == 1){
                user.setUserId(getUserId());
            }
            List<SysUser> list = userService.selectUserList(user);
            sysIds.addAll(getSysIds(list));
        }
        return sysIds;
    }
}
