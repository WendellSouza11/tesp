package br.unibh.seguros.entidades;

import java.util.Date;

public class Segurado extends Pessoa {

	private String classe;
	private String numeroRG;
	private String orgaoExpedidorRG;
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getNumeroRG() {
		return numeroRG;
	}
	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}
	public String getOrgaoExpedidorRG() {
		return orgaoExpedidorRG;
	}
	public void setOrgaoExpedidorRG(String orgaoExpedidorRG) {
		this.orgaoExpedidorRG = orgaoExpedidorRG;
	}
	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}
	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}
	public String getTipoHabilitacao() {
		return tipoHabilitacao;
	}
	public void setTipoHabilitacao(String tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}
	public Date getDataValidadeHabilitacao() {
		return dataValidadeHabilitacao;
	}
	public void setDataValidadeHabilitacao(Date dataValidadeHabilitacao) {
		this.dataValidadeHabilitacao = dataValidadeHabilitacao;
	}
	public Date getDataPrimeiraHabilitacao() {
		return dataPrimeiraHabilitacao;
	}
	public void setDataPrimeiraHabilitacao(Date dataPrimeiraHabilitacao) {
		this.dataPrimeiraHabilitacao = dataPrimeiraHabilitacao;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	private String numeroHabilitacao;
	private String tipoHabilitacao;
	private Date dataValidadeHabilitacao;
	private Date dataPrimeiraHabilitacao;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	@Override
	public String toString() {
		return "Segurado [classe=" + classe + ", numeroRG=" + numeroRG + ", orgaoExpedidorRG=" + orgaoExpedidorRG
				+ ", numeroHabilitacao=" + numeroHabilitacao + ", tipoHabilitacao=" + tipoHabilitacao
				+ ", dataValidadeHabilitacao=" + dataValidadeHabilitacao + ", dataPrimeiraHabilitacao="
				+ dataPrimeiraHabilitacao + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", toString()=" + super.toString() + "]";
	}
	
}
