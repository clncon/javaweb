<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'header.jsp' starting page</title>
  </head>
  <body>
	<%for(int i=1;i<=6;i++){ %>
     <h<%=i %>>javaWeb</h<%=i %>>
	<%
              }
           %>
</body>
</html>
