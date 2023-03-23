package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TShareImgMapper;
import com.ruoyi.system.domain.TShareImg;
import com.ruoyi.system.service.ITShareImgService;

/**
 * 分享图片Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TShareImgServiceImpl implements ITShareImgService 
{
    @Autowired
    private TShareImgMapper tShareImgMapper;

    /**
     * 查询分享图片
     * 
     * @param id 分享图片主键
     * @return 分享图片
     */
    @Override
    public TShareImg selectTShareImgById(String id)
    {
        return tShareImgMapper.selectTShareImgById(id);
    }

    /**
     * 查询分享图片列表
     * 
     * @param tShareImg 分享图片
     * @return 分享图片
     */
    @Override
    public List<TShareImg> selectTShareImgList(TShareImg tShareImg)
    {
        return tShareImgMapper.selectTShareImgList(tShareImg);
    }

    /**
     * 新增分享图片
     * 
     * @param tShareImg 分享图片
     * @return 结果
     */
    @Override
    public int insertTShareImg(TShareImg tShareImg)
    {
        tShareImg.setCreateTime(DateUtils.getNowDate());
        return tShareImgMapper.insertTShareImg(tShareImg);
    }

    /**
     * 修改分享图片
     * 
     * @param tShareImg 分享图片
     * @return 结果
     */
    @Override
    public int updateTShareImg(TShareImg tShareImg)
    {
        tShareImg.setUpdateTime(DateUtils.getNowDate());
        return tShareImgMapper.updateTShareImg(tShareImg);
    }

    /**
     * 批量删除分享图片
     * 
     * @param ids 需要删除的分享图片主键
     * @return 结果
     */
    @Override
    public int deleteTShareImgByIds(String[] ids)
    {
        return tShareImgMapper.deleteTShareImgByIds(ids);
    }

    /**
     * 删除分享图片信息
     * 
     * @param id 分享图片主键
     * @return 结果
     */
    @Override
    public int deleteTShareImgById(String id)
    {
        return tShareImgMapper.deleteTShareImgById(id);
    }
}
