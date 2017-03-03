<%@page import="java.util.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/simple" prefix = "simple"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
       <%-- <% 
          String address = request.getRemoteAddr();
          out.write(address);
       %> --%>
        <%--<simple:ip/>
       <simple:execute>
                           哈哈
       </simple:execute>
       <simple:skip>
                     哈啊哈
       </simple:skip>
       zidi
       <simple:for1>
          <input type = "text" name="ti"/><br/>
       </simple:for1>
       <simple:upper>
         abcd
       </simple:upper>--%>
       <%-- <% 
         pageContext.setAttribute("num", "12");
       %> 
       <simple:for2 count="${num }">
        <input type = "text" name="ti"/><br/>
       </simple:for2>
       <simple:for3  var="num" begin="10" end="50"  step="5">
          ${num}
       </simple:for3>
        <simple:referer error="/ad.jsp" url="http://localhost:8080/day16/welcome.jsp">
             <a href="#">
                                      下载
             </a>
        </simple:referer>
        <simple:if flag="${10<5}">
            10大于5
        </simple:if>
        10小于5
        <% 
           pageContext.setAttribute("age", "89");
        %>
         <simple:choose>
   	<simple:when test="${age<16}">
   		<font color="blue">你未成年</font>
   	</simple:when>
   	<simple:when test="${age>=16 and age<=60}">
   		<font color="red">你成年</font>
   	</simple:when>
   	<simple:otherwise>
   		<font color="yellow">你已老年</font>
   	</simple:otherwise>
   </simple:choose>
        --%>
        <%-- <%
            List<String> listIterator = new ArrayList<String>();
            listIterator.add("小王");
            listIterator.add("小吴");
            listIterator.add("小张");
            pageContext.setAttribute("LISTITERATOR",listIterator);
            
         %> --%>
       <%--   <%
            Map<String,String> map = new HashMap<String,String>();
            map.put("1","小王");
             map.put("2","小张");
              map.put("3","小李");
              pageContext.setAttribute("MAP", map);
          %> 
       <simple:forEach items="${MAP}" var="s">
                   ${s.key}----${s.value}<br/>
       </simple:forEach>--%>
       
         <simple:filter>
           <script type="text/javascript"> 
               while(true){
                  window.alert("haha");
               }
           </script>
         
         </simple:filter>
  </body>
</html>
