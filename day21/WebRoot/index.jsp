<%@ page language="java"  pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>index</title>
	 <script type="text/javascript">
	     function startTime(){
	       //每一秒更新一次时间
	       // alert("jj");
	       window.setInterval("updateTime()",1000);
	     }
	     function updateTime(){
	       //新建当前日期对象
	      var date = new Date();
	     var time = date.toLocaleString();
	       var spanElement = document.getElementById("span");
	        spanElement.innerText=time;
	     }
	 </script>
  </head>
  
  <body onload="startTime()">
      你的ip地址:${ip}<br/>
      居住地:${address}
      访问次数:${counter}<br/>
      时间:<span id="span"></span>
  </body>
</html>
