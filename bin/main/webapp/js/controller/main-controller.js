appUserManager.controller("mainController", function($scope, $http, $location) {
	$scope.logInOutButton = 'Login';

	$scope.logout = function() {
		$scope.logInOutButton = 'Logout'
		localStorage.removeItem('userIn');
		$location.path('/login')
	}
});