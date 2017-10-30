<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%> 

<x:page>    
	<jsp:attribute name="script">	
    </jsp:attribute>
	<jsp:body>	 
			<h1 class="text-center">${report.title} </h1> 
			<div class="panel panel-info"> 
			    <div class="panel-body">
			    	${report.content}
			    </div>
			    <div class="panel-footer">
			    	<div class="avatar"> 
		                <img src="${report.createUser.icon}"  class="media-photo"/>  
		                <b class="user-name">${report.createUser.displayName}</b> -  ${report.createDate}
	           
		           </div>
				</div>
			</div> 
    </jsp:body>
</x:page>
