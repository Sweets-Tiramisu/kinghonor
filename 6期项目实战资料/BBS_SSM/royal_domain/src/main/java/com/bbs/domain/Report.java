package com.bbs.domain;

import java.util.Date;

public class Report {
    private Integer reportid;

    private String reportcontent;

    private Date reporttime;

    private String reportusername;

    private Integer reportstatus;

    private Integer articleid;

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getReportusername() {
        return reportusername;
    }

    public void setReportusername(String reportusername) {
        this.reportusername = reportusername == null ? null : reportusername.trim();
    }

    public Integer getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(Integer reportstatus) {
        this.reportstatus = reportstatus;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
}