<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    </jsp:attribute> 
    <jsp:attribute name="script">	 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/announcement.js"></script> 
    </jsp:attribute>
<jsp:body>
<h1 class="text-left">Announcements</h1>
<div ng-app="app" ng-controller="AnnouncementController">					
		<div class="panel panel-info">
			<div class="panel-heading">Welcome to PHA Announcement Board!</div>  
			<table class="table table-condensed">
			  <tbody>
				  <tr ng-repeat="x in announcements">
				
				  	<td><img ng-src="{{x.creator.icon}}"> <span>{{x.creator.displayName}}</span><td>	  	
					<td width=300px;><a href="${pageContext.request.contextPath}/announcement/{{x.id}}">{{x.title}}</a></td>
					<!-- <td ng-bind-html= "x.content"><br></td> -->		
				  	<td>{{x.createDate}}</td>
				  	<td ng-show="x.creator.id==${currentUser.id}">
				  		<a href="javascript:;" ng-click="editAnnouncement(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="removeAnnouncement(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				  	
				  	</td>
				  </tr>
			  </tbody>
			</table>
				
			<div class="panel-footer" ng-show="${ifUserisDoctor = true}" >	
					 
				  <div class="form-group" aria-hidden="true">
				    <label>Title</label>
				    <input type="text" class="form-control" ng-model="announcement.title">
				  </div>
				  <div class="form-group" aria-hidden="true">
				    <label>Content</label>
				     <div id="summernote"></div> 
				  </div> 
				 <div class="form-check">
					  <label class="form-check-label">
					  <!-- checkbox of send email to users -->
					    <input class="form-check-input" type="checkbox" value="" ng-model="announcement.ifSendEmail"
					    ng-true-value="true" ng-false-value="false">
					    Send announcement via Email to all users.
					  </label>
				</div>
				  <br><button type="button" class="btn btn-default" ng-click="submitAnnouncement()">Post</button>	 
			</div> 
		</div>		  
</div>	  			  
    </jsp:body>
</x:page>
