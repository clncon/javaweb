<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buttom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <section class="toolbarfoot">
    <a href="/web/card_change" target="_blank" class="kq"></a>
    <!--<a href="#" class="kf"><iframe src="/kefu" style="width: 35px;height: 35px;outline: none;border: none;position: fixed;bottom: 37px;right: 0;">-->
    <!--</iframe></a>-->
    <a href="#" class="kf" onclick="window.open('http://p.qiao.baidu.com/im/index?siteid=7860627&ucid=6965311','','width=800,height=600')"></a>
    <a href="javascript:scrollTo(0,0);" class="return-top"></a>
</section>
    <section class="p-common-footer">
  <div class="content">
    <ul class="list-inline clearfix">
      <ul>
        <ul>
          <ul>
            <ul>
             <li><img src="img/20160112163206.png" width="226" height="52"><img src="img/20160112163344.png" width="954" height="57"></li>
            </ul>
          </ul>
        </ul>
      </ul>
    </ul>
    <div class="clearfix footbar"><div class="logo"><img src="img/20160112161811.png" width="147" height="119"></div>
            <div class="block1">
                <dl class="clearfix">
                  
                    <dd class="pull-left">
                        
                       <wb:follow-button uid="1728025983" type="red_2" width="136" height="24"></wb:follow-button>
                    </dd>
                </dl>
                <div class="VI-color2 fs-5">182-5977-2030</div>
                <div class="font-gray"><span class="font-color">服务时间</span> 08:00 - 22:00</div>
            </div>
            <ul class="block2 list-unstyled">
                <li><img src="img/ewcode1.jpg" alt="" /><span>当然果园官方微信</span></li>
                <li><img src="img/ewcode2.jpg" alt="" /><span>当然果园在线客服</span></li>
            </ul>
            <ul class="block3 list-unstyled">
                <li><h4>购物指南</h4>
                    <a href="xinyonghuzhuce.jsp">新用户注册</a>
                    <a href="zaixianxiadan.jsp">在线下单</a> <a href="zhifufangshi.jsp">支付方式</a>
                </li>
                <li><h4>配送说明</h4> <a href="yunfeishuoming.jsp">运费说明</a>
                    <a href="peisongfangshi.jsp">配送方式</a> <a href="fapiaoshuoming.jsp">发票说明</a>
                </li>
                <li><h4>售后服务</h4>
                    <a href="tuihuanhuoyuanze.jsp">退换货规则</a> <a href="fuwubaozhangchengnuo.jsp">服务保障承诺</a> <a href="yanhuoyuqianshou.jsp">验货与签收</a>
                </li>
                <li><h4>企业服务</h4>
                    <a href="qiyedinggou.jsp">企业订购</a>
                    <a href="zengpiaoxinxi.jsp">增值信息</a>
                    <a href="dingzhizhuanqu.jsp">定制专区</a>
                </li>
            </ul>

        </div>
        <div class="copyright text-center">
            <p class="fs-2 font-color">版权所有 &copy; 2016当然果园&nbsp;&nbsp;保留所有权利 | 沪ICP备12042163</p>
            <p class="fs-2 VI-color2">当然果园&nbsp;&nbsp;鲜果网购</p>
            <!-- 添加工商信息-->
            <!--   -->
        </div>
    </div>
</section>
  </body>
</html>
