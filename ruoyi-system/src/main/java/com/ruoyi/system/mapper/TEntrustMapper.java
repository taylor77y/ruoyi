package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TEntrust;

/**
 * 币币撮合Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-12
 */
public interface TEntrustMapper 
{
    /**
     * 查询币币撮合
     * 
     * @param id 币币撮合主键
     * @return 币币撮合
     */
    public TEntrust selectTEntrustById(String id);

    /**
     * 查询币币撮合列表
     * 
     * @param tEntrust 币币撮合
     * @return 币币撮合集合
     */
    public List<TEntrust> selectTEntrustList(TEntrust tEntrust);

    /**
     * 新增币币撮合
     * 
     * @param tEntrust 币币撮合
     * @return 结果
     */
    public int insertTEntrust(TEntrust tEntrust);

    /**
     * 修改币币撮合
     * 
     * @param tEntrust 币币撮合
     * @return 结果
     */
    public int updateTEntrust(TEntrust tEntrust);

    /**
     * 删除币币撮合
     * 
     * @param id 币币撮合主键
     * @return 结果
     */
    public int deleteTEntrustById(String id);

    /**
     * 批量删除币币撮合
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTEntrustByIds(String[] ids);
}
