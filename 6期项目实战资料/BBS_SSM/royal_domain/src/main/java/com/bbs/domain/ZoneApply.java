package com.bbs.domain;

public class ZoneApply {
    private Integer applyzoneid;

    private String zonename;

    private String username;

    private String reason;

    private Integer status;

    public Integer getApplyzoneid() {
        return applyzoneid;
    }

    public void setApplyzoneid(Integer applyzoneid) {
        this.applyzoneid = applyzoneid;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename == null ? null : zonename.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}