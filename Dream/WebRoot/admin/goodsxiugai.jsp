<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
	    <base href="<%=basePath%>">
		<title>梦之队 • 当然果园在线系统 | 修改果品</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	</head>

	<body>
		<form id="goodsAdd" class="goodsAdd" action="GoodsServlet?todo=updateGoods" method="post">
			<div class="right_content" align="center">
			<input type="hidden" name="gid" value="${goods.gId}"/>
				<h2>修改果品信息</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">果品名称</span>
							</td>
							<td>
								<input name="gname" id="" class="info-textfield" type="text" value="${goods.gName}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">销售价格</span>
							</td>
							<td>
								<input name="gprice" id="" class="info-textfield" type="text" value="${goods.gPrice}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">类型</span>
							</td>
							<td>
								<input name="gtype" id="" class="info-textfield" type="text" value="${goods.gType}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">产地</span>
							</td>
							<td>
								<input name="gaddress" id="" class="info-textfield" type="text" value="${goods.gAddress}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							
						
								<input name="gpic" id="" class="info-textfield" type="hidden" value="${goods.gPic}"/>
					
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">描述</span>
							</td>
							<td>
								<input name="gdescribe" id="" class="info-textfield" type="text" value="${goods.gDescribe}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td colspan="2" class="">
								<script type="text/javascript">
								function reset() {
									$(".userAdd")[0].reset();
								}
								function submit() {
									$(".userAdd").submit();
								}
								</script>
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										
											<input class="bt_green" type="submit" name="bt_green" id="bt_green" value="修改果品">
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
  