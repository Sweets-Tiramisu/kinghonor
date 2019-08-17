package com.bbs.domain;

import java.io.Serializable;

public class UpvoteKey implements Serializable {
    private String upvoteusername;

    private Integer upvotearticleid;

    public String getUpvoteusername() {
        return upvoteusername;
    }

    public void setUpvoteusername(String upvoteusername) {
        this.upvoteusername = upvoteusername == null ? null : upvoteusername.trim();
    }

    public Integer getUpvotearticleid() {
        return upvotearticleid;
    }

    public void setUpvotearticleid(Integer upvotearticleid) {
        this.upvotearticleid = upvotearticleid;
    }
}