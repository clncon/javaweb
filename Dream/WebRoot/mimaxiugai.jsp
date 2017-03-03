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

           
    
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="http://www.fruitday.com/css/style-ie.css">
    <link rel="stylesheet" href="http://www.fruitday.com/css/style-ie1.css">
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

    <!-- GA -->
    <script  type="text/javascript" >
    var ht=null;
   function   checkpass(password1){
      // password1=document.getElementById("password1").value;
       
      // alert(password1);
       var  msg=document.getElementById("msg");
          var zPwd=/^[a-zA-Z]\w{5,17}$/   ;
     //     var zPwd="123";
      // alert("dfr");
        if(password1==""){
        //alert(1);
           msg.childNodes[0].nodeValue = "请输入正确密码！";
            //msg.innerText="123";
          //  form1.password1.focus;
			return false;
         }else if(! zPwd.test(password1)){
          // alert(12);
           msg.childNodes[0].nodeValue = "请输入正确格式密码！";
           document.getElementById("password1").value="";
           form1.password1.focus;
          
           return false;
         }
        
       //ajax
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
	
		ht.onreadystatechange = callyh; //回调函数
		//以GET方式发送
		//ht.open("GET","servlet/checkuser?userId="+userId,true); //true异步
		//ht.send();//发送请求到服务器端

		ht.open("post", "UserServlet?todo=mimaxiugaiajax&password1="+password1	, true);
		ht.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
		ht.send(); // ?参数 

	return true;
           }
        function callyh(){
        if(ht.readyState==4){   //接收完毕
           if(ht.status==200){    //OK
       //    alert(ht.responseText);
              var msg=document.getElementById("msg");
              if(ht.responseText=="true"){
              msg.childNodes[0].nodeValue ="";
               // idd.innerText="";
              }else { 
              //idd.innerText="输入的密码与原密码不匹配，请重新输入！";
              msg.childNodes[0].nodeValue ="输入的密码与原密码不匹配，请重新输入！";
             // alert("dfr");
    			}

			}

		}
	}
    </script>
    <script type="text/javascript">
    function   checkpass1(password2){
      // password1=document.getElementById("password1").value;
       
      // alert(password2);
       var  msg=document.getElementById("msg1");
          var zPwd=/^[a-zA-Z]\w{5,17}$/   ;
     //     var zPwd="123";
      // alert("dfr");
        if(password2==""){
        //alert(1);
           msg.childNodes[0].nodeValue = "请输入正确密码！";
            //msg.innerText="123";
          //  form1.password1.focus;
			return false;
         }else if(! zPwd.test(password2)){
          // alert(12);
           msg.childNodes[0].nodeValue = "请输入正确格式密码！";
           document.getElementById("password2").value="";
           form1.password2.focus;
          
           return false;
         }else{
            msg.childNodes[0].nodeValue ="";
             return true;
         }
    }
    function checknewpass(up){
  var  password2=document.getElementById("password2").value;
 // alert(up);
      var msg=document.getElementById("msg2");
         if(up!=password2){
           // msg.innerText="两次密码不相等！！！";
           msg.childNodes[0].nodeValue ="两次密码不相等！！！";
         document.getElementById("password3").value="";
           // document.form1.password3.focus();
            return false;
         }else{
           msg.childNodes[0].nodeValue ="";
           return true;
         }
    
    }
    
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
		<a href="wodedingdan.jsp"  >我的订单</a>
		<a href="wodejifen.jsp" >我的积分</a>
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
		<a href="UserServlet?todo=searchjibenziliao" >基本资料</a>
		<a href="mimaxiugai.jsp" class="cur">密码修改</a>
		<a href="shouhuodizhi.jsp" >收货地址</a>
		<a href="tongzhishezhi.jsp" >通知设置</a>
	</li>
</ul>
        </div>
        <form  name="form1"  action="UserServlet?todo=mimaxiugai"  method="post">
        <div class="main">
          <h6 class="basic">&nbsp;&nbsp;&nbsp;&nbsp;密码修改</h6>  
          <div class="detail changeTel password-box">
            <div>
              <label class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;原密码:</label>
              <input  type="password"   onblur=" checkpass(this.value)"  class="pull-left "  placeholder="请输入原密码"   id="password1" name="password1"   />
            <label   style="color:red;font-size:12px; " id="msg"  >&nbsp;</label>
            </div>
             
            <div>
              <label class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;新密码:</label>
              <input type="password" placeholder="字母开头在6~18字符"   class="pull-left " id="password2" name="password2" onblur=" checkpass1(this.value)">
              <label   style="color:red;font-size:12px; " id="msg1"  >&nbsp;</label>
            </div>
            
            <div>
              <label class="pull-left newsec">&nbsp;&nbsp;&nbsp;&nbsp;确认密码:</label>
              <input type="password" placeholder="请确认你的密码"  class="pull-left " id="password3" name="password3"  onblur="checknewpass(this.value)" >
              <label   style="color:red;font-size:12px; " id="msg2"  >&nbsp;</label>
            </div>
           <!--   <a href="UserServlet?todo=mimaxiugai" class="next-step pull-left">确认提交</a>-->
            <label class="pull-left newsec">&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="submit"  class="pull-left"  value="确认提交">
            <p class="prompt pull-left overshow">修改成功</p>
          </div>
          </form>
        </div>
    </section>
<!--底部 -->


<jsp:include page="console_element/buttom.jsp"></jsp:include>




</body>

</html>
</body>

</html>
 