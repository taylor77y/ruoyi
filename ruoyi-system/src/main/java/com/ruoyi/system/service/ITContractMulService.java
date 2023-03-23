package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TContractMul;

/**
 * 合约交易对Service接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface ITContractMulService 
{
    /**
     * 查询合约交易对
     * 
     * @param id 合约交易对主键
     * @return 合约交易对
     */
    public TContractMul selectTContractMulById(String id);

    /**
     * 查询合约交易对列表
     * 
     * @param tContractMul 合约交易对
     * @return 合约交易对集合
     */
    public List<TContractMul> selectTContractMulList(TContractMul tContractMul);

    /**
     * 新增合约交易对
     * 
     * @param tContractMul 合约交易对
     * @return 结果
     */
    public int insertTContractMul(TContractMul tContractMul);

    /**
     * 修改合约交易对
     * 
     * @param tContractMul 合约交易对
     * @return 结果
     */
    public int updateTContractMul(TContractMul tContractMul);

    /**
     * 批量删除合约交易对
     * 
     * @param ids 需要删除的合约交易对主键集合
     * @return 结果
     */
    public int deleteTContractMulByIds(String[] ids);

    /**
     * 删除合约交易对信息
     * 
     * @param id 合约交易对主键
     * @return 结果
     */
    public int deleteTContractMulById(String id);
}
