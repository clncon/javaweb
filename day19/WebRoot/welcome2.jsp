<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  </head>
  
  <body>
      ${message}<br/>
       <c:choose>
           <c:when test="${flag=='admin'}">
              <a href="#">下载</a>
           </c:when >
               <c:when test="${flag=='user'}">
                                                    下载
               </c:when>
       </c:choose>
  </body>
</html>
