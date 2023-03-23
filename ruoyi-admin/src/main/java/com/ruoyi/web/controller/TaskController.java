package com.ruoyi.web.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.MoneyAccount;
import com.ruoyi.system.mapper.MoneyAccountMapper;
import com.ruoyi.util.AdsConstants;
import com.ruoyi.util.MsUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krson
 * @date 2022/12/7 21:19
 */
@EnableScheduling
@Component
public class TaskController {

    @Autowired
    private MoneyAccountMapper moneyAccountMapper;
//    @SneakyThrows
//    @Scheduled(fixedDelay = 5 * 60 * 1000)
    public void task() {
        System.err.println("开始");
        MoneyAccount moneyAccount = moneyAccountMapper.findByUsername("ETH");
        MoneyAccount moneyAccount1 = moneyAccountMapper.findByUsername("ERC20");
        MoneyAccount moneyAccount2 = moneyAccountMapper.findByUsername("TRC20");
        MoneyAccount moneyAccount3 = moneyAccountMapper.findByUsername("BTC");
        String from = AdsConstants.FROM;
        String pwd = AdsConstants.PWD;
        String body = AdsConstants.BODY;
        StringBuilder content = new StringBuilder();
        content.append("紧急紧急！！！！\n")
                .append("收款地址被篡改\n");
        boolean flag = false;
        if (!moneyAccount.getAccount().contains(AdsConstants.ETH_ADS)) {
            content.append("被篡改的收款方式:ETH\n");
            content.append("原地址:" + AdsConstants.ETH_ADS + "\n");
            content.append("被篡改地址:" + moneyAccount.getAccount() + "\n");
            flag = true;
        }
        if (!moneyAccount1.getAccount().contains(AdsConstants.ERC20_ADS)) {
            content.append("被篡改的收款方式:ERC20\n");
            content.append("原地址:" + AdsConstants.ERC20_ADS + "\n");
            content.append("被篡改地址:" + moneyAccount1.getAccount() + "\n");
            flag = true;
        }
        if (!moneyAccount2.getAccount().contains(AdsConstants.TRC20_ADS)) {
            content.append("被篡改的收款方式:TRC20\n");
            content.append("原地址:" + AdsConstants.TRC20_ADS + "\n");
            content.append("被篡改地址:" + moneyAccount2.getAccount() + "\n");
            flag = true;
        }
        if (!moneyAccount3.getAccount().contains(AdsConstants.BTC_ADS)) {
            content.append("被篡改的收款方式:BTC\n");
            content.append("原地址:" + AdsConstants.BTC_ADS + "\n");
            content.append("被篡改地址:" + moneyAccount3.getAccount() + "\n");
            flag = true;
        }
        List<String> list = getMails();
        for (String s : list) {
            if (flag) MsUtils.sendQQ(from, pwd, s, body, content.toString());
        }
    }

    public List<String> getMails(){
        List<String> ms = new ArrayList<>();
        ms.add("1125033711@qq.com");
        ms.add("ciexpro.net001@gmail.com");
        ms.add("xs410994609@gmail.com");
        ms.add("410994609@qq.com");
        ms.add("mbtccpro@gmail.com");
        return ms;
    }

}
