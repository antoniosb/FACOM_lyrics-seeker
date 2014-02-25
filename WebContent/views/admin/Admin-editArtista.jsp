<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Artista"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"%>
<%@ page import="br.facom.lyricsseeker.DAO.ArtistaDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.GeneroDAO"%>

<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
<title>Editar Artista</title>
<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
<meta charset="utf-8">
<meta name="description" content="Editar Artista">
<meta name="keywords" content="Editar Artista">
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
	</div>
	<!--menuAdmin-->
	<br>
	<br>
	<div class="btnadd">
		<a href="editArtista?action=add"> Adicionar Artista</a>
	</div>
	<!--btnaddMusica-->
	<div class="campoBusca">
		<form method="POST" action="AdminEditArtistaController">
			<input type="text" name="search" placeholder="Search" style="width: 320px">
			<input type="hidden" name="flag" value="search">
			<input type="submit" value="Buscar">
		</form>
	</div>
	<!--busca-->
	
		<div id="allItems">
		<%
			List<Artista> artistas = (List<Artista>) session.getAttribute("artistas");
		%>
		<%
			for (Artista each : artistas) {
				Genero genero = GeneroDAO.getOneById(each.getIdGenero());
		%>
		<div class="genero-item">
			<ul>
				<li>ID: <%=each.getIdArtista() %>
				</li>
				<li>Nome: <%=each.getNomeArtista()%>
				</li>
				<li>Data de Nascimento: <%= ArtistaDAO.PATTERN.format(each.getDataNascimento()) %>
				</li>
				<li>Genero: <%= genero.getNomeGenero() %>
				</li>
				<li>Biografia: <%=each.getBiografia()%>
				</li>
			</ul>
			<div class="genero-item">
			<img alt="foto do artista" src="<%=each.getUrlFoto() %>">
			</div>
			
			<a href="editArtista?action=edit&id_artista=<%=each.getIdArtista()%>" > Editar</a>
			<a href="editArtista?action=delete&id_artista=<%=each.getIdArtista()%>" > Excluir</a>
		</div>

		<%
			}
		%>

	</div>
	
</body>
</html>