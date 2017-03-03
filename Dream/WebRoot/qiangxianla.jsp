<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="mengzhidui">
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
    <link rel="stylesheet" type="text/css" href="css/qiangxian.css">
    


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

    <script>
        function timer(el, intDiff) {
            window.setInterval(function() {
                var day = 0, hour = 0, minute = 0, second = 0;
                if (intDiff > 0) {
                    day = Math.floor(intDiff / (60 * 60 * 24));
                    hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                    minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                    second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                }
                if (minute <= 9)
                    minute = '0' + minute;
                if (second <= 9)
                    second = '0' + second;
                var countdown = '<span class="sp-com">' + day + '</span> 天 <span class="sp-com">' + hour + '</span> 时 <span class="sp-com">' + minute + '</span> 分 <span class="sp-com">' + second + '</span> 秒';
                el.jsp(countdown);
                intDiff--;
            }, 1000);
        }
    </script>
    <div class="qx-banner">
        <div style="background-image:url('img/74ea37ddf055abeb1888c3cb352ce523.jpg')"></div>
    </div>
    <div class="qx-content">
        <div class="qx-cor">
                        <div class="qx-img">
                <img src="img/qx-img01.png" alt="">
            </div>
                            <div class="qx-jingd clearfix">
                <div class="jingd-left">
                    <img src="img/1450243185_long_photo.jpg" width="825" height="490">
                    <!--<img src="img/jind-img.jpg" alt="">-->
                                    </div>
                <div class="jingd-right">
                    <div class="right-hd clearfix">
                        <div class="guoqi pull-left gq_50"></div>
                        <div class="hd-title">
                            <p>四川安岳柠檬</p>
                        </div>
                    </div>
                    <div class="right-bd">
                        <div class="bd-content">
                            <p>四川安岳柠檬，口感浓酸爽口，汁多肉鲜，富含维生素C和柠檬酸，生津止渴，开胃护肤，老少皆宜。
 </p>
                        </div>
                        <div class="bd-price clearfix">
                            <span class="pr0 pr pull-left">￥</span>
                            <span class="pr1 pull-left">9.00</span>
                            <div class="pull-left clearfix">
                                <span class="pr3 pull-left"><s>市场价: 19.00</s></span>
                                <span class="pr2 pr pr-bottom pull-left">/1斤装</span>
                            </div>
                        </div>
                        <div class="bd-btn">
                            <!-- 抢光的代码 -->
                                                        <a href="javascript:;" class="btn" style="display:block">
                                未开始！
                            </a>
                                                    </div>
                        <div class="bd-limit clearfix">
                            <div class="limit-left pull-left">
                                <span>每人限购 <em>1</em> 份</span>
                            </div>
                                                        <div class="limit-right pull-left">
                                <span>今天剩余 <em>30</em> 份</span>
                            </div>
                                                    </div>
                    </div>
                                        <div class="right-ft clearfix">
                        <p class="pull-left"><img src="img/clock.png" alt=""></p>
                        <p class="pull-left p2">距抢鲜开始</p>
                        <div class="limit pull-left" data-remain="2345">
                            <span class="sp-com">00</span>天<span class="sp-com">00</span>时<span class="sp-com">00</span>分<span class="sp-com">00</span>秒
                        </div>
                    </div>
                                    </div>
            </div>
                            
                        <div class="qx-img">
                <img src="img/qx-img03.png" alt="">
            </div>
            <!--抢先食品列表  -->
            <div class="qx-cont">
                <ul class="clearfix">
                                                            <li class="pull-left">
                        <a href="RepertoryServlet?todo=searchBygid&gid=32" target="_blank">
                            <div class="wrap">
                                <img src="img/1-270x270-6682-T2TRD8DT.jpg" width="370" height="370">
                                <div class="float-box">
                                                                                                        </div>
                            </div>
                        </a>
                        <div class="qx-info  clearfix">
                            <div class="info-box pull-left">
                                <div class="info-name">
                                    <p>美国佛罗里达葡萄柚</p>
                                </div>
                                <div class="info-price">
                                    <span class="pr01">￥49.00</span>
                                    <span class="pr02">/1个装</span>
                                                                        <s>参考价:59.00 </s>
                                                                    </div>
                            </div>
                            <div class="cart pull-right" data-pid="7946" data-ppid="10120" data-pno="2151229101">

                            </div>
                        </div>
                        <div class="qx-limittime clearfix">
                            <div class="limittime-left pull-left">
                                <span><em class="numb">8045</em>人已购买</span></div>
                            <div class="limittime-right pull-right clearfix">
                                <span class="click pull-left"></span>
                                <div class="limit pull-left" data-remain="3285545">
                                    <span class="sp-com">00</span>天<span class="sp-com">00</span>时<span class="sp-com">00</span>分<span class="sp-com">00</span>秒
                                </div>
                            </div>
                        </div>
                    </li>
                                                            <li class="pull-left">
                        <a href="RepertoryServlet?todo=searchBygid&gid=29" target="_blank">
                            <div class="wrap">
                                <img src="img/1-270x270-7911-1P7DTC48.jpg" width="410" height="410">
                                <div class="float-box">
                            </div>
                        </a>
                        <div class="qx-info  clearfix">
                            <div class="info-box pull-left">
                                <div class="info-name">
                                    <p>希腊金奇异果</p>
                                </div>
                                <div class="info-price">
                                    <span class="pr01">￥99.00</span>
                                    <span class="pr02">/12只装</span>
                                                                        <s>参考价:109.00 </s>
                                                                    </div>
                            </div>
                            <div class="cart pull-right" data-pid="5209" data-ppid="9139" data-pno="2150812101">

                            </div>
                        </div>
                        <div class="qx-limittime clearfix">
                            <div class="limittime-left pull-left">
                                <span><em class="numb">14732</em>人已购买</span></div>
                            <div class="limittime-right pull-right clearfix">
                                <span class="click pull-left"></span>
                                <div class="limit pull-left" data-remain="139145">
                                    <span class="sp-com">00</span>天<span class="sp-com">00</span>时<span class="sp-com">00</span>分<span class="sp-com">00</span>秒
                                </div>
                            </div>
                        </div>
                    </li>
                                                            <li class="pull-left">
                        <a href="RepertoryServlet?todo=searchBygid&gid=58" target="_blank">
                            <div class="wrap">
                                <img src="img/shijia1.jpg" width="370" height="370">
                                <div class="float-box">
                                                                                                        </div>
                            </div>
                        </a>
                        <div class="qx-info  clearfix">
                            <div class="info-box pull-left">
                                <div class="info-name">
                                    <p>台湾释迦</p>
                                </div>
                                <div class="info-price">
                                    <span class="pr01">￥59.00</span>
                                    <span class="pr02">/500g</span>
                                                                        <s>参考价:69.00 </s>
                                                                    </div>
                            </div>
                            <div class="cart pull-right" data-pid="7804" data-ppid="9977" data-pno="2151222118">

                            </div>
                        </div>
                        <div class="qx-limittime clearfix">
                            <div class="limittime-left pull-left">
                                <span><em class="numb">1328</em>人已购买</span></div>
                            <div class="limittime-right pull-right clearfix">
                                <span class="click pull-left"></span>
                                <div class="limit pull-left" data-remain="175145">
                                    <span class="sp-com">00</span>天<span class="sp-com">00</span>时<span class="sp-com">00</span>分<span class="sp-com">00</span>秒
                                </div>
                            </div>
                        </div>
                    </li>
                                                        </ul>
            </div>
                    </div>
    </div>
    <script>
        $(function() {
            $("div.limit.pull-left").each(function() {
                timer($(this), $(this).data('remain'));
            });

            $(".cart").on('click', function() {
                var pid = $(this).data('pid'),
                    ppid = $(this).data('ppid'),
                    pno = $(this).data('pno');
                addCart(pid, ppid, pno, 'normal');
            });

            $('.shop-cart .shop-top .cha').click(
                function(){
                    $('.shop-cart').fadeOut(800);
                    $('.zhezhao').fadeOut(800);
                    $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').animate({backgroundPosition: "-517px -243px"}, 500);
                }
            );
        });

        /*
         * 加入购物车 - 继续购物
         */
        function closeCart() {
            $('.shop-cart').fadeOut(800);
            $('.zhezhao').fadeOut(800);
            $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').animate({backgroundPosition: "-517px -243px"}, 500);
        }

        /*
         * 加入购物车
         */
        function addCart(pid,ppid,pno,type)
        {
            var items = {
                0: {
                    'pid':pid,
                    'ppid':ppid,
                    'pno':pno,
                    'type':type,
                    'qty':1
                }
            };

            //添加商品到购物车
            $.ajax({
                type: 'POST',
                url: '/ajax/cart/add',
                dataType: 'json',
                async:false,
                data: {
                    items:items
                },
                success: function(rs) {
                    if (rs.code == 200) {
                        $('.zhezhao').fadeIn(800);
                        $('.shop-cart').fadeIn(800);

                        var ds = rs.data;
                        var cartcount = ds.cartcount;
                        var cartprice = '￥'+ds.cart.total_amount;

                        $(".cartcount").jsp(cartcount);
                        $(".cartprice").jsp(cartprice);

                        var cart_good = ds.cart;
                        var is_gift = 1;

                        for(var g_key in cart_good)
                        {
                            if(g_key == 'pmt_alert')
                            {
                                is_gift =0;
                            }
                        }

                        if(is_gift == 0)
                        {
                            var cart_m_good = ds.cart.pmt_alert[0].solution;
                            var pmt_id = cart_m_good.pmt_id;

                            $(".cart_m_text").jsp(cart_m_good.title);
                            if(cart_m_good.product_photo != '')
                            {
                                $("#cart_m_img").attr("src",cart_m_good.product_photo);
                            }
                        }
                        else
                        {
                            var cart_g_good = ds.cart.items;

                            for(var m_key in cart_g_good){
                                var str = m_key;
                                if(str.indexOf("gift") > 0)
                                {
                                    $(".cart_m_text").jsp(cart_g_good[m_key].name);
                                    $("#cart_m_img").attr("src",cart_g_good[m_key].photo.thum);
                                }
                            }
                        }

                        var url = "http://"+window.location.host;
                        $('.p-common-minicart').load(url+'/cart/resminicart' + " .p-common-minicart>*");
                    }
                    else if(rs.code == 300){
                        gdialog_info(rs.msg);
                        $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').animate({backgroundPosition: "-517px -243px"}, 500);
                    }
                }
            });

        }
    </script>


<!--购物车弹出层-->
<div class="zhezhao"></div>
<!-- 购物车 -->
<div class="shop-cart">
    <div class="shop-top">
        <div class="cha pull-right">
            <img src="img/cha.png" alt=""></div>
    </div>
    <div class="shop-content">
        <div class="title clearfix">
            <div class="suc pull-left"></div>
            <div class="adds pull-left">
                <p>加入购物车成功！</p>

            </div>
        </div>
        <p class="row2">
            购物车中共
            <em class="cartcount">0</em>
            件商品 | 商品小计
            <em class="cartprice">￥0</em>
        </p>
        <div class="choosed clearfix">
            <ul>
                <li>
                    <div class="buy clearfix">
                        <div class="fr-buy pull-left">
                            <a href="javascript:void(0);" onclick="closeCart();" class="btn btn-primary btn-lg active" role="button" title="点击此按钮，到下一步确认购买信息">继续购物</a>
                        </div>
                        <div class="fr-add pull-left">
                            <a href="/cart" class="btn btn-primary btn-lg active" title="加入购物车" role="button">
                                去结算
                            </a></div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
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

</html>