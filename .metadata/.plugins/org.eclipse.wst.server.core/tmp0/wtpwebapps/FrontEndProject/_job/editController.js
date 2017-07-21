app.controller('EditController',function($scope,$routeParams,$location,JobService){
	//  /edit/:id
	//   /edit/230
	console.log('entering editcontroller ');
	// $routeParams object read the value from the URL path - read the value of id
	var id=$routeParams.id;
	
	$scope.job=JobService.getJobDetail(id)
	.then(function(response){
		console.log(response.status)
		$scope.job= response.data;
	},null)
	//Display the value in editJob.html page
	$scope.update=function(){
		console.log('update function in editcontroller')
		JobService.updateJob(id,$scope.job)
	.then(
			//response - object contains details like data, status 
			function(response){
		console.log(response.status)
		$location.path('/getAllJobs')
		},function(response){
			console.log(response.status)
		})
	}
})
