<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
	<!--el获取数据1，从四个域对象中取值-->
	<c:set var="username" value="jack" scope="page" />
	用户名:${username}
	<hr />
	<!--EL在javabean对象中 获取值-->
	<jsp:useBean id="user" class="cn.itcast.web.jsp.el.User" scope="page" />
	<c:set target="${user}" property="name" value="marry" />
	<c:set target="${user}" property="age" value="20" />
	用户名: ${user.name} 年龄: ${user.age}
	<hr />
	<!--EL表达式在Collection中获取值-->
	<%
                List<String> list = new ArrayList<String>();
                 list.add("one");
                 list.add("two");
                 list.add("three");
                 request.setAttribute("List", list);
              %>
	el获取第一个值 ${List[0]}
	<hr />
	<!--获得map集合中的值-->
	<jsp:useBean id="map" class="java.util.LinkedHashMap" scope="page" />
	<c:set target="${map}" property="key" value="one" />
	<c:set target="${map}" property="value" value="jaja" />
	第一个元素的key是:${map.key} 第一个元素的value是:${map.value }
	<hr />
	<!--el取得数组的值-->
	<%
		int[] arry = { 1, 2, 3 };
		pageContext.setAttribute("ARRY", arry);
	%>
	数组的第二个元素是:${ARRY[1]}
    ${fn:toLowerCase("WWW.ITCAST.CN") }
</body>
</html>
