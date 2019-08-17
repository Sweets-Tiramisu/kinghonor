package com.bbs.manage.controller;

import com.bbs.domain.Report;
import com.bbs.service.IArticleService;
import com.bbs.service.IReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @Autowired
    private IArticleService articleService;

    /**
     * 分页,条件查询
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Report> list = reportService.findByPage();
        PageInfo pageInfo = new PageInfo(list, 6);
        model.addAttribute("reportMsgs", pageInfo);
        return "/ReportPage";
    }

    /**
     * 审核举报信息
     * @param pageNum
     * @param flag
     * @param aid
     * @return
     */
    @GetMapping("/auditReport.do")
    public String auditReport(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum,Integer flag,Integer aid) {
        if (flag==0){
            //驳回
            reportService.changeStatus(aid);
        }else if (flag==1){
            //屏蔽
            reportService.changeStatus(aid);
            articleService.updateReportStatus(aid);
        }
        return "redirect:/report/findByPage.do?pn="+pageNum;
    }





}
