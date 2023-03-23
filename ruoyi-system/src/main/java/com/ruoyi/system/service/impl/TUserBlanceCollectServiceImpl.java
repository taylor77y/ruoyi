package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TUserBlanceCollectMapper;
import com.ruoyi.system.domain.TUserBlanceCollect;
import com.ruoyi.system.service.ITUserBlanceCollectService;

/**
 * 用户财务分析Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-13
 */
@Service
public class TUserBlanceCollectServiceImpl implements ITUserBlanceCollectService 
{
    @Autowired
    private TUserBlanceCollectMapper tUserBlanceCollectMapper;

    /**
     * 查询用户财务分析
     * 
     * @param id 用户财务分析主键
     * @return 用户财务分析
     */
    @Override
    public TUserBlanceCollect selectTUserBlanceCollectById(Long id)
    {
        return tUserBlanceCollectMapper.selectTUserBlanceCollectById(id);
    }

    /**
     * 查询用户财务分析列表
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 用户财务分析
     */
    @Override
    public List<TUserBlanceCollect> selectTUserBlanceCollectList(TUserBlanceCollect tUserBlanceCollect)
    {
        return tUserBlanceCollectMapper.selectTUserBlanceCollectList(tUserBlanceCollect);
    }

    /**
     * 新增用户财务分析
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 结果
     */
    @Override
    public int insertTUserBlanceCollect(TUserBlanceCollect tUserBlanceCollect)
    {
        return tUserBlanceCollectMapper.insertTUserBlanceCollect(tUserBlanceCollect);
    }

    /**
     * 修改用户财务分析
     * 
     * @param tUserBlanceCollect 用户财务分析
     * @return 结果
     */
    @Override
    public int updateTUserBlanceCollect(TUserBlanceCollect tUserBlanceCollect)
    {
        tUserBlanceCollect.setUpdateTime(DateUtils.getNowDate());
        return tUserBlanceCollectMapper.updateTUserBlanceCollect(tUserBlanceCollect);
    }

    /**
     * 批量删除用户财务分析
     * 
     * @param ids 需要删除的用户财务分析主键
     * @return 结果
     */
    @Override
    public int deleteTUserBlanceCollectByIds(Long[] ids)
    {
        return tUserBlanceCollectMapper.deleteTUserBlanceCollectByIds(ids);
    }

    /**
     * 删除用户财务分析信息
     * 
     * @param id 用户财务分析主键
     * @return 结果
     */
    @Override
    public int deleteTUserBlanceCollectById(Long id)
    {
        return tUserBlanceCollectMapper.deleteTUserBlanceCollectById(id);
    }
}
