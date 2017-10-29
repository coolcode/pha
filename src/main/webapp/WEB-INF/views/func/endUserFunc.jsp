<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Demo -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
<jsp:body>
		<h1 class="text-left">Demo</h1>
					
		<div class="panel panel-info">
			<div class="panel-heading">!</div> 
			<a href="${pageContext.request.contextPath}/demo/index2">Index 2</a>
		</div>	  			  
    </jsp:body>
</x:page>
