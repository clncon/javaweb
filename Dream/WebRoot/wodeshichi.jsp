<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
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
   
    <script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/jquery.lazyload.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/usercenter-basics.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-donation.css">
     <link rel="stylesheet" type="text/css" href="css/usercenter-order.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-order-evaluate.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-tryeat.css">
    <link rel="stylesheet" type="text/css" href="css/order-online.css">
    
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="http://www.fruitday.com/css/style-ie.css">
    <link rel="stylesheet" href="http://www.fruitday.com/css/style-ie1.css">
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

    <!-- GA -->
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
	<li><a href="user.jsp"  >我的账户</a></li>
	<li><a href="./wodedingdan.jsp"  >我的订单</a> 
		<a href="./wodeshichi.jsp" class="cur">我的试吃</a>
		<a href="./wodejifen.jsp" >我的积分</a>
		<a href="./zhanghuyue.jsp" >账户余额</a>
		<a href="./wodeyonghujuan.jsp" >我的优惠券</a>
		<a href="./wodezengping.jsp" >我的赠品</a>
		  	
	</li>
	<li>
		<a href="./zaixianchongzhi.jsp" >在线充值</a>
		<a href="./zhongzhifapiao.jsp" >充值发票</a>
		<a href="#" >申请开店</a>
		<a href="#" >管理我的店面 </a>
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
            <div class="tabmenu" id="uctabnav">
                <ul class="list-unstyled">
                    <li class="selected" ><a href="/user/tryeat" class="link"><span>所有试吃</span> <i class="interval">|</i></a></li>
                    <li  ><a href="/user/tryeat/1" class="link"><span>待评价</span><em></em></a></li>
                </ul>
                <div class="wrap-line">
                    <span class="line select0"></span>
                </div>

            </div>
            <div class="tryeat-detail">
              <table>
                <thead>
                  <tr class="order-nav">
                    <th class="shop-name">商品</th>
                    <th class="apply-time">申请时间</th>
                    <th class="apply-status">申请状态</th>
                    <th class="tryeat-order">试吃订单号</th>
                    <th class="shop-action">操作</th>
                  </tr>
                </thead>
                                
              </table>
            </div>
			 <!-- 翻页 -->
            <div class="btn-toolbar" role="toolbar">
                                
            </div>
        </div>
    </section>
   <!--底部 -->

<jsp:include page="console_element/buttom.jsp"/>
<!-- 53 kefu  -->
<!--<iframe src="/kefu" style="width: 35px;height: 35px;outline: none;border: none;position: fixed;bottom: 36px;right: 0;">-->
<!--</iframe>-->

<!-- baidu map -->
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
    //type状态 后台同志提供
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
<script src="http://www.fruitday.com/js/require.js" data-main="http://www.fruitday.com/js/main"></script>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
</html>
</body>
<script src="/js/require.js" data-main="/js/main" ></script>

</html>
 