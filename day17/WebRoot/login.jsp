<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>login</title>
  </head>
  
  <body>
        <%
           ResourceBundle rb = 
                ResourceBundle.
                        getBundle("cn/itcast/web/jsp/config/message",request.getLocale());
                    
   
           
         %>
       <form>
            <table align ="center" border="1">
                <caption><%= rb.getString("login")%></caption>
                 <tr>
                    <th><%=rb.getString("username")%></th>
                    <td>
                       <input type="text" name="username">
                    </td>
                 </tr>
                  <tr>
                     <th><%=rb.getString("password")%></th>
                     <td>
                      <input type="password" name="password"/>
                      </td>
                      <tr>
                         <td colspan="2" align="center">
                           <input type="submit" value='<%=rb.getString("submit")%>'/> 
                         </td>
                      </tr>
                  
            </table>
       </form>
  </body>
</html>
