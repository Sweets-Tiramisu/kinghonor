package com.bbs.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.domain.User;
import com.bbs.domain.ZoneApply;
import com.bbs.service.IZoneApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by geekhoon on 2019/6/23.
 */
@Controller
@RequestMapping("zoneApply")
public class ZoneApplyController {

    @Autowired
    private IZoneApplyService zoneApplyService;


    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(@RequestBody ZoneApply zoneApply, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        zoneApply.setUsername(user.getUsername());
        zoneApply.setStatus(0);
        try {
            zoneApplyService.add(zoneApply);
            return new ResponseResult(CommonCode.SUCCESS);
        }catch (Exception e){
            return new ResponseResult(CommonCode.FAIL);
        }


    }
}
