<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>manager</title>
	 
  </head>
  
  <body>
        
        <table width="500" align="center" border="1">
            <caption>管理员界面</caption>
             <tr>
                    <th>用户</th>
                    <th>操作</th>
                </tr>
           <c:forEach var="map" items="${applicationScope.MAP}">
                
                 <tr>
                    <td>${map.key}</td>
                    <td>
                       <c:url var="myurl" value="/KickServlet">
                         <c:param name="Name" value="${map.key}"/>
                       </c:url>
                        <a href="${myurl}">踢人</a>
                    </td> 
                 </tr>
             </c:forEach>
             
        </table>
  </body>
</html>
