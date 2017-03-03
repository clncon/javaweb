<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
      <form action = "/day11/LoginServlet" method = "post">
          <table border = "1" align = "center">
              <tr>
                   <th>用户名</th>
                   <td><input type = "text" name="username" value = "${LoginBean.username }"></td>
                   <td>${LoginBean.error.username }</td>
               </tr>
               <tr>
                 <th>密码</th>
                  <td><input type = "password" name = "password"></td>
                   <td>${LoginBean.error.password }</td>
               </tr>
               <tr>
                  <th>email</th>
                   <td><input type = "text" name = "email"  value = "${LoginBean.email }"></td>
                    <td>${LoginBean.error.email }</td>
               </tr>
                <tr>
                  <td colspan = "2" align = "center">
                   <input type = "submit" value = "提交">
                  </td>
                </tr>
          </table>
      </form>
  </body>
</html>
