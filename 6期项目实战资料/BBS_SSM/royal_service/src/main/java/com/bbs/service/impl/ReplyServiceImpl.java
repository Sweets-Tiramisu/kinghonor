package com.bbs.service.impl;

import com.bbs.dao.ReplyDao;
import com.bbs.dao.WordDao;
import com.bbs.domain.Reply;
import com.bbs.domain.Word;
import com.bbs.domain.WordExample;
import com.bbs.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/19.
 */
@Service
@Transactional
public class ReplyServiceImpl implements IReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private WordDao wordDao;

    @Override
    public void addReply(Reply reply) {
        replyDao.insert(reply);
    }

    @Override
    public List<Reply> findReplyList(Integer commentid) {
        List<Reply> replyList = replyDao.findAll(commentid);
        WordExample example=new WordExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Word> wordList = wordDao.selectByExample(example);
        for (Reply reply : replyList) {
            for (Word word : wordList) {
                String replyContent = reply.getReplycontent().replaceAll(word.getWord(), "***");
                reply.setReplycontent(replyContent);
            }
        }
        return replyDao.findAll(commentid);
    }
}
