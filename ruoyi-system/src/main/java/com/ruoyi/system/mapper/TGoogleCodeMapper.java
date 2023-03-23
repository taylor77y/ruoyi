package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TGoogleCode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * 谷歌密钥Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-08
 */
public interface TGoogleCodeMapper 
{
    /**
     * 查询谷歌密钥
     * 
     * @param id 谷歌密钥主键
     * @return 谷歌密钥
     */
    public TGoogleCode selectTGoogleCodeById(Long id);

    @Select("select * from t_google_code where account = #{account}")
    public TGoogleCode findByAccount(Object account);

    /**
     * 查询谷歌密钥列表
     * 
     * @param tGoogleCode 谷歌密钥
     * @return 谷歌密钥集合
     */
    public List<TGoogleCode> selectTGoogleCodeList(TGoogleCode tGoogleCode);

    /**
     * 新增谷歌密钥
     * 
     * @param tGoogleCode 谷歌密钥
     * @return 结果
     */
    public int insertTGoogleCode(TGoogleCode tGoogleCode);

    /**
     * 修改谷歌密钥
     * 
     * @param tGoogleCode 谷歌密钥
     * @return 结果
     */
    public int updateTGoogleCode(TGoogleCode tGoogleCode);

    /**
     * 删除谷歌密钥
     * 
     * @param id 谷歌密钥主键
     * @return 结果
     */
    public int deleteTGoogleCodeById(Long id);

    /**
     * 批量删除谷歌密钥
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTGoogleCodeByIds(Long[] ids);

    @Delete("delete from t_google_code where account = #{account}")
    public int deleteAll(Object account);
}
