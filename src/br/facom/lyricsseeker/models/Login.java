package br.facom.lyricsseeker.models;

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
	
	@Override
	public String toString(){
		return "Login = {usuario: "+getUsuario()+", senha: "+getSenha()+", is_auth: "+isAuth()+"}";
	}
	
}
