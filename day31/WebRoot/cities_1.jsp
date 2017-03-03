<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cites</title>
  </head>
  
  <body>
       <select id="provinceID">
		<option>选择省份</option>	
		<option>吉林省</option>	
		<option>辽宁省</option>	
		<option>山东省</option>	
	</select>
	<select id="cityID">
		<option>选择城市</option>	
	</select>
	
	    <script type="text/javascript">
	        document.getElementById("provinceID").onchange=function(){
	          //清空所有的选项
	           var citySelectElement = document.getElementById("cityID");
			var cityElementArray = citySelectElement.options;
			var size = cityElementArray.length;
			if(size > 1){
				for(var i=size-1;i>0;i--){
					citySelectElement.removeChild(cityElementArray[i]);
				}
			}
	               //创建xhr引擎对象
	             var  xhr = createXHR();
	              // alert("ff");
	             //定位到下拉省份的标签处，并取得其中的值
	            var provinceValue = this[this.selectedIndex].firstChild.nodeValue;
	            //编码
	             provinceValue = encodeURI(provinceValue);
	             xhr.onreadystatechange=function(){
	                    //alert("ff");
	                 if(xhr.readyState==4){
	                      ;
	                   if(xhr.status==200){
	                      //以xml方式来接收
	                      var XMLDocument = xhr.responseXML;
	                      //alert(XMLDocument);
	                      var cityElements = XMLDocument.getElementsByTagName("city");
	                      var size = cityElements.length;
	                      for(var i=0;i<size;i++){
	                         //创建option节点
	                         var optionElement = document.createElement("option");
	                          //给optionElemet添加值
	                           optionElement.innerHTML=cityElements[i].firstChild.nodeValue;
	                           //alert(cityElements[i].firstChild.nodeValue);
	                           //定位到城市这个下拉列表
	                            var citySelect = document.getElementById("cityID");
	                            //添加到到city元素下
	                            citySelect.appendChild(optionElement);
	                      }
	                   }
	                 }
	             }
	                 xhr.open("get","/day31/CityServlet?time="+new Date().getTime()+"&province="+provinceValue);
	                 xhr.send(null);
	        }
	        
	        
	        
	        
	        
	        
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
