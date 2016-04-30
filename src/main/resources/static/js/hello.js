angular.module('hello', [])
       	.controller('home', function($scope, $http) {
       		$http.get('/resource/').success(function(data) {
       			$scope.greeting = data;
       		})
       	}).controller('demo', function($scope, $http) {

       		$http.get("/buttonPresses").success(function(data) {
       			$scope.mydata = data;
       		})


       		$scope.clickedButton = function() {
       			$http.post('/pressButton', null)
       			.success(function(data){

       				$scope.mydata = data;
       				console.log("Success");
       			})
       			.failure(function() {
       				console.log("Failure");
       			})

       		}
       	});