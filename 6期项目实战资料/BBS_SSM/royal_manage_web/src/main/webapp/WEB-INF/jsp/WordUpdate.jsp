<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加敏感词汇</title>
</head>
<body>

<!-- /.帖子详情页 -->
<div class="modal fade word-add-modal" id="word_add" tabindex="-1" role="dialog" aria-labelledby="word-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">添加敏感词汇</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal word_add_form" id="word_add_form">
                    <div class="form-group">
                        <label for="add_word" class="col-sm-2 control-label">敏感词</label>
                        <div class="col-sm-8">
                            <input class="form-control" name="word" id="add_word">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="addWord()">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
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

    function addWord() {
        $.ajax({
            url:'/word/addWord.do',
            type:'post',
            dataType:'json',
            contentType:'application/json',
            data:JSON.stringify($("#word_add_form").serializeJson()),
            success:function (data) {
                if(data.success){
                    alert(data.message);
                    location.href="/word/findByPage.do?pn=${wordMsgs.pageNum}";
                }else{
                    alert(data.message)
                    $('#word_add').modal('hide')
                }
            }
        })
    }
</script>
</html>
