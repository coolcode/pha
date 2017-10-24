angular.module('app', ['angular-loading-bar'])
  .controller('HomeController',['$scope', '$http', function($scope, $http) { 
	  $scope.wikis = []; 
	  $scope.posts = [];
	  
	  $scope.reloaPosts = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/forum/post/top/10' 
			}).then(function successCallback(r) {  
				 $scope.posts = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadWikis = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/wiki/top/10' 
			}).then(function successCallback(r) {  
				 $scope.wikis = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloaPosts();
	  $scope.reloadWikis(); 

  }]);