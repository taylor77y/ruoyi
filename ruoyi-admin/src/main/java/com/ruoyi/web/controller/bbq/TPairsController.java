package com.ruoyi.web.controller.bbq;

import java.math.BigDecimal;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.kline.TCurrencyControls;
import com.ruoyi.system.domain.kline.TStagePrice;
import com.ruoyi.system.mapper.TCurrencyControlsMapper;
import com.ruoyi.system.mapper.TKlineDataMapper;
import com.ruoyi.system.mapper.TPairsMapper;
import com.ruoyi.system.mapper.TStagePriceMapper;
import com.ruoyi.system.service.ITStagePriceService;
import com.ruoyi.util.ObjToParamsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TPairs;
import com.ruoyi.system.service.ITPairsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 交易对配置Controller
 *
 * @author ruoyi
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/system/pairs")
@Slf4j
public class TPairsController extends BaseController {
    @Autowired
    private ITPairsService tPairsService;

    /**
     * 查询交易对配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:pairs:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPairs tPairs) {
        startPage();
        List<TPairs> list = tPairsService.selectTPairsList(tPairs);
        return getDataTable(list);
    }

    /**
     * 导出交易对配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:pairs:export')")
    @Log(title = "交易对配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPairs tPairs) {
        List<TPairs> list = tPairsService.selectTPairsList(tPairs);
        ExcelUtil<TPairs> util = new ExcelUtil<TPairs>(TPairs.class);
        util.exportExcel(response, list, "交易对配置数据");
    }

    /**
     * 获取交易对配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:pairs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(tPairsService.selectTPairsById(id));
    }

    /**
     * 新增交易对配置
     */
    @PreAuthorize("@ss.hasPermi('system:pairs:add')")
    @Log(title = "交易对配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPairs tPairs) {
        tPairs.setId(UUID.randomUUID().toString());
        return toAjax(tPairsService.insertTPairs(tPairs));
    }

    /**
     * 修改交易对配置
     */
    @PreAuthorize("@ss.hasPermi('system:pairs:edit')")
    @Log(title = "交易对配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPairs tPairs) {
        return toAjax(tPairsService.updateTPairs(tPairs));
    }

    /**
     * 删除交易对配置
     */
    @PreAuthorize("@ss.hasPermi('system:pairs:remove')")
    @Log(title = "交易对配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(tPairsService.deleteTPairsByIds(ids));
    }

    @Autowired
    private TPairsMapper tPairsMapper;

    /**
     * 列表
     */
    @GetMapping("/tokenCurList")
    public AjaxResult tokenCurList() {
        return AjaxResult.success(tPairsMapper.findByAll());
    }

    @Autowired
    private ITStagePriceService itStagePriceService;
    @Autowired
    private TStagePriceMapper tStagePriceMapper;
    @Autowired
    private TKlineDataMapper tKlineDataMapper;

    /**
     * K线数据
     */
    @GetMapping("/kline")
    public AjaxResult kline(String name, String time) {
        TStagePrice tStagePrice = new TStagePrice();
        tStagePrice.setTimeType(time);
        tStagePrice.setTokenCur(name);
        List<TStagePrice> list = itStagePriceService.selectTStagePriceList(tStagePrice);
        Map map = new HashMap();
        List<String> info = new ArrayList<>();
        List<List<BigDecimal>> data = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                TStagePrice res = list.get(i);
                info.add(i + 1 + "");
                List<BigDecimal> mos = new ArrayList<>();
                mos.add(res.getOpen());
                mos.add(res.getClose());
                mos.add(res.getLow());
                mos.add(res.getHigh());
                data.add(mos);
            }
        }
        map.put("info", info);
        map.put("data", data);
        return AjaxResult.success(map);
    }

//    @Value("${kline.url}")
    private String kUrl;
    @Resource
    private TCurrencyControlsMapper tCurrencyControlsMapper;

    /**
     * 控盘提交
     */
    @PostMapping("/batchSub")
    public AjaxResult batchSub(@RequestBody TCurrencyControls tCurrencyControls) {
        tKlineDataMapper.delete(tCurrencyControls.getTokenCur());
        tStagePriceMapper.delete(tCurrencyControls.getTokenCur());
        tCurrencyControlsMapper.updateTCurrencyControls(tCurrencyControls);
        String params = ObjToParamsUtils.change(tCurrencyControls.getClass(), tCurrencyControls);
        String urlNameString = kUrl + "?" + params + "&isClear=true&coin=" + tCurrencyControls.getTokenCur();
        log.info("请求地址:{}", urlNameString);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String res = HttpUtils.sendPost(urlNameString, urlNameString);
                log.info("响应结果:{}", res);
            }
        }).start();
        return AjaxResult.success();
    }
}
