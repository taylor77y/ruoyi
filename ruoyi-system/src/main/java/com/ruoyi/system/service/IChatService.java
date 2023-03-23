package com.ruoyi.system.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.seve.ChannelUserDocument;
import com.ruoyi.system.domain.seve.UserSessionDocument;
import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;

import java.util.List;
import java.util.Map;

/**
 * @author Krson
 * @date 2022/9/21 11:02
 */
public interface IChatService {

    List<Map<String,Object>> getChatList(List<String> sysIds,String id);

    UserSessionDocument getOne();

    String chatRecords(String hash);

    AjaxResult sourceRecord(String code,List<String> sysIds,String id);
}
