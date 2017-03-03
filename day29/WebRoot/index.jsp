<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<html:form action="/findHouse" method="post">
  		<table border="0" align="center">
  			<caption><h1>搜房条件</h1></caption>
  			<tr>
  				<th>区域</th>
  				<td>
  					<html:select property="area">
  						<html:option value="">不限</html:option>
  						<html:option value="天河区">天河区</html:option>
  						<html:option value="黄埔区">黄埔区</html:option>
  					</html:select>
  				</td>
  				<th>地点</th>
  				<td>
  				  	<html:select property="address">
  						<html:option value="">不限</html:option>
  						<html:option value="东圃">东圃</html:option>
  						<html:option value="下沙">下沙</html:option>
  					</html:select>
  				</td>
  				<th>地点</th>
  				<td>
  					<html:select property="space">
  						<html:option value="">不限</html:option>
  						<html:option value="三房二厅">三房二厅</html:option>
  						<html:option value="二房二厅">二房二厅</html:option>
  						<html:option value="一房一厅">一房一厅</html:option>
  					</html:select>
  				</td>  
  				<td>
  					<html:submit value="搜索"/>
  				</td>			
  			</tr>
  		</table>
  	</html:form>
  	      <table align="center" border="1" width="80%">
  	        
  	          
  	          <c:choose>
  	             <c:when test="${!empty requestScope.ListHouse}">
  	                  <tr>
  	            <th>区域</th>
  	            <th>地点</th>
  	            <th>空间</th>
  	         </tr>
  	                <c:forEach var="house" items="${requestScope.ListHouse}">
  	             <tr>
  	                <td>
  	                   ${house.area}
  	                </td>
  	                <td>
  	                   ${house.address}
  	                </td>
  	                <td>
  	                   ${house.space}
  	                </td>
  	             </tr>
  	          </c:forEach>
  	             </c:when>
  	              <c:otherwise>
  	                   <c:choose>
  	                      <c:when test="${!empty requestScope.houseForm.area}">
  	                     <font size="44" color="red"><center>查无此房</center></font>
  	                      
  	                      </c:when>
  	                      <c:otherwise>
  	                                                                             
  	                     <font size="44" color="red"><center>请选择</center></font>
  	                      </c:otherwise>
  	                   </c:choose>
  	              </c:otherwise>
  	          </c:choose>
  	          
  	      </table>
  </body>
</html>
