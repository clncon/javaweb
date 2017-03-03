<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>borrow</title>
	 </head>
	<body>              
         <table align="center" border="1">
            <caption><h1>借贷页面</h1></caption>
             <tr>
                <th>装备名称</th>
                <th>借贷数量</th>
                <th>借贷时间</th>
             <c:forEach var="borrow" items="${requestScope.listborrow}">
                  <tr>
                     <td>
                        ${borrow.name}
                     </td>
                     <td>
                        ${borrow.count}
                     </td>
                      <td>
                        ${borrow.time}
                     </td>
                      <td>
                        <a href="${pageContext.request.contextPath}/EquipServlet?method=deleteBorrow&id=${borrow.id}">还回</a>
                      </td>
                      
                  </tr>
                   
             </c:forEach>
              <tr>
                <td colspan="3" align="center"> 
                   
                      <jsp:include page="back.jsp"/>
                </td>
              </tr>
         </table>
  </body>
</html>
