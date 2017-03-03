<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>	
  </head>
  <body>
   <%!
          public String compare(int guess,int random){
          if(guess==random){
            return "猜中了";
          }
           else if(guess>random){
             return "猜大了";
           } 
           else 
            return "猜小了";
          }
         
        %>
      <%
         int guess = Integer.parseInt(request.getParameter("guessCount"));
         Random random = new Random();
        int ran = random.nextInt(10)+1;
         
       %>
       <%
          PrintWriter pw =  response.getWriter();
          pw.write(compare(guess,ran)+"<br/>");
          pw.write("客户端的数字为"+guess+"<br/>");
          pw.write("系统产生的数字为"+ran);
           
        %>
       
      
  </body>
</html>
