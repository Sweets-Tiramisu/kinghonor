<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词管理页面</title>

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
                        <li class="active">敏感词汇管理</li>
                    </ol>
                </div>
                <button class="btn btn-primary" onclick="showAddModal()">新增敏感词</button>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${wordMsgs.list}" var="word" varStatus="index">
                            <tr>
                                <td width="10%">${index.index+1}</td>
                                <td width="50%" class="line-limit-length">${word.word}</td>
                                <td width="10%" >
                                    <c:if test="${word.status==0}">
                                        使用中
                                    </c:if>
                                    <c:if test="${word.status==1}">
                                        已停用
                                    </c:if>

                                </td>
                                <td width="20%">
                                    <c:if test="${word.status==0}">
                                        <a href="/word/changeStatus.do?wid=${word.wordid}&pn=${wordMsgs.pageNum}" role="button" class="btn btn-danger" >停用</a>
                                    </c:if>
                                    <c:if test="${word.status==1}">
                                        <a href="/word/changeStatus.do?wid=${word.wordid}&pn=${wordMsgs.pageNum}" role="button" class="btn btn-primary" >启用</a>
                                    </c:if>

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
                    当前第 ${wordMsgs.pageNum} 页.总共 ${wordMsgs.pages} 页.一共 ${wordMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchWord(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${wordMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchWord('${wordMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${wordMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == wordMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != wordMsgs.pageNum}">
                                    <li><a href="#" onclick="searchWord('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${wordMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchWord('${wordMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchWord('${wordMsgs.pages}')">尾页</a></li>
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
<%@ include file="WordUpdate.jsp"%>
</body>
<script>
    function searchWord(pn) {
        location.href="/word/findByPage.do?pn="+pn;
    }

    function showAddModal() {
        $("#word_add").modal();
    }

</script>
</html>
