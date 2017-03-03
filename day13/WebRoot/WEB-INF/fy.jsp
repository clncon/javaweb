<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
         <table border = "1" align = "center">
          <caption>数据库分页</caption>
          <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>生日</th>
            <th>薪水</th>
          </tr>
          <c:forEach var = "user" items ="${pageNO.list}">
              <tr>
                 <td>${user.id}</td>
                 <td>${user.username}</td>
                 <td>${user.password}</td>
                 <td>${user.birthday}</td>
                 <td>${user.salary}</td>
              </tr>
          </c:forEach>
          <tr>
            <td colspan ="5" align="center">
               <c:forEach  var = "i" begin = "1" end="${pageNO.allPageNO}">
                    <a href = "/day13/userServlet?method = fy&page=${i}"
                     style="text-decoration:none">
                    [${i}]&nbsp;&nbsp;&nbsp;  
                    </a>
               </c:forEach>
            </td>
          </tr>
         </table>
         
  </body>
</html>
