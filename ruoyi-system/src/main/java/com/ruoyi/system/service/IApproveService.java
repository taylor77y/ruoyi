package com.ruoyi.system.service;

import com.ruoyi.system.domain.Approve;

import java.util.List;

/**
 * 会员Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface IApproveService
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public Approve selectTMemberById(String id);

    /**
     * 查询会员列表
     * 
     * @return 会员集合
     */
    public List<Approve> selectTMemberList(Approve approve);

    /**
     * 新增会员
     * 
     * @return 结果
     */
    public int insertTMember(Approve approve);

    /**
     * 修改会员
     * 
     * @return 结果
     */
    public int updateTMember(Approve approve);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    public int deleteTMemberByIds(String[] ids);

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    public int deleteTMemberById(String id);
}
