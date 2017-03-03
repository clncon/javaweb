<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
     <title>orderStudent</title>
     <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
     <script type="text/javascript">
    	function init(){
    		var thisTags=document.getElementsByTagName("td");
    		
    		for(var i=0;i<thisTags.length;i++){
    			if(thisTags[i].innerText<60){
    				
        			thisTags[i].setAttribute("class", "invalid");
        			//alert(thisTags[i].classname);
        		}
    		}
    	}
     </script>
</head>
<body onload="init()">
<div class="title">学生信息排序页面</div>
<div class="sort_table">
	<table id="tableId" border="0" align="center" width="1000px" height="750px">
		
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>班级</th>
			<th>英语</th>
			<th>数学</th>
			<th>语文</th>
			<th>总分</th>
			<th>平均分</th>
		</tr>
		<c:forEach var="student" items="${LISTSTU}">
			<tr>
				<td class="pi">${student.id}</td>
				<td class="pi">${student.name}</td>
				<td class="pi">${student.gender}</td>
				<td class="pi">${student.myClass}</td>
				<td class="pg" >${student.english}</td>
				<td class="pg" >${student.math}</td>
				<td class="pg" >${student.chinese}</td>
				<td class="pg">${student.total_point}</td>
				<td class="pg">${student.average}</td>
			</tr>
		</c:forEach> 
	</table>
	<div class="back"><jsp:include page="back.jsp"/></div>
</div>
</body>
</html>
