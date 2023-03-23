package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBannerMapper;
import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.service.ITBannerService;

/**
 * 币币-banner图Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TBannerServiceImpl implements ITBannerService 
{
    @Autowired
    private TBannerMapper tBannerMapper;

    /**
     * 查询币币-banner图
     * 
     * @param id 币币-banner图主键
     * @return 币币-banner图
     */
    @Override
    public TBanner selectTBannerById(String id)
    {
        return tBannerMapper.selectTBannerById(id);
    }

    @Value("${img.path-suffix}")
    private String IMG_PATH;
    /**
     * 查询币币-banner图列表
     * 
     * @param tBanner 币币-banner图
     * @return 币币-banner图
     */
    @Override
    public List<TBanner> selectTBannerList(TBanner tBanner)
    {
        List<TBanner> list = tBannerMapper.selectTBannerList(tBanner);
        if (list.size()>0) {
            for (TBanner banner : list) {
                banner.setBannerUrl(IMG_PATH + banner.getBannerUrl());
            }
        }
        return list;
    }

    /**
     * 新增币币-banner图
     * 
     * @param tBanner 币币-banner图
     * @return 结果
     */
    @Override
    public int insertTBanner(TBanner tBanner)
    {
        tBanner.setCreateTime(DateUtils.getNowDate());
        return tBannerMapper.insertTBanner(tBanner);
    }

    /**
     * 修改币币-banner图
     * 
     * @param tBanner 币币-banner图
     * @return 结果
     */
    @Override
    public int updateTBanner(TBanner tBanner)
    {
        tBanner.setUpdateTime(DateUtils.getNowDate());
        return tBannerMapper.updateTBanner(tBanner);
    }

    /**
     * 批量删除币币-banner图
     * 
     * @param ids 需要删除的币币-banner图主键
     * @return 结果
     */
    @Override
    public int deleteTBannerByIds(String[] ids)
    {
        return tBannerMapper.deleteTBannerByIds(ids);
    }

    /**
     * 删除币币-banner图信息
     * 
     * @param id 币币-banner图主键
     * @return 结果
     */
    @Override
    public int deleteTBannerById(String id)
    {
        return tBannerMapper.deleteTBannerById(id);
    }
}
