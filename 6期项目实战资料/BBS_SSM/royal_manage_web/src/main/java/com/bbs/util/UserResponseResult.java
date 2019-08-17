package com.bbs.util;

import com.bbs.common.ResponseResult;
import com.bbs.common.ResultCode;
import com.bbs.domain.User;

import java.util.List;

public class UserResponseResult extends ResponseResult{

    private List<User> userList;
    private int pageNum;
    private long pages;
    private long total;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public UserResponseResult(ResultCode resultCode) {
        super(resultCode);
    }

    public UserResponseResult(boolean success, int code, String message) {
        super(success, code, message);
    }
}
