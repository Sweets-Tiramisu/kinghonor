package com.bbs.service;

import com.bbs.domain.Upvote;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/22.
 */
public interface IUpvoteService {
    void addUpvote(Upvote upvote);

    List findByUsernameAndArticleid(Upvote upvote);

    void updateStatus(Upvote upvote);
}
