<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>
	<jsp:attribute name="script">	  
		<script src="${pageContext.request.contextPath}/resources/js/app/home.js"></script>	
    </jsp:attribute>
 
	<jsp:body>	
	
		<div ng-app="app" ng-controller="HomeController">
			<h1 class="text-center">Home</h1> 
			<p><img src="http://res.cloudinary.com/yopo/image/upload/v1508995517/doctoronline/banner.jpg" style="width:100%" class="rounded"><br></p>
			<div class="row">	
				<div class="col-xs-12 col-sm-6 col-md-6">				
					<div class="panel panel-info">
						<div class="panel-heading">New Posts</div>
						<ul class="list-group">
						  <li class="list-group-item" ng-repeat="x in posts"><a
								href="${pageContext.request.contextPath}/forum/post/{{x.id}}" target="_blank">{{x.title | limitTo:50}}</a></li> 
						</ul> 
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">				
					<div class="panel panel-info">
						<div class="panel-heading">Knowledge Library</div>
						<ul class="list-group">
						  <li class="list-group-item" ng-repeat="x in wikis"><a
								href="${pageContext.request.contextPath}/wiki/{{x.id}}" target="_blank">{{x.title | limitTo:50}}</a></li> 
						</ul> 
					</div>
				</div>	
			</div> 
		</div>
    </jsp:body>
</x:page>
