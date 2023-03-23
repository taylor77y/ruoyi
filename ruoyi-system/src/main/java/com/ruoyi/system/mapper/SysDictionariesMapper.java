package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysDictionaries;

/**
 *  充提配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface SysDictionariesMapper 
{
    /**
     * 查询 充提配置
     * 
     * @param id  充提配置主键
     * @return  充提配置
     */
    public SysDictionaries selectSysDictionariesById(Long id);

    /**
     * 查询 充提配置列表
     * 
     * @param sysDictionaries  充提配置
     * @return  充提配置集合
     */
    public List<SysDictionaries> selectSysDictionariesList(SysDictionaries sysDictionaries);

    /**
     * 新增 充提配置
     * 
     * @param sysDictionaries  充提配置
     * @return 结果
     */
    public int insertSysDictionaries(SysDictionaries sysDictionaries);

    /**
     * 修改 充提配置
     * 
     * @param sysDictionaries  充提配置
     * @return 结果
     */
    public int updateSysDictionaries(SysDictionaries sysDictionaries);

    /**
     * 删除 充提配置
     * 
     * @param id  充提配置主键
     * @return 结果
     */
    public int deleteSysDictionariesById(Long id);

    /**
     * 批量删除 充提配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDictionariesByIds(Long[] ids);
}
