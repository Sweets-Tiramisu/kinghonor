package com.bbs.controller;

import com.bbs.domain.Comment;
import com.bbs.domain.User;
import com.bbs.service.ICommentService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by geekhoon on 2019/6/19.
 */
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private UserService userService;


    /**
     * 发表评论
     * @param comment
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public void addComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
       try {
           User user = (User)request.getSession().getAttribute("user");
           comment.setCommenttime(new Date());
           comment.setCommentusername(user.getUsername());
           comment.setCommentstatus(0);

           commentService.addComment(comment);
           List<Comment> list = commentService.findCommentList(comment.getArticleid());
           request.getSession().setAttribute("commentList",list);




           response.sendRedirect(request.getContextPath()+"/article/getArticle.do?articleid="+comment.getArticleid());
       }catch (Exception e){
       }
    }




}
