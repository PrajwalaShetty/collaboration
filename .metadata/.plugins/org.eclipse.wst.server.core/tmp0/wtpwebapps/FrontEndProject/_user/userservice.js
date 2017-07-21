app.factory('UserService',function($http){
	var userService=this;
	var BASE_URL="/BackendProject"
		
	userService.authenticate=function(user){
		console.log('Entering - submit function in userservice')

		return $http.post(BASE_URL + "/login",user);
	}
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL + "/register",user) 
	}
	
	userService.logout=function(){
		console.log('Entering - logout function in userservice')
		return $http.put(BASE_URL + "/logout") 
	}
	
	
	userService.getAllUsers=function(){
		console.log('entering getallusers in user service')
		return $http.get(BASE_URL +"/getUsers")
	}
	
	userService.friendRequest=function(username){
		console.log('service --- friendRequest');
		return $http.post(BASE_URL+ '/friendRequest',username);
	}
	
	return userService;
})
