appUserManager.controller("pessoaController",
		function($scope, $http) {
			$scope.buttonText = "Salvar"
			$scope.pessoas = [];
			$scope.pessoa = {};

			$scope.loadAllPessoas = function() {
				$http({
					method : 'GET',
					url : 'http://localhost:8080/pessoas/all'
				}).then(function(response) {
					$scope.pessoas = response.data;
				});
			}

			$scope.loadAllPessoas();

			$scope.savePessoa = function() {
				if ($scope.pessoaForm.$valid && isEditPessoa()) {
					$scope.pessoa.operador = JSON.parse(localStorage
							.getItem('userIn'));
					$http({
						method : 'POST',
						url : 'http://localhost:8080/pessoas/save',
						data : $scope.pessoa
					}).then(function(response) {
						isNewItem = true;
						for (i = 0; i < $scope.pessoas.length; i++) {
							if (response.data.id == $scope.pessoas[i].id) {
								isNewItem = false;
								break;
							}
						}
						if (isNewItem) {
							$scope.pessoas.push(response.data);
						} else {
							for (i = 0; i < $scope.pessoas.length; i++) {
								if (response.data.id == $scope.pessoas[i].id) {
									$scope.pessoas[i] = response.data;
									break;
								}
							}
						}
						$scope.pessoa = {};
					});
					$scope.pessoaForm.$setDirty(false);
				}
				if (!isEditPessoa()) {
					window.alert("O Usuario nao e um Administrador ou Gerente!")
				} else {
					$scope.pessoaForm.$setDirty(true);
				}
			}

			function isEditPessoa() {
				operadorAutenticado = JSON
						.parse(localStorage.getItem('userIn'));
				return operadorAutenticado.perfil == "ADMINISTRADOR"
						|| operadorAutenticado.perfil == "GERENTE";
			}

			$scope.updatePessoaInit = function(pessoa) {
				$scope.pessoa = angular.copy(pessoa);
				$scope.buttonText = "Atualizar";
			}

			$scope.deletePessoa = function(pessoa) {
				$http({
					method : 'DELETE',
					url : 'http://localhost:8080/pessoas/delete/' + pessoa.id
				}).then(function(response) {
					var index = $scope.pessoas.indexOf(pessoa);
					$scope.pessoas.splice(index, 1);
				});
			}

			$scope.cancelUpdatePessoa = function() {
				$scope.pessoa = {};
			}
		})