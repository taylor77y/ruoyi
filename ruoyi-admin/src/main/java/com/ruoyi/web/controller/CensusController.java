package com.ruoyi.web.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.seve.UserSessionDocument;
import com.ruoyi.system.domain.vo.CtDataVo;
import com.ruoyi.system.domain.vo.TkDto;
import com.ruoyi.system.mapper.CensusMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.IChatService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Krson
 * @date 2022/8/13 20:12
 */
@RestController
@RequestMapping("/system/census")
public class CensusController extends BaseController {

    @Autowired
    private CensusMapper censusMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 校验操作密码
     */
    @PostMapping("/checkOperPwd/{pwd}")
    public AjaxResult checkOperPwd(@PathVariable String pwd){
        String res = sysUserMapper.findByUid(getUserId());
        if (StringUtils.isEmpty(res)) return AjaxResult.success("操作成功",false);
        return AjaxResult.success("操作成功",SecurityUtils.matchesPassword(pwd,res));
    }

    @GetMapping("/hyData")
    public AjaxResult hyData(){
        List<String> sysIds = getSysIdList();
        CtDataVo ctDataVo1 = new CtDataVo();
        CtDataVo ctDataVo2 = new CtDataVo();
        ctDataVo1.setName("总注册用户");
        ctDataVo1.setCount(censusMapper.zcMemberCount(null,sysIds));
        ctDataVo2.setName("今日注册用户");
        ctDataVo2.setCount(censusMapper.zcMemberCount(1,sysIds));
        List<CtDataVo> list = new ArrayList<>();
        list.add(ctDataVo1);
        list.add(ctDataVo2);
        return AjaxResult.success(list);
    }
    /**
     * 充提数据
     */
    @GetMapping("/ctData")
    public AjaxResult ctData(){
        List<String> sysIds = getSysIdList();
        CtDataVo ctDataVo1 = new CtDataVo();
        CtDataVo ctDataVo2 = new CtDataVo();
        CtDataVo ctDataVo3 = new CtDataVo();
        BigDecimal tx = censusMapper.withdraw("PASS",null,sysIds);
        BigDecimal cz = censusMapper.recharge(2,null,sysIds);
        ctDataVo1.setName("充值");
        List<Map> czList = new ArrayList<>();
        Map<String,Object> cz1 = new HashMap<>();
        cz1.put("name","日：");
        cz1.put("amount",censusMapper.recharge(2,1,sysIds));
        Map<String,Object> cz2 = new HashMap<>();
        cz2.put("name","总：");
        cz2.put("amount",cz);
        czList.add(cz2);
        czList.add(cz1);
        ctDataVo1.setItems(czList);

        ctDataVo2.setName("提现");
        List<Map> txList = new ArrayList<>();
        Map<String,Object> tx1 = new HashMap<>();
        tx1.put("name","日：");
        tx1.put("amount",censusMapper.withdraw("PASS",1,sysIds));
        Map<String,Object> tx2 = new HashMap<>();
        tx2.put("name","总：");
        tx2.put("amount",tx);
        txList.add(tx2);
        txList.add(tx1);
        ctDataVo2.setItems(txList);

        ctDataVo3.setName("平台提现充值差额");
        Map<String,Object> pt = new HashMap<>();
        pt.put("name","");
        pt.put("amount",cz.subtract(tx));
        List<Map> ptList = new ArrayList<>();
        ptList.add(pt);
        ctDataVo3.setItems(ptList);



        List<CtDataVo> list = new ArrayList<>();
        list.add(ctDataVo1);
        list.add(ctDataVo2);
        list.add(ctDataVo3);
        return AjaxResult.success(list);
    }

    /**
     * 法币交易订单
     */
    @GetMapping("/fbData")
    public AjaxResult fbData(){
        List<String> sysIds = getSysIdList();
        CtDataVo ctDataVo1 = new CtDataVo();
        ctDataVo1.setName("法币交易订单");
        //法币交易订单数量（包含付款，完成）
//        Long fk = censusMapper.fbCount("PAYMENT",sysIds);
        Long wc = censusMapper.fbCount("FINISH",sysIds);
        ctDataVo1.setCount(wc);
        ctDataVo1.setPath("/fack/otcOrderPrice");
        return AjaxResult.success(ctDataVo1);
    }

    /**
     * 法币交易订单金额
     */
    @GetMapping("/fbAmountData")
    public AjaxResult fbAmountData() {

        List<String> sysIds = getSysIdList();
        CtDataVo ctDataVo1 = new CtDataVo();
        CtDataVo ctDataVo2 = new CtDataVo();
        ctDataVo1.setName("法币交易购买金额");
//        BigDecimal fbgmAmount = censusMapper.fbAmountTotalPrice("PAYMENT",null,sysIds);
        BigDecimal fbgmAmount2 = censusMapper.fbAmountTotalPrice("FINISH",null,sysIds);
//        BigDecimal fbgmAmount3 = censusMapper.fbAmountTotalPrice("PAYMENT",1,sysIds);
        BigDecimal fbgmAmount4 = censusMapper.fbAmountTotalPrice("FINISH",1,sysIds);
        List<Map> fbgmList = new ArrayList<>();
        Map<String,Object> fbgm1 = new HashMap<>();
        Map<String,Object> fbgm2 = new HashMap<>();
        fbgm1.put("name","总：");
        fbgm1.put("amount",fbgmAmount2);
        fbgm2.put("name","日：");
        fbgm2.put("amount",fbgmAmount4);
        fbgmList.add(fbgm1);
        fbgmList.add(fbgm2);
        ctDataVo1.setItems(fbgmList);

        ctDataVo2.setName("法币交易出售金额");
//        BigDecimal fbcsAmount = censusMapper.fbAmountPrice("PAYMENT",null,sysIds);
        BigDecimal fbcsAmount2 = censusMapper.fbAmountPrice("FINISH",null,sysIds);
//        BigDecimal fbcsAmount3 = censusMapper.fbAmountPrice("PAYMENT",1,sysIds);
        BigDecimal fbcsAmount4 = censusMapper.fbAmountPrice("FINISH",1,sysIds);
        List<Map> fbcsList = new ArrayList<>();
        Map<String,Object> fbcs1 = new HashMap<>();
        Map<String,Object> fbcs2 = new HashMap<>();
        fbcs1.put("name","总：");
        fbcs1.put("amount",fbcsAmount2);
        fbcs2.put("name","日：");
        fbcs2.put("amount",fbcsAmount4);
        fbcsList.add(fbcs1);
        fbcsList.add(fbcs2);
        ctDataVo2.setItems(fbcsList);

        List<CtDataVo> list = new ArrayList<>();
        list.add(ctDataVo1);
        list.add(ctDataVo2);
        return AjaxResult.success(list);


    }
    /**
     * 需要跳转数据
     */
    @GetMapping("/tzData")
    public AjaxResult tzData(){
        List<String> sysIds = getSysIdList();
        CtDataVo ctDataVo1 = new CtDataVo();
        CtDataVo ctDataVo2 = new CtDataVo();
        CtDataVo ctDataVo3 = new CtDataVo();
        ctDataVo1.setName("充值待审核");
        ctDataVo2.setName("提现待审核");
        ctDataVo3.setName("认证待审核");

        ctDataVo1.setCount(censusMapper.rechargeCount(1,null,sysIds));
        ctDataVo2.setCount(censusMapper.withdrawCount("CREATE",null,sysIds));
        ctDataVo3.setCount(censusMapper.memberCount(sysIds));

        ctDataVo1.setPath("/ctb/memberRecharge");
        ctDataVo2.setPath("/ctb/extractCoin");
        ctDataVo3.setPath("/bus/approve");

        List<CtDataVo> list = new ArrayList<>();
        list.add(ctDataVo1);
        list.add(ctDataVo2);
        list.add(ctDataVo3);
        return AjaxResult.success(list);
    }
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 充值提示
     */
    @GetMapping("/chongzhi")
    public AjaxResult chongzhi(){

        TMemberRecharge tExtractCoin = censusMapper.recCount(getSysIdList());
        TkDto tkDto = new TkDto();
        tkDto.setPath("/ctb/memberRecharge");
        tkDto.setCount(censusMapper.recCount2(getSysIdList()));
        String key = getKey("chongti");
        if(null!=tExtractCoin){
            Long id= (Long) redisTemplate.opsForValue().get(key);
            if(id==null||!id.equals(tExtractCoin.getId())){
                redisTemplate.opsForValue().set(key,tExtractCoin.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一笔充值订单提交，请前往处理！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }
    /**
     * 提现提示
     */
    @GetMapping("/tixian")
    public AjaxResult tixian(){
        TExtractCoin tExtractCoin = censusMapper.widCount(getSysIdList());
        TkDto tkDto = new TkDto();
        tkDto.setPath("/ctb/extractCoin");
        tkDto.setCount(censusMapper.widCount2(getSysIdList()));
        String key = getKey("tixian");
        if(null!=tExtractCoin){
            String id= (String) redisTemplate.opsForValue().get(key);
            if(id==null||!id.equals(tExtractCoin.getId())){
                redisTemplate.opsForValue().set(key,tExtractCoin.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一笔提现订单提交，请前往处理！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }
    /**
     * 认证提示
     */
    @GetMapping("/renzheng")
    public AjaxResult renzheng(){
        Approve approve = censusMapper.approveCount(getSysIdList());
        TkDto tkDto = new TkDto();
        tkDto.setPath("/bus/approve");
        tkDto.setCount(censusMapper.approveCount2(getSysIdList()));
        String key = getKey("renzheng");
        if(null!=approve){
            String id= (String) redisTemplate.opsForValue().get(key);
            if(id==null||!id.equals(approve.getId())){
                redisTemplate.opsForValue().set(key,approve.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一个认证待处理，请前往！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }

    /**
     * 法币提示
     */
    @GetMapping("/fbHint")
    public AjaxResult fb(){
        TkDto tkDto = new TkDto();
        tkDto.setPath("/fack/otcOrderPrice");
        tkDto.setCount(censusMapper.fbOne2(getSysIdList()));
        TOtcOrderPrice tOtcOrderPrice = censusMapper.fbOne(getSysIdList());
        String key = getKey("fbts");
        if (null != tOtcOrderPrice){
            String id= (String) redisTemplate.opsForValue().get(key);
            if(id==null||!id.equals(tOtcOrderPrice.getId())){
                redisTemplate.opsForValue().set(key,tOtcOrderPrice.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一个法币交易待处理，请前往！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }

    /**
     * 币币提示
     */
    @GetMapping("/bbHint")
    public AjaxResult bb(){
        TkDto tkDto = new TkDto();
        tkDto.setPath("/bbq/entrust");
        tkDto.setCount(censusMapper.bbOne2(getSysIdList()));
        TEntrust tEntrust = censusMapper.bbOne(getSysIdList());
        String key = getKey("bbts");
        if (null != tEntrust){
            String id= (String) redisTemplate.opsForValue().get(key);
            if(id==null||!id.equals(tEntrust.getId())){
                redisTemplate.opsForValue().set(key,tEntrust.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一个币币交易待处理，请前往！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }

    /**
     * 秒合约提示
     */
    @GetMapping("/mhyHint")
    public AjaxResult mhy(){
        TkDto tkDto = new TkDto();
        tkDto.setPath("/mhy/secondsBetLog");
        tkDto.setCount(censusMapper.mhyOne2(getSysIdList()));
        TSecondsBetLog tSecondsBetLog = censusMapper.mhyOne(getSysIdList());
        String key = getKey("mhyts");
        if (null != tSecondsBetLog){
            Object id= redisTemplate.opsForValue().get(key);
            if(null == id || !id.equals(tSecondsBetLog.getId())){
                redisTemplate.opsForValue().set(key,tSecondsBetLog.getId());
                tkDto.setOpen(true);
                return AjaxResult.success("有一个秒合约待处理，请前往！！！",tkDto);
            }
        }
        tkDto.setOpen(false);
        return AjaxResult.success("不需要处理",tkDto);
    }
    @Autowired
    private IChatService iChatService;
    /**
     * 客服推送
     */
    @GetMapping("/chatTs/{type}")
    public AjaxResult chatTs(@PathVariable Integer type){

        String key = getKey("zkf-speck");
        UserSessionDocument userSessionDocument = iChatService.getOne();
        if (null != userSessionDocument){
            Object id= redisTemplate.opsForValue().get(key);
            if(null == id || !id.equals(userSessionDocument.getLastTime().getTime())){
                redisTemplate.opsForValue().set(key,userSessionDocument.getLastTime().getTime());
            }
        }
        return AjaxResult.success("操作结果",iChatService.getOne());
    }
    @GetMapping("/mp3")
    @CrossOrigin
    public void mp3(HttpServletRequest request, HttpServletResponse response) {
        File file = new File("D:/Pro/y913.mp3");
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] buf = new byte[100];
            int len_l = 0;
            in = Files.newInputStream(file.toPath());
            showAvailableBytes(in);
            request.setCharacterEncoding("UTF-8");//解决乱码
            response.setContentType("text/html;charset=UTF-8");//解决乱码
            response.setHeader("Content-type", "text/html; charset=UTF-8");
            response.setHeader("Content-Type", "video/mp4");
            OutputStream out = response.getOutputStream();
            len_l = in.read(buf);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while (len_l != -1) {
                System.out.write(buf, 0, len_l);
                out.write(buf,0,len_l);
                len_l = in.read(buf);
            }
            out.flush();
            out.close();
            in.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private String getKey(String rule){
        return rule + "-" + getUserId() + "-" + getUsername();
    }
}
