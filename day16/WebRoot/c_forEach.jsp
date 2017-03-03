<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.lang.reflect.MalformedParameterizedTypeException" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
           <%
              List<String> list = new ArrayList<String>();
              list.add("小李");
              list.add("小王");
              list.add("小红");
              list.add("小张");
              list.add("小名");
              pageContext.setAttribute("LIST",list);
              
            %>      
            <c:forEach var="s" items="${LIST}" varStatus="status">
              ${status.index}--${status.count}--${status.first}--${status.last}<br/>
            
            </c:forEach>



  </body>
</html>
