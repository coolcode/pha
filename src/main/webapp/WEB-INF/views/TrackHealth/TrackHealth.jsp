<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/font-awesome.min.css">
    		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/TrackHealth.css">
    		<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
	<jsp:body>
		<div id="headerwrap">
			<div align="center" >
			<h1>Track Health Status</h1>
				<div class="column port-space">
					<div class="col-lg-12 port-space">
					</div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-8 port-space">
						<a href="${pageContext.request.contextPath}/TrackHealth/input"><h2>Input Daily Intake</h2></a>
					</div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-8 port-space">
						<a href="${pageContext.request.contextPath}/TrackHealth/result"><h2>View Analyze Result</h2></a>
					</div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-2 port-space"></div>
					<div class="col-xs-8 port-space">
						<a href="${pageContext.request.contextPath}/TrackHealth/history"><h2>View History</h2></a>
					</div>
					<div class="col-xs-2"></div>	
				</div>
			</div><!-- /container -->
		</div><!-- /headerwrap -->
		  			  
    </jsp:body>
</x:page>
