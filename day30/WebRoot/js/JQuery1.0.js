function $(StrId){
	var element =  document.getElementById(StrId);
	if(element!=null){
		return element;
	}else{
		return null;
	}
}
function JQuery(){
	this.show=function(){
		document.images[0].style.visibility="visible"; 
	}
	this.hidden=function(){
		document.images[0].style.visibility="hidden"; 
	}
}