function show(){
	window.alert("嘻嘻");
}
window.onload=function(){
	
	var buttonElement = document.forms[0].mybtn;
	
	buttonElement.onclick=show;
}