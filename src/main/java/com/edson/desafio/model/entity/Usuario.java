package com.edson.desafio.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.edson.desafio.model.util.BaseEntity;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity {
	
	private static final long serialVersionUID = 497025313744059123L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Login do Usuário
	 */
	@Column(name = "login", nullable = false, length = 15, unique = true)
	@NotNull(message = "O Login do Operador deve ser informado!")
	@Size(max = 15, message = "O Login não deve conter mais que 15 caracteres!")
	private String login;

	/**
	 * Senha do Usuário
	 */
	@Column(name = "senha", nullable = false)
	@NotNull(message = "A Senha do Operador deve ser informada!")
	private String senha;

	/**
	 * Token de Acesso do Usuário este não é adicionado ao banco de dados
	 */
	@Transient
	private String token;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
