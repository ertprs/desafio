angular.module('appUserManager').factory('Operador', Operador);

function Operador() {
	var perfil = "";

	return {
		setPerfil : perfil,
		isAdmin : isAdmin,
		isEditPessoa : isEditPessoa,
		isEditTelefone : isEditTelefone
	};

	function setPerfil(perfil) {
		this.perfil = perfil;
	}

	function isAdmin() {
		return this.perfil.equals("ADMINISTRADOR");
	}

	function isEditPessoa() {
		return this.perfil.equals("GERENTE");
	}

	function isEditTelefone() {
		return this.perfil.equals("ANALISTA");
	}
}