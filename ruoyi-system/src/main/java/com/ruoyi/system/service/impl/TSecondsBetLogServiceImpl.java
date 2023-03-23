package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSecondsBetLogMapper;
import com.ruoyi.system.domain.TSecondsBetLog;
import com.ruoyi.system.service.ITSecondsBetLogService;

/**
 * 秒合约记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class TSecondsBetLogServiceImpl implements ITSecondsBetLogService 
{
    @Autowired
    private TSecondsBetLogMapper tSecondsBetLogMapper;

    /**
     * 查询秒合约记录
     * 
     * @param id 秒合约记录主键
     * @return 秒合约记录
     */
    @Override
    public TSecondsBetLog selectTSecondsBetLogById(Long id)
    {
        return tSecondsBetLogMapper.selectTSecondsBetLogById(id);
    }

    /**
     * 查询秒合约记录列表
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 秒合约记录
     */
    @Override
    public List<TSecondsBetLog> selectTSecondsBetLogList(TSecondsBetLog tSecondsBetLog)
    {
        return tSecondsBetLogMapper.selectTSecondsBetLogList(tSecondsBetLog);
    }

    /**
     * 新增秒合约记录
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 结果
     */
    @Override
    public int insertTSecondsBetLog(TSecondsBetLog tSecondsBetLog)
    {
        tSecondsBetLog.setCreateTime(DateUtils.getNowDate());
        return tSecondsBetLogMapper.insertTSecondsBetLog(tSecondsBetLog);
    }

    /**
     * 修改秒合约记录
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 结果
     */
    @Override
    public int updateTSecondsBetLog(TSecondsBetLog tSecondsBetLog)
    {
        return tSecondsBetLogMapper.updateTSecondsBetLog(tSecondsBetLog);
    }

    /**
     * 批量删除秒合约记录
     * 
     * @param ids 需要删除的秒合约记录主键
     * @return 结果
     */
    @Override
    public int deleteTSecondsBetLogByIds(Long[] ids)
    {
        return tSecondsBetLogMapper.deleteTSecondsBetLogByIds(ids);
    }

    /**
     * 删除秒合约记录信息
     * 
     * @param id 秒合约记录主键
     * @return 结果
     */
    @Override
    public int deleteTSecondsBetLogById(Long id)
    {
        return tSecondsBetLogMapper.deleteTSecondsBetLogById(id);
    }
}
