<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>梦之队 • 当然果园在线系统 | 添加订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
		 <script type="text/javascript" src="admin/js/yanzheng.js"></script>
	<script type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script></head>

	<body>
		<form id="orderAdd" class="orderAdd" action="OrdersServlet?todo=addOrders" method="post">
		 
			<div class="right_content" align="center">
				<h2>添加订单</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
				<tr>	
 <td width="291" style="padding-right: 10px;"><span class="search">订单日期</span></td>
                              <td><input type="text" name="begin" value=""
onclick="WdatePicker()" class="textfield" /></td>
</tr>

						<tr>
							<td>
								<span class="">订单状态</span>
							</td>
							<td>
								<input name="ostatus" id="ostatus" class="info-textfield" type="text" placeholder="请输入订单状态" value="未送达"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
					<tr>
                              <td><span class="search">送达日期</span></td>
                              <td><input type="text" onclick="WdatePicker()" value=""
name="end" class="textfield" /></td>	
</tr><tr>
							<td>
								<span class="">用户</span>
							</td>
							<td>
								<input name="uname" id="uname" class="info-textfield" type="text" placeholder="请输入买家名"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">商品</span>
							</td>
							<td>
								<input name="gname" id="gname" class="info-textfield" type="text" placeholder="请输入买的果品名"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">数量</span>
							</td>
							<td>
								<input name="pnum" id="pnum" class="info-textfield" type="text" placeholder="请输入数量"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">价格</span>
							</td>
							<td>
								<input name="gprice" id="gprice" class="info-textfield" type="text" placeholder="请输入价格"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">订单地址</span>
							</td>
							<td>
								<input name="oaddress" id="oaddress" class="info-textfield" type="text" placeholder="请输入订单地址"/>
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
									<input class="bt_green" type="submit" name="bt_green" id="bt_green" value="添加订单">									
										<a href="OrdersServlet?todo=searchOrders" class="bt_green" onclick="reset()">返 回</a>
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
									