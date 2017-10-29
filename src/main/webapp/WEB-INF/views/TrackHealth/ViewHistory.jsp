<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>



<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
	<jsp:body>
		<h1 class="text-left">View History</h1>
									
		<div class="panel panel-info">
			<div class="panel-heading"></div>
			<table class="table table-condensed">
			  <tbody>
			  	<c:forEach items= "${a}" var="d">
				 <tr>	  	
					<td>${a.foodType}</td>
				  </tr>
				  </c:forEach>
			  </tbody>
			</table>
		</div>	  
    </jsp:body>
</x:page>
