<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>注册</title>
  </head>
  <body>
        <jsp:include page="Header.jsp"/>
        <form action="${pageContext.request.contextPath}/BbsServlet?method=Register" method="post">
           <table align="center" border="1">
                <caption><h1>注册页面</h1></caption>
                <tr>
                  <th>用户名:</th>
                  <td><input type="text" name="username" value="${RegisterForm.username}"/></td>
                  <td>${RegisterForm.errors.username}</td>
                </tr>
                <tr>
                   <th>密码:</th>
                   <td><input type="password" name="password" value="${RegisterForm.password}"/></td>
                   <td>${RegisterForm.errors.password}</td>
                </tr>
                <tr>
                  <th>性别:</th>
                   <td>
                      <input ${RegisterForm.gender=='male' ? 'checked':''} type="radio" value="male" name="gender"/>男
                      <input ${RegisterForm.gender=='female' ? 'checked':''} type="radio" value="female" name="gender"/>女 
                   </td>
                </tr>
                 <tr>
                   <th>邮箱:</th>
                   <td>
                       <input type="text" name="email" value="${RegisterForm.email }"/>
                   </td>
                    <td>${RegisterForm.errors.email}</td>
                 </tr>
                 <tr>
                   <td colspan="2" align="center">
                    <input type="submit" value="注册"/>
                    <input type="reset" value="取消"/> 
                    </td>               
                 </tr>
           </table>
        </form>
         <jsp:include page="foot.jsp"/>
  </body>
</html>
