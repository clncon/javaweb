<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>listVote</title>
  </head>
  
  <body>
     欢迎${!empty sessionScope.user?user.username:'游客'}光临本网站
     <c:if test="${!empty sessionScope.user}">
     <a href="${pageContext.request.contextPath}/VoteServlet?method=exit"
     style="text-decoration:none">安全退出</a>
     </c:if>
         <table border="1" align="center" width="500">
           <caption>候选人基本信息</caption>
           <tr>
              <th>人名</th>
              <th>票数</th>
              <th>操作</th>
           </tr>
             
                 <c:forEach var="vote" items="${LISTVOTE}">
                    <tr>
                       <td><c:choose>
                       <c:when test="${!empty sessionScope.user}">
                       <a href="${pageContext.request.contextPath}/VoteServlet?method=findVoteById&id=${vote.id}"
                         style="text-decoration: none">
                       ${vote.content}
                       </a>
                       </c:when>
                         <c:when test="${empty sessionScope.user}">
                             ${vote.content}
                         </c:when>
                         </c:choose>
                         </td>
                      
                        <td><img src="images/bar.jpg" width="${vote.ticket*2}px" height="20px"></img></td>
                        <td>
                          <c:if test="${!empty sessionScope.user}">
                          <a href = "${pageContext.request.contextPath}/VoteServlet?method=addVote&id=${vote.id}" style="text-decoration:none">投票</a>
                          </c:if>
                        </td>
                    </tr>
                 </c:forEach>
              <tr>
                <td>
                  <a href="${pageContext.request.contextPath}/VoteServlet?method=toLoginJsp">
                                                安全登录                  
                  </a>
                </td>
                <td align="right">
                   <a href="${pageContext.request.contextPath}/VoteServlet?method=toManagerLogin">
                                                    管理员入口
                   </a>
                </td>
                <td align="right">
                  <a href="${pageContext.request.contextPath}/VoteServlet?method=findAllInfo">
                                                查询投票人的信息
                  </a>
                </td>
              </tr>
         </table>
         <div style="position:absolute;left:1000px;top:25px">
         <table border="1" >
             <caption>热门候选人</caption>
             
             <c:forEach var="vote" items="${LISTVOTEDESC}" varStatus="status">
                   <tr>
                       <th>
                         <c:if test="${status.first==true}">
                            <img src="images/agree.gif"/>
                         </c:if>
                       </th>
                       <td>
                          ${vote.content}
                       </td>
                   </tr>
             </c:forEach>
         </table>
         </div>
  </body>
</html>
