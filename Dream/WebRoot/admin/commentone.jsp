<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>梦之队 •当然果园系统 | 评论</title>
     <base href="<%=basePath%>">
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
        <h2>评论列表</h2>
		<div class="top-input">
			<form action="CommentServlet?todo=searchnameComment" name="search" method="post">
            	<table id="top-table">
                    <tbody>
                        <tr>
                            <td width="262">
								<span><span class="rounded">果</span>品名称</span>
										<select name="" size="1" class="" id="">
								<c:forEach var="com" items="${listcom}">
								  <option>${com.cGname }</option>				
								 	</c:forEach>		
                              </select>
                          </td>
                            <td width="291" style="padding-right: 10px;"><span class="search">评论时间</span>
                              <input type="text" name="begin" value="${beginTime}"
										onclick="WdatePicker()" class="textfield" />
                              <span class="search">至</span>
                              <input type="text" onclick="WdatePicker()" value="${endTime}"
										name="end" class="textfield" /></td>
                            <td width="61">
								<!-- Search --><span class="search">
								<input type="submit" value="查询" />
								</span><!-- / Search -->
                            </td>
                        </tr>
                    </tbody>
                </table>
			</form></div>                   
		<table id="rounded-corner">
            <thead>
                <tr>
                    <th width="39" height="36" class="rounded-company" scope="col"><input type="checkbox" name="input" /></th>
                    <th width="177" class="rounded" scope="col">果品名称</th>
                    <th width="46" class="rounded" scope="col">果品代码</th>
                    <th width="196" class="rounded" scope="col">评论内容</th>
                    <th width="111" class="rounded" scope="col">评论IP</th>
                    <th width="102" class="rounded" scope="col">评论者</th>
                    <th width="153" class="rounded" scope="col">评论日期</th>
                </tr>
            </thead>
            <tbody>
                <!-- 单条记录 -->              
                <tr>
                    <td><input type="checkbox" name="" /></td>
                    <td>${com.cGname }</td>
                    <td>${com.cId}</td>
                    <td>${com.cContent }</td>
                    <td>${com.cIp }</td>
                    <td>${com.cAuthor }</td>
                    <td>${com.cDate }</td>                  
                </tr>              
                <!--end 单条记录 -->
                
              
            </tbody>
            <tfoot>
			</tfoot>
        </table>
        
        <!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
            <div class="div-btns"><a href="CommentServlet?todo=searchComment" class="bt_green">显示全部<span class="rounded">评论</span></a>
            </div> 
			<!--end 按钮 --> 
            
			<!-- 页码 -->
			<div class="page-navigator">
                <div class="page-navigator-left">
				每页
                <select class="select-short" name="select">
                  <option value="0" selected="selected">5</option>
                  <option value="1">10</option>
                  <option value="2">15</option>
                </select>
				条
                </div>
				<div class="page-navigator-right">
                <a href="" class="first">«</a>
                <a href="" class="prev">‹</a>
                &nbsp;第 1 页&nbsp; &nbsp;共 20 页&nbsp;
                <a href="" class="next">›</a>
                <a href="" class="last">»</a>
                </div>
			</div>
			<!--End 页码 -->
        </div>
        <!-- / 页码 + 按钮 -->
    </div>
	<div class="clear"></div>
</body>
</html>