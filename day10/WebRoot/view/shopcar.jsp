<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <script type="text/javascript">
      function updateBook(id,num){
        var regex = /^[0-9]+$/;
           if(regex.test(num)){
              if(num<100){
               var url = "/day10/updateBookServlet?id="+id+"&"+"num="+num;
                window.location.href=url;
              }
              else{
                  window.alert("个人购书的数量必须在1-100本之间")
              }
           }
           else{
                window.alert("请输入数字");
           }
            
      }
  </script>
     <table align = "center" border = "1" width="80%">
       <tr>
          <th>书名</th>
          <th>作者</th>
          <th>单价</th>
          <th>数量</th>
          <th>单项总价</th>
       </tr>
       <c:forEach var = "entry" items = "${car.map}">
         <tr>
          <td>${entry.value.book.name}</td>
          <td>${entry.value.book.athor}</td>
          <td>${entry.value.book.price}</td>
          <td><input type ="text" 
           size ="1" 
           name = "num" 
           value=${entry.value.num}
           onblur="updateBook(${entry.value.book.id},this.value)"></td>
          <td>${entry.value.itemPirce }</td>
          <td><a href = "/day10/deleteBookServlet?id=${entry.value.book.id }">删除</a></td>
           </tr>
           
       </c:forEach>
       <tr>
             <td colspan="2">总价：${car.getTotalPrice()}</td>
              <td colspan = "1"><a href = "/day10/clearCarServlet">清空购物车</a></td>
              <td colspan = "1"><a href = "/day10/listBookServlet">继续购物</a></td>
           </tr>
     </table>
  </body>
</html>
