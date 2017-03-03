<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>image.jsp</title>
  </head>
  <body>
       <img src="images/lb.jpg" height="100px" value="1"/>
       <img src="images/sq.jpg" height="100px" value="2"/>
       <div style="border-style:dotted;width:100px;position:absolute;left:350px;top:100px">
                              编号:<span></span><br/>
                            名称:<span></span><br/>      
                          作者:<span></span><br/>                                                     
       </div>
       <script type="text/javascript">
         //当页面加载时将div隐藏
        window.onload=function(){
            //定位<div>标签
  			var divElement = document.getElementsByTagName("div")[0];
  			//通过JS操作CSS样式
  			divElement.style.visibility="hidden";

         }
          
       
         var imageElements = document.getElementsByTagName("img");
         var size = imageElements.length;
        
         for(var i=0;i<size;i++){
              imageElements[i].onmouseout=function(){
                  //定位<div>标签
  			var divElement = document.getElementsByTagName("div")[0];
  			//通过JS操作CSS样式
  			divElement.style.visibility="hidden";
                
              }
             imageElements[i].onmouseover=function(event){
                //取得客户端的坐标
                //在火狐浏览器下只能用传入参数的方式传入event
                var ev = event||window.event;
                 var x = ev.clientX + 20;
  				var y = ev.clientY + 40;
  				   
                 var xhr = createXHR();
                 var id = this.getAttribute("value");
                  xhr.onreadystatechange=function(){
                       if(xhr.readyState==4){
                         if(xhr.status==200){
                             var jsonString = xhr.responseText;
                             var jsonObject = eval("("+jsonString+")");
                             var id = jsonObject[0].id;
                             var name = jsonObject[0].name;
                             var author = jsonObject[0].author;
                             //将鼠标当前的位置作为显示的位置
                             var divElement = document.getElementsByTagName("div")[0];
  			                     divElement.style.visibility="visible";
                              divElement.style.left=x+"px";
                              divElement.style.top=y+"px"; 
                             var spanElements = document.getElementsByTagName("span");
                              spanElements[0].innerHTML=id;
                              spanElements[1].innerHTML=name;
                              spanElements[2].innerHTML=author;
                         }
                       }
                  }
                 xhr.open("get","/day32/ImageServlet?time="+new Date().getTime()+"&id="+id);
                 xhr.send(null);
             }
         }
          
         function createXHR(){
           var xhr = null;
           try{
           
            xhr = new ActiveXObject("microsoft.xmlhttp"); 
           }catch(e){
              xhr= new XMLHttpRequest();
           }
            
           return xhr;
         }
       </script>
  </body>
</html>
