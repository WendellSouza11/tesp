package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name="tb_questionario")

public class Questionario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	
	@Column(name="segurado_e_princiapal_condutor", nullable=false)
	private Boolean seguradoEPrincipalCondutor; 
	
	@Column(name="nome_condutor_principal",columnDefinition="varchar(100)", nullable=true)
	private String nomeCondutorPrincipal; 
	
	@Column(name="reside_com_pessoa_17_a_25_anos", nullable=false)
	private Boolean resideComPessoa17A25Anos; 
	
	@Column(name="possiu_garagem_residecia", nullable=false)
	private Boolean possuiGaragemResidencia; 
	
	@Column(name="possiu_garagem_trabalho", nullable=false)
	private Boolean possuiGaragemTrabalho; 
	
	@Column(name="possiu_garagem_estudo", nullable=false)
	private Boolean possuiGaragemEstudo; 
	
	@Column(name="residencia_propria", nullable=false)
	private Boolean residenciaPropria; 
	
	@Column(nullable=false)
	private Long quilometragemAtual;
	
	@Column(name="utiliza_veiculo_atividades_profissionais", nullable=false)
	private Boolean utilizaVeiculoAtividadesProfissionais; 
	
	@Column(name="acidente_ou_roubo_ultimos_2_anos", nullable=false)
	private Boolean acidenteOuRouboUltimos2Anos; 
	
	@Column(name="possiu_dispositivo_anti_furto", nullable=false)
	private Boolean possuiDispositivoAntiFurto; 
	
	@Version
	private Long version; 
	

}

