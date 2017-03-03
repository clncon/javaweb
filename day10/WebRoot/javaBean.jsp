<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "cn.itcast.web.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<!-- 建立javaBean对象 -->
	<jsp:useBean id="s" class="cn.itcast.web.domain.stuBean" scope="page"/>
         

	<%-- <!--设置属性值  -->
	<jsp:setProperty name="s" property="name" value="Taylor" />
	<jsp:setProperty name="s" property="age" value="20" />
	<jsp:setProperty name="s" property="salary" value="10000" /> --%>

    

     <%--<!-- 通过参数设置值 -->
     <jsp:setProperty name = "s" property = "name" param="n"/>
     <jsp:setProperty name = "s" property = "age" param="a"/>
     <jsp:setProperty name = "s" property = "salary" param="s"/> --%>
          

      <!-- 通过通配符 设置属性值-->
      <jsp:setProperty name = "s" property = "*"/>

     



	<!-- 获取属性值 -->
	姓名：<jsp:getProperty name="s" property="name" /><br/>
	年龄：<jsp:getProperty name="s" property="age" /><br/>
	薪水：<jsp:getProperty name="s" property="salary" /><br/>
</body>
</html>
