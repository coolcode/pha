angular.module('app', ['angular-loading-bar'])
  .controller('UserController',['$scope', '$http', function($scope, $http) {
	  $scope.entity = {};
	  $scope.entityList = []; 
	  var apiUrl = $.context + '/api/user';
	  
	  $scope.reloadUsers = function(){
		  $http({
			  method: 'GET',
			  url: apiUrl 
			}).then(function successCallback(r) { 
				 $scope.entity = {};
				 $scope.entityList = r.data; 
				 for(var i in $scope.entityList){
					 $scope.loadRoles($scope.entityList[i]);
				 }
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.loadRoles = function (entity){
		 return  $http({
			  method: 'GET',
			  url: apiUrl  + '/roles/?email='+entity.email,
			}).then(function successCallback(r) {  
				 entity.roles = r.data;
				 return r.data;
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadUsers();
	  
	  $scope.submitUser = function(){	
		  $http({
			  method: 'POST',
			  url: apiUrl,
			  data: $scope.entity
			}).then(function successCallback(r) { 
				 var newentity= r.data;
				 $scope.entityList.push(newentity);
				 $scope.entity = {}; 
				 $scope.reloadUsers();
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.editUser = function (entity){ 
		  $scope.entity = entity; 
	  }
	  
	  $scope.removeUser = function (entity){
		  $http({
			  method: 'DELETE',
			  url: apiUrl + '/'+entity.id
			}).then(function successCallback(r) {  
				 $scope.reloadUsers();
			  }, function errorCallback(r) { 
		   }); 
	  } 	  

	  $scope.assignUserToRole = function(entity, roleName){	
		  $http({
			  method: 'POST',
			  url: apiUrl + '/roles/'+entity.id,
			  data: {name: roleName}
			}).then(function successCallback(r) { 
				 var newentity= r.data;
				 $scope.entityList.push(newentity);
				 $scope.entity = {}; 
				 $scope.reloadUsers();
			  }, function errorCallback(r) { 
		   }); 
	  };
  }]);