angular.module('app', ['angular-loading-bar'])
  .controller('IntakeController',['$scope', '$http', function($scope, $http) {
	  $scope.entity = {};
	  $scope.entityList = []; 
	  
	  $scope.reload = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/intake' 
			}).then(function successCallback(r) { 
				 $scope.entity = {};
				 $scope.entityList = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	    
	  
	  $scope.reload();
	  
	  $scope.save = function(){	 
		  $http({
			  method: 'POST',
			  url: $.context + '/api/intake',
			  data: $scope.entity
			}).then(function successCallback(r) { 
				 var newentity= r.data;
				 $scope.entityList.push(newentity);
				 $scope.entity = {}; 
				 $scope.reload();
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.edit = function (entity){ 
		  $scope.entity = entity;
	  }
	  
	  
	  $scope.remove = function (entity){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/intake/'+entity.id
			}).then(function successCallback(r) {  
				 $scope.reload();
			  }, function errorCallback(r) { 
		   }); 
	  }
 
  }]);