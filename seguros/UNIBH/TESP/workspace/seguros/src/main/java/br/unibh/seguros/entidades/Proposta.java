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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;


@Entity
@Table (name="tb_proposta")
	

public class Proposta {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date data; 
	
	@Column(columnDefinition="char(1)", nullable=true)
	private String classe; 
	
	@Column(name="codigo_susep",columnDefinition="CHAR(15)",unique=true)
	private String codigoSusep; 
	
	@Column(name="valor_segurado",columnDefinition="decimal(14,2)", nullable=false)
	private BigDecimal valorSegurado; 
	
	@Column(name="valor_franquia",columnDefinition="decimal(14,2)", nullable=false)
	private BigDecimal valorFranquia; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_incio_vigencia", nullable=false)
	private Date dataInicioVigencia; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_tramitacao_vigencia", nullable=false)
	private Date dataTerminoVigencia;
	
	@Column(name="carencia_em_meses", nullable=false)
	private int carenciaEmMeses; 
	
	@Column(name="valor_premio",columnDefinition="decimal(14,2)", nullable=false)
	private BigDecimal valorPremio;
	
	@Column(name="dia_pagamento", nullable=false)
	private int diaPagamento; 
	
	@Column(name="banco_pagamento",columnDefinition="varchar(50)", nullable=false)
	private String bancoPagamento; 
	
	@Column(columnDefinition="varchar(15)", nullable=false)
	private String agencia; 
	
	@Column(columnDefinition="varchar(15)", nullable=false)
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
	
	

}
