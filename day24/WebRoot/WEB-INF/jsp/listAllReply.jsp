<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>回复页面</title>
  </head>
    <link href="${pageContext.request.contextPath}/css/listAllType.css"  rel="stylesheet" type="text/css"/>
  <body>
        <jsp:include page="Header.jsp"/>
         <c:if test="${!empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/BbsServlet?method=toSendReply&topic_id=${topic.id}">发表回复</a>
         </c:if>
       <table align="center" border="1" width="500">
           <caption><h1>回复主页</h1></caption>
              <tr>
                <th>主题</th>
                <td>${topic.title}</td>
              </tr>
               <tr>
                  <th>内容</th>
                  <td>${topic.content}</td>
               </tr>
       </table>
        <hr>
         <table align="center" border="1" width="800px">
               <tr>
                 <th></th>
                 <th>回复标题</th>
                 <th>回复内容</th>
                 <th>回复作者</th>
                 <th>回复时间</th>
               </tr>
               <c:forEach var="reply" items="${listReply}" varStatus="status">
                  <tr>
                    <td>
                      <c:if test="${status.first==true}">
                        <img src="image/8_5_12.gif" width="30px" height="20px"/>
                      </c:if>
                    </td>
                    <td>${reply.title}</td>
                    <td>${reply.content}</td>
                    <td>${reply.name}</td>
                    <td><fmt:formatDate 
                   value="${reply.time}"
                    dateStyle="full"
                    type="both"
                    timeStyle="Default"
                    /></td>
                  </tr>
               </c:forEach>
         </table>
          <jsp:include page="foot.jsp"/>
  </body>
</html>
