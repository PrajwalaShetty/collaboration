app.controller('FriendController',function($scope,$location,FriendService){
	alert('entering friend controller')
	$scope.friends=[];
	$scope.pendingRequest=[]
	$scope.friends= 
		FriendService.getAllFriends()
		.then(function(response){
			console.log('get all Friends controller')
			console.log(response.status)
			$scope.friends= response.data;
		},
		function(response){
			console.log(response.data)
		})
	
	$scope.pendingRequest=
		FriendService.pendingRequest()
		.then(function(response){
			console.log('PENDING REQUEST')
			console.log(response.status);
			$scope.pendingRequest= response.data
			console.log($scope.pendingRequest)
			alert($scope.pendingRequest);
		},function(response){
			console.log(response.status)
		})
	
	$scope.updatePendingRequest=function(fromId,friendStatus){
		alert('updateFriendrequest')
		FriendService.updateFriendRequest(friendStatus,fromId)
		.then(function(response){
			console.log(response.status)
			if(friendStatus=='A'){
			alert('you have accepted the friend request. You and ' + fromId + " are friends");
			$location.path('/friendsList')
			}
			else{
				alert('You have denied the friend requet')
			}
		},function(response){
			console.log(response.log)
		})
	}
})