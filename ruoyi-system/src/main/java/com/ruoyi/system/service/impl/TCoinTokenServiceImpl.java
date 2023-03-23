package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TCoinTokenMapper;
import com.ruoyi.system.domain.TCoinToken;
import com.ruoyi.system.service.ITCoinTokenService;

/**
 * 币种信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
@Service
public class TCoinTokenServiceImpl implements ITCoinTokenService 
{
    @Autowired
    private TCoinTokenMapper tCoinTokenMapper;

    /**
     * 查询币种信息
     * 
     * @param id 币种信息主键
     * @return 币种信息
     */
    @Override
    public TCoinToken selectTCoinTokenById(String id)
    {
        return tCoinTokenMapper.selectTCoinTokenById(id);
    }

    /**
     * 查询币种信息列表
     * 
     * @param tCoinToken 币种信息
     * @return 币种信息
     */
    @Override
    public List<TCoinToken> selectTCoinTokenList(TCoinToken tCoinToken)
    {
        return tCoinTokenMapper.selectTCoinTokenList(tCoinToken);
    }

    /**
     * 新增币种信息
     * 
     * @param tCoinToken 币种信息
     * @return 结果
     */
    @Override
    public int insertTCoinToken(TCoinToken tCoinToken)
    {
        return tCoinTokenMapper.insertTCoinToken(tCoinToken);
    }

    /**
     * 修改币种信息
     * 
     * @param tCoinToken 币种信息
     * @return 结果
     */
    @Override
    public int updateTCoinToken(TCoinToken tCoinToken)
    {
        return tCoinTokenMapper.updateTCoinToken(tCoinToken);
    }

    /**
     * 批量删除币种信息
     * 
     * @param ids 需要删除的币种信息主键
     * @return 结果
     */
    @Override
    public int deleteTCoinTokenByIds(String[] ids)
    {
        return tCoinTokenMapper.deleteTCoinTokenByIds(ids);
    }

    /**
     * 删除币种信息信息
     * 
     * @param id 币种信息主键
     * @return 结果
     */
    @Override
    public int deleteTCoinTokenById(String id)
    {
        return tCoinTokenMapper.deleteTCoinTokenById(id);
    }
}
