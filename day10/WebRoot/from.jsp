<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "java.net.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
       <jsp:forward page = "/come.jsp">
        <jsp:param name = "name" value ='<%=URLEncoder.encode("杰克","UTF-8") %>'/>
        <jsp:param name = "pass" value = "123"/>
       
       </jsp:forward>
  </body>
</html>
