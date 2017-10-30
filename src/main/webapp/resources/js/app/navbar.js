angular.module('app')
  .controller('NavbarController',['$scope', '$http', function($scope, $http) { 
	  $scope.user = {role : 'ROLE_USER'};
	  $scope.loadUserRole = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/user/myroles' 
			}).then(function successCallback(r) { 
				console.log("role: "+ r.data);
				if(r.data && r.data.length>0 ){
					$scope.user.role = r.data[0]; 
				}
				 
			  }, function errorCallback(r) { 
		   }); 
	  } 
	  
	  $scope.loadUserRole(); 

  }]);