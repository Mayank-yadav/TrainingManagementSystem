

$(document).ready(function(){
	$('#userName1').focusin(function(){
		$('#userName1').addClass('box');
		$('#spanUser1').text("Enter userName");
	});
	
	$('#userName1').focusout(function(){
		$('#userName1').removeClass('box');
		$('#spanUser1').text("");
	});
	
	/*-=====================================----*/
	$('#password1').focusin(function(){
		$('#password1').addClass('box');
		$('#spanPassword1').text("Enter Password");
	});
	
	$('#password1').focusout(function(){
		$('#password1').removeClass('box');
		$('#spanPassword1').text("");
	});
	//================================================================
	$('#name').focusin(function(){
		$('#name').addClass('box');
		$('#spanName').text("Enter Name");
	});
	
	$('#name').focusout(function(){
		$('#name').removeClass('box');
		$('#spanName').text("");
	});
	
	//=======================================================================
	$('#contact').focusin(function(){
		$('#contact').addClass('box');
		$('#spanContact').text("Enter Contact");
	});
	
	$('#contact').focusout(function(){
		$('#contact').removeClass('box');
		$('#spanContact').text("");
	});
	
	//======================================
	$('#email').focusin(function(){
		$('#email').addClass('box');
		$('#spanEmail').text("Enter Email");
	});
	
	$('#email').focusout(function(){
		$('#email').removeClass('box');
		$('#spanEmail').text("");
	});
	
	//==============================================================
	$('#name').focusin(function(){
		$('#name').addClass('box');
		$('#spanName').text("Enter Name");
	});
	
	$('#name').focusout(function(){
		$('#name').removeClass('box');
		$('#spanName').text("");
	});
	
	//=================================================================
	
	$('#userName').keyup(function(){
		var userNameLength = $('#userName').val().length;
		//$('#userName').text(userNameLength);
		if(userNameLength<15){
			$('#user').text("");
		}else{
			$('#user').text("Not exceeded than 15 characters");
			
		}	
	});
	
	$('#password').keyup(function(){
		var passwordLength = $('#password').val().length;
		//$('#userName').text(userNameLength);
		if(passwordLength<=10&&passwordLength>=4){
			$('#pass').text("");
		}else{
			$('#pass').text("Password range is between 4 -10");
			
		}	
	});
	
	$('#contact').keyup(function(){
		var contactLength = $('#contact').val().length;
		var contact = $('#contact').val();
		for (var n = 0; n < contact.length; n++) {
			 var digit = contact.charCodeAt(n) >= 48 && contact.charCodeAt(n) <= 57 || contact.charCodeAt(n) == 46 || contact.charCodeAt(n) == 45;
			 if(!digit){
				 $('#spanContact').text("Enter Numbers Only");
				 
				 
			 }else{
				 
				 if(contactLength<=10){
					 $('#spanContact').text("");
				 }else{
					 $('#spanContact').text("Contact digit is more than 10");
					 
				 }	
			 }
		}
		
	});
	$('#email').keyup(function(){
		var emailValid = $('#email').val();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!filter.test(emailValid)){
			
			$('#spanEmail').text("Enter Valid  Email-ID");
		}else{
			
			$('#spanEmail').text("")
		}
		
	});
	
	//==================================================
	
	$('#password1').keyup(function(){
		var passwordValid = $('#password1').val();
		var regex = /^[a-zA-Z0-9]+$/;
		if(regex.test(passwordValid)){
			$('#spanPassword').text("Password Contains Alphanumeric and Special Charcters");
			
		}else{
			$('#spanPassword').text("")
			
		}
		
	});
});