<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
     <title>index</title>
     <link rel="stylesheet" type="text/css" href="././css/xsgl.css">
<script type="text/javascript">
      
       function init(){
    	   	var serch=document.getElementById("cx");
    	   	var serchcontent=document.getElementById("cxop");
    	   	serchcontent.style.display="none";
    	   	serch.onclick=serchdownlist;
    		function serchdownlist(){
    		   if(serchcontent.style.display=="block"){
    			   
    			   serchcontent.style.display="none";
    			}
    			else{
    				serchcontent.style.display="block";
    			}
    		   return false;
    	  	 } 
    		
    		var sortbutton=document.getElementById("sort");
     	   	var sortcontent=document.getElementById("sortop");
     	   	sortcontent.style.display="none";
     	  	sortbutton.onclick=sortdownlist;
     		function sortdownlist(){
     		   if(sortcontent.style.display=="block"){
     			   
     			  sortcontent.style.display="none";
     			}
     			else{
     				sortcontent.style.display="block";
     			}
     		   return false;
     	   }  
    	   
    	   
    	    var thisTags=document.getElementsByTagName("td");
   			for(var i=0;i<thisTags.length;i++){
   				if(thisTags[i].innerText<60){
   				
       				thisTags[i].setAttribute("class", "invalid");
       				//alert(thisTags[i].classname);
       			}
   			}
    	   
       var div = document.getElementById("div");
       var course = document.getElementById("course");
         div.style.display = "inline";
         course.style.display = "inline";
         
       /*  var tr = document.getElementById("trRed");
        var arry = tr.childNodes;
        for(var i=4;i<=6;i++){
           var temp = arry[i].innText*1;
           if(temp<60){
              arry[i].style.color="color";
           }
        } */
         
       }
       function fy(){
         
    		//定位到inputID所对应的元素
    		var inputElement = document.getElementById("inputID");
    		var currentPageNo = inputElement.value;
    		  if(currentPageNo<=${Page.allPageNo}&&currentPageNo>=1){
    		     var url = "${pageContext.request.contextPath}/stuServlet?method=findAllStudent&currentPageNo="+currentPageNo;
    		      window.location.href = url;
    		 }
    		 else{
    		     window.alert("您输入的页号不存在");
    		     document.getElementById("inputID").focus();
    		     document.getElementById("inputID").select();
    		 }
    	}
    	function deleteAll(){
    	
            var strId="";
    	   var tableElement = document.getElementById("tableId");
    	 
    	   var size = tableElement.rows.length;
    	   for(var i=1;i<size-2;i++){
    	      var checkboxElement = tableElement.rows[i].cells[0].firstChild;
    	      if(checkboxElement.checked){
    	           strId += checkboxElement.value+"_";
    	          
    	      }
    	   }
    	     
    	   if(strId.length>0){
    	   
    	     var url = "/XSGL/stuServlet?method=deleteStudent&strId="+strId;
    	      window.location.href = url;
    	   }else{
    	     window.alert("请选中要删除的用户选项");
    	   }
    	    
    	}
    	 
	function addSelect(selects) {
		var index = selects.selectedIndex;
		var div = document.getElementById("div");
		var span = document.getElementById("span");
		
		if (index==3) {
		    var select = document.createElement("select");
			select.setAttribute("name", "course");
			var option1 = document.createElement("option");
			option1.value = "english";
			option1.innerText = "英语";
			var option2 = document.createElement("option");
			option2.value = "math";
			option2.innerText = "数学";
			var option3 = document.createElement("option");
			option3.value = "chinese";
			option3.innerText = "语文";
			//将option加到select中
			select.appendChild(option1);
			select.appendChild(option2);
			select.appendChild(option3);
			//将select加入到div中
			div.appendChild(select);
			//提示信息
            
			span.innerText = "格式:60_80";
		}
		else
		{
		     var select2 = document.getElementsByTagName("select")[1];
		     //alert(select2.length);
		     div.removeChild(select2);
		     span.innerText="";
		}

	}
	function change(select){
	  var index = select.selectedIndex;
	  var div = document.getElementById("course");
	     //只有选中了第二个或第三个才会添加新select
	    if(index==1||index==2){
	        var select2 = document.getElementById("Curriculum");
	        //如果已经添加了select则不在添加
	       if(select2==null){
	        var select = document.createElement("select");
			select.setAttribute("name", "course");
			select.setAttribute("id","Curriculum");
			var option1 = document.createElement("option");
			option1.value = "english";
			option1.innerText = "英语";
			var option2 = document.createElement("option");
			option2.value = "math";
			option2.innerText = "数学";
			var option3 = document.createElement("option");
			option3.value = "chinese";
			option3.innerText = "语文";
			//只有选择了第一项才会添加总分的选项
			if(index==1){
			var option4 = document.createElement("option");
			option4.value="sum";
		    option4.innerText="总分";
			select.appendChild(option4);
			}
			if (index == 2) {
					var selectClass = document.createElement("select");
					selectClass.setAttribute("name", "selectClass");
					selectClass.setAttribute("id", "selectClass");
					var selectClassOption1 = document.createElement("option");
					selectClassOption1.value = "great";
					selectClassOption1.innerText = "优秀率";
					var selectClassOption2 = document.createElement("option");
					selectClassOption2.value = "fail";
					selectClassOption2.innerText = "不及格率";
					selectClass.appendChild(selectClassOption1);
					selectClass.appendChild(selectClassOption2);
					div.appendChild(selectClass);
				}
			 //将option加到select中
			select.appendChild(option1);
			select.appendChild(option2);
			select.appendChild(option3);
			div.appendChild(select);
			
			}
			else{
			   //如果你选择了第二项，就把总分这个选项去掉，如果总分存在的话
			   if(index==2){
			     
			     var selects = document.getElementById("Curriculum");
			     if(selects.childNodes.length==4){
			        //alert("sd");
			        selects.removeChild(selects.childNodes[3]);
			     }
			     if(document.getElementById("studentClass")==null){
			         var selectClass = document.createElement("select");
					selectClass.setAttribute("name", "selectClass");
					selectClass.setAttribute("id", "selectClass");
					var selectClassOption1 = document.createElement("option");
					selectClassOption1.value = "great";
					selectClassOption1.innerText = "优秀率";
					var selectClassOption2 = document.createElement("option");
					selectClassOption2.value = "fail";
					selectClassOption2.innerText = "不及格率";
					selectClass.appendChild(selectClassOption1);
					selectClass.appendChild(selectClassOption2);
					div.appendChild(selectClass);
			     }
			   }
			   else{
			        var selects = document.getElementById("Curriculum");
			        //如果是第三项的话就将把总分这个选项加上，如果总分存在的话
			        if(selects.childNodes.length==3){
			           var option4 = document.createElement("option");
			          option4.value="sum";
		              option4.innerText="总分";
			          selects.appendChild(option4);
			            var selectClass = document.getElementById("selectClass");
	                   div.removeChild(selectClass);
			        }
			   }
			}
			
	    }else   
	    {
	     
	      var select2 = document.getElementById("Curriculum");
	         div.removeChild(select2);
	      var selectClass = document.getElementById("selectClass");
	      div.removeChild(selectClass);
	  
	    }
	}
	 
</script>
<body onload="init()">

<div class="title">学生信息管理页面</div>
<div class="outer">
<div class="navigation">
	<div id="cx"><h4>按条件查询</h4></div>
	<div id="cxop" class="aaa">
	<form action="${pageContext.request.contextPath}/selectServlet" method="post">
		<select name="select" onchange="addSelect(this)">
			<option ${select== 'id'? 'selected':''} value="id">学号</option>
			<option ${select== 'name'? 'selected':''}  value="name">姓名</option>
			<option ${select== 'myClass'? 'selected':''} value="myClass">班级</option>
			<option>课程</option>
		</select>
		<div id="div"></div>
		<br><input type="text" name="selectname" value="${selectname}" /><input type="submit" value="查询" /><br><font
			color="red" size="4"><span id="span"></span>
		</font> 
	</form>
	<p><jsp:include page="back.jsp" />
	&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	
	<div id="sort"><h4>按条件排序</h4></div>
	<div id="sortop">
	<form action="${pageContext.request.contextPath}/OrderServlet" method="post">
		           <select name="select" onchange="change(this)"> 
		              <option value="id">学号</option>
		              <option>课程</option>
		              <option value="myclass">班级</option>
		           </select>
		           <div id="course"></div>
		            <select name="order">
		                <option value="asc">升序</option>
		                <option value="desc">降序</option>
		            </select>   
		            <input type="submit" value="排序"/>
		       </form>
	</div>
	
	<div><h4>添加学生信息<a href="${pageContext.request.contextPath}/stuServlet?method=toAddJsp">
					   &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></h4></div>
</div>	
	
<div class="stu_table">
	<table id="tableId" border="0" align="center" width="850px" height="500px">
		
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>班级</th>
			<th>英语</th>
			<th>数学</th>
			<th>语文</th>
		</tr>
		<c:forEach var="student" items="${Page.listStudent}">
			<tr id="TrRed">
				<td><input type="checkbox" value="${student.id}" />${student.id}</td>
				<td>${student.name}</td>
				<td>${student.gender}</td>
				<td>${student.myClass}</td>
				<td class="pg">${student.english}</td>
				<td class="pg">${student.math}</td>
				<td class="pg">${student.chinese}</td>
				<td><a
					href="${pageContext.request.contextPath}/stuServlet?method=findStudentById&id=${student.id}"
					style="text-decoration:none">[编辑]</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center"><input id="inputID" type="text"
				size="1" name="currentPageNo" /> <input type="button" value="GO"
				onclick="fy()" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
				value="删除" onclick="deleteAll()" /> </br>当前第${Page.currentPageNo}页/共有${Page.allPageNo}页</td>
		</tr>
		<%-- <tr>
			<td colspan="7" align="center"><a
				href="${pageContext.request.contextPath}/stuServlet?method=toAddJsp"
				 style="text-decoration: none">
					[添加学生信息] </a></td>
		</tr> --%>
		<%--  <tr>
		     <th>排序</th>
		    <td colspan="6">
		       <form action="${pageContext.request.contextPath}/OrderServlet" method="post">
		           <select name="select" onchange="change(this)"> 
		              <option value="id">学号</option>
		              <option>课程</option>
		              <option value="myclass">班级</option>
		           </select>
		           <div id="course"></div>
		            <select name="order">
		                <option value="asc">升序</option>
		                <option value="desc">降序</option>
		            </select>   
		            <input type="submit" value="排序"/>
		       </form>
		    </td>
		 </tr> --%>
	</table>
</div>		
</div>	
</body>
</html>
