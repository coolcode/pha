angular.module('app', ['angular-loading-bar'])
  .controller('HealthReportController',['$scope', '$http', function($scope, $http) {
	  $scope.wiki = {};
	  $scope.wikis = []; 
	  
	  $scope.reloadWikis = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/health-report' 
			}).then(function successCallback(r) { 
				 $scope.wiki = {};
				 $scope.wikis = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	    
	  $scope.reloadUsers = function(){
		  $http({
			  method: 'GET',
			  url:  $.context + '/api/user/simpleUsers' 
			}).then(function successCallback(r) {  
				 $scope.userList = r.data;  
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadWikis();
	  $scope.reloadUsers();
	  
	  $scope.submitWiki = function(){	
		  $scope.wiki.content = $('#summernote').summernote('code');
		  $http({
			  method: 'POST',
			  url: $.context + '/api/health-report',
			  data: $scope.wiki
			}).then(function successCallback(r) { 
				 var newwiki= r.data;
				 $scope.wikis.push(newwiki);
				 $scope.wiki = {};
				 $('#summernote').summernote('code', '');
				 $scope.reloadWikis();
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.editWiki = function (wiki){ 
		  $scope.wiki = wiki;
		  $('#summernote').summernote('code', wiki.content);
	  }
	  
	  $scope.addUser = function (user){ 
		  $scope.wiki.user  = user ; 
	  }
	  
	  $scope.removeWiki = function (wiki){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/health-report/'+wiki.id
			}).then(function successCallback(r) {  
				 $scope.reloadWikis();
			  }, function errorCallback(r) { 
		   }); 
	  }

	  $scope.searchWiki = function (){ 
		  var title = $scope.wiki.title;

		  $http({
			  method: 'POST',
			  url: $.context + '/api/health-report/search',
			  data: $scope.wiki
			}).then(function successCallback(r) {  
				 var content = r.data.content;
			     $('#summernote').summernote('code', content);
			  }, function errorCallback(r) { 
		   }); 
		  
	  }
	  
	  var uploadImage =  function (image) {
	        var data = new FormData();
	        data.append("file",image);
	        $http({
				  method: 'POST',
				  url: $.context + '/api/image/upload',
		          data: data,
		          withCredentials: true,
		          headers: {'Content-Type': undefined },
		          transformRequest: angular.identity
				}).then(function successCallback(r) {  	            	
	                var image = r.data.url;
                  console.log("url: "+ image);
	                $('#summernote').summernote("insertImage", image);
				}, function errorCallback(r) {
	                 console.log(r); 
			 }); 
	   };
	
    $('#summernote').summernote({
        placeholder: '',
        tabsize: 2,
        height: 400,
        callbacks : {
            onImageUpload: function(images) {
        		console.log("image:"+ images.length);
            	for(var i=0;i<images.length;i++){
                	uploadImage(images[i]);
            	}
            }
        }
    });
  }]);