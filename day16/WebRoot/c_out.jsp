<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "cn.itcast.web.jsp.jstl.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  
      <% 
         Address address = new Address();
         address.setLocation("合肥");
         User user = new User();
         user.setName("思思");
         user.setAddress(address);
         pageContext.setAttribute("USER",user);
      %>
       用户名：<c:out value="${USER.name}" default="无名"/><br/>
       地址：<c:out value="${USER.address.location}" />
    <hr/>
    <c:out value="<a href='#'>下载</a>" escapeXml="flase"/>
    
    
        
  </body>
</html>
