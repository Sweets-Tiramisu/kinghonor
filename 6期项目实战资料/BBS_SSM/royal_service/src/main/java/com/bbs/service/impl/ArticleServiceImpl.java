package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.WordDao;
import com.bbs.domain.Article;
import com.bbs.domain.ArticleExample;
import com.bbs.domain.Word;
import com.bbs.domain.WordExample;
import com.bbs.service.IArticleService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geekhoon on 2019/6/18.
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {


    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private WordDao wordDao;

    /**
     * 发帖
     * @param article
     */
    @Override
    public Integer addArticle(Article article) {
       articleDao.insert(article);
       return article.getArticleid();

    }

    @Override
    public Integer getTotalCount() {
        return articleDao.getTotalCount();
    }

    @Override
    public Integer getTodayCount() {
        return articleDao.getTodayCount();
    }

    @Override
    public void upvoteChange(Integer i, Integer articleid) {
        Map<String,Integer> map = new HashMap();
        map.put("i",i);
        map.put("articleid",articleid);
        articleDao.upvoteChange(map);
    }

    @Override
    public Integer findUpvoteCount(Integer articleid) {

        return articleDao.findUpvoteCount(articleid);
    }

    @Override
    public List<Article> findByPage(Article article) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        if (StringUtil.isNotEmpty(article.getTitle()))
            criteria.andTitleLike("%"+article.getTitle().trim()+"%");
        if (StringUtil.isNotEmpty(article.getSendername()))
            criteria.andSendernameLike("%"+article.getSendername().trim()+"%");
        criteria.andIsreportEqualTo(0);
        articleExample.setOrderByClause("isTop desc,sendTime desc,upvoteCount desc,browseCount desc");
        List<Article> articleList = articleDao.selectByExampleWithBLOBs(articleExample);
        return articleList;
    }

    @Override
    public void changeStatus(Integer id) {
        Article article = articleDao.selectByPrimaryKey(id);
        if (article.getIstop()==0){
            article.setIstop(1);
        }else{
            article.setIstop(0);
        }
        articleDao.updateByPrimaryKey(article);
    }

    @Override
    public Article findById(Integer id) {
        return articleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> getArticleList(Integer zoneid) {

        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIsreportEqualTo(0);
        criteria.andZoneidEqualTo(zoneid);
        example.setOrderByClause("istop desc");
        List<Article> articleList = articleDao.selectByExample(example);
        replaceWord(articleList);
        return articleList;
    }

    @Override
    public Article getArticle(Integer articleid) {
        Article article = articleDao.selectByPrimaryKey(articleid);
        WordExample example=new WordExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Word> wordList = wordDao.selectByExample(example);
        for (Word word : wordList) {
            String title = article.getTitle().replaceAll(word.getWord(), "***");
            String content = article.getContent().replaceAll(word.getWord(), "***");
            article.setTitle(title);
            article.setContent(content);
        }
        return article;
    }

    @Override
    public void replyChange(Integer articleid) {
        articleDao.replyChange(articleid);
    }

    @Override
    public Integer findReplyCount(Integer articleid) {
        return articleDao.findReplyCount(articleid);
    }

    @Override
    public void updateReportStatus(Integer articleid) {
        articleDao.updateReportStatus(articleid);
    }

    @Override
    public void deleteArticle(Integer id) {
        Article article = articleDao.selectByPrimaryKey(id);
        if (article.getIsreport()==0){
            article.setIsreport(1);
        }else{
            article.setIsreport(0);
        }
        articleDao.updateByPrimaryKey(article);
    }

    @Override
    public List<Article> searchArticle(String articleName,Integer zoneid) {
        WordExample example=new WordExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Word> wordList = wordDao.selectByExample(example);
        for (Word word : wordList) {
            if (word.getWord().contains(articleName))
                return new ArrayList<>();
        }
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTitleLike("%"+articleName+"%");
        criteria.andIsreportEqualTo(0);
        criteria.andZoneidEqualTo(zoneid);
        articleExample.setOrderByClause("isTop desc");
        List<Article> articleList = articleDao.selectByExample(articleExample);
        replaceWord(articleList);
        return articleList;
    }

    @Override
    public Integer getCount(String username) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andSendernameEqualTo(username);
        criteria.andIsreportEqualTo(0);
        return articleDao.selectByExample(example).size();
    }

    private void replaceWord(List<Article> articleList) {
        WordExample example=new WordExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Word> wordList = wordDao.selectByExample(example);
        for (Article article : articleList) {
            for (Word word : wordList) {
                String title = article.getTitle().replaceAll(word.getWord(), "***");
                article.setTitle(title);
            }
        }
    }
}
