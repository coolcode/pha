<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>     
    <jsp:attribute name="css">
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    </jsp:attribute> 
    <jsp:attribute name="script">	 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/health-report.js"></script>	 
    </jsp:attribute>
	<jsp:body>	
	<h1 class="text-center">Health Report</h1>
	<div ng-app="app" ng-controller="MyHealthReportController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in wikis">
				  	<td><img ng-src="{{x.user.icon}}"> <span>{{x.user.displayName}}</span><td>	  	
					<td><a href="${pageContext.request.contextPath}/health-report/{{x.id}}">{{x.title}}</a></td>
				  	<td>{{x.createDate}}</td> 
				  </tr>
			  </tbody>
			</table> 
		</div>
	</div>
    </jsp:body>
</x:page>
