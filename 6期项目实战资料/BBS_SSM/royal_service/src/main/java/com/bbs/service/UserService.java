package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface UserService {

    User findUserByuserName(String userName);

    Boolean userRegist(User user);

    /**
     * 后台管理登录
     * @param user
     * @return
     */
    User manageLogin(User user);

    /**
     * 条件查询
     * @param user
     * @return
     */
    List<User> findByPage(User user);

    /**
     * 修改用户禁言状态
     * @param id
     */
    void changeStatus(Integer id);

    /**
     * 根据用户id查询信息
     * @param id
     * @return
     */
    User findById(Integer id);

    User login(User user);

    void updateLastLoginTime(User user);

    void changeUserPass(String userid, String newPass);

    Boolean checkUserPass(String userid, String oldPass);

    void updateLoginStatus(Integer userid, Integer loginstatus);

    List getOnlineUser();

    void updateUserEmail(Integer userid, String email);

    Boolean checkUserEmail(String email);

    void updateUserPicture(Integer userid, String filename);

    User findUserInfo(User user);

    String findUserPicture(String userid);

    void apply(User user);

    void changeApplyStatus(Integer id);

    void changeApplyStatusAndIsupate(Integer id);

    String findPicByName(String username);

    List<User> findPic();
}
