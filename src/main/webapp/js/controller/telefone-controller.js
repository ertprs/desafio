appUserManager.controller("telefoneController", function($scope, $http) {
	$scope.buttonText = "Salvar"
	$scope.telefones = [];
	$scope.telefone = {};

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

	$scope.loadAllTelefones = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/telefones/all'
		}).then(function(response) {
			$scope.telefones = response.data;
		});
	}

	$scope.loadAllTelefones();

	$scope.saveTelefone = function() {
		if ($scope.telefoneForm.$valid && isEditTelefone()) {
			$scope.telefone.pessoa = JSON.parse($scope.pessoa);
			$scope.telefone.operador = JSON.parse(localStorage
					.getItem('userIn'));
			$http({
				method : 'POST',
				url : 'http://localhost:8080/telefones/save',
				data : $scope.telefone
			}).then(function(response) {
				isNewItem = true;
				for (i = 0; i < $scope.telefones.length; i++) {
					if (response.data.id == $scope.telefones[i].id) {
						isNewItem = false;
						break;
					}
				}
				if (isNewItem) {
					$scope.telefones.push(response.data);
				} else {
					for (i = 0; i < $scope.telefones.length; i++) {
						if (response.data.id == $scope.telefones[i].id) {
							$scope.telefones[i] = response.data;
							break;
						}
					}
				}
				$scope.telefone = {};
				$scope.pessoa = {};
			});
			$scope.telefoneForm.$setDirty(false);
		}
		if (!isEditTelefone()) {
			window.alert("O Usuario nao e um Administrador ou Gerente!")
		} else {
			$scope.telefoneForm.$setDirty(true);
		}
	}

	function isEditTelefone() {
		operadorAutenticado = JSON.parse(localStorage.getItem('userIn'));
		return operadorAutenticado.perfil == "ADMINISTRADOR"
				|| operadorAutenticado.perfil == "ANALISTA";
	}

	$scope.updateTelefoneInit = function(telefone) {
		$scope.telefone = angular.copy(telefone);
		$scope.pessoa = $scope.telefone.pessoa;
		$scope.buttonText = "Atualizar";
	}

	$scope.deleteTelefone = function(telefone) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/telefones/delete/' + telefone.id
		}).then(function(response) {
			var index = $scope.telefones.indexOf(telefone);
			$scope.telefones.splice(index, 1);
		});
	}

	$scope.cancelUpdateTelefone = function() {
		$scope.telefone = {};
		$scope.pessoa = {};
	}
})