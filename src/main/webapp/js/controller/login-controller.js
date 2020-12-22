appUserManager.controller("loginController", function($scope, $http, $location,
		Operador) {
	$scope.usuario = {};
	$scope.token = "";

	$scope.login = function() {
		$http.post("/login", $scope.usuario).then(function(response) {
			userIn = JSON.stringify(response.data);
			localStorage.setItem('userIn', userIn);
			verificaTipoUsuarioLogado(response.data, $location);
		}, function(response) {
			window.alert("Login e/ou Senha Invalidos!");
		})
	}

	var verificaTipoUsuarioLogado = function(usuario, $location) {
		if (usuario.perfil == "ADMINISTRADOR") {
			$location.path("/operadores");
		} else if (usuario.perfil == "GERENTE") {
			$location.path("/pessoas");
		} else if (usuario.perfil == "ANALISTA") {
			$location.path("/telefones");
		}
	}
});
