package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TCoinToken;

/**
 * 币种信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TCoinTokenMapper 
{
    /**
     * 查询币种信息
     * 
     * @param id 币种信息主键
     * @return 币种信息
     */
    public TCoinToken selectTCoinTokenById(String id);

    /**
     * 查询币种信息列表
     * 
     * @param tCoinToken 币种信息
     * @return 币种信息集合
     */
    public List<TCoinToken> selectTCoinTokenList(TCoinToken tCoinToken);

    /**
     * 新增币种信息
     * 
     * @param tCoinToken 币种信息
     * @return 结果
     */
    public int insertTCoinToken(TCoinToken tCoinToken);

    /**
     * 修改币种信息
     * 
     * @param tCoinToken 币种信息
     * @return 结果
     */
    public int updateTCoinToken(TCoinToken tCoinToken);

    /**
     * 删除币种信息
     * 
     * @param id 币种信息主键
     * @return 结果
     */
    public int deleteTCoinTokenById(String id);

    /**
     * 批量删除币种信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTCoinTokenByIds(String[] ids);
}
