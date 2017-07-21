app.controller('JobController',function($scope,$location,JobService){
	$scope.job={jobTitle:'',jobDescription:'',skillsRequired:'',salary:'',location:''}
	// we can assign any function or variable to this $scope
	//$location will rediect to perticulr html page 
	$scope.jobs={}
	$scope.saveJob=function(){
		console.log('entering save job in job controller')
		JobService.saveJob($scope.job)
		.then(function(response){
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path('/home');
		},function(response){
			console.log("failure " +response.status);
			if(response.ststus==401){
				$location.path('/login')
			}
			else{ 
//			console.log(response.data.message)
			$location.path('/postJob')
			}
		})
	};
	
	function getAllJobs(){
		console.log('entering get All jobs')
		JobService.getAllJobs()
		.then(function(response){
			console.log(response.status); //200
			$scope.jobs=response.data;  //List<Job>
			
		},function(response){
			console.log(response.status)
		})
	}
	getAllJobs();
	
	
	

	$scope.deleteJob=function(id){
			
			console.log("entering delete method in controller with id"+ id);
			JobService.deleteJob(id)
			.then(
			
					function(d){
						
						console.log("deleted Successfylly");
						console.log(d);
						
						$location.path('/getAllJobs')
					},function(){
						console.log("Unable to delete");
						
					})
		}
//	$scope.getJobById=function(jobId) {
//		
//		console.log('entering get jobs by Id')
//		JobService.getJobById(jobId)
//		
//		.then(function(response){
//			$scope.jobs1=response.data;  // single Job object
//			console.log(response.status); //200
//			
//		},function(response){
//			console.log(response.status)
//		})
//		
//	};
	

})