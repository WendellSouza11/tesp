package br.unibh.seguros.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;



@Entity 
@Table(name = "tb_setor", uniqueConstraints = @UniqueConstraint(columnNames="sigla"))
public class Setor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	  
	@Column(columnDefinition="varchar(150)", nullable=false) // nullable=false é a forma como o JPA define o notnull
	@NotBlank  //considera espaços 
	@Size(min = 3, max = 150)
	@Pattern(regexp="[A-zÀ-ú .']*",message="Apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, ponto e aspas simples.")
    private String nome;
	
	
	@NotBlank
	@Size(min = 2, max = 10)
	@Pattern(regexp = "[A-Z]*", message = "Deve conter apenas caracteres de A a Z maiúsculos sem espaço")
	private String sigla;
	
	@OneToOne
	@JoinColumn(name="setor_superior")
	private Setor setorSuperior;
	
	@OneToMany(mappedBy="setor")
	private Set<Funcionario> funcionarios;
	
	@Version
	private long version;
	
	public Setor() {
		super();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Setor getSetorSuperior() {
		return setorSuperior;
	}
	public void setSetorSuperior(Setor setorSuperior) {
		this.setorSuperior = setorSuperior;
	}
	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}



	public Setor(Long id, String nome, String sigla, Setor setorSuperior, Set<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.setorSuperior = setorSuperior;
		this.funcionarios = funcionarios;
	}
	
	
	


}
