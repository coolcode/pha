<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>     
    <jsp:attribute name="css">
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    </jsp:attribute> 
    <jsp:attribute name="script">	 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/forum.js"></script> 
    </jsp:attribute>
	<jsp:body>	
	<h1 class="text-center">Discussion Board</h1>
	<div ng-app="app" ng-controller="ForumController">					
		<div class="panel panel-info">
			<div class="panel-heading">Welcome to PHA discussion board!</div>
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in posts">
				  	<td><img ng-src="{{x.createUser.icon}}"> <span>{{x.createUser.displayName}}</span><td>	  	
					<td><a href="${pageContext.request.contextPath}/forum/post/{{x.id}}">{{x.title}}</a></td>
				  	<td>{{x.createDate}}</td>
				  	<td ng-show="x.createUser.id==${currentUser.id}">
				  		<a href="javascript:;" ng-click="editPost(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="removePost(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				  	
				  	</td>
				  </tr>
			  </tbody>
			</table>
			<div class="panel-footer">		 
				  <div class="form-group">
				    <label>Title</label>
				    <input type="text" class="form-control" ng-model="post.title">
				  </div>
				  <div class="form-group">
				    <label>Content</label>
				     <div id="summernote"></div> 
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="submitPost()">Post</button>			 
			</div> 
		</div>
	</div>
    </jsp:body>
</x:page>
