<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
       <title>
          用户注册
       </title>
    </head>
  
  <body>
      <%--  <html:javascript formName="dynaActionForm"/> --%>
      <%--  onsubmit="return validateDynaActionForm(this)"  --%>
       <html:form action="/register" 
       method="post"
       focus="username"
       >
          <table align="center" border="1">
               <caption>用户注册</caption>
                <tr>
                    <th>用户名:</th>
                   <td>
                      <html:text property="username"/>
                   </td>
                    <td><html:errors property="username"/></td>
                </tr>
                 <tr>
                   <th>密码:</th>
                   <td>
                     <html:password property="password"/>
                   </td>
                    <td><html:errors property="password"/></td>
                 </tr>
                   <tr>
                      <th>生日：</th>
                       <td>
                          <html:text property="birthday"/>
                       </td>
                        <td><html:errors property="birthday"/></td>
                   </tr>
                     <tr>
                        <th>邮箱:</th>
                        <td>
                          <html:text property="email"/>
                        </td>
                         <td><html:errors property="email"/></td>
                     </tr>
                      <tr>
                         <th>工资：</th>
                          <td><html:text property="salary"/></td>
                           <td><html:errors property="salary"/></td>
                      </tr>
                   <tr>
                   <td colspan="2" align="center">
                     <html:submit value="提交"/>
                   </td>
                 </tr>
                 
          </table>
       </html:form>
  </body>
</html>
