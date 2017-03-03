<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
    <link rel="stylesheet" type="text/css" href="css/channel.css">
    
   
    <!--<script type="text/javascript" src="/js/lib/succeed-channel.js"></script>-->
    
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

    <div class="content typepage typepage-pad">
        <!-- 筛选器 -->
        <div class="select clearfix">
            <div class="oc clearfix pull-left f-li ">
        <h5 class="pull-left">品类</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">全部</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/256-0-0-0-0-0-0" class="">
                    <span class="line">蓝莓</span>
                </a>
                            </div>
        </div>
    </div>
                <div class="oc clearfix pull-left f-li ">
        <h5 class="pull-left">产地</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">全部</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/0-0-52-0-0-0-0" class="">
                    <span class="line">智利</span>
                </a>
                            </div>
        </div>
    </div>
            <div class="oc clearfix pull-left f-li ">
        <h5 class="pull-left">场合</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">全部</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/0-0-0-3-0-0-0" class="">
                    <span class="line">走亲访友</span>
                </a>
                            </div>
        </div>
    </div>
            <div class="oc clearfix pull-left f-li ">
        <h5 class="pull-left">规格</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">全部</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/0-0-0-0-1-0-0" class="">
                    <span class="line">单品</span>
                </a>
                            </div>
        </div>
    </div>
            <div class="oc clearfix pull-left f-li ">
        <h5 class="pull-left">价格</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">全部</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/0-0-0-0-0-0T100-0" class="">
                    <span class="line">100以下</span>
                </a>
                                                <a href="/prolist/index/0/0-0-0-0-0-100T200-0" class="">
                    <span class="line">100~200</span>
                </a>
                                                <a href="/prolist/index/0/0-0-0-0-0-200T-0" class="">
                    <span class="line">200以上</span>
                </a>
                            </div>
        </div>
    </div>
            <div class="oc clearfix pull-left f-li f-pai">
        <h5 class="pull-left">排序</h5>
        <div class="f-select pull-left clearfix">
            <div class="pull-left leftpart">
                <a href="/prolist/index/0/0-0-0-0-0-0-0" class="active">
                    <span class="f-all line">默认</span>
                </a>
            </div>
            <div class="pull-left rightpart">
                                                                <a href="/prolist/index/0/0-0-0-0-0-0-2" class="">
                    <span class="line">价格从低到高</span>
                </a>
                                                <a href="/prolist/index/0/0-0-0-0-0-0-3" class="">
                    <span class="line">价格从高到低</span>
                </a>
                            </div>
        </div>
    </div>
    </div>

        <!-- 列表 -->
        <div class="f-list clearfix">
            <div class="leftpart pull-left">
                                <ul>
                                        <li>
                        <div class="wrap">
                            <div class="s-img">
                                <a href="/prodetail/index/6052" target="_blank">
                                    <img src="img/1-270x270-6052-RWSK3RHH.jpg"/>
                                </a>
                            </div>
                            <div class="s-info clearfix">
                                <span class="s-unit pull-right font-color">￥78.00</span>
                                                                                                智利蓝莓
                            </div>
                            <div class="p-operate clearfix">
                                <div class="s-kg clearfix pull-left">
                                    <span class="kg02 cur pull-left">
                                        （2+2）盒装
                                    </span>
                                </div><div class="s-kg1 clearfix pull-left">
                                                                        <span data-price="69.00" data-ppid="10212" data-pno="201411906" class="kg02 cur pull-right">
                                       兴鹏水果店
                                    </span>
                              </div>
                                <div class="s-che pull-right" pid="6052" ppid="8167" type="normal" pno="30757">

                                </div>
                            </div>
                        </div>
                    </li>
                                    </ul>
                            </div>
            <!-- 浏览过的商品 -->
            <div class="rightpart pull-right float-none-pad width-pad">
                <h5>最近浏览过</h5>
<ul>
    </ul>

            </div>
        </div>
    </div>

<script>

    $(function(){
                $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').click(
                        function(){
                            $(this).animate({backgroundPosition:"-514px -291px"},500);

                            var pid = $(this).attr('pid');
                            var ppid = $(this).attr('ppid');
                            var pno = $(this).attr('pno');
                            var type = $(this).attr('type');

                            //加入购物车
                            addCart(pid,ppid,pno,type);
                        }
                )

                $('.shop-cart .shop-top .cha').click(
                        function(){
                            $('.shop-cart').fadeOut(800);
                            $('.zhezhao').fadeOut(800);
                            $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').animate({backgroundPosition:"-517px -243px"},500);
                        }
                )
            }
    );

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

                    var url = "http://"+window.location.host;
                    $('.p-common-minicart').load(url+'/cart/resminicart' + " .p-common-minicart>*");

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