angular.module('app', ['angular-loading-bar'])
  .controller('MedicineController',['$scope', '$http', function($scope, $http) {
	  $scope.medicine = {};
	  $scope.medicines = []; 
	  
	  $scope.reloadMedicines = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/medicine' 
			}).then(function successCallback(r) { 
				 $scope.medicine = {};
				 $scope.medicines = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadMedicines();
	  
	  $scope.submitMedicine = function(){	
		  $http({
			  method: 'POST',
			  url: $.context + '/api/medicine',
			  data: $scope.medicine
			}).then(function successCallback(r) { 
				 var newMedicine= r.data;
				 $scope.medicines.push(newMedicine);
				 $scope.medicine = {};
				 $scope.reloadMedicines();
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.editMedicine = function (medicine){ 
		  $scope.medicine = medicine;
		 
	  }
	  
	  $scope.removeMedicine = function (medicine){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/medicine/'+medicine.id
			}).then(function successCallback(r) {  
				 $scope.reloadMedicines();
			  }, function errorCallback(r) { 
		   }); 
	  }
 
 

  }]);