<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<link rel="shortcut icon" href="img/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/verify.css">
<script type="text/javascript">
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
       var msg = document.getElementById("checkMsg2");
       if (uPwd.value != uPwd1.value) {
			
			msg.childNodes[0].nodeValue = "密码两次输入的不一致";
			
			uPwd1.value = "";
			
			return false;
		} else {
		msg.childNodes[0].nodeValue = "";
			return true;
		}
       
       
       
   }  


</script>
</head>
<body>

<div class="top-con">
    
    </div>
<section class="p-common-header">
<jsp:include page="console_element/top1.jsp"></jsp:include>
<jsp:include page="console_element/top2.jsp"></jsp:include>
</section>

<div class="w-1000 w-750 pt-50">
    <p class="member">找回密码</p>
    <div class="find_password clearfix">
        <ul class="step1 clearfix hide">
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

        <ul class="step2 clearfix">
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

        <ul class="step3 clearfix hide" >
            <li class="pull-left first">
                <span>01.验证信息</span>
                <i></i>
            </li>
            <li class="pull-left second">
                <span>02.设置新密码</span>
                <i class="sec-i"></i>
            </li>
            <li class="pull-left third">
                <span>03.完成</span>
            </li>
        </ul>

    </div>
    
 <form action="MiMaServlet?todo=xinmima" method="post" onsubmit=" return checkPwd1()">
    <div class="regist_form fill_name">
   
        <ul class="refist_1">
            <li class="clearfix">
                <span class="pull-left">重置密码</span>
                <input type="text" class="pull-left form-control"     id="uPwd" name="uPwd"  onblur=" checkPwd(this.value)">
            </li>
           <div id="checkMsg1" style="color:red;font-size:12px; text-align: center;" >&nbsp;</div>
            
            <li class="clearfix verify_code">
                <span class="pull-left">确认密码</span>
                
                <input type="text" class="pull-left form-control" id="uPwd1" name="uPwd1"  onblur=" checkPwd1()">
            </li>
               <div id="checkMsg2" style="color:red;font-size:12px; text-align: center;" >&nbsp;</div>
             
            <li class="register">
               <input type="submit" class="btn btn-success" id="verifyBtn1" value="下一步" />
            </li>
        </ul>
      
    </div>
    </form>
</div>



<!--底部 -->
<jsp:include page="console_element/buttom.jsp"/>


</body>
<div class="show-loading"></div>
</html>

