package com.bbs.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.domain.User;
import com.bbs.service.IArticleService;
import com.bbs.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by geekhoon on 2019/6/21.
 */
@Controller
@RequestMapping("report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @Autowired
    private IArticleService articleService;


    /**
     * 举报帖子
     * @param report
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult addReport(HttpServletRequest request,@RequestBody  Report report){

          try {
              User user = (User)request.getSession().getAttribute("user");
              Article article = articleService.findById(report.getArticleid());
              if (article.getSendername().equals(user.getUsername())){
                  return new ResponseResult(CommonCode.USERNAMEREPEAT);
              }



              report.setReporttime(new Date());
              report.setReportusername(user.getUsername());
              report.setReportstatus(0);

              reportService.addReport(report);
              return new ResponseResult(CommonCode.SUCCESS);
          }catch (Exception e){
              e.printStackTrace();
              return new ResponseResult(CommonCode.FAIL);
          }



    }




}
