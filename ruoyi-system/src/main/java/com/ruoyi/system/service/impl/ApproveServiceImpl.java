package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Approve;
import com.ruoyi.system.mapper.ApproveMapper;
import com.ruoyi.system.service.IApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class ApproveServiceImpl implements IApproveService
{
    @Autowired
    private ApproveMapper approveMapper;
    @Value("${img.path-suffix}")
    private String IMG_PATH;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public Approve selectTMemberById(String id)
    {
        return approveMapper.selectTMemberById(id);
    }

    /**
     * 查询会员列表
     * 
     * @return 会员
     */
    @Override
    public List<Approve> selectTMemberList(Approve approve)
    {
        List<Approve> list = approveMapper.selectTMemberList(approve);
        if (list.size()>0){
            for (Approve data : list) {
                data.setPositiveLink(IMG_PATH+data.getPositiveLink());
                data.setSideLink(IMG_PATH+data.getSideLink());
            }
        }
        return list;
    }

    /**
     * 新增会员
     * 
     * @return 结果
     */
    @Override
    public int insertTMember(Approve approve)
    {
        approve.setCreateTime(DateUtils.getNowDate());
        return approveMapper.insertTMember(approve);
    }

    /**
     * 修改会员
     * 
     * @return 结果
     */
    @Override
    public int updateTMember(Approve approve)
    {
        approve.setUpdateTime(DateUtils.getNowDate());
        return approveMapper.updateTMember(approve);
    }

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteTMemberByIds(String[] ids)
    {
        return approveMapper.deleteTMemberByIds(ids);
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteTMemberById(String id)
    {
        return approveMapper.deleteTMemberById(id);
    }

}
