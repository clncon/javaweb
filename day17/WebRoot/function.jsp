<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>el的function</title>
</head>

<body>
	转大写：${fn:toUpperCase("www.itcast.cn")}
	<br /> 转小写：${fn:toLowerCase("WWW.ITCAS.CN")}
	<br /> 去掉空格前的长度：${fn:length(" www.itcast.cn ")}
	<br /> 去掉空格后的长度：${fn:length(fn:trim(" www.itcast.cn "))}
	<br />

	<%
      String[] sArr = {"www","itcast","cn"};
      request.setAttribute("SARR", sArr);
    %>
	合并字符串：${fn:join(SARR,"#")}
	<br /> 索引字符串：${fn:indexOf("www.itcast.cn","it")}
	<br />
	<!--从字符串的头开始查找，返回第一次查找到的位置，否则返回-1  -->
	包含字符串：${fn:contains("www.itcast.cn","itcast")}
	<br />
	<%-- 找到返回true,否则返回false--%>

	指定字符串的开始：${fn:startsWith("http://localhost:8080/day17/welcome.jsp","http://")}
	<br />
	指定字符串的结束：${fn:endsWith("http://localhost:8080/day17/welcome.jsp","welcome.jsp")}
	<br />
	<!--返回布尔值，true表示是以指定的字符串，false相反  -->
	替换字符串：${fn:replace("www.itcast.cn",".","#")}
	<br />

	截取字符串：${fn:substring("http://localhost:8080/day17/welcome.jsp",6,16)}
	<br />
	截取字符串后的字符串：${fn:substringAfter("http://localhost:8080/day17/welcome.jsp","8080")}
	<br />
	截取字符串前的字符串：${fn:substringBefore("http://localhost:8080/day17/welcome.jsp","8080")}
	<br />




</body>
</html>
