<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix = "fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>listAllInfo</title>
  </head>
  
  <body>
    
         <table border="1" align="center" width="500">
           <caption>投票人基本信息</caption>
           <tr>
              <th>ip地址</th>
              <th>最后一次投票时间</th>
              <th>地址</th>
           </tr>
             
                 <c:forEach var="info" items="${LISTINFO}">
                      <tr>
                         <td>${info.ip}</td>
                          <td><fmt:formatDate type="both" 
                               value="${info.votetime}"
                               dateStyle="full"
                               timeStyle="MEDIUM"
                              />
                            </td>
                            <td>${info.address.location}</td>
                         </tr>
                 </c:forEach>
                  <tr>
                    <td>
                       <jsp:include page="back.jsp"/>
                    </td>
                  </tr>
         </table>
  </body>
</html>
