<%@page import="com.dream.biz.impl.UserBizImpl" %>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
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
<link rel="stylesheet" href="css/dengluzhuce.css" type="text/css"></link>
    <link rel="stylesheet" type="text/css" href="css/usercenter-basics.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-donation.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-order-evaluate.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-order.css">
    <link rel="stylesheet" type="text/css" href="css/usercenter-tryeat.css">
    <link rel="stylesheet" type="text/css" href="css/order-online.css">
    
       
    
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
    <section class="p-component-usercenter clearfix">
        <div class="sidebar s_ani" >
            <span class="arrow"  id="arr"></span>
            <ul class="list-unstyled">
		<li><a href="user.jsp">我的账户</a></li>
	<li>
		<a href="OrdersServlet?todo=searchOrders2" >我的订单</a><a href="wodejifen.jsp" >我的积分</a>
		<a href="zhanghuyue.jsp" >账户余额</a>
		<a href="wodeyonghujuan.jsp" >我的优惠券</a>
		<a href="wodezengping.jsp" >我的赠品</a>
		  
	</li>
	<li>
		<a href="zaixianchongzhi.jsp" >在线充值</a>
		<a href="zhongzhifapiao.jsp" >充值发票</a>
		 <% User user1= (User)session.getAttribute("user"); 
                      UserBiz ub = new UserBizImpl();
                      User user=  ub.searchUser(user1.getuPhone());
                                    if(user.getuFlag().equals("2")){
                                    %>
                                   <a href="StoreServlet?todo=MyStore" >管理我的店面 </a>
                                     <%
                                    }else{
                                   %>  
                                    <a href="admin/kaidian.jsp" >申请开店</a>
                                    <%
                                    }
                                
                                %>
		
		
	</li>
	<li>
		<a href="UserServlet?todo=searchjibenziliao" >基本资料</a>
		<a href="mimaxiugai.jsp" >密码修改</a>
		<a href="shouhuodizhi.jsp" class="cur" >收货地址</a>
		<a href="tongzhishezhi.jsp" >通知设置</a>
	</li>
</ul>
        </div>
        <div class="main">
          <h6 class="people-info">收货人信息</h6>
          <div class="order-item">
            <ul class="list-unstyled clearfix order-item-addresslist" id="orderAddressList">
			 </ul>
<%-- 		 <script language="JavaScript">

var g_selProvince;
var g_selCity;
var Provinces=new Array(
new Array("110000","北京市"),
new Array("120000","天津市"),
new Array("130000","河北省"),
new Array("140000","山西省"),
new Array("150000","内蒙古自治区"),
new Array("210000","辽宁省"),
new Array("220000","吉林省"),
new Array("230000","黑龙江省"),
new Array("310000","上海市"),
new Array("320000","江苏省"),
new Array("330000","浙江省"),
new Array("340000","安徽省"),
new Array("350000","福建省"),
new Array("360000","江西省"),
new Array("370000","山东省"),
new Array("410000","河南省"),
new Array("420000","湖北省"),
new Array("430000","湖南省"),
new Array("440000","广东省"),
new Array("450000","广西壮族自治区"),
new Array("460000","海南省"),
new Array("500000","重庆市"),
new Array("510000","四川省"),
new Array("520000","贵州省"),
new Array("530000","云南省"),
new Array("540000","西藏自治区"),
new Array("610000","陕西省"),
new Array("620000","甘肃省"),
new Array("630000","青海省"),
new Array("640000","宁夏回族自治区"),
new Array("650000","新疆维吾尔自治区"),
new Array("710000","台湾省"),
new Array("810000","香港特别行政区"),
new Array("820000","澳门特别行政区")
);
var Citys=new Array(
new Array("110100","北京"),
new Array("120100","天津"),
new Array("130101","石家庄"),
new Array("130201","唐山"),
new Array("130301","秦皇岛"),
new Array("130701","张家口"),
new Array("130801","承德"),
new Array("131001","廊坊"),
new Array("130401","邯郸"),
new Array("130501","邢台"),
new Array("130601","保定"),
new Array("130901","沧州"),
new Array("133001","衡水"),
new Array("140101","太原"),
new Array("140201","大同"),
new Array("140301","阳泉"),
new Array("140501","晋城"),
new Array("140601","朔州"),
new Array("142201","忻州"),
new Array("142331","离石"),
new Array("142401","榆次"),
new Array("142601","临汾"),
new Array("142701","运城"),
new Array("140401","长治"),
new Array("150101","呼和浩特"),
new Array("150201","包头"),
new Array("150301","乌海"),
new Array("152601","集宁"),
new Array("152701","东胜"),
new Array("152801","临河"),
new Array("152921","阿拉善左旗"),
new Array("150401","赤峰"),
new Array("152301","通辽"),
new Array("152502","锡林浩特"),
new Array("152101","海拉尔"),
new Array("152201","乌兰浩特"),
new Array("210101","沈阳"),
new Array("210201","大连"),
new Array("210301","鞍山"),
new Array("210401","抚顺"),
new Array("210501","本溪"),
new Array("210701","锦州"),
new Array("210801","营口"),
new Array("210901","阜新"),
new Array("211101","盘锦"),
new Array("211201","铁岭"),
new Array("211301","朝阳"),
new Array("211401","锦西"),
new Array("210601","丹东"),
new Array("220101","长春"),
new Array("220201","吉林"),
new Array("220301","四平"),
new Array("220401","辽源"),
new Array("220601","浑江"),
new Array("222301","白城"),
new Array("222401","延吉"),
new Array("220501","通化"),
new Array("230101","哈尔滨"),
new Array("230301","鸡西"),
new Array("230401","鹤岗"),
new Array("230501","双鸭山"),
new Array("230701","伊春"),
new Array("230801","佳木斯"),
new Array("230901","七台河"),
new Array("231001","牡丹江"),
new Array("232301","绥化"),
new Array("230201","齐齐哈尔"),
new Array("230601","大庆"),
new Array("232601","黑河"),
new Array("232700","加格达奇"),
new Array("310100","上海"),
new Array("320101","南京"),
new Array("320201","无锡"),
new Array("320301","徐州"),
new Array("320401","常州"),
new Array("320501","苏州"),
new Array("320600","南通"),
new Array("320701","连云港"),
new Array("320801","淮阴"),
new Array("320901","盐城"),
new Array("321001","扬州"),
new Array("321101","镇江"),
new Array("330101","杭州"),
new Array("330201","宁波"),
new Array("330301","温州"),
new Array("330401","嘉兴"),
new Array("330501","湖州"),
new Array("330601","绍兴"),
new Array("330701","金华"),
new Array("330801","衢州"),
new Array("330901","舟山"),
new Array("332501","丽水"),
new Array("332602","临海"),
new Array("340101","合肥"),
new Array("340201","芜湖"),
new Array("340301","蚌埠"),
new Array("340401","淮南"),
new Array("340501","马鞍山"),
new Array("340601","淮北"),
new Array("340701","铜陵"),
new Array("340801","安庆"),
new Array("341001","黄山"),
new Array("342101","阜阳"),
new Array("342201","宿州"),
new Array("342301","滁州"),
new Array("342401","六安"),
new Array("342501","宣州"),
new Array("342601","巢湖"),
new Array("342901","贵池"),
new Array("350101","福州"),
new Array("350201","厦门"),
new Array("350301","莆田"),
new Array("350401","三明"),
new Array("350501","泉州"),
new Array("350601","漳州"),
new Array("352101","南平"),
new Array("352201","宁德"),
new Array("352601","龙岩"),
new Array("360101","南昌"),
new Array("360201","景德镇"),
new Array("362101","赣州"),
new Array("360301","萍乡"),
new Array("360401","九江"),
new Array("360501","新余"),
new Array("360601","鹰潭"),
new Array("362201","宜春"),
new Array("362301","上饶"),
new Array("362401","吉安"),
new Array("362502","临川"),
new Array("370101","济南"),
new Array("370201","青岛"),
new Array("370301","淄博"),
new Array("370401","枣庄"),
new Array("370501","东营"),
new Array("370601","烟台"),
new Array("370701","潍坊"),
new Array("370801","济宁"),
new Array("370901","泰安"),
new Array("371001","威海"),
new Array("371100","日照"),
new Array("372301","滨州"),
new Array("372401","德州"),
new Array("372501","聊城"),
new Array("372801","临沂"),
new Array("372901","菏泽"),
new Array("410101","郑州"),
new Array("410201","开封"),
new Array("410301","洛阳"),
new Array("410401","平顶山"),
new Array("410501","安阳"),
new Array("410601","鹤壁"),
new Array("410701","新乡"),
new Array("410801","焦作"),
new Array("410901","濮阳"),
new Array("411001","许昌"),
new Array("411101","漯河"),
new Array("411201","三门峡"),
new Array("412301","商丘"),
new Array("412701","周口"),
new Array("412801","驻马店"),
new Array("412901","南阳"),
new Array("413001","信阳"),
new Array("420101","武汉"),
new Array("420201","黄石"),
new Array("420301","十堰"),
new Array("420400","沙市"),
new Array("420501","宜昌"),
new Array("420601","襄樊"),
new Array("420701","鄂州"),
new Array("420801","荆门"),
new Array("422103","黄州"),
new Array("422201","孝感"),
new Array("422301","咸宁"),
new Array("422421","江陵"),
new Array("422801","恩施"),
new Array("430101","长沙"),
new Array("430401","衡阳"),
new Array("430501","邵阳"),
new Array("432801","郴州"),
new Array("432901","永州"),
new Array("430801","大庸"),
new Array("433001","怀化"),
new Array("433101","吉首"),
new Array("430201","株洲"),
new Array("430301","湘潭"),
new Array("430601","岳阳"),
new Array("430701","常德"),
new Array("432301","益阳"),
new Array("432501","娄底"),
new Array("440101","广州"),
new Array("440301","深圳"),
new Array("441501","汕尾"),
new Array("441301","惠州"),
new Array("441601","河源"),
new Array("440601","佛山"),
new Array("441801","清远"),
new Array("441901","东莞"),
new Array("440401","珠海"),
new Array("440701","江门"),
new Array("441201","肇庆"),
new Array("442001","中山"),
new Array("440801","湛江"),
new Array("440901","茂名"),
new Array("440201","韶关"),
new Array("440501","汕头"),
new Array("441401","梅州"),
new Array("441701","阳江"),
new Array("450101","南宁"),
new Array("450401","梧州"),
new Array("452501","玉林"),
new Array("450301","桂林"),
new Array("452601","百色"),
new Array("452701","河池"),
new Array("452802","钦州"),
new Array("450201","柳州"),
new Array("450501","北海"),
new Array("460100","海口"),
new Array("460200","三亚"),
new Array("510101","成都"),
new Array("513321","康定"),
new Array("513101","雅安"),
new Array("513229","马尔康"),
new Array("510301","自贡"),
new Array("500100","重庆"),
new Array("512901","南充"),
new Array("510501","泸州"),
new Array("510601","德阳"),
new Array("510701","绵阳"),
new Array("510901","遂宁"),
new Array("511001","内江"),
new Array("511101","乐山"),
new Array("512501","宜宾"),
new Array("510801","广元"),
new Array("513021","达县"),
new Array("513401","西昌"),
new Array("510401","攀枝花"),
new Array("500239","黔江土家族苗族自治县"),
new Array("520101","贵阳"),
new Array("520200","六盘水"),
new Array("522201","铜仁"),
new Array("522501","安顺"),
new Array("522601","凯里"),
new Array("522701","都匀"),
new Array("522301","兴义"),
new Array("522421","毕节"),
new Array("522101","遵义"),
new Array("530101","昆明"),
new Array("530201","东川"),
new Array("532201","曲靖"),
new Array("532301","楚雄"),
new Array("532401","玉溪"),
new Array("532501","个旧"),
new Array("532621","文山"),
new Array("532721","思茅"),
new Array("532101","昭通"),
new Array("532821","景洪"),
new Array("532901","大理"),
new Array("533001","保山"),
new Array("533121","潞西"),
new Array("533221","丽江纳西族自治县"),
new Array("533321","泸水"),
new Array("533421","中甸"),
new Array("533521","临沧"),
new Array("540101","拉萨"),
new Array("542121","昌都"),
new Array("542221","乃东"),
new Array("542301","日喀则"),
new Array("542421","那曲"),
new Array("542523","噶尔"),
new Array("542621","林芝"),
new Array("610101","西安"),
new Array("610201","铜川"),
new Array("610301","宝鸡"),
new Array("610401","咸阳"),
new Array("612101","渭南"),
new Array("612301","汉中"),
new Array("612401","安康"),
new Array("612501","商州"),
new Array("612601","延安"),
new Array("612701","榆林"),
new Array("620101","兰州"),
new Array("620401","白银"),
new Array("620301","金昌"),
new Array("620501","天水"),
new Array("622201","张掖"),
new Array("622301","武威"),
new Array("622421","定西"),
new Array("622624","成县"),
new Array("622701","平凉"),
new Array("622801","西峰"),
new Array("622901","临夏"),
new Array("623027","夏河"),
new Array("620201","嘉峪关"),
new Array("622102","酒泉"),
new Array("630100","西宁"),
new Array("632121","平安"),
new Array("632221","门源回族自治县"),
new Array("632321","同仁"),
new Array("632521","共和"),
new Array("632621","玛沁"),
new Array("632721","玉树"),
new Array("632802","德令哈"),
new Array("640101","银川"),
new Array("640201","石嘴山"),
new Array("642101","吴忠"),
new Array("642221","固原"),
new Array("650101","乌鲁木齐"),
new Array("650201","克拉玛依"),
new Array("652101","吐鲁番"),
new Array("652201","哈密"),
new Array("652301","昌吉"),
new Array("652701","博乐"),
new Array("652801","库尔勒"),
new Array("652901","阿克苏"),
new Array("653001","阿图什"),
new Array("653101","喀什"),
new Array("654101","伊宁"),
new Array("710001","台北"),
new Array("710002","基隆"),
new Array("710020","台南"),
new Array("710019","高雄"),
new Array("710008","台中"),
new Array("211001","辽阳"),
new Array("653201","和田"),
new Array("542200","泽当镇"),
new Array("542600","八一镇"),
new Array("820000","澳门"),
new Array("810000","香港")
);
function FillProvinces(selProvince)
{
selProvince.options[0]=new Option("请选择","000000");
for(i=0;i<Provinces.length;i++)
{
selProvince.options[i+1]=new Option(Provinces[i][1],Provinces[i][0]);
}
selProvince.options[0].selected=true;
selProvince.length=i+1;
}
function Province_onchange()
{
//alert("22begin");
FillCitys(g_selCity,g_selProvince.value);
}
function FillCitys(selCity,ProvinceCode)
{
//if the province is a direct-managed city, like Beijing, shanghai, tianjin, chongqin,hongkong, macro
//need not "请选择选项"
if(ProvinceCode=="110000"||ProvinceCode=="120000"||ProvinceCode=="310000"
||ProvinceCode=="810000"||ProvinceCode=="820000"||ProvinceCode=="500000")
count=0;
else
{selCity.options[0]=new Option("请选择",ProvinceCode);
count=1;}
//因为有‘请选择’，所以多个1
for(i=0;i<Citys.length;i++)
{
if(Citys[i][0].toString().substring(0,2)==ProvinceCode.substring(0,2))
{
selCity.options[count]=new Option(Citys[i][1],Citys[i][0]);
count=count+1;
}
}
selCity.options[0].selected=true;
selCity.length=count;
}
function InitCitySelect(selProvince,selCity)
{
//alert("begin");
g_selProvince=selProvince;
g_selCity=selCity;
selProvince.onchange=Function("Province_onchange();");
FillProvinces(selProvince);
Province_onchange();
}
//-->
</script>
<form name="profile" method="post" action="UserServlet?todo=addAddress">
<SELECT id=province size=1 name=province>
<OPTION selected></OPTION>
</SELECT>
<SELECT id=city size=1 name=city>
<OPTION selected></OPTION>
</SELECT>
<SCRIPT language=javascript>
InitCitySelect(document.profile.province,document.profile.city);
</SCRIPT>
<br/><br/>
<input name="address" value="" type="text" width="200px" height="100px" >
<br/><br/>
<input id="dengluzhuce1" value="新增收货地址" type="submit">
<span>
</span>
</form>

 --%>
<% session.setAttribute("user", user); %>
  <c:forTokens items="${user.uAddress}" delims="@" var="address" varStatus="i">
 收货地址${i.index+1}:&nbsp; ${address}<br/><br/>
  </c:forTokens>
  <hr style='border:solid' color='#CCCCCC' size='0.1'/>
<form name="profile" method="post" action="UserServlet?todo=addAddress">
<input name="address" value="" type="text" width="300px" height="100px" placeholder="请输入新地址">
<br/><br/>
<input id="dengluzhuce1" value="新增收货地址" type="submit">          
   </form>
          </div>
        </div>
    </section>
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
<script src="http://www.fruitday.com/js/require.js" data-main="http://www.fruitday.com/js/main"></script>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
</html>	
    <div id="p-dialog">

    </div>
<body>s</body>
<script>
    $(function(){
        addAddress();//新增收货地址
        modifyAddress(); //修改收货地址
        deleteAddress();//删除收货地址
        setDefault();  //设置默认地址
        chooseAddress();//选择地址
    });

    function diaClose(){
        $('#p-dialog').removeClass().addClass('dialog-close').delay(200).fadeOut(100);
    }

	function checkboxOnclick(checkbox){
		if ( checkbox.checked == true ){
            $("#def").val(1);
		}else{
            $("#def").val(0);
		}
	}

    function addressResister(sta){
        var $s=$('#submit'),
                $n=$('#name'),
                $p=$('#provice'),
                $c=$('#city'),
                $a=$('#area'),
                $d=$('#detailAddr'),
                $t=$('#tel');
				$ch=$('#del');
                //$ph=$('#phone');


        $s.on('click', function(e){

            var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
            var b=true, _li;
            var _n=$n.val(), _p=$p.val(), _c=$c.val(), _a=$a.val(), _d=$d.val(), _t=$t.val();

            if(_n==""){
                $n.addClass('hasError');
                b = false;
            }
            if(_p==""){
                $p.parent().addClass('hasError');
                b = false;
            }
            if(_c==""){
                $c.parent().addClass('hasError');
                b = false;
            }
            if(_a==""){
                $a.parent().addClass('hasError');
                b = false;
            }
            if(_d==""){
                $d.addClass('hasError');
                b = false;
            }
            if(!myreg.test(_t)){
                $t.addClass('hasError');
                b = false;
            }

            if (!b) {
                e.preventDefault()
            } else {
                if(sta=="new"){
                    var data = {
                        'name':_n,
                        'province':_p,
                        'city':_c,
                        'area':_a,
                        'address':_d,
                        'mobile':_t,
                        'default':$("#def").val(),
                    };
                    var url = "/ajax/order/addAddr";
                    var ares = ajaxAddArea(data,url);
                    if(ares!=0){
                         $("#orderAddressList").load(location.href + " #orderAddressList>*");                  
                    }
                    diaClose()
                }
                if(sta=="modify"){
                    var data = {
                        'name':_n,
                        'province':_p,
                        'city':_c,
                        'area':_a,
                        'address':_d,
                        'mobile':_t,
                        'default':$("#def").val(),
                        'address_id':$("#curr_addr_id").val(),
                    };
                    var url = "/ajax/order/updateAddr";
                    var ares = ajaxAddArea(data,url);
                    if(ares!=0){                   
                        $("#orderAddressList").load(location.href + " #orderAddressList>*");    
                    }
                    diaClose()
                }
                if(sta="invoice"){
                    diaClose();
                }
            }
        });
        $('#name, #detailAddr, #tel, #phone').on('focus', function(){
            $(this).removeClass('hasError');
        })
    }
    function ajaxAddArea(jdata,url){
            var res;
             $.ajax({
                  async:false,
                  type: 'POST',
                  url: url,
                  data: jdata,
                  success: function(data) {
                        if(data.code==200){
                            res = data.msg;
                        }else{
                            res = 0;
                        }
                  },
                  dataType: 'json'
            });
             return res;
    }
    function ajaxGetArea(pid, obj){
            var area_li = [];
            var data = {'pid':pid};
            $.ajax({
                async:false,
                type: 'POST',
                beforeSend : function(){
                    if(obj.parents('.inpSel').next('.inpSel').children('input').attr('id')=='city') {
                        $("#city").val("");
                        $("#city").next("span").jsp("市");
                        $("#area").val("");
                        $("#area").next("span").jsp("区／县");
                        $("#area").next("ul").jsp("");
                        $("#area").parent().addClass('hide')
                    }else if(obj.parents('.inpSel').next('.inpSel').children('input').attr('id')=='area'){
                        $("#area").val("");
                        $("#area").next("span").jsp("区／县");
                    }
                },
                data: data,
                url: "/ajax/order/getArea/",
                success : function(data){
                    var li = "";
                    var n = 0;
                    if(data.code==200){
                        $.each(data.msg,function(key, val){
                            li = li+"<li data-id="+val.id+">"+val.name+"</li>";
                            n++;
                        })
                        area_li[0] = n;
                        area_li[1] = li;
                    }
                },
                dataType: 'json'
            })
            return area_li;
    }

    function simulateSelect(){
        $('.inpSel').on('click', function(e){
            e.stopPropagation();
            var $this=$(this);
            if(!$this.hasClass('hide')){
                $this.addClass('act').removeClass('hasError').
                        find('ul').slideDown(200).parent().siblings().removeClass('act').find('ul').slideUp(100).end().end()
                        .find('li').on('click', function(e){
                            e.stopPropagation();
                            var t=$(this).text();
                            var pid = $(this).attr('data-id');
                            var area_li = ajaxGetArea(pid, $(this));
                            $(this).parents('.inpSel').next('.inpSel').find('ul').jsp(area_li[1]).find('li').length;
                            if($this.find('li').length==1){
                                $(this).addClass('cur').parent().slideUp(100).prev('span').text(t).prev('input').val(pid).parent().removeClass('act');
                            }else{
                                $(this).addClass('cur').siblings().removeClass('cur').parent().slideUp(100).prev('span').text(t).prev('input').val(pid).parent().removeClass('act');
                            }
                            $(this).parents('.inpSel').next('.inpSel').removeClass('hide');
                            $this.find('li').off('click'); 
                        });
            }

        });
        $('body').on('click', function(){
            $('.inpSel').removeClass('act').find('ul').slideUp(100);
        });
    }

    function addAddress(){
        $('#newAddress').on('click', function(){
            $.ajax({
                url: "/order/newaddr"
            }).done(function(data) {
                $('#p-dialog').empty().append(data).fadeIn(100).removeClass().addClass('dialog-open');
                simulateSelect();
                addressResister("new");
                $('.dialog-til>span').on('click', diaClose);
            });
       })
    }

    function modifyAddress(){
        $('#orderAddressList').delegate('.modifyAddress', 'click', function(){
            var addr_id = $(this).parent().find('input[name=addr_id]').val();
            $.ajax({
                type: 'GET',
                url: "/order/modifyaddr/"+addr_id,
                dataType: 'html'
            }).done(function(data) {
                $('#p-dialog').empty().append(data).fadeIn(100).removeClass().addClass('dialog-open');
                simulateSelect();
                addressResister("modify");
                $('.dialog-til>span').on('click', diaClose);
            })
        });
    }

    function deleteAddress(){
        $('#orderAddressList').delegate('.deleteAddress', 'click', function(){
            var addr_id = $(this).parent().find('input[name=addr_id]').val();
            $.ajax({
                type: 'GET',
                url: "/order/deleteaddr/"+addr_id,
                dataType: 'html'
            }).done(function(data) {
                $('#p-dialog').empty().append(data).fadeIn(100).removeClass().addClass('dialog-open');

                $('.dialog-til>span').on('click', diaClose);
                $('#addr_del_cancle').on('click', diaClose);
                $("#addr_del_submit").on('click', function(){
                    var data = {address_id: $(this).parent().find('input[name=addr_id]').val()}
                    $.ajax({
                        type: 'POST',
                        data: data,
                        url: "/ajax/order/delAddr/",
                        success : function(data){
                            if(data.code==200){
                                diaClose();
                                $("#addr_li_"+data.msg).remove();
                            }
                        },
                        dataType: 'json'
                    })
                })
            })
        });
    }
    function ajaxChooseAddr(data){
            var res;
             $.ajax({
                  async:false,
                  type: 'POST',
                  url: '/ajax/order/choseAddr',
                  data: data,
                  success: function(data) {
                        res = data;
                  },
                  dataType: 'json'
            });
             return res;        
    }

    function setDefault(){
      var defaultVal=$(".tag").text();
      // console.log(val);
      $(".operate a:first-child").click(function(){
        if($(this).text()!=defaultVal){
          var addr_id = $(this).parent().find('input[name=addr_id]').val();
          $.ajax({
                  async:false,
                  type: 'GET',
                  url: '/ajax/order/defaultAddr/'+addr_id,
                  success: function(data) {
					   if(data.code == 200){
						   var val=$(this).text();
						   $('.tag').removeClass('tag').text('设为默认地址');
                           $("#addr_li_"+addr_id).find('.flags').addClass("tag").text(defaultVal);
					   }else{
                           gdialog_info( data.msg );
					   }
                  },
                  dataType: 'json'
          });
        }

      });
    }

    //地址选择,多级联动等
    function chooseAddress(){
        $('#orderAddressList').delegate('.tag', 'click', function(){
            var data = {'address_id':$(this).parent().find('input[name=addr_id]').val()};

            var cres = ajaxChooseAddr(data);
            if(cres.code == 200){
                $(this).parent().addClass('cur').siblings().removeClass('cur');
            }else{
                gdialog_info(cres.msg);
            }
        });
    }
</script>

</html>
 