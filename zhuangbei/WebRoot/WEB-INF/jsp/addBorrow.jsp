<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addBorrow</title>
	 </head>
	     
	<body>              
	    <form action="${pageContext.request.contextPath}/EquipServlet?method=addBorrow" method="post">
                <table align="center" border="1">
                     <caption><h1>添加借贷</h1></caption>
                      <tr>
                         <th>装备名称</th>
                          <td>
                            
                             <input type="text" name="name" value="${requestScope.Name}"/>
                          </td>
                      </tr>
                       <tr>
                          <th>借贷数量</th>
                          <td>
                            <input type="text" name="count"/>
                          </td>
                       </tr>
                        <tr>
                          <td colspan="2" align="center">
                            <input type="submit" value="提交"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                               <jsp:include page="back.jsp"/>
                          </td>
             
                        </tr>
                </table>
            </form>
  </body>
</html>
