

$('document').ready(function(){
	
	var password = document.getElementById('password');
	var confirmPassword = document.getElementById('confirmPassword');

	function validatePassword(){
		

		if(password.value !=confirmPassword.value){
			//confirmPassword.setCustomValidity("Password dont match");	
			 document.getElementById("demo").innerHTML = "Password dont match";
		}
		else{
		    //confirmPassword.setCustomValidity(" ");	
		    document.getElementById("demo").innerHTML = "";
	
		}
		
	}
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;
});