<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子详细页面</title>
</head>
<body>

<!-- /.帖子详情页 -->
<div class="modal fade article-detail-modal" id="article_detail" tabindex="-1" role="dialog" aria-labelledby="article-detail-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">帖子信息详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal article_detail_form">
                    <div class="form-group">
                        <label for="detail_title" class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" rows="3" name="title" id="detail_title" disabled></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="detail_content" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" rows="3" name="content" id="detail_content" disabled></textarea>
                        </div>
                    </div>
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
