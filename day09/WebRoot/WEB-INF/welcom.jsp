<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
       <% 
         String username =(String)session.getAttribute("USERNAME");  
        %>
        欢迎<%=username %>光临网页
        <a href = "/day09/exitServlet">注销</a>
  </body>
</html>
