<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
	    <base href="<%=basePath%>">
		<title>梦之队 • 当然果园在线系统 | 修改会员</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	</head>

	<body>
		<form id="" class="" action="VipServlet?todo=updateVip&uid=${vip.uId}" method="post">
		 <input type="hidden" name="uid" value="${vip.uId}">
			<div class="right_content" align="center">
				<h2>修改会员</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">用户账号*</span>
							</td>
							<td>
								<input name="uPhone" id="uPhone" class="info-textfield" type="text" value="${vip.uPhone }" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户姓名*</span>
							</td>
							<td>
								<input name="uName" id="uName" class="info-textfield" type="text" value="${ vip.uName}" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户性别*</span>
							</td>
							<td>								
								<input type="text" name="sex" id="sex" class="info-textfield" value="${ vip.sex}" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户邮箱</span>
							</td>
							<td>
								<input name="uMail" id="uMail" class="info-textfield" type="text"  value="${ vip.uMail}"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">联系地址</span>
							</td>
							<td>
								<input name="uAddress" id="uAddress" class="info-textfield" type="text" value="${vip.uAddress }" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>		
						<tr>
							<td>
								<span class="">vip等级</span><br></td>
							<td>
								<select name="uLevel"  >
									
										<option selected="true">${vip.uLevel}</option>
										<option>0</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									
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
										<!--  <a href="javascript:void(0)" class="bt_green" onclick="submit()">提交</a>-->
										<input type="submit"  class="bt_green" value="修改" >										
										<a href="VipServlet?todo=searchVip" class="bt_green" onclick="reset()"><input type="button"  class="bt_green" value="返 回" ></a>
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
  