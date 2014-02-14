package br.facom.lyricsseeker.models;

import java.util.Date;

public class Musico {

	int idMusico;
	String nomeMusico;
	Date dataNascimento;
	String nomeGenero;
	String urlFoto;
	String biografia;
	public int getIdMusico() {
		return idMusico;
	}
	public void setIdMusico(int idMusico) {
		this.idMusico = idMusico;
	}
	public String getNomeMusico() {
		return nomeMusico;
	}
	public void setNomeMusico(String nomeMusico) {
		this.nomeMusico = nomeMusico;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeGenero() {
		return nomeGenero;
	}
	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	
}
