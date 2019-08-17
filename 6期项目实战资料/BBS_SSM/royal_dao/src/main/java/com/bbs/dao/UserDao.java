package com.bbs.dao;

import com.bbs.domain.User;
import com.bbs.domain.UserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void updateUserEmail(User user);

    User checkUserEmail(String email);

    void updateUserPicture(User user);

    User findUserInfo(User user);

    User findUserPicture(User userid);

    void updateLoginStatus(Map map);

    User checkUserPass(User user);

    void changeUserPass(User User);

    void updateLoginTime(User user);

    User login(User user);

    User findUserByName(String userName);

    int userRegist(User user);

    User findPicByName(User user);
}