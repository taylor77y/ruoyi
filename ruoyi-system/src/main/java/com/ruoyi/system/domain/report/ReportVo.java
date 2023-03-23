package com.ruoyi.system.domain.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Krson
 * @date 2022/9/25 11:19
 */
@Data
public class ReportVo {

    private Integer type;
    private Date startTime;
    private Date endTime;
}
