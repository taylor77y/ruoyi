package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TMemberRecharge;

/**
 * 会员充值Service接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface ITMemberRechargeService 
{
    /**
     * 查询会员充值
     * 
     * @param id 会员充值主键
     * @return 会员充值
     */
    public TMemberRecharge selectTMemberRechargeById(Long id);

    /**
     * 查询会员充值列表
     * 
     * @param tMemberRecharge 会员充值
     * @return 会员充值集合
     */
    public List<TMemberRecharge> selectTMemberRechargeList(TMemberRecharge tMemberRecharge);

    /**
     * 新增会员充值
     * 
     * @param tMemberRecharge 会员充值
     * @return 结果
     */
    public int insertTMemberRecharge(TMemberRecharge tMemberRecharge);

    /**
     * 修改会员充值
     * 
     * @param tMemberRecharge 会员充值
     * @return 结果
     */
    public int updateTMemberRecharge(TMemberRecharge tMemberRecharge);

    /**
     * 批量删除会员充值
     * 
     * @param ids 需要删除的会员充值主键集合
     * @return 结果
     */
    public int deleteTMemberRechargeByIds(Long[] ids);

    /**
     * 删除会员充值信息
     * 
     * @param id 会员充值主键
     * @return 结果
     */
    public int deleteTMemberRechargeById(Long id);

    AjaxResult rechargeAudit(Integer type, Long id);
}
