<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.facom.lyricsseeker.models.Genero"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
<title>Editar Gênero</title>
<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
<meta charset="utf-8">
<meta name="description" content="Editar Gênero">
<meta name="keywords" content="Editar Gênero">
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
		<a href="editGenero?action=add"> Adicionar Gênero</a>
	</div>
	<!--btnaddMusica-->
	<div class="campoBusca">
		<form method="POST" action="AdminEditGeneroController">
			<input type="text" name="search" placeholder="Search" style="width: 320px">
			<input type="hidden" name="flag" value="search">
			<input type="submit" value="Buscar">
		</form>
	</div>
	<!--busca-->

	<div id="allItems">
		<%
			List<Genero> generos = (List<Genero>) session.getAttribute("generos");
		%>
		<%
			for (Genero each : generos) {
				
		%>
		<div class="genero-item">
			<ul>
				<li>ID: <%= each.getId() %>
				</li>
				<li>Nome: <%=each.getNomeGenero()%>
				</li>
				<li>Descrição: <%=each.getDescricao()%>
				</li>
			</ul>
			<a href="editGenero?action=edit&nomeGenero=<%=each.getNomeGenero()%>" > Editar</a>
			<a href="editGenero?action=delete&nomeGenero=<%=each.getNomeGenero()%>" > Excluir</a>
		</div>

		<%
			}
		%>

	</div>

</body>
</html>