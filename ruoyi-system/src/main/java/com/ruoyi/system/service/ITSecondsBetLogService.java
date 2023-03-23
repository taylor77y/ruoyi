package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TSecondsBetLog;

/**
 * 秒合约记录Service接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface ITSecondsBetLogService 
{
    /**
     * 查询秒合约记录
     * 
     * @param id 秒合约记录主键
     * @return 秒合约记录
     */
    public TSecondsBetLog selectTSecondsBetLogById(Long id);

    /**
     * 查询秒合约记录列表
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 秒合约记录集合
     */
    public List<TSecondsBetLog> selectTSecondsBetLogList(TSecondsBetLog tSecondsBetLog);

    /**
     * 新增秒合约记录
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 结果
     */
    public int insertTSecondsBetLog(TSecondsBetLog tSecondsBetLog);

    /**
     * 修改秒合约记录
     * 
     * @param tSecondsBetLog 秒合约记录
     * @return 结果
     */
    public int updateTSecondsBetLog(TSecondsBetLog tSecondsBetLog);

    /**
     * 批量删除秒合约记录
     * 
     * @param ids 需要删除的秒合约记录主键集合
     * @return 结果
     */
    public int deleteTSecondsBetLogByIds(Long[] ids);

    /**
     * 删除秒合约记录信息
     * 
     * @param id 秒合约记录主键
     * @return 结果
     */
    public int deleteTSecondsBetLogById(Long id);
}
