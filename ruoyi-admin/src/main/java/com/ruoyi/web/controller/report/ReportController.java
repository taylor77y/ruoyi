package com.ruoyi.web.controller.report;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.dto.MinDto;
import com.ruoyi.system.domain.report.ReportVo;
import com.ruoyi.system.service.IReportService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krson
 * @date 2022/9/25 10:56
 */
@RestController
@RequestMapping("/report")
public class ReportController extends BaseController {

    @Autowired
    private IReportService iReportService;

    /**
     * 新增用户统计
     */
    @PostMapping("/getAddUserData")
    public AjaxResult getAddUserData(@RequestBody ReportVo reportVo) throws ParseException {
        return iReportService.getAddUserData(getSysIdList(),reportVo);
    }

    /**
     * 用户存量金额汇总
     */
    @GetMapping("/getLiveAmountData")
    public AjaxResult getLiveAmountData(){
        return iReportService.getLiveAmountData(getSysIdList());
    }

    /**
     * 用户统计
     */
    @PostMapping("/getUserData")
    public TableDataInfo getUserData(@RequestBody TMember tMember) {

        tMember.setSysIds(getSysIdList());
        startPage();
        List<TMember> list = iReportService.getUserData(tMember,null);
        return getDataTable(list);
    }

    @PostMapping("/getIncomeData")
    public AjaxResult getIncomeData(@RequestBody TMember tMember){
        return AjaxResult.success("查询结果",iReportService.getIncomeData(tMember,null));
    }
    /**
     * 信息统计
     */
    @PostMapping("/getInfoData")
    public TableDataInfo getInfoData(@RequestBody MinDto minDto){
        startPage();
        List<TMember> list = iReportService.getInfoData(minDto.getInfo(),getSysIdList(),minDto.getOpenTime(),minDto.getCloseTime());
        return getDataTable(list);
    }


    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;

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
