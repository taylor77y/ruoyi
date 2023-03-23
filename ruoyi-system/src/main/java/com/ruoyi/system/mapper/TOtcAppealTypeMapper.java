package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TOtcAppealType;

/**
 * OTC申诉类型Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TOtcAppealTypeMapper 
{
    /**
     * 查询OTC申诉类型
     * 
     * @param id OTC申诉类型主键
     * @return OTC申诉类型
     */
    public TOtcAppealType selectTOtcAppealTypeById(Integer id);

    /**
     * 查询OTC申诉类型列表
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return OTC申诉类型集合
     */
    public List<TOtcAppealType> selectTOtcAppealTypeList(TOtcAppealType tOtcAppealType);

    /**
     * 新增OTC申诉类型
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return 结果
     */
    public int insertTOtcAppealType(TOtcAppealType tOtcAppealType);

    /**
     * 修改OTC申诉类型
     * 
     * @param tOtcAppealType OTC申诉类型
     * @return 结果
     */
    public int updateTOtcAppealType(TOtcAppealType tOtcAppealType);

    /**
     * 删除OTC申诉类型
     * 
     * @param id OTC申诉类型主键
     * @return 结果
     */
    public int deleteTOtcAppealTypeById(Integer id);

    /**
     * 批量删除OTC申诉类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTOtcAppealTypeByIds(Integer[] ids);
}
