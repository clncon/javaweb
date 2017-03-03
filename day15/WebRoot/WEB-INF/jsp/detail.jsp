<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "cn.itcast.web.crm.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <%
    Customer customer = (Customer)request.getAttribute("customer");
    Date birthday = customer.getBirthday();	 
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(birthday);
     int strY = calendar.get(calendar.YEAR);
     int strM = calendar.get(calendar.MONTH)+1;
     int strD = calendar.get(calendar.DATE);
     pageContext.setAttribute("y", strY);
     pageContext.setAttribute("m", strM);
     pageContext.setAttribute("d", strD);
     
   %>
     <form action = "/day15/CrmServlet?method=update&id=${customer.id}" method="post">
       <table border="1" align = "center" width="60%">
           <caption><h1>更新客户信息</h1></caption>
           <tr>
             <th>姓名</th>
             <td>
               <input type = "text" name="name" value="${customer.name}"/>
             </td>
           </tr>
           <tr>
             <th>性别</th>
             <td>
              <input ${customer.gender=='男'? 'checked':''} type ="radio" name = "gender" 
              value="男"/>男
              <input ${customer.gender=='女'? 'checked':''} type ="radio" name = "gender" 
              value="女"/>女
             </td>
           </tr>
           <tr>
             <th>地址</th>
             <td>
               <input type = "text" name="address" value="${customer.address}"/>
             </td>
           </tr>
            <tr>
              <th>电话</th>
               <td>
                <input type = "text" name ="tel" value = "${customer.tel }">
               </td>
            </tr>
           <tr>
             <th>邮箱</th>
             <td>
               <input type = "text" name="email" value="${customer.email}"/>
             </td>
           </tr>
           <tr>
              <th>生日</th>
             <td>
                <select name ="year">
                  <c:forEach var="year" begin="1990" end="2001">
                       <option ${y==year?'selected':''} >${year}</option>
                  </c:forEach>
                </select>年
                <select name = "month">
                <c:forEach  var="month" begin="1" end="12">
                       <option ${m==month?'selected':''}>${month}</option>
                  </c:forEach>月
                </select name="day">
                <select>
                <c:forEach  var="day" begin="1" end="31">
                       <option ${d==day?'selected':''} >${day}</option>
                  </c:forEach>
                </select>
             </td>
           </tr>
            <tr>
               <td colspan = "2" align="center">
                 <input type = "submit" value="提交">
               </td>
            </tr>
       </table> 
        </form>
  </body>
</html>
