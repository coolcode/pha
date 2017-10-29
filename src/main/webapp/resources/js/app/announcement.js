angular.module('app', ['angular-loading-bar'])
  .controller('AnnouncementController',['$scope', '$http', function($scope, $http) {
	  $scope.announcement = {};
	  $scope.announcements = []; 
//directly mapping to AnnouncementRestController via URLs  
//reload function used for getting json data from restcontroller.
	  $scope.reloadAnnouncements = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/amnt/announcements' 
			}).then(function successCallback(r) { 
				 $scope.announcement = {};
				 $scope.announcements = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
	  $scope.reloadAnnouncements();
//Deliver the information that the user manipulated from front end.
	  $scope.submitAnnouncement = function(){	
		  $scope.announcement.content = $('#summernote').summernote('code');
		  $http({
			  method: 'POST',
			  url: $.context + '/api/amnt/announcement',
			  data: $scope.announcement
			}).then(function successCallback(r) { 
				 var newAMNT= r.data;
				 $scope.announcements.push(newAMNT);
				 $scope.announcement = {};
				 $('#summernote').summernote('code', '');
				 $scope.reloadAnnouncements();
			  }, function errorCallback(r) { 
		   }); 
	  };
//Edit the announcement and post again.	  
	  $scope.editAnnouncement = function (announcement){ 
		  $scope.announcement = announcement;
		  $('#summernote').summernote('code', announcement.content);
	  }
	  
	  $scope.removeAnnouncement = function (announcement){
		  $http({
			  method: 'DELETE',
			  url: $.context + '/api/amnt/announcement/'+announcement.id
			}).then(function successCallback(r) {  
				 $scope.reloadAnnouncements();
			  }, function errorCallback(r) { 
		   }); 
	  }
	  
//Customize image upload process using Cloudinary API	
//Connecting with ImageRestController
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
	  
//Integrating the text input into Bootstrap Summernote.
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