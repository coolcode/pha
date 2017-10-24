
<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>


<x:base>
	<jsp:attribute name="script">	  
		<script src="${pageContext.request.contextPath}/resources/js/app/register.js"></script>	
    </jsp:attribute>
	<jsp:body>	
	
		<div ng-app="app" ng-controller="UserController">
		 <form method="post" action="register" >
            <div class="form-group">
            	<h6 class="text-center">${message}</h6>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="username" placeholder="Username">
            </div>
            <div class="form-group">
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="password_confirm" placeholder="Comfirm Password">
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <div class="radio">
                        <label class="control-label">
                            <input type="radio" name="type" value="doctor">Doctor</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="radio">
                        <label class="control-label">
                            <input type="radio" name="type" value="patient"checked>Patient</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button class="btn btn-default form-control" type="submit" value="register">Submit Registration</button>
            </div>
            <div class="form-group">
            	<a href="login" class="forgot">I have an account</a>
            </div>
		</div>
    </jsp:body>
</x:base>
