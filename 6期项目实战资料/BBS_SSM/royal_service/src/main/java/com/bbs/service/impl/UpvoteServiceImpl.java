package com.bbs.service.impl;

import com.bbs.dao.UpvoteDao;
import com.bbs.domain.Upvote;
import com.bbs.domain.UpvoteExample;
import com.bbs.service.IUpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/22.
 */
@Service
public class UpvoteServiceImpl implements IUpvoteService {

    @Autowired
    private UpvoteDao upvoteDao;
    @Override
    public void addUpvote(Upvote upvote) {
        upvoteDao.insert(upvote);
    }

    @Override
    public List findByUsernameAndArticleid(Upvote upvote) {
        UpvoteExample example = new UpvoteExample();
        UpvoteExample.Criteria criteria = example.createCriteria();
        criteria.andUpvoteusernameEqualTo(upvote.getUpvoteusername());
        criteria.andUpvotearticleidEqualTo(upvote.getUpvotearticleid());

        return upvoteDao.selectByExample(example);
    }

    @Override
    public void updateStatus(Upvote upvote) {
        upvoteDao.updateByPrimaryKey(upvote);
    }
}
