<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:wb="http://open.weibo.com/wb">
<head>
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
    <meta name="description" content="天天果园官方网站提供水果生鲜、果篮券卡订制、干果零食等优质食品网购服务,2014年车厘子销量全网第一,佳沛奇异果、新奇士橙、进口牛油果等亦深受果友喜爱。" />
    <title>当然果园-水果网购首选品牌，水果，我们只挑有来头的！</title> <link rel="shortcut icon"  href="img/default_userpic.ico">
<link rel="shortcut icon" href="/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
    <jsp:include
		page="console_element/top1.jsp"></jsp:include>
        <div class="content">
        <nav class="navbar ">
            <div class="container-fluid">
                <div class="navbar-header">
                   <div  style="padding:0px;float:left"> <a href="index.jsp"><img src="img/login5.png.png" /></a> </div>
                </div>
                <div class="collapse navbar-collapse" >
                                    <ul class="icons-cart clearfix pull-right list-unstyled">
                        <li class="pull-left li1 cur">
                            <span>1</span>
                            <p>我的购物车</p>
                        </li>
                        <li class="pull-left li2 cur">
                            <span>2</span>
                            <p>确认订单信息</p>
                        </li>
                        <li class="pull-left li3">
                            <span>3</span>
                            <p>成功提交订单</p>
                        </li>
                    </ul>
                                    </div>
            </div>
        </nav>
    </div>
</section>
<div class="pay-succeed w-750">

    <div class="succeed clearfix">
        <div class="img pull-left">
          </div>
        <div class="payorders pull-left">
            <p class="order">您已成功提交订单！</p>
            <p class="min">请在30分钟内进行付款，超过时间后系统将自动取消订单！</p>
        </div>
    </div>
    <div class="succeed-details clearfix">
        <p class="ordernum">您的订单号:</p>
        <p class="figure">${oid}</p>
        <div class="cl"></div>
        <a href="OrdersServlet?todo=searchOrders2" clsss="view" target="_blank">查看订单详情 > </a>    </div>

    <div class="pay-box">
        <p class="key">请选择支付方式</p>
        <p class="value">
            <span></span>
            
            选择支付方式支付     <em>${allPrice}</em>
            元
        </p>
    </div>



<!-- BI -->
<input type="hidden" id="utrace_money" value="58.00" />
<input type="hidden" id="pay_type" value="1" />


 <jsp:include page="console_element/buttom.jsp"></jsp:include>

<!-- bi -->
<iframe src="/utrace" style="width: 0;height: 0;"></iframe>

</body>
<div class="show-loading"></div>
</html>