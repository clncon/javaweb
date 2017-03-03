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
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery.base64.js"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-52936203-1', 'auto');
        ga('send', 'pageview');

    </script>
     <link rel="stylesheet" href="css/960.min.css" type="text/css"></link>   
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.excoloSlider1.js"></script>
<link rel="stylesheet" href="css/jquery.excoloSlider.css" type="text/css"></link>
 <script>
        $(function () {
            $("#sliderA").excoloSlider();
        });
    </script>
</head>
<body>
<!-- top -->
<div class="top-con"> </div>

<!-- 头部开始 -->

<section class="p-common-header">
<jsp:include page="console_element/top1.jsp"></jsp:include>
<jsp:include page="console_element/top2.jsp"></jsp:include>
</section>

<!-- 轮播图开始 -->
<section class="p-component-banner" id="p-banner">
  <div class="frame" id="frameBanner">
   <div class="container_12">
            <div class="grid_8">
                  <div id="sliderA" class="slider" width="980" height="400" >
                  <a href="RepertoryServlet?todo=searchBygid&gid=35"><img src="img/20160325171956.png" width="1600px" height="500" /></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=18"><img src="img/b1d1f25c2be525722f3ad33cea6a22bb.jpg"  width="1600px" height="500"/></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=54"><img src="img/niuyouguo.jpg" width="1600px " height="500"/></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=32"><img src="img/putaoyou.jpg" width="1600px" height="500" /></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=30"><img src="img/20160325170332.png" width="1600px" height="500" /></a>
				
				
			</div>
			</div>
			</div>
  </div>
  <ul class="slidebtn">
  </ul>
</section>
<!-- 中部广告开始 -->
<div class="show-ad w-1280">
  <ul class="clearfix">
    <li class="pull-left "> <a href="RepertoryServlet?todo=searchBygid&gid=59" target="_blank"> <img alt="" class="lazy" src="img/7b87d255c09845d0fc55ec577ae57471.jpg" src="img/EmptyHome@2x.png"> </a> </li>
    <li class="pull-left "> <a href="RepertoryServlet?todo=searchBygid&gid=54" target="_blank"> <img alt="" class="lazy" src="img/e62edd57716e6b6c5054ae8661869b9f.jpg" src="img/EmptyHome@2x.png"> </a> </li>
    <li class="pull-left last"> <a href="RepertoryServlet?todo=searchBygid&gid=61" target="_blank"> <img alt="" class="lazy" src="img/528ab8c3e40c22964dfe3564e6fd33a0.jpg" src="img/EmptyHome@2x.png"> </a> </li>
  </ul>
</div>
<!-- 水果品类 -->
<div class="fruit-kinds w-1280"> 
  <!-- 新品推荐 -->
  <div class="new-kind" style="display:block">
    <div class="title">
      <h3 class="pull-left">新品推荐</h3>
      <div class="pull-left img-new"> <img src="img/xinp.png" alt=""></div>
       <a href="fruit.jsp" class="more pull-right" target="_blank">更多></a> </div>
    <div class="good-list clearfix">
      <ul>
        <li id="newkind" class="pull-left first" pid="8010" ppid="10185" type="normal" pno="2151231101">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=1" target="_blank"> <img  class="lazy" src="img/497ca19fffafa51c64039d83da4e7f96.jpg" alt="2131231"> </a> </div>
          <div class="wrap"> <a href="RepertoryServlet?todo=searchBygid&gid=1" target="_blank">	 
            <p class="first-p"></p>
            <p>智利甜心樱桃</p>
            <p>￥128.00/2斤</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>智利甜心樱桃</span> </div>
            <div class="s-unit pull-left"> <span>￥128.00/</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="8178" ppid="10354" type="normal" pno="2160106103">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=3" target="_blank"> <img class="lazy" src="img/1-270x270-3384-WX7U25FR.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=3">
            <p class="first-p"></p>
            <p>佳沛新西兰有机绿奇异果</p>
            <p>￥49/12个装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>佳沛新西兰有机绿奇异果</span> </div>
            <div class="s-unit pull-left"> <span>￥49/12个装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="8079" ppid="10255" type="normal" pno="2160105105">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=7" target="_blank"> <img class="lazy" src="img/caomei1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=7">
            <p class="first-p"></p>
            <p>长柄玫瑰草莓</p>
            <p>￥26/1斤装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>长柄玫瑰草莓</span> </div>
            <div class="s-unit pull-left"> <span>￥26/1斤装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="8077" ppid="10253" type="normal" pno="2160105101">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=53" target="_blank"> <img class="lazy" src="img/1-370x370-8077-D8ASXR89.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=53">
            <p class="first-p"></p>
            <p>泰国椰青</p>
            <p>￥69.00/4个装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>泰国椰青</span> </div>
            <div class="s-unit pull-left"> <span>￥69.00/4个装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="3817" ppid="5708" type="normal" pno="20149219">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=57" target="_blank"> <img class="lazy" src="img/1-370x370-3817-H17S4KAD.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=57">
            <p class="first-p"></p>
            <p>云南牛奶青枣</p>
            <p>￥58.00/2斤装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>云南牛奶青枣</span> </div>
            <div class="s-unit pull-left"> <span>￥58.00/2斤装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="7911" ppid="10085" type="normal" pno="2151225101">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=3" target="_blank"> <img class="lazy" src="img/1-370x370-7911-1P7DTC48.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=3">
            <p class="first-p"></p>
            <p>佳沛新西兰有机绿奇异果 </p>
            <p>￥49.00/12个装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>佳沛新西兰有机绿奇异果 </span> </div>
            <div class="s-unit pull-left"> <span>￥49.00/12个装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
        <li class="pull-left" pid="7805" ppid="9978" type="normal" pno="2151222106">
          <div class="img-scale"> <a href="RepertoryServlet?todo=searchBygid&gid=26" target="_blank"> <img class="lazy" src="img/1-270x270-3265-XAK35HBR.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="wrap"> <a target="_blank" href="RepertoryServlet?todo=searchBygid&gid=26">
            <p class="first-p"></p>
            <p>菲律宾凤梨</p>
            <p>￥45/2个装</p>
            <p class="small"></p>
            <span class="button-a add-cart-index">加入购物车</span> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>菲律宾凤梨</span> </div>
            <div class="s-unit pull-left"> <span>￥45/2个装</span> </div>
            <div class="s-che pull-right"> </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
  
  <!-- 全球鲜果 -->
  <div class="import-fruit">
    <div class="title">
      <h3 class="pull-left">全球鲜果</h3>
      <div class="pull-left img-new"> <img src="img/jink.png" alt=""></div>
      <a href="fruit.jsp" class="more pull-right" target="_blank">更多></a> </div>
    <div class="good-list clearfix">
      <ul>
        <li class="pull-left first" pid="7365" ppid="9530" type="normal" pno="2151208108">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=10" target="_blank"> <img class="lazy" src="img/1-370x370-7365-UPX2C3HB.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>海南西州蜜瓜</span> </div>
            <div class="s-unit pull-left"> <span>￥35.00/1个装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7144" ppid="9298" type="normal" pno="2151231112">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=61" target="_blank"> <img class="lazy" src="img/1-370x370-7144-1D9PAHK7.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>新疆库尔勒香梨</span> </div>
            <div class="s-unit pull-left"> <span>￥59.00/4斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="3839" ppid="5741" type="normal" pno="201411658">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=56" target="_blank"> <img class="lazy" src="img/qingpingguo1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>法国苹果</span> </div>
            <div class="s-unit pull-left"> <span>￥18/1斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="6434" ppid="8567" type="normal" pno="2150514132">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=20" target="_blank"> <img class="lazy" src="img/1-370x370-6434-THKC4UFT.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>泰国龙眼</span> </div>
            <div class="s-unit pull-left"> <span>￥49.00/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left first" pid="3682" ppid="5567" type="normal" pno="201512268">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=13" target="_blank"> <img class="lazy" src="img/1-370x370-3682-A9D9CDY9.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>秘鲁红提</span> </div>
            <div class="s-unit pull-left"> <span>￥39.00/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="1979" ppid="2719" type="normal" pno="201411938">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=17" target="_blank"> <img class="lazy" src="img/1-270x270-3493-RRKRR26C.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>新奇士美国柠檬</span> </div>
            <div class="s-unit pull-left"> <span>￥58/2斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>

        </li>
        <li class="pull-left " pid="3171" ppid="4765" type="normal" pno="33423">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=51" target="_blank"> <img class="lazy" src="img/1-370x370-3171-88RHW16A.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>四川枇杷</span> </div>
            <div class="s-unit pull-left"> <span>￥39.00/1斤装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="6952" ppid="9104" type="normal" pno="2151122101">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=50" target="_blank"> <img class="lazy" src="img/yangtao1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>台湾杨桃</span> </div>
            <div class="s-unit pull-left"> <span>￥25/2斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
  
  <!-- 生鲜美食 -->
  <!-- 
  <div class="china-made">
    <div class="title">
      <h3 class="pull-left">生鲜美食</h3>
      <div class="pull-left img-new"> <img src="img/guoc.png" alt=""></div>
      <a href="fruit.jsp" class="more pull-right" target="_blank">更多></a> </div>
    <div class="good-list clearfix">
      <ul>
        <li class="pull-left first" pid="5588" ppid="7683" type="normal" pno="2150901120">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-5588-R16YW81F.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>澳大利亚草饲牛腩块</span> </div>
            <div class="s-unit pull-left"> <span>￥38.00/350克</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="4892" ppid="6943" type="normal" pno="2150512101">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-4892-2B2FK2KP.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>越南龙利鱼柳</span> </div>
            <div class="s-unit pull-left"> <span>￥19.00/300-400g</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="3980" ppid="5896" type="normal" pno="2151110119">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-3980-B2S2873P.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>精选澳洲草饲牛排超值家庭装</span> </div>
            <div class="s-unit pull-left"> <span>￥76.00/400g</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="5995" ppid="8107" type="normal" pno="2150925106">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-5995-49XP4961.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>野生半壳大扇贝</span> </div>
            <div class="s-unit pull-left"> <span>￥42.00/6只装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left first" pid="4607" ppid="6645" type="normal" pno="2150519102">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-4607-FBWDXF42.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>上海崇明生态鸽</span> </div>
            <div class="s-unit pull-left"> <span>￥58.00/1个装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="6921" ppid="9073" type="normal" pno="2151120107">
          <div class="s-img"> <a href="goumai.jsp" target="_blank"> <img class="lazy" src="img/1-370x370-6921-K3DS471C.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>新西兰小牛脊骨（2件8.8折）</span> </div>
            <div class="s-unit pull-left"> <span>￥19.00/500g</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="4612" ppid="6650" type="normal" pno="201412031">
          <div class="s-img"> <a href="/prodetail/index/4612" target="_blank"> <img class="lazy" src="img/1-370x370-4612-A9UCU85S.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>加拿大比目鱼</span> </div>
            <div class="s-unit pull-left"> <span>￥58.00/400克</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="4606" ppid="6644" type="normal" pno="2150519101">
          <div class="s-img"> <a href="/prodetail/index/4606" target="_blank"> <img class="lazy" src="img/1-370x370-4606-SCFB4K8W.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>上海崇明生态草鸡</span> </div>
            <div class="s-unit pull-left"> <span>￥88.00/1个装</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
   -->
  <!--礼品券卡-->
  <div class="gift-card">
    <div class="title">
      <h3 class="pull-left">奇珍异果</h3>
      <div class="pull-left img-new"> <img src="img/liw.png" alt=""></div>
      <a href="gift.jsp" class="more pull-right" target="_blank">更多></a> </div>
    <div class="good-list clearfix">
      <ul>
        <li class="pull-left first" pid="7644" ppid="9816" type="normal" pno="2151216111">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=70" target="_blank"> <img class="lazy" src="img/heijialun1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>台湾黑加仑</span> </div>
            <div class="s-unit pull-left"> <span>￥88.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7647" ppid="9819" type="normal" pno="2151216113">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=63" target="_blank"> <img class="lazy" src="img/boluomi1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>海南菠萝蜜</span> </div>
            <div class="s-unit pull-left"> <span>￥88.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7652" ppid="9824" type="normal" pno="2151216117">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=64" target="_blank"> <img class="lazy" src="img/xianrenzhangguo1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>野生仙人掌果</span> </div>
            <div class="s-unit pull-left"> <span>￥138.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7656" ppid="9828" type="normal" pno="2151216119">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=66" target="_blank"> <img class="lazy" src="img/jiaogua1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>非洲角瓜</span> </div>
            <div class="s-unit pull-left"> <span>￥234.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left first" pid="7659" ppid="9831" type="normal" pno="2151216121">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=65" target="_blank"> <img class="lazy" src="img/wuzhiju1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>广东五指橘</span> </div>
            <div class="s-unit pull-left"> <span>￥66.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7663" ppid="9835" type="normal" pno="2151216123">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=67" target="_blank"> <img class="lazy" src="img/shufanqie1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>苏州树番茄</span> </div>
            <div class="s-unit pull-left"> <span>￥25.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7667" ppid="9839" type="normal" pno="2151216126">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=68" target="_blank"> <img class="lazy" src="img/danhuangguo1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>南美洲蛋黄果</span> </div>
            <div class="s-unit pull-left"> <span>￥159.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
        <li class="pull-left " pid="7672" ppid="9843" type="normal" pno="2151216128">
          <div class="s-img"> <a href="RepertoryServlet?todo=searchBygid&gid=69" target="_blank"> <img class="lazy" src="img/nacuigua1.jpg" alt="" src="img/default.png"> </a> </div>
          <div class="s-info clearfix">
            <div class="s-name pull-left"> <span>新西兰纳粹瓜</span> </div>
            <div class="s-unit pull-left"> <span>￥450.00/斤</span> </div>
            <div class="s-che pull-right"></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</div>
<script>
    $(function() {

        $(".new-kind .good-list ul li,.new-kind2 .good-list ul li").hover(
                function(){
                    $(this).children('.fruit-kinds .good-list ul li .wrap').stop().animate({"top": 0}, 500);
                    $(this).addClass("cur");
                },
                function(){
                    if ($(this).hasClass('first')) {
                        $(this).children('.fruit-kinds .good-list ul li .wrap').stop().animate({"top": 637}, 500);
                    }
                    else {
                        $(this).children('.fruit-kinds .good-list ul li .wrap').stop().animate({"top": 322}, 500);
                    }
                    $(this).addClass("cur");
                }
        );

        $(".new-kind .good-list ul li,.new-kind2 .good-list ul li").mouseleave(
                function(){
                    $(this).removeClass("cur");
                }
        );

        $(".import-fruit .good-list ul li,.china-made .good-list ul li,.gift-card .good-list ul li").hover(
                function(){
                    $(this).addClass("cur");
                }
        );

        $(".import-fruit .good-list ul li,.china-made .good-list ul li,.gift-card .good-list ul li").mouseleave(
                function(){
                    $(this).removeClass("cur");
                }
        );


        $('.fruit-kinds .good-list ul li .wrap a span').click(function () {
                    //$('.zhezhao').fadeIn(800);
                    //$('.shop-cart').fadeIn(800);
                    return false;
                }
        );

        $('.fruit-kinds .new-kind .good-list ul li .wrap a span,.fruit-kinds .new-kind2 .good-list ul li .wrap a span').click(function(){

                    var pid = $('.fruit-kinds .good-list ul li.cur').attr('pid');
                    var ppid = $('.fruit-kinds .good-list ul li.cur').attr('ppid');
                    var pno = $('.fruit-kinds .good-list ul li.cur').attr('pno');
                    var type = $('.fruit-kinds .good-list ul li.cur').attr('type');

                    //加入购物车
                    addCart(pid,ppid,pno,type);
                }
        );

        $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').click(
                function(){
                    $(this).animate({backgroundPosition:"-514px -291px"}, 500);
                    var pid = $('.fruit-kinds .good-list ul li.cur').attr('pid');
                    var ppid = $('.fruit-kinds .good-list ul li.cur').attr('ppid');
                    var pno = $('.fruit-kinds .good-list ul li.cur').attr('pno');
                    var type = $('.fruit-kinds .good-list ul li.cur').attr('type');


                    //加入购物车
                    addCart(pid,ppid,pno,type);
                }
        );

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

                }
                else if(rs.code == 300){
                    gdialog_info(rs.msg);
                    $('.f-list .leftpart .p-operate .s-che,.fruit-kinds .good-list ul li .s-info .s-che,.qx-content .qx-cor .qx-cont .qx-info .cart').animate({backgroundPosition: "-517px -243px"}, 500);
                }

                var url = "http://"+window.location.host;
                $('.p-common-minicart').load(url+'/cart/resminicart' + " .p-common-minicart>*");
            }
        });
    }
</script> 

<!--购物车弹出层-->
<div class="zhezhao"></div>
<!-- 购物车 -->
<div class="shop-cart">
  <div class="shop-top">
    <div class="cha pull-right"> <img src="img/cha.png" alt=""></div>
  </div>
  <div class="shop-content">
    <div class="title clearfix">
      <div class="suc pull-left"></div>
      <div class="adds pull-left">
        <p>加入购物车成功！</p>
      </div>
    </div>
    <p class="row2"> 购物车中共 <em class="cartcount">0</em> 件商品 | 商品小计 <em class="cartprice">￥0</em> </p>
    <div class="choosed clearfix">
      <ul>
        <li>
          <div class="buy clearfix">
            <div class="fr-buy pull-left"> <a href="javascript:void(0);" onclick="closeCart();" class="btn btn-primary btn-lg active" role="button" title="点击此按钮，到下一步确认购买信息">继续购物</a> </div>
            <div class="fr-add pull-left"> <a href="#" class="btn btn-primary btn-lg active" title="加入购物车" role="button"> 去结算 </a></div>
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