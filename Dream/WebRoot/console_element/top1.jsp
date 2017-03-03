<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
    
    <div class="topnav">
        <div class="content clearfix">
        <span class="pull-left">
          <span class="pull-left p-common-region" id="region"> <i class="iconfont">&#xe602;</i>
            <a href="javascript:;" class="topnav-region link-gray">
                上海 <i class="iconfont">&#xe606;</i>
            </a>
            <div class="p-common-regionCon hide" onmouseover="p-common-regionCon" id="regSel">
                <h5>热门城市:</h5>
                <ul class="list-unstyled clearfix hotcity">
                                        <li>
                        <a href="javascript:;" data-id="106092">上海</a>
                    </li>
                                        <li>
                        <a href="javascript:;" data-id="144261">广州</a>
                    </li>
                                        <li>
                        <a href="javascript:;" data-id="143949">北京</a>
                    </li>
                                        <li>
                        <a href="javascript:;" data-id="144422">深圳</a>
                    </li>
                                        <li>
                        <a href="javascript:;" data-id="144444">成都</a>
                    </li>
                                    </ul>
                <h5>选择城市:</h5>
                <ul class="list-unstyled regionsel">
                                                            <li>
                        <a href="javascript:;" data-id="106092">上海</a>
                    </li>
                                                                                <li>
                        <a href="javascript:;" data-id="145855">上海郊区</a>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            江苏
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="14270">常州</a>
                                                        <a href="javascript:;" data-id="31710">淮安</a>
                                                        <a href="javascript:;" data-id="28260">连云港</a>
                                                        <a href="javascript:;" data-id="2">南京</a>
                                                        <a href="javascript:;" data-id="23730">南通</a>
                                                        <a href="javascript:;" data-id="17771">苏州</a>
                                                        <a href="javascript:;" data-id="42749">泰州</a>
                                                        <a href="javascript:;" data-id="4536">无锡</a>
                                                        <a href="javascript:;" data-id="46290">宿迁</a>
                                                        <a href="javascript:;" data-id="9135">徐州</a>
                                                        <a href="javascript:;" data-id="49184">盐城</a>
                                                        <a href="javascript:;" data-id="36177">扬州</a>
                                                        <a href="javascript:;" data-id="39980">镇江</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            浙江
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="54352">杭州</a>
                                                        <a href="javascript:;" data-id="78239">湖州</a>
                                                        <a href="javascript:;" data-id="74881">嘉兴</a>
                                                        <a href="javascript:;" data-id="84713">金华</a>
                                                        <a href="javascript:;" data-id="101443">丽水</a>
                                                        <a href="javascript:;" data-id="61841">宁波</a>
                                                        <a href="javascript:;" data-id="90123">衢州</a>
                                                        <a href="javascript:;" data-id="81106">绍兴</a>
                                                        <a href="javascript:;" data-id="96033">台州</a>
                                                        <a href="javascript:;" data-id="68453">温州</a>
                                                        <a href="javascript:;" data-id="93628">舟山</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            安徽
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="116543">安庆</a>
                                                        <a href="javascript:;" data-id="110702">蚌埠</a>
                                                        <a href="javascript:;" data-id="140334">亳州</a>
                                                        <a href="javascript:;" data-id="142739">池州</a>
                                                        <a href="javascript:;" data-id="122473">滁州</a>
                                                        <a href="javascript:;" data-id="126555">阜阳</a>
                                                        <a href="javascript:;" data-id="106341">合肥</a>
                                                        <a href="javascript:;" data-id="114716">淮北</a>
                                                        <a href="javascript:;" data-id="112546">淮南</a>
                                                        <a href="javascript:;" data-id="120049">黄山</a>
                                                        <a href="javascript:;" data-id="136386">六安</a>
                                                        <a href="javascript:;" data-id="113743">马鞍山</a>
                                                        <a href="javascript:;" data-id="115943">铜陵</a>
                                                        <a href="javascript:;" data-id="109303">芜湖</a>
                                                        <a href="javascript:;" data-id="130770">宿州</a>
                                                        <a href="javascript:;" data-id="144431">宣城</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" data-id="143949">北京</a>
                    </li>
                                                                                <li>
                        <a href="javascript:;" data-id="145874">北京（五环外）</a>
                    </li>
                                                                                <li>
                        <a href="javascript:;" data-id="144005">天津</a>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            河北
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="143984">石家庄</a>
                                                        <a href="javascript:;" data-id="144032">廊坊</a>
                                                        <a href="javascript:;" data-id="144033">承德</a>
                                                        <a href="javascript:;" data-id="144034">唐山</a>
                                                        <a href="javascript:;" data-id="144660">保定</a>
                                                        <a href="javascript:;" data-id="144668">沧州</a>
                                                        <a href="javascript:;" data-id="144677">邯郸</a>
                                                        <a href="javascript:;" data-id="144684">衡水</a>
                                                        <a href="javascript:;" data-id="144690">秦皇岛</a>
                                                        <a href="javascript:;" data-id="144694">邢台</a>
                                                        <a href="javascript:;" data-id="144700">张家口</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            广东
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="144422">深圳</a>
                                                        <a href="javascript:;" data-id="144261">广州</a>
                                                        <a href="javascript:;" data-id="144274">珠海</a>
                                                        <a href="javascript:;" data-id="144278">汕头</a>
                                                        <a href="javascript:;" data-id="144285">韶关</a>
                                                        <a href="javascript:;" data-id="144296">佛山</a>
                                                        <a href="javascript:;" data-id="144302">江门</a>
                                                        <a href="javascript:;" data-id="144313">湛江</a>
                                                        <a href="javascript:;" data-id="144321">茂名</a>
                                                        <a href="javascript:;" data-id="144328">肇庆</a>
                                                        <a href="javascript:;" data-id="144334">惠州</a>
                                                        <a href="javascript:;" data-id="144338">梅州</a>
                                                        <a href="javascript:;" data-id="144341">汕尾</a>
                                                        <a href="javascript:;" data-id="144345">河源</a>
                                                        <a href="javascript:;" data-id="144347">阳江</a>
                                                        <a href="javascript:;" data-id="144351">清远</a>
                                                        <a href="javascript:;" data-id="144355">东莞</a>
                                                        <a href="javascript:;" data-id="144357">中山</a>
                                                        <a href="javascript:;" data-id="144359">揭阳</a>
                                                        <a href="javascript:;" data-id="144364">云浮</a>
                                                        <a href="javascript:;" data-id="144367">潮州</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" class="provicesel">
                            <span class="pull-right">
                              <i class="iconfont">&#xe60a;</i>
                            </span>
                            四川
                        </a>
                        <div class="citysel">
                                                        <a href="javascript:;" data-id="144444">成都</a>
                                                        <a href="javascript:;" data-id="144508">巴中</a>
                                                        <a href="javascript:;" data-id="144510">达州</a>
                                                        <a href="javascript:;" data-id="144517">德阳</a>
                                                        <a href="javascript:;" data-id="144513">广安</a>
                                                        <a href="javascript:;" data-id="144502">广元</a>
                                                        <a href="javascript:;" data-id="144499">乐山</a>
                                                        <a href="javascript:;" data-id="144494">泸州</a>
                                                        <a href="javascript:;" data-id="145541">眉山</a>
                                                        <a href="javascript:;" data-id="144472">绵阳</a>
                                                        <a href="javascript:;" data-id="144487">南充</a>
                                                        <a href="javascript:;" data-id="144482">内江</a>
                                                        <a href="javascript:;" data-id="144479">遂宁</a>
                                                        <a href="javascript:;" data-id="144504">宜宾</a>
                                                        <a href="javascript:;" data-id="145547">资阳</a>
                                                        <a href="javascript:;" data-id="144450">自贡</a>
                                                        <a href="javascript:;" data-id="144515">雅安</a>
                                                    </div>
                    </li>
                                                                                <li>
                        <a href="javascript:;" data-id="144522">重庆</a>
                    </li>
                                                        </ul>

            </div>
          </span>
          满百包邮（环郊内）
        </span>

            <ul class="pull-right list-inline">
                                <li>
                               
                                    <a href="user.jsp" class="link-gray"></a>
                                    <a href="UserServlet?todo=loginOut" class="link-gray">[ 退出 ]</a> 
                                    
                                   
                                    <a href="login.jsp" class="link-gray">[ 登录 ]</a> 
                                   
                    ，
                    <a href="zhuce.jsp" class="link-gray">[ 注册有惊喜 ]</a>
                </li>
                                <li>|</li>

                <li class="p-common-topsubnav">
                  <a href="gonggao1.jsp" class="link-gray">果园公告</a>
                    <!--<span class="tipscircle"></span>-->
                    <div class="p-common-noticelist hide">
                        <ul class="list-unstyled">
                                                        <li> <a href="gonggao1.jsp" target="_blank">全仓满赠商品及满赠金额变更</a>
                                <em>new</em>                            </li>
                                                        <li>
                                <a href="gonggao2.jsp" target="_blank">上海自建满赠商品变更</a>
                                <em>new</em>                            </li>
                                                        <li>
                                <a href="gonggao3.jsp" target="_blank">全仓满赠商品及满赠金额变更</a>
                                <em>new</em>                            </li>
                                                    </ul>
                        <div class="text-center"><a href="/notice" target="_blank">查看更多 ></a></div>
                    </div>
                </li>
                <li>|</li>
               
                <li>|</li>
                <li class="p-common-topsubnav">
                    <i class="iconfont">&#xe605;</i>
                    手机果园
                    <div class="p-common-topcode hide">
                        <div class="text-center">
                            <span class="VI-color2">下载果园app，</span>
                            即享果园特价商品
                        </div>
                        <dl class="clearfix">
                            <dt>
                                <img src="img/ewcode2.jpg" alt="" />
                            </dt>
                            <dd>
                                <a href="#//itunes.apple.com/us/app/tian-tian-guo-yuan-fruitday/id880977721" target="_blank">
                                    <img src="img/btn01.jpg" alt="" />
                                </a>
                                <a href="img/fruitday.apk" target="_blank">
                                    <img src="img/btn02.jpg" alt="" />
                                </a>
                            </dd>
                        </dl>
                        <dl class="clearfix">
                            <dt>
                                <img src="img/ewcode1.jpg" alt="" />
                            </dt>
                            <dd>
                                <span class="VI-color2">关注果园微信</span>
                                优惠信息实时掌握
                            </dd>
                        </dl>
                    </div>
                </li>
                <li>|</li
                        >
                <li>
                    <i class="iconfont">&#xe61a;</i> <b>182-5977-2030</b>
                </li>
            </ul>
        </div>
    </div>
        

  </body>
</html>
