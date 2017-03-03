<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
     <title>update</title>
    <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
      
  <body>
<div class="title">更新用户信息</div>
<div class="outer">
     <form action="${pageContext.request.contextPath}/stuServlet?method=update&id=${Stu.id}"
     method="post">
     <table border="0" align="center" width="300px" height="450px">
       
         <tr>
            <th>学号</th>
            <td><input type="text" name="id" value="${Stu.id}" readonly="readonly"/></td>
         </tr>
          <tr>
            <th>姓名</th>
            <td><input type="text" name="name" value="${Stu.name}"/></td>
         </tr>
          <tr>
            <th>性别</th>
            <td>
            <input ${Stu.gender=='男'?'checked':''} type="radio" name="gender" value="男"/>男
          	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input ${Stu.gender=='女'? 'checked':''} type="radio" name="gender" value="女"/>女
            </td>
         </tr>
           <tr>
              <th>班级</th>
               <td>
                  <input type = "text" name="myClass" value="${Stu.myClass}"/>
               </td>
           </tr>
          <tr>
            <th>英语</th>
            <td><input type="text" name="english" value="${Stu.english}"/></td>
         </tr>
          <tr>
            <th>数学</th>
            <td><input type="text" name="math" value="${Stu.math}"/></td>
         </tr>
          <tr>
            <th>语文</th>
            <td><input type="text" name="chinese" value="${Stu.chinese}"/></td>
         </tr>
          
     </table>
     <div class="back">
               <input type="submit" value="更新"/>
                &nbsp;&nbsp;&nbsp;&nbsp; <jsp:include page="back.jsp"/>
      </div>
     </form>
     </div>
  </body>
</html>
