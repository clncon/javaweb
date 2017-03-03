<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
       <form action="${pageContext.request.contextPath}/GetPostServlet" method="post">
            <input type = "text" name= "username"/><br/>
             <input type="submit" value="提交"/>
       </form>
  </body>
</html>
