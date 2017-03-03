<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>result.jsp</title>

  </head>
  
  <body>
     <!-- el获取请求参数的对象 -->
            姓名：${param.name}<br/>
          年龄： ${param.age }<br/>
      爱好：${paramValues.hobby[0]}
      爱好：${paramValues.hobby[1]}
      爱好：${paramValues.hobby[2]}
      <hr/>
      <!-- el获取浏览器信息的对象 -->
       浏览器信息：${header['User-Agent'] }
       字符编码: ${headerValues['Accept-Encoding'][0] }
       <hr/>
        <%--
           Cookie cookie = new Cookie("username","jack");
           cookie.setMaxAge(5*60);
           response.addCookie(cookie);
        
         --%>
         Cookie的名字：${cookie.username.name}<br/>
         Cookie的值：${cookie.username.value}<br/>
         <!--EL读取初始化参数  -->
           name:${initParam.name}
         
  </body>
</html>
