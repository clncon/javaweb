function validateForm(){
	var formElement = document.forms[0];
	var username = trim(formElement.username.value);
	var password = trim(formElement.password.value);
	var email = trim(formElement.email.value);
	if(username.length==0){
		alert("用户名必须填");
	}else if(!/^[a-zA-Z0-9]+$/.test(username)){
		alert("用户名必须是数字或英文");
	}else if(password.length==0){
		alert("密码必须填");
	}else if(!/[0-9]{6}/.test(password)){
		alert("密码必须是六位的数字");
	}else if(email.length==0){
		alert("邮箱必须填");
	}else if(!/^\w+@\w+(\.\w+)+$/.test(email)){
		alert("邮箱不符合格式");
	}
	return false;
}
function trim(str){
	str=str.replace(/^\s*$/,"");
	return str;
}