package com.bbs.domain;

public class Zone {
    private Integer zoneid;

    private String zonename;

    private Integer isdef;

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename == null ? null : zonename.trim();
    }

    public Integer getIsdef() {
        return isdef;
    }

    public void setIsdef(Integer isdef) {
        this.isdef = isdef;
    }
}