package br.unibh.seguros.entidades;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table (name="tb_tramitacao")

public class Tramitacao {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	private Proposta proposta; 
	
	@Column(name="etapa_processo", nullable=false)
	private EtapaProcesso EtapaProcesso; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora", nullable=true)
	private Date dataHora; 
	
	@Column(name="tipo_decisao", nullable=false)
	private TipoDecisao tipoDecisao;
	
	@OneToOne
	@JoinColumn(name="usario_decisao")
	private Funcionario usuarioDecisao;
	
	@Column(columnDefinition="varchar(100)", nullable=true)
	private String comentario; 
	
	@Column(columnDefinition="blob", nullable=true)
	private File documento; 
	@Version
	private Long version;
	
	
	
}
