<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
       <%
         String name = request.getParameter("name");
          name= URLDecoder.decode(name, "UTF-8");
         String pass = request.getParameter("pass");
        %>
        用户名：<%=name %>密码：<%=pass %>
  </body>
</html>
