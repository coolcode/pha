
<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>


<x:base>
	<jsp:attribute name="script">	  
		<script src="${pageContext.request.contextPath}/resources/js/app/login.js"></script>
		<script src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.10&appId=1950443364972031"></script>			
		<script>
		  $(function(){
		      $('#status').hide();	
		      //checkLoginStatus();
		  })			
		
		  function checkLoginStatus(){
			  FB.getLoginStatus(function(response) {
				   //statusChangeCallback(response);
	    			console.log(JSON.stringify(response));
				   if (response.status === 'connected') {
				      // Logged into your app and Facebook.
					   console.log('Welcome!  Fetching your information.... ');
					   FB.api('/me', {fields: 'id,name,gender,email' }, function(response) {
						      console.log('Successful login for: ' + response.name);
				    		  console.log(JSON.stringify(response)); 
						      location.href = "${pageContext.request.contextPath}/user/facebook_callback?"
						    		  +"name="+ response.name
						    		  +"&email="+response.email
						    		  +"&id="+ response.id;
						   
						}); 
				    } else {
				        // The person is not logged into your app or we are unable to tell.
				        $('#status').show();
				        $('#status').html('Please log into this app.');
				    }
			  });		
		  }  
		  
		  function myFacebookLogin() {
			  FB.login(function(){
			      checkLoginStatus();
			  }, {scope: 'public_profile,email'});
		  }
		  
		</script>
		
    </jsp:attribute>
	<jsp:body>	
	<div id="fb-root"></div> 
		<div ng-app="app" ng-controller="UserController">
			<h1 class="text-center">Sign In</h1> 
			<div class="row">	
				<div class="col-xs-12 col-sm-6 col-md-6 col-md-offset-3 col-sm-offset-3">	 
			        <form action="${pageContext.request.contextPath}/user/login" method="post">
			            <div class="form-group">
			            	<label> User Name </label>
			            	<input type="text" name="username" class="form-control"/> 
			            </div>
			            <div class="form-group">
			            	<label> Password </label>
			            	 <input type="password" name="password" class="form-control"/>
			            </div>
			            <div><input type="submit" class="btn btn-default" value="Sign In" /></div>
			        </form>	
<%-- 			        <form action="${pageContext.request.contextPath}/user/register" method="post"> --%>
<!-- 			        <button class="btn btn-default"  onclick="register()">Register</button> -->
<!-- 			        </form> -->
			          <hr/>
				   <button class="btn btn-default"  onclick="myFacebookLogin()">Facebook</button>
		          
<!-- 		            <div class="fb-login-button" data-max-rows="1" data-size="medium" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="true"></div> -->
  					<div id="status" class="alert alert-danger" role="alert" style="display:none;"></div>
					
				</div> 
			</div> 
		</div>
    </jsp:body>
</x:base>
