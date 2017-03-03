<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>梦之队 • 当然果园在线系统 | 添加会员</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	</head>

	<body>
		<form id="userAdd" class="userAdd" action="UserServlet?f=userAdd" method="post">
			<div class="right_content" align="center">
				<h2>添加会员</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">用户账号*</span>
							</td>
							<td>
								<input name="userCode" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户姓名*</span>
							</td>
							<td>
								<input name="userName" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户性别*</span>
							</td>
							<td>
								<span>男</span>
								<input type="radio" name="userSex" value="1" />
								<span>女</span>
								<input type="radio" name="userSex" value="0" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">联系方式</span>
							</td>
							<td>
								<input name="userPhone" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">联系地址</span>
							</td>
							<td>
								<input name="userAddr" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">vip等级</span><br></td>
							<td>
								<select name="userDep">
									<c:forEach items="${deps}" var="dep">
										<option value="${dep.departmentId}">
											${dep.departmentName}
										</option>
									</c:forEach>
								</select>
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
										<a href="javascript:void(0)" class="bt_green" onclick="submit()">添 加 会员</a>
										<a href="javascript:void(0)" class="bt_green" onclick="reset()">返 回</a>
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
