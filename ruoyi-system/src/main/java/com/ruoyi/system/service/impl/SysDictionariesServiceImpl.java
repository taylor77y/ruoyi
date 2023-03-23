package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDictionariesMapper;
import com.ruoyi.system.domain.SysDictionaries;
import com.ruoyi.system.service.ISysDictionariesService;

/**
 *  充提配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
@Service
public class SysDictionariesServiceImpl implements ISysDictionariesService 
{
    @Autowired
    private SysDictionariesMapper sysDictionariesMapper;

    /**
     * 查询 充提配置
     * 
     * @param id  充提配置主键
     * @return  充提配置
     */
    @Override
    public SysDictionaries selectSysDictionariesById(Long id)
    {
        return sysDictionariesMapper.selectSysDictionariesById(id);
    }

    /**
     * 查询 充提配置列表
     * 
     * @param sysDictionaries  充提配置
     * @return  充提配置
     */
    @Override
    public List<SysDictionaries> selectSysDictionariesList(SysDictionaries sysDictionaries)
    {
        return sysDictionariesMapper.selectSysDictionariesList(sysDictionaries);
    }

    /**
     * 新增 充提配置
     * 
     * @param sysDictionaries  充提配置
     * @return 结果
     */
    @Override
    public int insertSysDictionaries(SysDictionaries sysDictionaries)
    {
        sysDictionaries.setCreateTime(DateUtils.getNowDate());
        return sysDictionariesMapper.insertSysDictionaries(sysDictionaries);
    }

    /**
     * 修改 充提配置
     * 
     * @param sysDictionaries  充提配置
     * @return 结果
     */
    @Override
    public int updateSysDictionaries(SysDictionaries sysDictionaries)
    {
        sysDictionaries.setUpdateTime(DateUtils.getNowDate());
        return sysDictionariesMapper.updateSysDictionaries(sysDictionaries);
    }

    /**
     * 批量删除 充提配置
     * 
     * @param ids 需要删除的 充提配置主键
     * @return 结果
     */
    @Override
    public int deleteSysDictionariesByIds(Long[] ids)
    {
        return sysDictionariesMapper.deleteSysDictionariesByIds(ids);
    }

    /**
     * 删除 充提配置信息
     * 
     * @param id  充提配置主键
     * @return 结果
     */
    @Override
    public int deleteSysDictionariesById(Long id)
    {
        return sysDictionariesMapper.deleteSysDictionariesById(id);
    }
}
