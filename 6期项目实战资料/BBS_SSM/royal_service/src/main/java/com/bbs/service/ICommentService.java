package com.bbs.service;

import com.bbs.domain.Comment;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/19.
 */
public interface ICommentService {
    public void addComment(Comment comment);

    public List<Comment> findCommentList(Integer articleid);
}
