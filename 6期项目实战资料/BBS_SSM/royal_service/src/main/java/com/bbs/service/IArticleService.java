package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/18.
 */
public interface IArticleService {

    public Integer addArticle(Article article);

    Integer getTotalCount();

    Integer getTodayCount();

    void upvoteChange(Integer i, Integer articleid);

    Integer findUpvoteCount(Integer articleid);

    List<Article> findByPage(Article article);

    void changeStatus(Integer id);

    Article findById(Integer id);

    List<Article> getArticleList(Integer zoneid);

    Article getArticle(Integer articleid);

    void replyChange(Integer articleid);

    Integer findReplyCount(Integer articleid);

    void updateReportStatus(Integer articleid);

    void deleteArticle(Integer id);

    List<Article> searchArticle(String articleName,Integer zoneid);

    Integer getCount(String username);
}
