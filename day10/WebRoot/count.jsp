<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "cn.itcast.web.domain.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    
    <%
       countBean cb = countBean.getBean();
        
        double firstNumber = cb.getFirstNumber();
        double secondNumber = cb.getSecondNumber();
        double resultNumber = cb.getResultNumber();
        String operator = cb.getOperator();
      %>
      <%=firstNumber %> <%=operator %> <%=secondNumber %> = <%=resultNumber %>
  
     <%-- <jsp:useBean id = "s" class= "cn.itcast.web.domain.countBean" scope = "page"/>
     <jsp:getProperty name = "s" property = "firstNumber"/>   
     <jsp:getProperty name = "s" property = "operator"/>   
     <jsp:getProperty name = "s" property = "secondNumber"/>
      =
      <jsp:getProperty name = "s" property = "resultNumber"/>
   --%>
  
  
  
    <form method = "post" action = "/day10/countServlet">
                 第一个参数<br/>
       <input type = "text" name = "firstNumber"/><br/>
       运算符
       
       	<select name="operator">
       		<option selected value="+">+</option>
       		<option value="-">-</option>
       		<option value="*">*</option>
       		<option value="/">/</option>
       	</select><br/>
            第二个参数<br/>
            <input type = "text" name = "secondNumber"/><br/>
          <input type = "submit" value = "计算"/>

    </form>
  </body>
</html>
