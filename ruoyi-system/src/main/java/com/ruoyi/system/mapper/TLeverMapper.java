package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TLever;

/**
 * 合约杠杆Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TLeverMapper 
{
    /**
     * 查询合约杠杆
     * 
     * @param id 合约杠杆主键
     * @return 合约杠杆
     */
    public TLever selectTLeverById(String id);

    /**
     * 查询合约杠杆列表
     * 
     * @param tLever 合约杠杆
     * @return 合约杠杆集合
     */
    public List<TLever> selectTLeverList(TLever tLever);

    /**
     * 新增合约杠杆
     * 
     * @param tLever 合约杠杆
     * @return 结果
     */
    public int insertTLever(TLever tLever);

    /**
     * 修改合约杠杆
     * 
     * @param tLever 合约杠杆
     * @return 结果
     */
    public int updateTLever(TLever tLever);

    /**
     * 删除合约杠杆
     * 
     * @param id 合约杠杆主键
     * @return 结果
     */
    public int deleteTLeverById(String id);

    /**
     * 批量删除合约杠杆
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTLeverByIds(String[] ids);
}
