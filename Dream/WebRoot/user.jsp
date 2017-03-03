<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <meta name="viewport" content="width=device-width,user-scalable=0,initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-title" content="fruitday">
    <meta content="telephone=no" name="format-detection" />
    <meta content="email=no" name="format-detection" />
    <meta name="keywords" content="奇异果,苹果,橙,火龙果,葡萄,瓜,石榴,李子" />
    <meta name="description" content="当然果园官方网站提供水果生鲜、果篮券卡订制、干果零食等优质食品网购服务,2014年车厘子销量全网第一,佳沛奇异果、新奇士橙、进口牛油果等亦深受果友喜爱。" />
    <title>当然果园-水果网购首选品牌，水果，我们只挑有来头的！</title> <link rel="shortcut icon"  href="img/default_userpic.ico">
<link rel="shortcut icon" href="img/favicon.ico" >

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
 <script src="js/jquery-1.11.0.min.js">
 </script><script src="js/jquery.lazyload.min.js"></script>
 <link rel="stylesheet" type="text/css" href="css/usercenter-basics.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-donation.css">
 <link rel="stylesheet" type="text/css" href="css/usercenter-order.css">
<link rel="stylesheet" type="text/css" href="css/usercenter-order-evaluate.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-tryeat.css">
    <link rel="stylesheet" type="text/css" href="css/order-online.css">
   
  
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-52936203-1', 'auto');
        ga('send', 'pageview');

    </script>
</head>
<body>
<!-- top -->
<div class="top-con">
    
    </div>

<!-- 头部开始 -->
<section class="p-common-header">
<jsp:include page="console_element/top1.jsp"></jsp:include>
<jsp:include page="console_element/top2.jsp"></jsp:include>
</section>
    <section class="p-component-usercenter clearfix">
        <div class="sidebar s_ani" >
            <span class="arrow"  id="arr"></span>
            <ul class="list-unstyled">
	<li><a href="user.jsp" class="cur" >我的账户</a></li>
	<li>
		<a href="OrdersServlet?todo=searchOrders2" >我的订单</a><a href="wodejifen.jsp" >我的积分</a>
		<a href="zhanghuyue.jsp" >账户余额</a>
		<a href="wodeyonghujuan.jsp" >我的优惠券</a>
		<a href="wodezengping.jsp" >我的赠品</a>
		  
	</li>
	<li>
		<a href="zaixianchongzhi.jsp" >在线充值</a>
		<a href="zhongzhifapiao.jsp" >充值发票</a>
		 
                                   <a href="StoreServlet?todo=MyStore" >管理我的店面 </a>
                                     
                                    <a href="admin/kaidian.jsp" >申请开店</a>
                                   
		
		
	</li>
	<li>
		<a href="UserServlet?todo=searchjibenziliao" >基本资料</a>
		<a href="mimaxiugai.jsp" >密码修改</a>
		<a href="shouhuodizhi.jsp" >收货地址</a>
		<a href="tongzhishezhi.jsp" >通知设置</a>
	</li>
</ul>
        </div>
        <div class="main">
          <!-- 个人信息 -->
            <div class="member-tabmenu">
              <ul>
                <li class="member-info">
                  <div class="face-img">
                    <img src="img/default_userpic.png" alt="">
                    <div class="member-levels v0" data-level="v0"></div>
                    <a href="huiyuan.jsp">查看等级特权</a>
                  </div>
                  <div class="member-content">
                    <!-- <p class="member-name">${user.uPhone}</p>  -->
                     <p class="member-name">
                     	<%
                     	//取得客户端的所有Cookie
						Cookie[] Cookies = request.getCookies();
    
						Cookie sCookie = null;
						String cookieName = null;
						String cookieValue = null;
						int cookieVersion=0;
						if (Cookies == null) // 如果没有任何Cookie
							out.print("没有Cookie");
						else {
							try {
								if (Cookies.length == 0) {
									System.out.println("客户端禁止写入cookie");
								} else {
									for (int i = 0; i <= Cookies.length; i++) { // 循环列出所有可用的Cookie
										sCookie = Cookies[i];
										cookieName = sCookie.getName();
										if(cookieName.equals("register_phone")){
											cookieValue = sCookie.getValue();			
											out.print("<b>"+cookieValue+"</b><br/>");
										}
										
									}
								}
							}
							catch (Exception e) {
								System.out.println(e);
						    }
						}
                     	%>
					 </p>
                    <p>距离鲜果达人V1还需</p>
                    <p>消费200元</p>
                    <p>购买0次</p>
                  </div>
                </li>
                <li class="member-content">
                  <p class="character">余额：</p>
                  <p class="digit">¥0.00</p>
                  
                </li >
                <li class="member-content">
                  <p class="character">积分：</p>
                  <p class="digit">0</p>
                  
                </li>
                <li class="member-content noborderRight">
                  <p class="character">优惠券：</p>
                  <p class="digit">4张</p>
                  <a href="wodeyonghujuan.jsp">查看优惠券&nbsp;&gt;</a>
                </li>
              </ul>
            </div>
            <!-- 个人信息 end-->

            <!-- 最近订单 -->
            <div class="order-detail">
             
            </div>
            <!-- 最近订单 end-->


            <!--最近浏览的商品  -->
            <div class="look-history">
              <div class="scrollbar clearfix">
                  <ul class="clearfix look-history-menu">
				                            
					                        <li class="pull-left"><p class="p-noborder">你可能感兴趣的商品</p></li>
                  </ul>
              </div>
              <div class="look-history-con">
			                        <div class="wrap">
                      <div class="frame cartSlidee_0">
                          <ul class="slidee clearfix ul1">
							                                                                                                                							<li>
								 <li class="pull-left " pid="1979" ppid="2719" type="normal" pno="201411938">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=17" target="_blank"> <img class="lazy" height="127px"  src="img/1-270x270-3493-RRKRR26C.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>新奇士美国柠檬</span> </div>
            <div class="s-unit pull-left"> <span>￥58/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>

        </li>
							   <li class="pull-left first" pid="3682" ppid="5567" type="normal" pno="201512268">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=13" target="_blank"> <img class="lazy"  height="127px" src="img/1-370x370-3682-A9D9CDY9.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>秘鲁红提</span> </div>
            <div class="s-unit pull-left"> <span>￥39.00/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
         <li class="pull-left " pid="6434" ppid="8567" type="normal" pno="2150514132">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=20" target="_blank"> <img class="lazy"  height="127px" src="img/1-370x370-6434-THKC4UFT.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>泰国龙眼</span> </div>
            <div class="s-unit pull-left"> <span>￥49.00/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="6952" ppid="9104" type="normal" pno="2151122101">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=50" target="_blank"> <img class="lazy" height="127px" src="img/yangtao1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>台湾杨桃</span> </div>
            <div class="s-unit pull-left"> <span>￥25/2斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
						
							                            </ul>
                       </div>
                      <div class="prev"><div></div></div>
                      <div class="next"><div></div></div>
                  </div>
				                    <div class="wrap"  style="display:none;"  >
                    
                      <div class="prev"><div></div></div>
                      <div class="next"><div></div></div>
                  </div>
              </div>
              <div class="cl"></div>
            </div>
        </div>
    </section>
    
<!--底部 -->
<jsp:include page="console_element/buttom.jsp"/>


<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?1c8a96ff82d41e32620cf4036a594559";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

<script>
    var have_bigImg = $('.bigImg').length;
    var have_smallImg = $('.smallImg').length;
    var type = "";
    if((have_bigImg == 1) && (have_smallImg == 0) ){
        type = 1;
    }
    if((have_bigImg == 0) && (have_smallImg == 1) ){
        type = 2;
    }
    if((have_bigImg > 0) && (have_smallImg > 0) ){
        type = 3;
    }
    //type状态 后台同时提供
    switch(type){
        case 1:
            // 1，只有一张大图 就显示一张大图
            break;
        case 2:
            // 2，只有一张小图 就是显示一张小图
            break;
        case 3:
            // 3，大小图同时出现，3秒钟之后 大图渐渐消失，小图出来并一直在顶部显示了
        {
            setTimeout(function(){
                $('#bI').fadeOut('800',function(){

                    $('#sI').fadeIn(300);
                })

            },3000);
        }
            break;
    }
</script>
</body>
<div class="show-loading"></div>

    <div id="p-dialog">

    </div>
<body>wo</body>

</html>


    