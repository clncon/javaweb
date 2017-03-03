<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>梦之队• 当然果园门店管理系统 | Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="admin/css/login.css" rel="stylesheet" type="text/css" />
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	
	
  </head>
  
  <body>
	<div id="login_container">
		<div id="innerlogin">
            <form action="LoginServlet?do=login" method="post">
                <input name="userName" id="" type="text" class="logininput" value="用户名" onblur="if (this.value == ''){this.value = '用户名';}" onfocus="if (this.value == '用户名'){this.value = '';}"/>
                <input name="userPwd" type="password" class="logininput" value="密码" onblur="if (this.value == ''){this.value = '密码';}" onfocus="if (this.value == '密码'){this.value = '';}"/>
                <input name="" type="submit" class="loginbtn"/>
            </form>
		</div>
    </div>
    <div class="login_footer">Dream &#8226; 当然果园分店管理系统 | Powered by <a href="#">梦之队</a></div>
  </body>
</html>
