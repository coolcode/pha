angular.module('app', ['angular-loading-bar'])
  .controller('ChatController',['$scope', '$http', '$location', function($scope, $http, $location) {
	  $scope.chat_users = [];
	  $scope.chat_user = {};
	  $scope.current_user = {};
	  	  
	  $scope.msg_list = []; 
	  
	  $scope.select_user = function (user){
		  $scope.chat_user = user; 
		  $scope.load_msg (user.id);
	  };
	  
	  $scope.is_selected_user =  function (user){
		  return $scope.chat_user == user;
	  };
	  
      $scope.add_chat_user = function (user_id){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/user/' + user_id
			}).then(function successCallback(r) {
				if(r.data){
					$scope.chat_user = r.data;
					$scope.chat_users.unshift(r.data); 
				}		    	  			      
			  }, function errorCallback(r) { 
		   }); 
      };
      
	  $scope.load_chat_users = function(){
		  $http({
			  method: 'GET', 
			  url: $.context + '/api/message/chat_users'
			}).then(function successCallback(r) {  
				 $scope.chat_users = r.data; 
				 var chat_user_id = $.url().param('chat_user_id');
				 console.log(chat_user_id);
		          if(chat_user_id){
		        	  var user_in_list = false;
		        	  for(var i=0;i<$scope.chat_users.length;i++ ){
		        		  if($scope.chat_users[i].id==chat_user_id){
					    	  $scope.select_user($scope.chat_users[i]);	
					    	  user_in_list = true;
					    	  break;
		        		  }
		        	  }
		        	  
		        	  if(!user_in_list){
			        	  $scope.add_chat_user(chat_user_id);		        		  
		        	  }
		        	  
		          }else{
				      if($scope.chat_users.length>0){
				    	  $scope.select_user($scope.chat_users[0]);
				      }
		          }
			      
			  }, function errorCallback(r) { 
		   }); 
	  };	  

	  $scope.load_current_user = function(){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/user/current'  
			}).then(function successCallback(r) {  
				 $scope.current_user = r.data;  			      
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.load_msg = function(chat_user_id){
		  $http({
			  method: 'GET',
			  url: $.context + '/api/message',//?chat_user_id='+chat_user_id,
			  params: {"chat_user_id":chat_user_id}
			}).then(function successCallback(r) {  
				 $scope.msg_list = r.data; 
			  }, function errorCallback(r) { 
		   }); 
	  };
	  
	  $scope.get_side =  function(msg){
		  return msg.sender.id == $scope.chat_user.id? "left":"right";
	  };
	  
	  $messages = $('.messages');	  
	  
	  $scope.sendMessage = function(content){		  
		  var msgModel = {content: content, receiver: $scope.chat_user };
		  $http({
			  method: 'POST',
			  url: $.context + '/api/message',
			  data: msgModel
			}).then(function successCallback(r) {   
				 $scope.msg_list.push(r.data);
				 $scope.message = '';
				 $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
			  }, function errorCallback(r) { 
		   }); 
	  };

	  $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);

      $('.message_input').keydown(function (e) {
          if (e.which === 13) {
             $scope.sendMessage($('.message_input').val());
          }
      });

      //$scope.load_current_user();
      $scope.load_chat_users();
     
      $scope.isAttachment = function(msg){
    	  var r = msg.attachment && msg.attachment>0;
    	  //console.log("isAttachment: "+ r);
    	  return r;
      }
  }]);