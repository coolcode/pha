angular.module('app', ['angular-loading-bar'])
  .controller('ScriptDetailController',['$scope', '$http', '$window', function($scope, $http, $window) {
	  $scope.script = {"medicines":[]}; 
	  $scope.init =  function(scriptId){ 
		  $scope.loadScript(scriptId);   
	  }
	  
      $scope.loadScript = function (scriptId){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/script/' + scriptId
			}).then(function successCallback(r) {
				if(r.data){
					$scope.script = r.data;  
				}		    	  			      
			  }, function errorCallback(r) { 
		   }); 
      };
      
  }]);