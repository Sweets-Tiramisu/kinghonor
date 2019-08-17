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
                <form action="#" method="post" id="zoneApply_form">
                    <ul class="bd">
                        <li class="clearfix">
                            <input type="hidden" id="userId" name="userid" value="${sessionScope.user.userid}"/>
                            <div class="info-l"><i></i>版块名称:</div>
                            <div class="info-r"><input type="text" class="txt" name="zonename" /></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">申请理由:</div>
                            <div class="info-r"><textarea  name="reason" required="required" placeholder="请在此输入申请理由" style="width:200px; height:100px; border:solid 1px #ddd; resize:none;"></textarea></div>
                        </li>

                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input type="button" class="btn" value="申请" onclick="zoneApply()"/>
                                <script type="text/javascript">
                                    function zoneApply() {
                                        $.fn.serializeJson=function(){
                                            var serializeObj={};
                                            var array=this.serializeArray();
                                            var str=this.serialize();
                                            $(array).each(function(){
                                                if(serializeObj[this.name]){
                                                    if($.isArray(serializeObj[this.name])){
                                                        serializeObj[this.name].push(this.value);
                                                    }else{
                                                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                                                    }
                                                }else{
                                                    serializeObj[this.name]=this.value;
                                                }
                                            });
                                            return serializeObj;
                                        };
                                        $.ajax({
                                            type:'post',
                                            dataType:'json',
                                            contentType:'application/json',
                                            url:'/zoneApply/add.do',
                                            data:JSON.stringify($("#zoneApply_form").serializeJson()),
                                            success:function (data) {
                                                if (data.success){
                                                    alert("申请成功，待审核！");
                                                    $("#zoneApply_form")[0].reset();
                                                }else{
                                                    alert("申请失败！");
                                                }
                                            }
                                        });

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