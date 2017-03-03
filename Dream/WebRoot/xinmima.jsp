<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
    <link rel="stylesheet" type="text/css" href="css/verify.css">

 
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
   


<div class="w-1000 w-750 pt-50">
    <p class="member">找回密码</p>
    <div class="find_password clearfix">
        <ul class="step1 clearfix">
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

        <ul class="step2 clearfix hide">
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

        <ul class="step3 clearfix hide" >
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

    </div>
    <div class="regist_form fill_name">
        <ul class="refist_1">
            <li class="clearfix">
                <span class="pull-left">手机号</span>
                <input type="text" class="pull-left form-control" id="user"><span class="true"></span>
            </li>
            <li class="clearfix verify_code">
                <span class="pull-left">验证码</span>
                <div class="clearfix pull-left input-group">
                    <input type="text" class="pull-left form-control send" id="verify" disabled />
                    <span class="pull-left input-group-addon" id="TestGetCode"><em>发送验证码</em><em class="hide">还剩<b id="timeout">30</b>秒</em></span>
                </div>   <span class="true"></span>
            </li>
            <li class="register">
                <button type="button" class="btn btn-success" id="verifyBtn1">下一步</button>
            </li>
        </ul>
        <ul class="refist_2 hide">
        </ul>
        <ul class="refist_3 hide">
        </ul>
    </div>
</div>
<input type="hidden" id="scode" value="" >
<!--底部 -->
<jsp:include page="console_element/buttom.jsp"/>


<!-- bi -->
<iframe src="/utrace" style="width: 0;height: 0;"></iframe>

</body>
<div class="show-loading"></div>
</html>

