package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.domain.UserExample;
import com.bbs.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByuserName(String userName) {
        User user = userDao.findUserByName(userName);
        return user;
    }

    @Override
    public Boolean userRegist(User user) {
        Date registDate = new Date();
        user.setLastlogintime(registDate);
        int num = userDao.userRegist(user);
        if (num > 0){
            return true;
        }
        return false;
    }
    @Override
    public User manageLogin(User user) {
        try {
            UserExample example=new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername()).andUserpassEqualTo(user.getUserpass()).andRoleEqualTo(3);
            List<User> userTables = userDao.selectByExample(example);
            if (userTables.size()==0){
                return null;
            }else{
                return userTables.get(0);
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<User> findByPage(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (StringUtil.isNotEmpty(user.getUsername()))
            criteria.andUsernameLike("%"+user.getUsername().trim()+"%");
        if (user.getRole()!=null)
            criteria.andRoleEqualTo(user.getRole());
        userExample.setOrderByClause("role desc ,isupdating desc");
        List<User> userList = userDao.selectByExample(userExample);
        return userList;
    }

    @Override
    public void changeStatus(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        if (user.getTalkstatus()==0){
            user.setTalkstatus(1);
        }else if (user.getTalkstatus()==1){
            user.setTalkstatus(0);
        }
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User login(User user) {
        updateLastLoginTime(user);
        return userDao.login(user);
    }

    @Override
    public void updateLastLoginTime(User user) {
        Date lastLoginTime = new Date();
        user.setLastlogintime(lastLoginTime);
        userDao.updateLoginTime(user);
    }

    @Override
    public void changeUserPass(String userid, String newPass) {
        User user = new User();
        user.setUserid(Integer.parseInt(userid));
        user.setUserpass(newPass);
        userDao.changeUserPass(user);
    }

    @Override
    public Boolean checkUserPass(String userid, String oldPass) {
        User u = new User();
        u.setUserid(Integer.parseInt(userid));
        u.setUserpass(oldPass);
        User check = userDao.checkUserPass(u);
        if (check != null){
            //旧密码正确,查到用户
            return true;
        }else{
            //旧密码错误,查不到用户
            return false;
        }
    }

    @Override
    public void updateUserEmail(Integer userid, String email) {
        User user = new User();
        user.setUserid(userid);
        user.setEmail(email);
        userDao.updateUserEmail(user);
    }

    @Override
    public Boolean checkUserEmail(String email) {
        User user = userDao.checkUserEmail(email);
        if(user != null){
            //该邮箱已被注册,无法使用
            return true;
        }
        return false;
    }

    @Override
    public void updateUserPicture(Integer userid, String filename) {
        User user = new User();
        user.setUserid(userid);
        user.setPicurl(filename);
        userDao.updateUserPicture(user);
    }

    @Override
    public User findUserInfo(User user) {
        User userInfo = userDao.findUserInfo(user);
        return userInfo;
    }

    @Override
    public String findUserPicture(String userid) {
        User user = new User();
        user.setUserid(Integer.parseInt(userid));
        User u = userDao.findUserPicture(user);
        if(u.getPicurl() == null){
            return "images/default.png";
        }
        return u.getPicurl();
    }

    @Override
    public void apply(User user) {
        user.setIsupdating(1);
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public void changeApplyStatus(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        user.setUpdatestatus(1);
        user.setRole(2);
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public void changeApplyStatusAndIsupate(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        user.setIsupdating(0);
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public String findPicByName(String username) {
        User user = new User();
        user.setUsername(username);
        User u = userDao.findPicByName(user);
        return u.getPicurl();
    }

    @Override
    public List<User> findPic() {
        return userDao.selectByExample(null);
    }

    @Override
    public void updateLoginStatus(Integer userid, Integer loginstatus) {
        Map map = new HashMap<>();
        map.put("userid",userid);
        map.put("loginstatus",loginstatus);
        userDao.updateLoginStatus(map);
    }

    @Override
    public List getOnlineUser() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginstatusEqualTo(1);
        return userDao.selectByExample(example);
    }
}
