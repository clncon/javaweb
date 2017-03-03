<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>梦之队 • 当然果园门店管理 | menu</title>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	<script type="text/javascript" src="admin/js/ddaccordion.js"></script>
	<script type="text/javascript">
	ddaccordion.init({
		headerclass: "submenuheader", //Shared CSS class name of headers group
		contentclass: "submenu", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
		mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["suffix", "<img src='admin/images/plus.gif' class='statusicon' />", "<img src='admin/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
	</script>
  </head>
  
<body>
    <div class="sidebarmenu">
    			<a class="menuitem submenuheader" href="">我的商城</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="admin/yulanshangcheng.html" target="mainFrame">预览商城</a></li>
		                <li><a href="StoreServlet?todo=searchStore" target="mainFrame">店面信息</a></li>
		                
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="" >会员管理</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="VipServlet?todo=searchVip&pageNo=1" target="mainFrame">会员信息管理</a>
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="">商品销售</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="GoodsServlet?todo=searchGoods&pageNo=1" target="mainFrame">商品管理</a></li>
		                <li><a href="CommentServlet?todo=searchComment&pageNo=1"  target="mainFrame">评论管理</a></li>
		                <li><a href="SaleServlet?todo=searchSale" target="mainFrame">销售查询</a></li>         
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="goodCounter.html">商品活动</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="ActivityServlet?todo=searchActivity&pageNo=1" target="mainFrame">双11</a></li>
		                <li><a href="ActivityServlet?todo=searchActivity12&pageNo=1" target="mainFrame">双12</a></li>
		                <li><a href="ActivityServlet?todo=searchAnniversary&pageNo=1" target="mainFrame">周年庆</a></li>
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="">订单管理</a>
		        <div class="submenu">
		            <ul>
		                
		                <li><a href="OrdersServlet?todo=searchOrders&pageNo=1" target="mainFrame">订单信息管理</a></li>
		            </ul>
		        </div> 
    </div>		
</body>
</html>
