<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"  %>
<%@ page import="br.facom.lyricsseeker.models.Artista"  %>
<%@ page import="br.facom.lyricsseeker.DAO.ArtistaDAO"  %>
<%@ page import="br.facom.lyricsseeker.DAO.GeneroDAO"  %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
		<title>Adicionar Artista</title>
		<meta charset="utf-8">
		<meta name="description" content="Adicionar Artista">
		<meta name="keywords" content="Adicionar Artista">
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
			Artista a = (Artista) session.getAttribute("artista");
			GeneroDAO dao = new GeneroDAO();
			List<Genero> generos = dao.getAll();
			String selected = "";
			String id_artista = "";
			String nomeArtista = "";
			String dataNascimento = "";
			int id_genero = -1;
			String urlFoto = "";
			String biografia = "";
			if(a != null){
				id_artista = String.valueOf(a.getIdArtista());
				nomeArtista = a.getNomeArtista();
				dataNascimento = ArtistaDAO.PATTERN.format(a.getDataNascimento());
				id_genero = a.getIdGenero();
				urlFoto = a.getUrlFoto();
				biografia = a.getBiografia();
			}
		%>
		
		<div class="formArtista">
			<form method = "POST" action = "AdminEditArtistaController">
				<p>ID: <input type="text" readonly name="id_artista" value="<%= id_artista %>"style="width:295px; font-family:arial"></p>
				
				<p>ID Genero: <input type="text" readonly value="<%= id_genero %>"style="width:295px; font-family:arial"></p>
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
				
				<p>Nome: <input type="text" name="nomeArtista" value="<%= nomeArtista %>" style="width:295px; font-family:arial"></p>
				<p>Data de Nascimento: <input type="date" name="dataNascimento" value="<%= dataNascimento %>" placeholder="YYYY-MM-DD HH:MM:SS.SSS" style="width:300px; font-family:arial"></p>
				<br><br><br><br>
				<p>Url Foto: <input type="text" name="urlFoto" value="<%= urlFoto %>" placeholder="http://" style="width:295px; font-family:arial"></p>
				<p>Biografia: <textarea name="biografia" rows="20" cols="40"> <%= biografia %> </textarea></p>
				<input type="hidden" name="flag" value="add">
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formArtista-->
	</body>
</html>