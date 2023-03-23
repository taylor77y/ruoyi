package com.ruoyi.system.domain.seve;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Krson
 * @date 2022/9/21 11:28
 */
//@Document(collection = "channel_user")
public class ChannelUserDocument {

//    @Id
    private Object id;
    private String memberId;
    private String remoteIp;
    private String localIp;
    private LocalDateTime loginTime;
    private Byte source;
    private List<UserSessionDocument> sessions;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public List<UserSessionDocument> getSessions() {
        return sessions;
    }

    public void setSessions(List<UserSessionDocument> sessions) {
        this.sessions = sessions;
    }
}
