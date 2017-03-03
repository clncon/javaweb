<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑页面</title>
     
  </head>
  
  <body>
       
      <html:form action="/login.do" method="post">
      
                 <table align="center" border="1">
               <caption><h1>用户编辑</h1></caption>
                  <tr>
                     <th>*用户名:</th>
                      <td>
                           <!--   旧版本的页面回显方法 -->
                        <%-- <input type="text" name="username" value="${registerForm.username}"/> --%>
                           <!--      新版本的页面回显方法 -->
                         <html:text property="username"/>
                      </td>
                       <td><html:errors property="username"/></td>
                       <tr>
                          <th>邮箱：</th>
                           <td><html:text property="email"/></td>
                           <td><html:errors property="email"/></td>
                       </tr>
                         
                        <tr>
                           <td colspan="2" align="center">
                             <html:submit value="更新"/>
                           </td>
                        </tr>
            </table>
      </html:form>
  </body>
</html>
