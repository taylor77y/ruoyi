package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TLeverMapper;
import com.ruoyi.system.domain.TLever;
import com.ruoyi.system.service.ITLeverService;

/**
 * 合约杠杆Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TLeverServiceImpl implements ITLeverService 
{
    @Autowired
    private TLeverMapper tLeverMapper;

    /**
     * 查询合约杠杆
     * 
     * @param id 合约杠杆主键
     * @return 合约杠杆
     */
    @Override
    public TLever selectTLeverById(String id)
    {
        return tLeverMapper.selectTLeverById(id);
    }

    /**
     * 查询合约杠杆列表
     * 
     * @param tLever 合约杠杆
     * @return 合约杠杆
     */
    @Override
    public List<TLever> selectTLeverList(TLever tLever)
    {
        return tLeverMapper.selectTLeverList(tLever);
    }

    /**
     * 新增合约杠杆
     * 
     * @param tLever 合约杠杆
     * @return 结果
     */
    @Override
    public int insertTLever(TLever tLever)
    {
        tLever.setCreateTime(DateUtils.getNowDate());
        return tLeverMapper.insertTLever(tLever);
    }

    /**
     * 修改合约杠杆
     * 
     * @param tLever 合约杠杆
     * @return 结果
     */
    @Override
    public int updateTLever(TLever tLever)
    {
        tLever.setUpdateTime(DateUtils.getNowDate());
        return tLeverMapper.updateTLever(tLever);
    }

    /**
     * 批量删除合约杠杆
     * 
     * @param ids 需要删除的合约杠杆主键
     * @return 结果
     */
    @Override
    public int deleteTLeverByIds(String[] ids)
    {
        return tLeverMapper.deleteTLeverByIds(ids);
    }

    /**
     * 删除合约杠杆信息
     * 
     * @param id 合约杠杆主键
     * @return 结果
     */
    @Override
    public int deleteTLeverById(String id)
    {
        return tLeverMapper.deleteTLeverById(id);
    }
}
