<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>    
	<jsp:attribute name="script">	   
		<script src="${pageContext.request.contextPath}/resources/js/app/script-detail.js"></script>	
    </jsp:attribute>
	<jsp:body>	
		<div ng-app="app" ng-controller="ScriptDetailController" ng-init="init(${scriptId})">
			<!-- Medicine List -->	
			<h1 class="text-center">Script</h1> 
			<div class="panel panel-info"> 
				<div class="panel-heading">Medicine List</div>  
			    <div class="panel-body" >			    
					  <div class="form-group">
					    <label>Patient</label>
					    <div class="avatar"> 
			                <img ng-src="{{script.patient.icon}}"  class="media-photo"/>  
			                <b class="user-name">{{script.patient.displayName}}</b>  		           
			           </div> 
					  </div> 
			    </div>
		    	<table class="table">
			    	<thead>
			    		<tr>
			    			<th>Medicine Name</th>
			    			<th>Price</th> 
			    		</tr>
			    	</thead>
				  <tbody> 
					  <tr ng-repeat="x in script.medicines">
					  	<td>{{x.name}}</td>
					  	<td>$ {{x.price}}</td> 
					  </tr>
				  </tbody>
				</table>				 
			    <div class="panel-footer">		   
					  <div class="form-group">
					    <label>Doctor</label>
					    <div class="avatar"> 
			                <img ng-src="{{script.doctor.icon}}"  class="media-photo"/>  
			                <b class="user-name">{{script.doctor.displayName}}</b>  		           
			           </div> 
					  </div> 
					  <a href="/map" target="_blank">Medical Location</a>
				 </div> 
				 
			</div>		
		</div> 		
    </jsp:body>
</x:page>
