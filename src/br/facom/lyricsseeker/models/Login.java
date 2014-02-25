package br.facom.lyricsseeker.models;

import java.util.List;

import br.facom.lyricsseeker.DAO.LoginDAO;

public class Login {
	
	String usuario;
	String senha;
	boolean isAuth;
	
	public boolean isAuth() {
		return isAuth;
	}
	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
