package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOtcAppealTypeMapper;
import com.ruoyi.system.domain.TOtcAppealType;
import com.ruoyi.system.service.ITOtcAppealTypeService;

/**
 * OTC申诉类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TOtcAppealTypeServiceImpl implements ITOtcAppealTypeService 
{
    @Autowired
    private TOtcAppealTypeMapper tOtcAppealTypeMapper;

    /**
     * 查询OTC申诉类型
     * 
     * @param id OTC申诉类型主键
     * @return OTC申诉类型
     */
    @Override
    public TOtcAppealType selectTOtcAppealTypeById(Integer id)
    {
        return tOtcAppealTypeMapper.selectTOtcAppealTypeById(id);
    }

    /**
     * 查询OTC申诉类型列表
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return OTC申诉类型
     */
    @Override
    public List<TOtcAppealType> selectTOtcAppealTypeList(TOtcAppealType tOtcAppealType)
    {
        return tOtcAppealTypeMapper.selectTOtcAppealTypeList(tOtcAppealType);
    }

    /**
     * 新增OTC申诉类型
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return 结果
     */
    @Override
    public int insertTOtcAppealType(TOtcAppealType tOtcAppealType)
    {
        tOtcAppealType.setCreateTime(DateUtils.getNowDate());
        return tOtcAppealTypeMapper.insertTOtcAppealType(tOtcAppealType);
    }

    /**
     * 修改OTC申诉类型
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return 结果
     */
    @Override
    public int updateTOtcAppealType(TOtcAppealType tOtcAppealType)
    {
        return tOtcAppealTypeMapper.updateTOtcAppealType(tOtcAppealType);
    }

    /**
     * 批量删除OTC申诉类型
     * 
     * @param ids 需要删除的OTC申诉类型主键
     * @return 结果
     */
    @Override
    public int deleteTOtcAppealTypeByIds(Integer[] ids)
    {
        return tOtcAppealTypeMapper.deleteTOtcAppealTypeByIds(ids);
    }

    /**
     * 删除OTC申诉类型信息
     * 
     * @param id OTC申诉类型主键
     * @return 结果
     */
    @Override
    public int deleteTOtcAppealTypeById(Integer id)
    {
        return tOtcAppealTypeMapper.deleteTOtcAppealTypeById(id);
    }
}
