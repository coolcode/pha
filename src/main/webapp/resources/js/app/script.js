angular.module('app', ['angular-loading-bar'])
  .controller('ScriptController',['$scope', '$http', '$window', function($scope, $http, $window) {
	  $scope.script = {"medicines":[]};
	  $scope.medicines = []; 
	  $scope.init =  function(patientId){
		  $scope.patientId = patientId; 
		  $scope.loadUser(patientId);
		  $scope.reloadMedicines();		  
	  }
	  
      $scope.loadUser = function (userId){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/user/' + userId
			}).then(function successCallback(r) {
				if(r.data){
					$scope.patient = r.data; 
					$scope.script.patient = r.data; 
				}		    	  			      
			  }, function errorCallback(r) { 
		   }); 
      };
      
	  $scope.reloadMedicines = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/script/medicines'
			}).then(function successCallback(r) {  
				 $scope.medicines = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }	  	  
 
	  $scope.submitScript = function(){	
		  if( $scope.script.medicines.length ==0){
			  alert("A script's medicines cannot be empty.");
			  return;
		  }
		  
		  $http({
			  method: 'POST',
			  url: $.context + '/api/script',
			  data: $scope.script
			}).then(function successCallback(r) { 
				$window.location.href =  $.context + '/chat/?chat_user_id='+$scope.patientId;
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.addMedicine = function(medicine){		   
		   $scope.script.medicines.push(medicine); 
	  };

	  $scope.removeMedicine = function (medicine){ 
		  var index = $scope.script.medicines.indexOf(medicine);
		  $scope.script.medicines.splice(index, 1); 
	  }
	   
  }]);