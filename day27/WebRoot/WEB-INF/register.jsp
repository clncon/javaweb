<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="cn.itcast.web.struts.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>register</title>
   
  </head>
  
  <body>
        <form action="/day27/register.do" method="post">
            <table align="center" border="1">
               <caption><h1>用户注册</h1></caption>
                  <tr>
                     <th>*用户名:</th>
                      <td>
                        <input type="text" name="username"/>
                      </td>
                       <td><html:errors property="username"/></td>
                  </tr>
                     <tr>
                     <th>*密码:</th>
                      <td>
                        <input type="password" name="password1"/>
                      </td>
                         <td><html:errors property="password1"/></td>
                  </tr>
                     <tr>
                     <th>*确认密码:</th>
                      <td>
                        <input type="password" name="password2"/>
                      </td>
                        <td><html:errors property="password2"/></td>
                  </tr>
                     <tr>
                     <th>*性别:</th>
                      <td>
                        <input type="radio" name="gender" value="male"/>男
                        <input type="radio" name="gender" value="female"/>女                        
                      </td>
                  </tr>
                    <tr>
                        <th>生日:</th>
                         <td>
                         <input type="text" name="birthday"/>
                         </td>
                          <td><html:errors property="birthday"/></td>                       
                      </tr>
                       <tr>
                        <th>城市:</th>
                         <td>
                             <select name="city">
                                <c:forEach var="city" items="<%=City.values()%>">
                                    <option value="${city.value}">${city.desc}</option>
                                </c:forEach>
                             </select>
                         </td>
                              <td><html:errors property="city"/></td>                   
                      </tr>
                      <tr>
                     <th>收入:</th>
                      <td>
                        <input type="text" name="income"/>
                      </td>
                       <td><html:errors property="income"/></td>
                  </tr>
                    <tr>
                       <th>爱好:</th>
                        <td>
                           <c:forEach var="like" items="<%=Like.values() %>">
                               <input type="checkbox" name="likes" value="${like.value}">${like.desc}
                           </c:forEach>
                         </td>
                          <td><html:errors property="likes"/></td>
                    </tr>
                     <tr>
                     <th>邮箱:</th>
                      <td>
                        <input type="text" name="email"/>
                      </td>
                       <td><html:errors property="email"/></td>
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
