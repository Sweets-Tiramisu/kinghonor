package com.bbs.controller;

import com.bbs.domain.Upvote;
import com.bbs.domain.User;
import com.bbs.service.IUpvoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by geekhoon on 2019/6/22.
 */
@Controller
@RequestMapping("upvote")
public class UpvoteController {

    @Autowired
    private IUpvoteService upvoteService;

    @RequestMapping("/add")
    public void addUpvote(Integer articleid, HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        Upvote upvote = new Upvote();
        upvote.setUpvoteusername(user.getUsername());
        upvote.setUpvotearticleid(articleid);

        upvote.setIsupvote(1);
        upvoteService.addUpvote(upvote);



    }

    @RequestMapping("/findByUsernameAndArticleid")
    @ResponseBody
    public String findByUsernameAndArticleid(@Param(value = "articleid") Integer articleid, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Upvote upvote = new Upvote();
        if(user != null){
            upvote.setUpvoteusername(user.getUsername());
        }else {
            return "false";
        }


        upvote.setUpvotearticleid(articleid);
        List<Upvote> list = upvoteService.findByUsernameAndArticleid(upvote);
        if (list.size() == 0 || list.get(0).getIsupvote() == 0){
            return "false";
        }else {
            return "true";
        }



    }
}
