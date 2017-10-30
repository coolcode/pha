<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>     
    <jsp:attribute name="css"> 
    </jsp:attribute> 
    <jsp:attribute name="script">	  
		<script src="${pageContext.request.contextPath}/resources/js/app/user.js"></script>	 
    </jsp:attribute>
	<jsp:body>	
	<h1 class="text-center">Users</h1>
	<div ng-app="app" ng-controller="UserController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in entityList">
				  	<td><img ng-src="{{x.icon}}"> <span>{{x.createUser.displayName}}</span><td>	  	
					<td>{{x.email}}</td>
				  	<td>{{x.roles}}</td>
				  	<td ng-show="x.id!=1">
				  		<a href="javascript:;" ng-click="editUser(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
<!-- 				  		<a href="javascript:;" ng-click="removeUser(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>	 -->
				  		<a href="javascript:;" ng-click="assignUserToRole(x, 'ROLE_DOCTOR')" >Assign to Doctor Role</a>	
				  		<a href="javascript:;" ng-click="assignUserToRole(x, 'ROLE_USER')" >Assign to User Role</a>				  	
				  	</td>
				  </tr>
			  </tbody>
			</table>
			<div class="panel-footer">		 
				  <div class="form-group">
				    <label>Icon</label> 
				      <input type="text" class="form-control" ng-model="entity.icon" >
				  </div>	 
				  <div class="form-group">
				    <label>Email</label> 
				      <input type="text" class="form-control" ng-model="entity.email" >
				  </div>
				  <div class="form-group">
				    <label>Display Name</label>
				      <input type="text" class="form-control" ng-model="entity.displayName" >
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="submitUser()">Save</button>			 
			</div> 
		</div>
	</div>
    </jsp:body>
</x:page>
