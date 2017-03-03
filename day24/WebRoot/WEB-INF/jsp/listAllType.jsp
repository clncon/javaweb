<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>论坛主页</title>
     <link href="${pageContext.request.contextPath}/css/listAllType.css"  rel="stylesheet" type="text/css"/>
    <!--  <style type="text/css">
       td{
          text-align:center;
       }
       th{
         color:red;
       }
     </style> -->
  </head>
  <body>
     <jsp:include page="Header.jsp"/>
      <table align="center" border="1" width="60%">
              <caption><h1>论坛系统</h1></caption>
              <tr>
                 <th>图标</th>
                 <th>主题</th>
                 <th>点击数</th>
                 <th>主题数</th>
                 <th>最新主题</th> 
                 <th>作者</th>
              </tr>
                 <c:forEach var="type" items="${LISTALLTYPE}">
                      <tr>
                          <td>
                          <img src = "${type.image}" width="40" height="30"/>
                          </td>
                          <td><a href="${pageContext.request.contextPath}/BbsServlet?method=findTopicByType&type_id=${type.id}">${type.title}</a></td>
                          <td>${type.click}</td>
                          <td>${type.topicNum}</td>
                          <td style="text-align:left">
                             <div id="topic">
                                                                                                主题:${type.newTopic.title}</br>
                                                                                                作者:${type.newTopic.name}</br>
                                                                                               时间:<fmt:formatDate 
                                    value="${type.newTopic.time}"
                                    dateStyle="full"
                                    type="both"
                                    timeStyle="Default"                                                            
                                   />
                             </div>
                          </td>
                          <td>${type.admin.name}</td>
                         
                       </tr>
                 
                 </c:forEach>
      </table>
       <jsp:include page="foot.jsp"/>
  </body>
</html>
