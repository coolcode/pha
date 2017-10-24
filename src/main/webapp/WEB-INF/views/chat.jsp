<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>

<x:page>      
    <jsp:attribute name="css">
		<link href="${pageContext.request.contextPath}/resources/css/app/chat.css" rel="stylesheet">
    </jsp:attribute>  
    <jsp:attribute name="script">
		<script src="${pageContext.request.contextPath}/resources/js/app/chat.js"></script>
    </jsp:attribute>
	<jsp:body>	
	     <div class="row"  ng-app="app" ng-controller="ChatController">
            <div class="col-xs-12 col-sm-3">
	            <div class="list-group">
				  <a ng-repeat="u in chat_users" href="javascript:;" ng-click="select_user(u)" class="list-group-item chat-user" ng-class="{active : is_selected_user(u)}"> 
				  	<div class="avatar"> 
	                     <img ng-src="{{u.icon}}"  class="media-photo"/>  
	                     <span class="user-name">{{u.displayName}}</span>
	                </div>
				  </a>
				</div>
            </div>
            <div class="col-xs-12 col-sm-9">
                <div class="chat_window">
                    <div class="top_menu">
                        <div class="buttons">
                            <div class="button"><a href="/"></a></div>
                        </div>
     					<div class="title">{{ chat_user.displayName }}</div>
                    </div>
                    <ul class="messages"> 
                            <li ng-repeat="m in msg_list" class="message appeared" ng-class="get_side(m)">
                                <div class="avatar">  
                                    <img ng-src="{{m.sender.icon}}" class="media-photo"/> 
                                </div>
                                <div class="text_wrapper">
                                    <div class="text">
                                    	<span>{{ m.content }}</span>
                                    	<a ng-show="isAttachment(m)" href="${pageContext.request.contextPath}/script/{{m.attachment}}" target="_blank"> 
                                    		<img ng-src="${pageContext.request.contextPath}/resources/img/script.png"/>
										</a>
                                    </div>
                                </div>
                            </li> 
                    </ul>
                    <div class="bottom_wrapper clearfix"> 
                        <div class="message_input_wrapper">
                        	<input ng-model="message" class="message_input" placeholder="Type your message here..."/>  
					  		<a class="x-icon" href="${pageContext.request.contextPath}/script?patient={{chat_user.id}}" ng-click="attach(x)" title="Send Script" uib-popover="Send Script" popover-trigger="'mouseenter'">
					  			<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> 
					  		</a>  
                        </div>
                        <div class="send_message">
                            <div class="text" ng-click="sendMessage(message)">Send</div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </jsp:body>    
</x:page>