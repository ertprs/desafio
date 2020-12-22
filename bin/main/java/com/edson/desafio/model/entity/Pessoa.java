package com.edson.desafio.model.entity;

import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.edson.desafio.model.enumeration.TipoPessoa;
import com.edson.desafio.model.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pessoa")
@EntityListeners(AuditingEntityListener.class)
public class Pessoa extends BaseEntity {
	
	private static final long serialVersionUID = -2806934479016802074L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 100)
	@NotNull(message = "O Nome da Pessoa deve ser informado!")
	@Size(max = 100, message = "O Nome não pode conter mais que 100 caracteres!")
	private String nome;

	@Column(name = "codigo", nullable = false, length = 14, unique = true)
	@NotNull(message = "O CPF/CNPJ da Pessoa deve ser informado!")
	private String codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	@NotNull(message = "A Data de Nascimento da Pessoa deve ser informada!")
	private Date dataNascimento;

	@Column(name = "nome_mae", length = 100)
	@Size(max = 100, message = "O Nome da Mãe não pode ter mais que 100 caracteres")
	private String nomeMae;

	@Column(name = "nome_pai", length = 100)
	@Size(max = 100, message = "O Nome do Pai não pode ter mais que 100 caracteres")
	private String nomePai;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro = new Date();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_operador", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Operador operador;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", nullable = false)
	@NotNull(message = "O Tipo de Pessoa deve ser informado!")
	private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
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

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
