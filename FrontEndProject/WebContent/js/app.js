var app=angular.module("myApp",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	console.log('entering configuration')
	$routeProvider
	
	.when('/login',{
		controller:'UserController',
		templateUrl:'_user/login.html'
	})
	
	//***** profile *******
		.when('/uploadPicture',{
	
		templateUrl:'_user/uploadFile.html'
	})
	
	.when('/home',{
		templateUrl:'_home/home.html'
	})
	.when('/register',{
		controller:'UserController',
		templateUrl:'_user/register.html'
	})
		
	
	//************ job *********
	.when('/postJob',{
		controller:'JobController',
		templateUrl:'_job/createJob.html'
	})
	.when('/getAllJobs',{
		controller:'JobController',  // write a function to get all jobs from the backend => JobService
		templateUrl:'_job/jobs.html'  // to display the job titles in html page
	})
	
	.when('/editJob/:id',{
		controller:'EditController',
		templateUrl:'_job/editJob.html'
	})
	
	// ******* friend**********
	.when('/friendsList',{
			controller:'FriendController',
		templateUrl:'_friend/listOfFriends.html'
	})
	.when('/pendingRequest',{
		controller:'FriendController',
		templateUrl:'_friend/pendingRequest.html'
		
	})
	.when('/getAllUsers',{
		controller:'UserController',
		templateUrl:'_user/listOfUsers.html'
			
	})
	
	//******* blog *******
	
	
.when('/addPost',{
		controller:'BlogController',
		templateUrl:'_blog/newPost.html'
	})
	.when('/getAllBlogs',{
		controller:'BlogController',
		templateUrl:'_blog/blogList.html'
	})
       .when('/getBlogDetail/:id',{
		controller:'BlogDetailController',
		templateUrl:'_blog/getBlogDetail.html'
	})
		
	.when('/edit/:id',{
		controller:'EditController',
		templateUrl:'_blog/editBlog.html'
	})
	
	
	
	//********** chat *******
	.when('/chat',{
		controller:'ChatController',
		templateUrl:'_chat/chat.html'
	})
})
//	.when('/viewjobapply',{
//	controller:'JobController',
//	templateUrl:'__job/viewjobapply.html'
//})

//	.when('/getJobById/(jobId)',{
//		controller:'JobController',  // write a function to get all jobs from the backend => JobService
//		templateUrl:'_job/jobdetail.html'  // to display the job titles in html page
//	})

app.run(function($cookieStore,$rootScope,$location,UserService){  //entry point
	
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get('currentUser')
		
	$rootScope.logout=function(){
		console.log('logout function')
		delete $rootScope.currentUser;
		$cookieStore.remove('currentUser')
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$rootScope.message="Logged out Successfully";
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
		
	}	
})