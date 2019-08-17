package com.bbs.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/findIndex.do")
    public String findIndex(){
        return "index";
    }

    @RequestMapping("/findRegister.do")
    public String findRedister(){
        return "register";
    }

    @RequestMapping("/findUserInfo.do")
    public String findUserInfo(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        User user1 = userService.findById(user.getUserid());
        request.getSession().setAttribute("user",user1);
        return "userInfo";
    }

    @RequestMapping("/findUserPwd.do")
    public String findUserPwd(){
        return "userPwd";
    }

    @RequestMapping("/findUserApply.do")
    public String findUserApply(){
        return "userApply";
    }

    @RequestMapping("/findZoneApply.do")
    public String findZoneApply(){
        return "zoneApply";
    }

    @RequestMapping("/findUserByUserName.do")
    public @ResponseBody User findUserByUserName(String userName){
        User user = userService.findUserByuserName(userName);
        return user;
    }

    @PostMapping("/userLogin.do")
    @ResponseBody
    public String userLogin(@Param("username")String username, @Param("userPass")String userpass, HttpServletRequest request, Model model){
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        User u = userService.login(user);
        if(u == null){
            //登录失败
            return "false";
        }else{
            //登录成功
            //request.getSession().setAttribute("username",u.getUsername());
            userService.updateLoginStatus(u.getUserid(), 1);
            request.getSession().setAttribute("user",u);
            System.out.println(u);
            return "true";
        }
    }

    @RequestMapping("/userExist.do")
    public void userExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            userService.updateLoginStatus(user.getUserid(),0);
        }
        request.getSession().removeAttribute("user");

       // request.getSession().removeAttribute("username");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @RequestMapping("/userChangePass.do")
    @ResponseBody
    public String userChangePass(String userid,String oldPass,String newPass){
        Boolean checkUserPass = userService.checkUserPass(userid,oldPass);
        if(!checkUserPass){
            //输入的旧密码错误
            return "error";
        }else{
            //输入的旧密码正确
            userService.changeUserPass(userid,newPass);
            return "success";
        }
    }

    @RequestMapping("/upload.do")
    public String userInfoChange(Integer userid,String email,MultipartFile upload,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(email != null){
            userService.updateUserEmail(userid,email);
        }

        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();
        if(filename == null || "".equals(filename)){
            User user = new User();
            user.setUserid(userid);
            User u = userService.findUserInfo(user);
            request.getSession().setAttribute("user",u);
            return "userInfo";
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        int i = filename.lastIndexOf(".");
        filename = filename.substring(i);
        filename = uuid+filename;
        upload.transferTo(new File(path,filename));
        String saveName = "uploads/"+filename;
        userService.updateUserPicture(userid,saveName);

        User user = new User();
        user.setUserid(userid);
        User u = userService.findUserInfo(user);
        request.getSession().setAttribute("user",u);

        return "userInfo";
    }

    @RequestMapping("/findUserPicture.do")
    @ResponseBody
    public String findUserPicture(String userid){
        String path = userService.findUserPicture(userid);
        return path;
    }

    @RequestMapping("findPicByName.do")
    @ResponseBody
    public String findPicByName(String username,HttpServletRequest request){
        if(username != null){
            String picByName = userService.findPicByName(username);
            String path = request.getSession().getServletContext().getContextPath()+picByName;
            return path;
        }
        return request.getSession().getServletContext().getContextPath()+"images/default.png";
    }

    @RequestMapping("/checkUserEmail.do")
    @ResponseBody
    public String checkUserEmail(String email ,HttpServletResponse response){
        response.setContentType("UTF-8");
        Boolean b = userService.checkUserEmail(email);
        if(b){
            //该邮箱已被注册,不能使用
            return "error";
        }else{
            //该邮箱未被注册,可以使用
            return "success";
        }
    }

    @RequestMapping(value = "/findUser.do" ,method = RequestMethod.POST)
    public @ResponseBody User findUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return null;
        }else{
            return user;
        }
    }

    @RequestMapping(value = "/userRegist.do")
    public @ResponseBody User userRegist(String username,String userpass,String email,HttpServletRequest request,RedirectAttributes redirectAttributes){
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setEmail(email);
        user.setTalkstatus(0);
        Boolean regist = userService.userRegist(user);
        User userLogin = userService.findUserByuserName(user.getUsername());

        if (regist){
            userService.updateLoginStatus(userLogin.getUserid(), 1);
            //注册成功
            request.getSession().setAttribute("user",userLogin);
            return user;
        }else{
            //注册失败
            return null;
        }
    }

    @RequestMapping("/getOnlineCount")
    @ResponseBody
    public Integer getOnlineCount(HttpServletRequest request, HttpServletResponse response){
        List<User> list =  userService.getOnlineUser();

        return list.size();
    }

    @RequestMapping("/apply")
    @ResponseBody
    public ResponseResult apply(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        try {
            userService.apply(user);
            return new ResponseResult(CommonCode.SUCCESS);
        }catch (Exception e){
            return new ResponseResult(CommonCode.FAIL);
        }

    }
}
