<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Artista"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"%>
<%@ page import="br.facom.lyricsseeker.models.Musica"%>
<%@ page import="br.facom.lyricsseeker.DAO.ArtistaDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.GeneroDAO"%>
<%@ page import="br.facom.lyricsseeker.DAO.MusicaDAO"%>
<%@ page import="java.util.List"%>
		
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
		<title>Adicionar Música</title>
		<meta charset="utf-8">
		<meta name="description" content="Adicionar Música">
		<meta name="keywords" content="Adicionar Música">
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
			Musica m = (Musica) session.getAttribute("musica");
			GeneroDAO gDao = new GeneroDAO();
			ArtistaDAO aDAO = new ArtistaDAO();
			List<Genero> generos = gDao.getAll();
			List<Artista> artistas = aDAO.getAll();
			
			String selected = "";
			
			String id_musica = "";
			String nomeMusica = "";
			int id_artista = -1;
			int id_genero = -1;
			String urlVideo = "";
			String dataCriacao = "";
			String letra = "";
			if(m != null){
				
				id_musica = String.valueOf(m.getIdMusica());
				nomeMusica = m.getNomeMusica();
				id_artista = m.getIdArtista();
				id_genero = m.getIdGenero();
				urlVideo = m.getUrlVideo();
				dataCriacao = MusicaDAO.PATTERN.format(m.getDataCriacao());
				letra = m.getLetra();
			}
		%>
		
		<div class="formMusica">
			<form method = "POST" action = "AdminEditMusicaController">
				<p>ID: <input type="text" readonly name="id_musica" value="<%= id_musica %>"style="width:295px; font-family:arial"></p>
				
				<p>ID Artista: <input type="text" readonly value="<%= id_artista %>"style="width:295px; font-family:arial"></p>
				
				<p>ID Genero: <input type="text" readonly value="<%= id_genero %>"style="width:295px; font-family:arial"></p>
				
				Artista: 
				<select name="id_artista" >
					<%for(Artista each: artistas){ 
						if(each.getIdArtista()== id_artista){
						%>
							<option value="<%= each.getIdArtista()%>" selected> <%=each.getNomeArtista() %></option>
						<%
						}else{
						%>
							<option value="<%= each.getIdArtista()%>"> <%=each.getNomeArtista() %></option>
						<%
						}
						%>
						
					<% } %>
				</select>
				
				Genero:
				<select name="id_genero" >
					<%for(Genero each: generos){ 
						if(each.getId()== id_genero){
						%>
							<option value="<%= each.getId()%>" selected> <%=each.getNomeGenero() %></option>
						<%
						}else{
						%>
							<option value="<%= each.getId()%>"> <%=each.getNomeGenero() %></option>
						<%
						}
						%>
						
					<% } %>
				</select>
				
				<p>Nome: <input type="text" name="nomeMusica" value="<%= nomeMusica %>" style="width:295px; font-family:arial"></p>
				<p>Data de Criação: <input type="date" name="dataCriacao" value="<%= dataCriacao %>" placeholder="YYYY-MM-DD HH:MM:SS.SSS" style="width:300px; font-family:arial"></p>
				<br><br><br><br>
				<p>Url Video: <input type="text" name="urlVideo" value="<%= urlVideo %>" placeholder="http://" style="width:295px; font-family:arial"></p>
				<p>Letra: <textarea name="letra" rows="20" cols="40"> <%= letra %> </textarea></p>
				<input type="hidden" name="flag" value="add">
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formMusica-->
	</body>
</html>