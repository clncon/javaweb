<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>    
    <base href="<%=basePath%>">
    <title>梦之队 • 当然果园系统 | welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
	<div id="welcome_container"><img src="admin/images/welcome_main.jpg"></img></div>
  </body>
</html>
