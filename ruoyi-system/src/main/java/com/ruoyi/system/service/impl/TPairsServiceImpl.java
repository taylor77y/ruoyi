package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPairsMapper;
import com.ruoyi.system.domain.TPairs;
import com.ruoyi.system.service.ITPairsService;

/**
 * 交易对配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TPairsServiceImpl implements ITPairsService 
{
    @Autowired
    private TPairsMapper tPairsMapper;

    @Value("${img.path-logo}")
    private String IMG_PATH;
    /**
     * 查询交易对配置
     * 
     * @param id 交易对配置主键
     * @return 交易对配置
     */
    @Override
    public TPairs selectTPairsById(String id)
    {
        return tPairsMapper.selectTPairsById(id);
    }

    /**
     * 查询交易对配置列表
     * 
     * @param tPairs 交易对配置
     * @return 交易对配置
     */
    @Override
    public List<TPairs> selectTPairsList(TPairs tPairs)
    {
        List<TPairs> list = tPairsMapper.selectTPairsList(tPairs);
        if (list.size()>0){
            for (TPairs pairs : list) {
                if (StringUtils.isNotEmpty(pairs.getImage())){
                    pairs.setImage(IMG_PATH+pairs.getImage());
                }
            }
        }
        return list;
    }

    /**
     * 新增交易对配置
     * 
     * @param tPairs 交易对配置
     * @return 结果
     */
    @Override
    public int insertTPairs(TPairs tPairs)
    {
        tPairs.setCreateTime(DateUtils.getNowDate());
        return tPairsMapper.insertTPairs(tPairs);
    }

    /**
     * 修改交易对配置
     * 
     * @param tPairs 交易对配置
     * @return 结果
     */
    @Override
    public int updateTPairs(TPairs tPairs)
    {
        tPairs.setUpdateTime(DateUtils.getNowDate());
        return tPairsMapper.updateTPairs(tPairs);
    }

    /**
     * 批量删除交易对配置
     * 
     * @param ids 需要删除的交易对配置主键
     * @return 结果
     */
    @Override
    public int deleteTPairsByIds(String[] ids)
    {
        return tPairsMapper.deleteTPairsByIds(ids);
    }

    /**
     * 删除交易对配置信息
     * 
     * @param id 交易对配置主键
     * @return 结果
     */
    @Override
    public int deleteTPairsById(String id)
    {
        return tPairsMapper.deleteTPairsById(id);
    }
}
