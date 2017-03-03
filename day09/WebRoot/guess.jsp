<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'guess.jsp' starting page</title>
  </head>
  <body>
	<form method="post" action="/day09/result.jsp">
		输入你猜测的数字[1-10]:<input size = "1" type="text" name="guessCount">
		<input type = "submit" value = "提交"/>
	</form>
</body>
</html>
