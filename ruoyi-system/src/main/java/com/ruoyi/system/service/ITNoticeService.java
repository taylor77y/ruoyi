package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TNotice;

/**
 * 币币-公告Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ITNoticeService 
{
    /**
     * 查询币币-公告
     * 
     * @param id 币币-公告主键
     * @return 币币-公告
     */
    public TNotice selectTNoticeById(String id);

    /**
     * 查询币币-公告列表
     * 
     * @param tNotice 币币-公告
     * @return 币币-公告集合
     */
    public List<TNotice> selectTNoticeList(TNotice tNotice);

    /**
     * 新增币币-公告
     * 
     * @param tNotice 币币-公告
     * @return 结果
     */
    public int insertTNotice(TNotice tNotice);

    /**
     * 修改币币-公告
     * 
     * @param tNotice 币币-公告
     * @return 结果
     */
    public int updateTNotice(TNotice tNotice);

    /**
     * 批量删除币币-公告
     * 
     * @param ids 需要删除的币币-公告主键集合
     * @return 结果
     */
    public int deleteTNoticeByIds(String[] ids);

    /**
     * 删除币币-公告信息
     * 
     * @param id 币币-公告主键
     * @return 结果
     */
    public int deleteTNoticeById(String id);
}
