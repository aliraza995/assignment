/**
 * Fizz Buzz script
 */
angular.module('app', []);
angular
  .module('app')
  .controller('FizzBuzzCtrl', function($scope, $http) {

    $scope.perform = function() {
    	var data = { 'action' : $scope.userAction }
    	$http.post('/assignment-webapp/rest/fizzbuzz', data, { 'headers' : { 'content-type' : 'application/json' } })
        .success(function (data) {
        	$scope.response = data.value;
        }).error(function (data, status) {
            if (status == 400) {
            	$scope.apiError = data.endUserMessage;
            } else if (status == 500) {
            	$scope.apiError = "unable to perform action"
            }
        });
    };
});
