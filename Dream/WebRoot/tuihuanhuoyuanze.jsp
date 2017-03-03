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
                <a href="fapiaoshuoming.jsp"  >发票说明</a>
            </li>
            <li>
                <a href="tuihuanhuoyuanze.jsp"  class="cur">退换货规则</a>
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
            <p>&nbsp;以下情况在发现48小时内可以进行退换货</p>
<div>&nbsp;</div>
<div>1、由客户个人原因造成的退换货情况</div>
<div>&nbsp;</div>
<div>①个人口味偏好</div>
<div>&nbsp;</div>
<div>②产品色泽感观差异</div>
<div>&nbsp;</div>
<div>③无任何理由退回（产品与包装完好无损的情况下）</div>
<div>&nbsp;</div>
<div>④因客户个人原因造成的退换货，将不退还该订单的运费，退换货时产生的运费，由客户承担</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>2、由当然果园造成的退换货情况</div>
<div>&nbsp;</div>
<div>①发现收到的产品并非订购的产品时，请提供订单编号，以便跟进服务</div>
<div>&nbsp;</div>
<div>②产品本身质量问题，请提供订单编号，以便提供售后服务</div>
<div>&nbsp;</div>
<div>③配送无故延期</div>
<div>&nbsp;</div>
<div>④因当然果园造成的退换货，果园会承担退换货产生的运费</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>3、以下情况拒绝进行任何退换货</div>
<div>&nbsp;</div>
<div>①产品存在质量问题时，客户丢弃或食用产品之后在进行投诉咨询的</div>
<div>&nbsp;</div>
<div>②产品经配送人员检查后并非当然果园出售的产品</div>
<div>&nbsp;</div>
<div>③产品超过规定的48小时内售后服务时间</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>4、退换货提示</div>
<div>&nbsp;</div>
<div>①订单中如有赠品，退货时，如不满赠送条件，需将赠品一同退回，如赠品已经拆封或食用，则订单商品只换不退，</div>
<div>如有不便，敬请谅解。</div>
<div>&nbsp;</div>
<div>②退货时，需退回相对应的订单客户联及发票，确保配送人员能够核实并快速处理。</div>
<div>&nbsp;</div>
<div>③退款将会按原付款方式退回。</div>
<div>&nbsp;</div>
<div>④网站图片及信息仅供参考，商品以实物为准，拍摄灯光和显示器色差可能会造成产品实物和图片有少许出入的情况，</div>
<div>不属于质量问题。</div>
<div>&nbsp;</div>
<div>订单交易成功后的客户联和发票请保存好，以便在规定时间发现质量问题后，可以正常进行售后服务。</div>
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
</html>