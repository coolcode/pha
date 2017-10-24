angular.module('app', ['angular-loading-bar'])
  .controller('UserController',['$scope', '$http', function($scope, $http) {
	  $scope.user = {};
	  $scope.users = []; 
	  

	  
	  $scope.submitLogin = function(){	
		  //$scope.user.content = $('#summernote').summernote('code');
		  window.alert("11111")
		  $http({
			  method: 'POST',
			  url: $.context + '/api/user/login',
			  data: $scope.user
			  }).then(function successCallback(r) { 
				 var newAMNT= r.data;
				 $scope.userInfo.push(newAMNT);
				 $scope.userInfo = {};
				// $('#summernote').summernote('code', '');
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  
	  
 

  }]);