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
    <link rel="stylesheet" type="text/css" href="css/detail.css">
    
 
 
    

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

    <!-- 水果信息开始 -->
    <div class="content typepage clearfix">
        <div class="bread">
            <strong class="lvse"><a href="index.jsp">首页</a></strong>
            <span class="lvse">
                                &gt;
                <a href="fruit.jsp">全部鲜果</a>
                                &gt;
            </span>
            <span class="huise">法国姬娜苹果</span>
        </div>
        <!-- 焦点图开始 -->
        <div id="MyFocus" class="pull-left">
            <ul class="dianul">
                                <li class=" cur">
                    <img src="img/images/product_pic/7946/1/1-180x180-7946-7UPAKSYU.jpg"/>
                    <span>
                        <img src="img/panel.png"/>
                    </span>
                </li>
                                <li class=" ">
                    <img src="img/images/product_pic/7348/3/3-180x180-7348-T1YPRSAW.jpg"/>
                    <span>
                        <img src="img/panel.png"/>
                    </span>
                </li>
                                <li class="last ">
                    <img src="img/images/product_pic/7348/2/2-180x180-7348-T1YPRSAW.jpg"/>
                    <span>
                        <img src="img/panel.png"/>
                    </span>
                </li>
                            </ul>
            <ul class="tuul">
                                <li class="cur">
                    <a href="javascript:;">
                        <img src="img/images/product_pic/7946/1/1-370x370-7946-7UPAKSYU.jpg"/>
                    </a>
                </li>
                                <li class="cur">
                    <a href="javascript:;">
                        <img src="img/images/product_pic/7348/3/3-370x370-7348-T1YPRSAW.jpg"/>
                    </a>
                </li>
                                <li class="cur">
                    <a href="javascript:;">
                        <img src="img/images/product_pic/7348/2/2-370x370-7348-T1YPRSAW.jpg"/>
                    </a>
                </li>
                            </ul>
        </div>
        <script type="text/javascript">
            window.onload = function(){
                MyFocus(5000);
            }
        </script>
        <!-- 焦点图结束 -->
        <!-- 产品信息 -->
        <div class="product-info pull-left">
            <div class="country clearfix">
                                <div class="guoqi pull-left gq_70"></div>
                                <div class="name pull-left">
                    <h3>法国姬娜苹果</h3>
                </div>
            </div>
            <div class="price-info">
                <div class="price01 clearfix">
                    <div class="box  clearfix pull-left">
                        <div class="pri01">
                            <h5 class="pull-left">参考价</h5>
                            <span class="pull-left">
                                <s id="jq-old-price">￥29</s>
                            </span>
                        </div>
                        <div class="pri02">
                            <h5 class="pull-left">果园价</h5>
                            <span class="pull-left price-sp" id="jq-price">￥29</span>
                        </div>
                    </div>
                    <div class="box2 pull-right">
                        <div class="weixin">
                            <img src="http://qr.liantu.com/api.php?el=l&w=280&m=5&text=http://m.fruitday.com/detail/index/7946"/>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(
                            function(e){
                                $(".box2").mouseover(
                                    function(e){
                                    /* Act on the event */
                                    $(".weixin").show();
                                });
                                 $(".box2").mouseleave(
                                    function(e){
                                     /* Act on the event */
                                     $(".weixin").hide();
                                 });

                            });
                    </script>
                </div>
                <div class="guige clearfix">
                    <h5 class="pull-left">规格</h5>
                    <div class="zhuang pull-left">
                                                <span data-old-price="29" data-price="29" data-pid="7946" data-ppid="10120" data-product_no="2151229101" data-outofstock="0" class="pull-left current">6个装</span>
                                            </div>
                    <script>
                        $(".guige div.zhuang span").on('click', function() {
                            if (!$(this).hasClass('current')) {
                                $("#jq-old-price").jsp('￥' + $(this).data('old-price'));
                                $("#jq-price").jsp('￥' + $(this).data('price'));
                                $(this).addClass('current').siblings('span').removeClass('current');
                                $("div.comment span.product_no").text($(this).data('product_no'));

                                var stockMsg = '';
                                if ($(this).data('outofstock')) {
                                    stockMsg = '无货';
                                    $("div.buy a").addClass('none');
                                } else {
                                    stockMsg = '有货';
                                    $("div.buy a").removeClass('none');
                                }
                                $("div.send > span.have").text(stockMsg);
                            }
                        });
                    </script>
                </div>
                <input type="hidden" id="send_to" name="send_to" value="106092" />
                                    
                <div class="send clearfix">
                    <h5 class="pull-left">配送至</h5>
                    <!-- Single button -->
                    <div class="btn-group pull-left">
                        <div class="btn btn-default dropdown-toggle" aria-expanded="false">
                            <p id="send-area">上海</p>
                            <span class="glyphicon glyphicon-menu-down"></span>
                            <span class="icon"></span>
                        </div>
                        <div class="dropdown-menu" role="menu">
                            <div class="dropdown-content">
                                <div class="dropdown-nav">
                                    <ul class="tab">
                                        <li id="province_item"><a class="hover" href="javascript:void(0);"><em>请选择</em><i></i></a></li>
                                        <li id="city_item" style="display: none"><a href="javascript:void(0);"><em>请选择</em><i></i></a></li>
                                    </ul>
                                </div>
                                <div class="fd-area active" id="stock_province_item">
                                    <ul class="area-list">
                                                                                <li data-id="106092" data-name="上海"><a href="javascript:void(0);">上海</a></li>
                                                                                <li data-id="145855" data-name="上海郊区"><a href="javascript:void(0);">上海郊区</a></li>
                                                                                <li data-id="1" data-name="江苏"><a href="javascript:void(0);">江苏</a></li>
                                                                                <li data-id="54351" data-name="浙江"><a href="javascript:void(0);">浙江</a></li>
                                                                                <li data-id="106340" data-name="安徽"><a href="javascript:void(0);">安徽</a></li>
                                                                                <li data-id="143949" data-name="北京"><a href="javascript:void(0);">北京</a></li>
                                                                                <li data-id="145874" data-name="北京（五环外）"><a href="javascript:void(0);">北京（五环外）</a></li>
                                                                                <li data-id="144005" data-name="天津"><a href="javascript:void(0);">天津</a></li>
                                                                                <li data-id="143983" data-name="河北"><a href="javascript:void(0);">河北</a></li>
                                                                                <li data-id="144252" data-name="广东"><a href="javascript:void(0);">广东</a></li>
                                                                                <li data-id="144443" data-name="四川"><a href="javascript:void(0);">四川</a></li>
                                                                                <li data-id="144522" data-name="重庆"><a href="javascript:void(0);">重庆</a></li>
                                                                            </ul>
                                </div>
                                <div class="fd-area" id="stock_city_item">
                                    <ul class="area-list">
                                                                                                                                                                                                                                                                                                                                                    <li data-pid="1" data-id="14270" data-name="常州"><a href="javascript:void(0);">常州</a></li>
                                                                                        <li data-pid="1" data-id="31710" data-name="淮安"><a href="javascript:void(0);">淮安</a></li>
                                                                                        <li data-pid="1" data-id="28260" data-name="连云港"><a href="javascript:void(0);">连云港</a></li>
                                                                                        <li data-pid="1" data-id="2" data-name="南京"><a href="javascript:void(0);">南京</a></li>
                                                                                        <li data-pid="1" data-id="23730" data-name="南通"><a href="javascript:void(0);">南通</a></li>
                                                                                        <li data-pid="1" data-id="17771" data-name="苏州"><a href="javascript:void(0);">苏州</a></li>
                                                                                        <li data-pid="1" data-id="42749" data-name="泰州"><a href="javascript:void(0);">泰州</a></li>
                                                                                        <li data-pid="1" data-id="4536" data-name="无锡"><a href="javascript:void(0);">无锡</a></li>
                                                                                        <li data-pid="1" data-id="46290" data-name="宿迁"><a href="javascript:void(0);">宿迁</a></li>
                                                                                        <li data-pid="1" data-id="9135" data-name="徐州"><a href="javascript:void(0);">徐州</a></li>
                                                                                        <li data-pid="1" data-id="49184" data-name="盐城"><a href="javascript:void(0);">盐城</a></li>
                                                                                        <li data-pid="1" data-id="36177" data-name="扬州"><a href="javascript:void(0);">扬州</a></li>
                                                                                        <li data-pid="1" data-id="39980" data-name="镇江"><a href="javascript:void(0);">镇江</a></li>
                                                                                                                                                                                                                                                                        <li data-pid="54351" data-id="54352" data-name="杭州"><a href="javascript:void(0);">杭州</a></li>
                                                                                        <li data-pid="54351" data-id="78239" data-name="湖州"><a href="javascript:void(0);">湖州</a></li>
                                                                                        <li data-pid="54351" data-id="74881" data-name="嘉兴"><a href="javascript:void(0);">嘉兴</a></li>
                                                                                        <li data-pid="54351" data-id="84713" data-name="金华"><a href="javascript:void(0);">金华</a></li>
                                                                                        <li data-pid="54351" data-id="101443" data-name="丽水"><a href="javascript:void(0);">丽水</a></li>
                                                                                        <li data-pid="54351" data-id="61841" data-name="宁波"><a href="javascript:void(0);">宁波</a></li>
                                                                                        <li data-pid="54351" data-id="90123" data-name="衢州"><a href="javascript:void(0);">衢州</a></li>
                                                                                        <li data-pid="54351" data-id="81106" data-name="绍兴"><a href="javascript:void(0);">绍兴</a></li>
                                                                                        <li data-pid="54351" data-id="96033" data-name="台州"><a href="javascript:void(0);">台州</a></li>
                                                                                        <li data-pid="54351" data-id="68453" data-name="温州"><a href="javascript:void(0);">温州</a></li>
                                                                                        <li data-pid="54351" data-id="93628" data-name="舟山"><a href="javascript:void(0);">舟山</a></li>
                                                                                                                                                                                                                                                                        <li data-pid="106340" data-id="116543" data-name="安庆"><a href="javascript:void(0);">安庆</a></li>
                                                                                        <li data-pid="106340" data-id="110702" data-name="蚌埠"><a href="javascript:void(0);">蚌埠</a></li>
                                                                                        <li data-pid="106340" data-id="140334" data-name="亳州"><a href="javascript:void(0);">亳州</a></li>
                                                                                        <li data-pid="106340" data-id="142739" data-name="池州"><a href="javascript:void(0);">池州</a></li>
                                                                                        <li data-pid="106340" data-id="122473" data-name="滁州"><a href="javascript:void(0);">滁州</a></li>
                                                                                        <li data-pid="106340" data-id="126555" data-name="阜阳"><a href="javascript:void(0);">阜阳</a></li>
                                                                                        <li data-pid="106340" data-id="106341" data-name="合肥"><a href="javascript:void(0);">合肥</a></li>
                                                                                        <li data-pid="106340" data-id="114716" data-name="淮北"><a href="javascript:void(0);">淮北</a></li>
                                                                                        <li data-pid="106340" data-id="112546" data-name="淮南"><a href="javascript:void(0);">淮南</a></li>
                                                                                        <li data-pid="106340" data-id="120049" data-name="黄山"><a href="javascript:void(0);">黄山</a></li>
                                                                                        <li data-pid="106340" data-id="136386" data-name="六安"><a href="javascript:void(0);">六安</a></li>
                                                                                        <li data-pid="106340" data-id="113743" data-name="马鞍山"><a href="javascript:void(0);">马鞍山</a></li>
                                                                                        <li data-pid="106340" data-id="115943" data-name="铜陵"><a href="javascript:void(0);">铜陵</a></li>
                                                                                        <li data-pid="106340" data-id="109303" data-name="芜湖"><a href="javascript:void(0);">芜湖</a></li>
                                                                                        <li data-pid="106340" data-id="130770" data-name="宿州"><a href="javascript:void(0);">宿州</a></li>
                                                                                        <li data-pid="106340" data-id="144431" data-name="宣城"><a href="javascript:void(0);">宣城</a></li>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    <li data-pid="143983" data-id="143984" data-name="石家庄"><a href="javascript:void(0);">石家庄</a></li>
                                                                                        <li data-pid="143983" data-id="144032" data-name="廊坊"><a href="javascript:void(0);">廊坊</a></li>
                                                                                        <li data-pid="143983" data-id="144033" data-name="承德"><a href="javascript:void(0);">承德</a></li>
                                                                                        <li data-pid="143983" data-id="144034" data-name="唐山"><a href="javascript:void(0);">唐山</a></li>
                                                                                        <li data-pid="143983" data-id="144660" data-name="保定"><a href="javascript:void(0);">保定</a></li>
                                                                                        <li data-pid="143983" data-id="144668" data-name="沧州"><a href="javascript:void(0);">沧州</a></li>
                                                                                        <li data-pid="143983" data-id="144677" data-name="邯郸"><a href="javascript:void(0);">邯郸</a></li>
                                                                                        <li data-pid="143983" data-id="144684" data-name="衡水"><a href="javascript:void(0);">衡水</a></li>
                                                                                        <li data-pid="143983" data-id="144690" data-name="秦皇岛"><a href="javascript:void(0);">秦皇岛</a></li>
                                                                                        <li data-pid="143983" data-id="144694" data-name="邢台"><a href="javascript:void(0);">邢台</a></li>
                                                                                        <li data-pid="143983" data-id="144700" data-name="张家口"><a href="javascript:void(0);">张家口</a></li>
                                                                                                                                                                                                                                                                        <li data-pid="144252" data-id="144422" data-name="深圳"><a href="javascript:void(0);">深圳</a></li>
                                                                                        <li data-pid="144252" data-id="144261" data-name="广州"><a href="javascript:void(0);">广州</a></li>
                                                                                        <li data-pid="144252" data-id="144274" data-name="珠海"><a href="javascript:void(0);">珠海</a></li>
                                                                                        <li data-pid="144252" data-id="144278" data-name="汕头"><a href="javascript:void(0);">汕头</a></li>
                                                                                        <li data-pid="144252" data-id="144285" data-name="韶关"><a href="javascript:void(0);">韶关</a></li>
                                                                                        <li data-pid="144252" data-id="144296" data-name="佛山"><a href="javascript:void(0);">佛山</a></li>
                                                                                        <li data-pid="144252" data-id="144302" data-name="江门"><a href="javascript:void(0);">江门</a></li>
                                                                                        <li data-pid="144252" data-id="144313" data-name="湛江"><a href="javascript:void(0);">湛江</a></li>
                                                                                        <li data-pid="144252" data-id="144321" data-name="茂名"><a href="javascript:void(0);">茂名</a></li>
                                                                                        <li data-pid="144252" data-id="144328" data-name="肇庆"><a href="javascript:void(0);">肇庆</a></li>
                                                                                        <li data-pid="144252" data-id="144334" data-name="惠州"><a href="javascript:void(0);">惠州</a></li>
                                                                                        <li data-pid="144252" data-id="144338" data-name="梅州"><a href="javascript:void(0);">梅州</a></li>
                                                                                        <li data-pid="144252" data-id="144341" data-name="汕尾"><a href="javascript:void(0);">汕尾</a></li>
                                                                                        <li data-pid="144252" data-id="144345" data-name="河源"><a href="javascript:void(0);">河源</a></li>
                                                                                        <li data-pid="144252" data-id="144347" data-name="阳江"><a href="javascript:void(0);">阳江</a></li>
                                                                                        <li data-pid="144252" data-id="144351" data-name="清远"><a href="javascript:void(0);">清远</a></li>
                                                                                        <li data-pid="144252" data-id="144355" data-name="东莞"><a href="javascript:void(0);">东莞</a></li>
                                                                                        <li data-pid="144252" data-id="144357" data-name="中山"><a href="javascript:void(0);">中山</a></li>
                                                                                        <li data-pid="144252" data-id="144359" data-name="揭阳"><a href="javascript:void(0);">揭阳</a></li>
                                                                                        <li data-pid="144252" data-id="144364" data-name="云浮"><a href="javascript:void(0);">云浮</a></li>
                                                                                        <li data-pid="144252" data-id="144367" data-name="潮州"><a href="javascript:void(0);">潮州</a></li>
                                                                                                                                                                                                                                                                        <li data-pid="144443" data-id="144444" data-name="成都"><a href="javascript:void(0);">成都</a></li>
                                                                                        <li data-pid="144443" data-id="144508" data-name="巴中"><a href="javascript:void(0);">巴中</a></li>
                                                                                        <li data-pid="144443" data-id="144510" data-name="达州"><a href="javascript:void(0);">达州</a></li>
                                                                                        <li data-pid="144443" data-id="144517" data-name="德阳"><a href="javascript:void(0);">德阳</a></li>
                                                                                        <li data-pid="144443" data-id="144513" data-name="广安"><a href="javascript:void(0);">广安</a></li>
                                                                                        <li data-pid="144443" data-id="144502" data-name="广元"><a href="javascript:void(0);">广元</a></li>
                                                                                        <li data-pid="144443" data-id="144499" data-name="乐山"><a href="javascript:void(0);">乐山</a></li>
                                                                                        <li data-pid="144443" data-id="144494" data-name="泸州"><a href="javascript:void(0);">泸州</a></li>
                                                                                        <li data-pid="144443" data-id="145541" data-name="眉山"><a href="javascript:void(0);">眉山</a></li>
                                                                                        <li data-pid="144443" data-id="144472" data-name="绵阳"><a href="javascript:void(0);">绵阳</a></li>
                                                                                        <li data-pid="144443" data-id="144487" data-name="南充"><a href="javascript:void(0);">南充</a></li>
                                                                                        <li data-pid="144443" data-id="144482" data-name="内江"><a href="javascript:void(0);">内江</a></li>
                                                                                        <li data-pid="144443" data-id="144479" data-name="遂宁"><a href="javascript:void(0);">遂宁</a></li>
                                                                                        <li data-pid="144443" data-id="144504" data-name="宜宾"><a href="javascript:void(0);">宜宾</a></li>
                                                                                        <li data-pid="144443" data-id="145547" data-name="资阳"><a href="javascript:void(0);">资阳</a></li>
                                                                                        <li data-pid="144443" data-id="144450" data-name="自贡"><a href="javascript:void(0);">自贡</a></li>
                                                                                        <li data-pid="144443" data-id="144515" data-name="雅安"><a href="javascript:void(0);">雅安</a></li>
                                                                                                                                                                                                                                                            </ul>
                                </div>
                                <div class="fd-area" id="dropdown-town"></div>
                            </div>
                            <div class="dropdown-close"></div>
                        </div>
                    </div>
                    <span class="pull-left have">有货</span>
                </div>
                <script>
                    var areaBox = $("div.btn-group.pull-left");
                    var hoverHandler = $(".dropdown-toggle");
                    var closeHandler = $(".dropdown-close");
                    var targetAreaBox = $(".dropdown-menu");
                    var dropdownNav = $(".dropdown-nav li");
                    var dropdownNavBox = $(".dropdown-content .fd-area");
                    var autoClose;

                    // 地址长度大于4，改变宽度
                    $(".area-list li a").each(function(){
                      if($(this).text().length>4){
                        $(this).parent().addClass("long-area");
                      }
                    });
                    // input handler hover, target show
                    hoverHandler.on('mouseover', function() {
                        $(this).css({
                            "border-bottom": '0',
                            "z-index": '10'
                        });
                        targetAreaBox.show();
                        dropdownNav.first().click();
                    });
                    // close handler click, target hide
                    closeHandler.on('click', function() {
                        targetAreaBox.hide();
                        hoverHandler.css('border-bottom', '1px solid #CECBCE');
                    });
                    // nav click, nav box show
                    dropdownNav.on('click', function() {
                        $(this).children('a').addClass('hover');
                        $(this).siblings('li').children('a').removeClass('hover');
                        dropdownNavBox.eq($(this).index()).addClass('active').siblings().removeClass('active');
                    });
                    // first tab li click
                    select($("#stock_province_item li"), $("#city_item"), $("#stock_city_item"));
                    // last tab li click
                    $("#stock_city_item li").on('click', function() {
                        selectLast($(this));
                    });

                    // select function, not last select
                    function select(handler, targetTop, targetBox) {
                        handler.on('click', function() {
                            var son = targetBox.find("li[data-pid=" + $(this).data('id') + "]");
                            if (son.length > 0) {
                                targetTop.prev().find("em").text($(this).data('name'));
                                targetTop.show().click();
                                son.show().siblings("li[data-pid!=" + $(this).data('id') + "]").hide();
                            } else {
                                selectLast($(this));
                            }
                        });
                    };

                    // last select function
                    function selectLast(obj) {
                        $("#send-area").text(obj.data('name'));
                        closeHandler.click();
                        setRegion(obj.data('id'), obj.data('name'));
                    }

                    // auto close
                    areaBox.on('mouseover', function() {
                        if (autoClose) {
                            clearTimeout(autoClose);
                        }
                    }).on('mouseout', function() {
                        autoClose = setTimeout(function() {
                            targetAreaBox.hide();
                            hoverHandler.css('border-bottom', '1px solid #CECBCE');
                        }, 1000);
                    });
                </script>
                    
                                <div class="number clearfix">
                    <h5 class="pull-left">数量</h5>
                                        <div class="goods-buy01 pull-left clearfix">
                        <span id="redu" class="num pull-left">-</span>
                        <input class="pull-left" id="add" type="tel" value="1">
                        <span id="add1" class="num pull-left">+</span>
                    </div>
                                    </div>
                <div class="buy clearfix">
                    <div class="fr-buy pull-left">
                        <a href="javascript:;" class="btn btn-primary btn-lg active " role="button" title="点击此按钮，到下一步确认购买信息">立即购买</a>
                    </div>
                                        <div class="fr-add pull-left">
                        <a href="javascript:;" class="btn btn-primary btn-lg active " title="加入购物车" role="button" >
                            加入购物车
                        </a>
                    </div>
                                    </div>
            </div>
            <div class="comment clearfix">
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">甜度</h5>
                    <span class="pull-left">
                        <img src="img/circle-3.png"/>
                    </span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">种类</h5>
                    <span class="pull-left">苹果</span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">产地</h5>
                    <span class="pull-left">法国</span>
                </div>
                                                <div class="pull-left clearfix">
                    <h5 class="pull-left">存储方法</h5>
                    <span class="pull-left">常温</span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">商品编码</h5>
                    <span class="pull-left product_no">
                        2151229101
                    </span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">备注</h5>
                    <span class="pull-left">
                        单重130-145g
                    </span>
                </div>
                            </div>
        </div>
        <!-- 产品信息结束 -->
        <div class="cl h68"></div>
        <!--  评论开始-->
        <input type="hidden" id="product_id" value="7946">
        <input type="hidden" id="comment_curr_page" value="0">
        <input type="hidden" id="comment_curr_type" value="">
        <input type="hidden" id="comment_curr_total" value="0">
        <div class="assess clearfix">
            <div class="leftpart pull-left">
                <div class="good-details js_fixed clearfix"  id="js_fixed">
                    <span class="cur pull-left" draggable="true">商品简介</span>
                    <span class="pull-left">
                        顾客评论 <b id="comment_total_top">(0)</b>
                    </span>
                                        <a href="javascript:;" class="pull-right btn btn-primary btn-lg active " title="加入购物车" role="button">加入购物车 <i class="tb-iconfont pull-left"></i>
                        <div class="thefruit clearfix">
                            <div class="fruitleft pull-left">
                                <img src="img/images/product_pic/7946/1/1-180x180-7946-7UPAKSYU.jpg"/>
                            </div>
                            <div class="fruitright pull-left">
                                <h5>法国姬娜苹果</h5>
                                <p>￥29 / 6个装</p>
                                <p class="frnum"></p>
                                <div class="anniu">
                                    确认
                                </div>
                            </div>
                        </div>
                    </a>
                                    </div>
                <div class="good-comments">
                    <ul class="no1" style="display: block;">
                        <li>
                            ​
                            
                            
	
	<img src="img/14497389494515.jpg" width="800" height="699">
    <img src="img/14497389516031.jpg" width="800" height="699">
    <img src="img/14497389542966.jpg" width="800" height="699">
    <img src="img/14497389587671.jpg" width="800" height="700">
    <img src="img/14497389615169.jpg" width="800" height="699">
    <img src="img/14497389656076.jpg" width="800" height="699">
    <img src="img/14497389687082.jpg" width="800" height="699">
   
   
                        </li>
                    </ul>
                    <ul class="no2" style="display: none;">
                        <div class="detail-title clearfix">
                            <div class="detail-title00 pull-left">
                                <p class="p1" id="grade_good_another_left">0%</p>
                                <p class="p2 mar-8">好评度</p>
                            </div>
                            <div class="detail-title01 pull-left">
                                <div class="pl-user clearfix">
                                    <div class="green-user pull-left">不错哟</div>
                                    <div class="dengji-good pull-left">
                                        <div id="grade_good_another" style="width: 0%;"></div>
                                    </div>
                                    <div class="dengji-number pull-left" id="good_rate_another">0%</div>
                                </div>
                                <div class="pl-user clearfix">
                                    <div class="green-user pull-left">待提高</div>
                                    <div class="dengji-good pull-left">
                                        <div id="grade_normal_another" style="width: 0%;"></div>
                                    </div>
                                    <div class="dengji-number pull-left" id="normal_rate_another">0%</div>
                                </div>
                                <div class="pl-user clearfix">
                                    <div class="green-user pull-left">小失落</div>
                                    <div class="dengji-good pull-left">
                                        <div id="grade_bad_another" style="width: 0%;"></div>
                                    </div>
                                    <div class="dengji-number pull-left" id="bad_rate_another">0%</div>
                                </div>
                            </div>
                            <div class="detail-title02 pull-left clearfix">
                                <p class="">发布评价即可获10积分，</p>
                                <p class="w-375">APP上传图片并晒单即可获得20积分，前5名可获双倍积分。</p>

                            </div>
                        </div>
                        <div class="detail-user">
                            <div class="modal fade bs-appraise-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog modal-md">
                                      <div class="modal-content appraise-img-dialog">
                                        <img src="">
                                      </div>
                                </div>
                            </div>
                            <div class="detail-user-title  clearfix">
                                <ul>
                                    <li  val="" id="c_all_another" class="now-gray pull-left">
                                        <s class="fpicon"></s>
                                        全部评论(
                                        <span id="comment_total">0</span>
                                        )
                                    </li>
                                    <li val="good" id="c_good_another" class="pull-left">
                                        <s class="fpicon"></s>
                                        不错呦(
                                        <span id="comment_total_good">0</span>
                                        )
                                    </li>
                                    <li val="normal" id="c_normal_another" class="pull-left">
                                        <s class="fpicon"></s>
                                        待提高(
                                        <span id="comment_total_normal">0</span>
                                        )
                                    </li>
                                    <li val="bad" id="c_bad_another" class="pull-left">
                                        <s class="fpicon"></s>
                                        小失落(
                                        <span id="comment_total_bad">0</span>
                                        )
                                    </li>
                                                                    </ul>
                            </div>
                            <div class="detail-allsays" id="comment_box">
                                <div class="nocomm">正在加载 ......</div>
                            </div>
                            <div class="btn-toolbar" role="toolbar" >
                                <div class="main" id="comment_box_page">
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
            <div class="rightpart pull-right">
                <h5>最近浏览过</h5>
<ul>
            <li>
        <a href="/prodetail/index/7946" class="clearfix" target="_blank">
            <div class="tu pull-left">
                <img src="http://img1.fruitday.com/images/product_pic/7946/1/1-180x180-7946-7UPAKSYU.jpg"/>
            </div>
            <div class="title pull-left">
                <h5>法国姬娜苹果</h5>
                <p>￥29.00 / 6个装</p>
                            </div>
        </a>
    </li>
    </ul>

            </div>
        </div>
        <script>
            $(".content .assess .good-details a").click(function(event) {
                if ($(this).hasClass('none')) {
                    gdialog_info('该商品已缺货');
                    return false;
                }

                //同步购物车购买数量
                var num = parseInt($("#add").val());
                var str = 'X'+num;
                $('.frnum').text(str);

                $(".thefruit").toggle();
                $('.content .assess .good-details a .thefruit').click(function() {
                       return false;
                    }
                 );
            });

            $(function() {
                getCommentRate();

                $("#c_all_another, #c_good_another, #c_normal_another, #c_bad_another").on('click', function() {
                    getComment($(this).attr('val'), 0, $(this).children('span').text());
                });

                $("#foretaste-comment").on('click', function() {
                    getList(1);
                });

                //立即购买
                $(".price-info .buy .fr-buy").click(function(){
                    if ($(this).children('a').hasClass('none')) {
                        gdialog_info('该商品已缺货');
                        return false;
                    }
                    var active_id = '';

                    if(active_id == '' || active_id == null)
                    {
                        //添加商品到购物车
                        addCart('lg');
                    }
                    else if (!$(this).children('a').hasClass('none'))
                    {
                        //kjt
                        var items = "7946"+'|'+"10120"+'|'+"2151229101"+'|'+active_id;
                        $.base64.utf8encode = true;
                        items = $.base64.encode(items);
                        top.location.href = '/kjtorder/index/'+items;
                    }

                });

                // 加入购物车
                $(".price-info .buy .fr-add").click(function(){
                    if ($(this).children('a').hasClass('none')) {
                        gdialog_info('该商品已缺货');
                        return false;
                    }
                    addCart();
                });
                $('.shop-cart .shop-top .cha').click(function(){
                    $('.shop-cart').fadeOut(800);
                    $('.zhezhao').fadeOut(800);

                });

                //加入购物车 - 下拉确认
                $(".anniu").click(function(){
                    //添加商品到购物车
                    addCart();
                });


            });

            /*
             * 加入购物车
             */
            function addCart(type)
            {
                var items = {
                    0: {
                        'pid': $("div.zhuang > span[class*=current]").data('pid'),
                        'ppid': $("div.zhuang > span[class*=current]").data('ppid'),
                        'pno': $("div.zhuang > span[class*=current]").data('product_no'),
                        'type':"normal",
                        'qty':parseInt($("#add").val())
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

                            if(type != 'lg')
                            {
                                $('.zhezhao').fadeIn(800);
                                $('.shop-cart').fadeIn(800);
                            }

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

                            //跳转到购物车
                            if(type == 'lg')
                            {
                                top.location.href = '/cart';
                            }
                        }
                        else if(rs.code == 300){
                            gdialog_info(rs.msg);
                        }
                    }
                });
            }

            function getCommentRate() {
                $.ajax({
                    type: 'POST',
                    url: '/ajax/comment/pRate',
                    dataType: 'json',
                    data: {
                        id: $("#product_id").val()
                    },
                    success: function(data) {
                        if (data.code == 200) {
                            $("#comment_total_top").text('(' + data.msg.num.total + ')');
                            $("#grade_good_another_left").text(data.msg.good + '%');
                            $("#grade_good_another").animate({width: data.msg.good + '%'}, 1000);
                            $("#good_rate_another").text(data.msg.good + '%');
                            $("#grade_normal_another").animate({width: data.msg.normal + '%'}, 1000);
                            $("#normal_rate_another").text(data.msg.normal + '%');
                            $("#grade_bad_another").animate({width: data.msg.bad + '%'}, 1000);
                            $("#bad_rate_another").text(data.msg.bad + '%');
                            $("#comment_total").text(data.msg.num.total);
                            $("#comment_total_good").text(data.msg.num.good);
                            $("#comment_total_normal").text(data.msg.num.normal);
                            $("#comment_total_bad").text(data.msg.num.bad);

                            getComment('', 0, data.msg.num.total);
                        }
                    }
                });
            }
            // get comment list and pagination
            function getComment(type, page, total) {
//                console.log(arguments);
                $.ajax({
                    type: 'POST',
                    url: '/ajax/comment/pList',
                    dataType: 'json',
                    data: {
                        id: $("#product_id").val(),
                        curr_page: page,
                        type: type
                    },
                    success: function(data) {
                        if (data.code == 200) {
                            var list = data.msg.list;
                            var commentHtml;
                            if (!list.length) {
                                commentHtml = '<div class="nocomm">暂时还没有评论</div>';
                            } else {
                                commentHtml =  '<div class="detail-allsays01">'
                                $.each(list, function(k, v) {
                                    commentHtml +=      '<div class="detail-user-says clearfix">';
                                    commentHtml +=          '<div class="detail-user-says-left pull-left">';
                                    commentHtml +=              '<img class="img-circle" src="' + v.userface + '">';
                                    commentHtml +=              '<p>' + v.user_name + '</p>';
                                    commentHtml +=          '</div>';
                                    commentHtml +=          '<div class="detail-user-says-right pull-right">';
                                    commentHtml +=              '<ul>';
                                    commentHtml +=                  '<li class="clearfix">';
                                    commentHtml +=                      '<p class="num pull-left">评分</p>';
                                    commentHtml +=                      '<p class="start pull-left user-ping">';
                                    commentHtml +=                          new Array(parseInt(v.star)+1).join('<span class="star"></span>');
                                    commentHtml +=                      '</p>';
                                    commentHtml +=                  '</li>';
                                    commentHtml +=                  '<li class="clearfix">';
                                    commentHtml +=                      '<p class="cont pull-left">内容</p>';
                                    commentHtml +=                      '<p class="pull-left user-ping">' + v.content.replace("\\n", "<br />", "g") + '</p>';
                                    commentHtml +=                  '</li>';
                                    if (v.thumbs) {
                                        var commentImage = v.thumbs.split(',');
                                    commentHtml +=                  '<li data-toggle="modal" data-target="#myModal">';
                                    commentHtml +=                      '<p class="cont pull-left">晒图</p>';
                                        $.each(commentImage, function(key, img) {
                                    commentHtml +=                      '<img src="' + img + '"/>';
                                        });
                                    commentHtml +=                  '</li>';
                                    }
                                    commentHtml +=                  '<li>';
                                    commentHtml +=                      '<span class="gray">' + v.time + '</span>';
                                    commentHtml +=                  '</li>';
                                    commentHtml +=                  '<li class="clearfix">';
                                    if(v.customer_repaly != undefined)
                                    {
                                        if(v.customer_repaly[0] != null && v.customer_repaly[0].id >0)
                                        {
                                            commentHtml +=                      '<p class="cont pull-left" style="color:#64a131">回复</p>';
                                            commentHtml +=                      '<p class="pull-left user-ping" style="color:#64a131">' + v.customer_repaly[0].content+ '</p>';
                                            commentHtml +=                  '</li>';
                                            commentHtml +=                  '<li>';
                                            commentHtml +=                      '<span class="gray" style="color:#64a131">' + v.customer_repaly[0].time + '</span>';
                                            commentHtml +=                  '</li>';
                                        }
                                    }
                                    commentHtml +=              '<ul>';
                                    commentHtml +=          '</div>';
                                    commentHtml +=      '</div>';
                                });
                                commentHtml +=      '</div>';

                            }
                            $("#comment_box").jsp(commentHtml);

                            $("#comment_curr_type").val(type);
                            $("#comment_curr_page").val(page);
                            $("#comment_curr_total").val(total);

                            getCommentPage(parseInt(total), page);
                        }
                    }
                });
            }
            function getCommentPage(total, current){
                if (total == 0) {
                    $("#comment_box_page").jsp('').hide();
                    return false;
                }

                var pageSize = 10;
                var pages = Math.ceil(total/pageSize) - 1;
                if (pages > 0) {
                    var start = current - 2 >= 0 ? current - 2 : 0;
                    var end = current + 2 <= pages ? current + 2 : pages;

                    var commentPageHtml = '';
                    if (total > pageSize) {
                        commentPageHtml =   '<a href="javascript:;" class="jq-first"> < 首页</a>';
                        commentPageHtml +=  '<div class="last">';
                        commentPageHtml +=      '<a href="javascript:;">上一页</a>';
                        commentPageHtml +=  '</div>';
                    }
                    commentPageHtml +=      '<div class="pagenum">';
                    for (var i=start; i<=end; i++) {
                        var curr = i == current ? 'cur' : '';
                    commentPageHtml +=          '<a href="javascript:;" class="' + curr + '">' + (i+1) + '</a>';
                    }
                    commentPageHtml +=      '</div>';
                    if (total > pageSize) {
                        commentPageHtml +=  '<div class="next">';
                        commentPageHtml +=      '<a href="javascript:;">下一页</a>';
                        commentPageHtml +=  '</div>';
                        commentPageHtml +=  '<a href="javascript:;" class="jq-last"> 最后一页 > </a>';
                    }

                    $("#comment_box_page").jsp(commentPageHtml).show();

                    // bind page event
                    var currentType = $("#comment_curr_type").val();
                    var currentPage = parseInt($("#comment_curr_page").val());
                    var currentTotal = parseInt($("#comment_curr_total").val());

                    $("#comment_box_page .jq-first").on('click', function() {
                        getComment(currentType, 0, currentTotal);
                    });
                    $("#comment_box_page > .last > a").on('click', function() {
                        var page = currentPage-1 >= 0 ? currentPage-1 : 0;
                        getComment(currentType, page, currentTotal);
                    });
                    $("#comment_box_page > .next > a").on('click', function() {
                        var page = currentPage+1 <= pages ? currentPage+1 : pages;
                        getComment(currentType, page, currentTotal);
                    });
                    $("#comment_box_page > .pagenum > a").on('click', function() {
                        getComment(currentType, $(this).text()-1, currentTotal);
                    });
                    $("#comment_box_page .jq-last").on('click', function() {
                        getComment(currentType, pages, currentTotal);
                    });
                } else {
                    $("#comment_box_page").jsp('').hide();
                }
            }

            function getList(page) {
                $.ajax({
                    type: 'POST',
                    url: '/ajax/foretaste/getComment',
                    dataType: 'json',
                    data: {
                        fgid: $("#foretaste-comment").data('fgid'),
                        page: page,
                    },
                    success: function(data) {
                        if (data.code == 200) {
                            var list = data.msg.data;
                            var listHtml = '', pageHtml = '';
                            if (!list.length) {
                                listHtml = '<div class="nocomm">暂时还没有评论</div>';
                                $("#comment_box").jsp(listHtml);
                            } else {
                                // list
                                listHtml =  '<div class="detail-allsays01">'
                                $.each(list, function(k, v) {
                                    listHtml +=      '<div class="detail-user-says clearfix">';
                                    listHtml +=          '<div class="detail-user-says-left pull-left">';
                                    listHtml +=              '<img class="img-circle" src="' + (v.userinfo ? v.userinfo.userface : '') + '">';
                                    listHtml +=              '<p>' + (v.userinfo ? v.userinfo.username : '') + '</p>';
                                    listHtml +=          '</div>';
                                    listHtml +=          '<div class="detail-user-says-right pull-right">';
                                    listHtml +=              '<ul>';
                                    listHtml +=                  '<li class="clearfix">';
                                    listHtml +=                      '<p class="num pull-left">评分</p>';
                                    listHtml +=                      '<p class="start pull-left user-ping">';
                                    listHtml +=                          new Array(parseInt(v.rank)+1).join('<span class="star"></span>');
                                    listHtml +=                      '</p>';
                                    listHtml +=                  '</li>';
                                    listHtml +=                  '<li class="clearfix">';
                                    listHtml +=                      '<p class="cont pull-left">内容</p>';
                                    listHtml +=                      '<p class="pull-left user-ping">' + v.content.replace("\\n", "<br />", "g") + '</p>';
                                    listHtml +=                  '</li>';
                                    if (v.pic_urls.length) {
                                    listHtml +=                  '<li data-target="#myModal" data-toggle="modal">';
                                    listHtml +=                      '<p class="cont pull-left">晒图</p>';
                                        $.each(v.pic_urls, function(key, img) {
                                    listHtml +=                      '<img src="' + img + '"/>';
                                        });
                                    listHtml +=                  '</li>';
                                    }
                                    listHtml +=                  '<li>';
                                    listHtml +=                      '<span class="gray">' + v.createtime + '</span>';
                                    listHtml +=                  '</li>';
                                    listHtml +=              '<ul>';
                                    listHtml +=          '</div>';
                                    listHtml +=      '</div>';
                                });
                                listHtml +=      '</div>';
                                $("#comment_box").jsp(listHtml);

                                // pagep
                                var total = data.msg.totalResult;
                                var pageSize = 10;
                                pageHtml = getPage(total, page, pageSize);
                                console.log(pageHtml);
                                $("#comment_box_page").jsp(pageHtml).show();
                                if (!pageHtml) $("#comment_box_page").hide();
                                bindPageEvent(page, Math.ceil(total/pageSize));
                            }
                        }
                    },
                });
            }
            function getPage(total, current, pageSize) {
                var pages = Math.ceil(total/pageSize);
                var pageHtml = '';

                if (pages > 1) {
                    var start = current - 2 >= 1 ? current - 2 : 1;
                    var end = current + 2 <= pages ? current + 2 : pages;


                    if (total > pageSize) {
                        pageHtml +=     '<a href="javascript:;" class="jq-first"> < 首页 </a>';
                        pageHtml +=     '<div class="last">';
                        pageHtml +=         '<a href="javascript:;">上一页</a>';
                        pageHtml +=     '</div>';
                    }
                    pageHtml +=         '<div class="pagenum">';
                    for (var i=start; i<=end; i++) {
                        var curr = i == current ? 'cur' : '';
                    pageHtml +=             '<a href="javascript:;" class="'+ curr + '">' + i + '</a>';
                    }
                    pageHtml +=         '</div>';
                    if (total > pageSize) {
                        pageHtml +=     '<div class="next">';
                        pageHtml +=         '<a href="javascript:;">下一页</a>';
                        pageHtml +=     '</div>';
                        pageHtml +=     '<a href="javascript:;" class="jq-last"> 最后一页 > </a>';
                    }
                } else {
                    pageHtml = '';
                }

                return pageHtml;
            }
            function bindPageEvent(currentPage, pages) {
                $("#comment_box_page .jq-first").on('click', function() {
                    getList(1);
                });
                $("#comment_box_page > .last > a").on('click', function() {
                    var page = currentPage-1 >= 1 ? currentPage-1 : 1;
                    getList(page);
                });
                $("#comment_box_page > .next > a").on('click', function() {
                    var page = currentPage+1 <= pages ? currentPage+1 : pages;
                    getList(page);
                });
                $("#comment_box_page > .pagenum > a").on('click', function() {
                    getList(parseInt($(this).text()));
                });
                $("#comment_box_page > .jq-last").on('click', function() {
                    getList(pages);
                });
            }
        </script>
        <!-- 评论结束 -->
    </div>

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
<div class="show-loading"></div>

</html>