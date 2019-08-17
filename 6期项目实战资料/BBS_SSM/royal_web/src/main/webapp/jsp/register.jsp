<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {

            var user_flag ;
            var email_flag;
            //检验用户名
            $("#userName_reg").blur(function () {
                if(checkUserName()){
                    var userName = $("#userName_reg").val();
                    $.get("findUserByUserName.do",{"userName":userName},function (data) {
                        $("#checkUserName").text("");
                        $("#checkUserName").attr("style","display:none");
                        if(data.username == null){
                            $("#checkUserName").html("该用户名可以使用");
                            $("#checkUserName").prop("style","color:blue");
                            user_flag = true;
                        }else{
                            $("#checkUserName").html("该用户名已被注册");
                            $("#checkUserName").prop("style","color:red");
                            $("#userName_reg").css("border","1px solid red");
                            user_flag = false;
                        }
                    })
                }

                $("#email").blur(function () {
                        if(checkEmail()){
                            var userEmail = $("#email").val();
                            $.get("checkUserEmail.do",{"email":userEmail},function (data) {
                                $("#checkUserName").text("");
                                $("#checkUserName").attr("style","display:none");
                                if(data == "success"){
                                    $("#checkUserName").html("该邮箱可以使用");
                                    $("#checkUserName").prop("style","color:blue");
                                    email_flag = true;
                                }else{
                                    $("#checkUserName").html("该邮箱已被注册");
                                    $("#checkUserName").prop("style","color:red");
                                    $("#email").css("border","1px solid red");
                                    email_flag = false;
                                }
                            },"text")
                        }
                    }
                )

            });

            $("#reg_btn").click(function () {
                if(checkUserName() && checkPassWord() && checkEmail() && user_flag && email_flag){
                    $.ajax({
                        type:"POST",
                        url:"userRegist.do",
                        data:{"username":$("#userName_reg").val(),"userpass":$("#userPass_reg").val(),"email":$("#email").val()},
                        dataType:"JSON",
                        success:function (data) {
                            if(data.username != null){
                                location.href="${pageContext.request.contextPath}/article/getArticleList.do";
                            }else{
                                alert("注册失败,请联系管理员");
                            }
                        }
                    })
                }
            });

            //校验用户名
            function checkUserName() {
                $("#checkUserName").text("");
                $("#checkUserName").attr("style","display:none");
                var userName_reg = $("#userName_reg").val();
                var userName_Reg =/^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
                var boolean = userName_Reg.test(userName_reg);
                $("#userName_reg").css({border:"none"});
                if(userName_reg == ""){
                    $("#userName_reg").css("border","1px solid red");
                    return false;
                }else{
                    if (boolean ){
                        $("#userName_reg").css("border","1px solid green");
                        return true;
                    }else{
                        $("#userName_reg").css("border","1px solid red");
                        return false;
                    }
                }
            }

            //校验密码
            function checkPassWord() {
                var userPass_in = $("#userPass_reg").val();
                var userPass_Reg =/^[a-zA-Z0-9]{6,10}$/;
                var boolean = userPass_Reg.test(userPass_in);
                $("#userPass_reg").css({border:"none"});
                if("" == userPass_in){
                    //alert("密码不能为空!");
                    $("#userPass_reg").css("border","1px solid red");
                    return false;
                }else{
                    if (boolean){
                        $("#userPass_reg").css("border","1px solid green");
                        return true;
                    }else{
                        //alert("密码格式错误");
                        $("#userPass_reg").css("border","1px solid red");
                        return false;
                    }
                }
            }

            //校验邮箱
            function checkEmail() {
                var email = $("#email").val();
                var email_Reg =/^[0-9A-Za-z][\.-_0-9A-Za-z]*@[0-9A-Za-z]+(\.[0-9A-Za-z]+)+$/;
                var boolean = email_Reg.test(email);
                $("#email").css({border:"none"});
                if(email==""){
                    //alert("邮箱不能为空!");
                    $("#email").css("border","1px solid red");
                    return false;
                }else{
                    if (boolean){
                        $("#email").css("border","1px solid green");
                        return true;
                    }else{
                        //alert("邮箱格式错误");
                        $("#email").css("border","1px solid red");
                        return false;
                    }
                }
            }

            $("#userName_reg").blur(checkUserName);
            //密码校验
            $("#userPass_reg").blur(checkPassWord);
            //邮箱校验
            $("#email").blur(checkEmail);
        })
    </script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="${pageContext.request.contextPath}/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
               <%-- <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>--%>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="user/findIndex.do">首页</a><span></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色星号代表必填）</span></h2>
            <div class="reg-info">
                <form id="registForm" action="" method="post">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="userName_reg" name="userName_reg" class="txt" />
                            </div>
                            <div><span id=""></span></div>
                            <span class="tips">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="userPass_reg" name="userPass_reg" class="txt" />
                            </div>
                            <span class="tips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">
                                <span class="red">*</span> 邮&nbsp;&nbsp;&nbsp;箱：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" />
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="button" id="reg_btn" class="submit-btn" value="注册"/>
                                <span id="checkUserName"></span><br/>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>




<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


</body>
</html>