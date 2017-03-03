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
		<option>湖南省</option>	
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
	                       //取得json字符串
	                        var msg = xhr.responseText;
	                        //转换成json对象
	                         var jsonObject = eval("("+msg+")");
	                         var size = jsonObject.length;
	                         for(var i=0;i<size;i++){
	                            var optionElement = document.createElement("option");
	                            optionElement.innerHTML=jsonObject[i].city_name;
	                            //alert(jsonObject[i].name);
	                            var citySelect = document.getElementById("cityID");
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
