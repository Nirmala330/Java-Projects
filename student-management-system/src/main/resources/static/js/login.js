$('document').ready(function(){
	
	$('form').submit(function () {

    // Get the Login Name value and trim it
    var username = $.trim($('#username').val());
    var password = $.trim($('#password').val());

  var username_error =$("#user_name_error"); 
  var password_error =$("#password_error"); 

    // Check if empty of not
    if (username  === '') {
     
	    username_error.html("Please enter user name"); // Put the message content inside div
        return false;
    }
    
    else{
		username_error.html(""); // Put the message content inside div

	 }
	
    if(password === '')
    {
	    password_error.html("Please enter password"); // Put the message content inside div
        return false;

	}
	else{
	    password_error.html(""); // Put the message content inside div

	 }
	
	
	
    
    
});

});