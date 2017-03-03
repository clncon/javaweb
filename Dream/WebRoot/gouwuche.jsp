<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="Rose">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">
<meta name="viewport"
	content="width=device-width,user-scalable=0,initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-title" content="fruitday">
<meta content="telephone=no" name="format-detection" />
<meta content="email=no" name="format-detection" />
<meta name="keywords" content="奇异果,苹果,橙,火龙果,葡萄,瓜,石榴,李子" />
<meta name="description"
	content="天天果园官方网站提供水果生鲜、果篮券卡订制、干果零食等优质食品网购服务,2014年车厘子销量全网第一,佳沛奇异果、新奇士橙、进口牛油果等亦深受果友喜爱。" />
<title>当然果园-水果网购首选品牌，水果，我们只挑有来头的！</title> <link rel="shortcut icon"  href="img/default_userpic.ico">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/cart.css">

<script type="text/javascript">
     function jia(gId){
     var num=parseInt(document.getElementById("num"+gId).value);
   
       var ss= num+1;
       if(ss>100){
       ss=100;
       }
    
 
      var gprice= parseInt(document.getElementById("gprice"+gId).value);
     
    document.getElementById("num"+gId).value=ss;
         
  
       document.getElementById("zongjia").value= parseInt(document.getElementById("zongjia").value)+gprice;
     
       // var fff=num1*gprice;
        //alert(fff);
    //  var msg=document.getElementById("zongjia1");

      //msg.innerHTML =fff;
    
    
     }
   
     function jian(gId){
       var num=parseInt(document.getElementById("num"+gId).value);
       if(num>1){
       var ss= num-1;
        if(ss>=1){
         var gprice= parseInt(document.getElementById("gprice"+gId).value);
        document.getElementById("num"+gId).value=ss;
        document.getElementById("zongjia").value= parseInt(document.getElementById("zongjia").value)-gprice;
        }
       
    
       
       
       
       
       
     
   
     }
    }
    
    </script>

</head>
<body>
	<!-- top -->
	<div class="top-con"></div>

	<!-- 头部开始 -->
	<section class="p-common-header"> <jsp:include
		page="console_element/top1.jsp"></jsp:include>
	<div class="content">
		<nav class="navbar ">
		<div class="container-fluid">
			<div class="navbar-header">
				<div style="padding:0px;float:left">
					<a href="index.jsp"><img src="img/login5.png.png" /> </a>
				</div>

			</div>

			<div class="collapse navbar-collapse">
				<ul class="icons-cart clearfix pull-right">
					<li class="pull-left li1 cur"><span>1</span>
						<p>我的购物车</p></li>
					<li class="pull-left li2"><span>2</span>
						<p>确认订单信息</p></li>
					<li class="pull-left li3"><span>3</span>
						<p>成功提交订单</p></li>
				</ul>

			</div>
		</div>
		</nav>
	</div>
	</section>
	<!--中部开始-->

	<div class="cart w-750">
		<form action="jiesuan.jsp" method="post">

			<div class="cart-filter-bar pt-50">
				<div class="mycart">
					<p class="pull-left">我的购物车</p>
					<a href="RepertoryServlet?todo=searchfruit" class="pull-right">继续逛逛></a>
				</div>
			</div>
			<div class="cartmain cartspage">
				<div class="cart-head clearfix">
					<div class="cart-select pull-left">
						<!--<p class="select selected"></p><input type="hidden" value="" />
                <span>全选</span>-->
					</div>
					<input type="hidden">
					<div class="cart-good pull-left">
						<span>商品</span>
					</div>
					<div class="cart-spec pull-left">
						<span>规格</span>
					</div>
					<div class="cart-price pull-left">
						<span>单价(元)</span>
					</div>
					<div class="cart-number pull-left">
						<span>数量</span>
					</div>
					<div class="cart-sum pull-left">
						<span>原价(元)</span>
					</div>
					<div class="cart-action pull-left">
						<span>操作</span>
					</div>
				</div>
				<div class="cart-order clearfix ">
					<ul class="list-unstyled">
						<c:set var="allPrice" value="0" scope="session" />
						<c:forEach items="${gwc}" var="map">
							<c:forEach items="${map.value}" var="gouwuche">
								<li id='c_normal_10217' type="normal" pid="8042" ppid="10217">
									<div class="cartbox clearfix">
										<div class="cartorder-select pull-left clearfix">
											<!--<p class="select selected"></p><input type="hidden" value="" />-->
										</div>
										<div class="cart-imgs pull-left">
											<c:forTokens items="${gouwuche.gPic}" delims="@" var="gouwu"
												varStatus="i">

												<c:if test="${i.index==0}">
													<a
														href="RepertoryServlet?todo=searchBygid&gid=${gouwuche.gId}"
														target="_blank"> <img src="${gouwu}" alt=""> </a>
												</c:if>


											</c:forTokens>
										</div>

										<div class="cart-name pull-left">
											<p>${gouwuche.gName}</p>
										</div>
										<div class="spec-num pull-left">
											<p>3个装</p>
										</div>
										<div class="price-singular pull-left">
											<p>${gouwuche.gPrice}</p>
										</div>
										<input type="hidden" id="gId" name="gId"
											value="${gouwuche.gId}"> <input type="hidden"
											id="pnum" value="${gouwuche.pNum}"  name="pnum">
											<c:set var="number" value="${gouwuche.pNum}"></c:set>
										<div class="num_sel_lage cart-goods pull-left clearfix">
											<button type="button" id="button"
												class="inC num pull-left btn-minus"
												onclick="jian(${gouwuche.gId} )">-</button>
											<input class="pull-left" type="tel" disabled=""
												id="num${gouwuche.gId }" name="num" autocomplete='on'
												value="${gouwuche.pNum}">
											<button type="button" id="button"
												class="deC num pull-left btn-plus"
												onclick=" jia(${gouwuche.gId} )">+</button>
										</div>
										<input type="hidden" id="gprice${gouwuche.gId}" name="gprice"
											value="${gouwuche.gPrice}">
										<div class="sum pull-left">
											<p>${gouwuche.gPrice}</p>
										</div>
										<c:set var="prive" value="${gouwuche.gPrice*gouwuche.pNum}" />
										<div class="delete pull-left">
											<c:set var="allPrice" value="${allPrice+prive}"
												scope="session"></c:set>
											<p></p>
											<p href="GouwuServlet?todo=deleteGouwu&gId=${gouwuche.gId}"
												class="m-cartlist-delete deleteCartpro">删除</p>
										</div>
									</div>
									<div class="cl"></div></li>
							</c:forEach>
						</c:forEach>
					</ul>
					<div class="m-carttips">
						<ul class="list-unstyled">
							<div class="cartbox2 clearfix">
								<div class="send-free pull-left">
									<p>促</p>
								</div>
								<p class="pull-left title">
									<!--<a  target="_blank" href='/cart/selpmt/amount/394' >满129元送新疆库尔勒香梨,还差24元，去凑单></a>-->
									满129元送新疆库尔勒香梨,还差24元，<a target="_blank"
										href="RepertoryServlet?todo=searchfruit">去凑单</a>
								</p>
							</div>
						</ul>
					</div>


					<div class="cl"></div>



					<input id="cart_page" type="hidden" value='2' />
				</div>
				<!-- 尾部 -->
				<div class="cartfooter clearfix">

					<div class="cart-pay pull-right">
						<span> 已选择 <em>${number}</em> 商品 | 订单金额￥ </span> <span class="all-order"
							id="zongjia1"> <input type="text" disabled="disabled"
							height="10px" id="zongjia" name="zongjia" value="${allPrice}">
						</span> <input type="submit" id="js" class="go-pay" value="去结算">
					</div>
					<div class="cl"></div>
				</div>
			</div>
		</form>
		<!-- 轮播开始-->
		<div class="cl"></div>
		<div class="look-history">
			<div class="scrollbar clearfix">
				<ul class="clearfix look-history-menu">

					<li class="pull-left"><p class="p-noborder">你可能感兴趣的商品</p>
					</li>
				</ul>
			</div>
			<div class="look-history-con">
				<ul class="slidee clearfix ul1">
					<li>
					<li class="pull-left " pid="1979" ppid="2719" type="normal"
						pno="201411938">
						<div class="s-img">
							<a href="RepertoryServlet?todo=searchBygid&gid=17"
								target="_blank"> <img class="lazy" height="127px"
								src="img/1-270x270-3493-RRKRR26C.jpg" alt=""
								src="img/default.png"> </a>
						</div>
						<div class="s-info clearfix">
							<div class="s-name pull-left">
								<span>新奇士美国柠檬</span>
							</div>
							<div class="s-unit pull-left">
								<span>￥58/2斤装</span>
							</div>
							<div class="s-che pull-right"></div>
						</div>
					</li>
					<li class="pull-left first" pid="3682" ppid="5567" type="normal"
						pno="201512268">
						<div class="s-img">
							<a href="RepertoryServlet?todo=searchBygid&gid=13"
								target="_blank"> <img class="lazy" height="127px"
								src="img/1-370x370-3682-A9D9CDY9.jpg" alt=""
								src="img/default.png"> </a>
						</div>
						<div class="s-info clearfix">
							<div class="s-name pull-left">
								<span>秘鲁红提</span>
							</div>
							<div class="s-unit pull-left">
								<span>￥39.00/2斤装</span>
							</div>
							<div class="s-che pull-right"></div>
						</div>
					</li>
					<li class="pull-left " pid="6434" ppid="8567" type="normal"
						pno="2150514132">
						<div class="s-img">
							<a href="RepertoryServlet?todo=searchBygid&gid=20"
								target="_blank"> <img class="lazy" height="127px"
								src="img/1-370x370-6434-THKC4UFT.jpg" alt=""
								src="img/default.png"> </a>
						</div>
						<div class="s-info clearfix">
							<div class="s-name pull-left">
								<span>泰国龙眼</span>
							</div>
							<div class="s-unit pull-left">
								<span>￥49.00/2斤装</span>
							</div>
							<div class="s-che pull-right"></div>
						</div>
					</li>
					<li class="pull-left " pid="6952" ppid="9104" type="normal"
						pno="2151122101">
						<div class="s-img">
							<a href="RepertoryServlet?todo=searchBygid&gid=50"
								target="_blank"> <img class="lazy" height="127px"
								src="img/yangtao1.jpg" alt="" src="img/default.png"> </a>
						</div>
						<div class="s-info clearfix">
							<div class="s-name pull-left">
								<span>台湾杨桃</span>
							</div>
							<div class="s-unit pull-left">
								<span>￥25/2斤</span>
							</div>
							<div class="s-che pull-right"></div>
						</div>
					</li>

				</ul>
				<div class="wrap">
					<div class="frame cartSlidee_0"></div>
					<div class="prev">
						<div></div>
					</div>
					<div class="next">
						<div></div>
					</div>
				</div>
			</div>

			<div class="cl"></div>
		</div>
	</div>
	<div id="p-dialog"></div>


	<jsp:include page="console_element/buttom.jsp"></jsp:include>

</body>
<div class="show-loading"></div>
<script src="js/require.js"></script>
<script src="js/wb.js"></script>
</html>

<!--<script src="js/lib/jquery-1.11.0.min.js"></script>-->

</html>

