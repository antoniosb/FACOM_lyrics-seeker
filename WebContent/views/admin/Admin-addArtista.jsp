<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
		<title>Adicionar Artista</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
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
		<div class="formArtista">
			<form method = "POST" action = "Admin-editArtista.jsp">
				<p>Nome: <input type="text" name="nome" style="width:295px; font-family:arial"></p>
				<p>Data: <input type="date" name="data" style="width:300px; font-family:arial"></p>
				<p>Gênero:</p>
				<br><br><br><br>
				<p>Foto: <input type="file" name="foto" style="width:300px; font-family:arial"></p>
				<p>Letra: <textarea name="letra" rows="20" cols="40"></textarea></p>
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formArtista-->
	</body>
</html>