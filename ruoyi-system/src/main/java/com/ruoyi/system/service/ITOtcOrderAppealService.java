package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TOtcOrderAppeal;

/**
 * Otc申诉Service接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface ITOtcOrderAppealService 
{
    /**
     * 查询Otc申诉
     * 
     * @param id Otc申诉主键
     * @return Otc申诉
     */
    public TOtcOrderAppeal selectTOtcOrderAppealById(String id);

    /**
     * 查询Otc申诉列表
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return Otc申诉集合
     */
    public List<TOtcOrderAppeal> selectTOtcOrderAppealList(TOtcOrderAppeal tOtcOrderAppeal);

    /**
     * 新增Otc申诉
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return 结果
     */
    public int insertTOtcOrderAppeal(TOtcOrderAppeal tOtcOrderAppeal);

    /**
     * 修改Otc申诉
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return 结果
     */
    public int updateTOtcOrderAppeal(TOtcOrderAppeal tOtcOrderAppeal);

    /**
     * 批量删除Otc申诉
     * 
     * @param ids 需要删除的Otc申诉主键集合
     * @return 结果
     */
    public int deleteTOtcOrderAppealByIds(String[] ids);

    /**
     * 删除Otc申诉信息
     * 
     * @param id Otc申诉主键
     * @return 结果
     */
    public int deleteTOtcOrderAppealById(String id);
}
