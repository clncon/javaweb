<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <%--   <% String name = (String) pageContext.getAttribute("NAME",pageContext.APPLICATION_SCOPE);%>
               欢迎<%=name%>光临 --%>
               
               <%
                   String name = (String)pageContext.findAttribute("NAME"); 
               %>
               welcome<%=name %>
  </body>           
</html>
