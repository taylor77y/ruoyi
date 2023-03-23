package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPeProjectMapper;
import com.ruoyi.system.domain.TPeProject;
import com.ruoyi.system.service.ITPeProjectService;

/**
 * 私募项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
@Service
public class TPeProjectServiceImpl implements ITPeProjectService 
{
    @Autowired
    private TPeProjectMapper tPeProjectMapper;

    /**
     * 查询私募项目
     * 
     * @param id 私募项目主键
     * @return 私募项目
     */
    @Override
    public TPeProject selectTPeProjectById(String id)
    {
        return tPeProjectMapper.selectTPeProjectById(id);
    }

    /**
     * 查询私募项目列表
     * 
     * @param tPeProject 私募项目
     * @return 私募项目
     */
    @Override
    public List<TPeProject> selectTPeProjectList(TPeProject tPeProject)
    {
        return tPeProjectMapper.selectTPeProjectList(tPeProject);
    }

    /**
     * 新增私募项目
     * 
     * @param tPeProject 私募项目
     * @return 结果
     */
    @Override
    public int insertTPeProject(TPeProject tPeProject)
    {
        tPeProject.setCreateTime(DateUtils.getNowDate());
        return tPeProjectMapper.insertTPeProject(tPeProject);
    }

    /**
     * 修改私募项目
     * 
     * @param tPeProject 私募项目
     * @return 结果
     */
    @Override
    public int updateTPeProject(TPeProject tPeProject)
    {
        tPeProject.setUpdateTime(DateUtils.getNowDate());
        return tPeProjectMapper.updateTPeProject(tPeProject);
    }

    /**
     * 批量删除私募项目
     * 
     * @param ids 需要删除的私募项目主键
     * @return 结果
     */
    @Override
    public int deleteTPeProjectByIds(String[] ids)
    {
        return tPeProjectMapper.deleteTPeProjectByIds(ids);
    }

    /**
     * 删除私募项目信息
     * 
     * @param id 私募项目主键
     * @return 结果
     */
    @Override
    public int deleteTPeProjectById(String id)
    {
        return tPeProjectMapper.deleteTPeProjectById(id);
    }
}
