<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <meta name="description" content="天天果园官方网站提供水果生鲜、果篮券卡订制、干果零食等优质食品网购服务,2014年车厘子销量全网第一,佳沛奇异果、新奇士橙、进口牛油果等亦深受果友喜爱。" />
    <title>当然果园-水果网购首选品牌，水果，我们只挑有来头的！</title> <link rel="shortcut icon"  href="img/default_userpic.ico">
<link rel="shortcut icon" href="img/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    
    
 <script type="text/javascript">
  var ht=null;
   function  addAddress(){
      var address= document.getElementById("address").value;
      
		if (window.XMLHttpRequest) {//其他IE容器
			ht = new XMLHttpRequest();
		} else if (window.ActiveXObject) {//IE容器
			try {
				ht = new ActiveXObject("MsXML2.XMLHTTP");
			} catch (e) {
				try {
					ht = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alter("对象实例化有问题！");
				}
			}
		}
	
		ht.onreadystatechange = call123; //回调函数
		//以GET方式发送
		//ht.open("GET","servlet/checkuser?userId="+userId,true); //true异步
		//ht.send();//发送请求到服务器端

		ht.open("post", "GouwuServlet?todo=ajax&address="+address	, true);
		ht.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
		ht.send(); // ?参数 

	return true;
      
  
  }
 function call123() {
 }
 
 </script>
    
</head>
<body>
<!-- top -->
<div class="top-con">
    
    </div>

<!-- 头部开始 -->
<section class="p-common-header">
    <jsp:include
		page="console_element/top1.jsp"></jsp:include>
        <div class="content">
        <nav class="navbar ">
            <div class="container-fluid">
                <div class="navbar-header">
                    <div  style="padding:0px;float:left"> <a href="index.jsp"><img src="img/login5.png.png" /></a> </div>
                </div>
                <div class="collapse navbar-collapse" >
                                    <ul class="icons-cart clearfix pull-right list-unstyled">
                        <li class="pull-left li1 cur">
                            <span>1</span>
                            <p>我的购物车</p>
                        </li>
                        <li class="pull-left li2 cur">
                            <span>2</span>
                            <p>确认订单信息</p>
                        </li>
                        <li class="pull-left li3">
                            <span>3</span>
                            <p>成功提交订单</p>
                        </li>
                    </ul>
                                    </div>
            </div>
        </nav>
    </div>
</section>

<input type="hidden" id="api_msg_type" value="">
<input type="hidden" id="api_msg" value="">
<input type="hidden" id="api_goto_url" value="">
<input type="hidden" id="order_error" value="">

<!-- 下单开始 -->
<form action="GouwuServlet?todo=jiesuan" method="post">
<section class="p-component-order" id="p-order">
    <h3><i class="iconfont pull-left">&#xe603;</i>填写并核对订单信息</h3>
    <h4><a href="javascript:;" class="pull-right" id="newAddress">新增收货地址</a>收货人信息</h4>
    <div class="order-item">
                <ul class="list-unstyled clearfix order-item-addresslist" id="orderAddressList">
                    </ul>
        <ul  class="list-unstyled order-item-addresslist" id="orderAddressSwitch">
            <li>
            <%  User user1= (User)session.getAttribute("user");
                  UserBiz ub= new UserBizImpl();
                 User user= ub.searchUser(user1.getuPhone());
                if(user.getuAddress()!=null){
               %> <span class="more">
                    <b><%=user.getuAddress() %></b>
                    <a class=""></a>
                </span>
                <%
                }else{
                 
                 %>  <input type="text"   style="border: 1; height: 40px ;width:500px"  id="address" name="address">
                 <input type="button" value="增加收货地址" onclick="addAddress()"  >
                 <span class="more" style="float: left;" >
                    <b>没有常用地址请添加</b>
                   
                    <a class=""></a>
                </span>
                <%
                }
             %>
                
            </li>
        </ul>
            </div>
    <h4>支付方式</h4>
    <div class="order-item">
        <ul class="list-unstyled clearfix order-item-paylist" id="orderPayList">
            <li data-id="1|0" class="cur">在线支付</li>
            <!--<li data-id="1|0" class="curr">网银支付</li>-->
            <!--<li id="sc_payoff" data-id="4|1" >货到付款</li>-->
            <li id="sc_payoff" data-id="1|0" class="balancepay payarrival "><p id="offname">线下支付</p>
                <div class="paytips payways">
                    <i class="iconfont">&#xe607;</i>
                                        <p >货到付现金<em style="display: none">|1</em></p>
                                        <p >货到刷银行卡<em style="display: none">|2</em></p>
                                        <p >红色储值卡<em style="display: none">|7</em></p>
                                        <p >金色储值卡<em style="display: none">|8</em></p>
                                        <p >果实卡<em style="display: none">|9</em></p>
                                        <p >通用券/代金券<em style="display: none">|11</em></p>
                                    </div>
            </li>
            <li data-id="5|0" class="balancepay">余额支付
                <div class="paytips">
                    <i class="iconfont">&#xe607;</i>
                    您的余额是：0.00元 <span class="fc-red">余额不足，<a href="/user/recharge" target="_blank">立即充值</a></span>                </div>
            </li>
        </ul>
    </div>
    <h4><span class="pull-right">购物车</span>配送信息</h4>
    <div class="order-item clearfix">
        <ul class="order-item-cartlist list-unstyled pull-right">
         
       
           
                      <c:set var="allPrice" value="0" scope="session" />
					<c:forEach items="${gwc}" var="map">
						<c:forEach items="${map.value}" var="gouwuche">
							<li>
                <dl class="list-unstyled clearfix">
                <c:forTokens items="${gouwuche.gPic}" delims="@" var="gouwu"
											varStatus="i">

											<c:if test="${i.index==0}">
												<dt> <img src="${gouwu}" height="80px" width="80px"    alt=""></dt>
												</a>
											</c:if>


										</c:forTokens>
                    <dd>
                        <div class="protitle">${gouwuche.gName}</div>
                        <div class="proinfo">￥${gouwuche.gPrice} <span>x ${gouwuche.pNum}</span></div>
                        <!-- <span class="protag">赠品</span> -->
                    </dd>
                </dl>
                <c:set var="prive" value="${gouwuche.gPrice*gouwuche.pNum}" />
										<c:set var="allPrice" value="${allPrice+prive}"
											scope="session"></c:set>
            </li>
						</c:forEach>
					</c:forEach>
                    </ul>
        <div class="order-item-sendinfo pull-left" id="orderSendInfo">
            <h5><a href="javascript:;" class="pull-right" id="modifyTime">修改</a><span class="pull-left">配送时间</span><p><input id="d422" name="date" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+1}'})"/> </p></h5>
            <h5 class="end clearfix"><textarea class="form-control pull-right" rows="3" placeholder="请填写备注信息" id="msg"></textarea><span class="pull-left">备注信息</span></h5>
            <div class="font-color"><span>运费：</span><span class="VI-color2" id="ref_yf">￥0.00</span></div>
        </div>
    </div>
    <h4>使用积分/优惠券</h4>
    <div class="order-item order-item-discount">
        <p>最多可抵扣￥0.00元，已抵扣<input type="text" class="form-control" placeholder="0"  value="0.00" id="jf"  data-last-id="0.00" data-limit-id="0.00">元</p>
        <p><span id="couponshow">抵扣码及优惠券:
                                            共4张
                            </span><a href="javascript:;" id="modifyCoup">选择</a></p>
    </div>

    <div class="order-item-inall">
        <p class="text-right">商品总金额：<span>${allPrice}</span></p>
        <p class="text-right">运费：<span id="all_yf">￥0.00</span></p>
        <p class="text-right">商品减免：<span>￥0</span></p>
        <p class="text-right">积分抵扣：<span id="all_jf">￥0.00</span></p>
        <p class="text-right">优惠券抵扣：<span id="all_cm">￥0.00</span></p>
        <p class="text-right">其他抵扣：<span id="all_pd">￥0.00</span></p>
    </div>

    <div class="order-item-last text-right">
    <input type="submit" value="提交订单" id="js" class="pull-right">
        <b class="pull-right"><span id="all_total"><input type="text" disabled="disabled"
						height="10px" id="zongjia"   style="width: 80px"  name="zongjia" value="${allPrice}"></span></b><span>应付金额</span>
    </div>
 </form>
</section>
 <jsp:include page="console_element/buttom.jsp"></jsp:include>





</body>


</html>
