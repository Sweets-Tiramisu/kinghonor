<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子详细页面</title>
</head>
<body>

<!-- /.帖子详情页 -->
<div class="modal fade zone-detail-modal" id="zone_detail" tabindex="-1" role="dialog" aria-labelledby="zone-detail-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">当前版块</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal zone_detail_form">

                    <c:forEach var="zone" items="${zoneList}">
                        <div class="form-group">
                            <div class="col-sm-8">
                                <input class="form-control" disabled value="${zone.zonename}">
                            </div>
                        </div>
                    </c:forEach>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</body>
</html>
