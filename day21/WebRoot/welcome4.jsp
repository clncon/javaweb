<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>welcome</title>
	 
  </head>
  
  <body>
       <%
          session.setAttribute("name","marry");
          session.setAttribute("name","玛丽");
          session.removeAttribute("name");
          
        /*   application.setAttribute("name","mike");
          application.setAttribute("name", "麦克");
          application.removeAttribute("name");
         
          request.setAttribute("name","jack");
          request.setAttribute("name", "杰克");
          request.removeAttribute("name"); */
        %>
  </body>
</html>
