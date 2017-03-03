<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<table border="1" align="center">
		<caption>后台操作</caption>
		<tr>
			<th>用户名</th>
			<th>操作</th>
		</tr>
		<c:forEach var="entry" items="${map}">
			<tr>
				<td>${entry.key}</td>
				<td>
					<c:url var="myURL" value="/KickServlet">
						<c:param name="username" value="${entry.key}"/>
					</c:url>
					<a 
						href="${myURL}" 
						style="text-decoration:none">
						踢人
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>

