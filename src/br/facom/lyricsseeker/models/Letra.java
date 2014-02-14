package br.facom.lyricsseeker.models;

import java.util.Date;

public class Letra {
	int idLetra;
	String nomeLetra;
	int idMusico;
	String nomeGenero;
	String urlVideo;
	Date dataCriacao;
	String texto;
	
	
	public int getIdLetra() {
		return idLetra;
	}
	public void setIdLetra(int idLetra) {
		this.idLetra = idLetra;
	}
	public String getNomeLetra() {
		return nomeLetra;
	}
	public void setNomeLetra(String nomeLetra) {
		this.nomeLetra = nomeLetra;
	}
	public int getIdMusico() {
		return idMusico;
	}
	public void setIdMusico(int idMusico) {
		this.idMusico = idMusico;
	}
	public String getNomeGenero() {
		return nomeGenero;
	}
	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
