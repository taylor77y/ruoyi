package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Store;
import com.ruoyi.system.domain.dto.MemberDto;

import java.util.List;

/**
 * 会员Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface IStoreService
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public Store selectTMemberById(String id);

    /**
     * 查询会员列表
     * 
     * @param tMember 会员
     * @return 会员集合
     */
    public List<Store> selectTMemberList(Store tMember);

    /**
     * 新增会员
     * 
     * @return 结果
     */
    public int insertTMember(Store store);

    /**
     * 修改会员
     * 
     * @return 结果
     */
    public int updateTMember(Store store);

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

    /**
     * 充值法币余额
     */
    AjaxResult fbAmount(MemberDto memberDto);
}
