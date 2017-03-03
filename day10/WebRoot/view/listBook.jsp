<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
       <table border = "1" align = "center" width= "80%">
         <caption>图书列表</caption>
         <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>单价</th>
         </tr>
           <c:forEach var = "entry" items = "${MAP}">
              <tr>
                 <td>${entry.value.id}</td>
                 <td>${entry.value.name}</td>
                 <td>${entry.value.athor}</td>
                 <td>${entry.value.price }</td>
                 <td><a href = "/day10/buyServlet?id=${entry.value.id}">购买</a></td>
                 
              </tr>
           </c:forEach>
       </table>
  </body>
</html>
