package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private Integer articleid;

    private String title;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date sendtime;



    private String sendtimestr;

    private String sendername;

    private Integer istop;

    private Integer replycount;

    private Integer upvotecount;

    private Integer browsecount;

    private Integer isreport;

    private Integer zoneid;

    private String content;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendtimestr() {
        if(sendtime!=null){
            sendtimestr= DateUtils.date2String(sendtime,"yyyy-MM-dd HH:mm:ss");
        }
        return sendtimestr;
    }

    public void setSendtimestr(String sendtimestr) {
        this.sendtimestr = sendtimestr;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }


    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Integer getUpvotecount() {
        return upvotecount;
    }

    public void setUpvotecount(Integer upvotecount) {
        this.upvotecount = upvotecount;
    }

    public Integer getBrowsecount() {
        return browsecount;
    }

    public void setBrowsecount(Integer browsecount) {
        this.browsecount = browsecount;
    }

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    public Integer getIsreport() {
        return isreport;
    }

    public void setIsreport(Integer isreport) {
        this.isreport = isreport;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}