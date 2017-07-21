app.controller("ChatController", function($scope,$rootScope ,ChatService) {
    $scope.messages = [];
    $scope.message = "";
    $scope.max = 300;
    
    $scope.addMessage = function() {
      ChatService.send($rootScope.currentUser.username + " : " + $scope.message);
      $scope.message = "";
    };
    
    ChatService.receive().then(null, null, function(message) {
      $scope.messages.push(message);
      // whenever i receive any new message i want to push it to the messages array
    });
  });