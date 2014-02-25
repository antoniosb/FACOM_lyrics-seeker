<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"  %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
		<title>Adicionar GÃªnero</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Adicionar Gênero">
		<meta name="keywords" content="Adicionar Gênero">
		<meta name="author" content="Grupo">
	</head>
	<body>
		<div class="menuAdmin">
			<nav id="menu">
			<ul>
				<li><a href="editMusica">Música</a></li>
				<li><a href="editArtista">Artista</a></li>
				<li><a href="editGenero">Gênero</a></li>
				<li><a href="admin">Sair</a></li>
			</ul>
			</nav>
		</div><!--menuAdmin-->
		<br><br>
		<%
			Genero g = (Genero) session.getAttribute("genero");
			String nome = "";
			String desc = "";
			if(g != null){
				nome = g.getNomeGenero();
				desc = g.getDescricao();
			}
		%>
		<div class="formGenero">
			<form method = "POST" action = "AdminEditGeneroController">
				<p>Gênero: <input type="text" name="nomeGenero" style="width:300px; font-family:arial" value="<%= nome %>" ></p>
				<p>Letra: <textarea name="descricaoGenero" rows="20" cols="40"> <%= desc %> </textarea></p>
				<input type="hidden" name="flag" value="add">
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formArtista-->
	</body>
</html>