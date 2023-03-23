package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TCustomerService;

/**
 * 客服链接配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface ITCustomerServiceService 
{
    /**
     * 查询客服链接配置
     * 
     * @param id 客服链接配置主键
     * @return 客服链接配置
     */
    public TCustomerService selectTCustomerServiceById(Long id);

    /**
     * 查询客服链接配置列表
     * 
     * @param tCustomerService 客服链接配置
     * @return 客服链接配置集合
     */
    public List<TCustomerService> selectTCustomerServiceList(TCustomerService tCustomerService);

    /**
     * 新增客服链接配置
     * 
     * @param tCustomerService 客服链接配置
     * @return 结果
     */
    public int insertTCustomerService(TCustomerService tCustomerService);

    /**
     * 修改客服链接配置
     * 
     * @param tCustomerService 客服链接配置
     * @return 结果
     */
    public int updateTCustomerService(TCustomerService tCustomerService);

    /**
     * 批量删除客服链接配置
     * 
     * @param ids 需要删除的客服链接配置主键集合
     * @return 结果
     */
    public int deleteTCustomerServiceByIds(Long[] ids);

    /**
     * 删除客服链接配置信息
     * 
     * @param id 客服链接配置主键
     * @return 结果
     */
    public int deleteTCustomerServiceById(Long id);
}
