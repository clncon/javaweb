<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
       <% 
        String country = request.getParameter("country");
           byte[] temp = country.getBytes("iso-8859-1");
            out.write(new String(temp,"utf-8"));
            %>
                
      
  </body>
</html>
