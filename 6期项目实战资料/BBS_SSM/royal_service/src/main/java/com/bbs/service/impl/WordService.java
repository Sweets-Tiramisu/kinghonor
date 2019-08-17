package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.domain.WordExample;
import com.bbs.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService implements IWordService {

    @Autowired
    private WordDao wordDao;

    @Override
    public List<Word> findByPage() {
        WordExample wordExample = new WordExample();
        wordExample.setOrderByClause("status desc");
        List<Word> wordList = wordDao.selectByExample(wordExample);
        return wordList;
    }

    @Override
    public boolean add(Word word) {
        WordExample wordExample = new WordExample();
        if (word.getWord()!=null){
            WordExample.Criteria criteria = wordExample.createCriteria();
            criteria.andWordEqualTo(word.getWord());
            List<Word> wordList = wordDao.selectByExample(wordExample);
            if (wordList.size()==0){
                word.setStatus(0);
                wordDao.insert(word);
                return true;
            }
        }
       return false;
    }

    @Override
    public void changeStatus(Integer wid) {
        Word word = wordDao.selectByPrimaryKey(wid);
        if (word.getStatus()==0){
            word.setStatus(1);
        }else{
            word.setStatus(0);
        }
        wordDao.updateByPrimaryKey(word);
    }
}
