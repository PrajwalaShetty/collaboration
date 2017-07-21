app.factory('FriendService',function($http){
	var BASE_URL="/BackendProject"
	var friendService=this;
	
	friendService.getAllFriends=function(){
		console.log('service --- friendRequest');
		return $http.get(BASE_URL + "/getAllFriends");
	}
	friendService.pendingRequest=function(){
		console.log('service --- pending request');
		return $http.get(BASE_URL + "/pendingRequest")
	}
	friendService.updateFriendRequest=function(friendStatus,fromId){
		console.log('service - update friend request')
		return $http.put(BASE_URL + "/updateFriendRequest/" + friendStatus +"/"+fromId)
	}
	return friendService;
})