package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TPeProject;

/**
 * 私募项目Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TPeProjectMapper 
{
    /**
     * 查询私募项目
     * 
     * @param id 私募项目主键
     * @return 私募项目
     */
    public TPeProject selectTPeProjectById(String id);

    /**
     * 查询私募项目列表
     * 
     * @param tPeProject 私募项目
     * @return 私募项目集合
     */
    public List<TPeProject> selectTPeProjectList(TPeProject tPeProject);

    /**
     * 新增私募项目
     * 
     * @param tPeProject 私募项目
     * @return 结果
     */
    public int insertTPeProject(TPeProject tPeProject);

    /**
     * 修改私募项目
     * 
     * @param tPeProject 私募项目
     * @return 结果
     */
    public int updateTPeProject(TPeProject tPeProject);

    /**
     * 删除私募项目
     * 
     * @param id 私募项目主键
     * @return 结果
     */
    public int deleteTPeProjectById(String id);

    /**
     * 批量删除私募项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPeProjectByIds(String[] ids);
}
