package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reply {
    private Integer replyid;//回复id

    private String replycontent;//回复内容

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date replytime;//回复时间

    private String replytimestr;
    private String replyusername;//回复人

    private Integer commentid;//评论编号

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getReplytimestr() {

        if(replytime!=null){
            replytimestr= DateUtils.date2String(replytime,"yyyy-MM-dd HH:mm:ss");
        }
        return replytimestr;
    }

    public void setReplytimestr(String replytimestr) {
        this.replytimestr = replytimestr;
    }

    public String getReplyusername() {
        return replyusername;
    }

    public void setReplyusername(String replyusername) {
        this.replyusername = replyusername == null ? null : replyusername.trim();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
}