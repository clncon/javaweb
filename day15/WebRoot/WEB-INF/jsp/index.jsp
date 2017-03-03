<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <script type="text/javascript">
    	function fy(){
    		//定位到inputID所对应的元素
    		var inputElement = document.getElementById("inputID");
    		var currPageNO = inputElement.value;
    		  if(currPageNO<=${page.allPageNO}&&currPageNO>=1){
    		     var url = "/day15/CrmServlet?method=findAllCustomer&currPageNO="+currPageNO;
    		      window.location.href = url;
    		 }
    		 else{
    		     window.alert("您输入的页号不存在");
    		     document.getElementById("inputID").focus();
    		     document.getElementById("inputID").select();
    		 }
    	}
    	function deleteAll(){
    	    //**注意firstChild在标准浏览器中也算一个节点
    		var tableElement = document.getElementById("tableID");
    		var size = tableElement.rows.length;//size=5
    		//装ID号的数组
    		var strId = "";
    		for(var i=1;i<=size-2;i++){
    			//取得每行的1列中的checkbox元素
    			var checkboxElement = tableElement.rows[i].cells[0].firstChild;
    			//如果该复选框被选中
    			if(checkboxElement.checked){
    				//收集该复选框的ID值
    				strId += checkboxElement.value + "_";
    			}
    		
    	}
    		if(strId.length>0){
    		   var url = "/day15/CrmServlet?method=deleteCustomerById&strId="+strId;
    		   window.location.href = url;
    		 }else{
    		    window.alert("请选中所要删除的客户的状态");
    		 } 
    	}
    </script>
  	<table id="tableID" border="1" align="center" width="80%">
  		<caption><h1>客户信息</h1></caption>
  		<tr>
  			<th>状态</th>
  			<th>姓名</th>
  			<th>性别</th>
  			<th>地址</th>
  			<th>电话</th>
  			<th>邮箱</th>
  			<th>生日</th>
  		</tr>
  		<c:forEach var="customer" items="${page.listCustomer}">
  			<tr>
  				<td><input type="checkbox" value="${customer.id}"/></td>
  				
  				<td>${customer.name}</td>
  				<td>${customer.gender}</td>
  				<td>${customer.address}</td>
  				<td>${customer.tel}</td>
  				<td>${customer.email}</td>
  				<td>${customer.birthday}</td>
  				<td>
  					<a href="/day15/CrmServlet?method=findCustomerById&id=${customer.id}" style="text-decoration:none">[编辑]</a>
  				</td>
  			</tr>
  		</c:forEach>
		<tr>
			<td colspan="7" align="center">
			 <input type="button" value="删除"
				onclick="deleteAll()" /> <input id="inputID" type="text" size="1"
				name="currPageNO" /> <input type="button" value="GO" onclick="fy()" />
				当前第${page.currentPageNO}/共有${page.allPageNO}</td>
		</tr>
		<tr>
		   <td>
		      <a href="/day15/CrmServlet?method=toAddJsp" style = "text-decoration: none" align = "left">[添加客户信息]</a>
		    </td>
		</tr>
	</table>
  </body>
</html>
