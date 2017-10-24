<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
 

<x:page>    
	<jsp:attribute name="script">	 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/post.js"></script>	
    </jsp:attribute>
	<jsp:body>	
		<div ng-app="app" ng-controller="PostController" ng-init="init(${post.id})">
			<!-- post -->	
			<h1 class="text-center">${post.title} </h1> 
			<div class="panel panel-info"> 
			    <div class="panel-body">
			    	${post.content}
			    </div>
			    <div class="panel-footer">
			    	<div class="avatar"> 
		                <img src="${post.createUser.icon}"  class="media-photo"/>  
		                <b class="user-name">${post.createUser.displayName}</b> -  ${post.createDate}
	           
		           </div>
				</div>
			</div>
			<!-- comments -->				
			<div class="panel panel-info">
				<div class="panel-heading">Comments</div> 
			    	<table class="table">
					  <tbody>
						  <tr ng-repeat="x in comments">
						  	<td><img ng-src="{{x.createUser.icon}}"> <span>{{x.createUser.displayName}}</span><td>	  	
							<td><div ng-bind="x.content"></div></td>
						  	<td>{{x.createDate}}</td>
						  	<td ng-show="x.createUser.id==${currentUser.id }">						  		
						  		<a href="javascript:;" ng-click="editComment(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
						  		<a href="javascript:;" ng-click="removeComment(x)"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
						  	</td>
						  </tr>
					  </tbody>
					</table>
			    <div class="panel-footer">
					<div>  
						  <div class="form-group">
						    <label>Comment</label>
					    	<input type="text" class="form-control" ng-model="comment.content">
						  </div> 
						  <button type="button" class="btn btn-default" ng-click="submitComment()">Comment</button>			 
					</div> 
			    </div>
			</div> 
		</div> 		
    </jsp:body>
</x:page>
