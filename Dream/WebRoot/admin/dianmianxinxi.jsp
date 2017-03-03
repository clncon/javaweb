<%@page import="com.dream.entity.Store"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>梦之队 •当然果园系统 | 店面信息</title>
		 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	</head>

	<body>
		<form id="userAdd" class="userAdd" action="StoreServlet?todo=updateStore" method="post">
		<!--  <input  type="hidden" value="searchStore" name="todo" > -->
			<div class="right_content" align="center">
				<h2>店面信息</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						
						<tr>
							<td>
								<span class="">商店名字</span>
							</td>
							<!--  <%   Store s=(Store)request.getAttribute("store"); %>-->
							<td>
								<input name="sName" id="" class="info-textfield" type="hidden"  value="${requestScope.store.sName}"  />
							    <span>${requestScope.store.sName}</span>
							
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						
						<tr>
							<td>
								<span class="">联系方式</span>
							</td>
							<td>
								<input name="sPhone" id="" class="info-textfield" type="text" value="${requestScope.store.sPhone} " />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">店家地址</span>
							</td>
							<td>
								<input name="sAddress" id="" class="info-textfield" type="text" value="${requestScope.store.sAddress} " />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td colspan="2" class="">
							
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										<input type="submit"  class="bt_green" value="修改">
										<a href="" class="bt_green">返 回</a>
									</div>
									<!--end 按钮 -->
								</div>
								<!-- / 页码 + 按钮 -->
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
		<div class="clear"></div>
	</body>
</html>
