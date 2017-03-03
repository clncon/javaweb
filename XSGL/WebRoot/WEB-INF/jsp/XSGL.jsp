<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>XSGL</title>
    <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
  </head>
  <body>
 
 	<div class="title">学生信息管理主页 </div>  
 	<div class="outer"> 
    <ul>
       <li> <a href="${pageContext.request.contextPath}/stuServlet?method=findAllStudent&currentPageNo=1" >学生信息</a>
    </ul>
    </div>   
  </body>
</html>
