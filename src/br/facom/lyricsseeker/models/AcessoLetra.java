package br.facom.lyricsseeker.models;

import java.util.Date;

public class AcessoLetra {

	int idLetra;
	int numeroVisitas;
	Date ultimaVisita;

	public int getIdLetra() {
		return idLetra;
	}

	public void setIdLetra(int idLetra) {
		this.idLetra = idLetra;
	}

	public int getNumeroVisitas() {
		return numeroVisitas;
	}

	public void setNumeroVisitas(int numeroVisitas) {
		this.numeroVisitas = numeroVisitas;
	}

	public Date getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

}
