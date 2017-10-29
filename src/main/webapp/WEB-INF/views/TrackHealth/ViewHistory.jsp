<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>



<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    		<script src="${pageContext.request.contextPath}/resources/js/app/TrackHealth.js"></script>	 
    </jsp:attribute>
	<jsp:body>
		<h1 class="text-left">View History</h1>
									
		<div ng-app="app" ng-controller="WikiController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in wikis">
				  	<td><img ng-src="{{x.createUser.icon}}"> <span>{{x.createUser.displayName}}</span><td>	  	
					<td><a href="${pageContext.request.contextPath}/wiki/{{x.id}}">{{x.createDate}}</a></td>
				  </tr>
			  </tbody>
			</table>
		</div>
		</div>
    </jsp:body>
</x:page>
