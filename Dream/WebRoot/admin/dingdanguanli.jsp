<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>    
    
    <title>梦之队 •当然果园系统 | 订单信息管理 </title>
    <base href="<%=basePath%>">
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
        <h2>订单信息管理</h2>
		<div class="top-input">
			
	  </div>                   
		<table id="rounded-corner">
            <thead>
                <tr>
                    <th scope="col" class="rounded-company"><input type="checkbox" name="input" /></th>
                    <th scope="col" class="rounded">订单编号</th>
                    <th scope="col" class="rounded">订单日期</th>
                    <th scope="col" class="rounded">订单状态</th>
                    <th scope="col" class="rounded">送达日期</th>
                    <th scope="col" class="rounded">用户</th>
                    <th scope="col" class="rounded">商品</th>
                    <th scope="col" class="rounded">数量</th>
                    <th scope="col" class="rounded">价格</th>
                    <th scope="col" class="rounded">订单地址</th>
                    <th scope="col" class="rounded">修改</th>
                    <th scope="col" class="rounded-q4">删除</th>
                </tr>
            </thead>
            <tbody>
                <!-- 单条记录 -->
                
                <c:forEach items="${listOugp }" var="Ougp"><tr>
                    <td><input type="checkbox" name="" /></td>
                    <td>${Ougp.oId }</td>
                    <td>${Ougp.oStartdate}</td>
                    <td>${Ougp.oStatus }</td>
                    <td>${Ougp.oEnddate}</td>
                    <td>${Ougp.uName}</td>
                    <td>${Ougp.gName}</td>
                    <td>${Ougp.pNum}</td>
                    <td>${Ougp.gPrice}</td>
                    <td>${Ougp.oAddress}</td>                  
                    
                    <td><a href="OrdersServlet?todo=searchupdateOrders&&oid=${Ougp.oId}"><img src="admin/images/user_edit.png" alt="" title="" border="0" /></a></td>
                     
                    <td><a href="OrdersServlet?todo=deleteOrders&&oid=${Ougp.oId}" class="ask"><img src="admin/images/trash.png" alt="" title="" border="0" /></a></td>
                </tr>
                 </c:forEach>
                <!--end 单条记录 -->

            </tbody>
            <tfoot>
				
            </tfoot>
        </table>
        
        <!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
            <div class="div-btns">
                <a href="admin/addOrders.jsp" class="bt_green">添 加 订单</a>

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
							<a href="OrdersServlet?todo=searchOrders&pageNo=1" class="first">«</a>
							<a href="OrdersServlet?todo=searchOrders&pageNo=${page.pageNo-1}"
								class="prev">‹</a> &nbsp;第 ${page.pageNo} 页&nbsp; &nbsp;共<td>${page.pageCount}</td>页&nbsp;
							<a href="OrdersServlet?todo=searchOrders&pageNo=${page.pageNo+1}"
								class="next">›</a>
							<a href="OrdersServlet?todo=searchOrders&pageNo=${page.pageCount}"
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