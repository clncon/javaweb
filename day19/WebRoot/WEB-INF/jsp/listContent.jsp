<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>listContent</title>
  </head>

<body>
	<table border="1" width="500" align="center">
		<caption>候选人的详细信息</caption>
        <tr>
           <th>头像</th>
           <td><img src="${Content.image.path}" width="100" height="100"></img></td>
        </tr>
		<tr>
			<th>姓名</th>
			<td>${Content.vote.content}</td>
		</tr>
		<tr>
			<th>年龄</th>
			<td>${Content.age}</td>
		</tr>
		<tr>
			<th>描述</th>
			<td>${Content.description}</td>
		</tr>
		<tr>
			<td colspan="3" align="right"><jsp:include page="back.jsp" /></td>
		</tr>
	</table>
</body>
</html>
