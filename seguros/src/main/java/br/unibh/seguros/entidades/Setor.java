package br.unibh.seguros.entidades;

import java.util.Set;

public class Setor {
	
	private Long id;
	private String nome;
	private String sigla;
	private Setor setorSuperior;
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
	private Set<Funcionario> funcionarios;

}

