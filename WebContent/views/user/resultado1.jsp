<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="br.facom.lyricsseeker.models.Artista"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"%>
<%@ page import="br.facom.lyricsseeker.models.Musica"%>
<%@ page import="br.facom.lyricsseeker.DAO.ArtistaDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.GeneroDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.MusicaDAO"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssEstilo.css">
<title>Resultado da Busca</title>
<meta charset="utf-8">
<meta name="description" content="Resultado da Busca">
<meta name="keywords" content="Resultado da Busca">
<meta name="author" content="Grupo">
</head>
<body>
	<form method="POST" action="IndexUserController">
		<div class="backResult1">
			<div class=imagemTop>
				<a href="/lyrics-seeker/"> <img src="./images/logoCinza.jpg"
					width="150" alt="Lyric's Searcher">
				</a>
			</div>

			<div class="txtTopPage">Buscar por:</div>
			<!--txtTopPage-->
			<div class="radioTopPage">
				<input type="radio" name="tipo" value="musica" checked>
				Música <input type="radio" name="tipo" value="artista">
				Artista <input type="radio" name="tipo" value="trecho">
				Trecho
			</div>
			<!--radioTopPage-->
			<div class="buscaTopPage">
				<input type="search" required name="termoBusca" placeholder="Search"
					style="width: 320px; font-family: arial; font-size: 15px">
				<input type="submit" name="searchList" value="Buscar"
					style="font-family: arial"> <input type="submit"
					name="searchOne" value="Estou com Sorte!">
			</div>
			<!--buscaTopPage-->
		</div>
	</form>
	<!--backResult1-->
	<div class="menuTop">
		<nav id="menu">
			<ul>
				<li><a href="#">Cantores A-Z</a></li>
				<li><a href="#">Gêneros</a></li>
				<li><a href="#">Top 10 Cantores</a></li>
				<li><a href="#">Top 10 Músicas</a></li>
				<li><a href="#">Novas Músicas</a></li>
			</ul>
		</nav>
	</div>
	<!--menuTop-->

	<div id="allItems">

		<%
			if (session.getAttribute("musica") != null) {
				Musica m = (Musica) session.getAttribute("musica");
				Genero g = GeneroDAO.getOneById(m.getIdGenero());
				Artista a = ArtistaDAO.getOneById(m.getIdArtista());
				String urlVideo = MusicaDAO.getYoutubeVideoId(m.getUrlVideo());
		%>
		<div class="result-item">
			<h2>
				<%=m.getNomeMusica()%>
			</h2>
			<br />
			<h3>
				<%=a.getNomeArtista()%>
				|||
				<%=g.getNomeGenero()%></h3>
			<br />
			<p>
				Letra:
				<textarea readonly rows="5" cols="60"> <%=m.getLetra()%> </textarea>
			</p>
			<br /> <br />
			<iframe width="400" height="300"
				src="//www.youtube.com/embed/<%=urlVideo%>" frameborder="0"
				allowfullscreen></iframe>

		</div>
		<%
			} else if (session.getAttribute("artista") != null) {
				Artista a = (Artista) session.getAttribute("artista");
				Genero g = GeneroDAO.getOneById(a.getIdGenero());
		%>

		<div class="result-item">
			<h2>
				<%=a.getNomeArtista()%>
				|||
				<%=g.getNomeGenero()%></h2>
			<br />
			<h5>
				<%=a.getDataNascimento()%></h5>
			<br /> <img alt="foto do artista" src="<%=a.getUrlFoto()%>"
				width="400" height="300"> <br /> <br />
			<textarea rows="5" cols="60" readonly> <%=a.getBiografia()%> </textarea>

		</div>

		<%
			} else if (session.getAttribute("musicas") != null
					&& ((List<Musica>) session.getAttribute("musicas")).size() > 0) {
				for (Musica m : ((List<Musica>) session.getAttribute("musicas"))) {
					Genero g = GeneroDAO.getOneById(m.getIdGenero());
					Artista a = ArtistaDAO.getOneById(m.getIdArtista());
					String urlVideo = MusicaDAO.getYoutubeVideoId(m
							.getUrlVideo());
		%>
		<div class="result-item">
			<h2>
				<%=m.getNomeMusica()%>
			</h2>
			<br />
			<h3>
				<%=a.getNomeArtista()%>
				|||
				<%=g.getNomeGenero()%></h3>
			<br />
			<p>
				Letra:
				<textarea readonly rows="5" cols="60"> <%=m.getLetra()%> </textarea>
			</p>
			<br /> <br />
			<iframe width="400" height="300"
				src="//www.youtube.com/embed/<%=urlVideo%>" frameborder="0"
				allowfullscreen></iframe>

		</div>

		<%
			}
			} else if (session.getAttribute("artistas") != null
					&& ((List<Artista>) session.getAttribute("artistas"))
							.size() > 0) {
				for (Artista a : ((List<Artista>) session
						.getAttribute("artistas"))) {
					Genero g = GeneroDAO.getOneById(a.getIdGenero());
		%>
		<div class="result-item">
			<h2>
				<%=a.getNomeArtista()%>
				|||
				<%=g.getNomeGenero()%></h2>
			<br />
			<h5>
				<%=a.getDataNascimento()%></h5>
			<br /> <img alt="foto do artista" src="<%=a.getUrlFoto()%>"
				width="400" height="300"> <br /> <br />
			<textarea rows="5" cols="60" readonly> <%=a.getBiografia()%> </textarea>

		</div>

		<%
			}
			} else {
		%>
		<div class="resukt-item">Nenhum resultado encontrado !</div>
		<%
			}
		%>

	</div>
















</body>
</html>