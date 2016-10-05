package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name="tb_questionario")

public class Questionario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	
	@Column(name="segurado_e_princiapal_condutor", nullable=false)
	@NotNull
	private Boolean seguradoEPrincipalCondutor; 
	
	@Column(name="nome_condutor_principal",columnDefinition="varchar(100)", nullable=true)
	@Pattern(regexp="[A-zÀ-ú .']*",message="Nome do condutor principal deverá conter apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, ponto e aspas simples.")
	@Size(max=100)
	private String nomeCondutorPrincipal; 
	
	@Column(name="reside_com_pessoa_17_a_25_anos", nullable=false)
	@NotNull
	private Boolean resideComPessoa17A25Anos; 
	
	@Column(name="possiu_garagem_residecia", nullable=false)
	@NotNull
	private Boolean possuiGaragemResidencia; 
	
	@Column(name="possiu_garagem_trabalho", nullable=false)
	@NotNull
	private Boolean possuiGaragemTrabalho; 
	
	@Column(name="possiu_garagem_estudo", nullable=false)
	@NotNull
	private Boolean possuiGaragemEstudo; 
	
	@NotNull
	@Column(name="residencia_propria", nullable=false)
	private Boolean residenciaPropria; 
	
	@Column(nullable=false)
	@NotNull
	private Long quilometragemAtual;
	
	@Column(name="utiliza_veiculo_atividades_profissionais", nullable=false)
	@NotNull
	private Boolean utilizaVeiculoAtividadesProfissionais; 
	
	@Column(name="acidente_ou_roubo_ultimos_2_anos", nullable=false)
	@NotNull
	private Boolean acidenteOuRouboUltimos2Anos; 
	
	@Column(name="possiu_dispositivo_anti_furto", nullable=false)
	@NotNull
	private Boolean possuiDispositivoAntiFurto; 
	
	@Version
	private Long version;

	public Questionario(Long id, Boolean seguradoEPrincipalCondutor, String nomeCondutorPrincipal,
			Boolean resideComPessoa17A25Anos, Boolean possuiGaragemResidencia, Boolean possuiGaragemTrabalho,
			Boolean possuiGaragemEstudo, Boolean residenciaPropria, Long quilometragemAtual,
			Boolean utilizaVeiculoAtividadesProfissionais, Boolean acidenteOuRouboUltimos2Anos,
			Boolean possuiDispositivoAntiFurto) {
		super();
		this.id = id;
		this.seguradoEPrincipalCondutor = seguradoEPrincipalCondutor;
		this.nomeCondutorPrincipal = nomeCondutorPrincipal;
		this.resideComPessoa17A25Anos = resideComPessoa17A25Anos;
		this.possuiGaragemResidencia = possuiGaragemResidencia;
		this.possuiGaragemTrabalho = possuiGaragemTrabalho;
		this.possuiGaragemEstudo = possuiGaragemEstudo;
		this.residenciaPropria = residenciaPropria;
		this.quilometragemAtual = quilometragemAtual;
		this.utilizaVeiculoAtividadesProfissionais = utilizaVeiculoAtividadesProfissionais;
		this.acidenteOuRouboUltimos2Anos = acidenteOuRouboUltimos2Anos;
		this.possuiDispositivoAntiFurto = possuiDispositivoAntiFurto;
	} 
	
	public Questionario(){
		
	}

}

