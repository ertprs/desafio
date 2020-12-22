package com.edson.desafio.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.edson.desafio.model.enumeration.Perfil;
import com.edson.desafio.model.util.BaseEntity;

@Entity
@Table(name = "operador")
@EntityListeners(AuditingEntityListener.class)
public class Operador extends BaseEntity {

	private static final long serialVersionUID = 569771600423809511L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * Nome do Operador
	 */
	@Column(name = "nome", nullable = false, length = 100)
	@NotNull(message = "O Nome do Operador deve ser informado!")
	@Size(max = 100, message = "O Nome não deve conter mais que 100 caracteres!")
	private String nome;

	/**
	 * Perfil do Operador
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	@NotNull(message = "O Perfil do Operador deve ser informado!")
	private Perfil perfil;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro = new Date();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
