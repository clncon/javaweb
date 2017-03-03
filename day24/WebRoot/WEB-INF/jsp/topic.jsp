<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>主题页</title>
       <link href="${pageContext.request.contextPath}/css/listAllType.css"  rel="stylesheet" type="text/css"/>
  </head>
  
  <body>
       <jsp:include page="Header.jsp"/>
       
       <c:if test="${!empty sessionScope.user}">
           <a href="${pageContext.request.contextPath}/BbsServlet?method=toSendTopic&type_id=${requestScope.type_id}">发表主题</a>
       </c:if>
       <table align="center" border="1" width="800px">
          <caption><h1>主题页面</h1></caption>
           <tr>
              <th></th>
              <th>主题</th>
              <th>作者</th>
              <th>回复数</th>
              <th>最后更新时间</th>
           </tr>
             <c:forEach var="topic" items="${listTopic}" varStatus="status">
               
                <tr>
                    <td>
                      <c:if test="${status.first==true}">
                        <img src="image/8_5_12.gif" width="30px" height="20px"/>
                      </c:if>
                    </td>
                   <td><a href="${pageContext.request.contextPath}/BbsServlet?method=findAllReplyByTopic_id&topic_id=${topic.id}" style="text-decoration: none">${topic.title}</a></td>
                   <td>${topic.name}</td>
                   <td>${topic.replyCount}</td>
                   <td><fmt:formatDate 
                   value="${topic.time}"
                    dateStyle="full"
                    type="both"
                    timeStyle="Default"
                   /></td>
                   <td>
                      <c:if test="${sessionScope.user.username==topic.name}">
                          <a href="${pageContext.request.contextPath}/BbsServlet?method=toUpdateJsp&id=${topic.id}">编辑</a>
                      </c:if>
                   </td>
                </tr>
             </c:forEach>
       </table>
        <jsp:include page="foot.jsp"/>
  </body>
</html>
