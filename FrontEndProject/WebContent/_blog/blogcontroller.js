app.controller('BlogController',function($scope,$location,BlogService){
	$scope.blogPost={};
	
	$scope.blogPosts=[]
	$scope.submit=function(){
		console.log('submit in blog controller to add new post')
		BlogService.addPost($scope.blogPost)
		.then(function(response){
			console.log(response.data);
			console.log(response.status);
			alert("successfully added")
			$location.path('/getBlogs')
			
		},function(response){
			console.log(response.data);
			console.log(response.status);
		})
	}
	$scope.blogPosts=BlogService.getBlogPosts()
	.then(function(response){
		console.log(response.status)
		console.log(response.data)
		$scope.blogPosts=response.data
	},function(response){
		console.log(response.status)
		console.log(response.data)
	})
	
	
$scope.deleteBlog=function(id){
		
		console.log("entering delete method in controller with id"+ id);
		BlogService.deleteBlog(id)
		.then(
		
				function(d){
					
					console.log("deleted Successfylly");
					console.log(d);
					
					$location.path('/getAllBlogs')
				},function(){
					console.log("Unable to delete");
					
				})
	}
})