package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Bizhongzongshu;
import com.ruoyi.system.domain.TBalance;

import java.util.List;
import java.util.Map;

/**
 * @author Krson
 * @date 2022/8/13 19:48
 */
public interface BizhongzongshuMapper {

    List<Map<String,Object>> selectBalance(TBalance tBalance);
}
