<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
      <style type="text/css">
         #tip{
              color:red;
              size:44;
            position:absolute;
              left:1000px;
              
         }
      </style>
	 </head>
	    <script type="text/javascript">
	         function del(){
	            //alert("sj");
	            var id = document.getElementById("delete").value;
	            var url = "${pageContext.request.contextPath}/EquipServlet?method=deleteEquipment&id="+id;
	            window.location.href=url;
	            
	         }
	    </script>
	<body>
	   <a href="${pageContext.request.contextPath}/EquipServlet?method=findAllBorrow">借贷</a>  
	    <div id="tip">
	       ${tip}
	    </div>         
         <table align="center" border="1">
            <caption><h1>装备管理系统</h1></caption>
             <tr>
                <th>装备Id</th>
                <th>装备名称</th>
                <th>装备数量</th>
                <th>装备功能</th>
                <th>装备编号</th>
             </tr>
             <c:forEach var="equipment" items="${requestScope.ListEquiment}">
                  <tr>
                     <td>
                        ${equipment.id}
                     </td>
                     <td>
                        ${equipment.name}
                     </td>
                     <td>
                        ${equipment.count}
                     </td>
                     <td>
                        ${equipment.function}
                     </td>
                     <td>
                       <a href="${pageContext.request.contextPath}/EquipServlet?method=setPosition&position=${equipment.position}">${equipment.position}</a>
                     </td>
                      
                     <td>
                        <c:url var="myurl" value="/EquipServlet?method=toAddBorrowJsp&name=${equipment.name}" scope="page">
                        
                        </c:url>
                         <a href="${myurl}">
                                                                                   借贷                                
                         </a>
                     </td>
                        
                     
                  </tr>
             </c:forEach>
              <tr>
                <td align="center" colspan="4">
                   <a href="${pageContext.request.contextPath}/EquipServlet?method=toAddEquipmentJsp">添加</a>
                </td>
              </tr>
               <tr>
                 <td align="center" colspan="4">
                     <input type="text" name="deleteID" size="1" id="delete"/>
                      &nbsp; &nbsp; &nbsp; &nbsp;
                      <input type="button" value="删除" onclick="del()"/>
                 </td>
               </tr>
         </table>
  </body>
</html>
