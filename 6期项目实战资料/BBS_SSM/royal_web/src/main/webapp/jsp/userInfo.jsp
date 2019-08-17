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

            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user/findUserPicture.do",
                data:{"userid":${sessionScope.user.userid}},
                dataType:"text",
                success:function (data) {
                    $("#userPic").attr("src","${pageContext.request.contextPath}/"+data);
                }
            });
            //用来判断邮箱是否存在的标记;
            var flag = true;

            $("#changeUserInfo").click(function () {
                // if($("#file").val() != ""){
                //     $("#uploadForm").submit();
                // }else if(flag || $("#file").val() == ""){
                //     $("#uploadForm").submit();
                //  }else if(flag){
                //     alert("选择一张图片");
                // }

                var file=$("#file").val();
                var filename=file.replace(/.*(\/|\\)/, "");
                var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';
                if(fileExt == "jpg" || fileExt == "png" || fileExt == "bmp"){
                    if(flag || $("#file").val() != ""){
                        $("#uploadForm").submit();
                    }
                }else{
                    alert("文件格式不对");
                }

            });

            //校验邮箱格式
            function checkEmail() {
                var email = $("#email").val();
                var email_Reg =/^[0-9A-Za-z][\.-_0-9A-Za-z]*@[0-9A-Za-z]+(\.[0-9A-Za-z]+)+$/;
                var boolean = email_Reg.test(email);
                if (boolean){
                    return true;
                }else{
                    flag = false;
                    return false;
                }
            }

            $("#email").blur(function () {
                if (checkEmail()){
                    $.ajax({
                        url:"${pageContext.request.contextPath}/user/checkUserEmail.do",
                        type:"POST",
                        dataType:"text",
                        data:{"userid":$("#userId").val(),"email":$("#email").val()},
                        success:function (data) {
                            if(data == "error"){
                                $("#checkUserInfo").html("");
                                $("#checkUserInfo").html("<font color='red'/>邮箱已存在</font>");
                                flag = false;
                            }else{
                                $("#checkUserInfo").html("");
                                flag=true;
                            }
                        }
                    })
                }
            })
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
                <a href="javascript:;"><img src="${pageContext.request.contextPath}/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="/index.jsp">首页</a><span>></span>个人信息
        </div>
    </div>
</div>



<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>

            <!--左侧用户名，头像-->
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="" id="userPic"/>
                    <div class="username">${sessionScope.user.username}</div>
                </div>
                <ul class="user-info-l-b">
                    <li class="cur"><i class="info-icon"></i>我的资料</li>
                    <li><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li class="cur"><a href="${pageContext.request.contextPath}/user/findUserInfo.do">个人信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/findUserPwd.do">修改密码</a></li>
                    <c:if test="${user.role == 1}">
                        <li><a href="${pageContext.request.contextPath}/user/findUserApply.do">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${user.role == 2}">
                        <li><a href="${pageContext.request.contextPath}/user/findZoneApply.do">开辟新版块</a></li>
                    </c:if>
                </ul>


                <form action="${pageContext.request.contextPath}/user/upload.do" method="post" id="uploadForm" enctype="multipart/form-data">
                    <ul class="bd">
                        <li class="clearfix">
                            <input type="hidden" id="userId" name="userid" value="${sessionScope.user.userid}"/>
                            <div class="info-l"><i class="red">*</i>用户名：</div>
                            <div class="info-r"><input type="text" class="txt" value="${sessionScope.user.username}" readonly="readonly" /></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">邮箱地址：</div>
                            <div class="info-r"><input type="text" id="email" name="email" class="txt" value="${sessionScope.user.email}" /></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">上传头像：</div>
                            <div class="info-r"><input type="file" id="file" name="upload" class="file-btn"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input type="button" id="changeUserInfo" class="btn" value="保存"/>
                                <span style="color:red;" id="checkUserInfo"></span>
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