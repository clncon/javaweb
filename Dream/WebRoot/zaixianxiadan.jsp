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
                <a href="zaixianxiadan.jsp"  class="cur" >在线下单</a>
                <a href="zhifufangshi.jsp"  >支付方式</a>
            </li>
            <li>
                <a href="yunfeishuoming.jsp"  >运费说明</a>
                <a href="peisongfangshi.jsp"  >配送方式</a>
                <a href="fapiaoshuoming.jsp"  >发票说明</a>
            </li>
            <li>
                <a href="tuihuanhuoyuanze.jsp"  >退换货规则</a>
                <a href="fuwubaozhangchengnuo.jsp"  >服务保障承诺</a>
                <a href="yanhuoyuqianshou.jsp"  >验货与签收</a>
            </li>
            <li>
                <a href="qiyedinggou.jsp"  >企业订购</a>
                <a href="zengpiaoxinxi.jsp"   >增票信息</a>
                <a href="dingzhizhuanqu.jsp"  >定制专区</a>
            </li>
        </ul>
    </div>
    <div class="main help-main">
        <div class="help-main-title"></div>
        <div class="help-main-content">
            <p>&nbsp;官网下单</p>
<div>&nbsp;</div>
<div>1、在当然果园官网浏览选购您需要的产品，选择 需要的商品及规格， 点击&ldquo;加入购物车&rdquo;即加入到购物车，</div>
<div>或点击&ldquo;立即购买&rdquo;直接到提交订单页面。</div>
<div><img src="img/help_zaixian1.jpg" width="725" height="329" alt="" /></div>
<div>&nbsp;</div>
<div>2、查看购物车，确认商品后点击&ldquo;去结算&rdquo;。</div>
<div>&nbsp;</div>
<div><img src="img/help_zaixian2.jpg" width="713" height="542" alt="" /></div>
<div>&nbsp;</div>
<div>3、进入购物车，按照要求填写收货人信息、选择送货时间以及付款方式，按需求选择是否需要开具发票或呈送贺卡。</div>
<div>信息填写完整后即可提交订单，进入支付页面。</div>
<div>&nbsp;</div>
<div><span style="color: rgb(255, 0, 0);"><strong>注：一笔订单只能使用一张优惠券，积分只能抵扣该订单实付金额的50%</strong></span></div>
<div>&nbsp;</div>
<div><img src="img/help_new_zx3.png.jpg" width="715" height="741"></div>
<div>&nbsp;</div>
<div>4、订单提交成功后，点击前往银行付款。</div>
<div>&nbsp;</div>
<div><img src="img/help_new_zx2.png.jpg" width="715" height="357"></div>
<div>&nbsp;</div>
<div>
<div>电话下单：&nbsp;</div>
<div>&nbsp;</div>
<div>您可以直接拨打首页上方的订购热线 182-5977-2030进行电话订购，</div>
<div>&nbsp;</div>
<div>我们有客服专员耐心给您解答，按照您的要求为您挑选商品。</div>
</div>
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