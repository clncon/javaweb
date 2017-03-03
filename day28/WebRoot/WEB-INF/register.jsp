<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
      <script type="text/javascript">
           function check(inputElement){
                 var username = inputElement.value;
                username = encodeURI(username);
                url="${pageContext.request.contextPath}/check.do?username="+username;
                window.location.href=url;
           }
      
      </script>
  </head>
  
  <body>
        <html:errors property="tip"/>
         <hr/>
      <html:form action="/register.do" method="post">
      
                 <table align="center" border="1">
               <caption><h1>用户注册</h1></caption>
                  <tr>
                     <th>*用户名:</th>
                      <td>
                           <!--   旧版本的页面回显方法 -->
                        <%-- <input type="text" name="username" value="${registerForm.username}"/> --%>
                           <!--      新版本的页面回显方法 -->
                         <html:text property="username" onblur="check(this)"/>
                      </td>
                       <td><html:errors property="username"/></td>
                  </tr>
                     <tr>
                     <th>*密码:</th>
                      <td>
                         <!--   旧版本的页面回显方法 -->
                        <!-- <input type="password" name="password"/> -->
                             <!--      新版本的页面回显方法 -->
                         <html:password property="password" redisplay="false"
                         />
                      </td>
                       <td><html:errors property="password"/></td>
                  </tr>
                     <tr>
                     <th>*性别:</th>
                      <td>
                           <!--   旧版本的页面回显方法 -->
                       <!--  <input ${registerForm.gender=='male'?'checked':'' } type="radio" name="gender" value="male"/>男
                        <input ${registerForm.gender=='female'?'checked':'' } type="radio" name="gender" value="female"/>女                         -->
                           <!--      新版本的页面回显方法 -->
                        <html:radio  property="gender" value="男"/>男
                        <html:radio property="gender" value="女"/>女
                      </td>
                  </tr>
                       <tr>
                        <th>城市:</th>
                         <td>
                             <!--   旧版本的页面回显方法 -->
                             <!-- <select name="city">
                                
                                    <option ${registerForm.city=='bj'?'selected':'' } value="bj">北京</option>
                                    <option ${registerForm.city=='sh'?'selected':'' } value="sh">上海</option>
                                    <option ${registerForm.city=='gz'?'selected':'' } value="gz">广州</option>
                                    
                             </select> -->
                                  <!--      新版本的页面回显方法 -->
                             <html:select property="city">
                                <html:option value="北京">北京</html:option>
                                <html:option value="上海">上海</html:option>
                                <html:option value="广州">广州</html:option>
                             </html:select>
                         </td>
                                            
                      </tr>
                    <tr>
                       <th>爱好:</th>
                        <td>
                                       <!--   旧版本的页面回显方法 -->                                                           <%--   思路：
                                     1.${registerForm.likes}是字符串数组
                                     2.将字符串数组转换成字符串
                                       ${fn:join(registerFormlikes,"#")}
                                     3.查看该字符串中是否有爱好如sing,dance等
                                       ${fn:contains(fn:join(registerForm.likes,"#"),like)} --%>
                               <!-- <input  ${fn:contains(fn:join(registerForm.likes,"#"),"sing")?'checked':''} type="checkbox" name="likes" value="sing">唱歌
                               <input   ${fn:contains(fn:join(registerForm.likes,"#"),"dance")?'checked':''} type="checkbox" name="likes" value="dance">跳舞 -->
                                      <!--      新版本的页面回显方法 -->
                               <html:multibox property="likes" value="唱歌"/>唱歌
                               <html:multibox property="likes" value="跳舞"/>跳舞
                             
                         </td>
                          
                    </tr>
                      <tr>
                         <th>生日:</th>
                          <td><html:text property="birthday"/></td>
                          <td><html:errors property="birthday"/></td>
                      </tr>
                   <tr>
                      <td colspan="2" align="center">
                        <input type="submit" value="提交"/>
                      </td>
                   </tr>
            </table>
      </html:form>
  </body>
</html>
