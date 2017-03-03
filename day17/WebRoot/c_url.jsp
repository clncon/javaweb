<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>url</title>
  </head>
  <body>
     <a href="/day17/value.jsp?country=<%=URLEncoder.encode("中国","utf-8")%>">传统方式传中文</a>
      <hr/>
     <c:url var="myurl" value="/value.jsp?country=中国" scope="page">
     </c:url>
       <a href="${myurl}">
                        现代方式传中文
       </a>
  </body>
</html>
