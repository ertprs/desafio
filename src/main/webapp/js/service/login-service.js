appUserManager.service('loginService', function($scope, $http, $location) {

	this.login = login;

	function login(usuario) {
		$http.post("/login", usuario).then(function(response) {
			userIn = JSON.stringify(response.data);
			localStorage.setItem('userIn', userIn);
		}, function(response) {
			window.alert("Login e/ou Senha Invalidos!");
		})
	}
})