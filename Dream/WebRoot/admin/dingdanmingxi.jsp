<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
	
    
		<title>梦之队 •当然果园系统 | 订单明细</title>
		 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
		<script type="text/javascript" src="admin/js/jconfirmaction.jquery.js"></script>
		<script language="javascript" type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
		function submit(){
			${"form"}[0].submit();
		}
	</script>
	</head>

	<body>
		<div class="right_content">
			<h2>订单明细</h2>
			<form action="StorageServlet?do=info" name="search" method="post">
				<div class="top-input">
					<table id="top-table">
						<tbody>
							<tr>
								<td>
									<span class="search">订单编号</span>
									<input type="text" name="num" value="${storageNum}" class="textfield" />
								</td>
								<td style="padding-right: 10px;">
									<span class="search">订单时间</span>
									<input type="text" name="begin" value="${beginTime}"
										onclick="WdatePicker()" class="textfield" />
									<span class="search">至</span>
									<input type="text" onclick="WdatePicker()" value="${endTime}"
										name="end" class="textfield" />
								</td>
								<td>
									<!-- Search -->
									<div class="search">
										<input type="submit" value="查询" />
									</div>
									<!-- / Search -->
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<table id="rounded-corner">
					<thead>
						<tr>
							<th scope="col" class="rounded">订单编号</th>
							<th scope="col" class="rounded">订单日期</th>
                            <th scope="col" class="rounded">订单状态</th>
                            <th scope="col" class="rounded">送达日期</th>
							<th scope="col" class="rounded">用户</th>
							<th scope="col" class="rounded">商品</th>
							<th scope="col" class="rounded">数量</th>
							<th scope="col" class="rounded">价格</th>
							<th scope="col" class="rounded">订单地址</th>
							<!-- <th scope="col" class="rounded-q4" style="padding-right: 20px;">删除</th> -->
						</tr>
					</thead>
					<tbody>
						<!-- 单条记录 -->
						<c:forEach items="${page.list}" var="s">
							<tr>
								<td>${s.storageNum}</td>
								<td>${s.storageTime}</td>
                                <td>${s.oStatus}</td>
                                <td>${s.storageTime}</td>
								<td>${s.provider.providerName}</td>
								<td>${s.good.goodName}</td>
								<td>${s.quantity}</td>
								<td>￥${s.unitPrice}</td>
								<td>${s.storageEmp.employName}</td>
								<!-- <td style="padding-right: 20px;">
									<a href="StorageServlet?do=del&sid=${s.storageId}" class="ask">
										<img src="images/trash.png" alt="" title="" border="0" />
									</a>
								</td> -->
							</tr>
						</c:forEach>
						<!--end 单条记录 -->
					</tbody>
				</table>

				<!-- 页码 + 按钮 -->
				<div class="btns-pagenav">
					<!-- 按钮 -->
					<div class="div-btns">
					<!--	<a href="StorageServlet?do=doadd" class="bt_green">商 品 入 库</a> -->
					</div>
					<!--end 按钮 -->

					<!-- 页码 -->
					<div class="page-navigator">
						<div class="page-navigator-left">
							每页
							<select class="select-short" name="pagesize" onchange="submit()">
								<option value="5" ${sessionScope.pagesize==5?"selected":""}>5</option>
								<option value="10" ${sessionScope.pagesize==10?"selected":""}>10</option>
							</select>
							条
						</div>
						<div class="page-navigator-right">
							<a href="StorageServlet?do=info&p=1&num=${storageNum}&begin=${beginTime}&end=${endTime}"
								class="first">«</a>
							<a href="StorageServlet?do=info&p=${page.pageno-1}&num=${storageNum}&begin=${beginTime}&end=${endTime}"
								class="prev">‹</a> &nbsp;第 1 页&nbsp; &nbsp;共
							1 页&nbsp;
							<a href="StorageServlet?do=info&p=${page.pageno+1}&num=${storageNum}&begin=${beginTime}&end=${endTime}"
								class="next">›</a>
							<a href="StorageServlet?do=info&p=${page.pagecount}&num=${storageNum}&begin=${beginTime}&end=${endTime}"
								class="last">»</a>
						</div>
					</div>
					<!--End 页码 -->
				</div>
				<!-- / 页码 + 按钮 -->

			</form>
		</div>
		<div class="clear"></div>
	</body>
</html>

