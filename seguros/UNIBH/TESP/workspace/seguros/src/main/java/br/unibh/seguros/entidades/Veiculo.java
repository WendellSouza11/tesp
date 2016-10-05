package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table (name="tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(columnDefinition="varchar(50)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú .']*",message="A marca deverá ter apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, ponto e aspas simples.")
	@Size(max=50)
	private String marca; 
	
	@Column(columnDefinition="varchar(150)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú -/.']*",message="Deverá conter apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, traços (-), barra (/), ponto e aspas simples.")
	@Size(max=150)
	private String descricao;
	
	@Column(name="ano_fabricacao", nullable=false)
	@NotNull
	@Min(value=1950, message ="Somente ano acima de 1950")
	private int anoFabricacao; 
	
	@Column(name="ano_modelo", nullable=false)
	@NotNull
	@Min(value=1950, message ="Somente modelo acima de 1950")
	private int anoModelo; 
	
	@Column(columnDefinition="char(8)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-Z]{3}-\\d{4}",message="Padrão de placa 'AAA-9999'")
	private String placa; 
	
	@Column(columnDefinition="varchar(50)", nullable=false)
	@NotBlank
	@Pattern(regexp="[A-z{0-9}]*",message="Deverá ter apenas caracteres de A à Z maiúsculos e dígitos.")
	@Size(max=50)
	private String chassi; 
	
	@Column(name="tipo_combustivel", nullable=false)
	@NotNull
	private TipoCombustivel tipoCombustivel;
	
	@Column(name="zero_km", nullable=false)
	@NotNull
	private Boolean zeroKm; 
	
	@Column(name="veiculo_alienado", nullable=false)
	@NotNull
	private Boolean veiculoAlienado; 
	
	@Version
	private Long version;

	public Veiculo(Long id, String marca, String descricao, int anoFabricacao, int anoModelo, String placa,
			String chassi, TipoCombustivel tipoCombustivel, Boolean zeroKm, Boolean veiculoAlienado) {
		super();
		this.id = id;
		this.marca = marca;
		this.descricao = descricao;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.placa = placa;
		this.chassi = chassi;
		this.tipoCombustivel = tipoCombustivel;
		this.zeroKm = zeroKm;
		this.veiculoAlienado = veiculoAlienado;
	}
	
	public Veiculo(){
		
	}

}
