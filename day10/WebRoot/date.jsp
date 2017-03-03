<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<% 
    String Year = request.getParameter("year");
    String Moth = request.getParameter("moth");
    String Day = request.getParameter("day");
  %>
	<%! 
     int year=1994;
     int moth = 1;
     int day = 1;
   
   %>
	<select name="years">
		<% for(int i=0;i<20;i++){%>
		<%
                boolean flag = false;
              if(String.valueOf(year).equals(Year)){
                    flag = true;
              }
            
          %>
		<option <%=flag ? "selected":"" %> value="<%=year%>"><%=year%></option>
		<%year++; %>
		<%} %>
	</select>


	<select name="mothes">
		<% for(int j = 0;j<12;j++){%>
		<%    boolean flag2 = false;
              if(String.valueOf(moth).equals(Moth)){
                    flag2 = true;
              }
              %>

		<option <%=flag2? "selected":"" %> value="<%=moth%>"><%=moth %></option>
		<% moth++;%>
		<%} %>
	</select>


	<select name="days">
		<% for(int y = 0 ;y<30;y++){%>
		<%     boolean flag3 = false;
              if(String.valueOf(day).equals(Day)){
                   flag3 = true;
              }
           %>
		<option <%=flag3? "selected":"" %> value="<%=day%>"><%=day %></option>
		<%
         
         
          day++;
        %>
		<%} %>
	</select>

</body>
</html>
