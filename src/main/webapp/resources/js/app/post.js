angular.module('app', ['angular-loading-bar'])
  .controller('PostController',['$scope', '$http', function($scope, $http) {
	  $scope.comment = {};
	  $scope.comments = []; 
	  $scope.init =  function(postId){
		  $scope.postId = postId;
		  console.log("post: "+ $scope.postId);
		  $scope.reloadComments();		  
	  }
	  
	  $scope.reloadComments = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/forum/post/'+  $scope.postId +'/comments' 
			}).then(function successCallback(r) { 
				 $scope.comment = {};
				 $scope.comments = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }	  
	  
	  $scope.submitComment = function(){	
		  //$scope.comment.content = $('#summernote').summernote('code');
		  $http({
			  method: 'POST',
			  url: $.context + '/api/forum/post/'+  $scope.postId +'/comment',
			  data: $scope.comment
			}).then(function successCallback(r) { 
				 var newcomment = r.data;
				 $scope.comments.push(newcomment);
				 $scope.comment = {};
				 $scope.reloadComments();
			  }, function errorCallback(r) { 
		   }); 
	  };

	  $scope.editComment = function (comment){ 
		  $scope.comment = comment; 
	  }
	  
	  $scope.removeComment = function (comment){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/forum/comment/'+comment.id
			}).then(function successCallback(r) {  
				 $scope.reloadComments();
			  }, function errorCallback(r) { 
		   }); 
	  } 

  }]);