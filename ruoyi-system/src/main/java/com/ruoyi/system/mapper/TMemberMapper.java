package com.ruoyi.system.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.system.domain.TBalance;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.seve.UserSessionDocument;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 会员Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface TMemberMapper 
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public TMember selectTMemberById(String id);
    public TMember selectTMemberByUuid(String uuid);
    public TMember selectTMemberByPhone(String phone);

    /**
     * 查询会员列表
     * 
     * @param tMember 会员
     * @return 会员集合
     */
    public List<TMember> selectTMemberList(TMember tMember);

    /**
     * 新增会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    public int insertTMember(TMember tMember);

    /**
     * 修改会员
     * 
     * @param tMember 会员
     * @return 结果
     */
    public int updateTMember(TMember tMember);

    @Update("update t_member set wel_member = #{wel} where id = #{id}")
    int upWelMember(@Param("wel") String wel,@Param("id") String id);

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

    @Update("update t_balance set assets_balance = assets_balance + ${balance} where user_id = #{userId} and currency = #{currency}")
    int addBalanceByUserIdAndBz(@Param("balance") Object balance,
                                @Param("userId") Object userId,
                                @Param("currency") Object currency);

    @Update("update t_balance set assets_balance = assets_balance - ${balance} where user_id = #{userId} and currency = #{currency} and assets_balance >= ${balance}")
    int subBalanceByUserIdAndBz(@Param("balance") BigDecimal balance,
                                @Param("userId") Object userId,
                                @Param("currency") Object currency);

    @Select("select phone from t_member where id = #{id}")
    String getMemberPhone(String id);
    @Select("select mail from t_member where id = #{id}")
    String getMemberMail(String id);

//    /**
//     * 法币可用
//     */
//    @Update("update t_balance set fb_balance = fb_balance + ${balance} where user_id = #{userId} and currency = #{currency}")
//    int addFbBalanceByUserIdAndBz(@Param("balance") Object balance,
//                                @Param("userId") Object userId,
//                                @Param("currency") Object currency);
    /**
     * 法币可用
     */
    @Update("update t_balance set assets_balance = assets_balance + ${balance} where user_id = #{userId} and currency = #{currency}")
    int addFbBalanceByUserIdAndBz(@Param("balance") Object balance,
                                  @Param("userId") Object userId,
                                  @Param("currency") Object currency);

//    @Update("update t_balance set fb_balance = fb_balance - ${balance} where user_id = #{userId} and currency = #{currency} and fb_balance >= ${balance}")
//    int subFbBalanceByUserIdAndBz(@Param("balance") BigDecimal balance,
//                                @Param("userId") Object userId,
//                                @Param("currency") Object currency);
    @Update("update t_balance set assets_balance = assets_balance - ${balance} where user_id = #{userId} and currency = #{currency} and assets_balance >= ${balance}")
    int subFbBalanceByUserIdAndBz(@Param("balance") BigDecimal balance,
                                  @Param("userId") Object userId,
                                  @Param("currency") Object currency);

//    /**
//     * 法币冻结
//     */
//    @Update("update t_balance set fb_blocked_balance = fb_blocked_balance + ${balance} where user_id = #{userId} and currency = #{currency}")
//    int addFbBlockedBalanceByUserIdAndBz(@Param("balance") Object balance,
//                                  @Param("userId") Object userId,
//                                  @Param("currency") Object currency);
    /**
     * 法币冻结
     */
    @Update("update t_balance set assets_blocked_balance = assets_blocked_balance + ${balance} where user_id = #{userId} and currency = #{currency}")
    int addFbBlockedBalanceByUserIdAndBz(@Param("balance") Object balance,
                                         @Param("userId") Object userId,
                                         @Param("currency") Object currency);

//    @Update("update t_balance set fb_blocked_balance = fb_blocked_balance - ${balance} where user_id = #{userId} and currency = #{currency} and fb_blocked_balance >= ${balance}")
//    int subFbBlockedBalanceByUserIdAndBz(@Param("balance") BigDecimal balance,
//                                  @Param("userId") Object userId,
//                                  @Param("currency") Object currency);
    @Update("update t_balance set assets_blocked_balance = assets_blocked_balance - ${balance} where user_id = #{userId} and currency = #{currency} and assets_blocked_balance >= ${balance}")
    int subFbBlockedBalanceByUserIdAndBz(@Param("balance") BigDecimal balance,
                                         @Param("userId") Object userId,
                                         @Param("currency") Object currency);

    @Select("select user_name from sys_user where user_id = #{sysId}")
    String findUserNameByAdminId(Long sysId);

    @Select("select assets_balance from t_balance where user_id = #{id} and currency = 'USDT'")
    BigDecimal findBalanceById(@Param("id") String id,@Param("currency") String currency);

    List<TMember> findByList(@Param("list") List<UserSessionDocument> list);

    List<TMember> findByList2();

    @Select("select * from t_member where id=#{id}")
    TMember findOne(String id);
}
