<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>number</title>
  </head>
  
  <body>
      数值类型
     <fmt:formatNumber value="231.235" type="number"/>
    <hr/>
    货币类型
     <fmt:formatNumber value="3654.254" type="currency"/>
     <hr/>
     百分比
      <fmt:formatNumber value=".0265" type ="percent"/>     
  </body>
</html>
