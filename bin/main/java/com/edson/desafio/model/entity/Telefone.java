package com.edson.desafio.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.edson.desafio.model.enumeration.TipoTelefone;
import com.edson.desafio.model.util.BaseEntity;

@Entity
@Table(name = "telefone")
public class Telefone extends BaseEntity {

	private static final long serialVersionUID = 4043964502237686345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "ddd", nullable = false, length = 3)
	@NotNull(message = "O DDD deve ser informado!")
	private Integer ddd;

	@Column(name = "numero", nullable = false, length = 10)
	@NotNull(message = "O Número deve ser informado!")
	private Integer numero;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone", nullable = false, length = 30)
	private TipoTelefone tipoTelefone;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro = new Date();

	@ManyToOne
	@JoinColumn(name = "id_operador", referencedColumnName = "id", nullable = false)
	private Operador operador;

	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
