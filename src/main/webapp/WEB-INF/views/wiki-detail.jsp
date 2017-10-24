<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>    
	<jsp:attribute name="script">	 
		<%-- <script src="${pageContext.request.contextPath}/resources/js/app/wiki-detail.js"></script>	 --%>
    </jsp:attribute>
	<jsp:body>	
		<%-- <div ng-app="app" ng-controller="WikiDetailController" ng-init="init(${wiki.id})"> --%>
			<!-- wiki -->	
			<h1 class="text-center">${wiki.title} </h1> 
			<div class="panel panel-info"> 
			    <div class="panel-body">
			    	${wiki.content}
			    </div>
			    <div class="panel-footer">
			    	<div class="avatar"> 
		                <img src="${wiki.createUser.icon}"  class="media-photo"/>  
		                <b class="user-name">${wiki.createUser.displayName}</b> -  ${wiki.createDate}
	           
		           </div>
				</div>
			</div> 
    </jsp:body>
</x:page>
