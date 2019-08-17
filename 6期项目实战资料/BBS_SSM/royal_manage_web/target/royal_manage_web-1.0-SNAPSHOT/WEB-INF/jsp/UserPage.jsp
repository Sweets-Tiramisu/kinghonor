<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理页面</title>

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
                        <li><a href="#">用户管理</a></li>
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="searchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="user_name" class="control-label">用户名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="user_name" class="form-control"
                                               name="username" value="${userSearch.username}">
                                        <input type="hidden" id="pageNum" name="pn" value="${userMsgs.pageNum}">
                                    </th>
                                    <th>
                                        <label for="user_role" class="control-label">用户组:</label>
                                    </th>
                                    <th>
                                        <select id="user_role" class="form-control" name="role">
                                            <option ></option>
                                            <option value=1 <c:if test="${userSearch.role==1}">selected</c:if> >普通用户</option>
                                            <option value=2 <c:if test="${userSearch.role==2}">selected</c:if> >高级用户</option>
                                            <option value=3 <c:if test="${userSearch.role==3}">selected</c:if> >超级管理员</option>
                                        </select>
                                    </th>
                                    <th colspan="2">
                                        <input type="button" value="查询" class="form-control btn-primary" onclick="searchUser(1)">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>用户组</th>
                        <th>邮箱</th>
                        <th>是否禁言</th>
                        <th>最近登录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userMsgs.list}" var="user">
                            <tr>
                                <td width="10%">${user.username}</td>
                                <td width="10%" class="line-limit-length">
                                    <c:if test="${user.role==1}">
                                        普通用户
                                    </c:if>
                                    <c:if test="${user.role==2}">
                                        高级用户
                                    </c:if>
                                    <c:if test="${user.role==3}">
                                        超级管理员
                                    </c:if>
                                </td>
                                <td width="10%" class="line-limit-length">${user.email}</td>
                                <td width="10%" class="line-limit-length">
                                    <c:if test="${user.talkstatus==0}">
                                        否
                                    </c:if>
                                    <c:if test="${user.talkstatus==1}">
                                        是
                                    </c:if>
                                </td>
                                <td width="25%">
                                    ${user.lastlogintime}
                                </td>
                                <td width="27%">
                                    <c:if test="${user.updatestatus==1||user.isupdating==0}">
                                        <a href="#" role="button" class="btn btn-primary" disabled >升级</a>
                                    </c:if>
                                    <c:if test="${user.updatestatus==0&&user.isupdating==1}">
                                        <a href="/user/changeApplyStatus.do?id=${user.userid}&pn=${userMsgs.pageNum}&username=${userSearch.username}&role=${userSearch.role}&flag=0" role="button" class="btn btn-primary" >升级</a>
                                        <a href="/user/changeApplyStatus.do?id=${user.userid}&pn=${userMsgs.pageNum}&username=${userSearch.username}&role=${userSearch.role}&flag=1" role="button" class="btn btn-primary" >驳回</a>
                                    </c:if>
                                    <c:if test="${user.talkstatus==0}">
                                        <a href="/user/changeStatus.do?id=${user.userid}&pn=${userMsgs.pageNum}&username=${userSearch.username}&role=${userSearch.role}" role="button" class="btn btn-danger" style="right: 0px">禁言</a>
                                    </c:if>
                                    <c:if test="${user.talkstatus==1}">
                                        <a href="/user/changeStatus.do?id=${user.userid}&pn=${userMsgs.pageNum}&username=${userSearch.username}&role=${userSearch.role}" role="button" class="btn btn-info" style="right: 0px">恢复</a>
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
                    当前第 ${userMsgs.pageNum} 页.总共 ${userMsgs.pages} 页.一共 ${userMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchUser(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${userMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchUser('${userMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${userMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == userMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != userMsgs.pageNum}">
                                    <li><a href="#" onclick="searchUser('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${userMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchUser('${userMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchUser('${userMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

</body>
<script>
    function searchUser(pn) {
        $('#pageNum').val(pn);
        $("#searchForm").attr('action','/user/findByPage.do');
        $("#searchForm").submit();
    }


</script>
</html>
