<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
<jsp:body>
<h1 class="text-left">Quiz Management Page</h1>
	<div ng-app="app" ng-controller="QuizController">					
		<div class="panel panel-info">
			<div class="panel-heading">Quiz</div>  
			<table  class="table table-condensed" >
			 
			  <tbody ng-repeat="x in quiz">
			  
			   <tr>
                  <td><strong>ID</strong></td>
                  <td><span>{{x.ID}}</span></td>
               </tr> 
               <tr>   
                  <td><strong>Name</strong></td>
                  <td><span>{{x.name}}</span></td>
                  <td rowspan="4" width=200px;>
                        <a href="javascript:;" ng-click="editQuiz(x)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
				  		<a href="javascript:;" ng-click="removeQuiz(x)" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                  </td>
              </tr>
			  
			  <tr>
                 <td width=10px;><strong>Description</strong></td>
                 <td><span>{{x.description}}</span></td>
              </tr>
              
            
				
			  </tbody>
			</table>



<div class="panel-footer">	
					 
				  <div class="form-group" aria-hidden="true">
				  <label>ID</label>
				  <input type="int"	class="form-control" ng-model="quiz.ID">	
				  </div>
				  <div class="form-group" aria-hidden="true">	    
				  <label>Name</label>
				    <input type="text" class="form-control" ng-model="quiz.name">
				  </div>
				  <div class="form-group" aria-hidden="true">
				    <label>Description</label>
				    <input type="text" class="form-control" ng-model="quiz.description">
				  </div> 
				  <button type="button" class="btn btn-default" ng-click="submitQuiz()">Post</button>	 
			</div> 



</script>			  
    </jsp:body>
</x:page>
