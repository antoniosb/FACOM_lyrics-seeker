<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		</div><!--menuAdmin-->
		<br><br>
		<div class="btnadd">
			<form method = "POST" action = "Admin-addArtista.jsp">
			<input type="submit" value="Adicionar Artista" >
			</form>
		</div><!--btnaddMusica-->
		<div class="campoBusca">
			<input type="search" placeholder="Search" style="width:320px">
			<input type="submit" value="Buscar" >			
		</div><!--busca-->
	</body>
</html>