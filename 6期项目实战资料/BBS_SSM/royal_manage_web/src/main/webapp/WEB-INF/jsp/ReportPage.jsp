<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>举报管理页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../../jsp/commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">审批举报</li>
                    </ol>
                </div>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>帖子ID</th>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${reportMsgs.list}" var="report">
                            <tr>
                                <td width="10%">${report.articleid}</td>
                                <td width="50%" class="line-limit-length">${report.reportcontent}</td>
                                <td width="10%" >
                                    ${report.reportusername}
                                </td>
                                <td width="10%" class="line-limit-length">${report.reporttime}</td>
                                <td width="20%">
                                    <a href="#" onclick="showArticle(${report.articleid})" role="button" class="btn btn-primary">相关帖子</a>
                                    <a href="/report/auditReport.do?aid=${report.articleid}&rid=${report.reportid}&pn=${reportMsgs.pageNum}&flag=1" role="button" class="btn btn-danger" >屏蔽</a>
                                    <a href="/report/auditReport.do?aid=${report.articleid}&rid=${report.reportid}&pn=${reportMsgs.pageNum}&flag=0" role="button" class="btn btn-info" >驳回</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${reportMsgs.pageNum} 页.总共 ${reportMsgs.pages} 页.一共 ${reportMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchReport(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${reportMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchReport('${reportMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${reportMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == reportMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != reportMsgs.pageNum}">
                                    <li><a href="#" onclick="searchReport('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${reportMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchReport('${reportMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchReport('${reportMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp"%>
</body>
<script>
    function searchReport(pn) {
        location.href="/report/findByPage.do?pn="+pn
    }

    function showArticle(id) {
        $.ajax({
            url:'/article/findById.do?id='+id,
            type:'get',
            success:function (res) {
                $("#detail_title").val(res.title);
                $("#detail_content").val(res.content);
                $("#article_detail").modal();
            }
        })
    }

</script>
</html>
