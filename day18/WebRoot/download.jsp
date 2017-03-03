<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  </head>
  
  <body>
        <table border="1" align="center">
           <caption>下载列表</caption>
            <c:forEach var="up" items="${requestScope.uplist}">
               <tr>
                   <th>${up.fileRealName}</th>
                 <td>
                   <c:url  var="url" value="/downloadServlet">
                        <c:param name="uuidfileName" value="${up.uuidFileName}"/>
                   </c:url>
                    <a href="${url}" style="text-decoration:none">下载</a>                
                 </td>
               </tr>
            </c:forEach>
       </table>
  </body>
</html>
