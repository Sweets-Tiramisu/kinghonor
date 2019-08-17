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
        $.ajax({
            type:'get',
            dataType:'json',
            contentType:'application/json',
            url:'/article/getCount.do',
            data:{},
            success:function (result) {
                $("#articleCount").html(result);
            }
        });

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/findUserPicture.do",
            data:{"userid":${sessionScope.user.userid}},
            dataType:"text",
            success:function (data) {
                $("#userPic").attr("src","${pageContext.request.contextPath}/"+data);
            }
        });


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
                    <li><a href="${pageContext.request.contextPath}/user/findUserPwd.do">修改密码</a></li>
                    <c:if test="${user.role == 1}">
                    <li class="cur"><a href="${pageContext.request.contextPath}/user/findUserApply.do">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${user.role == 2}">
                        <li class="cur"><a href="${pageContext.request.contextPath}/user/findZoneApply.do">开辟新版块</a></li>
                    </c:if>
                </ul>
                <form action="#" method="post">
                  <ul class="bd">
                    <li class="clearfix">
                        <div class="info-l" style="padding-left: 60px"><i class="red" style="font-size: 16px">高级特权:</i></div>
                        <div class="info-r"style="padding-top: 5px"><i class="black" style="font-size: 16px">开辟新版块</i></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l" style="padding-left: 60px"><i class="red" style="font-size: 16px">申请条件:</i></div>
                        <div class="info-r"style="padding-top: 5px"><i class="black" style="font-size: 16px">发帖数 ≥ 5</i></div>
                    </li>
                      <li class="clearfix">
                          <div class="info-l" style="padding-left: 60px"><i class="red" style="font-size: 16px">当前发帖数:</i></div>
                          <div class="info-r" style="padding-top: 5px"><span id="articleCount" ></span></div>
                      </li>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r">
						  <input type="button" class="btn" value="申请" onclick="apply()"/>
                            <script type="text/javascript">
                                function apply() {
                                    var count =  $("#articleCount").html();
                                    if (count < 5){
                                        alert("发帖数小于5，不满足条件！")
                                        return;
                                    }else {
                                        $.ajax({
                                            type:'get',
                                            dataType:'json',
                                            contentType:'application/json',
                                            url:'/user/apply.do',
                                            data:{},
                                            success:function (result) {
                                               if (result.success){
                                                   alert("申请成功，待审核！");
                                                   location.href="http://localhost:8081/user/findUserInfo.do";
                                               }else{
                                                   alert("申请失败！");
                                               }
                                            }
                                        });
                                    }
                                }
                            </script>
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