<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>选择语言</title>
</head>
<script type="text/javascript">
	function change() {
		var form = document.forms[0];
		form.submit();
	}
</script>
<body>
	<fmt:setLocale value="${param.language}" />
	<fmt:setBundle basename="cn/itcast/web/jsp/config/language" />
	当前local为：${param.language}
	<form action="/day17/language.jsp" method="post">
		<table>
			<tr>
				<td><fmt:message key="language" /></td>
				<td><select name="language" onchange="change()">
						<option ${param.language== 'zh_CN'?'selected':''} value="zh_CN">
							<fmt:message key="China" />
						</option>
						<option ${param.language== 'en_US'?'selected':''}  value="en_US">
							<fmt:message key="English" />
						</option>
				</select></td>
			</tr>
		</table>
	</form>

</body>
</html>
