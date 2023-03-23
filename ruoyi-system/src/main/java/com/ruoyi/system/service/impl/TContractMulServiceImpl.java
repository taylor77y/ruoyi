package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TContractMulMapper;
import com.ruoyi.system.domain.TContractMul;
import com.ruoyi.system.service.ITContractMulService;

/**
 * 合约交易对Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TContractMulServiceImpl implements ITContractMulService 
{
    @Autowired
    private TContractMulMapper tContractMulMapper;

    /**
     * 查询合约交易对
     * 
     * @param id 合约交易对主键
     * @return 合约交易对
     */
    @Override
    public TContractMul selectTContractMulById(String id)
    {
        return tContractMulMapper.selectTContractMulById(id);
    }

    /**
     * 查询合约交易对列表
     * 
     * @param tContractMul 合约交易对
     * @return 合约交易对
     */
    @Override
    public List<TContractMul> selectTContractMulList(TContractMul tContractMul)
    {
        return tContractMulMapper.selectTContractMulList(tContractMul);
    }

    /**
     * 新增合约交易对
     * 
     * @param tContractMul 合约交易对
     * @return 结果
     */
    @Override
    public int insertTContractMul(TContractMul tContractMul)
    {
        tContractMul.setCreateTime(DateUtils.getNowDate());
        return tContractMulMapper.insertTContractMul(tContractMul);
    }

    /**
     * 修改合约交易对
     * 
     * @param tContractMul 合约交易对
     * @return 结果
     */
    @Override
    public int updateTContractMul(TContractMul tContractMul)
    {
        tContractMul.setUpdateTime(DateUtils.getNowDate());
        return tContractMulMapper.updateTContractMul(tContractMul);
    }

    /**
     * 批量删除合约交易对
     * 
     * @param ids 需要删除的合约交易对主键
     * @return 结果
     */
    @Override
    public int deleteTContractMulByIds(String[] ids)
    {
        return tContractMulMapper.deleteTContractMulByIds(ids);
    }

    /**
     * 删除合约交易对信息
     * 
     * @param id 合约交易对主键
     * @return 结果
     */
    @Override
    public int deleteTContractMulById(String id)
    {
        return tContractMulMapper.deleteTContractMulById(id);
    }
}
