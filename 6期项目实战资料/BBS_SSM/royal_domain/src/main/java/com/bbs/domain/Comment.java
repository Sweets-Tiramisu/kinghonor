package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private String commentcontent;//评论内容
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date commenttime;//评论时间

    private String commenttimestr;//评论时间

    private String commentusername;//评论人

    private Integer commentstatus;//评论状态

    private Integer articleid;//帖子编号

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public String getCommenttimestr() {
        if(commenttime!=null){
            commenttimestr= DateUtils.date2String(commenttime,"yyyy-MM-dd HH:mm:ss");
        }
        return commenttimestr;
    }

    public void setCommenttimestr(String commenttimestr) {
        this.commenttimestr = commenttimestr;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getCommentusername() {
        return commentusername;
    }

    public void setCommentusername(String commentusername) {
        this.commentusername = commentusername == null ? null : commentusername.trim();
    }

    public Integer getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(Integer commentstatus) {
        this.commentstatus = commentstatus;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
}