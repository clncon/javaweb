<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
    <link rel="shortcut icon"  href="admin/img/default_userpic.ico">
    <title>梦之队• 当然果园门店管理系统 | header</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
  </head>
  
<body>
	<div class="header">
	
        
        <img src="admin/img/20160317144944.jpg"   border="0"  width="100%" height="90px"/>
        
        
        <div class="header_left">管理员&nbsp; | <a href="StoreServlet?todo=searchStore" target="mainFrame">修改个人资料</a></div>
            <div class="header_center"><jsp:useBean id="now" class="java.util.Date"></jsp:useBean><fmt:formatDate  value="${now}" type="both" pattern="yyyy.MM.dd——HH：mm" /></div>
			<div class="header_right">
				<a href="index.jsp"  target="_top" class="logout">首页</a> | 
				<!--
				<a href="#" class="prev">前进</a> | 
				<a href="#" class="next">后退</a> | 
				-->
				<a href="UserServlet?todo=loginOut" target="_top" class="logout">退出</a></div>
       
        <div class="header_menu">
            
			</div>
        </div>
    </div>
</body>
</html>

