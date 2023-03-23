package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.report.ReportVo;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author Krson
 * @date 2022/9/25 11:06
 */
public interface IReportService {

    AjaxResult getAddUserData(List<String> sysId, ReportVo reportVo) throws ParseException;

    AjaxResult getLiveAmountData(List<String> sysId);

    List<TMember> getUserData(TMember tMember,Integer mode);

    List<TMember> getIncomeData(TMember tMember,Integer mode);

    List<TMember> getInfoData(List<String> names, List<String> sysIds,Date openTime, Date closeTime);
}
