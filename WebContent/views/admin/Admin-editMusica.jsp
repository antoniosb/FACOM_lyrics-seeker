<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Artista"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"%>
<%@ page import="br.facom.lyricsseeker.DAO.ArtistaDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.GeneroDAO"%>
<%@ page import="br.facom.lyricsseeker.models.Musica"%>
<%@ page import="br.facom.lyricsseeker.DAO.MusicaDAO"%>

<%@ page import="java.util.List"%>	
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
<title>Editar Música</title>
<meta charset="utf-8">
<meta name="description" content="Editar Música">
<meta name="keywords" content="Editar Música">
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
		<a href="editMusica?action=add"> Adicionar Musica</a>
	</div>
	<!--btnaddMusica-->
	<div class="campoBusca">
		<form method="POST" action="AdminEditMusicaController">
			<input type="text" name="search" placeholder="Search" style="width: 320px">
			<input type="hidden" name="flag" value="search">
			<input type="submit" value="Buscar">
		</form>
	</div>
	<!--busca-->
	
		<div id="allItems">
		<%
			List<Musica> musicas = (List<Musica>) session.getAttribute("musicas");
		%>
		<%
			for (Musica each : musicas) {
				Genero genero = GeneroDAO.getOneById(each.getIdGenero());
				Artista artista = ArtistaDAO.getOneById(each.getIdArtista());
				String urlVideo = MusicaDAO.getYoutubeVideoId(each.getUrlVideo());
				
		%>
		<div class="genero-item">
			<ul>
				<li>ID: <%=each.getIdMusica() %>
				</li>
				<li>Nome: <%=each.getNomeMusica()%>
				</li>
				<li>Artista: <%= artista.getNomeArtista() %>
				</li>
				<li>Data de Criação: <%= MusicaDAO.PATTERN.format(each.getDataCriacao()) %>
				</li>
				<li>Genero: <%= genero.getNomeGenero() %>
				</li>
				<li>Letra: <%=each.getLetra()%>
				</li>
				<li>Link pro video: <%= each.getUrlVideo() %>
				</li>
			</ul>
			<div class="genero-item">
<%-- 			<a target="_blank" href="<%=each.getUrlVideo() %>">Link to Video</a> --%>
				<iframe width="400" height="300" src="//www.youtube.com/embed/<%= urlVideo %>" 
				frameborder="0" allowfullscreen></iframe>
			</div>
			
			<a href="editMusica?action=edit&id_musica=<%=each.getIdMusica()%>" > Editar</a>
			<a href="editMusica?action=delete&id_musica=<%=each.getIdMusica()%>" > Excluir</a>
		</div>

		<%
			}
		%>

	</div>
</body>
</html>