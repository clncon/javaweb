<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login</title>
  </head>
  
  <body>
      <form action="${pageContext.request.contextPath}/loginServlet" method="post">
         <table align="center" border="1">
            <caption>管理员登录界面</caption>
             <tr>
                <th>管理员账号:</th>
               <td>
                  <input type="text" name="username"/>
               </td>
             </tr>
              <tr>
                <th>管理员密码:</th>
                 <td>
                   <input type="password" name="password"/>
                 </td>
              </tr>
               <tr>
                 <td colspan="2" align="center">
                   <input type="submit" value="提交"/>
                 </td>
               </tr>
         </table>
      </form>
  </body>
</html>
