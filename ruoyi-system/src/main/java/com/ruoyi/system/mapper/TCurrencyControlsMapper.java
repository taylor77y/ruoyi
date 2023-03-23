package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.kline.TCurrencyControls;

import java.util.List;

/**
 * 自发币控制Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface TCurrencyControlsMapper 
{
    /**
     * 查询自发币控制
     * 
     * @param id 自发币控制主键
     * @return 自发币控制
     */
    public TCurrencyControls selectTCurrencyControlsById(Long id);

    /**
     * 查询自发币控制列表
     * 
     * @param tCurrencyControls 自发币控制
     * @return 自发币控制集合
     */
    public List<TCurrencyControls> selectTCurrencyControlsList(TCurrencyControls tCurrencyControls);

    /**
     * 新增自发币控制
     * 
     * @param tCurrencyControls 自发币控制
     * @return 结果
     */
    public int insertTCurrencyControls(TCurrencyControls tCurrencyControls);

    /**
     * 修改自发币控制
     * 
     * @param tCurrencyControls 自发币控制
     * @return 结果
     */
    public int updateTCurrencyControls(TCurrencyControls tCurrencyControls);

    /**
     * 删除自发币控制
     * 
     * @param id 自发币控制主键
     * @return 结果
     */
    public int deleteTCurrencyControlsById(Long id);

    /**
     * 批量删除自发币控制
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTCurrencyControlsByIds(Long[] ids);
}
