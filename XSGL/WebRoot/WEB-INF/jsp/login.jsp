<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>login</title>
     <link rel="stylesheet" type="text/css" href="././css/login.css">
  </head>
  <body>
  <div class="title"><h1>学生信息管理</h1></div>
      <form action="${pageContext.request.contextPath}/LoginServlet?method=Login" method="post">
         
            
               
                   <input type="text" name="rootName" placeholder="请输入管理员账号"/><br><br>
                  <input type="password" name="rootPassword" placeholder="请输入管理员密码"/><br><br>
			<input id="sbutton" type="submit" value="提交"/>
             
      </form>
  </body>
</html>
