/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-06-24 11:08:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\"/>\r\n");
      out.write("    <title>王者荣耀论坛注册页</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/common.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/common-new.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/search.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/register.css\"/>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.12.4.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("\r\n");
      out.write("            var user_flag ;\r\n");
      out.write("            var email_flag;\r\n");
      out.write("            //检验用户名\r\n");
      out.write("            $(\"#userName_reg\").blur(function () {\r\n");
      out.write("                if(checkUserName()){\r\n");
      out.write("                    var userName = $(\"#userName_reg\").val();\r\n");
      out.write("                    $.get(\"findUserByUserName.do\",{\"userName\":userName},function (data) {\r\n");
      out.write("                        $(\"#checkUserName\").text(\"\");\r\n");
      out.write("                        $(\"#checkUserName\").attr(\"style\",\"display:none\");\r\n");
      out.write("                        if(data.username == null){\r\n");
      out.write("                            $(\"#checkUserName\").html(\"该用户名可以使用\");\r\n");
      out.write("                            $(\"#checkUserName\").prop(\"style\",\"color:blue\");\r\n");
      out.write("                            user_flag = true;\r\n");
      out.write("                        }else{\r\n");
      out.write("                            $(\"#checkUserName\").html(\"该用户名已被注册\");\r\n");
      out.write("                            $(\"#checkUserName\").prop(\"style\",\"color:red\");\r\n");
      out.write("                            $(\"#userName_reg\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                            user_flag = false;\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                $(\"#email\").blur(function () {\r\n");
      out.write("                        if(checkEmail()){\r\n");
      out.write("                            var userEmail = $(\"#email\").val();\r\n");
      out.write("                            $.get(\"checkUserEmail.do\",{\"email\":userEmail},function (data) {\r\n");
      out.write("                                $(\"#checkUserName\").text(\"\");\r\n");
      out.write("                                $(\"#checkUserName\").attr(\"style\",\"display:none\");\r\n");
      out.write("                                if(data == \"success\"){\r\n");
      out.write("                                    $(\"#checkUserName\").html(\"该邮箱可以使用\");\r\n");
      out.write("                                    $(\"#checkUserName\").prop(\"style\",\"color:blue\");\r\n");
      out.write("                                    email_flag = true;\r\n");
      out.write("                                }else{\r\n");
      out.write("                                    $(\"#checkUserName\").html(\"该邮箱已被注册\");\r\n");
      out.write("                                    $(\"#checkUserName\").prop(\"style\",\"color:red\");\r\n");
      out.write("                                    $(\"#email\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                                    email_flag = false;\r\n");
      out.write("                                }\r\n");
      out.write("                            },\"text\")\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                )\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $(\"#reg_btn\").click(function () {\r\n");
      out.write("                if(checkUserName() && checkPassWord() && checkEmail() && user_flag && email_flag){\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        type:\"POST\",\r\n");
      out.write("                        url:\"userRegist.do\",\r\n");
      out.write("                        data:{\"username\":$(\"#userName_reg\").val(),\"userpass\":$(\"#userPass_reg\").val(),\"email\":$(\"#email\").val()},\r\n");
      out.write("                        dataType:\"JSON\",\r\n");
      out.write("                        success:function (data) {\r\n");
      out.write("                            if(data.username != null){\r\n");
      out.write("                                location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/article/getArticleList.do\";\r\n");
      out.write("                            }else{\r\n");
      out.write("                                alert(\"注册失败,请联系管理员\");\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //校验用户名\r\n");
      out.write("            function checkUserName() {\r\n");
      out.write("                $(\"#checkUserName\").text(\"\");\r\n");
      out.write("                $(\"#checkUserName\").attr(\"style\",\"display:none\");\r\n");
      out.write("                var userName_reg = $(\"#userName_reg\").val();\r\n");
      out.write("                var userName_Reg =/^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$/;\r\n");
      out.write("                var boolean = userName_Reg.test(userName_reg);\r\n");
      out.write("                $(\"#userName_reg\").css({border:\"none\"});\r\n");
      out.write("                if(userName_reg == \"\"){\r\n");
      out.write("                    $(\"#userName_reg\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }else{\r\n");
      out.write("                    if (boolean ){\r\n");
      out.write("                        $(\"#userName_reg\").css(\"border\",\"1px solid green\");\r\n");
      out.write("                        return true;\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $(\"#userName_reg\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            //校验密码\r\n");
      out.write("            function checkPassWord() {\r\n");
      out.write("                var userPass_in = $(\"#userPass_reg\").val();\r\n");
      out.write("                var userPass_Reg =/^[a-zA-Z0-9]{6,10}$/;\r\n");
      out.write("                var boolean = userPass_Reg.test(userPass_in);\r\n");
      out.write("                $(\"#userPass_reg\").css({border:\"none\"});\r\n");
      out.write("                if(\"\" == userPass_in){\r\n");
      out.write("                    //alert(\"密码不能为空!\");\r\n");
      out.write("                    $(\"#userPass_reg\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }else{\r\n");
      out.write("                    if (boolean){\r\n");
      out.write("                        $(\"#userPass_reg\").css(\"border\",\"1px solid green\");\r\n");
      out.write("                        return true;\r\n");
      out.write("                    }else{\r\n");
      out.write("                        //alert(\"密码格式错误\");\r\n");
      out.write("                        $(\"#userPass_reg\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            //校验邮箱\r\n");
      out.write("            function checkEmail() {\r\n");
      out.write("                var email = $(\"#email\").val();\r\n");
      out.write("                var email_Reg =/^[0-9A-Za-z][\\.-_0-9A-Za-z]*@[0-9A-Za-z]+(\\.[0-9A-Za-z]+)+$/;\r\n");
      out.write("                var boolean = email_Reg.test(email);\r\n");
      out.write("                $(\"#email\").css({border:\"none\"});\r\n");
      out.write("                if(email==\"\"){\r\n");
      out.write("                    //alert(\"邮箱不能为空!\");\r\n");
      out.write("                    $(\"#email\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }else{\r\n");
      out.write("                    if (boolean){\r\n");
      out.write("                        $(\"#email\").css(\"border\",\"1px solid green\");\r\n");
      out.write("                        return true;\r\n");
      out.write("                    }else{\r\n");
      out.write("                        //alert(\"邮箱格式错误\");\r\n");
      out.write("                        $(\"#email\").css(\"border\",\"1px solid red\");\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(\"#userName_reg\").blur(checkUserName);\r\n");
      out.write("            //密码校验\r\n");
      out.write("            $(\"#userPass_reg\").blur(checkPassWord);\r\n");
      out.write("            //邮箱校验\r\n");
      out.write("            $(\"#email\").blur(checkEmail);\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 头部 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"hm-header\">\r\n");
      out.write("    <div class=\"hm-inner clearfix\">\r\n");
      out.write("        <div class=\"hm-header-t clearfix\">\r\n");
      out.write("            <h1 class=\"logo l\">\r\n");
      out.write("                <a href=\"javascript:;\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/logo.png\" height=\"64\" width=\"168\" alt=\"\"/></a>\r\n");
      out.write("            </h1>\r\n");
      out.write("            <div class=\"search-box l\">\r\n");
      out.write("               ");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"hm-header-b\">\r\n");
      out.write("            <i class=\"hm-ico-home\"></i>\r\n");
      out.write("            <a href=\"user/findIndex.do\">首页</a><span></span>注册页面\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"hm-body hm-body-bgc\">\r\n");
      out.write("    <div class=\"hm-inner\">\r\n");
      out.write("        <div class=\"reg-box\">\r\n");
      out.write("            <h2>用户注册<span>（红色星号代表必填）</span></h2>\r\n");
      out.write("            <div class=\"reg-info\">\r\n");
      out.write("                <form id=\"registForm\" action=\"\" method=\"post\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <div class=\"reg-l\">\r\n");
      out.write("                                <span class=\"red\">*</span> 用户名：\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"reg-c\">\r\n");
      out.write("                                <input type=\"text\" id=\"userName_reg\" name=\"userName_reg\" class=\"txt\" />\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div><span id=\"\"></span></div>\r\n");
      out.write("                            <span class=\"tips\">用户名必须是由英文、数字、下划线组成</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <div class=\"reg-l\">\r\n");
      out.write("                                <span class=\"red\">*</span> 密&nbsp;&nbsp;&nbsp;码：\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"reg-c\">\r\n");
      out.write("                                <input type=\"password\" id=\"userPass_reg\" name=\"userPass_reg\" class=\"txt\" />\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <span class=\"tips\">密码长度必须6~10位的英文或数字</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"no-tips\">\r\n");
      out.write("                            <div class=\"reg-l\">\r\n");
      out.write("                                <span class=\"red\">*</span> 邮&nbsp;&nbsp;&nbsp;箱：\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"reg-c\">\r\n");
      out.write("                                <input type=\"text\" id=\"email\" name=\"email\" class=\"txt\" />\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <div class=\"reg-l\"></div>\r\n");
      out.write("                            <div class=\"reg-c\">\r\n");
      out.write("                                <input type=\"button\" id=\"reg_btn\" class=\"submit-btn\" value=\"注册\"/>\r\n");
      out.write("                                <span id=\"checkUserName\"></span><br/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 底部 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
