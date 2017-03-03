<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
	 </head>
	     
	<body>              
	    <form action="${pageContext.request.contextPath}/EquipServlet?method=addEquiment" method="post">
         <table align="center" border="1">
            <caption><h1>增加装备</h1></caption>
              <tr>
               <th>装备名称</th>
               <td><input type="text" name="name"></td>
            </tr>
            <tr>
               <th>装备数量</th>
               <td><input type="text" name="count"></td>
            </tr>
            <tr>
               <th>装备功能</th>
               <td><input type="text" name="function"></td>
            </tr>
            <tr>
               <th>装备编号</th>
               <td><input type="text" name="position"></td>
            </tr>
             <tr>
               <td align="center" colspan="2">
                  <input type="submit" value="添加">
                   &nbsp;&nbsp;&nbsp;&nbsp;
                      <jsp:include page="back.jsp"/>
               </td>
             </tr>
            </table>
            </form>
  </body>
</html>
