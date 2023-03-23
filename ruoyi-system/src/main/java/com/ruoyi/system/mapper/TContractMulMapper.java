package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TContractMul;

/**
 * 合约交易对Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TContractMulMapper 
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
     * 删除合约交易对
     * 
     * @param id 合约交易对主键
     * @return 结果
     */
    public int deleteTContractMulById(String id);

    /**
     * 批量删除合约交易对
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTContractMulByIds(String[] ids);
}
