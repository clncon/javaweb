<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
      <c:set var = "s" value="哈哈"/>
      <c:out value="${s}"/>
     <hr/>
     <jsp:useBean id="user" class="cn.itcast.web.jsp.jstl.User" scope="page"/>
     <c:set target="${user}" property="name" value="丁丁"/>
     <c:out value="${user.name}"/>
     <hr/>
      <jsp:useBean id="map" class="java.util.HashMap" scope="page"/>
      <c:set target="${map }" property="key" value="1"/>
      <c:set target="${map}" property="value" value="丽丽"/>
              键:<c:out value="${map.key}"/><br/>
              值:<c:out value="${map.value }"/>       
  </body>
</html>
