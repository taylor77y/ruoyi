package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TContractOrder;

/**
 * 合约订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TContractOrderMapper 
{
    /**
     * 查询合约订单
     * 
     * @param id 合约订单主键
     * @return 合约订单
     */
    public TContractOrder selectTContractOrderById(String id);

    /**
     * 查询合约订单列表
     * 
     * @param tContractOrder 合约订单
     * @return 合约订单集合
     */
    public List<TContractOrder> selectTContractOrderList(TContractOrder tContractOrder);

    /**
     * 新增合约订单
     * 
     * @param tContractOrder 合约订单
     * @return 结果
     */
    public int insertTContractOrder(TContractOrder tContractOrder);

    /**
     * 修改合约订单
     * 
     * @param tContractOrder 合约订单
     * @return 结果
     */
    public int updateTContractOrder(TContractOrder tContractOrder);

    /**
     * 删除合约订单
     * 
     * @param id 合约订单主键
     * @return 结果
     */
    public int deleteTContractOrderById(String id);

    /**
     * 批量删除合约订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTContractOrderByIds(String[] ids);
}
