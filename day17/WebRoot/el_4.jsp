<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/el" prefix="el"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
    <!-- ${el:filter('<script type="text/javascript">while(true){window.alert("haha");}</script>')}<br/>
    -->
       <%String pw1=null;
         String pw2=null;
        %>
      ${el:check("123456","123456") }
  </body>
</html>
