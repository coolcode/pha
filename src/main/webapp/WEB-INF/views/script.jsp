<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
 

<x:page>    
	<jsp:attribute name="script">	   
		<script src="${pageContext.request.contextPath}/resources/js/app/script.js"></script>	
    </jsp:attribute>
	<jsp:body>	
		<div ng-app="app" ng-controller="ScriptController" ng-init="init(${patient})">
			<!-- Medicine List -->	
			<h1 class="text-center">Create a Script</h1> 
			<div class="panel panel-info"> 
				<div class="panel-heading">Medicine List</div>  
			    	<table class="table">
				    	<thead>
				    		<tr>
				    			<th>Medicine Name</th>
				    			<th>Price</th>
				    			<th>Quantity</th>
				    			<th>Operation</th> 
				    		</tr>
				    	</thead>
					  <tbody>
						  <tr ng-repeat="x in medicines">
						  	<td>{{x.name}}</td>	  	
							<td>{{x.price}}</td>
						  	<td>{{x.quantity}}</td>
						  	<td style="width:60px; text-align:center ">						  		
						  		<a href="javascript:;" ng-click="addMedicine(x)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a> 
						  	</td>
						  </tr>
					  </tbody>
					</table> 
			</div>
			<!-- Script's Medicines -->				
			<div class="panel panel-info">
				<div class="panel-heading">Script</div> 
			    <div class="panel-body" >
			    	<ul class="list-group">
					  <li ng-repeat="x in script.medicines" class="list-group-item"> 
					  	<span>{{x.name}}</span>
					  	<a href="javascript:;" ng-click="removeMedicine(x)"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> 
					  </li> 
					</ul>	
				</div> 
			    <div class="panel-footer">			    
					  <div class="form-group">
					    <label>Patient</label>
					    <div class="avatar"> 
			                <img ng-src="{{script.patient.icon}}"  class="media-photo"/>  
			                <b class="user-name">{{script.patient.displayName}}</b>  		           
			           </div> 
					  </div> 
					<div> 
						  <button type="button" class="btn btn-default" ng-click="submitScript()">Send Script</button>			 
					</div> 
			    </div>
			</div> 
		</div> 		
    </jsp:body>
</x:page>
