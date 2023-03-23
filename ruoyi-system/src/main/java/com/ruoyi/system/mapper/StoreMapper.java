package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Store;

import java.util.List;

/**
 * 会员Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface StoreMapper
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public Store selectTMemberById(String id);
    public Store selectTMemberByPhone(String phone);

    /**
     * 查询会员列表
     * 
     */
    public List<Store> selectTMemberList(Store store);

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
     * 删除会员
     * 
     * @param id 会员主键
     * @return 结果
     */
    public int deleteTMemberById(String id);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMemberByIds(String[] ids);
}
