<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

   
   <link rel="stylesheet" type="text/css" href="css/usercenter-basics.css">
   <link rel="stylesheet" type="text/css" href="css/usercenter-donation.css">
   <link rel="stylesheet" type="text/css" href="css/usercenter-order.css">
   <link rel="stylesheet" type="text/css" href="css/usercenter-order-evaluate.css">
   <link rel="stylesheet" type="text/css" href="css/usercenter-tryeat.css">
   <link rel="stylesheet" type="text/css" href="css/order-online.css">
   <script type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script>    
    
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
	<li><a href="user.jsp"  >我的账户</a></li>
	<li>
		<a href="OrdersServlet?todo=searchOrders2" >我的订单</a><a href="wodejifen.jsp" >我的积分</a>
		<a href="zhanghuyue.jsp" >账户余额</a>
		<a href="wodeyonghujuan.jsp" >我的优惠券</a>
		<a href="wodezengping.jsp" >我的赠品</a>
		<a href="/web/card_change" target="_blank">券卡兑换</a>
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
		<a href="UserServlet?todo=searchjibenziliao" class="cur">基本资料</a>
		<a href="mimaxiugai.jsp" >密码修改</a>
		<a href="shouhuodizhi.jsp" >收货地址</a>
		<a href="tongzhishezhi.jsp" >通知设置</a>
	</li>
</ul>
        </div>
        
      
      
        <div class="main">
          <h6 class="basic">基本资料</h6>
          <form action="UserServlet?todo=updateUser&&uid=${user.uId }"  method="post">
            <div class="content">
              <ul>
                <li class="pic" id="pic">
                  <span class="pull-left">当前头像：</span>
                  <div class="pull-left">
                    <img src="img/default_userpic.png" alt="">
                  </div>
              <!--     <a href="javascript:;" class="pull-left">修改</a>  --> 
                </li>
                <li class="name" id="name">
                  <span class="pull-left">昵称：</span>
                  <input name="uName" type="text" disabled="disabled" value="${user.uName} " class="pull-left nickname">
                  <span class="prompt pull-left">昵称必须小于25个字符</span>
                </li>
                <li class="sex" id="sex">
                  <span class="pull-left">性别:</span>
                  <div class="pull-left csex">
                 男<input name="sex" type="radio" value="男">女<input name="sex" type="radio" value="女">
              <!--      <input name="sex" type="text"  value="${us.sex} " class="pull-left nickname"> 
                      <i class="cur"  sid="0">男</i><label>${us.sex}</label>   
                     <i  sid="1"></i><label>女</label>
                    <i  sid="2"></i><label>保密</label>
                    --> 
                  </div>
                </li>
                <li class="tel mail" id="birth">
                <span class="pull-left">生日：</span>
                <input name="uBir" type="text"  value="${user.uBir}"
										onclick="WdatePicker()" class="textfield" />
                <span class="pull-left"></span>
             <!--      <input name="uBir" type="text" value="${user.uBir}" class="pull-left nickname"> --> 
           <!--  <span>生日：</span>
                 <div class="inpSel">
                      <input type="hidden" value="1970" id="year">
                      <span>1970</span>
                      <ul class="list-unstyled show-year" >

                      </ul>
                  </div>
                  <div>年</div>
                  <div class="inpSel">
                      <input type="hidden" value="01" id="month">
                      <span>01</span>
                      <ul class="list-unstyled show-month" >
                      </ul>
                  </div>
                  <div>月</div>
                  <div class="inpSel sel1">
                      <input type="hidden" value="01" id="date">
                      <span>01</span>
                      <ul class="list-unstyled show-day">
                      </ul>
                  </div>
                  <div>日</div>
                  <span class="prompt">请选择生日</span>
                -->
                </li>
                <li class="tel" id="tel">
                  <span class="pull-left">手机：</span>
                  <input name="uPhone" type="text" class="pull-left" disabled="disabled" value="${user.uPhone}">
           <!--      <a href="javascript:;" class="pull-left">更换手机</a>  -->
                </li>
                <li class="tel mail" id="mail">
                  <span class="pull-left">邮箱：</span>
                  <input name="uMail" type="text" class="pull-left" value="${user.uMail}" id="email">
          <!--        <a href="javascript:;" class="pull-left">更换邮箱</a> -->
                  <span class="pull-left"></span>
                  <li class="tel mail" id="mail">
                  <span class="pull-left">地址：</span>
                  <input name="uAddress" type="text" class="pull-left" value="${user.uAddress}" id="email">
          <!--        <a href="javascript:;" class="pull-left">更换邮箱</a> -->
                  <span class="pull-left"></span>
                </li>
              </ul>
              <p class="test">邮件已发送，请在邮箱中完成验证</p>
              <p class="test-ok">已验证</p>
			  <p class="ftest">邮件发送失败，请检查邮箱</p>
              <p class="test-fail">不能验证</p>
       <!--      <a type="submit" class="submit-box">确认提交</a>    -->
                                   <input type="submit"  class="submit-box" value="修改" >
            </div>
          </form>
        </div>
        
        
    </section>


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

</html>
<div id="p-dialog" >
</div>
</body>
<script type="text/javascript">
  $(function(){
    change(".tel input");//更改号码
    change(".mail input");//更改邮箱
    change(".name input");//更改昵称
    sexSelect();//选择性别
    simulateSelect();// 选择生日
    checkBasic();//验证基本资料
    checkMail();//更换邮箱验证
	setYmd();//年月日
  });
  function change(obj){
     $(obj).on("blur",function(){
        var val=$(this).val();
        $(this).attr("value",val);
        // console.log(val);
     });
  }

  function sexSelect(){
    $(".sex div i").on("click",function(){
      $(this).addClass("cur").siblings("i").removeClass("cur");
    });
  }

  function simulateSelect(){
      $('.inpSel').on('click', function(e){
          e.stopPropagation();
          var $this=$(this);
          $this.siblings(".prompt").hide();
          if(!$this.hasClass('disabl')){
              $this.addClass('act').removeClass('hasError').
                      find('ul').slideDown(200).parent().siblings().removeClass('act').find('ul').slideUp(100).end().end()
                      .find('li').on('click', function(e){
                          e.stopPropagation();
                          var t=$(this).text();

                          if($this.find('li').length==1){
                              $(this).addClass('cur').parent().slideUp(100).prev('span').text(t).prev('input').val(t).parent().removeClass('act');
                          }else{
                              $(this).addClass('cur').siblings().removeClass('cur').parent().slideUp(100).prev('span').text(t).prev('input').val(t).parent().removeClass('act');

                          }
                           $(this).parents('.inpSel').next('.inpSel').removeClass('disabl');
                          $this.find('li').off('click'); 
                      });
          }

      });
      $('body').on('click', function(){
          $('.inpSel').removeClass('act').find('ul').slideUp(100);
      });
    }

    function diaClose(){
      $('#p-dialog').removeClass().addClass('dialog-close').delay(200).fadeOut(100);
    }

    function checkBasic(){
      var $n=$("#name input"),
          $b=$("#birth input"),
          $y=$("#year"),
          $m=$("#month"),
          $d=$("#date"),
          $t=$("#tel input"),
          $ma=$("#mail input");

      $(".submit-box").on("click",function(e){
        var mailReg=/^\w+@[a-z0-9\-]+(\.[a-z]{2,6}){1,2}$/i;
        var telReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
        var b=true;
        var _n=$n.val(),_b=$b.val(),_y=$y.val(),_m=$m.val(),_d=$d.val(),_t=$t.val(),_ma=$ma.val();
        if(_n==""){
            $n.addClass("hasError");
            b=false;
        }
        if(_b==""){
            $b.addClass("hasError");
            b=false;
        }
        if(_y==""){
            $y.parent().addClass("hasError");
            $("#birth").children(".prompt").show();
            b=false;
        }
        if(_m==""){
            $m.parent().addClass("hasError");
            $("#birth").children(".prompt").show();
            b=false;
        }
        if(_d==""){
            $d.parent().addClass("hasError");
            $("#birth").children(".prompt").show();
            b=false;
        }
        if(_t==""){
            $t.addClass("hasError");
            b=false;
        }
        if(_ma==""){
            $ma.addClass("hasError");
            b=false;
        }
        if(_n.length>=25){
          $("#name").children(".prompt").show();
          $n.addClass("hasError");
          b=false;
        }
        if(!mailReg.test(_ma)){
          $ma.addClass("hasError");
          b=false;
        }
        if(!telReg.test(_t)){
          $t.addClass("hasError");
          b=false;
        }
        
        if(!b){
          e.preventDefault();
        }else{
    		  var nickname = $(".nickname").val();
    		  var birthday_y = $("#year").val();
    		  var birthday_m = $("#month").val();
    		  var birthday_d = $("#date").val();
			  var email = $("#email").val();
    		  var sex = $(".csex").find('.cur').attr("sid");
    		  $.ajax({
    			  type: 'POST',
    			  url: "/ajax/user/updateBasic/",
    			  data: {nickname:nickname,birthday_y:birthday_y,birthday_m:birthday_m,birthday_d:birthday_d,email:email,sex:sex},
    			  dataType: 'json'
    		  }).done(function(data) {
    			  //gdialog_info(data.msg);
    			 // window.location.href="/user/basics";
            if(data.code == 200)
            {
                $.ajax({
                    type: 'GET',
                    url: "/user/basicsMsg/",
                    dataType: 'html'
                }).done(function(data){
                    $('#p-dialog').empty().append(data).fadeIn(100).removeClass().addClass('dialog-open');
                    $("#submit").on("click",diaClose);
                    $('.dialog-til>span').on('click', diaClose);
                });
            }
            else
            {
                gdialog_info(data.msg);
            }
    		  })
        }
      }); 
      $('#name input ,#tel input, #mail input').on('focus', function(){
          $(this).removeClass('hasError');
          $(this).siblings(".prompt").hide();
          $(".test").hide();
          $(".test-ok").hide();
      })
    }
    function checkMail(){
      var mailReg=/^\w+@[a-z0-9\-]+(\.[a-z]{2,6}){1,2}$/i;
      $("#mail a").on("click",function(){
		  $(".test").hide();
          $(".test-ok").hide();
		  var email = $("#email").val();
		  $.ajax({
			  type: 'POST',
			  url: "/ajax/user/sendEmail/",
			  data: {email:email},
			  dataType: 'json'
		  }).done(function(data) {
			  if(!mailReg.test($("#mail input").val()) ||$("#mail input").val()==""){
				$("#mail input").addClass("hasError");
			  }else{
				if( data.code == '200'){
					$(".test").show('200', function() {

					   setTimeout(function(){
						 $(".test").hide();
						 $(".test-ok").show();
					   }, 1500);
					});
				}else{
				    $(".ftest").show('200', function() {
					   setTimeout(function(){
						 $(".ftest").hide();
						 $(".test-fail").show();
					   }, 1500);
					});
				}
			  }
		  })

      });
      $("#mail input").on("focus",function(){
          $(this).removeClass("hasError");
      });
    }

	function setYmd(){

		var yearNow = new Date().getFullYear();
        var yearStr = '';
		var monthStr = '';
		var dayStr = '';

		for (var i = yearNow; i >= 1900; i--) {
			yearStr+= "<li>" + i + "</li>";
		}
		$(".show-year").jsp(yearStr);

		// 月份列表
		for (var i = 1; i <= 12; i++) {
			monthStr+= "<li>" + p(i) + "</li>";
		}
		$(".show-month").jsp(monthStr);
	
			// 月份列表
		for (var i = 1; i <= 31; i++) {
			dayStr+= "<li>" + p(i) + "</li>";
		}
		$(".show-day").jsp(dayStr);
	}

    function p(s) {
        return s < 10 ? '0' + s: s;
    }
</script>
</html>
 