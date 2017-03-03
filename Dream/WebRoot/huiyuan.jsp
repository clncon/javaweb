
<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<body>
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
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/member-center.css">
 <link rel="stylesheet" href="css/960.min.css" type="text/css"></link>   
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.excoloSlider.js"></script>
<link rel="stylesheet" href="css/jquery.excoloSlider.css" type="text/css"></link>
 <script>
        $(function () {
            $("#sliderA").excoloSlider();
        });
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

</section>
<!-- 中间内容开始 -->
<div class="member-body">
    <div class="member-boxheader clearfix">
        <div class="member-info pull-left">
            <div class="member-main">
                <p>查看等级特权</p>
                <div class="header-img">
                    <img src="img/default_userpic.png">
                    <div class="member-levels v0" data-level="v0"></div>
                </div>
                <% User user= (User)session.getAttribute("user");%>
                <p><%=user.getuName() %></p>
                <p class="p-col">距离鲜果达人<%=user.getuLevel() %>还需消费200元</p>
                <p class="p-col">购买0次</p>
                <div class="member-bottom clearfix">
                    <ul>
   <!--  删除积分 余额  优惠券的地方-->                  
      <li class="integrate pull-left">
                            <span></span>
                            <p id="points"></p>
                        </li>
                        <li class=""></li>
                        <li class="remainder pull-left">
                            <span></span>
                            <p></p>
                        </li>
                        <li class=""></li>
                        <li class="coupon pull-left">
                            <span></span>
                            <p></p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 轮播 -->
        <div class="member-banner pull-left">
            <div class="frame" style="overflow: hidden;" id="member-banner">
            <div class="container_12">
            <div class="grid_8">
                  <div id="sliderA" class="slider" width="980" height="400" >
				<a href="RepertoryServlet?todo=searchBygid&gid=18"><img src="img/b1d1f25c2be525722f3ad33cea6a22bb.jpg" /></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=54"><img src="img/niuyouguo.jpg" /></a>
				<a href="RepertoryServlet?todo=searchBygid&gid=32"><img src="img/putaoyou.jpg" /></a>
			</div>
			</div>
			</div>
            </div>
        </div>
    </div>
</div>

<div class="member-content">
    <!--会员信息 -->
    <div class="member-service clearfix">
        <div class="member-righzts pull-left clearfix">
            <div class="member-enjoy">
                <h3>会员专享</h3>
                <ul class="clearfix">

                                        <li class="pull-left">
                        <div class="member-img">
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=4" target="_blank"><img src="img/1-270x270-3718-7KAY1K18.jpg" width="370" height="370"></a>
                            <div class="member-levelimg clearfix">
                                <span class="level-bg"></span>
                        <!--         <span class="level-title">V1专享</span>     --> 
                                <span class="level-bg single"></span>
                            </div>

                        </div>
                        <div class="member-pricebox">
                            <p class="p-name p-name-width">美国华盛顿甜脆红地厘蛇果礼</p>
                            <div class="line"></div>
                            <p class="member-price">
                                <span>￥</span>
                                <em >88.00</em>
                                /礼盒
                                <s></s>
                            </p>
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=4" target="_blank" class="btn price-btn">立即购买</a>
                        </div>
                    </li>
                                        <li class="pull-left">
                        <div class="member-img">
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=1" target="_blank"><img src="img/1-270x270-8010-RDS7DTC6.jpg" width="370" height="370"></a>
                            <div class="member-levelimg clearfix">
                                <span class="level-bg"></span>
                        <!--        <span class="level-title">V2/V3专享</span>   --> 
                                <span class="level-bg single"></span>
                            </div>

                        </div>
                        <div class="member-pricebox">
                            <p class="p-name p-name-width">智利甜心樱桃</p>
                            <div class="line"></div>
                            <p class="member-price">
                                <span>￥</span>
                                <em >118.00</em>
                                /2斤装
                                <s></s>
                            </p>
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=1" target="_blank" class="btn price-btn">立即购买</a>
                        </div>
                    </li>
                                        <li class="pull-left">
                        <div class="member-img">
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=8" target="_blank"><img src="img/1-270x270-3817-H17S4KAD.jpg" width="370" height="370"></a>
                            <div class="member-levelimg clearfix">
                                <span class="level-bg"></span>
                        <!--          <span class="level-title">V4/V5专享</span>  -->
                                <span class="level-bg single"></span>
                            </div>

                        </div>
                        <div class="member-pricebox">
                            <p class="p-name p-name-width">台湾青枣</p>
                            <div class="line"></div>
                            <p class="member-price">
                                <span>￥</span>
                                <em >48.00</em>
                                /2斤装
                                <s></s>
                            </p>
                            <a href="RepertoryServlet?todo=searchhuiyuan&gid=8" target="_blank" class="btn price-btn">立即购买</a>
                        </div>
                    </li>
              </ul>
                <div class="member-tryeat pull-left">
                    <div class=""></div>
                </div>
            </div>
        </div>

        
    </div>

    <div class="My-special">
        <img src="img/46EC.png" width="724" height="320"><img src="img/20160113111400.png" width="555" height="320">
    </div>


    <div class="member-apply clearfix">
<img src="img/20160113111701.png" width="621" height="430"><img src="img/20160113111706.png" width="658" height="429">
</hr width>

        
    <div class="member-orders clearfix">
        <h3>会员须知</h3>
         <img src="img/20160113121709.png" align="right"/>
        <ul class="pull-left">
            <li>
                <h5 class="title"><b>1.累计消费总金额</b></h5>
                <ul>
                    <li>累计消费总金额计算周期为滚动的一年。例如当日为2015年1月1日，</li>
                    <li>计算周期即为2014年1月1日-2015年1月1日为期一年，以此类推；</li>
                    <li>累计消费总金额为订单实际支付，不包含积分及优惠券的抵金额；</li>
                    <li>使用券卡及充值余额购买，不计入积分计算；</li>
                    <li>累计消费总金额仅限同一ID，不同ID不可累计、转存等；</li>
                </ul>
            </li>
            <li>
              <h5 class="title"><b>2.会员等级升降</b></h5>
                <ul>
                    <li>会员等级升降均按照订单的“已完成”状态进行统计和等级变更；</li>
                    <li>计算周期：按照当日日期向前滚动一年，统计这一年内的累计购买金额和累计购买次数；</li>
                    <li>· 升级：订单状态转变为“已完成”后自动升级；</li>
                    <li>· 降级：若在计算周期内未达到会员等级计算条件，将自动保留现有等级3个月；</li>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;3个月后仍然未达到条件，将自动降级；</li>
                </ul>
            </li>
            <li>
              <h5 class="title"><b>3.会员日</b></h5>
                <ul>
                    <li>每月22日作为会员日，果园会推出一些会员专享款商品，指定会员专享；</li>
                </ul>
            </li>
            <li>
              <h5 class="title"><b>4.会员生日</b></h5>
                <ul>
                    <li>会员生日当月下单即可享受额外获赠2倍积分，同时V3以上会员将有尊享生日商品（生日特权每年享受一次）；</li>
                </ul>
            </li>
            <li>
              <h5 class="title"><b>5.会员等级查询</b></h5>
                <ul>
                    <li>可在“我的账户”中查看；</li>
                </ul>
            </li>
            <li>
              <h5 class="title"><b>6.售后保障</b></h5>
                <ul>
                    <li>如遇售后问题，请及时联系，我们将会尽快为您解决；</li>
                    <li>提示：当然果园可能通过您预留的手机号码向您推送发货通知、物流信息、促销优惠活动等内容，请确保号码真实有效；</li>
                </ul>
            </li>
        </ul>
        
    </div>
</div>
</div>


<jsp:include page="console_element/buttom.jsp"></jsp:include>


</body>
<div class="show-loading"></div>
</html>
