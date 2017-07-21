app.controller('EditController',function($scope,$routeParams,$location,BlogService){
	//  /edit/:id
	//   /edit/230
	console.log('entering editcontroller ');
	// $routeParams object read the value from the URL path - read the value of id
	var id=$routeParams.id;
	
	$scope.blog=BlogService.getBlogDetail(id)
	.then(function(response){
		console.log(response.status)
		$scope.blog= response.data;
	},null)
	//Display the value in editPerson.html page
	$scope.update=function(){
		console.log('update function in editcontroller')
		BlogService.updateBlog(id,$scope.blog)
	.then(
			//response - object contains details like data, status 
			function(response){
		console.log(response.status)
		$location.path('/getAllBlogs')
		},function(response){
			console.log(response.status)
		})
	}
})
