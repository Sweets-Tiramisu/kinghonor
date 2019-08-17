package com.bbs.controller;

import com.bbs.domain.*;
import com.bbs.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by geekhoon on 2019/6/18.
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IReplyService replyService;
    @Autowired
    private IZoneService zoneService;

    @Autowired
    private UserService userService;

    @Autowired
    private IUpvoteService upvoteService;

    /**
     * 发帖
     * @param article
     * @return
     */
    @RequestMapping("/add")
    public void addArticle(HttpServletRequest request, HttpServletResponse response, Article article) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        article.setSendtime(new Date());
        if (user == null){

        }else{
            article.setSendername(user.getUsername());
        }
        article.setIstop(0);
        article.setReplycount(0);
        article.setUpvotecount(0);
        article.setBrowsecount(0);
        article.setIsreport(0);
        article.setZoneid(article.getZoneid());
        Integer articleid =  articleService.addArticle(article);
        response.sendRedirect(request.getContextPath()+"/article/getArticle.do?articleid="+articleid);
    }

    @RequestMapping("/getTotalCount")
    @ResponseBody
    public Integer getTotalCount(){
        Integer totalCount = articleService.getTotalCount();
        return totalCount;
    }

    @RequestMapping("/getTodayCount")
    @ResponseBody
    public Integer getTodayCount(){
        Integer todayCount = articleService.getTodayCount();
        return todayCount;
    }

    @RequestMapping("/upvoteChange")
    @ResponseBody
    public Integer upvoteChange(@Param(value = "articleid") Integer articleid, HttpServletRequest request) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        Upvote upvote = new Upvote();
        upvote.setUpvotearticleid(articleid);
        upvote.setUpvoteusername(user.getUsername());
        List<Upvote> list = upvoteService.findByUsernameAndArticleid(upvote);
        if(list.size() == 0){
            upvote.setIsupvote(1);
            upvoteService.addUpvote(upvote);
            articleService.upvoteChange(1,articleid);
        }else if (list.get(0).getIsupvote() == 1){
            upvote.setIsupvote(0);
            upvoteService.updateStatus(upvote);
            articleService.upvoteChange(-1,articleid);
        }else if (list.get(0).getIsupvote() == 0){
            upvote.setIsupvote(1);
            upvoteService.updateStatus(upvote);
            articleService.upvoteChange(1,articleid);
        }

        Integer upvoteCount = articleService.findUpvoteCount(articleid);

        return upvoteCount;

    }
    @RequestMapping("/replyChange")
    @ResponseBody
    public Integer replyChange(Integer articleid,HttpServletRequest request) throws IOException {

        articleService.replyChange(articleid);
        Integer replyCount = articleService.findReplyCount(articleid);
        return replyCount;

    }



    @PostMapping("/searchArticle.do")
    public String searchArticle(Model model,String searchArticle,@RequestParam(required = false, defaultValue = "1", value = "zoneid") Integer zoneid){
        List<Article> articleList=articleService.searchArticle(searchArticle.trim(),zoneid);
        List<Zone> zoneList=zoneService.findZoneList();
        model.addAttribute("articleList",articleList);
        model.addAttribute("zoneList",zoneList);
        model.addAttribute("zoneid",zoneid);
        return "index";
    }



    @RequestMapping("/getArticleList")
    public String getArticleList(Model model,HttpServletRequest request,@RequestParam(required = false, defaultValue = "1", value = "zoneid") Integer zoneid){
        List<Article> list = articleService.getArticleList(zoneid);
        request.getSession().setAttribute("articleList",list);

        List onlineUser = userService.getOnlineUser();
        request.getSession().setAttribute("onLineUser",onlineUser);
        List<Zone> zoneList=zoneService.findZoneList();
        model.addAttribute("zoneList",zoneList);
        model.addAttribute("zoneid",zoneid);
        return "index";
    }

    @RequestMapping("/getArticle")
    public String getArticle(Integer articleid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Article article = articleService.getArticle(articleid);
        request.getSession().setAttribute("article",article);
        List<Comment> list = commentService.findCommentList(articleid);
        request.getSession().setAttribute("commentList",list);
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            Comment comment = list.get(i);


            List<Reply> replyList = replyService.findReplyList(comment.getCommentid());
            map.put(comment.getCommentid(),replyList);
        }
        List<User> userlist = userService.findPic();
        request.getSession().setAttribute("userList",userlist);

        request.getSession().setAttribute("replyMap",map);

        return "getArticle";
    }

    @RequestMapping("/getCount")
    @ResponseBody
    public Integer getCount(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");

        Integer count = articleService.getCount(user.getUsername());
        return count;
    }

}
