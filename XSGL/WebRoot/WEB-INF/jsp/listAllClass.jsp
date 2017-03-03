<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>listClass</title>
     <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
  </head>
  
  <body>
   <div class="title">各班级${COURSE}课优秀率排序</div>
   <div class="a_sort_table">
           <table align="center" border="1" width="500" width="1000px" height="400px">
            
              <tr>
                 <th>班级</th>
                 <th>${SELECT=='great'?'优秀率':'不及格率'}</th>
              </tr>
               <c:forEach var="list" items="${LISTCLASS}">
                  <tr>
                     <td>${list.myclass }</td>
                        <c:choose>
                           <c:when test="${SELECT=='great'}">
                              <td class="great"><img src="image/bar.jpg" width="${list.outstanding*100*2}px" height="20px"/>${list.outstanding*100}%</td>
                           </c:when>
                           <c:when test="${SELECT=='fail'}">
                               <td class="great"><img src="image/bar.jpg" width="${list.unfail*100*2}px" height="20px"/>${list.unfail*100}%</td>
                           </c:when>
                        </c:choose>
                  </tr>
               </c:forEach>
               
           </table>
                  <div class="back"><jsp:include page="back.jsp"/></div>
                  
    </div>
  </body>
</html>
