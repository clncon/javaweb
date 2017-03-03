<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
      <%
       pageContext.setAttribute("userName", "莉莉");
       %>
      <c:remove var="userName" scope="page"/> 
       <c:out value="${userName}" default="无名"/>
  </body>
</html>
