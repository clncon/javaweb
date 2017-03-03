<%@ page language="java"  pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>welcome</title>
	 
  </head>
  
  <body>
        欢迎${!empty sessionScope.Name? Name:'游客'}光临本网站
  </body>
</html>
