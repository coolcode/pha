<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>


<x:page>
	<jsp:attribute name="script">	  
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_UXHyOwQsMOAEJ_WyW7VJwnOdYZGJs4I&libraries=places"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/map.js"></script>	
    </jsp:attribute>
	<jsp:body>	
		<div>
			<h1 class="text-center">Map</h1> 
			<div class="row">	
				<div class="col-xs-12">	 
			         <div id="map" style="width:100%;height:500px;">
			         </div>
				</div> 
			</div> 
		</div> 
    </jsp:body>
</x:page>