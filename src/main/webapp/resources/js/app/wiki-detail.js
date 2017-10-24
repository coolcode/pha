angular.module('app', ['angular-loading-bar'])
  .controller('WikiDetailController',['$scope', '$http', function($scope, $http) {
	  $scope.comment = {};
	  $scope.comments = []; 
	  $scope.init =  function(wikiId){
		  $scope.wikiId = wikiId;
		  console.log("wiki: "+ $scope.wikiId);
		  $scope.loadwiki();		  
	  }
	  
	  $scope.loadwiki = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/wiki/'+  $scope.wikiId 
			}).then(function successCallback(r) {  
				 $scope.wiki = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }	  
	  

  }]);