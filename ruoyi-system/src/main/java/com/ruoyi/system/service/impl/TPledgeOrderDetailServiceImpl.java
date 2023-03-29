package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPledgeOrderDetailMapper;
import com.ruoyi.system.domain.TPledgeOrderDetail;
import com.ruoyi.system.service.ITPledgeOrderDetailService;

/**
 * 质押借币订单详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@Service
public class TPledgeOrderDetailServiceImpl implements ITPledgeOrderDetailService 
{
    @Autowired
    private TPledgeOrderDetailMapper tPledgeOrderDetailMapper;

    /**
     * 查询质押借币订单详情
     * 
     * @param id 质押借币订单详情主键
     * @return 质押借币订单详情
     */
    @Override
    public TPledgeOrderDetail selectTPledgeOrderDetailById(String id)
    {
        return tPledgeOrderDetailMapper.selectTPledgeOrderDetailById(id);
    }

    /**
     * 查询质押借币订单详情列表
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 质押借币订单详情
     */
    @Override
    public List<TPledgeOrderDetail> selectTPledgeOrderDetailList(TPledgeOrderDetail tPledgeOrderDetail)
    {
        return tPledgeOrderDetailMapper.selectTPledgeOrderDetailList(tPledgeOrderDetail);
    }

    /**
     * 新增质押借币订单详情
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 结果
     */
    @Override
    public int insertTPledgeOrderDetail(TPledgeOrderDetail tPledgeOrderDetail)
    {
        return tPledgeOrderDetailMapper.insertTPledgeOrderDetail(tPledgeOrderDetail);
    }

    /**
     * 修改质押借币订单详情
     * 
     * @param tPledgeOrderDetail 质押借币订单详情
     * @return 结果
     */
    @Override
    public int updateTPledgeOrderDetail(TPledgeOrderDetail tPledgeOrderDetail)
    {
        tPledgeOrderDetail.setUpdateTime(DateUtils.getNowDate());
        return tPledgeOrderDetailMapper.updateTPledgeOrderDetail(tPledgeOrderDetail);
    }

    /**
     * 批量删除质押借币订单详情
     * 
     * @param ids 需要删除的质押借币订单详情主键
     * @return 结果
     */
    @Override
    public int deleteTPledgeOrderDetailByIds(String[] ids)
    {
        return tPledgeOrderDetailMapper.deleteTPledgeOrderDetailByIds(ids);
    }

    /**
     * 删除质押借币订单详情信息
     * 
     * @param id 质押借币订单详情主键
     * @return 结果
     */
    @Override
    public int deleteTPledgeOrderDetailById(String id)
    {
        return tPledgeOrderDetailMapper.deleteTPledgeOrderDetailById(id);
    }
}
