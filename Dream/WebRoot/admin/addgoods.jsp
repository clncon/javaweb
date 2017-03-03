<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>梦之队 • 当然果园在线系统 | 添加果品</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	</head>

	<body>
		<form id="goodsAdd" class="goodsAdd" action="GoodsServlet" method="post">
		 <input	type="hidden" name="todo" value="addGoods">
			<div class="right_content" align="center">
				<h2>添加果品</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">果品名称</span>
							</td>
							<td>
								<input name="gname" id="gname" class="info-textfield" type="text" placeholder="请输入果品名"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">出售价格</span>
							</td>
							<td>
								<input name="gprice" id="gprice" class="info-textfield" type="text" placeholder="请输入价格"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
							<tr>
							<td>
								<span class="">类型</span>
							</td>
							<td>
								<input name="gtype" id="gtype" class="info-textfield" type="text" placeholder="请输入果品类型"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>	<tr>
							<td>
								<span class="">产地</span>
							</td>
							<td>
								<input name="gaddress" id="gaddress" class="info-textfield" type="text" placeholder="请输入果品产地" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">日期</span>
							</td>
							<td>
								<input name="" id="" class="info-textfield" type="text" placeholder="请输入日期"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">图片</span>
							</td>
							<td>
								<input name="gpic" id="gpic" class="info-textfield" type="text" placeholder="请输入图片地址"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">描述</span>
							</td>
							<td>
								<input name="gdescribe" id="gdescribe" class="info-textfield" type="text" placeholder="请输入果品描述"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">库存</span>
							</td>
							<td>
								<input name="rnum" id="rnum" class="info-textfield" type="text" placeholder="请输入库存数量"/>
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
									<input class="bt_green" type="submit" name="bt_green" id="bt_green" value="添 加 果品">									
										<a href="GoodsServlet?todo=searchGoods" class="bt_green" onclick="reset()">返 回</a>
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
									