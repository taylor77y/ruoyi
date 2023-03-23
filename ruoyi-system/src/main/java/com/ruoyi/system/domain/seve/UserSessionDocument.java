package com.ruoyi.system.domain.seve;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Krson
 * @date 2022/9/21 15:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSessionDocument {

    private Date lastTime;
    private String body;
    private String lastId;
    private Byte type;
    private String hash;
    private String target;
    private String sender;
}
