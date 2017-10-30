
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
			        <form action="${pageContext.request.contextPath}/login" method="post">
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
 
<!-- 			          <hr/>   -->
<%-- 			          <a href="${pageContext.request.contextPath}/register">Register</a> --%>
			          
			          <div id="status" class="alert alert-danger" role="alert" style="display:none;"></div>
					
				</div> 
			</div> 
		</div>
    </jsp:body>
</x:base>
