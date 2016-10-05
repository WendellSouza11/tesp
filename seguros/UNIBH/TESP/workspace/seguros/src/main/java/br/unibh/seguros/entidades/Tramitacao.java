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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name="tb_tramitacao")

public class Tramitacao {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	private Proposta proposta; 
	
	@Column(name="etapa_processo", nullable=false)
	@NotNull
	private EtapaProcesso EtapaProcesso; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora", nullable=true)
	@NotNull
	private Date dataHora; 
	
	@Column(name="tipo_decisao", nullable=false)
	@NotNull
	private TipoDecisao tipoDecisao;
	
	@OneToOne
	@JoinColumn(name="usario_decisao")
	private Funcionario usuarioDecisao;
	
	@Column(columnDefinition="varchar(100)", nullable=true)
	@Pattern(regexp="[A-zÀ-ú -/.1]*",message="Deve conter apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, traços (-), barra (/), ponto e aspas simples.")
	@Size(max=4000)
	private String comentario; 
	
	@Column(columnDefinition="blob", nullable=true)
	private File documento; 
	@Version
	private Long version;
	public Tramitacao(Long id, Proposta proposta, br.unibh.seguros.entidades.EtapaProcesso etapaProcesso, Date dataHora,
			TipoDecisao tipoDecisao, Funcionario usuarioDecisao, String comentario, File documento) {
		super();
		this.id = id;
		this.proposta = proposta;
		EtapaProcesso = etapaProcesso;
		this.dataHora = dataHora;
		this.tipoDecisao = tipoDecisao;
		this.usuarioDecisao = usuarioDecisao;
		this.comentario = comentario;
		this.documento = documento;
	}
	
	public Tramitacao(){
		
	}
	
}
