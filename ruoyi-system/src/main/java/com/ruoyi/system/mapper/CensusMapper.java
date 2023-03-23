package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Krson
 * @date 2022/8/13 20:27
 */
@Mapper
public interface CensusMapper {

    Long zcMemberCount(@Param("mode") Integer mode,
                     @Param("list") List<String> list);
    /**
     * 充币
     */
    BigDecimal recharge(@Param("status") Object status,
                       @Param("mode") Integer mode,
                        @Param("list") List<String> list);
    Long rechargeCount(@Param("status") Object status,
                        @Param("mode") Integer mode,
                       @Param("list") List<String> list);
    /**
     * 提币
     */
    BigDecimal withdraw(@Param("state") Object state,
                        @Param("mode") Integer mode,
                        @Param("list") List<String> list);
    Long withdrawCount(@Param("state") Object state,
                        @Param("mode") Integer mode,
                       @Param("list") List<String> list);

    Long memberCount(List<String> list);


    Long fbCount(@Param("status") String status,@Param("list") List<String> list);

    BigDecimal fbAmountTotalPrice(@Param("status") Object status,
                                  @Param("mode") Integer mode,
                                  @Param("list") List<String> list);
    BigDecimal fbAmountPrice(@Param("status") Object status,
                                  @Param("mode") Integer mode,@Param("list") List<String> list);





    //认证
//    @Select("select * from t_member where card_state = 'WAIT' order by update_time desc limit 1")
    Approve approveCount(List<String> list);
//    @Select("select count(0) from t_member where card_state = 'WAIT'")
    Long approveCount2(List<String> list);
    //充值
//    @Select("select * from t_member_recharge where status = 1 order by create_time desc limit 1")
    TMemberRecharge recCount(List<String> list);
//    @Select("select count(0) from t_member_recharge where status = 1")
    Long recCount2(List<String> list);
    //提现
//    @Select("select * from t_extract_coin where state = 'CREATE' order by create_time desc limit 1")
    TExtractCoin widCount(List<String> list);
//    @Select("select count(0) from t_extract_coin where state = 'CREATE'")
    Long widCount2(List<String> list);


    /**
     * 法币  币币  秒合约
     */
    TOtcOrderPrice fbOne(List<String> list);
    Long fbOne2(List<String> list);

    TEntrust bbOne(List<String> list);
    Long bbOne2(List<String> list);

    TSecondsBetLog mhyOne(List<String> list);
    Long mhyOne2(List<String> list);
}
