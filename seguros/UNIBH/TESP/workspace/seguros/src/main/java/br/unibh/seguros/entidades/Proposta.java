package br.unibh.seguros.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table (name="tb_proposta")

	

public class Proposta {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	@NotNull
	private Date data; 
	
	@Column(columnDefinition="char(1)", nullable=true)
	@NotBlank
	@Pattern(regexp="[A-Z]")
	@Size(max=1,min=1)
	private String classe; 
	
	@Column(name="codigo_susep",columnDefinition="CHAR(15)",unique=true)
	@NotBlank
	@Size (max=15)
	@Pattern(regexp="[A-zÀ-ú-/. ]*",message="Deverá conter apenas caracteres de A à Z maiúsculos, dígitos, traços (-), barra (/) e ponto. ")
  //@Pattern(regexp="[A-Z]{0-9}-/. *",message="Deverá conter apenas caracteres de A à Z maiúsculos, dígitos, traços (-), barra (/) e ponto. ")
	
	private String codigoSusep; 
	
	@Column(name="valor_segurado",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("0.01")
	private BigDecimal valorSegurado; 
	
	@Column(name="valor_franquia",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("0.01")  //Verificar pq não pode ser negativo
	private BigDecimal valorFranquia; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_incio_vigencia", nullable=false)
	@NotNull
	private Date dataInicioVigencia; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_tramitacao_vigencia", nullable=false)
	@NotNull
	private Date dataTerminoVigencia;
	
	@Column(name="carencia_em_meses", nullable=false)
	@NotNull
	private int carenciaEmMeses; 
	
	@Column(name="valor_premio",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("0.01")
	private BigDecimal valorPremio;
	
	@Column(name="dia_pagamento", nullable=false)
	@NotNull
	private int diaPagamento; 
	
	@Column(name="banco_pagamento",columnDefinition="varchar(50)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú .']*",message="Deverá conter apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, ponto e aspas simples.")
	@Size(max=50)
	private String bancoPagamento; 
	
	@Column(columnDefinition="varchar(15)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú-/]*",message="Deverá conter apenas caracteres de A à Z maiúsculos, dígitos, traços (-) e barra (/).")
  //@Pattern(regexp="[A-Z{0-9}-/]*",message="Deverá conter apenas caracteres de A à Z maiúsculos, dígitos, traços (-) e barra (/).")
	@Size(max=15)
	private String agencia; 
	
	@Column(columnDefinition="varchar(15)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú-/]*",message="Deverá conter apenas caracteres de A à Z maiúsculos, dígitos, traços (-) e barra (/).")
  //@Pattern(regexp="[A-Z{0-9}-/]*",message="Deverá ter apenas Letras e Espaço")
	@Size(max=15)
	private String conta; 
	
	@ManyToOne
	private Segurado segurado; 
	
	@OneToOne
	@JoinColumn(name="veiculo")
	private Veiculo veiculo; 
	
	@OneToOne
	@JoinColumn(name="questionario")
	private Questionario questionario; 
	
	@OneToMany(mappedBy="proposta")
	private Set<Tramitacao> tramitacoes; 
	
	@Version
	private Long version;

	public Proposta(Long id, Date data, String classe, String codigoSusep, BigDecimal valorSegurado,
			BigDecimal valorFranquia, Date dataInicioVigencia, Date dataTerminoVigencia, int carenciaEmMeses,
			BigDecimal valorPremio, int diaPagamento, String bancoPagamento, String agencia, String conta,
			Segurado segurado, Veiculo veiculo, Questionario questionario, Set<Tramitacao> tramitacoes) {
		super();
		this.id = id;
		this.data = data;
		this.classe = classe;
		this.codigoSusep = codigoSusep;
		this.valorSegurado = valorSegurado;
		this.valorFranquia = valorFranquia;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataTerminoVigencia = dataTerminoVigencia;
		this.carenciaEmMeses = carenciaEmMeses;
		this.valorPremio = valorPremio;
		this.diaPagamento = diaPagamento;
		this.bancoPagamento = bancoPagamento;
		this.agencia = agencia;
		this.conta = conta;
		this.segurado = segurado;
		this.veiculo = veiculo;
		this.questionario = questionario;
		this.tramitacoes = tramitacoes;
	} 
	
	public Proposta(){
		
	}

}
