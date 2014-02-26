<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet" type="text/css" href="./css/cssEstilo.css">
<title>Lyric's Searcher</title>
<meta charset="utf-8">
<meta name="description" content="Lyric's Searcher">
<meta name="keywords" content="Lyric's Searcher">
<meta name="author" content="Grupo">
</head>
<body>
	<div class=imagemIndex>
		<img src="./images/logo.jpg" width="400" alt="Lyric's Searcher">
	</div>

	<form method="POST" action="IndexUserController">
		<div class="txtBuscar">Buscar por:</div>
		<!--txtBuscar-->
		<div class="btnradio">
			<input type="radio" name="tipo" value="musica" checked >
			Música
			<input type="radio" name="tipo" value="artista">
			Artista 
			<input type="radio" name="tipo" value="trecho">
			Trecho
		</div>
		<!--btnradio_index-->

		<div class="campoBusca">
			<input type="search" name="termoBusca" required placeholder="Searchh" style="width: 320px"><br>
			<br>
		</div>
		<!--busca-->

		<div class="btnBusca">
			<input type="submit" value="Buscar" name="searchList" > 
			<input type="submit" value="Estou com Sorte!" name="searchOne">
		</div>
		<!--btnBusca-->
	</form>
</body>
</html>