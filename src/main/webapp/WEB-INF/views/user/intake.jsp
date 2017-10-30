<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>     
    <jsp:attribute name="css"> 
    </jsp:attribute> 
    <jsp:attribute name="script">	 
		<script src="${pageContext.request.contextPath}/resources/js/app/intake.js"></script>	 
    </jsp:attribute>
	<jsp:body>	
	<h1 class="text-center">Daily Intake</h1>
	<div ng-app="app" ng-controller="IntakeController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			<thead>
	    		<tr>
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
				  	<td>{{x.createDate}}</td>
					<td>{{x.intakeType}}</td>
					<td>{{x.intakeQty}}</td>
					<td>{{x.intakeUnit}}</td>
					<td>{{x.karlories}}</td> 
				  	<td>
				  		<a href="javascript:;" ng-click="edit(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="remove(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>				  	
				  	</td>
				  </tr>
			  </tbody>
			</table>
			<div class="panel-footer"> 
				  <div class="form-group">
				    <label>Intake Type</label>  
				      <input type="text" class="form-control" ng-model="entity.intakeType">  
				  </div> 
				  <div class="form-group">
				    <label>Intake Qty</label> 	 
				      <input type="text" class="form-control" ng-model="entity.intakeQty">  
				  </div> 
				  <div class="form-group">
				    <label>Intake Unit</label> 	 
				      <input type="text" class="form-control" ng-model="entity.intakeUnit">  
				  </div> 
				  <div class="form-group">
				    <label>Karlories</label>  
				      <input type="text" class="form-control" ng-model="entity.karlories">  
				  </div> 
				  <div class="form-group">
				    <label>Remarks</label> 	 
				      <input type="text" class="form-control" ng-model="entity.remarks">   
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="save()">Save</button>			 
			</div> 
		</div>
	</div>
    </jsp:body>
</x:page>
