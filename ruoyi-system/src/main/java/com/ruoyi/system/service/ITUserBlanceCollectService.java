package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TUserBlanceCollect;

/**
 * 用户财务分析Service接口
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
public interface ITUserBlanceCollectService 
{
    /**
     * 查询用户财务分析
     * 
     * @param id 用户财务分析主键
     * @return 用户财务分析
     */
    public TUserBlanceCollect selectTUserBlanceCollectById(Long id);

    /**
     * 查询用户财务分析列表
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 用户财务分析集合
     */
    public List<TUserBlanceCollect> selectTUserBlanceCollectList(TUserBlanceCollect tUserBlanceCollect);

    /**
     * 新增用户财务分析
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 结果
     */
    public int insertTUserBlanceCollect(TUserBlanceCollect tUserBlanceCollect);

    /**
     * 修改用户财务分析
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 结果
     */
    public int updateTUserBlanceCollect(TUserBlanceCollect tUserBlanceCollect);

    /**
     * 批量删除用户财务分析
     * 
     * @param ids 需要删除的用户财务分析主键集合
     * @return 结果
     */
    public int deleteTUserBlanceCollectByIds(Long[] ids);

    /**
     * 删除用户财务分析信息
     * 
     * @param id 用户财务分析主键
     * @return 结果
     */
    public int deleteTUserBlanceCollectById(Long id);
}
