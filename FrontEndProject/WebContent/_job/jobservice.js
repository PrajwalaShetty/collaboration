app.factory('JobService',function($http){
	var jobService={};
	var BASE_URL="/BackendProject"
	jobService.saveJob=function(job){
		return $http.post(BASE_URL + "/postJob" , job);
		// it returns response object
	}
	
	jobService.getAllJobs=function(){
		return $http.get(BASE_URL + "/getAllJobs");
	}	// it returns jobservice object to be used in controller further
		
	
	jobService.getJobDetail=function(id){
		console.log('getJobDetails')
		return $http.get("/BackendProject/job/"+ id)
	};
	
	
jobService.deleteJob=function(id){
		
		console.log("entering delete job in service with id"+id);
		return $http.delete(BASE_URL + "/job/"+id)
		.then(function(response){
			console.log(response.status)
					return response.status;
		},function(response){
			
			console.log(response.status)

		});

	};
	
	
	jobService.updateJob=function(id,job){
		console.log('update job in service')
		console.log('job id ' + id)
		return $http.put(BASE_URL + "/job/"+id, job);
	}
	
	return jobService;
})
	
//	return jobService;