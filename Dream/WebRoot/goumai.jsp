<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script type="text/javascript">
     function jia(){
     var num=parseInt(document.getElementById("add").value);
       var ss= num+1;
       if(ss>100){
       ss=100;
       }
      document.getElementById("add").value=ss;
       
       
    
     }
   
     function jian(){
       var num=parseInt(document.getElementById("add").value);
       var ss= num-1;
       if(ss<1){
       ss=1;
       }
      document.getElementById("add").value=ss;
     
     }
    
    
    </script>


<link rel="stylesheet" href="css/dengluzhuce.css" type="text/css"></link></head>
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
    <form method="post" action="GouwuServlet?todo=gouwuche&gId=${regost.gId}">
        <div class="bread">
            <strong class="lvse"><a href="index.jsp">首页</a></strong>
            <span class="lvse">
                                &gt;
                <a href="fruit.jsp">全部鲜果</a>
                                &gt;
            </span>
            <span class="huise">${regost.gName}</span>
        </div>
        <!-- 焦点图开始 -->
        <div id="MyFocus" class="pull-left">
          
            <ul class="dianul"> 
            <c:forTokens items="${goods }" delims="@" var="gb" varStatus="i">
                                <li class=" cur">
                    <img src=" ${gb}"/>
                   
                </li></c:forTokens>
                             
                            </ul>
                            
            <ul class="tuul">
            <c:forTokens items="${goods}" delims="@" var="gb" varStatus="i">
                                <li class="cur">
                    <a href="javascript:;">
                     <c:if test="${i.index==0 }"> <img src="${gb }"/></c:if> 
                    </a>
                </li>
                </c:forTokens>
                                <li class="cur">
                    <a href="javascript:;">
                  <!--        <img src="img/3-370x370-7348-T1YPRSAW.jpg"/>  -->  
                    </a>
                </li>
                                <li class="cur">
                    <a href="javascript:;">
                    <!--    <img src="img/2-370x370-7348-T1YPRSAW.jpg"/>-->  
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
                    <h3>${regost.gName }</h3>
                </div>
            </div>
            <div class="price-info">
                <div class="price01 clearfix">
                    <div class="box  clearfix pull-left">
                        <div class="pri01">
                            <h5 class="pull-left">参考价</h5>
                            <span class="pull-left">
                                <s id="jq-old-price">￥${regost.gPrice+10}</s>
                            </span>
                        </div>
                        <div class="pri02">
                            <h5 class="pull-left">果园价</h5>
                            <span class="pull-left price-sp" id="jq-price">￥${regost.gPrice}</span>
                        </div>
                    </div>
                    <div class="box2 pull-right">
                        <div class="weixin">
                            <img src="img/api.php?el=l&w=280&m=5&text=http://img/7946"/>
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
                    <h5 class="pull-left">库存</h5>
                    <div class="zhuang pull-left">
                                                <span data-old-price="29" data-price="29" data-pid="7946" data-ppid="10120" data-product_no="2151229101" data-outofstock="0" class="pull-left current">${regost.rNum}</span>
                                            </div>
                   
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
                
                    
                                <div class="number clearfix">
                    <h5 class="pull-left">数量</h5>
                                        <div class="goods-buy01 pull-left clearfix">
                        <button id="button"  type="button" class="num pull-left" onclick="jian()">-</button>
                        <input class="pull-left" id="add" name="add" type="tel" value="1">
                        <button id="button" type="button" class="num pull-left" onclick="jia()">+</button>
                    </div>
                                    </div>
                <div class="buy clearfix">	
                    <div class="fr-buy pull-left">
                       <input type="submit" value="立即购买" id="goumaijiaru" name="goumaijiaru">
                       
                       
                    </div>
                                        <div class="fr-add pull-left">
                        <a href="javascript:;" class="btn btn-primary btn-lg active " title="加入购物车" role="button" >
                            加入购物车
                        </a>
                    </div>
                                    </div>
            </div>
            </form>
            <div class="comment clearfix">
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">甜度</h5>
                    <span class="pull-left">
                        <img src="img/circle-3.png"/>
                    </span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">种类</h5>
                    <span class="pull-left">${regost.gType}</span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">产地</h5>
                    <span class="pull-left">${regost.gAddress}</span>
                </div>
                                                <div class="pull-left clearfix">
                    <h5 class="pull-left">存储方法</h5>
                    <span class="pull-left">常温</span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">商品编码</h5>
                    <span class="pull-left product_no">
                         ${regost.gId }
                    </span>
                </div>
                                <div class="pull-left clearfix">
                    <h5 class="pull-left">备注</h5>
                    <span class="pull-left">
                        ${regost.gDescribe}
                    </span>
                </div>
                            </div>
        </div>
        <!-- 产品信息结束 -->
        <div class="cl h68"></div>
        <!--  评论开始-->
       <input type="hidden" id="product_id" value="7946"> <input
			type="hidden" id="comment_curr_page" value="0"> <input
			type="hidden" id="comment_curr_type" value=""> <input
			type="hidden" id="comment_curr_total" value="0">
		<div class="assess clearfix">
			<div class="leftpart pull-left">
				<div class="good-details js_fixed clearfix" id="js_fixed">
					<span class="pull-left"> 顾客评论 <b id="comment_total_top">${count}</b>
					</span>
				</div> 
				<div class="good-comments">
					<ul class="no1" style="display: block;">


						<table width="996px">
							<c:forEach var="lc" items="${listcomment}">

								<tr>
									<td width="200px">评论作者:${lc.cAuthor }<br> <br>评论时间:${lc.cDate }
									<hr style='border:solid' color='#CCCCCC' size='0.1'/>
									</td>
									
									<td>${lc.cContent }<br><br><br>
									<hr style='border:solid' color='#CCCCCC' size='0.1'/>
									</td>
									
								<tr>
								
							</c:forEach>
						</table>

						<div class="detail-user">
							<div class="btn-toolbar" role="toolbar">
								<div class="main" id="comment_box_page"></div>
							</div>
						</div>
					</ul>

				</div>
			</div>
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


<jsp:include page="console_element/buttom.jsp"></jsp:include>

</body>
<div class="show-loading"></div>

</html>
