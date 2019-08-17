<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛详情页</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common-new.css"/>
    <link rel="stylesheet" type="text/css" href="../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/search.css"/>
    <link rel="stylesheet" type="text/css" href="../css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="../css/getArticle.css"/>
    <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/hm-bbs.js"></script>
</head>
<body>

<!-- 头部 -->
<jsp:include page="common/header.jsp"/>



<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">

        <!--帖子标题，点赞数，回复数，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="../images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix">
                    <h2 class="l">${article.title}</h2>
                    <div class="hm-detail-fun l">
					     <span class="icon-like" id="upvoteCount">
                            <a href='#'><i></i>${article.upvotecount}</a>
					     </span>
                        <span class="icon-talk" id="replyCount">
						     <a href='#'><i></i>${article.replycount}</a>
						</span>
                    </div>
                </div>
            </div>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!--导航，回首页，帖子标题，排序-->
        <div class="detail-page-box clearfix">
            <a href="/index.jsp">
                <i class="hm-ico-home"></i>首页
            </a>
            <span>></span>
            <a href="#">${article.title}</a>
            <a class="new-to-old r" href="" style="font-size:12px;float: right;">
                <i></i>从新到旧查看
            </a>
        </div>


        <div class="detail-box">
            <ul class="detail-floors">

                <!--原帖楼-->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo"><img id="articlePic" src=""/></div>
                        <div class="floorer-name">${article.sendername}</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">发帖时间：${article.sendtimestr}</div>
                            <div class="r">${article.browsecount}</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>${article.content}</p>
                            </div>
                            <div class="floor-ans"></div>
                        </div>
                        <span class="icon-comment">


                             <c:if test="${not empty user.username && !(user.username eq null) }">
                                 <c:if test="${user.talkstatus == 0 }">
                                     <a href="#comment" > <i></i> 评论</a>
                                 </c:if>
                                 <c:if test="${user.talkstatus == 1 }">
                                     <a href="javascript:alert('您已被禁言！')" > <i></i> 评论</a>
                                 </c:if>
                                 <a href="javascript:;" onclick="upvote(${article.articleid})"> <i id="id1"></i> 点赞</a>
                                 <a href="javascript:;" onclick="showDialog1()"> <i id="id2"></i> 举报</a>
                             </c:if>
                            <c:if test="${empty user.username || (user.username eq null) }">
                                <a href="javascript:alert('请先登录！')"> <i></i> 评论</a>
                                <a href="javascript:alert('请先登录！')"> <i id="id1"></i> 点赞</a>
                                <a href="javascript:alert('请先登录！')"> <i id="id2"></i> 举报</a>
                            </c:if>


                        </span>



                    </div>
                </li>

                <c:forEach items="${commentList}" var="comment"  step="1" varStatus="i">
                <!-- 评论部分,一楼及以后 -->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo">
                            <c:forEach items="${userList}" var="user">
                            <c:if test="${comment.commentusername == user.username}">
                            <img src="${pageContext.request.contextPath}/${user.picurl}" id="commentPic"/>
                            </c:if>
                            </c:forEach>
                        </div>
                        <div class="floorer-name">${comment.commentusername}</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">回贴时间：${comment.commenttimestr}</div>
                            <div class="r">${i.index+1}楼</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>${comment.commentcontent}</p>
                            </div>
                            <div class="floor-ans">
                                <ul>
                                    <c:forEach var="reply" items="${replyMap}" >
                                        <c:if test="${reply.key == comment.commentid}">
                                        <c:forEach items="${reply.value}" var="rep">

                                    <!-- 回复部分,楼中楼 -->
                                    <li class="clearfix">
                                        <div class="floor-ans-pho l">
                                          <c:forEach items="${userList}" var="user">
                                                <c:if test="${rep.replyusername == user.username}">
                                                    <img src="${pageContext.request.contextPath}/${user.picurl}"/>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <div class="floor-ans-con l">
                                            <span class="name">${rep.replyusername}</span>：${rep.replycontent}
                                            <span class="ans-time">${rep.replytimestr}</span>
                                        </div>
                                    </li>

                                        </c:forEach>
                                        </c:if>
                                    </c:forEach>

                                </ul>
                            </div>
                            <span class="icon-feedback">
                                    <c:if test="${not empty user.username && !(user.username eq null) }">

                                        <c:if test="${user.talkstatus == 0 }">
                                            <a href="javascript:;" onclick="showDialog(1);getCommentId(${comment.commentid})"> <i id="id3"></i> 回复</a>
                                        </c:if>
                                        <c:if test="${user.talkstatus == 1 }">
                                            <a href="javascript:alert('您已被禁言！')"> <i id="id3"></i> 回复</a>
                                        </c:if>

                                    </c:if>
                                 <c:if test="${empty user.username || (user.username eq null) }">
                                     <a href="javascript:alert('请先登录！');" > <i id="id3"></i> 回复</a>
                                 </c:if>
                            </span>

                        </div>
                    </div>
                </li>
                </c:forEach>
<%--                <!--二楼-->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo"><img src="../images/default.png"/> </div>
                        <div class="floorer-name">不哭不闹不炫耀</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">回贴时间：2017-05-24 10:10:00</div>
                            <div class="r">2楼</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>楼主你好，请按以下建议反馈格式回复，我们会有专人进行收集。祝你游戏愉快。</p>
                            </div>
                            <div class="floor-ans">
                                <ul>

                                    <!-- 回复部分 -->
                                    <li class="clearfix">
                                        <div class="floor-ans-pho l"><img src="../images/default.png"/></div>
                                        <div class="floor-ans-con l">
                                            <span class="name">张无忌</span>：顶顶顶！
                                            <span class="ans-time">2017-05-24 10:11:00</span>
                                        </div>
                                    </li>

                                </ul>
                            </div>
                            <span class="icon-feedback">
                                <a href="javascript:;" onclick="showDialog(2)"> <i></i> 回复</a>
                            </span>
                        </div>
                    </div>
                </li>


                <!--三楼-->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo"><img src="../images/default.png"/></div>
                        <div class="floorer-name">不哭不闹不炫耀</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">回贴时间：2017-05-24 10:10:00</div>
                            <div class="r">3楼</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>楼主你好，请按以下建议反馈格式回复，我们会有专人进行收集。祝你游戏愉快。</p>
                            </div>
                            <div class="floor-ans">
                                <ul>

                                    <!-- 回复部分 -->
                                    <li class="clearfix">
                                        <div class="floor-ans-pho l"><img src="../images/default.png"/></div>
                                        <div class="floor-ans-con l">
                                            <span class="name">张无忌</span>：顶顶顶！
                                            <span class="ans-time">2017-05-24 10:11:00</span>
                                        </div>
                                    </li>

                                </ul>
                            </div>
                            <span class="icon-feedback">
                                <a href="javascript:;" onclick="showDialog(3)"> <i></i> 回复</a>
                            </span>
                        </div>
                    </div>
                </li>--%>


            </ul>
        </div>
        <c:if test="${not empty user.username && !(user.username eq null) }">
        <!--发表评论-->
        <div class="detail-to-comment">
            <div class="tit"><a name="comment">发表评论</a></div>
            <!-- 未登录时候显示 <div class="con">您没有登录论坛，请登录后再进行回复</div>-->

            <!-- 登录后显示评论输入框-->
            <form action="/comment/add.do" method="post" id="comment_form">
                <div class="con con-loged">
                    <div class="con-t">
                        <input type="hidden" name="articleid" value="${article.articleid}">
                        <textarea id="content" name="commentcontent" required="required" placeholder="请在此输入您要回复的信息"></textarea>
                    </div>
                    <div class="con-b">
                        <%--<input type="button" class="btn" id="btn_commentSub" value="提交"/> --%>

                            <c:if test="${user.talkstatus == 0 }">
                                <input type="submit" class="btn" onclick="reply(${article.articleid})"/>
                            </c:if>
                            <c:if test="${user.talkstatus == 1 }">
                                <input value="发表评论" class="btn" onclick="javascript:alert('您已被禁言！')"/>
                            </c:if>



                        <span class="num">不能超过5000字</span>
                    </div>
                </div>
            </form>
        </div>
        </c:if>
    </div>
</div>



<!-- 底部 -->
<div class="hm-footer" style="padding-top:10px;">
    <div class="hm-inner">
        <div class="hm-footer-cpr">
            <p>Copyright@2006-2017 ITCAST. All Rights Reserved</p>
            <p>传智播客 版权所有</p>
        </div>
    </div>
</div>



<!-- 回复弹出框 -->
<form action="/reply/add.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">回复<span id="floorSpan"></span>楼</h4>
                <span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_b">
                    <input type="hidden" value="${article.articleid}" name="articleid">
                    <input type="hidden" value="" name="commentid" id="commentid">
                    <textarea id="replyContent" name="replycontent" required="required" placeholder="回复内容限于40字以内"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="回复" onclick="reply(${article.articleid})" />
                </div>
            </div>
        </div>
    </div>
</form>

<!-- 举报弹出框 -->
<form id="report_form">
    <div class="pop-box1 ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">举报本帖</h4>
                <span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_b">
                    <input type="hidden" name="articleid" value="${article.articleid}">
                    <textarea id="reportContent" name="reportcontent" required="required" placeholder="举报内容限于400字以内"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="button" class="btn" value="举报" id="btn_reportSub"/>
                </div>
            </div>
        </div>
    </div>
</form>



<div class="fixedBar" id="j_fixedBar">
    <c:if test="${not empty user.username && !(user.username eq null) }">
        <a href="#comment" class="newTopic"><span></span>评论</a>
    </c:if>
    <c:if test="${empty user.username || (user.username eq null) }">
        <a href="javascript:alert('请先登录！')" class="newTopic"><span></span>评论</a>
    </c:if>


    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>


</body>

<script type="text/javascript">
//弹出回复框
function showDialog(num) {
    $('.pop-box').css('display', 'block');
    $("#floorSpan").html(num);
}
function showDialog1() {
    $('.pop-box1').css('display', 'block');
}
</script>
<script>
    $(function () {
        $.ajax({
            type:'get',
            async:false,
            dataType:'json',
            contentType:'application/json',
            url:'/upvote/findByUsernameAndArticleid.do',
            data:{"articleid":${article.articleid}},
            success:function (result) {
                if (result){
                    $("#id1").css("background-position","-112px -32px");
                }else{
                    $("#id1").css("background-position","-0px -0px");
                }
            }
        });
    })
    
    
    function getCommentId(id){
        $("#commentid").val(id);
    }
    /*var i = 0;*/
    function upvote(articleid) {



       /* i = i + 1;
        if ( i % 2 == 1){
            $("#id1").css("background-position","-112px -32px");
        }else {
            $("#id1").css("background-position","-0px -0px");
        }*/
        $.ajax({
            type:'get',
            async:false,
            dataType:'json',
            contentType:'application/json',
            url:'/article/upvoteChange.do',
            data:{"articleid":articleid},
            success:function (result) {
                $("#upvoteCount").html("<a href='#'><i></i>"+result+"</a>");
            }
        });

        $.ajax({
            type:'get',
            async:false,
            dataType:'json',
            contentType:'application/json',
            url:'/upvote/findByUsernameAndArticleid.do',
            data:{"articleid":articleid},
            success:function (result) {
                if (result){
                    $("#id1").css("background-position","-112px -32px");
                }else{
                    $("#id1").css("background-position","-0px -0px");
                }
            }
        });

        /*$.post("/upvote/add.do",{"articleid":articleid},function(result){

        });*/

    }
    function reply(articleid) {
        $.post("/article/replyChange.do",{"articleid":articleid},function(result){
            /* $("#totalCount").html("全部帖子<strong>"+result+"</strong>")*/
            $("#upvoteCount").html("<a href='#'><i></i>"+result+"</a>");
        });
    }
</script>
<script>
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
    $(function () {

        //1.给按钮绑定单击事件
        $("#btn_reportSub").click(function () {
            var content = $("#reportContent").val();
            if(content == "" || content == undefined){
                alert("请输入举报内容");
                return;
            }



            //2.发送ajax请求，提交表单数据
            $.ajax({
                type:'post',
                dataType:'json',
                contentType:'application/json',
                url:'/report/add.do',
                data:JSON.stringify($("#report_form").serializeJson()),
                success:function (data) {
                    $('.pop-box1').css('display', 'none');
                    $("#reportContent").val("");
                    if (data.success) {
                        alert("举报成功！")
                    }else if(data.code == 99998){
                        alert("不能举报自己的帖子！")
                    }else {
                        alert("举报失败！")
                    }
                }
            });
        });
    });
</script>

<script>

    $(function () {
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/findPicByName.do",
            data:{"username":"${article.sendername}"},
            dataType:"text",
            success:function (data) {
                $("#articlePic").attr("src","${pageContext.request.contextPath}/"+data);
            }
        });
    });

</script>

</html>