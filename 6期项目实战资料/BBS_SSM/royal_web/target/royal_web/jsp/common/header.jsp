<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <c:if test="${not empty user.username && !(user.username eq null) }">

                欢迎<c:if test="${user.role == 1}">
                    普通用户:
                </c:if>
                    <c:if test="${user.role == 2}">
                        高级用户:
                    </c:if>
                    <c:if test="${user.role == 3}">
                        超级管理员:
                    </c:if>
                    ${user.username}&nbsp;

                    
                    <a href='${pageContext.request.contextPath}/user/findUserInfo.do'>个人中心</a>
                    <a href='${pageContext.request.contextPath}/user/userExist.do' id='userExist'>注销</a>
                </c:if>
                <c:if test="${empty user.username || (user.username eq null) }">
                <a href="javascript:;" id="login" class="to-login">游客登录</a>

                <a href="${pageContext.request.contextPath}/user/findRegister.do" id="regist">新用户注册</a>
                </c:if>


                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="${pageContext.request.contextPath}/images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form action="" id="LoginForm" method="post">
                        <ul class="editInfos">
                            <span id="check_in"></span>
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <li><input type="button" id="login_btn" value="登录" class="submitBtn"/></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
  $(function () {
      //显示弹框
      $('.box #login').click(function () {
          if(${sessionScope.username == null}){
              var className = $(this).attr('class');
              $('#dialogBg').fadeIn(300);
              $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
              $('#userName').focus();
              $("#j_fixedBar").hide()
          }
      });

      //关闭弹窗
      $('.closeDialogBtn').click(function () {
          $('#dialogBg').fadeOut(300, function () {
              $('#dialog').addClass('bounceOutUp').fadeOut();
              $("#j_fixedBar").show();
          });
      });

      //用户名非空校验
      function checkUserName(){
          var userName_log = $("#userName").val();
          var userName_Reg = /^\s*$/;
          var boolean = userName_Reg.test(userName_log);
          if(boolean){
              return false;
          }else{
              return true;
          }
      }

      //密码非空校验
      function checkPassWord(){
          var userPass_log = $("#userPass").val();
          var userPass_Reg = /^\s*$/;
          var boolean = userPass_Reg.test(userPass_log);
          if(boolean){
              return false;
          }else{
              return true;
          }
      }

      $("#login_btn").click(function () {
          if(checkUserName() && checkPassWord()){
              //可以往后台发送登录请求;
              $.ajax({
                  type:"POST",
                  url:"${pageContext.request.contextPath}/user/userLogin.do",
                  data:{"username":$("#userName").val(),"userpass":$("#userPass").val()},
                  dataType:"JSON",
                  success:function(data){
                      if(data){
                          location.href="${pageContext.request.contextPath}/index.jsp";
                      }else{
                          alert("用户名或密码错误");
                      }
                  }
              })
          }else{
              //用户名或密码输入非法
              alert("请输入用户名和密码");
          }
      });

        //查询已登录的用户信息
      $.post("${pageContext.request.contextPath}/user/findUser.do",{},function(data){
          if(data!=null){
              $("#login").html("欢迎,<a href='${pageContext.request.contextPath}/user/findUserInfo.do?userid='"+data.userid+">"+data.username+"</a>");
              $("#regist").html("<a href='${pageContext.request.contextPath}/user/userExist.do' id='userExist.do'>注销</a>");
          }
      },"json");

      //调用方法校验用户名及密码
      $("#userName").blur(checkUserName);
      $("#userName").blur(checkUserName);

  });
</script>
</html>