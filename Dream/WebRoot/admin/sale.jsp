<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
   <base href="<%=basePath%>">
    <title>梦之队 •当然果园系统 | 销售</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	<script type="text/javascript" src="admin/js/jconfirmaction.jquery.js"></script>
    <script type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
	</script>
</head>

<body>
    <div class="right_content">            
      <h2>销售业绩</h2>
	  <div class="top-input">
			
		<table id="rounded-corner">
            <thead>
                <tr>
                    <th width="160" class="rounded" scope="col">订单数量</th>
                    <th width="149" class="rounded" scope="col">成交金额</th>
                    <th width="119" class="rounded" scope="col">访客数目</th>
                </tr>
            </thead>
            <tbody>
                <!-- 单条记录   requestScope. -->                          
               <input type="hidden" name="said" value="${sale11.saId}"/>
                <tr>
                    <td>${sale11.saNum}</td>
                    <td>${sale11.saPrice}</td>
                    <td>${sale11.saVisitor}</td>
                </tr>
               
            </tbody>
            <tfoot>
			</tfoot>
        </table>
        
        <!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
          <div class="div-btns"><a href="SaleServlet?todo=searchSale" class="bt_green">返回<span class="rounded"></span></a>
            </div> 
			<!--end 按钮 --> 
            
			<!-- 页码 --><!--End 页码 -->
      </div>
        <!-- / 页码 + 按钮 -->
    </div>
	<div class="clear"></div>
</body>
</html>