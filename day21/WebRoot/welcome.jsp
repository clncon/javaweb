<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.itcast.web.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	欢迎${!empty username?username:'游客'}光临
  	<%--
  		User user = new User();
  		user.setUsername("haha");
  		session.setAttribute("user",user);
 		Thread.sleep(10*1000); 		
  		session.removeAttribute("user");
  		//session.invalidate();
  	--%>
  	<%--
  		request.setAttribute("name","sisi");
  		request.setAttribute("name","丝丝");
  		request.removeAttribute("name");
  	--%>
  
	<%--
		测试HttpSession产生和销毁
		Thread.sleep(10*1000);
		session.invalidate();
		你是第${caller}访问者<br/>
		当前在线${counter}人<br/>
	--%>
  </body>
</html>
