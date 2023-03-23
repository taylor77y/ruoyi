package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBanner;

/**
 * 币币-banner图Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TBannerMapper 
{
    /**
     * 查询币币-banner图
     * 
     * @param id 币币-banner图主键
     * @return 币币-banner图
     */
    public TBanner selectTBannerById(String id);

    /**
     * 查询币币-banner图列表
     * 
     * @param tBanner 币币-banner图
     * @return 币币-banner图集合
     */
    public List<TBanner> selectTBannerList(TBanner tBanner);

    /**
     * 新增币币-banner图
     * 
     * @param tBanner 币币-banner图
     * @return 结果
     */
    public int insertTBanner(TBanner tBanner);

    /**
     * 修改币币-banner图
     * 
     * @param tBanner 币币-banner图
     * @return 结果
     */
    public int updateTBanner(TBanner tBanner);

    /**
     * 删除币币-banner图
     * 
     * @param id 币币-banner图主键
     * @return 结果
     */
    public int deleteTBannerById(String id);

    /**
     * 批量删除币币-banner图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBannerByIds(String[] ids);
}
