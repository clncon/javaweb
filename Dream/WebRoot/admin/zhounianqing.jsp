<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">  
    <title>梦之队 • 当然果园在线系统|周年庆</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	<script type="text/javascript" src="admin/js/jconfirmaction.jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
	</script>
</head>

<body>
    

    <div class="right_content">            
        <h2>周年庆</h2>
		<div class="top-input">
			<form action="" name="search" method="post">
            	<table id="top-table">
                    <tbody>
                        <tr>
                            <td>
								<span>商品名称</span>
								<select name="gname" size="1" class="" id="">
								<c:forEach var="ac" items="${listActivity}">
								  <option>${ac.gName} </option>				
								 	</c:forEach>		
                              </select>    
                            </td>
                            <td>
								<!-- Search -->
                                <div class="search">                                 
                                    <input type="submit" class="button" value="GO" />
                                </div>
							  <!-- / Search -->
                            </td>
                        </tr>
                    </tbody>
                </table>
			</form>
	  </div>                   
		<table id="rounded-corner">
            <thead>
                <tr>
                    <th scope="col" class="rounded-company"><input type="checkbox" name="input" /></th>
                    <th scope="col" class="rounded">商品名称</th>
                    <th scope="col" class="rounded">商品代码</th>
                    <th scope="col" class="rounded">零售价格</th>
                    <th scope="col" class="rounded">活动价格</th>
                    <th scope="col" class="rounded">日期</th>
                    <th scope="col" class="rounded">修改</th>
                    <th scope="col" class="rounded-q4">删除</th>
                </tr>
            </thead>
            <tbody>
                <!-- 单条记录 -->
               <c:forEach var="ac" items="${listActivity}">
                <tr>
                    <td><input type="checkbox" name="" /></td>
                   
                    <td>${ac.gName }</td>
                    <td>${ac.aGid }</td>
                    <td>￥${ac.gPrice }</td>
                    <td>￥${ac.aprice }</td>
                    <td>${ac.adate }</td>
                    <td><a href="ActivityServlet?todo=searchActivityByaId&&aId=${ac.aId }"><img src="admin/images/user_edit.png" alt="" title="" border="0" /></a></td>
                    <td><a href="ActivityServlet?todo=deleteActivity&&aGid=${ac.aGid}" class="ask"><img src="admin/images/trash.png" alt="" title="" border="0" /></a></td>
                </tr>
                <!--end 单条记录 -->
               </c:forEach>
                
                
            </tbody>
            <tfoot>
				<tr>
                    <td colspan="9" class=""><em><br></em></td>
                </tr>
            </tfoot>
        </table>
        
        <!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
            <div class="div-btns">
                <a href="admin/addActivity.jsp" class="bt_green">添 加 商 品 活 动</a>
                <a href="ActivityServlet?todo=searchActivity" class="bt_green">显示全部活动</a>
            </div> 
			<!--end 按钮 --> 
            
			<!-- 页码 -->
			<div class="page-navigator">
              <%--  <div class="page-navigator-left">
				每页
                <select class="select-short" name="select">
                  <option value="0" selected="selected">5</option>
                  <option value="1">10</option>
                  <option value="2">15</option>
                </select>
				条
                </div>
                 --%>
				<div class="page-navigator-right">
							<a href="ActivityServlet?todo=searchAnniversary&pageNo=1" class="first">«</a>
							<a href="ActivityServlet?todo=searchAnniversary&pageNo=${page.pageNo-1}"
								class="prev">‹</a> &nbsp;第 ${page.pageNo} 页&nbsp; &nbsp;共<td>${page.pageCount}</td>页&nbsp;
							<a href="ActivityServlet?todo=searchAnniversary&pageNo=${page.pageNo+1}"
								class="next">›</a>
							<a href="ActivityServlet?todo=searchAnniversary&pageNo=${page.pageCount}"
								class="last">»</a>
						</div>
			</div>
			<!--End 页码 -->
        </div>
        <!-- / 页码 + 按钮 -->
    </div>
	<div class="clear"></div>
</body>
</html>