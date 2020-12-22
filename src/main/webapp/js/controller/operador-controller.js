appUserManager
		.controller(
				"operadorController",
				function($scope, $http) {
					$scope.buttonText = "Salvar"
					$scope.operadores = [];
					$scope.operador = {};
					$scope.usuario = {};

					$scope.loadAllOperadores = function() {
						operadorAutenticado = JSON.parse(localStorage
								.getItem('userIn'));
						$http.defaults.headers.common.Authorization = operadorAutenticado.usuario.token;
						$http({
							method : 'GET',
							url : 'http://localhost:8080/operadores/all'
						}).then(function(response) {
							$scope.operadores = response.data;
						});
					}

					$scope.loadAllOperadores();

					$scope.saveOperador = function() {
						if ($scope.operadorForm.$valid && isAdmin()) {
							$scope.operador.usuario = $scope.usuario;
							$http({
								method : 'POST',
								url : 'http://localhost:8080/operadores/save',
								data : $scope.operador
							})
									.then(
											function(response) {
												isNewItem = true;
												for (i = 0; i < $scope.operadores.length; i++) {
													if (response.data.id == $scope.operadores[i].id) {
														isNewItem = false;
														break;
													}
												}
												if (isNewItem) {
													$scope.operadores
															.push(response.data);
												} else {
													for (i = 0; i < $scope.operadores.length; i++) {
														if (response.data.id == $scope.operadores[i].id) {
															$scope.operadores[i] = response.data;
															break;
														}
													}
												}
												$scope.operador = {};
												$scope.usuario = {};
											});
							$scope.operadorForm.$setPristine(true);
						} else if (isAdmin != true) {
							window
									.alert("O Usuario logado nao e um Administrador!");
						} else {
							$scope.operadorForm.$setPristine(false);
						}
					}

					function isAdmin() {
						operadorAutenticado = JSON.parse(localStorage
								.getItem('userIn'));
						return operadorAutenticado.perfil == "ADMINISTRADOR";
					}

					$scope.updateOperadorInit = function(operador) {
						$scope.operador = angular.copy(operador);
						$scope.usuario = $scope.operador.usuario;
						$scope.buttonText = "Atualizar";
					}

					$scope.deleteOperador = function(operador) {
						$http(
								{
									method : 'DELETE',
									url : 'http://localhost:8080/operadores/delete/'
											+ operador.id
								}).then(function(response) {
							var index = $scope.operadores.indexOf(operador);
							$scope.operadores.splice(index, 1);
						});
					}

					$scope.cancelUpdateOperador = function() {
						$scope.operador = {};
						$scope.usuario = {};
					}

				});
