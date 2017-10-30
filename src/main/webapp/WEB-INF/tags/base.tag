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

<body>
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
					<span class="site-title">Doctor Online </span>
				</a>
			</div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav navbar-right">
	          </ul>
<!-- 	          <form class="navbar-form navbar-right"> -->
<!-- 	            <input type="text" class="form-control" placeholder="Search..."> -->
<!-- 	          </form> -->
	        </div>
		</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-12 main">
				<!--  custom content begin================================================== -->
				<jsp:doBody />
				<!--  custom content end================================================== -->
			</div>
		</div>

	</div>
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

</body>
</html>