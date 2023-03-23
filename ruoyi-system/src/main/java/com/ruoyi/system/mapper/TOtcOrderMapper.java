package com.ruoyi.system.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.system.domain.TOtcOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 法币订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-11
 */
public interface TOtcOrderMapper 
{
    /**
     * 查询法币订单
     * 
     * @param id 法币订单主键
     * @return 法币订单
     */
    public TOtcOrder selectTOtcOrderById(String id);

    /**
     * 查询法币订单列表
     * 
     * @param tOtcOrder 法币订单
     * @return 法币订单集合
     */
    public List<TOtcOrder> selectTOtcOrderList(TOtcOrder tOtcOrder);

    /**
     * 新增法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    public int insertTOtcOrder(TOtcOrder tOtcOrder);

    /**
     * 修改法币订单
     * 
     * @param tOtcOrder 法币订单
     * @return 结果
     */
    public int updateTOtcOrder(TOtcOrder tOtcOrder);

    /**
     * 删除法币订单
     * 
     * @param id 法币订单主键
     * @return 结果
     */
    public int deleteTOtcOrderById(String id);

    /**
     * 批量删除法币订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTOtcOrderByIds(String[] ids);

    @Update("update t_otc_order set deal_num = deal_num + ${dealNum} where id = #{id}")
    int addDealNumById(@Param("dealNum") BigDecimal dealNum,@Param("id") String id);
}
