<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>login</title>
  </head>
  <body>
         <jsp:include page="Header.jsp"/>
       <form action="${pageContext.request.contextPath}/BbsServlet?method=Login" method="post">
           <table align="center" border="1" width="400px">
               <caption><h1>用户登录</h1></caption>
                <tr>
                  <th>用户名</th>
                  <td><input type="text" name="username"/></td>
                   <td>${LoginForm.errors.username}</td>
                </tr>
                 <tr>
                   <th>密码</th>
                   <td>
                     <input type="password" name="password"/>
                    </td>
                     <td>${LoginForm.errors.password}</td>
                 </tr>
                  <tr>
                    <td colspan="2" align="center"><input type="submit" value="登录"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type = "reset" value="取消"/>
                    </td>
                  </tr>
           </table>
       </form>
         <jsp:include page="foot.jsp"/>
  </body>
</html>
