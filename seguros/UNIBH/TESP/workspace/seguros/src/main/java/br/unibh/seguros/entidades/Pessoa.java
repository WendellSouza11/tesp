package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


@Entity @Inheritance(strategy=InheritanceType.JOINED) /*@Entity= torna a classe persitente*/
@Table(name = "tb_pessoa", uniqueConstraints = @UniqueConstraint(columnNames="CPF"))/*@Table= define o nome da tabela no banco*/

public abstract class Pessoa {

	public Pessoa (){}
	
	public Pessoa(Long id, String nome, String sexo, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, Date dataNascimento, Date dataCadastro) {
		super();
	
	/*This � usado para fazer auto-refer�ncia ao pr�prio contexto em que se encontra. 
	 * Resumidamente, this sempre ser� a pr�pria classe ou o objeto j� instanciado.	*/
	    this.id = id;
	    
	    
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefoneComercial = telefoneComercial;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}
	
	
	@Id /*primary key. When a primary key field is defined the primary key value is automatically injected into that field by ObjectDB.*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)   /*The @GeneratedValue annotation specifies that the primary key is automatically allocated by ObjectDB.*/
	private Long id;
	
	@Column(columnDefinition="varchar(100)", nullable=false)
	@NotBlank
	@Size(min = 3, max = 100)
	@Pattern(regexp="[A-z�-� .']*",message="O nome dever� ter apenas Letras e Espa�o")
	private String nome;
	
	@Column(columnDefinition="char(1)", nullable=false)
	@NotBlank
	@Pattern(regexp="[MF]{1}", message="Sexo deve ter apenas M ou F")
	private String sexo;
	
	@Column(columnDefinition="char(11)", nullable=false, unique=true) //@Column(unique = true) is a shortcut to UniqueConstraint when it is only a single field.
	//@Pattern(regexp = "\\d{11}" , message = "CPF Dever� conter onze n�meros.")
	@NotBlank
	@CPF
	private String cpf;

	@Column(name="telefone_comercial",columnDefinition="char(14)", nullable=true)
	@Pattern(regexp = "\\(\\d{2}\\)\\d{4}-\\d{4}" , message = "Telefone Comercial Deve seguir o padr�o (99)099999999")
	private String telefoneComercial;
	
	@Column(name="telefone_residencial",columnDefinition="char(14)", nullable=false)
	@NotBlank
	@Pattern(regexp = "\\(\\d{2}\\)\\d{4}-\\d{4}" , message = "Telefone Residencial Deve seguir o padr�o (99)09999-9999")
	private String telefoneResidencial;
	
	@Column(name="telefone_celular",columnDefinition="char(14)", nullable=true)
	@Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}" , message = "Telefone Celular Deve seguir o padr�o (99)09999-9999")
	private String telefoneCelular;
	
	@Email
	@Size(max=100)
	//@Column(name = "email", length=50, columnDefinition="varchar(100)", nullable=true)
	private String email;
	
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento",columnDefinition="char(14)", nullable=false)
	@NotNull
	private Date dataNascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=true)
	@NotNull
	private Date dataCadastro;
	
	
	@Version //Toda vez que um novo registro for inserido no banco de dados, o valor dessa coluna anotada com @Version ser� incrementado por 1 (um).
	private long version;
	
	
	
	
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", telefoneComercial="
				+ telefoneComercial + ", telefoneResidencial=" + telefoneResidencial + ", telefoneCelular="
				+ telefoneCelular + ", email=" + email + ", dataNascimento=" + dataNascimento + ", dataCadastro="
				+ dataCadastro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
		result = prime * result + ((telefoneComercial == null) ? 0 : telefoneComercial.hashCode());
		result = prime * result + ((telefoneResidencial == null) ? 0 : telefoneResidencial.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
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
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null)
				return false;
		} else if (!telefoneCelular.equals(other.telefoneCelular))
			return false;
		if (telefoneComercial == null) {
			if (other.telefoneComercial != null)
				return false;
		} else if (!telefoneComercial.equals(other.telefoneComercial))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		return true;
	}
}
