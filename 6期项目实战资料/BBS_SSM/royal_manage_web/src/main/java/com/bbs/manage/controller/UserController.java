package com.bbs.manage.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login.do")
    public ResponseResult checkLogin(@RequestBody User user) {
        User loginUser = userService.manageLogin(user);
        if (loginUser == null) {
            //验证失败
            return new ResponseResult(CommonCode.LOGINFAIL);
        }
        //验证成功
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 分页,条件查询
     *
     * @param model
     * @param pageNum
     * @param user
     * @return
     */
    @GetMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, User user) {
        try {
            if (user.getUsername() != null)
                user.setUsername(new String(user.getUsername().getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        PageHelper.startPage(pageNum, 6);
        List<User> list = userService.findByPage(user);
        PageInfo pageInfo = new PageInfo(list, 6);
        model.addAttribute("userMsgs", pageInfo);
        model.addAttribute("userSearch", user);
        return "/UserPage";
    }

    /**
     * 修改禁言状态
     *
     * @param id
     * @param pageNum
     * @param user
     */
    @GetMapping("/changeStatus.do")
    public String changeStatus(@RequestParam("id") Integer id, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, User user) {
        userService.changeStatus(id);
        String username = "";
        if (user.getUsername() != null) {
            username = user.getUsername();
        }
        if (user.getRole() != null) {
            return "redirect:/user/findByPage.do?username=" + username + "&pn=" + pageNum + "&role=" + user.getRole();
        } else {
            return "redirect:/user/findByPage.do?username=" + username + "&pn=" + pageNum + "&role=";
        }

    }

    @GetMapping("/changeApplyStatus.do")
    public String changeApplyStatus(@RequestParam("id") Integer id, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, User user,Integer flag) {
        if (flag==0){
            //升级
            userService.changeApplyStatus(id);
        }else if (flag==1){
            //驳回
            userService.changeApplyStatusAndIsupate(id);
        }
        String username = "";
        if (user.getUsername() != null) {
            username = user.getUsername();
        }
        if (user.getRole() != null) {
            return "redirect:/user/findByPage.do?username=" + username + "&pn=" + pageNum + "&role=" + user.getRole();
        } else {
            return "redirect:/user/findByPage.do?username=" + username + "&pn=" + pageNum + "&role=";
        }
    }
}
