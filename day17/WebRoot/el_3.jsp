<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>El内置对象</title>
  </head>
  
  <body>
        <!-- el的四大域内置对象requestScope，sessionScope, pageScope,applicationScope-->
       <c:set var = "name" value="jack" scope="page"/>
      <c:set var = "name" value="marry" scope="request"/>
       用户名：${requestScope.name}
       <!--el的pageContext对象-->
          <a href="/day17/result.jsp?name='berry'&age='20'&hobby=游泳&hobby=跳高&hobby=唱歌">传送</a>
  </body>
</html>
