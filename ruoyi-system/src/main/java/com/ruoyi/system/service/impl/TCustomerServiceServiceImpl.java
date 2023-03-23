package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TCustomerServiceMapper;
import com.ruoyi.system.domain.TCustomerService;
import com.ruoyi.system.service.ITCustomerServiceService;

/**
 * 客服链接配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class TCustomerServiceServiceImpl implements ITCustomerServiceService 
{
    @Autowired
    private TCustomerServiceMapper tCustomerServiceMapper;

    /**
     * 查询客服链接配置
     * 
     * @param id 客服链接配置主键
     * @return 客服链接配置
     */
    @Override
    public TCustomerService selectTCustomerServiceById(Long id)
    {
        return tCustomerServiceMapper.selectTCustomerServiceById(id);
    }

    /**
     * 查询客服链接配置列表
     * 
     * @param tCustomerService 客服链接配置
     * @return 客服链接配置
     */
    @Override
    public List<TCustomerService> selectTCustomerServiceList(TCustomerService tCustomerService)
    {
        return tCustomerServiceMapper.selectTCustomerServiceList(tCustomerService);
    }

    /**
     * 新增客服链接配置
     * 
     * @param tCustomerService 客服链接配置
     * @return 结果
     */
    @Override
    public int insertTCustomerService(TCustomerService tCustomerService)
    {
        tCustomerService.setCreateTime(DateUtils.getNowDate());
        return tCustomerServiceMapper.insertTCustomerService(tCustomerService);
    }

    /**
     * 修改客服链接配置
     * 
     * @param tCustomerService 客服链接配置
     * @return 结果
     */
    @Override
    public int updateTCustomerService(TCustomerService tCustomerService)
    {
        return tCustomerServiceMapper.updateTCustomerService(tCustomerService);
    }

    /**
     * 批量删除客服链接配置
     * 
     * @param ids 需要删除的客服链接配置主键
     * @return 结果
     */
    @Override
    public int deleteTCustomerServiceByIds(Long[] ids)
    {
        return tCustomerServiceMapper.deleteTCustomerServiceByIds(ids);
    }

    /**
     * 删除客服链接配置信息
     * 
     * @param id 客服链接配置主键
     * @return 结果
     */
    @Override
    public int deleteTCustomerServiceById(Long id)
    {
        return tCustomerServiceMapper.deleteTCustomerServiceById(id);
    }
}
