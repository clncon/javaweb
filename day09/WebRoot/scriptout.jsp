<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'scriptout.jsp' starting page</title>
  </head>
  <body>
       <!-- 这是jsp的脚本表达式 -->
      <%="这是JSP的脚本输出表达式"%>
      <hr/>
      <%=new Random().nextInt(1000) %>
      <hr/>
       <%
          //这是jsp脚本片段
          Random random = new Random();
          int name = random.nextInt(10000); 
        %>
         随机数为:<%= name%>
  </body>
</html>
