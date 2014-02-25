package br.facom.lyricsseeker.models;

public class Genero {

	String nomeGenero;
	String descricao;

	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return "Genero = {nome: "+getNomeGenero()+", descricao: "+getDescricao()+"}";
	}
	

}
