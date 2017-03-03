<%@ page language="java"  pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>register</title>
	
  </head>
  
  <body>
       <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
          <table border="1" width="500" align="center">
               <caption>注册页面</caption>
               <tr>
                   <th>用户名</th>
                  <td><input type="text" name="username"></td>
               </tr>
                <tr>
                    <th>邮箱</th>
                  <td><input type="text" name="email"></td>
                </tr>
                  <tr>
                     <td colspan="2" align="center">
                       <input type="submit" value="注册"/>
                     </td>
                  </tr>            
           </table>
       </form>
  </body>
</html>
