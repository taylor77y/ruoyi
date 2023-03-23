package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TShareImg;

/**
 * 分享图片Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ITShareImgService 
{
    /**
     * 查询分享图片
     * 
     * @param id 分享图片主键
     * @return 分享图片
     */
    public TShareImg selectTShareImgById(String id);

    /**
     * 查询分享图片列表
     * 
     * @param tShareImg 分享图片
     * @return 分享图片集合
     */
    public List<TShareImg> selectTShareImgList(TShareImg tShareImg);

    /**
     * 新增分享图片
     * 
     * @param tShareImg 分享图片
     * @return 结果
     */
    public int insertTShareImg(TShareImg tShareImg);

    /**
     * 修改分享图片
     * 
     * @param tShareImg 分享图片
     * @return 结果
     */
    public int updateTShareImg(TShareImg tShareImg);

    /**
     * 批量删除分享图片
     * 
     * @param ids 需要删除的分享图片主键集合
     * @return 结果
     */
    public int deleteTShareImgByIds(String[] ids);

    /**
     * 删除分享图片信息
     * 
     * @param id 分享图片主键
     * @return 结果
     */
    public int deleteTShareImgById(String id);
}
