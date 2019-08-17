package com.bbs.manage.controller;

import com.bbs.domain.ZoneApply;
import com.bbs.service.IZoneApplyService;
import com.bbs.service.IZoneService;
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
@RequestMapping("/zoneApply")
public class ZoneApplyController {

    @Autowired
    private IZoneApplyService zoneApplyService;

    @Autowired
    private IZoneService zoneService;

    /**
     * 分页,条件查询
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<ZoneApply> list = zoneApplyService.findByPage();
        PageInfo pageInfo = new PageInfo(list, 6);
        model.addAttribute("zoneMsgs", pageInfo);
        model.addAttribute("zoneList",zoneService.findZoneList());
        return "/ZonePage";
    }

    /**
     * 审核新增版块信息
     * @param pageNum
     * @param flag
     * @param zid
     * @return
     */
    @GetMapping("/auditZone.do")
    public String auditReport(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum,Integer flag,Integer zid) {
        if (flag==0){
            //驳回
            zoneApplyService.changeStatus(zid);
        }else if (flag==1){
            //新增版块
            zoneApplyService.changeStatus(zid);
            zoneService.addZone(zid);
        }
        return "redirect:/zoneApply/findByPage.do?pn="+pageNum;
    }





}
