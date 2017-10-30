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
	<div ng-app="app" ng-controller="HealthReportController">					
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in wikis">
				  	<td><img ng-src="{{x.user.icon}}"> <span>{{x.user.displayName}}</span><td>	  	
					<td><a href="${pageContext.request.contextPath}/health-report/{{x.id}}">{{x.title}}</a></td>
				  	<td>{{x.createDate}}</td>
				  	<td ng-show="x.createUser.id==${currentUser.id}">
				  		<a href="javascript:;" ng-click="editWiki(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="removeWiki(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>				  	
				  	</td>
				  </tr>
			  </tbody>
			</table>
			<div class="panel-footer">
			      <div>		
	<h1 class="text-center">Create Health Report</h1>
			      <div class="panel panel-info"> 
					<div class="panel-heading">User List</div>  
				    	<table class="table"> 
						  <tbody>
							  <tr ng-repeat="x in userList">
							  	<td><img ng-src="{{x.icon}}"> <span>{{x.createUser.displayName}}</span><td>	  	
								<td>{{x.email}}</td> 
							  	<td style="width:60px; text-align:center ">						  		
							  		<a href="javascript:;" ng-click="addUser(x)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a> 
							  	</td>
							  </tr>
						  </tbody>
						</table> 
				</div>
			      </div> 
			      <hr>
			       <div class="form-group">
					    <label>User</label>
					    <div class="avatar"> 
			                <img ng-src="{{wiki.user.icon}}"  class="media-photo"/>  
			                <b class="user-name">{{wiki.user.displayName}}</b>  		           
			           </div> 
					  </div> 
				  <div class="form-group">
				    <label>HealthReport Title</label> 				  	
				  	<div class="input-group">
				      <input type="text" class="form-control" ng-model="wiki.title" placeholder="e.g. Main Page">
				      <span class="input-group-btn">
				        <button type="button" class="btn btn-default" ng-click="searchWiki()">Search on Wiki</button>	
				      </span>
				    </div>
				  </div>
				  <div class="form-group">
				    <label>Content</label>
				     <div id="summernote"></div> 
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="submitWiki()">Submit</button>			 
			</div> 
		</div>
	</div>
    </jsp:body>
</x:page>
