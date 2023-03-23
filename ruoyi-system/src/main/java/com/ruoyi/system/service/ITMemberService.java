package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.dto.MemberDto;

/**
 * 会员Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ITMemberService 
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public TMember selectTMemberById(String id);

    /**
     * 查询会员列表
     * 
     * @param tMember 会员
     * @return 会员集合
     */
    public List<TMember> selectTMemberList(TMember tMember);

    /**
     * 新增会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    public int insertTMember(TMember tMember);

    /**
     * 修改会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    public int updateTMember(TMember tMember);

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

    public AjaxResult changeAmount(MemberDto memberDto, Integer type);

    public AjaxResult wel(TMember tMember);
}
