<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>El執行運算</title>
  </head>
  
  <body>
       1.基本元素
        <br/>
         10+3=${10+3}<br/>
         10-3=${10-3}<br/>
         10/3=${10/3}<br/>
         10*3=${10*3}<br/>
        2.比較運算
          <br/>
            10>3=${10>3}<br/>
            10>=3=${10>=3}<br/>
            10<3=${10<3}<br/>
            10<=3=${10<=3}<br/>
            10==3=${10==3}<br/>
            10!=3=${10!=3}<br/>
          3.邏輯運算
            <br/>
               false&&false=${false && false}<br/>
               false&&true=${false && true}<br/>
               true||false=${true || false}<br/>
               false||false=${false || false}<br/>
               
            <c:set var="name" value="jaxk" scope="session"/>
          
             歡迎 ${!empty name? name:"遊客"}光臨
             web應用名:<%=request.getContextPath() %>
              <br/>
             web应用名：${pageContext.request.contextPath}
  </body>
</html>
