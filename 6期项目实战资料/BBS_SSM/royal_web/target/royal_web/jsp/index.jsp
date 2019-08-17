<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-new.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
</head>
<script>
    $(function () {
        $.post("/article/getTotalCount.do",{},function(result){
            $("#totalCount").html("全部帖子<strong>"+result+"</strong>")
        });
        $.post("/article/getTodayCount.do",{},function(result){
            $("#todayCount").html("今日帖子<strong>"+result+"</strong>")
        });
        $.post("/user/getOnlineCount.do",{},function(result){
            $("#onlineCount").html("<a href='javascript:;'>在线用户("+result+")</a>");
        });

    })
</script>
<body>

<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>




        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="${pageContext.request.contextPath}/images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span id="todayCount"></span>
                    <span id="totalCount"></span>
                </p>
            </div>
            <div class="search-box l">
                <form action="${pageContext.request.contextPath}/article/searchArticle.do" method="post">
                    <input type="text" class="txt l" placeholder="请输入关键字" name="searchArticle">
                    <input type="hidden" class="txt l" name="zoneid" value="${zoneid}">
                    <input type="submit" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>




        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix">
            <c:forEach var="zone" items="${zoneList}">
                <li class=${zoneid==zone.zoneid? 'current':''}>
                    <a href="${pageContext.request.contextPath}/article/getArticleList.do?zoneid=${zone.zoneid}"><em></em>${zone.zonename}
                    </a>
                </li>
            </c:forEach>
        </ul>




        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">

            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul>
                    <c:if test="${empty articleList}">

                        <c:if test="${not empty user.username && !(user.username eq null) }">
                            <em style="font-size: xx-large">还没有相关帖子哦,<a href="javascript:$('.ft-box').fadeIn(120);" class="newTopic">来一发</a>吧?</em>
                        </c:if>
                        <c:if test="${empty user.username || (user.username eq null) }">
                            <em style="font-size: xx-large">还没有相关帖子哦,<a href="javascript:alert('请先登录')" class="newTopic">来一发</a>吧?</em>
                        </c:if>

                    </c:if>
                    <c:forEach items="${articleList}" var="article">
                        <c:if test="${article.istop == 1}">
                             <li class="clearfix ding">
                        </c:if>
                        <c:if test="${article.istop == 0}">
                            <li class="clearfix">
                        </c:if>
                        <div class="hm-index-title">
                            <i class="set-to-top">顶</i> <a href="/article/getArticle.do?articleid=${article.articleid}">${article.title}</a>
                        </div>
                        <div class="hm-index-con">${article.content}</div>
                        <div class="hm-index-info l">
                            <span class="article-username">${article.sendername}</span>
                            <span class="post-time">${article.sendtimestr}</span>
                        </div>
                        <div class="hm-index-fun r">
                            <span class="icon-like"><i></i>${article.upvotecount}</span>
                            <span class="icon-talk"><i></i>${article.replycount}</span>
                        </div>
                    </li>
                    </c:forEach>

                </ul>
            </div>




            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <span id="onlineCount">
                            <a href='javascript:;'>在线用户(0)</a>
                        </span>
                    </h3>
                    <ul class="b clearfix">
                        <c:forEach items="${onLineUser}" var="user">
                        <li>
                            <div><img src="${pageContext.request.contextPath}/${user.picurl}" height="55"/> </div>
                            <p>${user.username}</p>
                        </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>



        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>



<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <c:if test="${not empty user.username && !(user.username eq null) }">
        <a id="newTopicBtn" href="javascript:;" class="newTopic"><span></span>发帖</a>
    </c:if>
    <c:if test="${empty user.username || (user.username eq null) }">
        <a href="javascript:alert('请先登录！')" class="newTopic"><span></span>发帖</a>
    </c:if>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>

<!-- 发帖弹出框 -->
<form action="${pageContext.request.contextPath}/article/add.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="hidden"  name="zoneid" value="${zoneid}"/>
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表"/>
                </div>
            </div>
        </div>
    </div>
</form>


</body>

</html>