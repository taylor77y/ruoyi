package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TMember;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Krson
 * @date 2022/9/25 11:05
 */
public interface ReportMapper {

    /**
     * 注册统计（当天、当月、当年）
     */
    Long findCountByMemberToDay(@Param("list") List<String> list,@Param("time") Date time);
    Long findCountByMemberToMonth(@Param("list") List<String> list,@Param("time") Date time);
    Long findCountByMemberToYear(@Param("list") List<String> list,@Param("time") Date time);

    /**
     * 用户资金汇总
     */
    @Select("select DISTINCT currency from t_balance")
    List<String> findCurrencyByUser();
    BigDecimal findAmountByUserAndCurrency(@Param("list") List<String> list,@Param("currency") String currency);


    /**
     * 充值金额查询
     */
    BigDecimal findMemberRecharge(@Param("memberId") Object memberId,@Param("currency") Object currency,
                                  @Param("openTime") Date openTime,@Param("closeTime") Date closeTime,@Param("mode") Integer mode);
    //提现
    BigDecimal findMemberIdByWithDraw(@Param("memberId") Object memberId,
                                      @Param("openTime") Date openTime,@Param("closeTime") Date closeTime,@Param("mode") Integer mode);
    //用户法币买卖
    BigDecimal findMemberByOTC(@Param("memberId") Object memberId,@Param("userDirection") Object userDirection,
                               @Param("openTime") Date openTime,@Param("closeTime") Date closeTime,@Param("mode") Integer mode);
    //秒合约输赢
    BigDecimal findMemberMhyByWin(@Param("memberId") Object memberId,
                                  @Param("openTime") Date openTime,@Param("closeTime") Date closeTime,@Param("mode") Integer mode);
    BigDecimal findMemberMhyByDonate(@Param("memberId") Object memberId,
                                     @Param("openTime") Date openTime,@Param("closeTime") Date closeTime,@Param("mode") Integer mode);
    //虚拟上下分
    BigDecimal findMemberByXnAmount(@Param("memberId") Object memberId,@Param("balanceType") Object balanceType,@Param("currency") Object currency,
                                    @Param("openTime") Date openTime,@Param("closeTime") Date closeTime);


    List<TMember> findInfoByUser(@Param("list") List<String> list,@Param("sysIds") List<String> sysIds,
                                 @Param("openTime") Date openTime,@Param("closeTime") Date closeTime);

}
