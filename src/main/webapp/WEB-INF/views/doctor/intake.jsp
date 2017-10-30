<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>     
    <jsp:attribute name="css"> 
    </jsp:attribute> 
    <jsp:attribute name="script">	 
		<script src="${pageContext.request.contextPath}/resources/js/app/intake.js"></script>	 
    </jsp:attribute>
	<jsp:body>	
	<h1 class="text-center">User Daily Intake</h1>
	<div ng-app="app" ng-controller="IntakeController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			<thead>
	    		<tr>
	    			<th>End User</th>
	    			<th>Time</th>
	    			<th>Intake Type</th>
	    			<th>Qty</th>
	    			<th>Unit</th> 
	    			<th>Karlories</th>
	    			<th>Operation</th>
	    		</tr>
			</thead>
			  <tbody>
				  <tr ng-repeat="x in entityList"> 
				  	<td><img ng-src="{{x.user.icon}}"> <span>{{x.user.displayName}}</span><td>	 
				  	<td>{{x.createDate}}</td>
					<td>{{x.intakeType}}</td>
					<td>{{x.intakeQty}}</td>
					<td>{{x.intakeUnit}}</td>
					<td>{{x.karlories}}</td> 
				  </tr>
			  </tbody>
			</table>
		</div>
	</div>
    </jsp:body>
</x:page>
