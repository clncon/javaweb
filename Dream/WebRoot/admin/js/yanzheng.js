  function checkPnum(num){	
		var zpum=/^[0-9]*[1-9][0-9]*$/ ;
		var  msg= document.getElementById("Msg1");
		 if(zpum.test(num)){
			   msg.childNodes[0].nodeValue ="";
		     return true;		     
		 }else{		   
		        msg.childNodes[0].nodeValue ="您的输入有误";	  
		     return false;
		 }
		 
		 }
 
 
 