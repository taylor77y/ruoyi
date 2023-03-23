package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.report.ReportVo;
import com.ruoyi.system.mapper.ReportMapper;
import com.ruoyi.system.mapper.TMemberMapper;
import com.ruoyi.system.service.IReportService;
import com.ruoyi.system.utils.TimeIntervalUtils;
import org.apache.poi.ss.formula.functions.Na;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Krson
 * @date 2022/9/25 11:06
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;


    @Override
    public AjaxResult getAddUserData(List<String> sysIds,ReportVo reportVo) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        List<Long> nums = new ArrayList<>();
        if (reportVo.getType() == 1){
            jsonObject.put("names",TimeIntervalUtils.getHoursName());
            List<Date> list = TimeIntervalUtils.ofHours();
            for (Date date : list) {
                Long num = reportMapper.findCountByMemberToDay(sysIds,date);
                nums.add(num);
            }
        }else if (reportVo.getType() == 2){
            jsonObject.put("names",TimeIntervalUtils.getDaysName());
            List<Date> list = TimeIntervalUtils.ofDays();
            for (Date date : list) {
                Long num = reportMapper.findCountByMemberToMonth(sysIds,date);
                nums.add(num);
            }
        }else if (reportVo.getType() == 3){
            jsonObject.put("names",TimeIntervalUtils.getMonthsName());
            List<Date> list = TimeIntervalUtils.ofMonths();
            for (Date date : list) {
                Long num = reportMapper.findCountByMemberToYear(sysIds,date);
                nums.add(num);
            }
        }else {
            List<String> names = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startTime = sdf.format(reportVo.getStartTime());
            String endTime = sdf.format(reportVo.getEndTime());
            List<Date> times = TimeIntervalUtils.ofTwoDaysList(startTime,endTime);
            for (Date time : times) {
                names.add(sdf.format(time));
                Long num = reportMapper.findCountByMemberToDay(sysIds,time);
                nums.add(num);
            }
            jsonObject.put("names",names);
        }
        jsonObject.put("nums",nums);
        return AjaxResult.success("查询结果",jsonObject);
    }

    @Override
    public AjaxResult getLiveAmountData(List<String> sysId) {
        List<Map> maps = new ArrayList<>();
        List<String> list = reportMapper.findCurrencyByUser();
        for (String s : list) {
            Map map = new HashMap();
            BigDecimal amount = reportMapper.findAmountByUserAndCurrency(sysId,s);
            map.put("currency",s);
            map.put("amount",amount);
            maps.add(map);
        }
        return AjaxResult.success("查询结果",maps);
    }
    @Autowired
    private TMemberMapper tMemberMapper;

    @Override
    public List<TMember> getUserData(TMember tMember,Integer mode) {
        List<TMember> list = tMemberMapper.selectTMemberList(tMember);
        for (TMember member : list) {
            member.setBtcAmount(reportMapper.findMemberRecharge(member.getId(),"BTC",tMember.getOpenTime(),tMember.getCloseTime(),mode));
            member.setEthAmount(reportMapper.findMemberRecharge(member.getId(),"ETH",tMember.getOpenTime(),tMember.getCloseTime(),mode));
            member.setUsdtAmount(reportMapper.findMemberRecharge(member.getId(),"USDT",tMember.getOpenTime(),tMember.getCloseTime(),mode));
            member.setTxAmount(reportMapper.findMemberIdByWithDraw(member.getId(),tMember.getOpenTime(),tMember.getCloseTime(),mode));
            BigDecimal fbBuyAmount = reportMapper.findMemberByOTC(member.getId(),"BUY",tMember.getOpenTime(),tMember.getCloseTime(),mode);
            BigDecimal fbSellAmount = reportMapper.findMemberByOTC(member.getId(),"SELL",tMember.getOpenTime(),tMember.getCloseTime(),mode);
            member.setFbBuyAmount(fbBuyAmount);
            member.setFbSellAmount(fbSellAmount);
            member.setMhyWinAmount(reportMapper.findMemberMhyByWin(member.getId(),tMember.getOpenTime(),tMember.getCloseTime(),mode));
            member.setMhyDonateAmount(reportMapper.findMemberMhyByDonate(member.getId(),tMember.getOpenTime(),tMember.getCloseTime(),mode));


            member.setXnUpAmount(reportMapper.findMemberByXnAmount(member.getId(),52,"USDT",tMember.getOpenTime(),tMember.getCloseTime()));
            member.setXnDownAmount(reportMapper.findMemberByXnAmount(member.getId(),54,"USDT",tMember.getOpenTime(),tMember.getCloseTime()));

            member.setXnUpAmountBTC(reportMapper.findMemberByXnAmount(member.getId(),52,"BTC",tMember.getOpenTime(),tMember.getCloseTime()));
            member.setXnDownAmountBTC(reportMapper.findMemberByXnAmount(member.getId(),54,"BTC",tMember.getOpenTime(),tMember.getCloseTime()));

            member.setXnUpAmountETH(reportMapper.findMemberByXnAmount(member.getId(),52,"ETH",tMember.getOpenTime(),tMember.getCloseTime()));
            member.setXnDownAmountETH(reportMapper.findMemberByXnAmount(member.getId(),54,"ETH",tMember.getOpenTime(),tMember.getCloseTime()));
        }
        return list;
    }

    @Override
    public List<TMember> getIncomeData(TMember tMember,Integer mode) {
        List<TMember> list = new ArrayList<>();
        TMember member = new TMember();
        member.setBtcAmount(reportMapper.findMemberRecharge(null,"BTC",tMember.getOpenTime(),tMember.getCloseTime(),mode));
        member.setEthAmount(reportMapper.findMemberRecharge(null,"ETH",tMember.getOpenTime(),tMember.getCloseTime(),mode));
        member.setUsdtAmount(reportMapper.findMemberRecharge(null,"USDT",tMember.getOpenTime(),tMember.getCloseTime(),mode));
        member.setTxAmount(reportMapper.findMemberIdByWithDraw(null,tMember.getOpenTime(),tMember.getCloseTime(),mode));
        BigDecimal fbBuyAmount = reportMapper.findMemberByOTC(null,"BUY",tMember.getOpenTime(),tMember.getCloseTime(),mode);
        BigDecimal fbSellAmount = reportMapper.findMemberByOTC(null,"SELL",tMember.getOpenTime(),tMember.getCloseTime(),mode);
        member.setFbBuyAmount(fbBuyAmount);
        member.setFbSellAmount(fbSellAmount);
        member.setMhyWinAmount(reportMapper.findMemberMhyByWin(null,tMember.getOpenTime(),tMember.getCloseTime(),mode));
        member.setMhyDonateAmount(reportMapper.findMemberMhyByDonate(null,tMember.getOpenTime(),tMember.getCloseTime(),mode));

        member.setXnUpAmount(reportMapper.findMemberByXnAmount(null,52,"USDT",tMember.getOpenTime(),tMember.getCloseTime()));
        member.setXnDownAmount(reportMapper.findMemberByXnAmount(null,54,"USDT",tMember.getOpenTime(),tMember.getCloseTime()));

        member.setXnUpAmountBTC(reportMapper.findMemberByXnAmount(null,52,"BTC",tMember.getOpenTime(),tMember.getCloseTime()));
        member.setXnDownAmountBTC(reportMapper.findMemberByXnAmount(null,54,"BTC",tMember.getOpenTime(),tMember.getCloseTime()));

        member.setXnUpAmountETH(reportMapper.findMemberByXnAmount(null,52,"ETH",tMember.getOpenTime(),tMember.getCloseTime()));
        member.setXnDownAmountETH(reportMapper.findMemberByXnAmount(null,54,"ETH",tMember.getOpenTime(),tMember.getCloseTime()));
        list.add(member);
        return list;
    }

    @Override
    public List<TMember> getInfoData(List<String> names,List<String> sysIds,Date openTime, Date closeTime) {

        List<TMember> list = reportMapper.findInfoByUser(names,sysIds,openTime,closeTime);
        if (!list.isEmpty()){
            for (TMember member : list) {
                String admin = tMemberMapper.findUserNameByAdminId(member.getSysId());
                member.setSysName(admin);
            }
        }
        return list;
    }
}
