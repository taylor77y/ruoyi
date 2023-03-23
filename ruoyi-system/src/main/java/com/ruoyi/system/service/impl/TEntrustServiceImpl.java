package com.ruoyi.system.service.impl;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.domain.TPairs;
import com.ruoyi.system.mapper.TPairsMapper;
import com.ruoyi.system.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TEntrustMapper;
import com.ruoyi.system.domain.TEntrust;
import com.ruoyi.system.service.ITEntrustService;

/**
 * 币币撮合Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class TEntrustServiceImpl implements ITEntrustService 
{
    private static final Logger logger = LoggerFactory.getLogger(TEntrustServiceImpl.class);

    @Autowired
    private TEntrustMapper tEntrustMapper;

    /**
     * 查询币币撮合
     * 
     * @param id 币币撮合主键
     * @return 币币撮合
     */
    @Override
    public TEntrust selectTEntrustById(String id)
    {
        return tEntrustMapper.selectTEntrustById(id);
    }

    /**
     * 查询币币撮合列表
     * 
     * @param tEntrust 币币撮合
     * @return 币币撮合
     */
    @Override
    public List<TEntrust> selectTEntrustList(TEntrust tEntrust)
    {
        return tEntrustMapper.selectTEntrustList(tEntrust);
    }

    /**
     * 新增币币撮合
     * 
     * @param tEntrust 币币撮合
     * @return 结果
     */
    @Override
    public int insertTEntrust(TEntrust tEntrust)
    {
        tEntrust.setCreateTime(DateUtils.getNowDate());
        return tEntrustMapper.insertTEntrust(tEntrust);
    }

    /**
     * 修改币币撮合
     * 
     * @param tEntrust 币币撮合
     * @return 结果
     */
    @Override
    public int updateTEntrust(TEntrust tEntrust)
    {
        tEntrust.setUpdateTime(DateUtils.getNowDate());
        return tEntrustMapper.updateTEntrust(tEntrust);
    }

    /**
     * 批量删除币币撮合
     * 
     * @param ids 需要删除的币币撮合主键
     * @return 结果
     */
    @Override
    public int deleteTEntrustByIds(String[] ids)
    {
        return tEntrustMapper.deleteTEntrustByIds(ids);
    }

    /**
     * 删除币币撮合信息
     * 
     * @param id 币币撮合主键
     * @return 结果
     */
    @Override
    public int deleteTEntrustById(String id)
    {
        return tEntrustMapper.deleteTEntrustById(id);
    }

    @Value("${ch.qx}")
    private String CK;
    @Value("${ch.ty}")
    private String TY;
    @Override
    public AjaxResult cancel(String id) {
        String result = HttpUtils.sendPost(CK+"?entrust="+id,id);
        JSONObject resultJson = JSONObject.parseObject(result);
        logger.info("撤销请求接口日志：{}",CK);
        logger.info("撤销请求响应日志：{}",result);
        if (resultJson.getString("status").equals("SUCCEED")){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @Override
    public AjaxResult agree(String id) {
        String result = HttpUtils.sendPost(TY+"?entrust="+id,id);
        JSONObject resultJson = JSONObject.parseObject(result);
        logger.info("确认请求接口日志：{}",TY);
        logger.info("确认请求响应日志：{}",result);
        if (resultJson.getString("status").equals("SUCCEED")){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

//    public static void main(String[] args) {
//        String result = HttpUtils.sendPost("https://bbapi.mbtcpro.com/entrust/entrust/setEntrustBackstage?entrust=b20d25b02bcd49bd90e0fb5470ea76ba","cccccccccc");
//        System.err.println(result);
//    }

}
