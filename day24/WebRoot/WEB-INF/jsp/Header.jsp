<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      
  </head>
  <body>
    <% 
      Date date = new Date();
      pageContext.setAttribute("date", date);
    %>
        欢迎<font color="red">${!empty sessionScope.user?user.username:'游客'}</font>光临
     当前时间: <fmt:formatDate 
          value="${date}"
           dateStyle="full"
           type="both"
           timeStyle="Default"
       />
   <br/>
   <c:choose>
    <c:when test="${empty sessionScope.user}">
   <a href="${pageContext.request.contextPath}/BbsServlet?method=toRegisterJsp">注册</a>
   <a href="${pageContext.request.contextPath}/BbsServlet?method=toLoginJsp">登录</a>
   </c:when>
    <c:when test="${!empty sessionScope.user}">
          <a href="${pageContext.request.contextPath}/BbsServlet?method=exit">安全退出</a>
    </c:when>
   </c:choose>
   <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
   <div style="position:absolute;left:920;top:15">
                 你的ip: <font color="red">${sessionScope.address.ip}</font>
                归属地:  <font color="red">${sessionScope.address.location}</font>
      <br/>
            在线人数：  <font color="red">${!empty applicationScope.online? online:'0'}</font>
    你是第几个访问者: <font color="red">${!empty sessionScope.caller?caller:'0'}</font>            
   </div>
  </body>
</html>
