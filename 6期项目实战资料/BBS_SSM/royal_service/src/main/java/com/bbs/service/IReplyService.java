package com.bbs.service;

import com.bbs.domain.Reply;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/19.
 */
public interface IReplyService {
    public void addReply(Reply reply);

    List<Reply> findReplyList(Integer commentid);
}
