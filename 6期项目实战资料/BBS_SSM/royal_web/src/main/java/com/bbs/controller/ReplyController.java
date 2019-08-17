package com.bbs.controller;

import com.bbs.domain.Reply;
import com.bbs.domain.User;
import com.bbs.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geekhoon on 2019/6/19.
 */
@Controller
@RequestMapping("reply")
public class ReplyController {

    @Autowired
    private IReplyService replyService;

    Map<Integer,List> map = new HashMap<>();
    /**
     * 评论
     * @param reply
     * @return
     */
    @RequestMapping("/add")
    public void addReply(HttpServletRequest request, HttpServletResponse response,Reply reply,Integer articleid) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        reply.setReplyusername(user.getUsername());
        replyService.addReply(reply);
        List<Reply> list = replyService.findReplyList(reply.getCommentid());
        map.put(reply.getCommentid(),list);

        request.getSession().setAttribute("replyMap",map);
        response.sendRedirect(request.getContextPath()+"/article/getArticle.do?articleid="+articleid);



    }


}
