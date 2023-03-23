package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.AmountChange;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.domain.TMemberCurrencyConfig;
import com.ruoyi.system.domain.dto.MemberDto;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.IStoreService;
import com.ruoyi.system.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class StoreServiceImpl implements IStoreService
{
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private TMemberCurrencyConfigMapper memberCurrencyConfigMapper;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public Store selectTMemberById(String id)
    {
        return storeMapper.selectTMemberById(id);
    }

    /**
     * 查询会员列表
     * 
     * @return 会员
     */
    @Override
    public List<Store> selectTMemberList(Store store)
    {
        store.setStoreState("PASS");
        List<Store> list = storeMapper.selectTMemberList(store);
        if (list.size()>0) {
            for (Store data : list) {
                TMemberCurrencyConfig currencyConfig = memberCurrencyConfigMapper.selectTMemberCurrencyConfigById(data.getOucId());
                if (currencyConfig != null) {
                    data.setOucName(currencyConfig.getCurrencyName());
                }
            }
        }
        return list;
    }

    @Value("${reg.url}")
    private String regUrl;
    /**
     * 新增会员
     * 
     * @return 结果
     */
    @Override
    public int insertTMember(Store store)
    {
        Store check = storeMapper.selectTMemberByPhone(store.getPhone());
        if (check != null) return -1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone",store.getPhone());
        jsonObject.put("password",store.getPassword());
        jsonObject.put("areaCode",store.getAreaCode());
        jsonObject.put("payPassword",store.getPassword());
        jsonObject.put("regType","PHONE");
        jsonObject.put("storeState","PASS");
        String result = HttpUtils.sendPost(regUrl,JSONObject.toJSONString(jsonObject));
        JSONObject resultJson = JSONObject.parseObject(result);
        if (resultJson.getString("status").equals("SUCCEED")){
            Store resStore = storeMapper.selectTMemberByPhone(store.getPhone());
            store.setId(resStore.getId());
            store.setPositiveLink("1");
            store.setSideLink("1");
            store.setCardNo(store.getUname());
            store.setCardState("PASS");
            updateTMember(store);
            return 1;
        }else {
            return -1;
        }
    }
    /**
     * 修改会员
     * 
     * @return 结果
     */
    @Override
    public int updateTMember(Store store)
    {
        store.setUpdateTime(DateUtils.getNowDate());
        return storeMapper.updateTMember(store);
    }

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteTMemberByIds(String[] ids)
    {
        return storeMapper.deleteTMemberByIds(ids);
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteTMemberById(String id)
    {
        return storeMapper.deleteTMemberById(id);
    }
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private AmountChangeMapper amountChangeMapper;
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Override
    @Transactional
    public AjaxResult fbAmount(MemberDto memberDto) {
        TBalanceRecord tBalanceRecord = new TBalanceRecord();
        tBalanceRecord.setMemberId(memberDto.getId());
        tBalanceRecord.setCurrency("USDT");
        tBalanceRecord.setBalanceDifference(memberDto.getAmount());
        tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(memberDto.getId(),"USDT"));
        tBalanceRecord.setFundsType(2);
        tBalanceRecord.setBalanceType(52);
        tBalanceRecord.setDataClassification(5);
        tMemberMapper.addFbBalanceByUserIdAndBz(memberDto.getAmount(),memberDto.getId(),"USDT");
        tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(memberDto.getId(),"USDT"));
        tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
        return AjaxResult.success();
    }

}
