<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<jsp:include page="/comman/head.jsp" />
	<hr />
	   <%
	       String email = config.getInitParameter("email");
	       
	    %>
	    <%=email %>
	<hr />
	<jsp:include page="/comman/foot.jsp" />
	<hr />
</body>
</html>
