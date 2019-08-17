package com.bbs.common;



/**
 * @Author: Conan.
 * @Description:
 * @Modified By:
 */
public enum CommonCode implements ResultCode{

    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    LOGINFAIL(false,10003,"账号或密码错误！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    USERNAMEREPEAT(false,99998,"用户名重复");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "CommonCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
