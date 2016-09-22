package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table (name="tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(columnDefinition="varchar(50)", nullable=false)
	private String marca; 
	
	@Column(columnDefinition="varchar(150)", nullable=false)
	private String descricao;
	
	@Column(name="ano_fabricacao", nullable=false)
	private int anoFabricacao; 
	
	@Column(name="ano_modelo", nullable=false)
	private int anoModelo; 
	
	@Column(columnDefinition="char(8)", nullable=false)
	private String placa; 
	
	@Column(columnDefinition="varchar(50)", nullable=false)
	private String chassi; 
	
	@Column(name="tipo_combustivel", nullable=false)
	private TipoCombustivel tipoCombustivel;
	
	@Column(name="zero_km", nullable=false)
	private Boolean zeroKm; 
	
	@Column(name="veiculo_alienado", nullable=false)
	private Boolean veiculoAlienado; 
	
	@Version
	private Long version;
	

}
