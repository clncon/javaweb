<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>错误信息</title>
  </head>
  <body>
        <jsp:include page="Header.jsp"/>
      ${message}
       
        <jsp:include page="foot.jsp"/>
  </body>
</html>
