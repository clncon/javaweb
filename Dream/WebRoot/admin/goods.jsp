<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
   <base href="<%=basePath%>">
    <title>梦之队 •当然果园系统 | 果品</title>
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
        <h2>果品列表</h2>
		<div class="top-input">
			<form action="GoodsServlet?todo=searchnameGoods" name="search" method="post">
            	<table id="top-table">
                    <tbody>
                        <tr>
                            <td>
								<span><span class="rounded">果</span>品名称</span>
								<select name="gname" size="1" class="" id="">
								<c:forEach var="good" items="${listGood}">
								  <option>${good.gName} </option>				
								 	</c:forEach>		
                              </select>
                          </td>
                            <td>
								<!-- Search -->
                                <div class="search">
                                  <input type="submit" class="button" value="GO" />
                                </div>
							  <!-- / Search -->
                            </td>
                        </tr>
                    </tbody>
                </table>
			</form>
	  </div>                   
		<table id="rounded-corner">
            <thead>
                <tr>
                    <th width="38" class="rounded-company" scope="col"><input type="checkbox" name="input" /></th>
                    <th width="166" class="rounded" scope="col">果品名称</th>
                    <th width="42" class="rounded" scope="col">果品代码</th>
                    <th width="86" class="rounded" scope="col">出售价格</th>
                    <th width="86" class="rounded" scope="col">类型</th>
                    <th width="100" class="rounded" scope="col">产地</th>
                   
                    <th width="116" class="rounded-q4" scope="col">描述</th>
                    <th width="84" class="rounded" scope="col">修改</th>
                    <th width="110" class="rounded-q4" scope="col">删除</th>           
                </tr>
            </thead>
            <tbody>
            <c:forEach var="goods" items="${listGoods}">
                <!-- 单条记录 -->
              
                <tr>
                 
                    <td><input type="checkbox" name="" id="" value=""/></td>               
                    <td>${goods.gName} </td>
                    <td>${goods.gId}</td>
                    <td>${goods.gPrice}</td>
                    <td>${goods.gType}</td>
                    <td>${goods.gAddress}</td>
                                        <td>${goods.gDescribe}</td>
                    <td><a href="GoodsServlet?todo=searchupdateGoods&&gid=${goods.gId}"><img src="admin/images/user_edit.png" alt="" title="" border="0" /></a></td>
                    <td><a href="GoodsServlet?todo=deleteGoods&&gid=${goods.gId}" class="ask"><img src="admin/images/trash.png" alt="" title="" border="0" /></a></td>
                </tr>
                <!--end 单条记录 -->      
               </c:forEach>
            </tbody>
            <tfoot>
				<tr>
                    <td colspan="11" class=""><em>注：<span class="rounded">果</span>品以实物为准！</em></td>
                </tr>
            </tfoot>
        </table>
        
        <!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
            <div class="div-btns">
            <div class="div-btns"><a href="GoodsServlet?todo=searchAllGoods2" class="bt_green">显示全部<span class="rounded">果品</span></a>
                <a href="admin/addgoods.jsp" class="bt_green">添 加 <span class="rounded">果</span> 品</a>
                
            </div> 
			<!--end 按钮 --> 
            
			<!-- 页码 -->
			<div class="page-navigator">
            <%--    <div class="page-navigator-left">
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
							<a href="GoodsServlet?todo=searchGoods&pageNo=1" class="first">«</a>
							<a href="GoodsServlet?todo=searchGoods&pageNo=${page.pageNo-1}"
								class="prev">‹</a> &nbsp;第 ${page.pageNo} 页&nbsp; &nbsp;共<td>${page.pageCount}</td>页&nbsp;
							<a href="GoodsServlet?todo=searchGoods&pageNo=${page.pageNo+1}"
								class="next">›</a>
							<a href="GoodsServlet?todo=searchGoods&pageNo=${page.pageCount}"
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