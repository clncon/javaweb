<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>timezone</title>
  </head>
  
  <body>
      <%
         TimeZone tz = TimeZone.getDefault();
          pageContext.setAttribute("TZ", tz);
       %>
        <jsp:useBean id="now" class="java.util.Date" scope="page"/>
                 中国
      <fmt:timeZone value="${TZ}">
           <fmt:formatDate 
           value="${now}"
           type="both"
           dateStyle="FULL"
           timeStyle="FULL"
           />
      </fmt:timeZone><br/>
                    美国
          <fmt:timeZone value="GMT-08:00">
           <fmt:formatDate 
           value="${now}"
           type="both"
           dateStyle="FULL"
           timeStyle="FULL"
           />
      </fmt:timeZone>    
  </body>
</html>
