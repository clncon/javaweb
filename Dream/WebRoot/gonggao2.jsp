<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
        <link rel="stylesheet" type="text/css" href="css/announcement.css">
    


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

<div class="fruit">
    <div class="title">
        <h6 class="pull-left"><a href="index.jsp">首页</a> &gt; <span>果园公告</span></h6>
        <a class="pull-right" href="gonggao3.jsp">更多&gt;</a>
    </div>
    <div class="list-detail">
        <h5>上海自建满赠商品变更</h5>

        <p>亲爱的果友们：</p>
        <div>
            <p>&nbsp;<span style="font-family: Arial; font-size: 14px;">上海自建</span><span style="font-family: Arial; font-size: 14px; color: rgb(51, 51, 51); line-height: 17px; text-indent: 30px;">地区单笔订单</span><span style="font-family: Arial; font-size: 14px;">满129元赠</span><span style="font-family: Arial; font-size: 14px;">云南冰糖橙1斤，价值18元，</span><span style="font-family: Arial; font-size: 14px;">，满259元赠菲律宾大凤梨1个，</span><span style="font-family: Arial; font-size: 14px; color: rgb(51, 51, 51); line-height: 17px; text-indent: 30px;">价值45元</span></p>
        </div>
        <p class="tr">2016-01-07</p>
        <p class="tr">当然果园</p>
    </div>
</div>



<jsp:include page="console_element/buttom.jsp"></jsp:include>

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

    switch(type){
        case 1:
 
            break;
        case 2:
          
            break;
        case 3:
          
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

</html>
