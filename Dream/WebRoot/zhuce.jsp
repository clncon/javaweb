<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html >
<head>

<base href="<%=basePath%>">
<meta charset="utf-8">
<title>当然果园-水果网购首选品牌，水果，我们只挑有来头的！</title> <link rel="shortcut icon"  href="img/default_userpic.ico">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
<link rel="stylesheet" type="text/css" href="css/dengluzhuce.css">
<script language="javascript">
var ht = null;

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
   function checkPwd1(){
       var uPwd= document.getElementById('uPwd');
       var uPwd1= document.getElementById('uPwd1');
       var msg = document.getElementById("checkMsg1");
       if (uPwd.value != uPwd1.value) {
			
			msg.childNodes[0].nodeValue = "密码两次输入的不一致";
			
			uPwd1.value = "";
			
			return false;
		} else {
		msg.childNodes[0].nodeValue = "";
			return true;
		}
       
       
       
   }  
 

	
	function checkUser(uPhone) {
		//var uPhone = document.getElementById('uPhone');
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

		ht.open("post", "UserServlet?todo=ajax&uPhone="+uPhone	, true);
		ht.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
		ht.send(); // ?参数 

	return true;
	}
	
	function call123() {
		if (ht.readyState == 4) {//4 (完成)数据接收完毕
			if (ht.status == 200) {
				var msg = document.getElementById("checkMsg");
				if (ht.responseText == "true") {
					// msg.innerText="该账号已经存在，请重新输入！";
					
					msg.childNodes[0].nodeValue = "该帐号已经存在，请重新输入";
				} else {
					//msg.innerText="该账号可以使用!";
					msg.childNodes[0].nodeValue = "该帐号可以使用";
				}

			}

		}
	}
	
	 function checkMail(mail){
     var reg=/^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
     var msg= document.getElementById("checkMsg2");
     if(reg.test(mail)){
      msg.childNodes[0].nodeValue="";
      return ture;
     }else{
     form1.uMail.focus;
      msg.childNodes[0].nodeValue="请输入正确的邮箱格式！";  
           document.getElementById("uMail").value="";
      return false;
    }
    
   }
	
</script>

</head>
<body>
	<!-- top -->
	<div class="top-con"></div>

	<!-- 头部开始 -->
	<section class="p-common-header">
	
	 <jsp:include page="console_element/top1.jsp"></jsp:include>
	<div class="content">
		<nav class="navbar ">
		<div class="container-fluid">

			<div style="padding:0px;float:left">
				<a href="index.jsp"><img src="img/login5.png.png" />
				</a>
			</div>
			<div class="collapse navbar-collapse"></div>
		</div>
		</nav>
	</div>
	</section>
	<form action="UserServlet?todo=zhuce" method="post" name="form1" onsubmit="">
		<div class="w-1000 w-750 pt-50">
			<p class="member">注册会员</p>
			<div class="login-sec clearfix">
				<div class="login-left pull-left">
					<img src="img/huiyuan.jpg" width="500" height="400">
					<div class="login">
						<a href="login.jsp"
							class="btn btn-primary btn-lg active login-btn" role="button"
							title="点击此按钮，登录会员账号"> 会员登录></a>
					</div>
				</div>

				<div class="login-right pull-right">
					<div class="login-form">
						<ul>
							<li class="clearfix">
								<div class="text02 all pull-left">
									<span class="mobile">手机号</span>
								</div>
								<div class="send-yanzm pull-left">
									<input type="text" placeholder="请输入手机号" class="form-control" id="uPhone"
										name="uPhone" clientidmode="Static" onblur="checkUser(this.value)"> 
										<span id="checkMsg" style="color:red;font-size:12px;">&nbsp;</span>
								</div></li>
									<li class="clearfix">
								<div class="text02 all pull-left">
									<span class="mobile">用户名</span>
								</div>
								<div class="send-yanzm pull-left">
									<input type="text" placeholder="请输入用户名" class="form-control" id="uName"
										name="uName" onblur=""> 
										<span id="checkMsg" style="color:red;font-size:12px;">&nbsp;</span>
								</div></li>
									
							
							<li class="clearfix">
								<div class="text02 all pull-left">
									<span class="mobile">邮箱</span>
								</div>
								<div class="send-yanzm pull-left">
									<input type="text" placeholder="请输入邮箱" class="form-control" id="uMail"
										name="uMail" clientidmode="Static" onblur="checkMail(this.value)"> 
										<span id="checkMsg2" style="color:red;font-size:12px;">&nbsp;</span>
								</div></li>
								

							<li class="clearfix">
								<div class="text04 all pull-left">
									<span class="code">密码</span>
								</div>
								<div class="password pull-left">
									<input type="password" placeholder="请输入 以字母开头6-20位号码字符"
										class="form-control" id="uPwd" name="uPwd" clientidmode="Static" onblur="checkPwd(this.value)"> <span
										id="checkMsg1" style="color:red;font-size:12px;">&nbsp;</span>
										
								</div></li>

							<li class="clearfix">
								<div class="text05 all pull-left">
									<span class="code">确认密码</span>
								</div>
								<div class="entrue pull-left">
									<input type="password" placeholder="请输入以字母开头6-20位号码字符"
										class="pull-left form-control" id="uPwd1" name="uPwd1" onblur="checkPwd1()">
									
								</div></li>

							<li class="clearfix">
								<div class="text01 all pull-left">
									<span class="form1">验证码</span>
								</div>
								<div class="yanzm pull-left">
									<input type="text text-01" placeholder="请输入验证码" class="pull-left form-control"
										id="verify" name="rand"><span class="true"></span>

								</div>
								<div>
									<img src="rand" height="30" width="80" />
								</div></li>

							<li class="clearfix">
								<div class="fruit-login pull-right">
									<div class="fr-regist pull-left">
										<input type="submit" value="注册" id="dengluzhuce1" />
									</div>
									<div class="fr-login pull-left">
										<a href="login.jsp" class="btn-lg" role="button">会员登录</a>
									</div>
								</div></li>
							<div align="center">
								<font color="red" id="errMs"><c:out value="${errMs}"
										default="" />
								</font>
							</div>


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

</script>
