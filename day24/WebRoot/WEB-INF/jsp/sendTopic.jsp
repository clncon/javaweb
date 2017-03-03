<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发表主题</title>
     <style type="text/css">
         h1{
            color:red;
            font-family:华文楷体;
         }
     </style>
  </head>
  
  <body>
       <jsp:include page="Header.jsp"/>
      <form action="${pageContext.request.contextPath}/BbsServlet?method=addTopicByType_Id&type_id=${requestScope.type_id}" method="post">
           <table align="center" border="1" width="500px">
               <caption><h1>发表主题</h1></caption>
               <tr>
                  <th>主题名:</th>
                   <td><input type="text" name="topicName"></td>
               </tr>
                <tr>
                   <th>内容:</th>
                   <td><textarea rows="10" cols="40" maxlength="200" name="content">
                   
                   
                   </textarea></td>
                </tr>
                 <tr>
                   <td colspan="2" align="center">
                     <input type="submit" value="发表主题"/>
                   </td>
                 </tr>
           </table>
      </form>
        <jsp:include page="foot.jsp"/>
  </body>
</html>
