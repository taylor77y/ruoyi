package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.seve.ChannelUserDocument;
import com.ruoyi.system.domain.seve.UserSessionDocument;
import com.ruoyi.system.mapper.TMemberMapper;
import com.ruoyi.system.service.IChatService;
import com.ruoyi.system.service.IReportService;
import com.ruoyi.system.utils.MemberUtils;
import com.ruoyi.system.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Krson
 * @date 2022/9/21 11:02
 */
@Service
@Slf4j
public class ChatServiceImpl implements IChatService {


//    @Resource
//    private MongoTemplate mongoTemplate;

    @Value("${im.channel}")
    private String url;
    @Value("${im.record}")
    private String url2;
    @Autowired
    private TMemberMapper tMemberMapper;

    @Override
    public List<Map<String, Object>> getChatList(List<String> sysIds, String id) {

        List<Map<String,Object>> res = new ArrayList<>();
//        for (String sysId : sysIds) {
//            String list = HttpUtils.sendGet(url+sysId);
//            ChannelUserDocument channelUserDocument = JSONObject.parseObject(list,ChannelUserDocument.class);
//            if (channelUserDocument != null) {
//                log.info("查询结果：{}", channelUserDocument);
//                List<UserSessionDocument> sessionDocuments = channelUserDocument.getSessions();
//                if (!sessionDocuments.isEmpty()) {
//                    List<TMember> byList = tMemberMapper.findByList(sessionDocuments);
//                    Map<String, TMember> collect = byList.stream().collect(Collectors.toMap(TMember::getId, t -> t));
//                    List<Map<String, Object>> a = sessionDocuments.stream().map((Function<UserSessionDocument, Map<String, Object>>) s -> {
//                        HashMap<String, Object> o = new HashMap<>();
//                        s.setSender(sysId);
//                        o.put("session", s);
//                        o.put("user", collect.get(s.getTarget()));
//                        return o;
//                    }).collect(Collectors.toList());
//                    res.addAll(a);
//                }
//            }
//        }
//        return res;
        String info = "service";
        String list = HttpUtils.sendGet(url+info);
        ChannelUserDocument channelUserDocument = JSONObject.parseObject(list,ChannelUserDocument.class);
        if (channelUserDocument == null) return new ArrayList<>();
        log.info("查询结果：{}", channelUserDocument);
        List<UserSessionDocument> sessionDocuments = channelUserDocument.getSessions();
        if (sessionDocuments.isEmpty()) return new ArrayList<>();
        List<TMember> byList = tMemberMapper.findByList(sessionDocuments);
        Map<String, TMember> collect = byList.stream().collect(Collectors.toMap(TMember::getId, t -> t));
        List<Map<String, Object>> a = sessionDocuments.stream().map((Function<UserSessionDocument, Map<String, Object>>) s -> {
            HashMap<String, Object> o = new HashMap<>();
            s.setSender(info);
            o.put("session", s);
            o.put("user", collect.get(s.getTarget()));
            return o;
        }).collect(Collectors.toList());
        return a;
    }

    @Override
    public UserSessionDocument getOne() {
        String info = "service";
        String list = HttpUtils.sendGet(url+info);
        ChannelUserDocument channelUserDocument = JSONObject.parseObject(list,ChannelUserDocument.class);
        if (channelUserDocument == null) return null;
        List<UserSessionDocument> sessionDocuments = channelUserDocument.getSessions();
        if (sessionDocuments.isEmpty()) return null;
        Collections.sort(sessionDocuments, new Comparator<UserSessionDocument>() {
            @Override
            public int compare(UserSessionDocument o1, UserSessionDocument o2) {
                return o1.getLastTime().compareTo(o2.getLastTime());
            }
        });
        for (UserSessionDocument sessionDocument : sessionDocuments) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.err.println(simpleDateFormat.format(sessionDocument.getLastTime()));
        }
        return sessionDocuments.get(sessionDocuments.size() - 1);
    }

    @Override
    public String chatRecords(String hash) {
        String list = HttpUtils.sendGet(url2 + hash);
        log.info("查询结果：{}", list);
        return list;
    }

    @Override
    public AjaxResult sourceRecord(String code, List<String> sysIds, String id) {
        TMember tMember = new TMember();
        tMember.setUuid(code);
        tMember.setSysIds(sysIds);
        List<TMember> list = tMemberMapper.selectTMemberList(tMember);
        if (list.size() == 0) return AjaxResult.error("查无此人");
        TMember tMember1 = list.get(0);
        String res = HttpUtils.sendGet(url + tMember1.getId());
        ChannelUserDocument channelUserDocument = JSONObject.parseObject(res, ChannelUserDocument.class);
        Map<String, Object> map = new HashMap<>();
        map.put("member", tMember1);
        UserSessionDocument userSessionDocument =
                UserSessionDocument.builder().target(tMember1.getId()).hash(MessageUtils.hash(tMember1.getId(), id)).build();
        if (channelUserDocument == null) {
            map.put("user", userSessionDocument);
        } else {
            if (channelUserDocument.getSessions().isEmpty()) {
                map.put("user", userSessionDocument);
            } else {
                map.put("user", channelUserDocument.getSessions().get(0));
            }
        }
        return AjaxResult.success("查询结果", map);
    }
}
