<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  
  <body>
                 用户名: <input type="text" name="username"/>
                  <hr>
       <div>
          <!-- 显示在这里 -->
       </div>
      <script type="text/javascript">
           document.getElementsByTagName("input")[0].onblur=function(){
                
                   
                 //取得文本框的数据
                  var username = this.value
                  //对用户名进行编码
                username = encodeURI(username);
                 //创建Ajax引擎对象
                 var xhr = new createXHR();
                 //为ajax引擎创建状态改变事件
                 xhr.onreadystatechange = function(){
                     //alert("ff");
                    //如果请求和响应都完成了
                    if(xhr.readyState==4){
                            
                       //如果是正确的响应
                       if(xhr.status==200){
                     
                         //取得服务器的响应
                         var msg = xhr.responseText;
                         //定位到div标签
                         var divElement = document.getElementsByTagName("div")[0];
                         //将msg添加到div下
                          divElement.innerHTML="<img src='"+msg+"'/>";
                          
                       }
                    }
                    
                  }
                   //准备向服务器发出请求
                   xhr.open("get","/day31/GetAndPostServlet?time="+new Date().getTime()+"&username="+username);
                   //真正发送、
                   xhr.send(null);
             
           }
         
         
          //根据不同的浏览器创建对应的AJAX引擎对象
              function createXHR(){
               var xhr=null;
                  //如果是IE
                 if(window.ActiveXObject){
                    xhr = new ActiveXObject("microsoft.xmlhttp");
                    
                 }
                   //如果是非IE
                 else{
                    xhr = new XMLHttpRequest();
                 }
                 return xhr;
              }
      </script>
  </body>
</html>
