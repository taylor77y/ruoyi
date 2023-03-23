package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.AmountChange;
import com.ruoyi.system.domain.TBalanceRecord;
import com.ruoyi.system.domain.dto.MemberDto;
import com.ruoyi.system.mapper.AmountChangeMapper;
import com.ruoyi.system.mapper.TBalanceRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberMapper;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.service.ITMemberService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TMemberServiceImpl implements ITMemberService 
{
    @Autowired
    private TMemberMapper tMemberMapper;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public TMember selectTMemberById(String id)
    {
        return tMemberMapper.selectTMemberById(id);
    }

    /**
     * 查询会员列表
     * 
     * @param tMember 会员
     * @return 会员
     */
    @Override
    public List<TMember> selectTMemberList(TMember tMember)
    {
        List<TMember> list = tMemberMapper.selectTMemberList(tMember);
        for (TMember member : list) {
            String admin = tMemberMapper.findUserNameByAdminId(member.getSysId());
            member.setSysName(admin);
        }
        return list;
    }

    /**
     * 新增会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    @Override
    public int insertTMember(TMember tMember)
    {
        tMember.setCreateTime(DateUtils.getNowDate());
        return tMemberMapper.insertTMember(tMember);
    }

    /**
     * 修改会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    @Override
    public int updateTMember(TMember tMember)
    {
        TMember res = tMemberMapper.selectTMemberById(tMember.getId());
        if (StringUtils.isNotEmpty(res.getPhone())){
            if (!res.getPhone().equals(tMember.getPhone())){
                if (tMemberMapper.selectTMemberByPhone(tMember.getPhone()) != null){
                    return -3;
                }
            }
        }else {
            if (tMemberMapper.selectTMemberByPhone(tMember.getPhone()) != null){
                return -3;
            }
        }
        tMember.setUpdateTime(DateUtils.getNowDate());
        return tMemberMapper.updateTMember(tMember);
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
        return tMemberMapper.deleteTMemberByIds(ids);
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
        return tMemberMapper.deleteTMemberById(id);
    }

    @Autowired
    private AmountChangeMapper amountChangeMapper;
    @Autowired
    private TBalanceRecordMapper tBalanceRecordMapper;
    @Override
    @Transactional
    public AjaxResult changeAmount(MemberDto memberDto, Integer type) {
        System.err.println(memberDto.getId());
        TBalanceRecord tBalanceRecord = new TBalanceRecord();
        tBalanceRecord.setMemberId(memberDto.getId());
        tBalanceRecord.setCurrency(memberDto.getCurrency());
        tBalanceRecord.setBalanceDifference(memberDto.getAmount());
        tBalanceRecord.setBalanceBefore(tMemberMapper.findBalanceById(memberDto.getId(),memberDto.getCurrency()));
        if (type == 1){//上分
            tBalanceRecord.setFundsType(2);
            tBalanceRecord.setBalanceType(52);
            tBalanceRecord.setDataClassification(5);
            tMemberMapper.addBalanceByUserIdAndBz(memberDto.getAmount(),memberDto.getId(),memberDto.getCurrency());
            tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(memberDto.getId(),memberDto.getCurrency()));
            tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
            return AjaxResult.success();
        }else if (type == 2){//下分
            int row = tMemberMapper.subBalanceByUserIdAndBz(memberDto.getAmount(),memberDto.getId(),memberDto.getCurrency());
            if (row == 0){
                return AjaxResult.error("下分失败，余额不足");
            }else {
                tBalanceRecord.setBalanceType(54);
                tBalanceRecord.setFundsType(1);
                tBalanceRecord.setDataClassification(5);
                tBalanceRecord.setBalanceBack(tMemberMapper.findBalanceById(memberDto.getId(),memberDto.getCurrency()));
                tBalanceRecordMapper.insertTBalanceRecord(tBalanceRecord);
                return AjaxResult.success();
            }
        }
        return AjaxResult.error("操纵失败，系统故障");
    }

    @Override
    public AjaxResult wel(TMember tMember) {

        TMember wo = tMemberMapper.selectTMemberById(tMember.getId());
        if (tMember.getUuid().equals(wo.getUuid())){
            return AjaxResult.error("自己无法成为自己的邀请人");
        }
        TMember res = tMemberMapper.selectTMemberByUuid(tMember.getUuid());
        if (res == null){
            return AjaxResult.error("查无此人，请重新操作");
        }
        Integer row = tMemberMapper.upWelMember(res.getId(), tMember.getId());
        if (row == 0){
            return AjaxResult.error("更新异常，请联系管理员");
        }
        return AjaxResult.success();
    }
}
