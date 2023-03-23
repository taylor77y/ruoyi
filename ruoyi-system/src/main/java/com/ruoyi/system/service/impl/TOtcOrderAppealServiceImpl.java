package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOtcOrderAppealMapper;
import com.ruoyi.system.domain.TOtcOrderAppeal;
import com.ruoyi.system.service.ITOtcOrderAppealService;

/**
 * Otc申诉Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TOtcOrderAppealServiceImpl implements ITOtcOrderAppealService 
{
    @Autowired
    private TOtcOrderAppealMapper tOtcOrderAppealMapper;

    /**
     * 查询Otc申诉
     * 
     * @param id Otc申诉主键
     * @return Otc申诉
     */
    @Override
    public TOtcOrderAppeal selectTOtcOrderAppealById(String id)
    {
        return tOtcOrderAppealMapper.selectTOtcOrderAppealById(id);
    }

    /**
     * 查询Otc申诉列表
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return Otc申诉
     */
    @Override
    public List<TOtcOrderAppeal> selectTOtcOrderAppealList(TOtcOrderAppeal tOtcOrderAppeal)
    {
        return tOtcOrderAppealMapper.selectTOtcOrderAppealList(tOtcOrderAppeal);
    }

    /**
     * 新增Otc申诉
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return 结果
     */
    @Override
    public int insertTOtcOrderAppeal(TOtcOrderAppeal tOtcOrderAppeal)
    {
        tOtcOrderAppeal.setCreateTime(DateUtils.getNowDate());
        return tOtcOrderAppealMapper.insertTOtcOrderAppeal(tOtcOrderAppeal);
    }

    /**
     * 修改Otc申诉
     * 
     * @param tOtcOrderAppeal Otc申诉
     * @return 结果
     */
    @Override
    public int updateTOtcOrderAppeal(TOtcOrderAppeal tOtcOrderAppeal)
    {
        tOtcOrderAppeal.setUpdateTime(DateUtils.getNowDate());
        return tOtcOrderAppealMapper.updateTOtcOrderAppeal(tOtcOrderAppeal);
    }

    /**
     * 批量删除Otc申诉
     * 
     * @param ids 需要删除的Otc申诉主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderAppealByIds(String[] ids)
    {
        return tOtcOrderAppealMapper.deleteTOtcOrderAppealByIds(ids);
    }

    /**
     * 删除Otc申诉信息
     * 
     * @param id Otc申诉主键
     * @return 结果
     */
    @Override
    public int deleteTOtcOrderAppealById(String id)
    {
        return tOtcOrderAppealMapper.deleteTOtcOrderAppealById(id);
    }
}
