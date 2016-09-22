package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {
	
	@ManyToOne
	private Setor setor;
	
	@Column(columnDefinition="varchar(30)", nullable=false)
	private String perfil;
	
	@Column(columnDefinition="varchar(15)", nullable=false)
	private String login;
	
	@Column(columnDefinition="varchar(100)", nullable=false)
	private String senha;
	
	
	
	public Funcionario() {
		super();
	}
	public Funcionario(Long id, String nome, String sexo, String cpf, String telefoneComercial,
			String telefoneResidencial, String telefoneCelular, String email, Date dataNascimento, Date dataCadastro,
			String perfil, String login, String senha) {
		super(id, nome, sexo, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, dataNascimento,
				dataCadastro);
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Funcionario [perfil=" + perfil + ", login=" + login + ", senha=" + senha + ", toString()="
				+ super.toString() + "]";
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
