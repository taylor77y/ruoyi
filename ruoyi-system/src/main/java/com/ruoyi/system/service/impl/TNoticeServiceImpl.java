package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TNoticeMapper;
import com.ruoyi.system.domain.TNotice;
import com.ruoyi.system.service.ITNoticeService;

/**
 * 币币-公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TNoticeServiceImpl implements ITNoticeService 
{
    @Autowired
    private TNoticeMapper tNoticeMapper;

    /**
     * 查询币币-公告
     * 
     * @param id 币币-公告主键
     * @return 币币-公告
     */
    @Override
    public TNotice selectTNoticeById(String id)
    {
        return tNoticeMapper.selectTNoticeById(id);
    }

    /**
     * 查询币币-公告列表
     * 
     * @param tNotice 币币-公告
     * @return 币币-公告
     */
    @Override
    public List<TNotice> selectTNoticeList(TNotice tNotice)
    {
        return tNoticeMapper.selectTNoticeList(tNotice);
    }

    /**
     * 新增币币-公告
     * 
     * @param tNotice 币币-公告
     * @return 结果
     */
    @Override
    public int insertTNotice(TNotice tNotice)
    {
        tNotice.setCreateTime(DateUtils.getNowDate());
        return tNoticeMapper.insertTNotice(tNotice);
    }

    /**
     * 修改币币-公告
     * 
     * @param tNotice 币币-公告
     * @return 结果
     */
    @Override
    public int updateTNotice(TNotice tNotice)
    {
        tNotice.setUpdateTime(DateUtils.getNowDate());
        return tNoticeMapper.updateTNotice(tNotice);
    }

    /**
     * 批量删除币币-公告
     * 
     * @param ids 需要删除的币币-公告主键
     * @return 结果
     */
    @Override
    public int deleteTNoticeByIds(String[] ids)
    {
        return tNoticeMapper.deleteTNoticeByIds(ids);
    }

    /**
     * 删除币币-公告信息
     * 
     * @param id 币币-公告主键
     * @return 结果
     */
    @Override
    public int deleteTNoticeById(String id)
    {
        return tNoticeMapper.deleteTNoticeById(id);
    }
}
