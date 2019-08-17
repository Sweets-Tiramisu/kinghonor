<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>

    <script>
        $(function () {
            //查询用户头像
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user/findUserPicture.do",
                data:{"userid":${sessionScope.user.userid}},
                dataType:"text",
                success:function (data) {
                    $("#userPic").attr("src","${pageContext.request.contextPath}/"+data);
                }
            });


                $("#change").click(function () {
                    if(checkOldPassword() && checkNewPassword()){
                        $.ajax({
                            url:"${pageContext.request.contextPath}/user/userChangePass.do",
                            type:"POST",
                            data:{"userid":${sessionScope.user.userid},"oldPass":$("#oldPassword").val(),"newPass":$("#newPassword").val()},
                            dataType:"text",
                            success:function (data) {
                                if(data=="error"){
                                    $("#changePassword").html("<font color='red'>输入的旧密码错误</font>");
                                }else if(data == "success"){
                                    alert("修改成功,请重新登录");
                                    location.href="${pageContext.request.contextPath}/user/userExist.do";
                                }
                            }
                        });
                    }
                    }
                );

            //校验密码框输入
            function checkOldPassword() {
                var oldPass = $("#oldPassword").val();
                var oldPass_Reg = /^[a-zA-Z0-9]{6,10}$/;
                var boolean = oldPass_Reg.test(oldPass);
                if("" == oldPass){
                    $("#oldPassword").css("border","1px solid red");
                    return false;
                }else{
                    if (boolean){
                        $("#oldPassword").css("border","1px solid green");
                        return true;
                    }else{
                        $("#oldPassword").css("border","1px solid red");
                        return false;
                    }
                }
            }

            function checkNewPassword() {
                var newPass = $("#newPassword").val();
                var newPass_Reg = /^[a-zA-Z0-9]{6,10}$/;
                var boolean = newPass_Reg.test(newPass);
                if("" == newPass){
                    $("#newPassword").css("border","1px solid red");
                    return false;
                }else{
                    if (boolean){
                        $("#newPassword").css("border","1px solid green");
                        return true;
                    }else{
                        $("#newPassword").css("border","1px solid red");
                        $("#changePassword").html("<font color='red'>密码必须是6~10位的英文或数字</font>");
                        return false;
                    }
                }
            }

            $("#oldPassword").blur(checkOldPassword);
            $("#newPassword").blur(checkNewPassword);

        })
    </script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""/></a>
            </h1>
            <div class="search-box l">
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="/index.jsp">首页</a><span>></span>修改密码
        </div>
    </div>
</div>


<!--修改密码-->
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="" id="userPic"/>
                    <div class="username">${sessionScope.user.username}</div>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="info-icon"></i>我的资料</li>
                    <li class="cur"><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="${pageContext.request.contextPath}/user/findUserInfo.do">个人信息</a></li>
                    <li class="cur"><a href="${pageContext.request.contextPath}/user/findUserPwd.do">修改密码</a></li>
                    <c:if test="${user.role == 1}">
                        <li><a href="${pageContext.request.contextPath}/user/findUserApply.do">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${user.role == 2}">
                        <li><a href="${pageContext.request.contextPath}/user/findZoneApply.do">开辟新版块</a></li>
                    </c:if>
                </ul>
                <form action="#" method="post">
                  <ul class="bd">
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>旧密码：</div>
                        <div class="info-r"><input type="password" name="oldPassword" id="oldPassword" class="txt"/></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>新密码：</div>
                        <div class="info-r"><input type="password" name="newPassword" id="newPassword" class="txt"/></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r">
						  <input type="button" id="change" class="btn" value="保存"/>
						  <span style="color:red;" id="changePassword"></span>
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