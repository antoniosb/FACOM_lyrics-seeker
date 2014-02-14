<%@page import="br.facom.lyricsseeker.models.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
<title>Editar MÃºsica</title>
<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
<meta charset="utf-8">
<meta name="description" content="Editar Música">
<meta name="keywords" content="Editar Música">
<meta name="author" content="Grupo">
</head>
<body>
	<div class="menuAdmin">
		<nav id="menu">
			<ul>
				<li><a href="Admin-editMusica.jsp">MÃºsica</a></li>
				<li><a href="Admin-editArtista.jsp">Artista</a></li>
				<li><a href="Admin-editGenero.jsp">GÃªnero</a></li>
				<li><a href="indexAdmin.jsp">Sair</a></li>
			</ul>
		</nav>
	</div>
	<!--menuAdmin-->
	<br>
	<br>
	<div class="btnadd">
		<form method="POST" action="Admin-addMusica.jsp">
			<input type="submit" value="Adicionar Música">
		</form>
	</div>
	<!--btnaddMusica-->
	<div class="campoBusca">
		<input type="search" placeholder="Search" style="width: 320px">
		<input type="submit" value="Buscar">
	</div>
	<!--busca-->

	<div>
		DADOS DO LOGIN:
		<% Login l = (Login)session.getAttribute("login"); %>
		Usuario: <%= l.getUsuario() %>
		Senha: <%= l.getSenha() %>

	</div>
</body>
</html>