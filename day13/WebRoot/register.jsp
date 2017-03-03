<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <form action="/day13/userServlet?method=register"  method= "post">
      <table border = "1" align = "center">
        <caption>用户登录</caption>
         <tr>
           <th>用户名</th>
           <td>
           <input type = "text" name = "username"/>
           </td>
         </tr>
         <tr>
           <th>密码</th>
           <td>
            <input type = "password" name = "password"/>
           </td>
         </tr>
         <tr>
           <th>生日</th>
           <td>
            <input type = "text" name = "birthday"/>
           </td>
         </tr>
         <tr>
           <th>期望薪水</th>
           <td>
            <input type = "text" name = "salary"/>
           </td>
         </tr>
         <tr>
          <td colspan = "4" align = "center">
             <input type = "submit" value = "提交"/>
          </td>
         </tr>
      </table>
      </form>
  </body>
</html>
