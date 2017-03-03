<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  </head>
  
  <body>
      <%-- <%-- <c:redirect url="/value.jsp">
          <c:param name="country" value="美国"/>
      </c:redirect> --%> 
      <jsp:forward page="/value.jsp">
           <jsp:param value="英国" name="country"/>
      </jsp:forward>
  </body>
</html>
