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
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <!--<script type="text/javascript" src="/js/lib/succeed.js"></script>
    <script type="text/javascript" src="/js/lib/succeed-channel.js"></script>-->
    
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
    <div class="sidebar s_ani help-sidebar" >
        <span class="arrow"  id="arr"></span>
        <ul class="list-unstyled help">
            <li><a href="javascript:;">帮助中心</a></li>
            <li>
                <a href="xinyonghuzhuce.jsp"  >新用户注册</a>
                <a href="zaixianxiadan.jsp"  >在线下单</a>
                <a href="zhifufangshi.jsp"  >支付方式</a>
            </li>
            <li>
                <a href="yunfeishuoming.jsp"  >运费说明</a>
                <a href="peisongfangshi.jsp"  >配送方式</a>
                <a href="fapiaoshuoming.jsp"  class="cur" >发票说明</a>
            </li>
            <li>
                <a href="tuihuanhuoyuanze.jsp"  >退换货规则</a>
                <a href="fuwubaozhangchengnuo.jsp"  >服务保障承诺</a>
                <a href="yanhuoyuqianshou.jsp"  >验货与签收</a>
            </li>
            <li>
                <a href="qiyedinggou.jsp"  >企业订购</a>
                <a href="zengpiaoxinxi.jsp"  >增票信息</a>
                <a href="dingzhizhuanqu.jsp"  >定制专区</a>
            </li>
        </ul>
    </div>
    <div class="main help-main">
        <div class="help-main-title"></div>
        <div class="help-main-content">
            <p>一、开发票的制度<br />
<br />
1、发票抬头：<br />
发票抬头不能为空，可填写个人姓名或单位名称。<br />
&nbsp;<br />
<br />
2、发票内容：<br />
发票内容为：水果。<br />
<br />
<br />
&nbsp;3、索取发票：<br />
请在提交订单页面下方，点击&quot;开具发票&quot;，按提示填写发票抬头，发票将会随您的订单商品一起送达。</p>
<p>如需发票配送其它地址，请勾选&ldquo;快递到其它地址&rdquo;并填写正确地址和另收人手机号码,发票另寄需要加收5元快递费用</p>
<p><br />
4、补开、换开发票说明：<br />
1）补开发票期限：订单提交之日起，一个月内。<br />
2）如果收到商品时没有发票，请在补开发票期限之内联系我们，并提供订单号、有效的邮寄地址、邮编及收件人姓名，我们会在补开发票后以平邮方式寄出。<br />
3）如果收到发票后，发票抬头、金额与提交订单时所填不符，请先与客服联络，再将发票寄至以下地址，并注明订单号、发票抬头。我们收到发票后会重新开具发票，并以平邮方式寄出。<br />
<br />
邮寄地址：上海浦东新区康桥路787号5号楼218室<br />
<br />
邮编：201315</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;<br />
<br />
注意事项：<br />
1）开票金额为订单实际支付金额，不包含券卡支付金额、积分抵扣以及优惠券抵扣金额。</p>
<p>2）当然果园提供的商品发票是&ldquo;上海增值税普通发票&rdquo;。<br />
&nbsp;<br />
<br />
二，不予开发票的情况：<br />
购买当然果园商品，使用果实卡、储值卡、提货券、通用券、账户余额支付时，当然果园不另开据发票。<br />
（原因：客户在购买以上卡券或充值卡时，当然果园已经开出全额发票，所以不再重复开票）</p>
<p>&nbsp;</p>
<p>充值发票可在&ldquo;我的账户&rdquo;&mdash;&ldquo;充值发票&rdquo;申请，充值超过3个月无法申请充值发票。</p>
        </div>
    </div>
</section>

<script type="text/javascript">
    $(function(){
        var title = $(".help li a.cur").jsp();
        $('.help-main-title').jsp(title);
    });
</script>

<!--底部 -->
<!--<section class="toolbarfoot">-->
    <!--<div class="toolbar-tab tab-card" style="bottom: 71px;">-->
        <!--<a href="/web/card_change" target="_blank">-->
            <!--<i class="tab-ico"></i>-->
            <!--<em class="tab-text">券卡</em>-->
        <!--</a>-->
    <!--</div>-->
    <!--<div class="toolbar-tab tab-top">-->
        <!--<a href="#" onclick="window.open('http://p.qiao.baidu.com/im/index?siteid=7860627&ucid=6965311','','width=800,height=600')">-->
            <!--<i class="tab-ico"></i>-->
            <!--<em class="tab-text">反馈</em>-->
        <!--</a>-->
    <!--</div>-->
    <!--<div class="toolbar-tab tab-feedback">-->
        <!--<a href="javascript:scrollTo(0,0);" >-->
            <!--<i class="tab-ico"></i>-->
            <!--<em class="tab-text">顶部</em>-->
        <!--</a>-->
    <!--</div>-->
<!--</section>-->

<jsp:include page="console_element/buttom.jsp"></jsp:include>

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

</html>