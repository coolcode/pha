angular.module('app', ['angular-loading-bar'])
  .controller('WikiController',['$scope', '$http', function($scope, $http) {
	  $scope.wiki = {};
	  $scope.wikis = []; 
	  
	  $scope.reloadWikis = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/TrackHealth' 
			}).then(function successCallback(r) { 
				 $scope.wiki = {};
				 $scope.wikis = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadWikis();
  }]);