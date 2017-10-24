<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Announcement detail page which user enters while clicking specific announcement -->
<x:page>    
	<jsp:attribute name="script">	 
    </jsp:attribute>
	<jsp:body>	

		
			<!-- display announcement detail content -->
			<h1 class="text-center">${announcement.title} </h1> 
			<div class="panel panel-info"> 
			    <div class="panel-body">
			    	${announcement.content}
			    </div>
			    <div class="panel-footer">
			    	<div class="avatar"> 
		                <img src="${announcement.creator.icon}"  class="media-photo"/>  
		                <b class="user-name">${announcement.creator.displayName}</b> -  ${announcement.createDate}
	           
		           </div>
				</div>
			</div>

    </jsp:body>
</x:page>