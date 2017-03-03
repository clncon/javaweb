<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>message</title>
     <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
  </head>
  
  <body>
  <div class="error">提示信息！</div>
     <div class="error_info"> ${message}</div>
        <div class="error_back">  <jsp:include page="back.jsp"/></div>
  </body>
</html>
