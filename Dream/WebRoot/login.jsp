<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
   <link rel="stylesheet" type="text/css" href="css/dengluzhuce.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
  <script type="text/javascript">
  
  	function checkUser(uPhone) {
	var msg = document.getElementById("checkMsg");
		var zPhone= /^0?1[3|4|5|8][0-9]\d{8}$/;
		//var zPhone="123123123";
		if (uPhone == "" ) {
			//alert("请输入正确账号！");
			msg.childNodes[0].nodeValue = "请输入正确账号！";
			form1.uPhone.focus;
			return false;
		}else if (! zPhone.test(uPhone)){
		    form1.uPhone.focus;
		    msg.childNodes[0].nodeValue = "您输入的手机号格式不正确，请输入正确账号！";
		    document.getElementById("uPhone").value="";
		    		      return false;
		}
		}
		
		
    function checkPwd(uPwd){
    var msg = document.getElementById("checkMsg1");
        //var uPwd= document.getElementById('uPwd');
        var zPwd=/^[a-zA-Z]\w{5,17}$/    //以字母开头，长度在6~18之间，只能包含字母、数字和下划线
         //var zPwd="123";
       
         if(uPwd ==""){
            msg.childNodes[0].nodeValue = "请输入正确密码！";
            form1.uPwd.focus;
			return false;
         }else if(! zPwd.test(uPwd)){
          
           msg.childNodes[0].nodeValue = "请输入正确格式密码！";          
           form1.uPwd.focus;
           document.getElementById("uPwd").value="";
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
        <div class="content">
        <nav class="navbar ">
            <div class="container-fluid">
               
                <div  style="padding:0px;float:left"> <a href="index.jsp"><img src="img/login5.png.png" /></a> </div>
                <div class="collapse navbar-collapse" >
                                                </div>
            </div>
        </nav>
    </div>
</section>
<form action="UserServlet?todo=loginRand" method="post" name="form1">
  <div class="w-1000 w-750 pt-50">
    <p class="member">会员登录</p>
    <div class="login-sec clearfix">
      <div class="login-left pull-left">
        <img src="img/huiyuan.jpg" width="500" height="400">
        <div class="login">
          <a href="zhuce.jsp" class="btn btn-primary btn-lg active login-btn" role="button" title="点击此按钮，登录会员账号"> 会员注册></a>
        </div>
      </div>       
      <div class="login-right pull-right">
        <div class="login-form">
        
            <ul>
              <li class="clearfix log-number">
                <div class="text02 all pull-left">
                  <span class="mobile">手机号</span>
                </div>
                <div class="send-yanzm pull-left">
                  <input type="text" placeholder="请输入手机号" class="form-control" id="uPhone" name="uPhone" onblur="checkUser(this.value) ">
                  <span id="checkMsg" style="color:red;font-size:12px;">&nbsp;</span>
                </div> 
              </li>

              <li class="clearfix log-pass">
                <div class="text04 all pull-left">
                 <span class="code">密码</span>
                </div>
                <div class="password pull-left">
                  <input type="password" placeholder="请输入6-20位号码字符" class="form-control" id="uPwd" name="uPwd" clientidmode="Static" onblur="checkPwd(this.value)">
                 <span id="checkMsg1" style="color:red;font-size:12px;">&nbsp;</span>
                </div>
              </li>
                
                <li class="clearfix yan-z">
                    <div class="text01 all pull-left">
                      <span class="form1">验证码</span>
                    </div>

                    <div class="yanzm pull-left">
                      <input type="text" placeholder="请输入验证码" class="pull-left form-control" id="verify" name="rand" >  
                    </div>
                    <div><img src="rand" height="30"  width="80"/></div>
                </li>

              <li class="clearfix log-wj">
                    <div class="wj-mima clearfix pull-right">
                      <div class="fr-ch pull-left">
                      <div class="checkbox">
                          <label for="blankCheckbox">
                            <input type="checkbox" id="blankCheckbox" value="option1">
                           <span>记住密码</span>
                          </label>
                      </div>
                      </div>
                      <div class="fr-wj pull-right"> <a href="wangjiMM.jsp" target="_blank">忘记密码?</a> </div>
                    </div>
              </li>

              <li class="clearfix">
                    <div class="fruit-login pull-right">
                        <div class="fr-regist pull-left">                          
                           <input  type="submit"  value="登录" id="dengluzhuce1" />
                        </div>
                        <div class="fr-login pull-left">
                            <a href="zhuce.jsp" class="btn-lg" role="button"> 注册会员
                            </a>
                        </div>
                        
                    </div>
                     
              </li>
     <div align="center" > <font color="red" id="errMs"><c:out value="${errMs}" default=""/></font></div> 
            </ul>
         
        </div>
      </div>
  </div>
</div>
</form>

<jsp:include page="console_element/buttom.jsp"></jsp:include>

</body>
<div class="show-loading"></div>

</html>
 
