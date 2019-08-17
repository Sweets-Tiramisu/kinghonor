<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">用户管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="/user/findByPage.do" >用户信息</a></li>
            </ul>
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="/zoneApply/findByPage.do" >版块审核</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">用户帖管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="/article/findByPage.do" >帖子信息</a></li>
            </ul>
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="/word/findByPage.do" >敏感词汇管理</a></li>
            </ul>
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="/report/findByPage.do" >审批举报</a></li>
            </ul>
        </li>
    </ul>
</div>

</body>
</html>
