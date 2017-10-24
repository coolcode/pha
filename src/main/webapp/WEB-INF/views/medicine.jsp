<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<%@page import="com.meecat.doctorapp.service.MedicineService,com.meecat.doctorapp.domain.Medicine"%>

<x:page> 
    <jsp:attribute name="css">
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    </jsp:attribute> 
    <jsp:attribute name="script">	 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app/medicine.js"></script> 
    </jsp:attribute>
<jsp:body>
<h1 class="text-left">Medicine Management Page</h1>
	<div ng-app="app" ng-controller="MedicineController">					
		<div class="panel panel-info">
			<div class="panel-heading">Medicine</div>  
			<table  class="table table-condensed" >
			  <tr>
			    <td>Picture</td>
			    <td>Detail</td>
			     <td></td>
			    <td>Operation</td>
		        
			  </tr>
			  <tbody ng-repeat="x in medicines">
			  
			   <tr>
                  <td rowspan="4" width=200px;><img style="width:200px;height:200px;" ng-src="{{x.picture}}"></td>
                  <td><strong>Name</strong></td>
                  <td><span>{{x.name}}</span></td>
                  <td rowspan="4" width=200px;>
                        <a href="javascript:;" ng-click="editMedicine(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="removeMedicine(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                  </td>
              </tr>
			  
			  <tr>
                 <td width=10px;><strong>Description</strong></td>
                 <td><span>{{x.description}}</span></td>
              </tr>
              
              <tr>
                 <td><strong>Price</strong></td>
                 <td><span>{{x.price}}</span></td>
              </tr>
              <tr>
                 <td><strong>Quantity</strong></td>
                 <td><span>{{x.quantity}}</span></td>
              </tr>
				
			  </tbody>
			</table>
			
			
				
			<div class="panel-footer">	
					 
				  <div class="form-group" aria-hidden="true">
				    <label>Name</label>
				    <input type="text" class="form-control" ng-model="medicine.name">
				  </div>
				  <div class="form-group" aria-hidden="true">
				    <label>Description</label>
				    <input type="text" class="form-control" ng-model="medicine.description">
				  </div> 
				  <div class="form-group" aria-hidden="true">
				    <label>Price</label>
				    <input type="text" class="form-control" ng-model="medicine.price">
				  </div> 
				  <div class="form-group" aria-hidden="true">
				    <label>Quantity</label>
				    <input type="text" class="form-control" ng-model="medicine.quantity">
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="submitMedicine()">Post</button>	 
			</div> 
		</div>		  
</div>

	  			  
    </jsp:body>
</x:page>