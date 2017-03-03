<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'declare.jsp' starting page</title>

  </head>
  
  <body>
      <%!
           String name = "xixi";
       %>
       <%!
           public String getName(){
            return name;
           }
        %>
        该实例变量为:  <%=getName() %>
  </body>
</html>
