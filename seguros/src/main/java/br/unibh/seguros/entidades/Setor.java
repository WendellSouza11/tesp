package br.unibh.seguros.entidades;

import java.util.Set;

public class Setor {
	
	private Long id;
	private String nome;
	private String sigla;
	private Setor setorSuperior;
	private Set<Funcionario> funcionarios;

}

