<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts.action.*" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>login</title>
   
  </head>
  
  <body>
                      <!--   第一种方式来显示错误信息  -->
   <%--  <% 
         ActionErrors ae = (ActionErrors)
         request.getAttribute("org.apache.struts.action.ERROR");
         if(ae!=null){
          Iterator<ActionMessage> messages = ae.get("username");
          while(messages.hasNext()){
            out.write("<font color='red'>"+messages.next().getKey()+"</font>");
          }
          }
     %> --%>
        <form action="/day27/login.do" method="post">
            <table align="center" border="1">
               <caption><h1>用户登录(struts版)</h1></caption>
                  <tr>
                     <th>用户名:</th>
                      <td>
                        <input type="text" name="username"/>
                      </td>
                       <td>
                          <html:errors property="username"/>
                       </td>
                  </tr>
                     <tr>
                     <th>密码:</th>
                      <td>
                        <input type="password" name="password1"/>
                      </td>
                        <td>
                          <html:errors property="password1"/>
                        </td>
                  </tr>
                    <tr>
                     <th>重复密码:</th>
                      <td>
                        <input type="password" name="password2"/>
                      </td>
                        <td>
                          <html:errors property="password2"/>
                        </td>
                  </tr>
                   <tr>
                      <td colspan="2" align="center">
                        <input type="submit" value="提交"/>
                      </td>
                   </tr>
            </table>
        </form>
  </body>
</html>
