angular.module('app', ['angular-loading-bar'])
  .controller('ForumController',['$scope', '$http', function($scope, $http) {
	  $scope.post = {};
	  $scope.posts = []; 
	  
	  $scope.reloadPosts = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/forum/posts' 
			}).then(function successCallback(r) { 
				 $scope.post = {};
				 $scope.posts = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadPosts();
	  
	  $scope.submitPost = function(){	
		  $scope.post.content = $('#summernote').summernote('code');
		  $http({
			  method: 'POST',
			  url: $.context + '/api/forum/post',
			  data: $scope.post
			}).then(function successCallback(r) { 
				 var newpost= r.data;
				 $scope.posts.push(newpost);
				 $scope.post = {};
				 $('#summernote').summernote('code', '');
				 $scope.reloadPosts();
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.editPost = function (post){ 
		  $scope.post = post;
		  $('#summernote').summernote('code', post.content);
	  }
	  
	  $scope.removePost = function (post){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/forum/post/'+post.id
			}).then(function successCallback(r) {  
				 $scope.reloadPosts();
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
          height: 200,
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