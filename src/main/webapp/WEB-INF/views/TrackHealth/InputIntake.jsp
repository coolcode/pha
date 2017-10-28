<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
<jsp:body>
		<h1 class="text-left">Input Daily Intake</h1>
					
		<div class="panel panel-info">
			<div class="panel-heading">Add Your Daily Input Here</div> 
			<div class="container-fluid">
				<div class="row">
				<form class="form-inline" action="">
					<div class="form-group col-sm-offset-1">
						<label for="exampleInputEmail1">Food Type:</label>
				    		<input type="text" class="form-control" id="exampleInputEmail1" placeholder="name">
				  	</div>
				  	<div class="form-group col-sm-offset-1">
				    		<label for="exampleInputPassword1">    Quantity:</label>
				    		<input type="number" class="form-control" id="exampleInputPassword1" placeholder="number">
				 	</div>
				 	<hr/>
				 	<div class="col-sm-offset-4 col-sm-10"><button type="submit" class="btn btn-default">Submit</button></div>	
				</form>
			
				</div>
			</div>
		</div>	  			  
    </jsp:body>
</x:page>
