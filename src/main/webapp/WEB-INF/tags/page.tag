<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="css" fragment="true"%>
<%@attribute name="script" fragment="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="Personal Health Assistant">
	<meta name="author" content="Bruce Lee">
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/logo.png" sizes="32x32" />
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/logo.png" sizes="192x192" />
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/img/logo.png" />
	<meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/resources/img/logo.png" />
	
	<title>Personal Health Assistant</title>
	
	<!--  CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> 
	<link href='http://cdnjs.cloudflare.com/ajax/libs/angular-loading-bar/0.9.0/loading-bar.min.css' rel='stylesheet' type='text/css' media='all' />
	<link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
	
	<!--  custom css ================================================== -->
	<jsp:invoke fragment="css" />
</head>

<body  ng-app="app" >
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">
					<img class="logo" src="${pageContext.request.contextPath}/resources/img/logo.png"/>
					<span class="site-title">Doctor Online</span>
				</a>
			</div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav navbar-left" ng-controller="NavbarController">
					<li ><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li ><a href="${pageContext.request.contextPath}/forum"> Discussion</a></li> 
					<li ng-show="user.role=='ROLE_USER'"><a href="${pageContext.request.contextPath}/my-intake">My Intake</a></li> 
					<li ng-show="user.role=='ROLE_USER'"><a href="${pageContext.request.contextPath}/my-health-report">My Health Report </a></li> 
					<li ng-show="user.role=='ROLE_USER'"><a href="${pageContext.request.contextPath}/quiz/quiz_user"> Quiz </a></li>
<%-- 					<li ng-show="user.role=='ROLE_USER'"><a href="${pageContext.request.contextPath}/TrackHealth/"> Track Health </a></li>	 --%>
					<li ng-show="user.role=='ROLE_DOCTOR'"><a href="${pageContext.request.contextPath}/intake">User Intake</a></li> 
					<li ng-show="user.role=='ROLE_DOCTOR'"><a href="${pageContext.request.contextPath}/health-report">Health Report </a></li> 
					<li ng-show="user.role=='ROLE_DOCTOR'"><a href="${pageContext.request.contextPath}/quiz/quiz_user"> Quiz </a></li>				 
					<li ng-show="user.role=='ROLE_ADMIN'"><a href="${pageContext.request.contextPath}/announcement">Announcement</a></li>					 
					<li ng-show="user.role=='ROLE_ADMIN'"><a href="${pageContext.request.contextPath}/admin/user">User</a></li>
	<%-- 				<li ng-show="user.role=='ROLE_ADMIN'"><a href="${pageContext.request.contextPath}/medicine">Medicine</a></li>
					<li><a href="#">${pageContext.request.userPrincipal.name }</a>   |  <a href="${pageContext.request.contextPath}/logout">Logout</a>   	          --%>
<!-- 			</li> -->
	          </ul> 
<!-- 			 <div class="navbar-form navbar-right" style="color:fff;">   	              -->
<%-- 					  ${pageContext.request.userPrincipal.name }  |  <a href="${pageContext.request.contextPath}/logout">Logout</a>   	          --%>
<!-- 			   </div>   -->
	        </div>
		</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
<!-- 			<div class="col-sm-3 col-md-2 sidebar"> -->
<!-- 				<ul class="nav nav-sidebar"> -->
<%-- 					<li class="active"><a href="${pageContext.request.contextPath}/">Home <span --%>
<!-- 							class="sr-only">(current)</span></a></li>  -->
<%-- 					<li><a href="${pageContext.request.contextPath}/hibernateDaoAdd">[Demo] hibernateDaoAdd</a></li> --%>
<%-- 					<li><a href="${pageContext.request.contextPath}/hibernateDaoServiceAdd"> [Demo]hibernateDaoServiceAdd</a></li> --%>
<%-- 					<li><a href="${pageContext.request.contextPath}/hibernateQuery">[Demo] hibernateQuery</a></li> --%>
<%-- 					<li><a href="${pageContext.request.contextPath}/chat">Chat</a></li> --%>
<!-- 				</ul> -->
<!-- 				<ul class="nav nav-sidebar"> -->
<!-- 				</ul> -->
<!-- 			</div> <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->

			<div class="col-sm-12 col-md-12 main"> 
			 <div class="navbar-form navbar-right">  
			  		  <div class="avatar"> 
			                <img src="${pageContext.request.contextPath}/api/user/current/icon"  class="media-photo"/>  		             
					  ${pageContext.request.userPrincipal.name }  |  <a href="${pageContext.request.contextPath}/logout">Logout</a>              
			           </div>  	         
			   </div>  
			</div>
			<jsp:doBody />
		</div>

	</div>
	
	<footer>
<!-- 		<div class="center"><a href="https://github.com/coolcode/pha" target="_blank">Source on Github</a></div> -->
	</footer>
	<!-- Scripts ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/purl.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/angular-sanitize.min.js"></script>	
 	<script src='http://cdnjs.cloudflare.com/ajax/libs/angular-loading-bar/0.9.0/loading-bar.min.js'></script>
	<script>
		$.context = "${pageContext.request.contextPath}";
	</script>

	<!--  custom scripts ================================================== -->
	<jsp:invoke fragment="script" />
	<script src="${pageContext.request.contextPath}/resources/js/app/navbar.js"></script>	

</body>
</html>